package com.v.train.domain.member.service.rule;


import com.v.train.domain.member.model.entity.RuleLogicEntity;

/**
 * @author admin
 * @date 2023/11/17
 * 规则过滤接口
 */
public interface ILogicFilter<T> {

    //流程校验
    RuleLogicEntity<T> filter(T data);

}
