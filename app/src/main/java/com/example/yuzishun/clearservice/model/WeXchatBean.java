package com.example.yuzishun.clearservice.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yuzishun on 2018/8/16.
 */

public class WeXchatBean {


    /**
     * code : 200
     * msg : success
     * data : {"appid":"wx94fbc1be78e61ee3","partnerid":"1485758212","prepayid":"wx1617180007259704b5514d202540431780","package":"Sign=WXPay","noncestr":"zbGt2wT0lXfAzytX","timestamp":"1534411080","sign":"2432027BEFF10FED5E26D6BD9A678A88"}
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
         * appid : wx94fbc1be78e61ee3
         * partnerid : 1485758212
         * prepayid : wx1617180007259704b5514d202540431780
         * package : Sign=WXPay
         * noncestr : zbGt2wT0lXfAzytX
         * timestamp : 1534411080
         * sign : 2432027BEFF10FED5E26D6BD9A678A88
         */

        private String appid;
        private String partnerid;
        private String prepayid;
        @SerializedName("package")
        private String packageX;
        private String noncestr;
        private String timestamp;
        private String sign;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "appid='" + appid + '\'' +
                    ", partnerid='" + partnerid + '\'' +
                    ", prepayid='" + prepayid + '\'' +
                    ", packageX='" + packageX + '\'' +
                    ", noncestr='" + noncestr + '\'' +
                    ", timestamp='" + timestamp + '\'' +
                    ", sign='" + sign + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WeXchatBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
