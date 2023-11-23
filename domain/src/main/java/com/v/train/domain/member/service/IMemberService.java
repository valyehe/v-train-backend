package com.v.train.domain.member.service;

import com.v.train.domain.member.model.entity.MemberEntity;
import com.v.train.domain.member.model.entity.MemberLoginEntity;

public interface IMemberService {

    //会员登录
    MemberEntity memberLogin(MemberLoginEntity memberLogin);

    //发送验证码
    Boolean sendCodeByMobile(MemberLoginEntity memberLogin);

}
