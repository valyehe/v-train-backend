package com.v.train.infrastructure.repository.member;


import com.mybatisflex.core.query.QueryCondition;
import com.mybatisflex.core.query.QueryWrapper;
import com.v.train.domain.passenger.model.aggregates.PassengerAggregate;
import com.v.train.domain.passenger.model.entity.PassengerEntity;
import com.v.train.domain.passenger.model.vo.PassengerTypeVO;
import com.v.train.domain.passenger.repository.IPassengerRepository;
import com.v.train.infrastructure.dao.member.IPassengerMapper;
import com.v.train.infrastructure.po.member.PassengerPO;
import com.v.train.types.enums.ErrorCode;
import com.v.train.types.excepiton.BusinessException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 会员 服务层实现。
 */
@Service
@Slf4j
public class PassengerRepositoryImpl implements IPassengerRepository {

    @Autowired
    private IPassengerMapper passengerMapper;

    @Override
    public Integer createPassenger(PassengerAggregate passenger) {

        PassengerPO passengerInsert = new PassengerPO();

        passengerInsert.setMemberId(passenger.getMemberId());

        passengerInsert.setName(passenger.getPassenger().getName());

        passengerInsert.setIdCard(passenger.getPassenger().getIdCard());

        passengerInsert.setType(passenger.getPassenger().getType().getCode());

        passengerInsert.setCreateTime(new Date());

        passengerInsert.setUpdateTime(new Date());

        return passengerMapper.insert(passengerInsert);

    }

    @Override
    public Integer updatePassenger(PassengerAggregate passenger) {

        PassengerPO passengerQuery = passengerMapper.selectOneByQuery(new QueryWrapper().eq("name", passenger.getPassenger().getName()));

        if (passengerQuery == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }

        PassengerPO passengerUpdate = new PassengerPO();

        passengerUpdate.setName(passenger.getPassenger().getName());

        passengerUpdate.setIdCard(passenger.getPassenger().getIdCard());

        passengerUpdate.setType(passenger.getPassenger().getType().getCode());

        return passengerMapper.updateByQuery(passengerUpdate, new QueryWrapper().eq("id", passengerQuery.getId()));
    }

    @Override
    public Integer deletePassenger(PassengerAggregate passenger) {

        PassengerPO passengerQuery = passengerMapper.selectOneByQuery(new QueryWrapper().eq("name", passenger.getPassenger().getName()));

        if (passengerQuery == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }

        return passengerMapper.deleteById(passengerQuery.getId());
    }

    @Override
    public List<PassengerEntity> queryPassenger(PassengerAggregate passenger) {

        List<PassengerPO> passengerPOList = passengerMapper.selectListByQuery(new QueryWrapper().eq("member_id", passenger.getMemberId()));

        List<PassengerEntity> passengerQueryList = new ArrayList<>();

        for (PassengerPO passengerPO : passengerPOList) {
            PassengerEntity passengerEntity = new PassengerEntity();
            passengerEntity.setName(passengerPO.getName());
            passengerEntity.setIdCard(passengerPO.getIdCard());
            passengerEntity.setType(PassengerTypeVO.get(passengerPO.getType()));
            passengerQueryList.add(passengerEntity);
        }

        return passengerQueryList;
    }
}