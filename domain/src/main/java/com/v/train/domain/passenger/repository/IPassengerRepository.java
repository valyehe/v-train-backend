package com.v.train.domain.passenger.repository;

import com.v.train.domain.passenger.model.aggregates.PassengerAggregate;
import com.v.train.domain.passenger.model.entity.PassengerEntity;

import java.util.List;

public interface IPassengerRepository {

    //创建乘车人
    Integer createPassenger(PassengerAggregate passenger);

    //修改乘车人
    Integer updatePassenger(PassengerAggregate passenger);

    //删除乘车人
    Integer deletePassenger(PassengerAggregate passenger);

    //查询乘车人
    List<PassengerEntity> queryPassenger(PassengerAggregate passenger);


}
