package com.v.train.infrastructure.redis.member;


import cn.hutool.core.util.RandomUtil;
import com.v.train.domain.member.repository.IMemberRedisRepository;
import com.v.train.domain.member.repository.IMemberRepository;
import com.v.train.types.enums.ErrorCode;
import com.v.train.types.excepiton.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 会员 服务层实现。
 */
@Service
@Slf4j
public class MemberRedisRepositoryImpl implements IMemberRedisRepository {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public Boolean sendCheckCodeByMobile(String mobile) {
        //判空
        if (mobile == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR, "手机号为空");
        }
        //创建验证码
        String code = RandomUtil.randomNumbers(4);
        String key = mobile + "For" + "CheckCode";
        //保存验证码
        redisTemplate.opsForValue().set(key, code, 5, TimeUnit.MINUTES);
        //返回结果
        String result = redisTemplate.opsForValue().get(key);
        log.info(key + ":" + result);
        return result != null;
    }

    @Override
    public Boolean compareCheckCodeByMobile(String mobile, String checkCode) {
        //获取验证码
        String key = mobile + "For" + "CheckCode";
        String result = redisTemplate.opsForValue().get(key);
        //比较验证码
        if (result != null && result.equals(checkCode)) {
            return true;
        }
        //删除验证码
        redisTemplate.delete(key);
        //返回结果
        return false;
    }

}