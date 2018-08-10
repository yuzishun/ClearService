package com.example.yuzishun.clearservice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/10.
 */

public class Adapter_orther extends RecyclerView.Adapter<Adapter_orther.ViewHolder> {
    private Context mContext;
    private List<String> list;

    public Adapter_orther(Context mContext, List<String> list) {
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
        holder.textView.setText(list.get(position));
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
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
        }
    }
}
