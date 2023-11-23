package com.v.train.domain.member.service;


import cn.dev33.satoken.stp.StpUtil;
import com.v.train.domain.member.model.entity.MemberEntity;
import com.v.train.domain.member.model.entity.MemberLoginEntity;
import com.v.train.domain.member.model.entity.RuleLogicEntity;
import com.v.train.domain.member.model.vo.LogicCheckTypeVO;
import com.v.train.domain.member.repository.IMemberRedisRepository;
import com.v.train.domain.member.repository.IMemberRepository;
import com.v.train.domain.member.service.rule.factory.DefaultLogicFactory;
import com.v.train.types.enums.ErrorCode;
import com.v.train.types.excepiton.BusinessException;
import jakarta.annotation.Resource;

public abstract class AbstractMemberService implements IMemberService {

    @Resource
    private IMemberRepository memberRepository;
    @Resource
    private IMemberRedisRepository memberRedisRepository;

    @Override
    public MemberEntity memberLogin(MemberLoginEntity memberLogin) {
        //判空
        if (memberLogin == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        //规则过滤
        RuleLogicEntity<MemberLoginEntity> ruleLogicEntity = this.doMemberCheckLogic(memberLogin,
                DefaultLogicFactory.LogicModel.MOBILE_NUMBER.getCode(),
                DefaultLogicFactory.LogicModel.CHECK_WORD.getCode()
        );

        if (!LogicCheckTypeVO.SUCCESS.equals(ruleLogicEntity.getType())) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, ruleLogicEntity.getInfo());
        }
        //用户查询
        MemberEntity memberResult = memberRepository.queryOrRegisterMemberByMobile(memberLogin.getMobile());
        //权限登录
        StpUtil.login(memberResult.getMemberId());
        //返回结果
        return memberResult;
    }

    @Override
    public Boolean sendCodeByMobile(MemberLoginEntity memberLogin) {
        //判空
        if (memberLogin.getMobile() == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        //规则过滤
        RuleLogicEntity<MemberLoginEntity> ruleLogicEntity = this.doMemberCheckLogic(memberLogin,
                DefaultLogicFactory.LogicModel.MOBILE_NUMBER.getCode()
        );

        if (!LogicCheckTypeVO.SUCCESS.equals(ruleLogicEntity.getType())) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, ruleLogicEntity.getInfo());
        }
        //返回结果
        return memberRedisRepository.sendCheckCodeByMobile(memberLogin.getMobile());
    }

    protected abstract RuleLogicEntity<MemberLoginEntity> doMemberCheckLogic(MemberLoginEntity memberLogin, String... logics);

}
