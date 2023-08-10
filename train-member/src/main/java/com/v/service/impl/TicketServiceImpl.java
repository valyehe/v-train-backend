package com.v.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.v.model.domain.Ticket;
import com.v.service.TicketService;
import com.v.mapper.TicketMapper;
import org.springframework.stereotype.Service;

/**
 * @author Admin
 * @description 针对表【ticket(车票)】的数据库操作Service实现
 * @createDate 2023-08-10 20:48:36
 */
@Service
public class TicketServiceImpl extends ServiceImpl<TicketMapper, Ticket> implements TicketService {

}




