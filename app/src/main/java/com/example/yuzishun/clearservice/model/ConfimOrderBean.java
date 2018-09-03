package com.example.yuzishun.clearservice.model;

/**
 * Created by yuzishun on 2018/8/28.
 */

public class ConfimOrderBean {


    /**
     * code : 200
     * msg : success
     * data : {"service_time":1534813200,"service_business_name":null,"service_city":"南京","service_area":"上海浦东3","user_confim_service_personal_time":1535422065,"user_have_confim_identity_time":1535422065,"user_confim_start_service_time":1535422065,"user_confim_complete_service_time":1535422065,"thirdy_pay_order":null,"order_money":10,"over_order_time":1535100760,"order_pay_money":10,"reach_account_money":0,"reward_money":0,"order_time":1535098960,"pay_time":0,"order_pay_type":2,"ping_time":0,"send_order_time":0,"business_send_order_time":0,"order_type":1,"order_status":1,"create_time":1535098960,"update_time":1535448528,"order_settlement_status":1,"order_settlement_time":0,"service_personal_confirm_visit_time":0,"service_personal_confirm_order":0,"service_personal_confirm_start":0,"service_personal_confirm_complete":0,"refund_time":0,"refund_reason_text":0,"_id":"5b7fc050f19107d8d7a4518d","order_sn":"20188241622407714","service_title":"测试扫地2","service_id":"5b7be36b36231e450ae1ad61","user_id":"5b62c876c8f80a0c78b61472","user_address_id":"5b767aed3308897973e313a8"}
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
         * service_time : 1534813200
         * service_business_name : null
         * service_city : 南京
         * service_area : 上海浦东3
         * user_confim_service_personal_time : 1535422065
         * user_have_confim_identity_time : 1535422065
         * user_confim_start_service_time : 1535422065
         * user_confim_complete_service_time : 1535422065
         * thirdy_pay_order : null
         * order_money : 10
         * over_order_time : 1535100760
         * order_pay_money : 10
         * reach_account_money : 0
         * reward_money : 0
         * order_time : 1535098960
         * pay_time : 0
         * order_pay_type : 2
         * ping_time : 0
         * send_order_time : 0
         * business_send_order_time : 0
         * order_type : 1
         * order_status : 1
         * create_time : 1535098960
         * update_time : 1535448528
         * order_settlement_status : 1
         * order_settlement_time : 0
         * service_personal_confirm_visit_time : 0
         * service_personal_confirm_order : 0
         * service_personal_confirm_start : 0
         * service_personal_confirm_complete : 0
         * refund_time : 0
         * refund_reason_text : 0
         * _id : 5b7fc050f19107d8d7a4518d
         * order_sn : 20188241622407714
         * service_title : 测试扫地2
         * service_id : 5b7be36b36231e450ae1ad61
         * user_id : 5b62c876c8f80a0c78b61472
         * user_address_id : 5b767aed3308897973e313a8
         */

        private int service_time;
        private Object service_business_name;
        private String service_city;
        private String service_area;
        private int user_confim_service_personal_time;
        private int user_have_confim_identity_time;
        private int user_confim_start_service_time;
        private int user_confim_complete_service_time;
        private Object thirdy_pay_order;
        private int order_money;
        private int over_order_time;
        private int order_pay_money;
        private int reach_account_money;
        private int reward_money;
        private int order_time;
        private int pay_time;
        private int order_pay_type;
        private int ping_time;
        private int send_order_time;
        private int business_send_order_time;
        private int order_type;
        private int order_status;
        private int create_time;
        private int update_time;
        private int order_settlement_status;
        private int order_settlement_time;
        private int service_personal_confirm_visit_time;
        private int service_personal_confirm_order;
        private int service_personal_confirm_start;
        private int service_personal_confirm_complete;
        private int refund_time;
        private int refund_reason_text;
        private String _id;
        private String order_sn;
        private String service_title;
        private String service_id;
        private String user_id;
        private String user_address_id;

        public int getService_time() {
            return service_time;
        }

        public void setService_time(int service_time) {
            this.service_time = service_time;
        }

        public Object getService_business_name() {
            return service_business_name;
        }

        public void setService_business_name(Object service_business_name) {
            this.service_business_name = service_business_name;
        }

        public String getService_city() {
            return service_city;
        }

        public void setService_city(String service_city) {
            this.service_city = service_city;
        }

        public String getService_area() {
            return service_area;
        }

        public void setService_area(String service_area) {
            this.service_area = service_area;
        }

