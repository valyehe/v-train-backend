package com.v.train.domain.member.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author admin
 * @date 2023/11/17
 * 会员登录聚合对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberLoginEntity {

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 验证码
     */
    private String checkCode;

}
