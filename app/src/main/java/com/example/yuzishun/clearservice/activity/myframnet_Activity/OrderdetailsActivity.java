package com.example.yuzishun.clearservice.activity.myframnet_Activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.yuzishun.clearservice.Custom.MyScrollView;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.model.ConfimOrderBean;
import com.example.yuzishun.clearservice.model.OrderdetailsBean;
import com.example.yuzishun.clearservice.net.ApiMethods;
import com.example.yuzishun.clearservice.utils.CountDownUtils;
import com.example.yuzishun.clearservice.utils.TimeUtils;

import java.sql.Time;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class OrderdetailsActivity extends BaseActivity implements View.OnClickListener, MyScrollView.OnScrollListener {
    @BindView(R.id.look_service) Button look_service;
    @BindView(R.id.title_text) TextView title_text;
    @BindView(R.id.image_back) LinearLayout image_back;
    @BindView(R.id.layout_title) RelativeLayout layout_title;
    @BindView(R.id.scroll_view) MyScrollView scroll_view;
    @BindView(R.id.imagr_state) ImageView imagr_state;
    @BindView(R.id.text_state) TextView text_state;
    @BindView(R.id.text_toast) TextView text_toast;
    @BindView(R.id.time_pay) TextView time_pay;
    @BindView(R.id.pin)TextView pin;
    @BindView(R.id.image_service_people) ImageView image_service_people;
    @BindView(R.id.service_name) TextView service_name;
    @BindView(R.id.service_time) TextView service_time;
    @BindView(R.id.zong_money) TextView zong_money;
    @BindView(R.id.text_money_price) TextView text_money_price;
    @BindView(R.id.shipay) TextView shipay;
    @BindView(R.id.tel_xx) TextView tel_xx;
    @BindView(R.id.tel_name) TextView tel_name;
    @BindView(R.id.tel_phone) TextView tel_phone;
    @BindView(R.id.layout_tioa) LinearLayout layout_tioa;
    @BindView(R.id.hei_text) TextView hei_text;
    @BindView(R.id.layout_one)RelativeLayout layout_one;
    @BindView(R.id.layout_two)RelativeLayout layout_two;
    @BindView(R.id.layout_three)RelativeLayout layout_three;
    @BindView(R.id.layout_four)RelativeLayout layout_four;
    @BindView(R.id.layout_frie)RelativeLayout layout_frie;
    @BindView(R.id.layout_six)RelativeLayout layout_six;
    @BindView(R.id.layout_seven)RelativeLayout layout_seven;
    @BindView(R.id.layout_nine)RelativeLayout layout_nine;
    @BindView(R.id.layout_ant)RelativeLayout layout_ant;
    @BindView(R.id.layout_ten)RelativeLayout layout_ten;
    @BindView(R.id.layout_button)LinearLayout layout_button;
    @BindView(R.id.layout_button_delete)LinearLayout layout_button_delete;
    @BindView(R.id.layout_onetext)TextView layout_onetext;
    @BindView(R.id.layout_twotext) TextView layout_twotext;
    @BindView(R.id.layout_threetext)TextView layout_threetext;
    @BindView(R.id.layout_fourtext)TextView layout_fourtext;
    @BindView(R.id.layout_frietext)TextView layout_frietext;
    @BindView(R.id.layout_sixtext) TextView layout_sixtext;
    @BindView(R.id.layout_seventext) TextView layout_seventext;
    @BindView(R.id.layout_anttext) TextView layout_anttext;
    @BindView(R.id.layout_ninetext) TextView layout_ninetext;
    @BindView(R.id.layout_tentext) TextView layout_tentext;
    @BindView(R.id.image_two)ImageView image_two;@BindView(R.id.image_three)ImageView image_three;@BindView(R.id.image_four)ImageView image_four;@BindView(R.id.image_frie)ImageView image_frie;@BindView(R.id.image_six)ImageView image_six;
    @BindView(R.id.image_seven)ImageView image_seven;@BindView(R.id.image_ten)ImageView image_ten;
    @BindView(R.id.image_linetwo)TextView image_linetwo;@BindView(R.id.image_linethree)TextView image_linethree;@BindView(R.id.image_linefour)TextView image_linefour;@BindView(R.id.image_linefrie)TextView image_linefrie;@BindView(R.id.image_linesix)TextView image_linesix;
    @BindView(R.id.image_lineseven)TextView image_lineseven;
    @BindView(R.id.text_two)TextView text_two;@BindView(R.id.text_three)TextView text_three;@BindView(R.id.text_four)TextView text_four;@BindView(R.id.text_frie)TextView text_frie;@BindView(R.id.text_six)TextView text_six;@BindView(R.id.text_seven)TextView text_seven;
    @BindView(R.id.text_ant)TextView text_ant;
    @BindView(R.id.time_one)TextView time_one;@BindView(R.id.time_two)TextView time_two;@BindView(R.id.time_three)TextView time_three;@BindView(R.id.time_four)TextView time_four;@BindView(R.id.time_frie)TextView time_frie;@BindView(R.id.time_six)TextView time_six;@BindView(R.id.time_seven)TextView time_seven;
    @BindView(R.id.time_ant)TextView time_ant;
    @BindView(R.id.button_one_deilts)Button button_one_deilts;@BindView(R.id.button_two_deilts)Button button_two_deilts;@BindView(R.id.button_three_deilts)Button button_three_deilts;@BindView(R.id.button_four_deilts)Button button_four_deilts;
    @BindView(R.id.lauyout_visibity_one)RelativeLayout lauyout_visibity_one;@BindView(R.id.lauyout_visibity_two)RelativeLayout lauyout_visibity_two;@BindView(R.id.lauyout_visibity_three)RelativeLayout lauyout_visibity_three;
    @BindView(R.id.lauyout_visibity_four)RelativeLayout lauyout_visibity_four;
    @BindView(R.id.lauyout_visibity2_one)RelativeLayout lauyout_visibity2_one;@BindView(R.id.lauyout_visibity2_two)RelativeLayout lauyout_visibity2_two;@BindView(R.id.lauyout_visibity2_three)RelativeLayout lauyout_visibity2_three;
    @BindView(R.id.lauyout_visibity2_four)RelativeLayout lauyout_visibity2_four;
    private String id;

    @Override
    public int intiLayout() {
        return R.layout.activity_orderdetails;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
//
        title_text.setText("订单详情");
        initState();
        onclick();
        scroll_view.setScrolListener(this);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        newTel();

    }

    private void newTel() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("_id",id);
        Observer<OrderdetailsBean> observer = new Observer<OrderdetailsBean>() {
            @Override
            public void onSubscribe(Disposable d) {


            }

            @Override
            public void onNext(OrderdetailsBean orderdetailsBean) {

                Log.e("YZS", orderdetailsBean.toString());

                Log.e("YZS",orderdetailsBean.getMsg());
                Log.e("YZS",orderdetailsBean.getCode()+"");
                Log.e("YZS",orderdetailsBean.getData().toString()+"");

                if(orderdetailsBean.getCode()==200){
                    switch (orderdetailsBean.getData().getOrder_status()){
                        case 1:

                            Glide.with(OrderdetailsActivity.this).load(R.mipmap.pay_dai).into(imagr_state);
                            text_state.setText("待支付");
                            text_toast.setText("逾期未支付，订单将自动取消");
                            int ping_end_time1 = orderdetailsBean.getData().getOver_order_time();
                            long ping_ende1 = (int)ping_end_time1;
                            long current1 = System.currentTimeMillis()/1000;

                            if(ping_ende1<current1){
                                time_pay.setText("已到期");

                            }else {
                                new CountDownUtils(ping_ende1 - current1,time_pay).startCount();
                            }
                            Glide.with(OrderdetailsActivity.this).load(orderdetailsBean.getData().getService_id().getService_banner_img().get(0))
                                    .into(image_service_people);

                            service_name.setText(orderdetailsBean.getData().getService_id().getService_name());
                            //服务人员服务时间
                            int ping_begin_time = orderdetailsBean.getData().getService_time();
                            long ping_end = (int)ping_begin_time;
                            String pin_start = TimeUtils.milliseconds2String(ping_end*1000);
                            service_time.setText("服务时间:"+pin_start);


                            zong_money.setText("¥:"+orderdetailsBean.getData().getOrder_money());
                            text_money_price.setText("¥:"+orderdetailsBean.getData().getOrder_money());
                            shipay.setText("¥:"+orderdetailsBean.getData().getOrder_pay_money());
                            tel_xx.setText(orderdetailsBean.getData().getUser_address_id().getAddress_city()+orderdetailsBean.getData()
                            .getUser_address_id().getAddress_name()+orderdetailsBean.getData().getUser_address_id().getAddress_info());
                            tel_name.setText(orderdetailsBean.getData().getUser_address_id().getUser_name());
                            tel_phone.setText(orderdetailsBean.getData().getUser_address_id().getMobile_phone());
                            hei_text.setVisibility(View.GONE);
                            layout_tioa.setVisibility(View.GONE);
                            layout_onetext.setText("订单编号:       "+orderdetailsBean.getData().getOrder_sn());
                            layout_two.setVisibility(View.GONE);
                            //下单时间
                            int order_time = orderdetailsBean.getData().getOrder_time();
                            long orderTime = (int)order_time;
                            String ordertime = TimeUtils.milliseconds2String(orderTime*1000);
                            layout_threetext.setText("下单编号:       "+ordertime);
                            layout_four.setVisibility(View.GONE);
                            layout_frie.setVisibility(View.GONE);
                            layout_six.setVisibility(View.GONE);
                            layout_seven.setVisibility(View.GONE);
                            layout_ant.setVisibility(View.GONE);
                            layout_nine.setVisibility(View.GONE);
                            layout_ten.setVisibility(View.GONE);
                            layout_button_delete.setVisibility(View.GONE);
                            break;
                        case 2:

                            Glide.with(OrderdetailsActivity.this).load(R.mipmap.nosucess).into(imagr_state);
                            text_state.setText("订单已取消");
                            text_toast.setVisibility(View.GONE);
                            time_pay.setVisibility(View.GONE);

                            Glide.with(OrderdetailsActivity.this).load(orderdetailsBean.getData().getService_id().getService_banner_img().get(0))
                                    .into(image_service_people);
                            pin.setVisibility(View.GONE);
                            service_name.setText(orderdetailsBean.getData().getService_id().getService_name());
                            //服务人员服务时间
                            int ping_begin_time2 = orderdetailsBean.getData().getService_time();
                            long ping_end2 = (int)ping_begin_time2;
                            String pin_start2 = TimeUtils.milliseconds2String(ping_end2*1000);
                            service_time.setText("服务时间:"+pin_start2);


                            zong_money.setText("¥:"+orderdetailsBean.getData().getOrder_money());
                            text_money_price.setText("¥:"+orderdetailsBean.getData().getOrder_money());
                            shipay.setText("¥:"+orderdetailsBean.getData().getOrder_pay_money());
                            tel_xx.setText(orderdetailsBean.getData().getUser_address_id().getAddress_city()+orderdetailsBean.getData()
                                    .getUser_address_id().getAddress_name()+orderdetailsBean.getData().getUser_address_id().getAddress_info());
                            tel_name.setText(orderdetailsBean.getData().getUser_address_id().getUser_name());
                            tel_phone.setText(orderdetailsBean.getData().getUser_address_id().getMobile_phone());
                            hei_text.setVisibility(View.GONE);
                            layout_tioa.setVisibility(View.GONE);
                            layout_onetext.setText("订单编号:       "+orderdetailsBean.getData().getOrder_sn());
                            layout_two.setVisibility(View.GONE);
                            //下单时间
                            int order_time2 = orderdetailsBean.getData().getOrder_time();
                            long orderTime2 = (int)order_time2;
                            String ordertime2 = TimeUtils.milliseconds2String(orderTime2*1000);
                            layout_threetext.setText("下单编号:       "+ordertime2);
                            layout_four.setVisibility(View.GONE);
                            layout_frie.setVisibility(View.GONE);
                            layout_six.setVisibility(View.GONE);
                            layout_seven.setVisibility(View.GONE);
                            layout_ant.setVisibility(View.GONE);
                            layout_nine.setVisibility(View.GONE);
                            layout_ten.setVisibility(View.GONE);
                            layout_button.setVisibility(View.GONE);
                            layout_button_delete.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            Glide.with(OrderdetailsActivity.this).load(R.mipmap.pay_dai).into(imagr_state);
                            text_state.setText("待成团");

                            int number_pin = orderdetailsBean.getData().getService_id().getPing_number()-orderdetailsBean.getData().getService_id().getHave_ping_number();

                            text_toast.setText("已参团"+orderdetailsBean.getData().getService_id().getHave_ping_number()+"人,还差"+number_pin+"人");
                            int ping_end_time3 = orderdetailsBean.getData().getService_id().getPing_end_time();
                            long ping_ende3 = (int)ping_end_time3;
                            long current3 = System.currentTimeMillis()/1000;

                            if(ping_ende3<current3){
                                time_pay.setText("已到期");

                            }else {
                                new CountDownUtils(ping_ende3 - current3,time_pay).startCount();
                            }
                            Glide.with(OrderdetailsActivity.this).load(orderdetailsBean.getData().getService_id().getService_banner_img().get(0))
                                    .into(image_service_people);

                            service_name.setText(orderdetailsBean.getData().getService_id().getService_name());
                            //服务人员服务时间
                            int ping_begin_time3 = orderdetailsBean.getData().getService_time();
                            long ping_end3 = (int)ping_begin_time3;
                            String pin_start3 = TimeUtils.milliseconds2String(ping_end3*1000);
                            service_time.setText("服务时间:"+pin_start3);


                            zong_money.setText("¥:"+orderdetailsBean.getData().getOrder_money());
                            text_money_price.setText("¥:"+orderdetailsBean.getData().getOrder_money());
                            shipay.setText("¥:"+orderdetailsBean.getData().getOrder_pay_money());
                            tel_xx.setText(orderdetailsBean.getData().getUser_address_id().getAddress_city()+orderdetailsBean.getData()
                                    .getUser_address_id().getAddress_name()+orderdetailsBean.getData().getUser_address_id().getAddress_info());
                            tel_name.setText(orderdetailsBean.getData().getUser_address_id().getUser_name());
                            tel_phone.setText(orderdetailsBean.getData().getUser_address_id().getMobile_phone());
                            layout_onetext.setText("订单编号:       "+orderdetailsBean.getData().getOrder_sn());
                            //下单时间
                            int order_time3 = orderdetailsBean.getData().getOrder_time();
                            long orderTime3 = (int)order_time3;
                            String ordertime3 = TimeUtils.milliseconds2String(orderTime3*1000);
                            layout_threetext.setText("下单编号:       "+ordertime3);
                            if(orderdetailsBean.getData().getOrder_pay_type()==1){

                                layout_twotext.setText("支付方式:       支付宝");

                            }else {
                                layout_twotext.setText("支付方式:       微信");

                            }
                            int pay_time = orderdetailsBean.getData().getPay_time();
                            Log.e("YZS",orderdetailsBean.getData().getPay_time()+"");
                            long pay_Time = (int)pay_time;
                            String paytime = TimeUtils.milliseconds2String(pay_Time*1000);

                            layout_fourtext.setText("支付时间:       "+paytime);
                            layout_frie.setVisibility(View.GONE);
                            layout_six.setVisibility(View.GONE);
                            layout_seven.setVisibility(View.GONE);
                            layout_ant.setVisibility(View.GONE);
                            layout_nine.setVisibility(View.GONE);
                            layout_ten.setVisibility(View.GONE);
                            layout_button.setVisibility(View.GONE);
                            layout_button_delete.setVisibility(View.GONE);
                            time_one.setText(paytime);

                            break;
                        case 4:

                            Glide.with(OrderdetailsActivity.this).load(R.mipmap.right_deilts).into(imagr_state);
                            text_state.setText("待服务");


                            text_toast.setText("拼团成功,待服务人员上门");

                                time_pay.setVisibility(View.GONE);


                            Glide.with(OrderdetailsActivity.this).load(orderdetailsBean.getData().getService_id().getService_banner_img().get(0))
                                    .into(image_service_people);

                            service_name.setText(orderdetailsBean.getData().getService_id().getService_name());
                            //服务人员服务时间
                            int ping_begin_time4 = orderdetailsBean.getData().getService_time();
                            long ping_end4 = (int)ping_begin_time4;
                            String pin_start4 = TimeUtils.milliseconds2String(ping_end4*1000);
                            service_time.setText("服务时间:"+pin_start4);


                            zong_money.setText("¥:"+orderdetailsBean.getData().getOrder_money());
                            text_money_price.setText("¥:"+orderdetailsBean.getData().getOrder_money());
                            shipay.setText("¥:"+orderdetailsBean.getData().getOrder_pay_money());
                            tel_xx.setText(orderdetailsBean.getData().getUser_address_id().getAddress_city()+orderdetailsBean.getData()
                                    .getUser_address_id().getAddress_name()+orderdetailsBean.getData().getUser_address_id().getAddress_info());
                            tel_name.setText(orderdetailsBean.getData().getUser_address_id().getUser_name());
                            tel_phone.setText(orderdetailsBean.getData().getUser_address_id().getMobile_phone());
                            layout_onetext.setText("订单编号:       "+orderdetailsBean.getData().getOrder_sn());
                            //下单时间
                            int order_time4 = orderdetailsBean.getData().getOrder_time();
                            long orderTime4 = (int)order_time4;
                            String ordertime4 = TimeUtils.milliseconds2String(orderTime4*1000);
                            layout_threetext.setText("下单编号:       "+ordertime4);
                            if(orderdetailsBean.getData().getOrder_pay_type()==1){

                                layout_twotext.setText("支付方式:       支付宝");

                            }else {
                                layout_twotext.setText("支付方式:       微信");

                            }
                            int pay_time4 = orderdetailsBean.getData().getPay_time();
                            long pay_Time4 = (int)pay_time4;
                            String paytime4 = TimeUtils.milliseconds2String(pay_Time4*1000);

                            layout_fourtext.setText("支付时间:       "+paytime4);
                            layout_six.setVisibility(View.GONE);
                            layout_seven.setVisibility(View.GONE);
                            layout_ant.setVisibility(View.GONE);
                            layout_nine.setVisibility(View.GONE);
                            layout_ten.setVisibility(View.GONE);
                            layout_button.setVisibility(View.GONE);
                            layout_button_delete.setVisibility(View.GONE);
                            time_one.setText(paytime4);
                            time_two.setVisibility(View.VISIBLE);
                            int pin_time4 = orderdetailsBean.getData().getPing_time();
                            long pin_Time4 = (int)pin_time4;
                            String pintime4 = TimeUtils.milliseconds2String(pin_Time4*1000);
                            layout_frietext.setText("成团时间:       "+pintime4);
                            time_two.setText(pin_time4+"");
                            time_two.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
                            text_two.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
                            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_two);
                            image_linetwo.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));


                            break;
                        case 6:
                            Glide.with(OrderdetailsActivity.this).load(R.mipmap.pay_dai).into(imagr_state);
                            text_state.setText("拼团失败，退款中");
                            text_toast.setVisibility(View.GONE);


                            time_pay.setVisibility(View.GONE);

                            pin.setVisibility(View.GONE);
                            Glide.with(OrderdetailsActivity.this).load(orderdetailsBean.getData().getService_id().getService_banner_img().get(0))
                                    .into(image_service_people);

                            service_name.setText(orderdetailsBean.getData().getService_id().getService_name());
                            //服务人员服务时间
                            int ping_begin_time6 = orderdetailsBean.getData().getService_time();
                            long ping_end6 = (int)ping_begin_time6;
                            String pin_start6 = TimeUtils.milliseconds2String(ping_end6*1000);
                            service_time.setText("服务时间:"+pin_start6);


                            zong_money.setText("¥:"+orderdetailsBean.getData().getOrder_money());
                            text_money_price.setText("¥:"+orderdetailsBean.getData().getOrder_money());
                            shipay.setText("¥:"+orderdetailsBean.getData().getOrder_pay_money());
                            tel_xx.setText(orderdetailsBean.getData().getUser_address_id().getAddress_city()+orderdetailsBean.getData()
                                    .getUser_address_id().getAddress_name()+orderdetailsBean.getData().getUser_address_id().getAddress_info());
                            tel_name.setText(orderdetailsBean.getData().getUser_address_id().getUser_name());
                            tel_phone.setText(orderdetailsBean.getData().getUser_address_id().getMobile_phone());
                            hei_text.setVisibility(View.GONE);
                            layout_tioa.setVisibility(View.GONE);
                            layout_onetext.setText("订单编号:       "+orderdetailsBean.getData().getOrder_sn());
                            //下单时间
                            int order_time6 = orderdetailsBean.getData().getOrder_time();
                            long orderTime6 = (int)order_time6;
                            String ordertime6 = TimeUtils.milliseconds2String(orderTime6*1000);
                            layout_threetext.setText("下单编号:       "+ordertime6);
                            layout_frie.setVisibility(View.GONE);
                            layout_six.setVisibility(View.GONE);
                            layout_seven.setVisibility(View.GONE);
                            layout_ant.setVisibility(View.GONE);
                            layout_nine.setVisibility(View.GONE);
                            layout_ten.setVisibility(View.GONE);
                            layout_button_delete.setVisibility(View.GONE);
                            if(orderdetailsBean.getData().getOrder_pay_type()==1){

                                layout_twotext.setText("支付方式:       支付宝");

                            }else {
                                layout_twotext.setText("支付方式:       微信");

                            }
                            int pay_time6 = orderdetailsBean.getData().getPay_time();
                            long pay_Time6 = (int)pay_time6;
                            String paytime6 = TimeUtils.milliseconds2String(pay_Time6*1000);

                            layout_fourtext.setText("支付时间:       "+paytime6);
                            layout_button.setVisibility(View.GONE);
                            layout_button_delete.setVisibility(View.GONE);



                            break;
                        case 7:
                            Glide.with(OrderdetailsActivity.this).load(R.mipmap.nosucess).into(imagr_state);
                            text_state.setText("拼团失败，退款失败");
                            text_toast.setText("由于系统原因,退款失败,系统正紧急处理,如有疑问请拨打下方电话进行咨询");
                            time_pay.setVisibility(View.GONE);

                            pin.setVisibility(View.GONE);
                            Glide.with(OrderdetailsActivity.this).load(orderdetailsBean.getData().getService_id().getService_banner_img().get(0))
                                    .into(image_service_people);

                            service_name.setText(orderdetailsBean.getData().getService_id().getService_name());
                            //服务人员服务时间
                            int ping_begin_time7 = orderdetailsBean.getData().getService_time();
                            long ping_end7 = (int)ping_begin_time7;
                            String pin_start7 = TimeUtils.milliseconds2String(ping_end7*1000);
                            service_time.setText("服务时间:"+pin_start7);


                            zong_money.setText("¥:"+orderdetailsBean.getData().getOrder_money());
                            text_money_price.setText("¥:"+orderdetailsBean.getData().getOrder_money());
                            shipay.setText("¥:"+orderdetailsBean.getData().getOrder_pay_money());
                            tel_xx.setText(orderdetailsBean.getData().getUser_address_id().getAddress_city()+orderdetailsBean.getData()
                                    .getUser_address_id().getAddress_name()+orderdetailsBean.getData().getUser_address_id().getAddress_info());
                            tel_name.setText(orderdetailsBean.getData().getUser_address_id().getUser_name());
                            tel_phone.setText(orderdetailsBean.getData().getUser_address_id().getMobile_phone());
                            hei_text.setVisibility(View.GONE);
                            layout_tioa.setVisibility(View.GONE);
                            layout_onetext.setText("订单编号:       "+orderdetailsBean.getData().getOrder_sn());
                            //下单时间
                            int order_time7 = orderdetailsBean.getData().getOrder_time();
                            long orderTime7 = (int)order_time7;
                            String ordertime7 = TimeUtils.milliseconds2String(orderTime7*1000);
                            layout_threetext.setText("下单编号:       "+ordertime7);
                            layout_frie.setVisibility(View.GONE);
                            layout_six.setVisibility(View.GONE);
                            layout_seven.setVisibility(View.GONE);
                            layout_ant.setVisibility(View.GONE);
                            layout_nine.setVisibility(View.GONE);
                            layout_ten.setVisibility(View.GONE);
                            layout_button_delete.setVisibility(View.GONE);
                            if(orderdetailsBean.getData().getOrder_pay_type()==1){

                                layout_twotext.setText("支付方式:       支付宝");

                            }else {
                                layout_twotext.setText("支付方式:       微信");

                            }
                            int pay_time7 = orderdetailsBean.getData().getPay_time();
                            long pay_Time7 = (int)pay_time7;
                            String paytime7 = TimeUtils.milliseconds2String(pay_Time7*1000);

                            layout_fourtext.setText("支付时间:       "+paytime7);
                            layout_button.setVisibility(View.GONE);
                            layout_button_delete.setVisibility(View.GONE);
                            break;

                        case 8:
                            Glide.with(OrderdetailsActivity.this).load(R.mipmap.right_deilts).into(imagr_state);
                            text_state.setText("拼团失败，退款成功");
                            text_toast.setText("退款金额:¥:"+orderdetailsBean.getData().getOrder_pay_money());


                            time_pay.setVisibility(View.GONE);

                            pin.setVisibility(View.GONE);
                            Glide.with(OrderdetailsActivity.this).load(orderdetailsBean.getData().getService_id().getService_banner_img().get(0))
                                    .into(image_service_people);

                            service_name.setText(orderdetailsBean.getData().getService_id().getService_name());
                            //服务人员服务时间
                            int ping_begin_time8 = orderdetailsBean.getData().getService_time();
                            long ping_end8 = (int)ping_begin_time8;
                            String pin_start8 = TimeUtils.milliseconds2String(ping_end8*1000);
                            service_time.setText("服务时间:"+pin_start8);


                            zong_money.setText("¥:"+orderdetailsBean.getData().getOrder_money());
                            text_money_price.setText("¥:"+orderdetailsBean.getData().getOrder_money());
                            shipay.setText("¥:"+orderdetailsBean.getData().getOrder_pay_money());
                            tel_xx.setText(orderdetailsBean.getData().getUser_address_id().getAddress_city()+orderdetailsBean.getData()
                                    .getUser_address_id().getAddress_name()+orderdetailsBean.getData().getUser_address_id().getAddress_info());
                            tel_name.setText(orderdetailsBean.getData().getUser_address_id().getUser_name());
                            tel_phone.setText(orderdetailsBean.getData().getUser_address_id().getMobile_phone());
                            hei_text.setVisibility(View.GONE);
                            layout_tioa.setVisibility(View.GONE);
                            layout_onetext.setText("订单编号:       "+orderdetailsBean.getData().getOrder_sn());
                            //下单时间
                            int order_time8 = orderdetailsBean.getData().getOrder_time();
                            long orderTime8 = (int)order_time8;
                            String ordertime8 = TimeUtils.milliseconds2String(orderTime8*1000);
                            layout_threetext.setText("下单编号:       "+ordertime8);
                            layout_frie.setVisibility(View.GONE);
                            layout_six.setVisibility(View.GONE);
                            layout_seven.setVisibility(View.GONE);
                            layout_ant.setVisibility(View.GONE);
                            layout_nine.setVisibility(View.GONE);
                            layout_ten.setVisibility(View.GONE);
                            if(orderdetailsBean.getData().getOrder_pay_type()==1){

                                layout_twotext.setText("支付方式:       支付宝");

                            }else {
                                layout_twotext.setText("支付方式:       微信");

                            }
                            int pay_time8 = orderdetailsBean.getData().getPay_time();
                            long pay_Time8 = (int)pay_time8;
                            String paytime8 = TimeUtils.milliseconds2String(pay_Time8*1000);

                            layout_fourtext.setText("支付时间:       "+paytime8);
                            layout_button.setVisibility(View.GONE);
                            break;
                        case 9:
                            Glide.with(OrderdetailsActivity.this).load(R.mipmap.right_deilts).into(imagr_state);
                            text_state.setText("待服务");


                            text_toast.setText("拼团成功,待服务人员上门");

                            time_pay.setVisibility(View.GONE);


                            Glide.with(OrderdetailsActivity.this).load(orderdetailsBean.getData().getService_id().getService_banner_img().get(0))
                                    .into(image_service_people);

                            service_name.setText(orderdetailsBean.getData().getService_id().getService_name());
                            //服务人员服务时间
                            int ping_begin_time9 = orderdetailsBean.getData().getService_time();
                            long ping_end9 = (int)ping_begin_time9;
                            String pin_start9 = TimeUtils.milliseconds2String(ping_end9*1000);
                            service_time.setText("服务时间:"+pin_start9);


                            zong_money.setText("¥:"+orderdetailsBean.getData().getOrder_money());
                            text_money_price.setText("¥:"+orderdetailsBean.getData().getOrder_money());
                            shipay.setText("¥:"+orderdetailsBean.getData().getOrder_pay_money());
                            tel_xx.setText(orderdetailsBean.getData().getUser_address_id().getAddress_city()+orderdetailsBean.getData()
                                    .getUser_address_id().getAddress_name()+orderdetailsBean.getData().getUser_address_id().getAddress_info());
                            tel_name.setText(orderdetailsBean.getData().getUser_address_id().getUser_name());
                            tel_phone.setText(orderdetailsBean.getData().getUser_address_id().getMobile_phone());
                            layout_onetext.setText("订单编号:       "+orderdetailsBean.getData().getOrder_sn());
                            //下单时间
                            int order_time9 = orderdetailsBean.getData().getOrder_time();
                            long orderTime9 = (int)order_time9;
                            String ordertime9 = TimeUtils.milliseconds2String(orderTime9*1000);
                            layout_threetext.setText("下单编号:       "+ordertime9);
                            if(orderdetailsBean.getData().getOrder_pay_type()==1){

                                layout_twotext.setText("支付方式:       支付宝");

                            }else {
                                layout_twotext.setText("支付方式:       微信");

                            }
                            int pay_time9 = orderdetailsBean.getData().getPay_time();
                            long pay_Time9 = (int)pay_time9;
                            String paytime9 = TimeUtils.milliseconds2String(pay_Time9*1000);

                            layout_fourtext.setText("支付时间:       "+paytime9);
                            layout_six.setVisibility(View.GONE);
                            layout_seven.setVisibility(View.GONE);
                            layout_ant.setVisibility(View.GONE);
                            layout_nine.setVisibility(View.GONE);
                            layout_ten.setVisibility(View.GONE);
                            layout_button.setVisibility(View.GONE);
                            layout_button_delete.setVisibility(View.GONE);
                            time_one.setText(paytime9);
                            time_two.setVisibility(View.VISIBLE);
                            int pin_time9 = orderdetailsBean.getData().getPing_time();
                            long pin_Time9 = (int)pin_time9;
                            String pintime9 = TimeUtils.milliseconds2String(pin_Time9*1000);
                            layout_frietext.setText("成团时间:       "+pintime9);
                            time_two.setText(pin_time9+"");
                            time_two.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
                            text_two.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
                            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_two);
                            image_linetwo.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
                            break;
                        case 10:
                            Glide.with(OrderdetailsActivity.this).load(R.mipmap.right_deilts).into(imagr_state);
                            text_state.setText("待服务");


                            text_toast.setText("拼团成功,待服务人员上门");

                            time_pay.setVisibility(View.GONE);


                            Glide.with(OrderdetailsActivity.this).load(orderdetailsBean.getData().getService_id().getService_banner_img().get(0))
                                    .into(image_service_people);

                            service_name.setText(orderdetailsBean.getData().getService_id().getService_name());
                            //服务人员服务时间
                            int ping_begin_time10 = orderdetailsBean.getData().getService_time();
                            long ping_end10 = (int)ping_begin_time10;
                            String pin_start10 = TimeUtils.milliseconds2String(ping_end10*1000);
                            service_time.setText("服务时间:"+pin_start10);


                            zong_money.setText("¥:"+orderdetailsBean.getData().getOrder_money());
                            text_money_price.setText("¥:"+orderdetailsBean.getData().getOrder_money());
                            shipay.setText("¥:"+orderdetailsBean.getData().getOrder_pay_money());
                            tel_xx.setText(orderdetailsBean.getData().getUser_address_id().getAddress_city()+orderdetailsBean.getData()
                                    .getUser_address_id().getAddress_name()+orderdetailsBean.getData().getUser_address_id().getAddress_info());
                            tel_name.setText(orderdetailsBean.getData().getUser_address_id().getUser_name());
                            tel_phone.setText(orderdetailsBean.getData().getUser_address_id().getMobile_phone());
                            layout_onetext.setText("订单编号:       "+orderdetailsBean.getData().getOrder_sn());
                            //下单时间
                            int order_time10 = orderdetailsBean.getData().getOrder_time();
                            long orderTime10 = (int)order_time10;
                            String ordertime10 = TimeUtils.milliseconds2String(orderTime10*1000);
                            layout_threetext.setText("下单编号:       "+ordertime10);
                            if(orderdetailsBean.getData().getOrder_pay_type()==1){

                                layout_twotext.setText("支付方式:       支付宝");

                            }else {
                                layout_twotext.setText("支付方式:       微信");

                            }
                            int pay_time10 = orderdetailsBean.getData().getPay_time();
                            long pay_Time10 = (int)pay_time10;
                            String paytime10 = TimeUtils.milliseconds2String(pay_Time10*1000);

                            layout_fourtext.setText("支付时间:       "+paytime10);
                            layout_six.setVisibility(View.GONE);
                            layout_seven.setVisibility(View.GONE);
                            layout_ant.setVisibility(View.GONE);
                            layout_nine.setVisibility(View.GONE);
                            layout_ten.setVisibility(View.GONE);
                            layout_button.setVisibility(View.GONE);
                            layout_button_delete.setVisibility(View.GONE);
                            time_one.setText(paytime10);
                            time_two.setVisibility(View.VISIBLE);
                            int pin_time10 = orderdetailsBean.getData().getPing_time();
                            long pin_Time10 = (int)pin_time10;
                            String pintime10 = TimeUtils.milliseconds2String(pin_Time10*1000);
                            layout_frietext.setText("成团时间:       "+pintime10);
                            time_two.setText(pin_time10+"");
                            time_two.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
                            text_two.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
                            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_two);
                            image_linetwo.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));

                            break;
                        case 11:
                            servicefinishcomp(orderdetailsBean);


                            break;
                        case 12:
                            servicefinishcomp(orderdetailsBean);

                            break;
                        case 13:
                            servicefinish(orderdetailsBean);

                            break;
                        case 14:
                            servicefinish2(orderdetailsBean);

                            break;
                        case 15:
                            servicefinish15(orderdetailsBean);
                            break;
                    }


                }else {
                    Toast.makeText(OrderdetailsActivity.this, orderdetailsBean.getMsg()+"", Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onError(Throwable e) {

                Log.e("YZS",e.getMessage()+"");
            }

            @Override
            public void onComplete() {

            }
        };

        ApiMethods.getOrderDeils(observer,hashMap);

        Log.e("YZS",hashMap.toString()+"");


    }

    private void onclick() {
        image_back.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:
                finish();
                break;
        }
    }
    private void initState() {
        if(Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            //取消设置透明状态栏,使 ContentView 内容不再沉浸到状态栏下
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.setStatusBarColor(getResources().getColor(R.color.blue2));
        }
    }

    @Override
    public void onScroll(int scrollY) {

    }

    public void servicefinishcomp(final OrderdetailsBean orderdetailsBean){
        Glide.with(OrderdetailsActivity.this).load(R.mipmap.pay_dai).into(imagr_state);
        text_state.setText("待服务");

        look_service.setVisibility(View.VISIBLE);

        text_toast.setText("请校验人员身份并确认服务人员上门");

        time_pay.setVisibility(View.GONE);


        Glide.with(OrderdetailsActivity.this).load(orderdetailsBean.getData().getService_id().getService_banner_img().get(0))
                .into(image_service_people);

        service_name.setText(orderdetailsBean.getData().getService_id().getService_name());
        //服务人员服务时间
        int ping_begin_time11 = orderdetailsBean.getData().getService_time();
        long ping_end11 = (int)ping_begin_time11;
        String pin_start11 = TimeUtils.milliseconds2String(ping_end11*1000);
        service_time.setText("服务时间:"+pin_start11);


        zong_money.setText("¥:"+orderdetailsBean.getData().getOrder_money());
        text_money_price.setText("¥:"+orderdetailsBean.getData().getOrder_money());
        shipay.setText("¥:"+orderdetailsBean.getData().getOrder_pay_money());
        tel_xx.setText(orderdetailsBean.getData().getUser_address_id().getAddress_city()+orderdetailsBean.getData()
                .getUser_address_id().getAddress_name()+orderdetailsBean.getData().getUser_address_id().getAddress_info());
        tel_name.setText(orderdetailsBean.getData().getUser_address_id().getUser_name());
        tel_phone.setText(orderdetailsBean.getData().getUser_address_id().getMobile_phone());
        layout_onetext.setText("订单编号:       "+orderdetailsBean.getData().getOrder_sn());
        //下单时间
        int order_time11 = orderdetailsBean.getData().getOrder_time();
        long orderTime11 = (int)order_time11;
        String ordertime11 = TimeUtils.milliseconds2String(orderTime11*1000);
        layout_threetext.setText("下单编号:       "+ordertime11);
        if(orderdetailsBean.getData().getOrder_pay_type()==1){

            layout_twotext.setText("支付方式:       支付宝");

        }else {
            layout_twotext.setText("支付方式:       微信");

        }
        int pay_time11 = orderdetailsBean.getData().getPay_time();
        Log.e("YZS",orderdetailsBean.getData().getPay_time()+"");
        long pay_Time11 = (int)pay_time11;
        String paytime11 = TimeUtils.milliseconds2String(pay_Time11*1000);
        time_two.setVisibility(View.VISIBLE);
        time_three.setVisibility(View.VISIBLE);
        layout_fourtext.setText("支付时间:       "+paytime11);
        layout_ten.setVisibility(View.GONE);
        layout_button.setVisibility(View.GONE);
        layout_button_delete.setVisibility(View.GONE);
        time_one.setText(paytime11);
        int pin_time11 = orderdetailsBean.getData().getPing_time();
        long pin_Time11 = (int)pin_time11;
        String pintime11 = TimeUtils.milliseconds2String(pin_Time11*1000);
        layout_frietext.setText("成团时间:       "+pintime11);
        int servicegomen_time11 = orderdetailsBean.getData().getService_personal_confirm_visit_time();
        long servicegomen_Time11 = (int)servicegomen_time11;
        String servicegomentime11 = TimeUtils.milliseconds2String(servicegomen_Time11*1000);
        layout_sixtext.setText("上门时间:       "+servicegomentime11);
        time_two.setText(pin_time11+"");
        time_two.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
        text_two.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
        Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_two);
        image_linetwo.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        time_three.setText(servicegomentime11+"");
        time_three.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
        text_three.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
        Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_three);
        image_linethree.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        button_one_deilts.setEnabled(true);
        button_two_deilts.setEnabled(true);
        button_three_deilts.setEnabled(true);
        button_four_deilts.setEnabled(true);
        button_two_deilts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suremen(orderdetailsBean.getData().get_id(),1);
            }
        });
        button_three_deilts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sureService(orderdetailsBean.getData().get_id(),3);
            }
        });
        button_four_deilts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sureServiceFinish(orderdetailsBean.getData().get_id(),4);

            }
        });
        button_one_deilts.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        button_two_deilts.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        button_three_deilts.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        button_four_deilts.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        layout_nine.setVisibility(View.GONE);
        if(orderdetailsBean.getData().getUser_have_confim_identity_time()==0){
            layout_seven.setVisibility(View.GONE);


        }else {
            layout_seven.setVisibility(View.VISIBLE);
            int confim_identity_time11 = orderdetailsBean.getData().getUser_have_confim_identity_time();
            long confimidentity_Time11 = (int)confim_identity_time11;
            String confimidentitytime11 = TimeUtils.milliseconds2String(confimidentity_Time11*1000);
            layout_seventext.setText("校验时间:       "+confimidentitytime11+"");
            lauyout_visibity_one.setVisibility(View.VISIBLE);
            lauyout_visibity2_one.setVisibility(View.GONE);
            time_four.setVisibility(View.VISIBLE);
            time_four.setText(confimidentitytime11+"");
            time_four.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            text_four.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_four);
            image_linefour.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));

        }
        if(orderdetailsBean.getData().getUser_confim_service_personal_time()==0){
            layout_ant.setVisibility(View.GONE);


        }else {

            layout_ant.setVisibility(View.VISIBLE);
            int user_confim_service_personal_time = orderdetailsBean.getData().getUser_confim_service_personal_time();
            long userconfim_service_time = (int)user_confim_service_personal_time;
            String userconfimService = TimeUtils.milliseconds2String(userconfim_service_time*1000);
            layout_anttext.setText("确认上门时间:       "+userconfimService);
            lauyout_visibity2_two.setVisibility(View.GONE);
            lauyout_visibity_two.setVisibility(View.VISIBLE);
            time_frie.setVisibility(View.VISIBLE);
            time_frie.setText(userconfimService+"");
            time_frie.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            text_frie.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_frie);
            image_linefrie.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));

        }
        if(orderdetailsBean.getData().getUser_confim_start_service_time()==0){
            layout_nine.setVisibility(View.GONE);


        }else {

            layout_nine.setVisibility(View.VISIBLE);
            int start_service_time = orderdetailsBean.getData().getUser_confim_start_service_time();
            long startservice_time = (int)start_service_time;
            String startservicetime = TimeUtils.milliseconds2String(startservice_time*1000);
            layout_ninetext.setText("开始服务时间:       "+startservicetime);
            lauyout_visibity2_three.setVisibility(View.GONE);
            lauyout_visibity_three.setVisibility(View.VISIBLE);
            time_six.setVisibility(View.VISIBLE);
            time_six.setText(startservicetime+"");
            time_six.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            text_six.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_six);
            image_linesix.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));

        }
        if(orderdetailsBean.getData().getUser_confim_complete_service_time()==0){
            layout_ten.setVisibility(View.GONE);


        }else {

            layout_ten.setVisibility(View.VISIBLE);
            int complete_service_time = orderdetailsBean.getData().getUser_confim_complete_service_time();
            long completeservice_time = (int)complete_service_time;
            String completeservicetime = TimeUtils.milliseconds2String(completeservice_time*1000);
            layout_tentext.setText("服务完成时间:       "+completeservicetime);
            lauyout_visibity2_four.setVisibility(View.GONE);
            lauyout_visibity_four.setVisibility(View.VISIBLE);
            time_seven.setVisibility(View.VISIBLE);
            time_seven.setText(completeservicetime+"");
            time_seven.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            text_seven.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_seven);
            image_lineseven.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));

        }





    }

    public void servicefinish(final OrderdetailsBean orderdetailsBean){
        Glide.with(OrderdetailsActivity.this).load(R.mipmap.pay_dai).into(imagr_state);
        text_state.setText("服务中");

        look_service.setVisibility(View.VISIBLE);

        text_toast.setText("服务人员正在进行服务");

        time_pay.setVisibility(View.GONE);


        Glide.with(OrderdetailsActivity.this).load(orderdetailsBean.getData().getService_id().getService_banner_img().get(0))
                .into(image_service_people);

        service_name.setText(orderdetailsBean.getData().getService_id().getService_name());
        //服务人员服务时间
        int ping_begin_time11 = orderdetailsBean.getData().getService_time();
        long ping_end11 = (int)ping_begin_time11;
        String pin_start11 = TimeUtils.milliseconds2String(ping_end11*1000);
        service_time.setText("服务时间:"+pin_start11);


        zong_money.setText("¥:"+orderdetailsBean.getData().getOrder_money());
        text_money_price.setText("¥:"+orderdetailsBean.getData().getOrder_money());
        shipay.setText("¥:"+orderdetailsBean.getData().getOrder_pay_money());
        tel_xx.setText(orderdetailsBean.getData().getUser_address_id().getAddress_city()+orderdetailsBean.getData()
                .getUser_address_id().getAddress_name()+orderdetailsBean.getData().getUser_address_id().getAddress_info());
        tel_name.setText(orderdetailsBean.getData().getUser_address_id().getUser_name());
        tel_phone.setText(orderdetailsBean.getData().getUser_address_id().getMobile_phone());
        layout_onetext.setText("订单编号:       "+orderdetailsBean.getData().getOrder_sn());
        //下单时间
        int order_time11 = orderdetailsBean.getData().getOrder_time();
        long orderTime11 = (int)order_time11;
        String ordertime11 = TimeUtils.milliseconds2String(orderTime11*1000);
        layout_threetext.setText("下单编号:       "+ordertime11);
        if(orderdetailsBean.getData().getOrder_pay_type()==1){

            layout_twotext.setText("支付方式:       支付宝");

        }else {
            layout_twotext.setText("支付方式:       微信");

        }
        int pay_time11 = orderdetailsBean.getData().getPay_time();
        Log.e("YZS",orderdetailsBean.getData().getPay_time()+"");
        long pay_Time11 = (int)pay_time11;
        String paytime11 = TimeUtils.milliseconds2String(pay_Time11*1000);
        time_two.setVisibility(View.VISIBLE);
        time_three.setVisibility(View.VISIBLE);
        layout_fourtext.setText("支付时间:       "+paytime11);
        layout_ten.setVisibility(View.GONE);
        layout_button.setVisibility(View.GONE);
        layout_button_delete.setVisibility(View.GONE);
        time_one.setText(paytime11);
        int pin_time11 = orderdetailsBean.getData().getPing_time();
        long pin_Time11 = (int)pin_time11;
        String pintime11 = TimeUtils.milliseconds2String(pin_Time11*1000);
        layout_frietext.setText("成团时间:       "+pintime11);
        int servicegomen_time11 = orderdetailsBean.getData().getService_personal_confirm_visit_time();
        long servicegomen_Time11 = (int)servicegomen_time11;
        String servicegomentime11 = TimeUtils.milliseconds2String(servicegomen_Time11*1000);
        layout_sixtext.setText("上门时间:       "+servicegomentime11);
        time_two.setText(pin_time11+"");
        time_two.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
        text_two.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
        Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_two);
        image_linetwo.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        time_three.setText(servicegomentime11+"");
        time_three.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
        text_three.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
        Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_three);
        image_linethree.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        button_one_deilts.setEnabled(true);
        button_two_deilts.setEnabled(true);
        button_three_deilts.setEnabled(true);
        button_four_deilts.setEnabled(true);
        button_two_deilts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suremen(orderdetailsBean.getData().get_id(),1);
            }
        });
        button_three_deilts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sureService(orderdetailsBean.getData().get_id(),3);
            }
        });
        button_four_deilts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sureServiceFinish(orderdetailsBean.getData().get_id(),4);

            }
        });
        button_one_deilts.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        button_two_deilts.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        button_three_deilts.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        button_four_deilts.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        layout_nine.setVisibility(View.GONE);
        if(orderdetailsBean.getData().getUser_have_confim_identity_time()==0){
            layout_seven.setVisibility(View.GONE);


        }else {
            layout_seven.setVisibility(View.VISIBLE);
            int confim_identity_time11 = orderdetailsBean.getData().getUser_have_confim_identity_time();
            long confimidentity_Time11 = (int)confim_identity_time11;
            String confimidentitytime11 = TimeUtils.milliseconds2String(confimidentity_Time11*1000);
            layout_seventext.setText("校验时间:       "+confimidentitytime11+"");
            lauyout_visibity_one.setVisibility(View.VISIBLE);
            lauyout_visibity2_one.setVisibility(View.GONE);
            time_four.setVisibility(View.VISIBLE);
            time_four.setText(confimidentitytime11+"");
            time_four.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            text_four.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_four);
            image_linefour.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));

        }
        if(orderdetailsBean.getData().getUser_confim_service_personal_time()==0){
            layout_ant.setVisibility(View.GONE);


        }else {

            layout_ant.setVisibility(View.VISIBLE);
            int user_confim_service_personal_time = orderdetailsBean.getData().getUser_confim_service_personal_time();
            long userconfim_service_time = (int)user_confim_service_personal_time;
            String userconfimService = TimeUtils.milliseconds2String(userconfim_service_time*1000);
            layout_anttext.setText("确认上门时间:       "+userconfimService);
            lauyout_visibity2_two.setVisibility(View.GONE);
            lauyout_visibity_two.setVisibility(View.VISIBLE);
            time_frie.setVisibility(View.VISIBLE);
            time_frie.setText(userconfimService+"");
            time_frie.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            text_frie.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_frie);
            image_linefrie.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));

        }
        if(orderdetailsBean.getData().getUser_confim_start_service_time()==0){
            layout_nine.setVisibility(View.GONE);


        }else {

            layout_nine.setVisibility(View.VISIBLE);
            int start_service_time = orderdetailsBean.getData().getUser_confim_start_service_time();
            long startservice_time = (int)start_service_time;
            String startservicetime = TimeUtils.milliseconds2String(startservice_time*1000);
            layout_ninetext.setText("开始服务时间:       "+startservicetime);
            lauyout_visibity2_three.setVisibility(View.GONE);
            lauyout_visibity_three.setVisibility(View.VISIBLE);
            time_six.setVisibility(View.VISIBLE);
            time_six.setText(startservicetime+"");
            time_six.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            text_six.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_six);
            image_linesix.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));

        }
        if(orderdetailsBean.getData().getUser_confim_complete_service_time()==0){
            layout_ten.setVisibility(View.GONE);


        }else {

            layout_ten.setVisibility(View.VISIBLE);
            int complete_service_time = orderdetailsBean.getData().getUser_confim_complete_service_time();
            long completeservice_time = (int)complete_service_time;
            String completeservicetime = TimeUtils.milliseconds2String(completeservice_time*1000);
            layout_tentext.setText("服务完成时间:       "+completeservicetime);
            lauyout_visibity2_four.setVisibility(View.GONE);
            lauyout_visibity_four.setVisibility(View.VISIBLE);
            time_seven.setVisibility(View.VISIBLE);
            time_seven.setText(completeservicetime+"");
            time_seven.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            text_seven.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_seven);
            image_lineseven.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));

        }

    }

    public void servicefinish2(final OrderdetailsBean orderdetailsBean) {
        Glide.with(OrderdetailsActivity.this).load(R.mipmap.pay_dai).into(imagr_state);
        text_state.setText("服务中");

        look_service.setVisibility(View.VISIBLE);

        text_toast.setText("服务人员完成服务，请确认服务完成");

        time_pay.setVisibility(View.GONE);


        Glide.with(OrderdetailsActivity.this).load(orderdetailsBean.getData().getService_id().getService_banner_img().get(0))
                .into(image_service_people);

        service_name.setText(orderdetailsBean.getData().getService_id().getService_name());
        //服务人员服务时间
        int ping_begin_time11 = orderdetailsBean.getData().getService_time();
        long ping_end11 = (int) ping_begin_time11;
        String pin_start11 = TimeUtils.milliseconds2String(ping_end11 * 1000);
        service_time.setText("服务时间:" + pin_start11);


        zong_money.setText("¥:" + orderdetailsBean.getData().getOrder_money());
        text_money_price.setText("¥:" + orderdetailsBean.getData().getOrder_money());
        shipay.setText("¥:" + orderdetailsBean.getData().getOrder_pay_money());
        tel_xx.setText(orderdetailsBean.getData().getUser_address_id().getAddress_city() + orderdetailsBean.getData()
                .getUser_address_id().getAddress_name() + orderdetailsBean.getData().getUser_address_id().getAddress_info());
        tel_name.setText(orderdetailsBean.getData().getUser_address_id().getUser_name());
        tel_phone.setText(orderdetailsBean.getData().getUser_address_id().getMobile_phone());
        layout_onetext.setText("订单编号:       " + orderdetailsBean.getData().getOrder_sn());
        //下单时间
        int order_time11 = orderdetailsBean.getData().getOrder_time();
        long orderTime11 = (int) order_time11;
        String ordertime11 = TimeUtils.milliseconds2String(orderTime11 * 1000);
        layout_threetext.setText("下单编号:       " + ordertime11);
        if (orderdetailsBean.getData().getOrder_pay_type() == 1) {

            layout_twotext.setText("支付方式:       支付宝");

        } else {
            layout_twotext.setText("支付方式:       微信");

        }
        int pay_time11 = orderdetailsBean.getData().getPay_time();
        Log.e("YZS", orderdetailsBean.getData().getPay_time() + "");
        long pay_Time11 = (int) pay_time11;
        String paytime11 = TimeUtils.milliseconds2String(pay_Time11 * 1000);
        time_two.setVisibility(View.VISIBLE);
        time_three.setVisibility(View.VISIBLE);
        layout_fourtext.setText("支付时间:       " + paytime11);
        layout_ten.setVisibility(View.GONE);
        layout_button.setVisibility(View.GONE);
        layout_button_delete.setVisibility(View.GONE);
        time_one.setText(paytime11);
        int pin_time11 = orderdetailsBean.getData().getPing_time();
        long pin_Time11 = (int) pin_time11;
        String pintime11 = TimeUtils.milliseconds2String(pin_Time11 * 1000);
        layout_frietext.setText("成团时间:       " + pintime11);
        int servicegomen_time11 = orderdetailsBean.getData().getService_personal_confirm_visit_time();
        long servicegomen_Time11 = (int) servicegomen_time11;
        String servicegomentime11 = TimeUtils.milliseconds2String(servicegomen_Time11 * 1000);
        layout_sixtext.setText("上门时间:       " + servicegomentime11);
        time_two.setText(pin_time11 + "");
        time_two.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
        text_two.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
        Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_two);
        image_linetwo.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        time_three.setText(servicegomentime11 + "");
        time_three.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
        text_three.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
        Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_three);
        image_linethree.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        button_one_deilts.setEnabled(true);
        button_two_deilts.setEnabled(true);
        button_three_deilts.setEnabled(true);
        button_four_deilts.setEnabled(true);
        button_two_deilts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suremen(orderdetailsBean.getData().get_id(),1);
            }
        });
        button_three_deilts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sureService(orderdetailsBean.getData().get_id(),3);
            }
        });
        button_four_deilts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sureServiceFinish(orderdetailsBean.getData().get_id(),4);

            }
        });
        button_one_deilts.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        button_two_deilts.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        button_three_deilts.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        button_four_deilts.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        layout_nine.setVisibility(View.GONE);
        if (orderdetailsBean.getData().getUser_have_confim_identity_time() == 0) {
            layout_seven.setVisibility(View.GONE);


        } else {
            layout_seven.setVisibility(View.VISIBLE);
            int confim_identity_time11 = orderdetailsBean.getData().getUser_have_confim_identity_time();
            long confimidentity_Time11 = (int) confim_identity_time11;
            String confimidentitytime11 = TimeUtils.milliseconds2String(confimidentity_Time11 * 1000);
            layout_seventext.setText("校验时间:       " + confimidentitytime11 + "");
            lauyout_visibity_one.setVisibility(View.VISIBLE);
            lauyout_visibity2_one.setVisibility(View.GONE);
            time_four.setVisibility(View.VISIBLE);
            time_four.setText(confimidentitytime11 + "");
            time_four.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            text_four.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_four);
            image_linefour.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));

        }
        if (orderdetailsBean.getData().getUser_confim_service_personal_time() == 0) {
            layout_ant.setVisibility(View.GONE);


        } else {

            layout_ant.setVisibility(View.VISIBLE);
            int user_confim_service_personal_time = orderdetailsBean.getData().getUser_confim_service_personal_time();
            long userconfim_service_time = (int) user_confim_service_personal_time;
            String userconfimService = TimeUtils.milliseconds2String(userconfim_service_time * 1000);
            layout_anttext.setText("确认上门时间:       " + userconfimService);
            lauyout_visibity2_two.setVisibility(View.GONE);
            lauyout_visibity_two.setVisibility(View.VISIBLE);
            time_frie.setVisibility(View.VISIBLE);
            time_frie.setText(userconfimService + "");
            time_frie.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            text_frie.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_frie);
            image_linefrie.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));

        }
        if (orderdetailsBean.getData().getUser_confim_start_service_time() == 0) {
            layout_nine.setVisibility(View.GONE);


        } else {

            layout_nine.setVisibility(View.VISIBLE);
            int start_service_time = orderdetailsBean.getData().getUser_confim_start_service_time();
            long startservice_time = (int) start_service_time;
            String startservicetime = TimeUtils.milliseconds2String(startservice_time * 1000);
            layout_ninetext.setText("开始服务时间:       " + startservicetime);
            lauyout_visibity2_three.setVisibility(View.GONE);
            lauyout_visibity_three.setVisibility(View.VISIBLE);
            time_six.setVisibility(View.VISIBLE);
            time_six.setText(startservicetime + "");
            time_six.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            text_six.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_six);
            image_linesix.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));

        }
        if (orderdetailsBean.getData().getUser_confim_complete_service_time() == 0) {
            layout_ten.setVisibility(View.GONE);


        } else {

            layout_ten.setVisibility(View.VISIBLE);
            int complete_service_time = orderdetailsBean.getData().getUser_confim_complete_service_time();
            long completeservice_time = (int) complete_service_time;
            String completeservicetime = TimeUtils.milliseconds2String(completeservice_time * 1000);
            layout_tentext.setText("服务完成时间:       " + completeservicetime);
            lauyout_visibity2_four.setVisibility(View.GONE);
            lauyout_visibity_four.setVisibility(View.VISIBLE);
            time_seven.setVisibility(View.VISIBLE);
            time_seven.setText(completeservicetime + "");
            time_seven.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            text_seven.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_seven);
            image_lineseven.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));

        }
    }
    public void servicefinish15(final OrderdetailsBean orderdetailsBean) {
        Glide.with(OrderdetailsActivity.this).load(R.mipmap.pay_dai).into(imagr_state);
        text_state.setText("服务中");

        look_service.setVisibility(View.VISIBLE);

        text_toast.setText("服务人员完成服务，请确认服务完成");

        time_pay.setVisibility(View.GONE);


        Glide.with(OrderdetailsActivity.this).load(orderdetailsBean.getData().getService_id().getService_banner_img().get(0))
                .into(image_service_people);

        service_name.setText(orderdetailsBean.getData().getService_id().getService_name());
        //服务人员服务时间
        int ping_begin_time11 = orderdetailsBean.getData().getService_time();
        long ping_end11 = (int) ping_begin_time11;
        String pin_start11 = TimeUtils.milliseconds2String(ping_end11 * 1000);
        service_time.setText("服务时间:" + pin_start11);


        zong_money.setText("¥:" + orderdetailsBean.getData().getOrder_money());
        text_money_price.setText("¥:" + orderdetailsBean.getData().getOrder_money());
        shipay.setText("¥:" + orderdetailsBean.getData().getOrder_pay_money());
        tel_xx.setText(orderdetailsBean.getData().getUser_address_id().getAddress_city() + orderdetailsBean.getData()
                .getUser_address_id().getAddress_name() + orderdetailsBean.getData().getUser_address_id().getAddress_info());
        tel_name.setText(orderdetailsBean.getData().getUser_address_id().getUser_name());
        tel_phone.setText(orderdetailsBean.getData().getUser_address_id().getMobile_phone());
        layout_onetext.setText("订单编号:       " + orderdetailsBean.getData().getOrder_sn());
        //下单时间
        int order_time11 = orderdetailsBean.getData().getOrder_time();
        long orderTime11 = (int) order_time11;
        String ordertime11 = TimeUtils.milliseconds2String(orderTime11 * 1000);
        layout_threetext.setText("下单编号:       " + ordertime11);
        if (orderdetailsBean.getData().getOrder_pay_type() == 1) {

            layout_twotext.setText("支付方式:       支付宝");

        } else {
            layout_twotext.setText("支付方式:       微信");

        }
        int pay_time11 = orderdetailsBean.getData().getPay_time();
        Log.e("YZS", orderdetailsBean.getData().getPay_time() + "");
        long pay_Time11 = (int) pay_time11;
        String paytime11 = TimeUtils.milliseconds2String(pay_Time11 * 1000);
        time_two.setVisibility(View.VISIBLE);
        time_three.setVisibility(View.VISIBLE);
        layout_fourtext.setText("支付时间:       " + paytime11);
        layout_ten.setVisibility(View.GONE);
        layout_button.setVisibility(View.GONE);
        layout_button_delete.setVisibility(View.GONE);
        time_one.setText(paytime11);
        int pin_time11 = orderdetailsBean.getData().getPing_time();
        long pin_Time11 = (int) pin_time11;
        String pintime11 = TimeUtils.milliseconds2String(pin_Time11 * 1000);
        layout_frietext.setText("成团时间:       " + pintime11);
        int servicegomen_time11 = orderdetailsBean.getData().getService_personal_confirm_visit_time();
        long servicegomen_Time11 = (int) servicegomen_time11;
        String servicegomentime11 = TimeUtils.milliseconds2String(servicegomen_Time11 * 1000);
        layout_sixtext.setText("上门时间:       " + servicegomentime11);
        time_two.setText(pin_time11 + "");
        time_two.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
        text_two.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
        Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_two);
        image_linetwo.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        time_three.setText(servicegomentime11 + "");
        time_three.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
        text_three.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
        Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_three);
        image_linethree.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        button_one_deilts.setEnabled(true);
        button_two_deilts.setEnabled(true);
        button_three_deilts.setEnabled(true);
        button_four_deilts.setEnabled(true);
        button_two_deilts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suremen(orderdetailsBean.getData().get_id(),1);
            }
        });
        button_three_deilts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sureService(orderdetailsBean.getData().get_id(),3);
            }
        });
        button_four_deilts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sureServiceFinish(orderdetailsBean.getData().get_id(),4);

            }
        });
        button_one_deilts.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        button_two_deilts.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        button_three_deilts.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        button_four_deilts.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
        layout_nine.setVisibility(View.GONE);
        if (orderdetailsBean.getData().getUser_have_confim_identity_time() == 0) {
            layout_seven.setVisibility(View.GONE);


        } else {
            layout_seven.setVisibility(View.VISIBLE);
            int confim_identity_time11 = orderdetailsBean.getData().getUser_have_confim_identity_time();
            long confimidentity_Time11 = (int) confim_identity_time11;
            String confimidentitytime11 = TimeUtils.milliseconds2String(confimidentity_Time11 * 1000);
            layout_seventext.setText("校验时间:       " + confimidentitytime11 + "");
            lauyout_visibity_one.setVisibility(View.VISIBLE);
            lauyout_visibity2_one.setVisibility(View.GONE);
            time_four.setVisibility(View.VISIBLE);
            time_four.setText(confimidentitytime11 + "");
            time_four.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            text_four.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_four);
            image_linefour.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));

        }
        if (orderdetailsBean.getData().getUser_confim_service_personal_time() == 0) {
            layout_ant.setVisibility(View.GONE);


        } else {

            layout_ant.setVisibility(View.VISIBLE);
            int user_confim_service_personal_time = orderdetailsBean.getData().getUser_confim_service_personal_time();
            long userconfim_service_time = (int) user_confim_service_personal_time;
            String userconfimService = TimeUtils.milliseconds2String(userconfim_service_time * 1000);
            layout_anttext.setText("确认上门时间:       " + userconfimService);
            lauyout_visibity2_two.setVisibility(View.GONE);
            lauyout_visibity_two.setVisibility(View.VISIBLE);
            time_frie.setVisibility(View.VISIBLE);
            time_frie.setText(userconfimService + "");
            time_frie.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            text_frie.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_frie);
            image_linefrie.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));

        }
        if (orderdetailsBean.getData().getUser_confim_start_service_time() == 0) {
            layout_nine.setVisibility(View.GONE);


        } else {

            layout_nine.setVisibility(View.VISIBLE);
            int start_service_time = orderdetailsBean.getData().getUser_confim_start_service_time();
            long startservice_time = (int) start_service_time;
            String startservicetime = TimeUtils.milliseconds2String(startservice_time * 1000);
            layout_ninetext.setText("开始服务时间:       " + startservicetime);
            lauyout_visibity2_three.setVisibility(View.GONE);
            lauyout_visibity_three.setVisibility(View.VISIBLE);
            time_six.setVisibility(View.VISIBLE);
            time_six.setText(startservicetime + "");
            time_six.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            text_six.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_six);
            image_linesix.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));

        }
        if (orderdetailsBean.getData().getUser_confim_complete_service_time() == 0) {
            layout_ten.setVisibility(View.GONE);


        } else {

            layout_ten.setVisibility(View.VISIBLE);
            int complete_service_time = orderdetailsBean.getData().getUser_confim_complete_service_time();
            long completeservice_time = (int) complete_service_time;
            String completeservicetime = TimeUtils.milliseconds2String(completeservice_time * 1000);
            layout_tentext.setText("服务完成时间:       " + completeservicetime);
            lauyout_visibity2_four.setVisibility(View.GONE);
            lauyout_visibity_four.setVisibility(View.VISIBLE);
            time_seven.setVisibility(View.VISIBLE);
            time_seven.setText(completeservicetime + "");
            time_seven.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            text_seven.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_seven);
            image_lineseven.setBackgroundColor(OrderdetailsActivity.this.getResources().getColor(R.color.blue2));
            time_ant.setTextColor(OrderdetailsActivity.this.getResources().getColor(R.color.black_shou));
