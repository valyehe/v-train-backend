package com.v.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 车票
 *
 * @TableName ticket
 */
@TableName(value = "ticket")
@Data
public class Ticket implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 会员id
     */
    private Long member_id;

    /**
     * 乘客id
     */
    private Long passenger_id;

    /**
     * 乘客姓名
     */
    private String passenger_name;

    /**
     * 日期
     */
    private Date train_date;

    /**
     * 车次编号
     */
    private String train_code;

    /**
     * 箱序
     */
    private Integer carriage_index;

    /**
     * 排号|01, 02
     */
    private String seat_row;

    /**
     * 列号|枚举[SeatColEnum]
     */
    private String seat_col;

    /**
     * 出发站
     */
    private String start_station;

    /**
     * 出发时间
     */
    private Date start_time;

    /**
     * 到达站
     */
    private String end_station;

    /**
     * 到站时间
     */
    private Date end_time;

    /**
     * 座位类型|枚举[SeatTypeEnum]
     */
    private String seat_type;

    /**
     * 新增时间
     */
    private Date create_time;

    /**
     * 修改时间
     */
    private Date update_time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}