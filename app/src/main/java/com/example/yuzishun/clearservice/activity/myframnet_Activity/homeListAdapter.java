package com.example.yuzishun.clearservice.activity.myframnet_Activity;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.adapter.listActivityAdapter;
import com.example.yuzishun.clearservice.model.HomepagerRecommend;
import com.example.yuzishun.clearservice.utils.CountDownUtils;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/8.
 */

public class homeListAdapter  extends RecyclerView.Adapter<homeListAdapter.ViewHolder> {
    private Context context;
    private List<HomepagerRecommend.DataBean.ServiceListBean> list;//存放数据

    public homeListAdapter(Context context, List<HomepagerRecommend.DataBean.ServiceListBean> list) {
        this.context = context;
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
    public homeListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_home_adaptet_item,parent,false));

    }

    @Override
    public void onBindViewHolder(homeListAdapter.ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnRecyclerViewListener != null) {
                    mOnRecyclerViewListener.onItemClick(position);
                }
            }
        });
        holder.yuanjiaText.setText(list.get(position).getService_original_money()+"");
        holder.name_text.setText(list.get(position).getService_name());
        Glide.with(context).load(list.get(position).getService_banner_img().get(0)).into(holder.icon_imageview);
        int i = list.get(position).getPing_number() - list.get(position).getHave_ping_number();
        holder.tuan.setText("参加人员"+list.get(position).getHave_ping_number()+"人,还差"+i+"人开团");
        holder.yuanjiaText.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        holder.xinajiaText.setText(list.get(position).getService_money()+"");
        int ping_end_time = list.get(position).getPing_end_time();
        long ping_end = (int)ping_end_time;
        long current = System.currentTimeMillis()/1000;

        if(ping_end<current){
            holder.time_text.setText("已结束");

        }else {
            new CountDownUtils(ping_end - current,holder.time_text).startCount();
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView yuanjiaText,xinajiaText,name_text,time_text,tuan;
        ImageView icon_imageview;
        public ViewHolder(View itemView) {
            super(itemView);
            tuan = itemView.findViewById(R.id.tuan);
            time_text = itemView.findViewById(R.id.time_text);
            name_text = itemView.findViewById(R.id.name_text);
            icon_imageview = itemView.findViewById(R.id.icon_image);
            yuanjiaText = itemView.findViewById(R.id.yuanjia);
            xinajiaText = itemView.findViewById(R.id.xianjia);


        }
    }
}