//            time_seven.setText(completeservicetime + "");
            Glide.with(OrderdetailsActivity.this).load(R.mipmap.big_yuan).into(image_ten);

        }
    }

    //dialog的点击事件
    public void suremen(final String order_id, final int confirm_type){
        int mWindowWidth, mWindowHeight;
        final Dialog dialog = new Dialog(this, R.style.simpleDialogStyle);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_styletwo, null);
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        mWindowWidth = displayMetrics.widthPixels;
        mWindowHeight = displayMetrics.heightPixels;

        dialog.setContentView(view, new ViewGroup.MarginLayoutParams(mWindowWidth,
                ViewGroup.MarginLayoutParams.MATCH_PARENT));
        dialog.show();
        TextView seach_id = view.findViewById(R.id.cancel_ids);
        TextView begin_id = view.findViewById(R.id.sure_ids);
        TextView text_nr2=  view.findViewById(R.id.text_nr2);
        TextView text_nr = view.findViewById(R.id.text_nr);
        text_nr.setText("确认服务人员上门");
        text_nr2.setText("确认服务人员已到达");
        begin_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //确认上门
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("user_access_token", Content.Token);
                hashMap.put("order_id",order_id);
                hashMap.put("confirm_type",confirm_type+"");
                Observer<ConfimOrderBean> observer = new Observer<ConfimOrderBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ConfimOrderBean confimOrderBean) {
                        if(confimOrderBean.getCode()==200){
                            newTel();
                            dialog.dismiss();

                        }else {
                            Toast.makeText(OrderdetailsActivity.this, confimOrderBean.getMsg()+"", Toast.LENGTH_SHORT).show();

                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("YZS",e.getMessage()+"");

                    }

                    @Override
                    public void onComplete() {

                    }
                };

                ApiMethods.getConfimOrder(observer,hashMap);
            }
        });
        seach_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });





    }

    //dialog的点击事件
    public void sureService(final String order_id, final int confirm_type){
        int mWindowWidth, mWindowHeight;
        final Dialog dialog = new Dialog(this, R.style.simpleDialogStyle);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_styletwo, null);
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        mWindowWidth = displayMetrics.widthPixels;
        mWindowHeight = displayMetrics.heightPixels;

        dialog.setContentView(view, new ViewGroup.MarginLayoutParams(mWindowWidth,
                ViewGroup.MarginLayoutParams.MATCH_PARENT));
        dialog.show();
        TextView seach_id = view.findViewById(R.id.cancel_ids);
        TextView begin_id = view.findViewById(R.id.sure_ids);
        TextView text_nr2=  view.findViewById(R.id.text_nr2);
        TextView text_nr = view.findViewById(R.id.text_nr);
        text_nr.setText("确认开始服务");
        text_nr2.setText("确认服务人员开始服务?");
        begin_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //确认上门
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("user_access_token", Content.Token);
                hashMap.put("order_id",order_id);
                hashMap.put("confirm_type",confirm_type+"");
                Observer<ConfimOrderBean> observer = new Observer<ConfimOrderBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ConfimOrderBean confimOrderBean) {
                        if(confimOrderBean.getCode()==200){
                            newTel();
                            dialog.dismiss();

                        }else {
                            Toast.makeText(OrderdetailsActivity.this, confimOrderBean.getMsg()+"", Toast.LENGTH_SHORT).show();

                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("YZS",e.getMessage()+"");

                    }

                    @Override
                    public void onComplete() {

                    }
                };

                ApiMethods.getConfimOrder(observer,hashMap);
            }
        });
        seach_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


    }


    //dialog的点击事件
    public void sureServiceFinish(final String order_id, final int confirm_type){
        int mWindowWidth, mWindowHeight;
        final Dialog dialog = new Dialog(this, R.style.simpleDialogStyle);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_styletwo, null);
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        mWindowWidth = displayMetrics.widthPixels;
        mWindowHeight = displayMetrics.heightPixels;

        dialog.setContentView(view, new ViewGroup.MarginLayoutParams(mWindowWidth,
                ViewGroup.MarginLayoutParams.MATCH_PARENT));
        dialog.show();
        TextView seach_id = view.findViewById(R.id.cancel_ids);
        TextView begin_id = view.findViewById(R.id.sure_ids);
        TextView text_nr2=  view.findViewById(R.id.text_nr2);
        TextView text_nr = view.findViewById(R.id.text_nr);
        text_nr.setText("确认服务完成");
        text_nr2.setText("您确定要确认服务完成吗?");
        begin_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //确认上门
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("user_access_token", Content.Token);
                hashMap.put("order_id",order_id);
                hashMap.put("confirm_type",confirm_type+"");
                Observer<ConfimOrderBean> observer = new Observer<ConfimOrderBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ConfimOrderBean confimOrderBean) {
                        if(confimOrderBean.getCode()==200){
                            newTel();
                            dialog.dismiss();

                        }else {
                            Toast.makeText(OrderdetailsActivity.this, confimOrderBean.getMsg()+"", Toast.LENGTH_SHORT).show();

                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("YZS",e.getMessage()+"");

                    }

                    @Override
                    public void onComplete() {

                    }
                };

                ApiMethods.getConfimOrder(observer,hashMap);
            }
        });
        seach_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


    }
}
