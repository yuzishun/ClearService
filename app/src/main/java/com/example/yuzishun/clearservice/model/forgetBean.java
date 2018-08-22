package com.example.yuzishun.clearservice.model;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/16.
 */

public class forgetBean {


    /**
     * code : 200
     * msg : success
     * data : {"user_select_tag":[],"create_time":"1534339083","update_time":"1534339083","_id":"5b74280a60df871cac155589","user_phone":"15801696719","user_password":"9422e07ed3ee9da1","nickname":"用户15801696719","area_number":"+86","token":"M9vwup9sTRljcKPlLh36WItW","token_expire_time":1534490185,"__v":0}
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
         * user_select_tag : []
         * create_time : 1534339083
         * update_time : 1534339083
         * _id : 5b74280a60df871cac155589
         * user_phone : 15801696719
         * user_password : 9422e07ed3ee9da1
         * nickname : 用户15801696719
         * area_number : +86
         * token : M9vwup9sTRljcKPlLh36WItW
         * token_expire_time : 1534490185
         * __v : 0
         */

        private String create_time;
        private String update_time;
        private String _id;
        private String user_phone;
        private String user_password;
        private String nickname;
        private String area_number;
        private String token;
        private int token_expire_time;
        private int __v;
        private List<?> user_select_tag;

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

        public String getUser_phone() {
            return user_phone;
        }

        public void setUser_phone(String user_phone) {
            this.user_phone = user_phone;
        }

        public String getUser_password() {
            return user_password;
        }

        public void setUser_password(String user_password) {
            this.user_password = user_password;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getArea_number() {
            return area_number;
        }

        public void setArea_number(String area_number) {
            this.area_number = area_number;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getToken_expire_time() {
            return token_expire_time;
        }

        public void setToken_expire_time(int token_expire_time) {
            this.token_expire_time = token_expire_time;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public List<?> getUser_select_tag() {
            return user_select_tag;
        }

        public void setUser_select_tag(List<?> user_select_tag) {
            this.user_select_tag = user_select_tag;
        }
    }
}
