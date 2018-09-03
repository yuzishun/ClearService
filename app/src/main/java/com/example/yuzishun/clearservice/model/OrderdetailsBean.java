package com.example.yuzishun.clearservice.model;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/23.
 */

public class OrderdetailsBean {


    /**
     * code : 200
     * msg : success
     * data : {"service_time":1530417600,"service_business_name":null,"service_city":"南京","service_area":"上海浦东","user_confim_service_personal_time":0,"user_have_confim_identity_time":0,"user_confim_start_service_time":0,"user_confim_complete_service_time":0,"thirdy_pay_order":null,"order_money":10,"order_pay_money":10,"order_time":1534937207,"pay_time":0,"order_pay_type":0,"ping_time":0,"send_order_time":0,"business_send_order_time":0,"order_type":1,"order_status":12,"create_time":1534937207,"update_time":1534937207,"order_settlement_status":1,"order_settlement_time":0,"service_personal_confirm_visit_time":0,"service_personal_confirm_order":0,"service_personal_confirm_start":0,"service_personal_confirm_complete":0,"_id":"5b7d4876e1807b81471c4bea","order_sn":"20188221926461075","service_title":"测试扫地","service_id":{"ping_begin_time":1527825600,"ping_end_time":1598004103,"service_banner_img":["http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg"],"service_video_url":"http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4","service_time":[1534809600,1534896000,1534982400,1535068800,1535155200,1535241600,1535328000,1535414400,1535500800,1535587200,1535673600,1535760000,1535846400,1535932800,1536019200,1536105600,1536192000,1536278400,1536364800,1536451200,1536537600,1536624000,1536710400,1536796800,1536883200,1536969600,1537056000,1537142400,1537228800,1537315200,1537401600,1537488000],"service_detail_time":[[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200]],"service_original_money":100,"service_money":10,"service_address_point":[121.472517,31.268818],"service_address_radius":10,"ping_number":10,"have_ping_number":0,"service_content":"http://att.bbs.duowan.com/forum/201405/22/154840fovfma9ayappk4fp.jpg","service_status":1,"is_push_homepage":1,"is_display":0,"create_time":1534838936,"update_time":1534838936,"_id":"5b7bc897c66b10409ec54eb3","service_name":"测试扫地","service_begin_time":1534809600,"service_end_time":1537488000,"service_branch_id":"5b7bc64c9218f63fcf2fe1dc","service_classify_id":"5b7bc65c9218f63fcf2fe1dd","service_address_name":"制造局","service_area_name":"上海浦东","service_area_city":"南京","service_time_begin_slot":"08:00","service_time_end_slot":"09:00"},"user_id":{"user_password":"11111111","nickname":"a123123","sex":"男","user_select_tag":["123123","33333","44444"],"create_time":"1533200502","update_time":"1533200502","last_login_time":"0","_id":"5b62c876c8f80a0c78b61472","user_phone":"13524446830","area_number":"+86","__v":0,"headerimg_url":"http://213123124.com","token":"n7n15izAG9YRqo1OTMHSX40b","token_expire_time":1599840000},"user_address_id":{"address_point":[121.472517,31.268818],"user_name":"啊带个好","mobile_phone":"13524565834","address_info":"发个好好的","address_name":"海淀区","is_delete":1,"is_default":0,"create_time":"1534491374","update_time":"1534491374","_id":"5b767aed3308897973e313a8","user_id":"5b62c876c8f80a0c78b61472","address_city":"上海"}}
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
         * service_time : 1530417600
         * service_business_name : null
         * service_city : 南京
         * service_area : 上海浦东
         * user_confim_service_personal_time : 0
         * user_have_confim_identity_time : 0
         * user_confim_start_service_time : 0
         * user_confim_complete_service_time : 0
         * thirdy_pay_order : null
         * order_money : 10
         * order_pay_money : 10
         * order_time : 1534937207
         * pay_time : 0
         * order_pay_type : 0
         * ping_time : 0
         * send_order_time : 0
         * business_send_order_time : 0
         * order_type : 1
         * order_status : 12
         * create_time : 1534937207
         * update_time : 1534937207
         * order_settlement_status : 1
         * order_settlement_time : 0
         * service_personal_confirm_visit_time : 0
         * service_personal_confirm_order : 0
         * service_personal_confirm_start : 0
         * service_personal_confirm_complete : 0
         * _id : 5b7d4876e1807b81471c4bea
         * order_sn : 20188221926461075
         * service_title : 测试扫地
         * service_id : {"ping_begin_time":1527825600,"ping_end_time":1598004103,"service_banner_img":["http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg"],"service_video_url":"http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4","service_time":[1534809600,1534896000,1534982400,1535068800,1535155200,1535241600,1535328000,1535414400,1535500800,1535587200,1535673600,1535760000,1535846400,1535932800,1536019200,1536105600,1536192000,1536278400,1536364800,1536451200,1536537600,1536624000,1536710400,1536796800,1536883200,1536969600,1537056000,1537142400,1537228800,1537315200,1537401600,1537488000],"service_detail_time":[[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200]],"service_original_money":100,"service_money":10,"service_address_point":[121.472517,31.268818],"service_address_radius":10,"ping_number":10,"have_ping_number":0,"service_content":"http://att.bbs.duowan.com/forum/201405/22/154840fovfma9ayappk4fp.jpg","service_status":1,"is_push_homepage":1,"is_display":0,"create_time":1534838936,"update_time":1534838936,"_id":"5b7bc897c66b10409ec54eb3","service_name":"测试扫地","service_begin_time":1534809600,"service_end_time":1537488000,"service_branch_id":"5b7bc64c9218f63fcf2fe1dc","service_classify_id":"5b7bc65c9218f63fcf2fe1dd","service_address_name":"制造局","service_area_name":"上海浦东","service_area_city":"南京","service_time_begin_slot":"08:00","service_time_end_slot":"09:00"}
         * user_id : {"user_password":"11111111","nickname":"a123123","sex":"男","user_select_tag":["123123","33333","44444"],"create_time":"1533200502","update_time":"1533200502","last_login_time":"0","_id":"5b62c876c8f80a0c78b61472","user_phone":"13524446830","area_number":"+86","__v":0,"headerimg_url":"http://213123124.com","token":"n7n15izAG9YRqo1OTMHSX40b","token_expire_time":1599840000}
         * user_address_id : {"address_point":[121.472517,31.268818],"user_name":"啊带个好","mobile_phone":"13524565834","address_info":"发个好好的","address_name":"海淀区","is_delete":1,"is_default":0,"create_time":"1534491374","update_time":"1534491374","_id":"5b767aed3308897973e313a8","user_id":"5b62c876c8f80a0c78b61472","address_city":"上海"}
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
        private int order_pay_money;
        private int order_time;
        private int over_order_time;
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
        private String _id;
        private String order_sn;
        private String service_title;
        private ServiceIdBean service_id;
        private UserIdBean user_id;
        private UserAddressIdBean user_address_id;

        public int getOver_order_time() {
            return over_order_time;
        }

        public void setOver_order_time(int over_order_time) {
            this.over_order_time = over_order_time;
        }

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

        public int getOrder_pay_money() {
            return order_pay_money;
        }

        public void setOrder_pay_money(int order_pay_money) {
            this.order_pay_money = order_pay_money;
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

        public ServiceIdBean getService_id() {
            return service_id;
        }

        public void setService_id(ServiceIdBean service_id) {
            this.service_id = service_id;
        }

        public UserIdBean getUser_id() {
            return user_id;
        }

        public void setUser_id(UserIdBean user_id) {
            this.user_id = user_id;
        }

        public UserAddressIdBean getUser_address_id() {
            return user_address_id;
        }

        public void setUser_address_id(UserAddressIdBean user_address_id) {
            this.user_address_id = user_address_id;
        }

        public static class ServiceIdBean {
            /**
             * ping_begin_time : 1527825600
             * ping_end_time : 1598004103
             * service_banner_img : ["http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg"]
             * service_video_url : http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4
             * service_time : [1534809600,1534896000,1534982400,1535068800,1535155200,1535241600,1535328000,1535414400,1535500800,1535587200,1535673600,1535760000,1535846400,1535932800,1536019200,1536105600,1536192000,1536278400,1536364800,1536451200,1536537600,1536624000,1536710400,1536796800,1536883200,1536969600,1537056000,1537142400,1537228800,1537315200,1537401600,1537488000]
             * service_detail_time : [[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200],[1534809600,1534811400,1534813200]]
             * service_original_money : 100
             * service_money : 10
             * service_address_point : [121.472517,31.268818]
             * service_address_radius : 10
             * ping_number : 10
             * have_ping_number : 0
             * service_content : http://att.bbs.duowan.com/forum/201405/22/154840fovfma9ayappk4fp.jpg
             * service_status : 1
             * is_push_homepage : 1
             * is_display : 0
             * create_time : 1534838936
             * update_time : 1534838936
             * _id : 5b7bc897c66b10409ec54eb3
             * service_name : 测试扫地
             * service_begin_time : 1534809600
             * service_end_time : 1537488000
             * service_branch_id : 5b7bc64c9218f63fcf2fe1dc
             * service_classify_id : 5b7bc65c9218f63fcf2fe1dd
             * service_address_name : 制造局
             * service_area_name : 上海浦东
             * service_area_city : 南京
             * service_time_begin_slot : 08:00
             * service_time_end_slot : 09:00
             */

