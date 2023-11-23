package com.v.train.domain.passenger.service;

import com.v.train.domain.passenger.model.aggregates.PassengerAggregate;
import com.v.train.domain.passenger.model.entity.PassengerEntity;
import com.v.train.domain.passenger.repository.IPassengerRepository;
import jakarta.annotation.Resource;

import java.util.List;

public abstract class AbstractPassengerService implements IPassengerService {

    @Resource
    private IPassengerRepository passengerRepository;

    @Override
    public List<PassengerEntity> queryPassengerByMember(PassengerAggregate passengerAggregate) {
        return passengerRepository.queryPassenger(passengerAggregate);
    }

}
