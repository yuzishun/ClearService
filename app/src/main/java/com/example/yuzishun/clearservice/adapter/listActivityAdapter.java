package com.example.yuzishun.clearservice.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.DetailsActivity;
import com.example.yuzishun.clearservice.model.classBeantwosp;
import com.example.yuzishun.clearservice.model.classificationBean;
import com.example.yuzishun.clearservice.model.classificationvideoBean;
import com.example.yuzishun.clearservice.utils.CountDownUtils;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/7.
 */

public class listActivityAdapter extends RecyclerView.Adapter<listActivityAdapter.ViewHolder> {
    private Context context;
    private List<classificationvideoBean.DataBean.ListBean> list;//存放数据

    public listActivityAdapter(Context context, List<classificationvideoBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }
    // 采用接口回调的方式实现RecyclerView的ItemClick
    public OnRecyclerViewListener mOnRecyclerViewListener;


    // 接口回调第一步: 定义接口和接口中的方法
    public interface OnRecyclerViewListener {

        void onItemClick(int position);

    }
    // 接口回调第二步: 初始化接口的引用
    public void setOnRecyclerViewListener(OnRecyclerViewListener l) {
        this.mOnRecyclerViewListener = l;
    }
    @Override
    public listActivityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.listactivityrecyclerview_item,parent,false));

    }

    @Override
    public void onBindViewHolder(listActivityAdapter.ViewHolder holder, final int position) {
        holder.textView.setText(list.get(position).getService_name());
        holder.textView_price.setText("¥:"+list.get(position).getService_original_money());
        holder.textView_price.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );

        holder.xian_price.setText("¥:"+list.get(position).getService_money());

        Glide.with(context).load(list.get(position).getService_banner_img().get(0)).into(holder.image__);
        int pingsy = list.get(position).getPing_number() - list.get(position).getHave_ping_number();
        holder.num_people.setText("参加人员"+list.get(position).getPing_number()+"人，还差"+pingsy+"人拼成");
        int ping_end_time = list.get(position).getPing_end_time();
        long ping_end = (int)ping_end_time;
        long current = System.currentTimeMillis()/1000;
        if(ping_end<current){
            holder.time.setText("已结束");
            holder.button_pin.setText("不可拼团");

        }else {
            new CountDownUtils(ping_end - current,holder.time).startCount();
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mOnRecyclerViewListener != null) {
                mOnRecyclerViewListener.onItemClick(position);
            }
            Intent intent = new Intent(context,DetailsActivity.class);
            intent.putExtra("id",list.get(position).get_id());
            context.startActivity(intent);

        }
    });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView,textView_price,xian_price,time,num_people;
        ImageView image__;
        Button button_pin;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.framily_time);
            textView_price = itemView.findViewById(R.id.yuan_price);
            xian_price = itemView.findViewById(R.id.xian_price);
            time = itemView.findViewById(R.id.time);
            num_people = itemView.findViewById(R.id.num_people);
            image__ = itemView.findViewById(R.id.image__);
            button_pin = itemView.findViewById(R.id.button_pin);
        }
    }
}