            private int ping_begin_time;
            private int ping_end_time;
            private String service_video_url;
            private int service_original_money;
            private int service_money;
            private int service_address_radius;
            private int ping_number;
            private int have_ping_number;
            private String service_content;
            private int service_status;
            private int is_push_homepage;
            private int is_display;
            private int create_time;
            private int update_time;
            private String _id;
            private String service_name;
            private int service_begin_time;
            private int service_end_time;
            private String service_branch_id;
            private String service_classify_id;
            private String service_address_name;
            private String service_area_name;
            private String service_area_city;
            private String service_time_begin_slot;
            private String service_time_end_slot;
            private List<String> service_banner_img;
            private List<Integer> service_time;
            private List<List<Integer>> service_detail_time;
            private List<Double> service_address_point;

            public int getPing_begin_time() {
                return ping_begin_time;
            }

            public void setPing_begin_time(int ping_begin_time) {
                this.ping_begin_time = ping_begin_time;
            }

            public int getPing_end_time() {
                return ping_end_time;
            }

            public void setPing_end_time(int ping_end_time) {
                this.ping_end_time = ping_end_time;
            }

            public String getService_video_url() {
                return service_video_url;
            }

            public void setService_video_url(String service_video_url) {
                this.service_video_url = service_video_url;
            }

