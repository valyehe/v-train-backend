package com.v.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.v.common.ErrorCode;
import com.v.exception.BusinessException;
import com.v.mapper.MemberMapper;
import com.v.model.domain.Member;
import com.v.model.dto.memberRequest.memberRegisterRequest;
import com.v.service.MemberService;
import com.v.uitl.SnowUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author Admin
 * description 针对表【member(会员)】的数据库操作Service实现
 * createDate 2023-08-10 20:48:36
 */
@Service
@Transactional
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Resource
    MemberMapper memberMapper;

    //注册接口实现
    public long register(memberRegisterRequest request) {
        //获取数据
        String mobile = request.getMobile();
        //强校验
        if (mobile == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        if (mobile.length() != 11) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //查找是否存在
        LambdaQueryWrapper<Member> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Member::getMobile, request.getMobile());
        List<Member> list = memberMapper.selectList(wrapper);
        if (!CollUtil.isEmpty(list)) {
            throw new BusinessException(ErrorCode.NOT_UNIQUE_MOBILE);
        }
        //创建对象
        Member member = new Member();
        //雪花算法生成id
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(request.getMobile());
        //插入对象
        int result = memberMapper.insert(member);
        if (result == 0) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return member.getId();
    }

}




