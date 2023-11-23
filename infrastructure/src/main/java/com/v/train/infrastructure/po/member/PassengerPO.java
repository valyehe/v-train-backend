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
 * 乘车人 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Table(value = "passenger")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerPO {

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
     * 姓名
     */
    @Column(value = "name")
    private String name;

    /**
     * 身份证
     */
    @Column(value = "id_card")
    private String idCard;

    /**
     * 旅客类型|枚举[PassengerTypeEnum]
     */
    @Column(value = "type")
    private Integer type;

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
