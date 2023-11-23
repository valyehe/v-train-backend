package com.v.train.domain.passenger.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PassengerTypeVO {

    ADULT(1, "成人"),
    CHILD(2, "儿童"),
    STUDENT(3, "学生");;

    private final Integer code;
    private final String desc;

    public static PassengerTypeVO get(Integer code) {
        return switch (code) {
            default -> PassengerTypeVO.ADULT;
            case 2 -> PassengerTypeVO.CHILD;
            case 3 -> PassengerTypeVO.STUDENT;
        };
    }


}
