package com.v.train.config;

import com.mybatisflex.core.mybatis.FlexConfiguration;
import com.mybatisflex.spring.boot.ConfigurationCustomizer;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
//MybatisFlex配置
public class MybatisFlexConfig implements ConfigurationCustomizer {
    @Override
    //日志输出
    public void customize(FlexConfiguration flexConfiguration) {
        flexConfiguration.setLogImpl(StdOutImpl.class);
    }

}
