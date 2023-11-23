package com.v.train.types.constant;

/**
 * 常见常数
 *
 * @author Admin
 */
public class SortConstant {

    public enum Sort {

        /**
         * 升序
         */
        ASC(1, "ascend"),
        /**
         * 降序
         */
        DESC(1, "descend");

        private Integer code;
        private String info;

        Sort(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
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
