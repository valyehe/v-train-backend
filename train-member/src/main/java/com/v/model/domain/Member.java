package com.v.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 会员
 *
 * @TableName member
 */
@TableName(value = "member")
@Data
public class Member implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 手机号
     */
    private String mobile;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}