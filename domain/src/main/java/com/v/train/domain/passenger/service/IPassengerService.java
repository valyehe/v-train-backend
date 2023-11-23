package com.v.train.domain.passenger.service;

import com.v.train.domain.passenger.model.aggregates.PassengerAggregate;
import com.v.train.domain.passenger.model.entity.PassengerEntity;

import java.util.List;

public interface IPassengerService {

    List<PassengerEntity> queryPassengerByMember(PassengerAggregate passengerAggregate);

}
