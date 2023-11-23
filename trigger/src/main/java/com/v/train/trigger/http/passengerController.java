package com.v.train.trigger.http;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.v.train.domain.passenger.model.aggregates.PassengerAggregate;
import com.v.train.domain.passenger.model.entity.PassengerEntity;
import com.v.train.domain.passenger.service.IPassengerService;
import com.v.train.types.model.BaseResponse;
import com.v.train.types.util.ResultUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class passengerController {
    @Resource
    private IPassengerService passengerService;


    @PostMapping("/query")
    @ResponseBody
    public BaseResponse<List<PassengerEntity>> query(PassengerAggregate passengerAggregate) {

        List<PassengerEntity> result = passengerService.queryPassengerByMember(passengerAggregate);

        return ResultUtils.success(result);
    }


}
