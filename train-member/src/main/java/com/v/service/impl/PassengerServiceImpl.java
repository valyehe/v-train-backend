package com.v.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.v.model.domain.Passenger;
import com.v.service.PassengerService;
import com.v.mapper.PassengerMapper;
import org.springframework.stereotype.Service;

/**
 * @author Admin
 * @description 针对表【passenger(乘车人)】的数据库操作Service实现
 * @createDate 2023-08-10 20:48:36
 */
@Service
public class PassengerServiceImpl extends ServiceImpl<PassengerMapper, Passenger> implements PassengerService {

}