        public int getUser_confim_service_personal_time() {
            return user_confim_service_personal_time;
        }

        public void setUser_confim_service_personal_time(int user_confim_service_personal_time) {
            this.user_confim_service_personal_time = user_confim_service_personal_time;
        }

        public int getUser_have_confim_identity_time() {
            return user_have_confim_identity_time;
        }

        public void setUser_have_confim_identity_time(int user_have_confim_identity_time) {
            this.user_have_confim_identity_time = user_have_confim_identity_time;
        }

        public int getUser_confim_start_service_time() {
            return user_confim_start_service_time;
        }

        public void setUser_confim_start_service_time(int user_confim_start_service_time) {
            this.user_confim_start_service_time = user_confim_start_service_time;
        }

        public int getUser_confim_complete_service_time() {
            return user_confim_complete_service_time;
        }

        public void setUser_confim_complete_service_time(int user_confim_complete_service_time) {
            this.user_confim_complete_service_time = user_confim_complete_service_time;
        }

        public Object getThirdy_pay_order() {
            return thirdy_pay_order;
        }

        public void setThirdy_pay_order(Object thirdy_pay_order) {
            this.thirdy_pay_order = thirdy_pay_order;
        }

        public int getOrder_money() {
            return order_money;
        }

        public void setOrder_money(int order_money) {
            this.order_money = order_money;
        }

        public int getOver_order_time() {
            return over_order_time;
        }

        public void setOver_order_time(int over_order_time) {
            this.over_order_time = over_order_time;
        }

        public int getOrder_pay_money() {
            return order_pay_money;
        }

        public void setOrder_pay_money(int order_pay_money) {
            this.order_pay_money = order_pay_money;
        }

        public int getReach_account_money() {
            return reach_account_money;
        }

        public void setReach_account_money(int reach_account_money) {
            this.reach_account_money = reach_account_money;
        }

        public int getReward_money() {
            return reward_money;
        }

        public void setReward_money(int reward_money) {
            this.reward_money = reward_money;
        }

        public int getOrder_time() {
            return order_time;
        }

        public void setOrder_time(int order_time) {
            this.order_time = order_time;
        }

        public int getPay_time() {
            return pay_time;
        }

        public void setPay_time(int pay_time) {
            this.pay_time = pay_time;
        }

        public int getOrder_pay_type() {
            return order_pay_type;
        }

        public void setOrder_pay_type(int order_pay_type) {
            this.order_pay_type = order_pay_type;
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

        public int getOrder_settlement_status() {
            return order_settlement_status;
        }

        public void setOrder_settlement_status(int order_settlement_status) {
            this.order_settlement_status = order_settlement_status;
        }

        public int getOrder_settlement_time() {
            return order_settlement_time;
        }

        public void setOrder_settlement_time(int order_settlement_time) {
            this.order_settlement_time = order_settlement_time;
        }

        public int getService_personal_confirm_visit_time() {
            return service_personal_confirm_visit_time;
        }

        public void setService_personal_confirm_visit_time(int service_personal_confirm_visit_time) {
            this.service_personal_confirm_visit_time = service_personal_confirm_visit_time;
        }

        public int getService_personal_confirm_order() {
            return service_personal_confirm_order;
        }

        public void setService_personal_confirm_order(int service_personal_confirm_order) {
            this.service_personal_confirm_order = service_personal_confirm_order;
        }

        public int getService_personal_confirm_start() {
            return service_personal_confirm_start;
        }

        public void setService_personal_confirm_start(int service_personal_confirm_start) {
            this.service_personal_confirm_start = service_personal_confirm_start;
        }

        public int getService_personal_confirm_complete() {
            return service_personal_confirm_complete;
        }

        public void setService_personal_confirm_complete(int service_personal_confirm_complete) {
            this.service_personal_confirm_complete = service_personal_confirm_complete;
        }

        public int getRefund_time() {
            return refund_time;
        }

        public void setRefund_time(int refund_time) {
            this.refund_time = refund_time;
        }

        public int getRefund_reason_text() {
            return refund_reason_text;
        }

        public void setRefund_reason_text(int refund_reason_text) {
            this.refund_reason_text = refund_reason_text;
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

        public String getService_title() {
            return service_title;
        }

        public void setService_title(String service_title) {
            this.service_title = service_title;
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

        public String getUser_address_id() {
            return user_address_id;
        }

        public void setUser_address_id(String user_address_id) {
            this.user_address_id = user_address_id;
        }
    }

    @Override
    public String toString() {
        return "ConfimOrderBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
