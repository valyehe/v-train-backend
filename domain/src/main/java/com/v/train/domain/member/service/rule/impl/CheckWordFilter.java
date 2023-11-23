package com.v.train.domain.member.service.rule.impl;

import com.v.train.domain.member.annotation.LogicStrategy;
import com.v.train.domain.member.model.entity.MemberLoginEntity;
import com.v.train.domain.member.model.entity.RuleLogicEntity;
import com.v.train.domain.member.model.vo.LogicCheckTypeVO;
import com.v.train.domain.member.repository.IMemberRedisRepository;
import com.v.train.domain.member.service.rule.ILogicFilter;
import com.v.train.domain.member.service.rule.factory.DefaultLogicFactory;
import com.v.train.types.enums.ErrorCode;
import com.v.train.types.excepiton.BusinessException;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@LogicStrategy(logicMode = DefaultLogicFactory.LogicModel.CHECK_WORD)
public class CheckWordFilter implements ILogicFilter<MemberLoginEntity> {

    @Resource
    private IMemberRedisRepository memberRedisRepository;

    @Override
    public RuleLogicEntity<MemberLoginEntity> filter(MemberLoginEntity memberLogin) {

        if (memberLogin.getCheckCode().isEmpty()) {
            throw new BusinessException(ErrorCode.NULL_ERROR, "验证码为空");
        }

        if (!memberLogin.getCheckCode().matches("^[0-9]*$")) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "验证码非法字符");
        }

        if (memberLogin.getCheckCode().length() != 4) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "验证码格式不正确");
        }

        if (!memberRedisRepository.compareCheckCodeByMobile(memberLogin.getMobile(), memberLogin.getCheckCode())) {
            throw new BusinessException(ErrorCode.MEMBER_MOBILE_CODE_ERROR, "验证码不正确");
        }

        return RuleLogicEntity.<MemberLoginEntity>builder()
                .type(LogicCheckTypeVO.SUCCESS)
                .data(memberLogin)
                .build();

    }


}
