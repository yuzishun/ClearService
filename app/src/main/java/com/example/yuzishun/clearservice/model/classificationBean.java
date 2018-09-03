package com.example.yuzishun.clearservice.model;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/13.
 */

public class classificationBean {


    /**
     * code : 200
     * msg : success
     * data : {"page":1,"totalNumber":2,"list":[{"classify_branch_id":"0","is_delete":2,"sort_number":0,"create_time":"1533282496","update_time":"1533284508","_id":"5b6408bfc2438433fcae17b1","classify_name":"家庭保洁5","classify_logo":"http://www.aa.com/a.png3","classify_type":"1","__v":0},{"classify_branch_id":"5b63ffb04b17ba32d8e618db","is_delete":1,"sort_number":0,"create_time":"1533282496","update_time":"1533282496","_id":"5b6408bfc2438433fcae17b2","classify_name":"家庭保洁1","classify_logo":"http://www.aa.com/a.png","classify_type":"2","__v":0}]}
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
         * list : [{"classify_branch_id":"0","is_delete":2,"sort_number":0,"create_time":"1533282496","update_time":"1533284508","_id":"5b6408bfc2438433fcae17b1","classify_name":"家庭保洁5","classify_logo":"http://www.aa.com/a.png3","classify_type":"1","__v":0},{"classify_branch_id":"5b63ffb04b17ba32d8e618db","is_delete":1,"sort_number":0,"create_time":"1533282496","update_time":"1533282496","_id":"5b6408bfc2438433fcae17b2","classify_name":"家庭保洁1","classify_logo":"http://www.aa.com/a.png","classify_type":"2","__v":0}]
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
             * classify_branch_id : 0
             * is_delete : 2
             * sort_number : 0
             * create_time : 1533282496
             * update_time : 1533284508
             * _id : 5b6408bfc2438433fcae17b1
             * classify_name : 家庭保洁5
             * classify_logo : http://www.aa.com/a.png3
             * classify_type : 1
             * __v : 0
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
            private int __v;

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

            public int get__v() {
                return __v;
            }

            public void set__v(int __v) {
                this.__v = __v;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "classify_branch_id='" + classify_branch_id + '\'' +
                        ", is_delete=" + is_delete +
                        ", sort_number=" + sort_number +
                        ", create_time='" + create_time + '\'' +
                        ", update_time='" + update_time + '\'' +
                        ", _id='" + _id + '\'' +
                        ", classify_name='" + classify_name + '\'' +
                        ", classify_logo='" + classify_logo + '\'' +
                        ", classify_type='" + classify_type + '\'' +
                        ", __v=" + __v +
                        '}';
            }


        }
    }

    @Override
    public String toString() {
        return "classificationBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
