package com.v.train.domain.member.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 会员 实体类。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberEntity {

    /**
     * 会员id
     */
    private long memberId;

    /**
     * 手机号
     */
    private String mobile;


}
