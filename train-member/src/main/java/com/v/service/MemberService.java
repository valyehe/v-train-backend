package com.v.service;

import com.v.model.domain.Member;
import com.baomidou.mybatisplus.extension.service.IService;
import com.v.model.dto.memberRequest.memberLoginRequest;
import com.v.model.dto.memberRequest.memberSendCodeRequest;
import com.v.model.vo.member.memberVo;

/**
 * @author Admin
 * description 针对表【member(会员)】的数据库操作Service
 * createDate 2023-08-10 20:48:36
 */
public interface MemberService extends IService<Member> {

    //注册接口
    memberVo login(memberLoginRequest request);

    boolean sendCode(memberSendCodeRequest request);
}
