package com.example.yuzishun.clearservice.model;

/**
 * Created by yuzishun on 2018/8/15.
 */

public class VerificationBean {


    /**
     * code : 200
     * msg : success
     * data : {"_id":"5b62c876c8f80a0c78b61472"}
     */

    private int code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * _id : 5b62c876c8f80a0c78b61472
         */

        private String _id;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }
    }

    @Override
    public String toString() {
        return "VerificationBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
