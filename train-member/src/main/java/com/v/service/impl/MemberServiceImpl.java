package com.v.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.v.common.ErrorCode;
import com.v.exception.BusinessException;
import com.v.manager.redis.VerifyCodeManager;
import com.v.mapper.MemberMapper;
import com.v.model.domain.Member;
import com.v.model.dto.memberRequest.memberLoginRequest;
import com.v.model.dto.memberRequest.memberSendCodeRequest;
import com.v.service.MemberService;
import com.v.uitl.SnowUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author Admin
 * description 针对表【member(会员)】的数据库操作Service实现
 * createDate 2023-08-10 20:48:36
 */
@Service
@Slf4j
@Transactional
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Resource
    MemberMapper memberMapper;

    @Resource
    VerifyCodeManager verifyCodeManager;

    //注册/登录接口实现
    public long login(memberLoginRequest request) {
        if (request == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        //获取数据
        String mobile = request.getMobile();
        String code = request.getCode();
        //强校验
        if (mobile == null || mobile.length() != 11) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        if (code == null || code.length() != 4) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //查找是否存在
        LambdaQueryWrapper<Member> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Member::getMobile, request.getMobile());
        Member memberDb = memberMapper.selectOne(wrapper);
        if (ObjectUtil.isEmpty(memberDb)) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "手机号未注册");
        }
        //校验验证码
        boolean codeOk = verifyCodeManager.VerifyCodeOk(code, mobile);
        if (!codeOk) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "验证码错误");
        }
        return memberDb.getId();
    }

    //发送验证码接口实现
    public boolean sendCode(memberSendCodeRequest request) {
        if (request == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        //获取数据
        String mobile = request.getMobile();
        //强校验
        if (mobile == null || mobile.length() != 11) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //查找是否存在
        LambdaQueryWrapper<Member> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Member::getMobile, request.getMobile());
        Member memberDb = memberMapper.selectOne(wrapper);
        if (ObjectUtil.isEmpty(memberDb)) {
            log.info("未注册手机号" + mobile);
            //创建对象
            Member member = new Member();
            //雪花算法生成id
            member.setId(SnowUtil.getSnowflakeNextId());
            member.setMobile(request.getMobile());
            //插入对象
            int result = memberMapper.insert(member);
            if (result != 1) {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR);
            }
        }
        //创建验证码,存入redis
        String code = verifyCodeManager.genVerifyCode(mobile);
        log.info("验证码" + code);
        return !code.isEmpty();
    }

}




