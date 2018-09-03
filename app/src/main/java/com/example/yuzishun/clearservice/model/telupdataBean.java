package com.example.yuzishun.clearservice.model;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/27.
 */

public class telupdataBean {


    /**
     * code : 200
     * msg : success
     * data : {"address_point":[11111.22,222222.33],"user_name":"翟晓平","mobile_phone":13524446830,"address_info":"西藏北路95弄103室","address_name":"和田小区1","is_delete":2,"create_time":"1533525693","update_time":"1533548774","_id":"5b67bebc369fc006c9bd084a","user_id":"5b62c876c8f80a0c78b61472","__v":0,"address_city":"南京"}
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
         * address_point : [11111.22,222222.33]
         * user_name : 翟晓平
         * mobile_phone : 13524446830
         * address_info : 西藏北路95弄103室
         * address_name : 和田小区1
         * is_delete : 2
         * create_time : 1533525693
         * update_time : 1533548774
         * _id : 5b67bebc369fc006c9bd084a
         * user_id : 5b62c876c8f80a0c78b61472
         * __v : 0
         * address_city : 南京
         */

        private String user_name;
        private long mobile_phone;
        private String address_info;
        private String address_name;
        private int is_delete;
        private String create_time;
        private String update_time;
        private String _id;
        private String user_id;
        private int __v;
        private String address_city;
        private List<Double> address_point;

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public long getMobile_phone() {
            return mobile_phone;
        }

        public void setMobile_phone(long mobile_phone) {
            this.mobile_phone = mobile_phone;
        }

        public String getAddress_info() {
            return address_info;
        }

        public void setAddress_info(String address_info) {
            this.address_info = address_info;
        }

        public String getAddress_name() {
            return address_name;
        }

        public void setAddress_name(String address_name) {
            this.address_name = address_name;
        }

        public int getIs_delete() {
            return is_delete;
        }

        public void setIs_delete(int is_delete) {
            this.is_delete = is_delete;
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

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public String getAddress_city() {
            return address_city;
        }

        public void setAddress_city(String address_city) {
            this.address_city = address_city;
        }

        public List<Double> getAddress_point() {
            return address_point;
        }

        public void setAddress_point(List<Double> address_point) {
            this.address_point = address_point;
        }
    }

    @Override
    public String toString() {
        return "telupdataBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
