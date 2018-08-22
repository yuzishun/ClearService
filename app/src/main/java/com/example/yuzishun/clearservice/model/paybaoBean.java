package com.example.yuzishun.clearservice.model;

/**
 * Created by yuzishun on 2018/8/16.
 */

public class paybaoBean {


    /**
     * code : 200
     * msg : success
     * data : app_id=2017052207306868&biz_content=%7B%22body%22%3A%22%E6%B5%8B%E8%AF%95%E5%95%86%E5%93%81%E6%8F%8F%E8%BF%B0%22%2C%22subject%22%3A%22%E6%B5%8B%E8%AF%95%E5%95%86%E5%93%81%22%2C%22out_trade_no%22%3A%2220188141626432879%22%2C%22timeout_express%22%3A%2210m%22%2C%22total_amount%22%3A10%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22goods_type%22%3A%220%22%7D&charset=utf-8&format=JSON&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fwww.xxx.com%2Fcallback%2Falipay&sign_type=RSA&timestamp=2018-08-16%2017%3A17%3A03&version=1.0&sign=fowGuEv70eN7%2F9SbJ9DKLnakrec5K6idpwH2MSL6Czz1aCMHJiB188fuBgPlDs8q0VuQwAkJ%2FRxD3EO%2Bkk7sExA55dT9XDlbMXPZrvm%2BpJS1906bjFFTq%2FWFubc5ZL6eV1qAw0FIHdjX%2Bca5LqrVQtUe1DgCCGTL2hAkRHMsh0GlRJec%2Fv%2F%2B%2B1nACmvOV3ecyI4lg5uOzHbTbB%2B7ykCXndkqTNWJG6rhiSzzDaqGnJOQvUNRHhtZ4PcHU7gpBrSNG89letwNx07Hrqx5Xde3dhndWYwBxqQh%2BKumhC7A1OcGxIr7%2BjVCiohB2iUYLO7Ye17sU9D1xtG8hyCku8py6g%3D%3D
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
}
