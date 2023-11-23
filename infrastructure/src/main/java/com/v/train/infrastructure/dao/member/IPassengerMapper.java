package com.v.train.infrastructure.dao.member;

import com.mybatisflex.core.BaseMapper;
import com.v.train.infrastructure.po.member.PassengerPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 乘车人 映射层。
 */
@Mapper
public interface IPassengerMapper extends BaseMapper<PassengerPO> {


}
