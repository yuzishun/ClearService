package com.example.yuzishun.clearservice.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yuzishun on 2018/8/15.
 */

public class ServiceinfocationBean implements Serializable{


    /**
     * code : 200
     * msg : success
     * data : {"ping_begin_time":1527825600,"ping_end_time":1527850800,"service_banner_img":["http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg"],"service_video_url":"http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4","service_time":[1533081600,1533168000,1533254400,1533340800,1533427200,1533513600,1533600000,1533686400,1533772800,1533859200,1533945600,1534032000,1534118400,1534204800,1534291200,1534377600,1534464000,1534550400,1534636800,1534723200,1534809600,1534896000,1534982400,1535068800,1535155200,1535241600,1535328000,1535414400,1535500800,1535587200],"service_detail_time":[[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200]],"service_original_money":100,"service_money":10,"service_address_point":[121.472517,31.268818],"service_address_radius":10,"ping_number":10,"have_ping_number":0,"service_content":"http://att.bbs.duowan.com/forum/201405/22/154840fovfma9ayappk4fp.jpg","service_status":1,"is_push_homepage":0,"is_display":0,"create_time":1534415774,"update_time":1534415774,"_id":"5b75539ddf2daf534f8f76c7","service_name":"测试扫地","service_begin_time":1533081600,"service_end_time":1535587200,"service_brach_id":"5b6408bfc2438433fcae17b1","service_classify_id":"5b6408bfc2438433fcae17b2","service_address_name":"制造局","service_area_name":"上海浦东","service_area_city":"南京","service_time_begin_slot":"08:00","service_time_end_slot":"09:00"}
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

    public static class DataBean implements Serializable{
        /**
         * ping_begin_time : 1527825600
         * ping_end_time : 1527850800
         * service_banner_img : ["http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg"]
         * service_video_url : http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4
         * service_time : [1533081600,1533168000,1533254400,1533340800,1533427200,1533513600,1533600000,1533686400,1533772800,1533859200,1533945600,1534032000,1534118400,1534204800,1534291200,1534377600,1534464000,1534550400,1534636800,1534723200,1534809600,1534896000,1534982400,1535068800,1535155200,1535241600,1535328000,1535414400,1535500800,1535587200]
         * service_detail_time : [[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200],[1533081600,1533083400,1533085200]]
         * service_original_money : 100
         * service_money : 10
         * service_address_point : [121.472517,31.268818]
         * service_address_radius : 10
         * ping_number : 10
         * have_ping_number : 0
         * service_content : http://att.bbs.duowan.com/forum/201405/22/154840fovfma9ayappk4fp.jpg
         * service_status : 1
         * is_push_homepage : 0
         * is_display : 0
         * create_time : 1534415774
         * update_time : 1534415774
         * _id : 5b75539ddf2daf534f8f76c7
         * service_name : 测试扫地
         * service_begin_time : 1533081600
         * service_end_time : 1535587200
         * service_brach_id : 5b6408bfc2438433fcae17b1
         * service_classify_id : 5b6408bfc2438433fcae17b2
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
        private String service_brach_id;
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

        public String getService_brach_id() {
            return service_brach_id;
        }

        public void setService_brach_id(String service_brach_id) {
            this.service_brach_id = service_brach_id;
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

        @Override
        public String toString() {
            return "DataBean{" +
                    "ping_begin_time=" + ping_begin_time +
                    ", ping_end_time=" + ping_end_time +
                    ", service_video_url='" + service_video_url + '\'' +
                    ", service_original_money=" + service_original_money +
                    ", service_money=" + service_money +
                    ", service_address_radius=" + service_address_radius +
                    ", ping_number=" + ping_number +
                    ", have_ping_number=" + have_ping_number +
                    ", service_content='" + service_content + '\'' +
                    ", service_status=" + service_status +
                    ", is_push_homepage=" + is_push_homepage +
                    ", is_display=" + is_display +
                    ", create_time=" + create_time +
                    ", update_time=" + update_time +
                    ", _id='" + _id + '\'' +
                    ", service_name='" + service_name + '\'' +
                    ", service_begin_time=" + service_begin_time +
                    ", service_end_time=" + service_end_time +
                    ", service_brach_id='" + service_brach_id + '\'' +
                    ", service_classify_id='" + service_classify_id + '\'' +
                    ", service_address_name='" + service_address_name + '\'' +
                    ", service_area_name='" + service_area_name + '\'' +
                    ", service_area_city='" + service_area_city + '\'' +
                    ", service_time_begin_slot='" + service_time_begin_slot + '\'' +
                    ", service_time_end_slot='" + service_time_end_slot + '\'' +
                    ", service_banner_img=" + service_banner_img +
                    ", service_time=" + service_time +
                    ", service_detail_time=" + service_detail_time +
                    ", service_address_point=" + service_address_point +
                    '}';
        }
    }
}