            public int getService_original_money() {
                return service_original_money;
            }

            public void setService_original_money(int service_original_money) {
                this.service_original_money = service_original_money;
            }

            public int getService_money() {
                return service_money;
            }

            public void setService_money(int service_money) {
                this.service_money = service_money;
            }

            public int getService_address_radius() {
                return service_address_radius;
            }

            public void setService_address_radius(int service_address_radius) {
                this.service_address_radius = service_address_radius;
            }

            public int getPing_number() {
                return ping_number;
            }

            public void setPing_number(int ping_number) {
                this.ping_number = ping_number;
            }

            public int getHave_ping_number() {
                return have_ping_number;
            }

            public void setHave_ping_number(int have_ping_number) {
                this.have_ping_number = have_ping_number;
            }

            public String getService_content() {
                return service_content;
            }

            public void setService_content(String service_content) {
                this.service_content = service_content;
            }

            public int getService_status() {
                return service_status;
            }

            public void setService_status(int service_status) {
                this.service_status = service_status;
            }

            public int getIs_push_homepage() {
                return is_push_homepage;
            }

            public void setIs_push_homepage(int is_push_homepage) {
                this.is_push_homepage = is_push_homepage;
            }

            public int getIs_display() {
                return is_display;
            }

            public void setIs_display(int is_display) {
                this.is_display = is_display;
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

            public String getService_name() {
                return service_name;
            }

            public void setService_name(String service_name) {
                this.service_name = service_name;
            }

            public int getService_begin_time() {
                return service_begin_time;
            }

            public void setService_begin_time(int service_begin_time) {
                this.service_begin_time = service_begin_time;
            }

            public int getService_end_time() {
                return service_end_time;
            }

            public void setService_end_time(int service_end_time) {
                this.service_end_time = service_end_time;
            }

            public String getService_branch_id() {
                return service_branch_id;
            }

            public void setService_branch_id(String service_branch_id) {
                this.service_branch_id = service_branch_id;
            }

            public String getService_classify_id() {
                return service_classify_id;
            }

            public void setService_classify_id(String service_classify_id) {
                this.service_classify_id = service_classify_id;
            }

            public String getService_address_name() {
                return service_address_name;
            }

            public void setService_address_name(String service_address_name) {
                this.service_address_name = service_address_name;
            }

            public String getService_area_name() {
                return service_area_name;
            }

            public void setService_area_name(String service_area_name) {
                this.service_area_name = service_area_name;
            }

            public String getService_area_city() {
                return service_area_city;
            }

            public void setService_area_city(String service_area_city) {
                this.service_area_city = service_area_city;
            }

            public String getService_time_begin_slot() {
                return service_time_begin_slot;
            }

            public void setService_time_begin_slot(String service_time_begin_slot) {
                this.service_time_begin_slot = service_time_begin_slot;
            }

            public String getService_time_end_slot() {
                return service_time_end_slot;
            }

            public void setService_time_end_slot(String service_time_end_slot) {
                this.service_time_end_slot = service_time_end_slot;
            }

            public List<String> getService_banner_img() {
                return service_banner_img;
            }

            public void setService_banner_img(List<String> service_banner_img) {
                this.service_banner_img = service_banner_img;
            }

            public List<Integer> getService_time() {
                return service_time;
            }

            public void setService_time(List<Integer> service_time) {
                this.service_time = service_time;
            }

            public List<List<Integer>> getService_detail_time() {
                return service_detail_time;
            }

            public void setService_detail_time(List<List<Integer>> service_detail_time) {
                this.service_detail_time = service_detail_time;
            }

            public List<Double> getService_address_point() {
                return service_address_point;
            }

            public void setService_address_point(List<Double> service_address_point) {
                this.service_address_point = service_address_point;
            }
        }

