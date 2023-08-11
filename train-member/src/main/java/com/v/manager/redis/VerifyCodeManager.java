package com.v.manager.redis;


import cn.hutool.core.util.RandomUtil;
import com.v.constant.CacheConstant;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Objects;

/**
 * 验证码 管理类
 *
 * @author Admin
 * date 2023/08/11
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class VerifyCodeManager {

    @Resource
    private final StringRedisTemplate stringRedisTemplate;

    /**
     * 生成数字验证码，并放入 Redis 中
     */
    public String genVerifyCode(String mobile) {
        String verifyCode = RandomUtil.randomNumbers(4);
        stringRedisTemplate.opsForValue().set(CacheConstant.VERIFY_CODE_CACHE_KEY + mobile, verifyCode, Duration.ofMinutes(5));
        return verifyCode;
    }

    /**
     * 校验图形验证码
     */
    public boolean VerifyCodeOk(String verifyCode, String mobile) {
        return Objects.equals(stringRedisTemplate.opsForValue().get(CacheConstant.VERIFY_CODE_CACHE_KEY + mobile), verifyCode);
    }

    /**
     * 从 Redis 中删除验证码
     */
    public void removeVerifyCode() {
        stringRedisTemplate.delete(CacheConstant.VERIFY_CODE_CACHE_KEY);
    }

}
