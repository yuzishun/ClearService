package com.example.yuzishun.clearservice.model;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/15.
 */

public class LoginBean {


    /**
     * code : 200
     * msg : success
     * data : {"user_select_tag":["123123","33333","44444"],"create_time":"1533200502","update_time":"1533200502","_id":"5b62c876c8f80a0c78b61472","user_phone":"13524446830","user_password":"11111111","area_number":"+86","__v":0,"headerimg_url":"http://213123124.com","nickname":"a123123","sex":"男","token":"uiySIddQlTsmu4oP8VUD8aUr","token_expire_time":1534416033}
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
         * user_select_tag : ["123123","33333","44444"]
         * create_time : 1533200502
         * update_time : 1533200502
         * _id : 5b62c876c8f80a0c78b61472
         * user_phone : 13524446830
         * user_password : 11111111
         * area_number : +86
         * __v : 0
         * headerimg_url : http://213123124.com
         * nickname : a123123
         * sex : 男
         * token : uiySIddQlTsmu4oP8VUD8aUr
         * token_expire_time : 1534416033
         */

        private String create_time;
        private String update_time;
        private String _id;
        private String user_phone;
        private String user_password;
        private String area_number;
        private int __v;
        private String headerimg_url;
        private String nickname;
        private String sex;
        private String token;
        private int token_expire_time;
        private List<String> user_select_tag;

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

        public String getArea_number() {
            return area_number;
        }

        public void setArea_number(String area_number) {
            this.area_number = area_number;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public String getHeaderimg_url() {
            return headerimg_url;
        }

        public void setHeaderimg_url(String headerimg_url) {
            this.headerimg_url = headerimg_url;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
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

        public List<String> getUser_select_tag() {
            return user_select_tag;
        }

        public void setUser_select_tag(List<String> user_select_tag) {
            this.user_select_tag = user_select_tag;
        }
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
