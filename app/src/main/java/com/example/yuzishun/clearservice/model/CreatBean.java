package com.example.yuzishun.clearservice.model;

/**
 * Created by yuzishun on 2018/8/16.
 */

public class CreatBean {


    /**
     * code : 200
     * msg : success
     * data : {"ping_time":0,"send_order_time":0,"business_send_order_time":0,"order_type":1,"order_status":1,"create_time":1534228157,"update_time":1534228157,"_id":"5b7276bde40a630fb5b80525","order_sn":"20188141429170756","service_time":1530417600,"service_id":"5b7267a1ea02e20cb6456730","user_id":"5b62c876c8f80a0c78b61472","order_money":10,"order_pay_money":10,"order_time":1534228157,"__v":0}
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
         * ping_time : 0
         * send_order_time : 0
         * business_send_order_time : 0
         * order_type : 1
         * order_status : 1
         * create_time : 1534228157
         * update_time : 1534228157
         * _id : 5b7276bde40a630fb5b80525
         * order_sn : 20188141429170756
         * service_time : 1530417600
         * service_id : 5b7267a1ea02e20cb6456730
         * user_id : 5b62c876c8f80a0c78b61472
         * order_money : 10
         * order_pay_money : 10
         * order_time : 1534228157
         * __v : 0
         */

        private int ping_time;
        private int send_order_time;
        private int business_send_order_time;
        private int order_type;
        private int order_status;
        private int create_time;
        private int update_time;
        private String _id;
        private String order_sn;
        private int service_time;
        private String service_id;
        private String user_id;
        private float order_money;
        private int over_order_time;
        private float order_pay_money;
        private int order_time;
        private int __v;

        public int getOver_order_time() {
            return over_order_time;
        }

        public void setOver_order_time(int over_order_time) {
            this.over_order_time = over_order_time;
        }

        public int getPing_time() {
            return ping_time;
        }

        public void setPing_time(int ping_time) {
            this.ping_time = ping_time;
        }

        public int getSend_order_time() {
            return send_order_time;
        }

        public void setSend_order_time(int send_order_time) {
            this.send_order_time = send_order_time;
        }

        public int getBusiness_send_order_time() {
            return business_send_order_time;
        }

        public void setBusiness_send_order_time(int business_send_order_time) {
            this.business_send_order_time = business_send_order_time;
        }

        public int getOrder_type() {
            return order_type;
        }

        public void setOrder_type(int order_type) {
            this.order_type = order_type;
        }

        public int getOrder_status() {
            return order_status;
        }

        public void setOrder_status(int order_status) {
            this.order_status = order_status;
        }

        public int getCreate_time() {
            return create_time;
        }

        public void setCreate_time(int create_time) {
            this.create_time = create_time;
        }

        public int getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(int update_time) {
            this.update_time = update_time;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getOrder_sn() {
            return order_sn;
        }

        public void setOrder_sn(String order_sn) {
            this.order_sn = order_sn;
        }

        public int getService_time() {
            return service_time;
        }

        public void setService_time(int service_time) {
            this.service_time = service_time;
        }

        public String getService_id() {
            return service_id;
        }

        public void setService_id(String service_id) {
            this.service_id = service_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public float getOrder_money() {
            return order_money;
        }

        public void setOrder_money(float order_money) {
            this.order_money = order_money;
        }

        public float getOrder_pay_money() {
            return order_pay_money;
        }

        public void setOrder_pay_money(float order_pay_money) {
            this.order_pay_money = order_pay_money;
        }

        public int getOrder_time() {
            return order_time;
        }

        public void setOrder_time(int order_time) {
            this.order_time = order_time;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }
    }

    @Override
    public String toString() {
        return "CreatBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
