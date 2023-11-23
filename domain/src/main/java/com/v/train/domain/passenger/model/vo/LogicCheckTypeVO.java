package com.v.train.domain.passenger.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LogicCheckTypeVO {

    SUCCESS("0000", "校验通过"),
    REFUSE("0001", "校验拒绝"),
    ;

    private final String code;

    private final String info;

}
