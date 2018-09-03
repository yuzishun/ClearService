package com.example.yuzishun.clearservice.adapter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.PayActivity;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.SubmissionActivity;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.OrderdetailsActivity;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.model.CancelOrderBean;
import com.example.yuzishun.clearservice.model.DeleteOrderBean;
import com.example.yuzishun.clearservice.model.OrderBean;
import com.example.yuzishun.clearservice.net.ApiMethods;
import com.example.yuzishun.clearservice.utils.CountDownUtils;
import com.example.yuzishun.clearservice.utils.TimeUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by yuzishun on 2018/8/10.
 */

public class Adapter_orther extends RecyclerView.Adapter<Adapter_orther.ViewHolder> {
    private Context mContext;
    private List<OrderBean.DataBean.ListBean> list;

    public Adapter_orther(Context mContext, List<OrderBean.DataBean.ListBean> list) {
        this.mContext = mContext;
        this.list = list;
    }
    // 采用接口回调的方式实现RecyclerView的ItemClick
    public listActivityAdapter.OnRecyclerViewListener mOnRecyclerViewListener;


    // 接口回调第一步: 定义接口和接口中的方法
    public interface OnRecyclerViewListener {

        void onItemClick(int position);

    }
    // 接口回调第二步: 初始化接口的引用
    public void setOnRecyclerViewListener(listActivityAdapter.OnRecyclerViewListener l) {
        this.mOnRecyclerViewListener = l;
    }
    @Override
    public Adapter_orther.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.orther_recyclerview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(Adapter_orther.ViewHolder holder, final int position) {
        holder.orther_hao.setText("订单编号:"+list.get(position).getOrder_sn());
        holder.text_name.setText(list.get(position).getService_title());
        Glide.with(mContext).load(list.get(position).getService_logo()).into(holder.image_order);
        //服务时间
        int ping_begin_time = list.get(position).getService_time();
        long ping_end = (int)ping_begin_time;
        String pin_start = TimeUtils.milliseconds2String(ping_end*1000);
        holder.text_service_time.setText("服务时间:"+pin_start);
        holder.text_money.setText("¥:"+list.get(position).getOrder_pay_money());
        holder.shifu.setText("¥:"+list.get(position).getOrder_pay_money());

        switch (list.get(position).getOrder_status()){
            case 1:
                holder.text_state.setText("待支付");
                if(list.get(position).getOver_order_time().equals("")){
                    holder.text_state.setText("已过期");
                    holder.layout_ddxq.setVisibility(View.VISIBLE);
                    holder.text_time.setVisibility(View.GONE);
                }else {
                int ping_end_time1 = Integer.parseInt(list.get(position).getOver_order_time());
                long ping_ende1 = (int)ping_end_time1;
                long current1 = System.currentTimeMillis()/1000;

                if(ping_ende1<current1){
                    holder.text_state.setText("已过期");
                    holder.layout_ddxq.setVisibility(View.VISIBLE);
                    holder.text_time.setVisibility(View.GONE);


                }else {
                    new CountDownUtils(ping_ende1 - current1,holder.text_time).startCount();
                }
                }
                break;
            case 2:
                holder.text_state.setText("已取消");
                holder.text_time.setVisibility(View.GONE);
                holder.layout_delete.setVisibility(View.VISIBLE);
                break;
            case 3:
                holder.text_state.setText("待成团");
                int ping_end_time = list.get(position).getPing_end_time();
                long ping_ende = (int)ping_end_time;
                long current = System.currentTimeMillis()/1000;
                holder.layout_xx.setVisibility(View.VISIBLE);
                if(ping_ende<current){
                    holder.text_state.setText("已过期");
                    holder.text_time.setVisibility(View.GONE);


                }else {
                    new CountDownUtils(ping_ende - current,holder.text_time).startCount();
                }
                break;
            case 4:
                holder.text_state.setText("待服务");
                holder.text_time.setVisibility(View.GONE);
                holder.layout_xx.setVisibility(View.VISIBLE);

                break;
            case 6:
                holder.text_state.setText("拼团失败-退款中");
                holder.text_time.setVisibility(View.GONE);
                holder.layout_xx.setVisibility(View.VISIBLE);

                break;
            case 7:
                holder.text_state.setText("拼团失败-退款失败");
                holder.text_time.setVisibility(View.GONE);
                holder.layout_xx.setVisibility(View.VISIBLE);

                break;
            case 8:
                holder.text_state.setText("拼团失败-退款成功");
                holder.text_time.setVisibility(View.GONE);
                holder.layout_delete.setVisibility(View.VISIBLE);

                break;
            case 9:
                holder.text_state.setText("待服务");
                holder.text_time.setVisibility(View.GONE);
                holder.layout_xx.setVisibility(View.VISIBLE);

                break;
            case 10:
                holder.text_state.setText("待服务");
                holder.text_time.setVisibility(View.GONE);
                holder.layout_xx.setVisibility(View.VISIBLE);

                break;
            case 11:
                holder.text_state.setText("待服务");
                holder.text_time.setVisibility(View.GONE);
                holder.layout_shenfen.setVisibility(View.VISIBLE);
                break;
            case 12:
                holder.text_state.setText("待服务");
                holder.text_time.setVisibility(View.GONE);
                holder.layout_chakan.setVisibility(View.VISIBLE);
                break;
            case 13:
                holder.text_state.setText("服务中");
                holder.text_time.setVisibility(View.GONE);
                holder.layout_begin.setVisibility(View.VISIBLE);
                break;
            case 14:
                holder.text_state.setText("服务中");
                holder.text_time.setVisibility(View.GONE);
                holder.layout_shenfen.setVisibility(View.GONE);
                holder.layout_end.setVisibility(View.VISIBLE);
                break;
            case 15:
                holder.text_state.setText("订单完成");
                holder.text_time.setVisibility(View.GONE);
                holder.layout_finish.setVisibility(View.VISIBLE);
                break;

        }

        holder.gopay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Content.OrderId = list.get(position).get_id();
                Content.OrderMoney = list.get(position).getOrder_pay_money();
                Intent intent = new Intent(mContext,PayActivity.class);
                intent.putExtra("_time",list.get(position).getOver_order_time());
                mContext.startActivity(intent);


            }
        });
        holder.cancel_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mWindowWidth, mWindowHeight;
                final Dialog dialog = new Dialog(mContext, R.style.simpleDialogStyle);
                View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_styleone, null);
                DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
                mWindowWidth = displayMetrics.widthPixels;
                mWindowHeight = displayMetrics.heightPixels;

                dialog.setContentView(view, new ViewGroup.MarginLayoutParams(mWindowWidth,
                        ViewGroup.MarginLayoutParams.MATCH_PARENT));
                dialog.show();
                TextView text_nr = view.findViewById(R.id.text_nr);
                TextView seach_id = view.findViewById(R.id.cancel_ids);
                TextView begin_id = view.findViewById(R.id.sure_ids);
                text_nr.setText("确定要取消订单吗?");
                seach_id.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                begin_id.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HashMap<String,String> hashMap = new HashMap<>();
                        hashMap.put("user_access_token", Content.Token);
                        hashMap.put("order_id",list.get(position).get_id());
                        Observer<CancelOrderBean> observer = new Observer<CancelOrderBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(CancelOrderBean cancelOrderBean) {
                                if(cancelOrderBean.getCode()==200){
                                    dialog.dismiss();
                                    Toast.makeText(mContext, "取消成功", Toast.LENGTH_SHORT).show();
                                    notifyItemChanged(position);

                                }else {
                                    Toast.makeText(mContext, cancelOrderBean.getMsg()+"", Toast.LENGTH_SHORT).show();
                                }

                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("YZS",e.getMessage());
                            }

                            @Override
                            public void onComplete() {

                            }
                        };
                        ApiMethods.getCancelOrder(observer,hashMap);


                    }
                });

            }
        });
        holder.delete_ordertwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(position);

            }
        });
        holder.delete_orderone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(position);
            }
        });
        holder.Service_peopleone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
        holder.Service_peopletwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnRecyclerViewListener != null) {
                    mOnRecyclerViewListener.onItemClick(position);
                }
            }
        });

        holder.xiangqing_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, OrderdetailsActivity.class);
                intent.putExtra("id", list.get(position).get_id());
                mContext.startActivity(intent);
            }
        });

        holder.xiangqing_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, OrderdetailsActivity.class);
                intent.putExtra("id", list.get(position).get_id());
                mContext.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView orther_hao,text_name,text_service_time,text_money,shifu,text_state,text_time;
        ImageView image_order;
        Button cancel_order,delete_ordertwo,delete_orderone,Service_peopletwo,Service_peopleone,gopay,xiangqing_button,xiangqing_button2;
        RelativeLayout layout_ddxq,layout_delete,layout_shenfen,layout_chakan,layout_begin,layout_end,layout_finish,layout_xx;
        @SuppressLint("WrongViewCast")
        public ViewHolder(View itemView) {
            super(itemView);
            image_order = itemView.findViewById(R.id.image_order);
            orther_hao = itemView.findViewById(R.id.orther_hao);
            text_name = itemView.findViewById(R.id.text_name);
            text_service_time = itemView.findViewById(R.id.text_service_time);
            text_money = itemView.findViewById(R.id.text_money);
            shifu = itemView.findViewById(R.id.shifu);
            cancel_order = itemView.findViewById(R.id.cancel_order);
            text_time = itemView.findViewById(R.id.text_time);
            text_state = itemView.findViewById(R.id.text_state);
            Service_peopleone = itemView.findViewById(R.id.Service_peopleone);
            Service_peopletwo = itemView.findViewById(R.id.Service_peopletwo);
            delete_ordertwo = itemView.findViewById(R.id.delete_ordertwo);
            delete_orderone = itemView.findViewById(R.id.deledte_ortherone);
            layout_ddxq = itemView.findViewById(R.id.layout_ddxq);
            gopay = itemView.findViewById(R.id.gopay);
            xiangqing_button = itemView.findViewById(R.id.xiangqing_button);
            xiangqing_button2 = itemView.findViewById(R.id.xiangqing_button2);
            layout_delete = itemView.findViewById(R.id.layout_delete);
            layout_shenfen = itemView.findViewById(R.id.layout_shenfen);
            layout_chakan = itemView.findViewById(R.id.layout_chakan);
            layout_begin = itemView.findViewById(R.id.layout_begin);
            layout_end = itemView.findViewById(R.id.layout_end);
            layout_finish = itemView.findViewById(R.id.layout_finish);
            layout_xx = itemView.findViewById(R.id.layout_xx);


        }
    }
    private void delete(final int position) {
        int mWindowWidth, mWindowHeight;
        final Dialog dialog = new Dialog(mContext, R.style.simpleDialogStyle);
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_styleone, null);
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        mWindowWidth = displayMetrics.widthPixels;
        mWindowHeight = displayMetrics.heightPixels;

        dialog.setContentView(view, new ViewGroup.MarginLayoutParams(mWindowWidth,
                ViewGroup.MarginLayoutParams.MATCH_PARENT));
        dialog.show();
        TextView text_nr = view.findViewById(R.id.text_nr);
        TextView seach_id = view.findViewById(R.id.cancel_ids);
        TextView begin_id = view.findViewById(R.id.sure_ids);
        text_nr.setText("确定要删除订单吗?");
        seach_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        begin_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("user_access_token", Content.Token);
                hashMap.put("order_id",list.get(position).get_id());
                Observer<DeleteOrderBean> observer = new Observer<DeleteOrderBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DeleteOrderBean deleteOrderBean) {
                        if(deleteOrderBean.getCode()==200){
                            dialog.dismiss();
                            Toast.makeText(mContext, "删除成功", Toast.LENGTH_SHORT).show();
                            notifyItemChanged(position);

                        }else {
                            Toast.makeText(mContext, deleteOrderBean.getMsg()+"", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("YZS",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                };
                ApiMethods.getDeltetOrder(observer,hashMap);


            }
        });


    }


}