        public static class UserIdBean {
            /**
             * user_password : 11111111
             * nickname : a123123
             * sex : 男
             * user_select_tag : ["123123","33333","44444"]
             * create_time : 1533200502
             * update_time : 1533200502
             * last_login_time : 0
             * _id : 5b62c876c8f80a0c78b61472
             * user_phone : 13524446830
             * area_number : +86
             * __v : 0
             * headerimg_url : http://213123124.com
             * token : n7n15izAG9YRqo1OTMHSX40b
             * token_expire_time : 1599840000
             */

            private String user_password;
            private String nickname;
            private String sex;
            private String create_time;
            private String update_time;
            private String last_login_time;
            private String _id;
            private String user_phone;
            private String area_number;
            private int __v;
            private String headerimg_url;
            private String token;
            private int token_expire_time;
            private List<String> user_select_tag;

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

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
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

            public String getLast_login_time() {
                return last_login_time;
            }

            public void setLast_login_time(String last_login_time) {
                this.last_login_time = last_login_time;
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

        public static class UserAddressIdBean {
            /**
             * address_point : [121.472517,31.268818]
             * user_name : 啊带个好
             * mobile_phone : 13524565834
             * address_info : 发个好好的
             * address_name : 海淀区
             * is_delete : 1
             * is_default : 0
             * create_time : 1534491374
             * update_time : 1534491374
             * _id : 5b767aed3308897973e313a8
             * user_id : 5b62c876c8f80a0c78b61472
             * address_city : 上海
             */

            private String user_name;
            private String mobile_phone;
            private String address_info;
            private String address_name;
            private int is_delete;
            private int is_default;
            private String create_time;
            private String update_time;
            private String _id;
            private String user_id;
            private String address_city;
            private List<Double> address_point;

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getMobile_phone() {
                return mobile_phone;
            }

            public void setMobile_phone(String mobile_phone) {
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

            public int getIs_default() {
                return is_default;
            }

            public void setIs_default(int is_default) {
                this.is_default = is_default;
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
            return "DataBean{" +
                    "service_time=" + service_time +
                    ", service_business_name=" + service_business_name +
                    ", service_city='" + service_city + '\'' +
                    ", service_area='" + service_area + '\'' +
                    ", user_confim_service_personal_time=" + user_confim_service_personal_time +
                    ", user_have_confim_identity_time=" + user_have_confim_identity_time +
                    ", user_confim_start_service_time=" + user_confim_start_service_time +
                    ", user_confim_complete_service_time=" + user_confim_complete_service_time +
                    ", thirdy_pay_order=" + thirdy_pay_order +
                    ", order_money=" + order_money +
                    ", order_pay_money=" + order_pay_money +
                    ", order_time=" + order_time +
                    ", pay_time=" + pay_time +
                    ", order_pay_type=" + order_pay_type +
                    ", ping_time=" + ping_time +
                    ", send_order_time=" + send_order_time +
                    ", business_send_order_time=" + business_send_order_time +
                    ", order_type=" + order_type +
                    ", order_status=" + order_status +
                    ", create_time=" + create_time +
                    ", update_time=" + update_time +
                    ", order_settlement_status=" + order_settlement_status +
                    ", order_settlement_time=" + order_settlement_time +
                    ", service_personal_confirm_visit_time=" + service_personal_confirm_visit_time +
                    ", service_personal_confirm_order=" + service_personal_confirm_order +
                    ", service_personal_confirm_start=" + service_personal_confirm_start +
                    ", service_personal_confirm_complete=" + service_personal_confirm_complete +
                    ", _id='" + _id + '\'' +
                    ", order_sn='" + order_sn + '\'' +
                    ", service_title='" + service_title + '\'' +
                    ", service_id=" + service_id +
                    ", user_id=" + user_id +
                    ", user_address_id=" + user_address_id +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "OrderdetailsBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
