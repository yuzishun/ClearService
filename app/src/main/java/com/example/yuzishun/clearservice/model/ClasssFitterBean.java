package com.example.yuzishun.clearservice.model;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/28.
 */

public class ClasssFitterBean {


    /**
     * code : 200
     * msg : success
     * data : [{"classify_name":"保洁护士","is_filter":true},{"classify_name":"细菌毁灭者","is_filter":false},{"classify_name":"打扫","is_filter":true}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * classify_name : 保洁护士
         * is_filter : true
         */

        private String classify_name;
        private boolean is_filter;

        public String getClassify_name() {
            return classify_name;
        }

        public void setClassify_name(String classify_name) {
            this.classify_name = classify_name;
        }

        public boolean isIs_filter() {
            return is_filter;
        }

        public void setIs_filter(boolean is_filter) {
            this.is_filter = is_filter;
        }
    }

    @Override
    public String toString() {
        return "ClasssFitterBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
