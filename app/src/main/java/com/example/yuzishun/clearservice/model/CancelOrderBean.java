package com.example.yuzishun.clearservice.model;

/**
 * Created by yuzishun on 2018/8/28.
 */

public class CancelOrderBean {


    /**
     * code : 200
     * msg : success
     * data : 5b72924383f1de1572e00b63
     */

    private int code;
    private String msg;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CancelOrderBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
