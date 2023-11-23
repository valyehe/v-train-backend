package com.v.train.domain.member.model.entity;

import com.v.train.domain.member.model.vo.LogicCheckTypeVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author admin
 * @date 2023/11/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RuleLogicEntity<T> {

    private LogicCheckTypeVO type;

    private String info;

    private T data;

}
