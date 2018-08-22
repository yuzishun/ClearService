package com.example.yuzishun.clearservice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.model.addressBean;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/7.
 */

public class telAdapterbeyond extends RecyclerView.Adapter<telAdapterbeyond.ViewHolder> {
    private Context mContext;
    private List<addressBean.DataBean.ListBean> list;
    private int i =0;
    public telAdapterbeyond(Context mContext, List<addressBean.DataBean.ListBean> list,int i) {
        this.mContext = mContext;
        this.list = list;
        this.i = i;
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
    public telAdapterbeyond.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.beyondrv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(telAdapterbeyond.ViewHolder holder, final int position) {
//        for (int i = 0; i <list.size() ; i++) {
//            Log.e("YZS",list.toString()+""+i);
//
//        }
        try {

        if(i==0){
            holder.changeImage.setVisibility(View.GONE);
            holder.changer.setVisibility(View.GONE);
            holder.line.setVisibility(View.GONE);
        }else {
            holder.changer.setVisibility(View.VISIBLE);
            holder.changeImage.setVisibility(View.VISIBLE);
            holder.line.setVisibility(View.VISIBLE);

        }

        holder.name.setText(list.get(position).getUser_name());
        holder.tel_number.setText(list.get(position).getMobile_phone()+"");

        holder.text_tel_.setText(list.get(position).getAddress_city()+""+list.get(position).getAddress_name()+""+list.get(position).getAddress_info());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnRecyclerViewListener != null) {
                    mOnRecyclerViewListener.onItemClick(position);
                }
            }
        });
        }catch (Exception e){

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,tel_number,text_tel_,changer,line;
        ImageView changeImage;
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tel_name);
            tel_number = itemView.findViewById(R.id.tel_number);
            text_tel_ = itemView.findViewById(R.id.text_tel_);
            changeImage = itemView.findViewById(R.id.change_image);
            changer = itemView.findViewById(R.id.changer);
            line = itemView.findViewById(R.id.line);
        }
    }
}
