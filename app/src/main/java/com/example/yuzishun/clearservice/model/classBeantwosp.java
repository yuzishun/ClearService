package com.example.yuzishun.clearservice.model;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/20.
 */

public class classBeantwosp {


    /**
     * code : 200
     * msg : success
     * data : {"page":1,"totalNumber":2,"list":[{"ping_begin_time":1534780800,"ping_end_time":1534867200,"service_banner_img":["https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg"],"service_video_url":"http:://www.video.url.com","service_time":[1534953600,1535040000],"service_detail_time":[[1535001900,1535003700,1535005500,1535007300,1535009100],[1535001900,1535003700,1535005500,1535007300,1535009100]],"service_original_money":213,"service_money":122,"service_address_point":[121.472517,31.268818],"service_address_radius":1234,"ping_number":1,"have_ping_number":0,"service_content":"https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","service_status":1,"is_push_homepage":0,"is_display":0,"create_time":1534742748,"update_time":1534742748,"_id":"5b7a50dc64db5508aa461328","service_name":"卫生保健","service_begin_time":1534953600,"service_end_time":1535040000,"service_brach_id":{"classify_branch_id":"0","is_delete":1,"sort_number":0,"create_time":"1534492770","update_time":"1534492770","_id":"5b768062e2e0f47a88bc18e5","classify_name":"保洁医生","classify_logo":"https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","classify_type":"1"},"service_classify_id":{"classify_branch_id":"5b768062e2e0f47a88bc18e5","is_delete":1,"sort_number":0,"create_time":"1534742547","update_time":"1534742547","_id":"5b7a501264db5508aa461326","classify_name":"今天我","classify_logo":null,"classify_type":"2"},"service_address_name":"南京西","service_area_name":"上海浦东","service_area_city":"上海","service_time_begin_slot":"13:25","service_time_end_slot":"15:25"},{"ping_begin_time":1534742617,"ping_end_time":1534780800,"service_banner_img":["https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg"],"service_video_url":"http:://www.video.url.com","service_time":[1535472000,1535558400],"service_detail_time":[[1535520180,1535521980,1535523780,1535525580,1535527380,1535529180,1535530980,1535532780,1535534580],[1535520180,1535521980,1535523780,1535525580,1535527380,1535529180,1535530980,1535532780,1535534580]],"service_original_money":213,"service_money":122,"service_address_point":[121.472517,31.268818],"service_address_radius":1234,"ping_number":1,"have_ping_number":0,"service_content":"https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","service_status":1,"is_push_homepage":0,"is_display":0,"create_time":1534742657,"update_time":1534742657,"_id":"5b7a508064db5508aa461327","service_name":"我是个商品","service_begin_time":1535472000,"service_end_time":1535558400,"service_brach_id":{"classify_branch_id":"0","is_delete":1,"sort_number":0,"create_time":"1534492770","update_time":"1534492770","_id":"5b768062e2e0f47a88bc18e5","classify_name":"保洁医生","classify_logo":"https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","classify_type":"1"},"service_classify_id":{"classify_branch_id":"5b768062e2e0f47a88bc18e5","is_delete":1,"sort_number":0,"create_time":"1534742547","update_time":"1534742547","_id":"5b7a501264db5508aa461326","classify_name":"今天我","classify_logo":null,"classify_type":"2"},"service_address_name":"南京西","service_area_name":"上海浦东","service_area_city":"上海","service_time_begin_slot":"13:23","service_time_end_slot":"17:23"}]}
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
         * page : 1
         * totalNumber : 2
         * list : [{"ping_begin_time":1534780800,"ping_end_time":1534867200,"service_banner_img":["https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg"],"service_video_url":"http:://www.video.url.com","service_time":[1534953600,1535040000],"service_detail_time":[[1535001900,1535003700,1535005500,1535007300,1535009100],[1535001900,1535003700,1535005500,1535007300,1535009100]],"service_original_money":213,"service_money":122,"service_address_point":[121.472517,31.268818],"service_address_radius":1234,"ping_number":1,"have_ping_number":0,"service_content":"https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","service_status":1,"is_push_homepage":0,"is_display":0,"create_time":1534742748,"update_time":1534742748,"_id":"5b7a50dc64db5508aa461328","service_name":"卫生保健","service_begin_time":1534953600,"service_end_time":1535040000,"service_brach_id":{"classify_branch_id":"0","is_delete":1,"sort_number":0,"create_time":"1534492770","update_time":"1534492770","_id":"5b768062e2e0f47a88bc18e5","classify_name":"保洁医生","classify_logo":"https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","classify_type":"1"},"service_classify_id":{"classify_branch_id":"5b768062e2e0f47a88bc18e5","is_delete":1,"sort_number":0,"create_time":"1534742547","update_time":"1534742547","_id":"5b7a501264db5508aa461326","classify_name":"今天我","classify_logo":null,"classify_type":"2"},"service_address_name":"南京西","service_area_name":"上海浦东","service_area_city":"上海","service_time_begin_slot":"13:25","service_time_end_slot":"15:25"},{"ping_begin_time":1534742617,"ping_end_time":1534780800,"service_banner_img":["https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg"],"service_video_url":"http:://www.video.url.com","service_time":[1535472000,1535558400],"service_detail_time":[[1535520180,1535521980,1535523780,1535525580,1535527380,1535529180,1535530980,1535532780,1535534580],[1535520180,1535521980,1535523780,1535525580,1535527380,1535529180,1535530980,1535532780,1535534580]],"service_original_money":213,"service_money":122,"service_address_point":[121.472517,31.268818],"service_address_radius":1234,"ping_number":1,"have_ping_number":0,"service_content":"https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","service_status":1,"is_push_homepage":0,"is_display":0,"create_time":1534742657,"update_time":1534742657,"_id":"5b7a508064db5508aa461327","service_name":"我是个商品","service_begin_time":1535472000,"service_end_time":1535558400,"service_brach_id":{"classify_branch_id":"0","is_delete":1,"sort_number":0,"create_time":"1534492770","update_time":"1534492770","_id":"5b768062e2e0f47a88bc18e5","classify_name":"保洁医生","classify_logo":"https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","classify_type":"1"},"service_classify_id":{"classify_branch_id":"5b768062e2e0f47a88bc18e5","is_delete":1,"sort_number":0,"create_time":"1534742547","update_time":"1534742547","_id":"5b7a501264db5508aa461326","classify_name":"今天我","classify_logo":null,"classify_type":"2"},"service_address_name":"南京西","service_area_name":"上海浦东","service_area_city":"上海","service_time_begin_slot":"13:23","service_time_end_slot":"17:23"}]
         */

