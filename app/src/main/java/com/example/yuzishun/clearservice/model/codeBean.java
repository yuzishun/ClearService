package com.example.yuzishun.clearservice.model;

/**
 * Created by yuzishun on 2018/8/15.
 */

public class codeBean {


    /**
     * code : 200
     * msg : success
     * data : {"_id":"5b62c876c8f80a0c78b61472","create_time":"1533200502","update_time":"1533200502"}
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
         * _id : 5b62c876c8f80a0c78b61472
         * create_time : 1533200502
         * update_time : 1533200502
         */

        private String _id;
        private String create_time;
        private String update_time;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
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
    }
}
