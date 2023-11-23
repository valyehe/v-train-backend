package com.v.train.domain.member.service.rule.factory;

import com.v.train.domain.member.annotation.LogicStrategy;
import com.v.train.domain.member.service.rule.ILogicFilter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 规则工厂
 *
 * @author admin
 * @date 2023/11/17
 */
@Service
public class DefaultLogicFactory<T> {

    public Map<String, ILogicFilter<T>> LogicFilterMap = new ConcurrentHashMap<>();

    public DefaultLogicFactory(List<ILogicFilter<T>> logicFilters) {
        logicFilters.forEach(
                logic -> {
                    LogicStrategy strategy = AnnotationUtils.findAnnotation(logic.getClass(), LogicStrategy.class);
                    if (null != strategy) {
                        LogicFilterMap.put(strategy.logicMode().getCode(), logic);
                    }
                }
        );
    }

    public Map<String, ILogicFilter<T>> openLogicFilter() {
        return LogicFilterMap;
    }


    /**
     * 规则逻辑枚举
     */
    public enum LogicModel {

        NULL("NULL", "放行不用过滤"),

        MOBILE_NUMBER("MOBILE_NUMBER", "手机号过滤"),

        CHECK_WORD("CHECK_WORD", "验证码过滤"),

        ;


        private String code;
        private String info;

        LogicModel(String code, String info) {
            this.code = code;
            this.info = info;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }


}
