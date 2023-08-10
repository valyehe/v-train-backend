package com.v.service;

import com.v.model.domain.Member;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Admin
 * @description 针对表【member(会员)】的数据库操作Service
 * @createDate 2023-08-10 20:48:36
 */
public interface MemberService extends IService<Member> {

    long register(String mobile);

}
