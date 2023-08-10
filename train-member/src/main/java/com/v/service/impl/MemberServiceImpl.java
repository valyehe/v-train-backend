package com.v.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.v.mapper.MemberMapper;
import com.v.model.domain.Member;
import com.v.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Admin
 * @description 针对表【member(会员)】的数据库操作Service实现
 * @createDate 2023-08-10 20:48:36
 */
@Service
@Transactional
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Resource
    MemberMapper memberMapper;

    public long register(String mobile) {
        //查找是否存在
        LambdaQueryWrapper<Member> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Member::getMobile, mobile);
        List<Member> list = memberMapper.selectList(wrapper);
        if (!CollUtil.isEmpty(list)) {
            return 0;
        }
        //创建对象
        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);
        //插入对象
        int result = memberMapper.insert(member);
        if (result != 0) {
            return member.getId();
        }
        return 0;
    }

}




