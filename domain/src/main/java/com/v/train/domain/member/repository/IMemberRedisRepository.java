package com.v.train.domain.member.repository;

public interface IMemberRedisRepository {

    //发送验证码
    Boolean sendCheckCodeByMobile(String mobile);

    //校验验证码
    Boolean compareCheckCodeByMobile(String mobile, String checkCode);

}