        private int page;
        private int totalNumber;
        private List<ListBean> list;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getTotalNumber() {
            return totalNumber;
        }

        public void setTotalNumber(int totalNumber) {
            this.totalNumber = totalNumber;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * ping_begin_time : 1534780800
             * ping_end_time : 1534867200
             * service_banner_img : ["https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg"]
             * service_video_url : http:://www.video.url.com
             * service_time : [1534953600,1535040000]
             * service_detail_time : [[1535001900,1535003700,1535005500,1535007300,1535009100],[1535001900,1535003700,1535005500,1535007300,1535009100]]
             * service_original_money : 213
             * service_money : 122
             * service_address_point : [121.472517,31.268818]
             * service_address_radius : 1234
             * ping_number : 1
             * have_ping_number : 0
             * service_content : https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg
             * service_status : 1
             * is_push_homepage : 0
             * is_display : 0
             * create_time : 1534742748
             * update_time : 1534742748
             * _id : 5b7a50dc64db5508aa461328
             * service_name : 卫生保健
             * service_begin_time : 1534953600
             * service_end_time : 1535040000
             * service_brach_id : {"classify_branch_id":"0","is_delete":1,"sort_number":0,"create_time":"1534492770","update_time":"1534492770","_id":"5b768062e2e0f47a88bc18e5","classify_name":"保洁医生","classify_logo":"https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg","classify_type":"1"}
             * service_classify_id : {"classify_branch_id":"5b768062e2e0f47a88bc18e5","is_delete":1,"sort_number":0,"create_time":"1534742547","update_time":"1534742547","_id":"5b7a501264db5508aa461326","classify_name":"今天我","classify_logo":null,"classify_type":"2"}
             * service_address_name : 南京西
             * service_area_name : 上海浦东
             * service_area_city : 上海
             * service_time_begin_slot : 13:25
             * service_time_end_slot : 15:25
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
            private ServiceBrachIdBean service_brach_id;
            private ServiceClassifyIdBean service_classify_id;
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

            public ServiceBrachIdBean getService_brach_id() {
                return service_brach_id;
            }

            public void setService_brach_id(ServiceBrachIdBean service_brach_id) {
                this.service_brach_id = service_brach_id;
            }

            public ServiceClassifyIdBean getService_classify_id() {
                return service_classify_id;
            }

            public void setService_classify_id(ServiceClassifyIdBean service_classify_id) {
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

            public static class ServiceBrachIdBean {
                /**
                 * classify_branch_id : 0
                 * is_delete : 1
                 * sort_number : 0
                 * create_time : 1534492770
                 * update_time : 1534492770
                 * _id : 5b768062e2e0f47a88bc18e5
                 * classify_name : 保洁医生
                 * classify_logo : https://www.macx.cn/u/data/avatar/000/00/00/08_avatar_middle.jpg
                 * classify_type : 1
                 */

                private String classify_branch_id;
                private int is_delete;
                private int sort_number;
                private String create_time;
                private String update_time;
                private String _id;
                private String classify_name;
                private String classify_logo;
                private String classify_type;

                public String getClassify_branch_id() {
                    return classify_branch_id;
                }

                public void setClassify_branch_id(String classify_branch_id) {
                    this.classify_branch_id = classify_branch_id;
                }

                public int getIs_delete() {
                    return is_delete;
                }

                public void setIs_delete(int is_delete) {
                    this.is_delete = is_delete;
                }

                public int getSort_number() {
                    return sort_number;
                }

                public void setSort_number(int sort_number) {
                    this.sort_number = sort_number;
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

                public String getClassify_name() {
                    return classify_name;
                }

                public void setClassify_name(String classify_name) {
                    this.classify_name = classify_name;
                }

                public String getClassify_logo() {
                    return classify_logo;
                }

                public void setClassify_logo(String classify_logo) {
                    this.classify_logo = classify_logo;
                }

                public String getClassify_type() {
                    return classify_type;
                }

                public void setClassify_type(String classify_type) {
                    this.classify_type = classify_type;
                }
            }

            public static class ServiceClassifyIdBean {
                /**
                 * classify_branch_id : 5b768062e2e0f47a88bc18e5
                 * is_delete : 1
                 * sort_number : 0
                 * create_time : 1534742547
                 * update_time : 1534742547
                 * _id : 5b7a501264db5508aa461326
                 * classify_name : 今天我
                 * classify_logo : null
                 * classify_type : 2
                 */

                private String classify_branch_id;
                private int is_delete;
                private int sort_number;
                private String create_time;
                private String update_time;
                private String _id;
                private String classify_name;
                private Object classify_logo;
                private String classify_type;

                public String getClassify_branch_id() {
                    return classify_branch_id;
                }

                public void setClassify_branch_id(String classify_branch_id) {
                    this.classify_branch_id = classify_branch_id;
                }

                public int getIs_delete() {
                    return is_delete;
                }

                public void setIs_delete(int is_delete) {
                    this.is_delete = is_delete;
                }

                public int getSort_number() {
                    return sort_number;
                }

                public void setSort_number(int sort_number) {
                    this.sort_number = sort_number;
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

                public String getClassify_name() {
                    return classify_name;
                }

                public void setClassify_name(String classify_name) {
                    this.classify_name = classify_name;
                }

                public Object getClassify_logo() {
                    return classify_logo;
                }

                public void setClassify_logo(Object classify_logo) {
                    this.classify_logo = classify_logo;
                }

                public String getClassify_type() {
                    return classify_type;
                }

                public void setClassify_type(String classify_type) {
                    this.classify_type = classify_type;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "classBeantwosp{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
