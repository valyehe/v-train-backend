package com.v.train.domain.member.repository;


import com.v.train.domain.member.model.entity.MemberEntity;

/**
 * 会员 服务层。
 */
public interface IMemberRepository {

    //查询，若未注册，则注册并返回
    MemberEntity queryOrRegisterMemberByMobile(String mobile);


}