package com.example.yuzishun.clearservice.model;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/17.
 */

public class OrderBean {


    /**
     * code : 200
     * msg : success
     * data : {"page":1,"totalNumber":20,"list":[{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1542970426,"order_sn":"20188241622407714","_id":"5b7fc050f19107d8d7a4518d","service_time":1534813200,"service_title":"测试扫地2","order_status":1,"order_pay_money":10,"over_order_time":1535100760},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1542970426,"order_sn":"20188241620182011","_id":"5b7fbfc2f19107d8d7a4518c","service_time":1534813200,"service_title":"测试扫地2","order_status":1,"order_pay_money":10,"over_order_time":1535100619},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188231914488883","_id":"5b7e9728012c4cac4efc59a0","service_time":1530417600,"service_title":"测试扫地","order_status":15,"order_pay_money":10,"over_order_time":1535024689},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"2018822192725999","_id":"5b7d488682d8998157c9a0de","service_time":1530417600,"service_title":"测试扫地","order_status":15,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221926513212","_id":"5b7d487bd340cc814d109fe1","service_time":1530417600,"service_title":"测试扫地","order_status":13,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221926461075","_id":"5b7d4876e1807b81471c4bea","service_time":1530417600,"service_title":"测试扫地","order_status":12,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221926428934","_id":"5b7d4872d9a98281421de34b","service_time":1530417600,"service_title":"测试扫地","order_status":11,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221926363933","_id":"5b7d486c4a4232814012e0cc","service_time":1530417600,"service_title":"测试扫地","order_status":10,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221926323489","_id":"5b7d486828999d813971a7fa","service_time":1530417600,"service_title":"测试扫地","order_status":9,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221926277946","_id":"5b7d4863aa5f6b8137a07ed5","service_time":1530417600,"service_title":"测试扫地","order_status":8,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221926224077","_id":"5b7d485ea5a911813292f6e6","service_time":1530417600,"service_title":"测试扫地","order_status":7,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221926157684","_id":"5b7d48573e2163812eed8eb7","service_time":1530417600,"service_title":"测试扫地","order_status":6,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"2018822192693100","_id":"5b7d4851d57f778129e2f155","service_time":1530417600,"service_title":"测试扫地","order_status":5,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"2018822192633733","_id":"5b7d484b975f1881258732b8","service_time":1530417600,"service_title":"测试扫地","order_status":4,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221925578296","_id":"5b7d4845c8ffd2811f34b705","service_time":1530417600,"service_title":"测试扫地","order_status":3,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221925460814","_id":"5b7d483a01e017811ad9a5fc","service_time":1530417600,"service_title":"测试扫地","order_status":2,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221925272298","_id":"5b7d4827b41a098110024c5a","service_time":1530417600,"service_title":"测试扫地","order_status":1,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"2018821182314114","_id":"5b7be3370d5f0444f96c971e","service_time":1530417600,"service_title":"测试扫地","order_status":1,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"2018821182130900","_id":"5b7be32594166444f69d4ab3","service_time":1530417600,"service_title":"测试扫地","order_status":1,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221926571925","_id":"5b7d488199e73581529e6106","service_time":1530417600,"service_title":"测试扫地","order_status":14,"order_pay_money":10,"over_order_time":""}]}
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
         * totalNumber : 20
         * list : [{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1542970426,"order_sn":"20188241622407714","_id":"5b7fc050f19107d8d7a4518d","service_time":1534813200,"service_title":"测试扫地2","order_status":1,"order_pay_money":10,"over_order_time":1535100760},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1542970426,"order_sn":"20188241620182011","_id":"5b7fbfc2f19107d8d7a4518c","service_time":1534813200,"service_title":"测试扫地2","order_status":1,"order_pay_money":10,"over_order_time":1535100619},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188231914488883","_id":"5b7e9728012c4cac4efc59a0","service_time":1530417600,"service_title":"测试扫地","order_status":15,"order_pay_money":10,"over_order_time":1535024689},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"2018822192725999","_id":"5b7d488682d8998157c9a0de","service_time":1530417600,"service_title":"测试扫地","order_status":15,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221926513212","_id":"5b7d487bd340cc814d109fe1","service_time":1530417600,"service_title":"测试扫地","order_status":13,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221926461075","_id":"5b7d4876e1807b81471c4bea","service_time":1530417600,"service_title":"测试扫地","order_status":12,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221926428934","_id":"5b7d4872d9a98281421de34b","service_time":1530417600,"service_title":"测试扫地","order_status":11,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221926363933","_id":"5b7d486c4a4232814012e0cc","service_time":1530417600,"service_title":"测试扫地","order_status":10,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221926323489","_id":"5b7d486828999d813971a7fa","service_time":1530417600,"service_title":"测试扫地","order_status":9,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221926277946","_id":"5b7d4863aa5f6b8137a07ed5","service_time":1530417600,"service_title":"测试扫地","order_status":8,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221926224077","_id":"5b7d485ea5a911813292f6e6","service_time":1530417600,"service_title":"测试扫地","order_status":7,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221926157684","_id":"5b7d48573e2163812eed8eb7","service_time":1530417600,"service_title":"测试扫地","order_status":6,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"2018822192693100","_id":"5b7d4851d57f778129e2f155","service_time":1530417600,"service_title":"测试扫地","order_status":5,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"2018822192633733","_id":"5b7d484b975f1881258732b8","service_time":1530417600,"service_title":"测试扫地","order_status":4,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221925578296","_id":"5b7d4845c8ffd2811f34b705","service_time":1530417600,"service_title":"测试扫地","order_status":3,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221925460814","_id":"5b7d483a01e017811ad9a5fc","service_time":1530417600,"service_title":"测试扫地","order_status":2,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221925272298","_id":"5b7d4827b41a098110024c5a","service_time":1530417600,"service_title":"测试扫地","order_status":1,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"2018821182314114","_id":"5b7be3370d5f0444f96c971e","service_time":1530417600,"service_title":"测试扫地","order_status":1,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"2018821182130900","_id":"5b7be32594166444f69d4ab3","service_time":1530417600,"service_title":"测试扫地","order_status":1,"order_pay_money":10,"over_order_time":""},{"service_logo":"http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg","ping_end_time":1598004103,"order_sn":"20188221926571925","_id":"5b7d488199e73581529e6106","service_time":1530417600,"service_title":"测试扫地","order_status":14,"order_pay_money":10,"over_order_time":""}]
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
             * service_logo : http://img3.imgtn.bdimg.com/it/u=1085482503,4263095848&fm=27&gp=0.jpg
             * ping_end_time : 1542970426
             * order_sn : 20188241622407714
             * _id : 5b7fc050f19107d8d7a4518d
             * service_time : 1534813200
             * service_title : 测试扫地2
             * order_status : 1
             * order_pay_money : 10
             * over_order_time : 1535100760
             */

