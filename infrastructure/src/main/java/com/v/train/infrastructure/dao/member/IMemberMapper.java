package com.v.train.infrastructure.dao.member;

import com.mybatisflex.core.BaseMapper;
import com.v.train.infrastructure.po.member.MemberPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员 映射层。
 */
@Mapper
public interface IMemberMapper extends BaseMapper<MemberPO> {


}
