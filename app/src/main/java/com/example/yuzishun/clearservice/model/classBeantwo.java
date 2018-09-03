package com.example.yuzishun.clearservice.model;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/20.
 */

public class classBeantwo {


    /**
     * code : 200
     * msg : success
     * data : {"page":1,"totalNumber":3,"list":[{"classify_branch_id":"5b7666860806a97476ba0116","is_delete":1,"sort_number":0,"create_time":"1534486177","update_time":"1534486177","_id":"5b7666a02f344376d7c7b1aa","classify_name":"擦冰箱","classify_logo":null,"classify_type":"2"},{"classify_branch_id":"5b7666860806a97476ba0116","is_delete":1,"sort_number":0,"create_time":"1534486650","update_time":"1534486650","_id":"5b7668792f344376d7c7b1ac","classify_name":"打扫卫生间","classify_logo":null,"classify_type":"2"},{"classify_branch_id":"5b76803be2e0f47a88bc18e4","is_delete":1,"sort_number":0,"create_time":"1534492863","update_time":"1534492863","_id":"5b7680bfe2e0f47a88bc18e6","classify_name":"纳米超人","classify_logo":null,"classify_type":"2"}]}
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
         * totalNumber : 3
         * list : [{"classify_branch_id":"5b7666860806a97476ba0116","is_delete":1,"sort_number":0,"create_time":"1534486177","update_time":"1534486177","_id":"5b7666a02f344376d7c7b1aa","classify_name":"擦冰箱","classify_logo":null,"classify_type":"2"},{"classify_branch_id":"5b7666860806a97476ba0116","is_delete":1,"sort_number":0,"create_time":"1534486650","update_time":"1534486650","_id":"5b7668792f344376d7c7b1ac","classify_name":"打扫卫生间","classify_logo":null,"classify_type":"2"},{"classify_branch_id":"5b76803be2e0f47a88bc18e4","is_delete":1,"sort_number":0,"create_time":"1534492863","update_time":"1534492863","_id":"5b7680bfe2e0f47a88bc18e6","classify_name":"纳米超人","classify_logo":null,"classify_type":"2"}]
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
             * classify_branch_id : 5b7666860806a97476ba0116
             * is_delete : 1
             * sort_number : 0
             * create_time : 1534486177
             * update_time : 1534486177
             * _id : 5b7666a02f344376d7c7b1aa
             * classify_name : 擦冰箱
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

    @Override
    public String toString() {
        return "classBeantwo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
