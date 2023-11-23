package com.v.train.domain.member.service.rule.impl;

import com.v.train.domain.member.annotation.LogicStrategy;
import com.v.train.domain.member.model.entity.MemberLoginEntity;
import com.v.train.domain.member.model.entity.RuleLogicEntity;
import com.v.train.domain.member.model.vo.LogicCheckTypeVO;
import com.v.train.domain.member.service.rule.ILogicFilter;
import com.v.train.domain.member.service.rule.factory.DefaultLogicFactory;
import com.v.train.types.enums.ErrorCode;
import com.v.train.types.excepiton.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@LogicStrategy(logicMode = DefaultLogicFactory.LogicModel.MOBILE_NUMBER)
public class MobileFilter implements ILogicFilter<MemberLoginEntity> {

    @Override
    public RuleLogicEntity<MemberLoginEntity> filter(MemberLoginEntity memberLogin) {

        if (memberLogin.getMobile().isEmpty()) {
            throw new BusinessException(ErrorCode.NULL_ERROR, "手机号为空");
        }

        if (!memberLogin.getMobile().matches("^[0-9]*$")) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "手机号非法字符");
        }

        if (memberLogin.getMobile().length() != 11) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "手机号格式不正确");
        }

        return RuleLogicEntity.<MemberLoginEntity>builder()
                .type(LogicCheckTypeVO.SUCCESS)
                .data(memberLogin)
                .build();
    }


}
