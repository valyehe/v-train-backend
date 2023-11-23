package com.v.train.domain.member.service;

import com.v.train.domain.member.model.entity.MemberLoginEntity;
import com.v.train.domain.member.model.entity.RuleLogicEntity;
import com.v.train.domain.member.model.vo.LogicCheckTypeVO;
import com.v.train.domain.member.service.rule.ILogicFilter;
import com.v.train.domain.member.service.rule.factory.DefaultLogicFactory;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberService extends AbstractMemberService {

    @Resource
    private DefaultLogicFactory<MemberLoginEntity> logicFactory;

    @Override
    protected RuleLogicEntity<MemberLoginEntity> doMemberCheckLogic(MemberLoginEntity memberLogin, String... logics) {

        Map<String, ILogicFilter<MemberLoginEntity>> logicFilterMap = logicFactory.openLogicFilter();

        RuleLogicEntity<MemberLoginEntity> entity = null;

        int flag = 0;

        for (String code : logics) {

            if (DefaultLogicFactory.LogicModel.NULL.getCode().equals(code)) continue;

            entity = logicFilterMap.get(code).filter(memberLogin);

            if (LogicCheckTypeVO.SUCCESS.equals(entity.getType())) flag++;

            if (flag == logics.length) return entity;

        }

        return entity != null ? entity : RuleLogicEntity.<MemberLoginEntity>builder()
                .type(LogicCheckTypeVO.SUCCESS)
                .data(memberLogin)
                .build();
    }

}
