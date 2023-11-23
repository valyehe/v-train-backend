package com.v.train.infrastructure.po.member;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 会员 实体类。
 */
@Table(value = "member")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberPO {

    /**
     * id
     */
    @Id(keyType = KeyType.Auto)
    private Integer id;

    /**
     * 会员id
     */
    @Column(value = "member_id")
    private long memberId;

    /**
     * 手机号
     */
    @Column(value = "mobile")
    private String mobile;

    /**
     * 新增时间
     */
    @Column(value = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(value = "update_time")
    private Date updateTime;

}
