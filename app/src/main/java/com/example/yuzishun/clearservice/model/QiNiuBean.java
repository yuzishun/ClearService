package com.example.yuzishun.clearservice.model;

/**
 * Created by yuzishun on 2018/8/22.
 */

public class QiNiuBean {


    /**
     * code : 200
     * msg : success
     * data : {"scope":"huifu-test","token_expire_time":"1535693079","create_time":"1535522956","update_time":"1535693079","_id":"5b86388cb298fd05965f19f9","token":"Qr9VWX9N2-azL_44sj4YwsGxLctdzXUza3LOooyb:9f7-54D-jqwS4yF52GNt5ZcDp2c=:eyJzY29wZSI6Imh1aWZ1LXRlc3QiLCJkZWFkbGluZSI6MTUzNTcwMDI3OH0="}
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
         * scope : huifu-test
         * token_expire_time : 1535693079
         * create_time : 1535522956
         * update_time : 1535693079
         * _id : 5b86388cb298fd05965f19f9
         * token : Qr9VWX9N2-azL_44sj4YwsGxLctdzXUza3LOooyb:9f7-54D-jqwS4yF52GNt5ZcDp2c=:eyJzY29wZSI6Imh1aWZ1LXRlc3QiLCJkZWFkbGluZSI6MTUzNTcwMDI3OH0=
         */

        private String scope;
        private String token_expire_time;
        private String create_time;
        private String update_time;
        private String _id;
        private String token;

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getToken_expire_time() {
            return token_expire_time;
        }

        public void setToken_expire_time(String token_expire_time) {
            this.token_expire_time = token_expire_time;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    @Override
    public String toString() {
        return "QiNiuBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