            private String service_logo;
            private int ping_end_time;
            private String order_sn;
            private String _id;
            private int service_time;
            private String service_title;
            private int order_status;
            private float order_pay_money;
            private String over_order_time;

            public String getService_logo() {
                return service_logo;
            }

            public void setService_logo(String service_logo) {
                this.service_logo = service_logo;
            }

            public int getPing_end_time() {
                return ping_end_time;
            }

            public void setPing_end_time(int ping_end_time) {
                this.ping_end_time = ping_end_time;
            }

            public String getOrder_sn() {
                return order_sn;
            }

            public void setOrder_sn(String order_sn) {
                this.order_sn = order_sn;
            }

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public int getService_time() {
                return service_time;
            }

            public void setService_time(int service_time) {
                this.service_time = service_time;
            }

            public String getService_title() {
                return service_title;
            }

            public void setService_title(String service_title) {
                this.service_title = service_title;
            }

            public int getOrder_status() {
                return order_status;
            }

            public void setOrder_status(int order_status) {
                this.order_status = order_status;
            }

            public float getOrder_pay_money() {
                return order_pay_money;
            }

            public void setOrder_pay_money(float order_pay_money) {
                this.order_pay_money = order_pay_money;
            }

            public String getOver_order_time() {
                return over_order_time;
            }

            public void setOver_order_time(String over_order_time) {
                this.over_order_time = over_order_time;
            }
        }
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}

