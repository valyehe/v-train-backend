package com.v.train.infrastructure.repository.member;


import cn.hutool.core.lang.Snowflake;
import com.mybatisflex.core.query.QueryWrapper;
import com.v.train.domain.member.model.entity.MemberEntity;
import com.v.train.domain.member.repository.IMemberRepository;
import com.v.train.infrastructure.dao.member.IMemberMapper;
import com.v.train.infrastructure.po.member.MemberPO;
import com.v.train.types.enums.ErrorCode;
import com.v.train.types.excepiton.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 会员 服务层实现。
 */
@Service
@Slf4j
public class MemberRepositoryImpl implements IMemberRepository {

    @Autowired
    private IMemberMapper memberMapper;

    @Override
    public MemberEntity queryOrRegisterMemberByMobile(String mobile) {

        if (mobile == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR, "手机号为空");
        }

        long countByQuery = memberMapper.selectCountByQuery(new QueryWrapper().eq("mobile", mobile));

        if (countByQuery == 0) {

            MemberPO memberInsert = new MemberPO();

            memberInsert.setMemberId(new Snowflake().nextId());

            memberInsert.setMobile(mobile);

            memberInsert.setCreateTime(new Date());

            memberInsert.setUpdateTime(new Date());

            int insertResult = memberMapper.insert(memberInsert);

            if (insertResult == 0) {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR);
            }

        }

        MemberPO mobileByQuery = memberMapper.selectOneByQuery(new QueryWrapper().eq("mobile", mobile));

        if (mobileByQuery == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }

        MemberEntity member = new MemberEntity();

        member.setMemberId(mobileByQuery.getMemberId());

        member.setMobile(mobileByQuery.getMobile());

        return member;
    }


}