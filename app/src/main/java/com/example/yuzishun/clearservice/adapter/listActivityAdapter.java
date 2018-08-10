package com.example.yuzishun.clearservice.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/7.
 */

public class listActivityAdapter extends RecyclerView.Adapter<listActivityAdapter.ViewHolder> {
    private Context context;
    private List<String> list;//存放数据

    public listActivityAdapter(Context context, List<String> list) {
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
        holder.textView.setText(list.get(position));
        holder.textView_price.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mOnRecyclerViewListener != null) {
                mOnRecyclerViewListener.onItemClick(position);
            }
        }
    });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView,textView_price;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.framily_time);
            textView_price = itemView.findViewById(R.id.yuan_price);
        }
    }
}
