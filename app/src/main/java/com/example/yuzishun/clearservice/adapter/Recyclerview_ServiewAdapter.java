package com.example.yuzishun.clearservice.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.DetailsActivity;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/8.
 */

public class Recyclerview_ServiewAdapter extends RecyclerView.Adapter<Recyclerview_ServiewAdapter.ViewHolder> {
    private Context context;
    private List<String> list;//存放数据

    public Recyclerview_ServiewAdapter(Context context, List<String> list) {
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
    public Recyclerview_ServiewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.serviceadapter_item,parent,false));
    }

    @Override
    public void onBindViewHolder(Recyclerview_ServiewAdapter.ViewHolder holder, final int position) {
        holder.text_state.setText(list.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnRecyclerViewListener != null) {
                    mOnRecyclerViewListener.onItemClick(position);
                }
            }
        });
        holder.deile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailsActivity.class));
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_state;
        Button deile_button;
        public ViewHolder(View itemView) {
            super(itemView);
            text_state = itemView.findViewById(R.id.state);
            deile_button = itemView.findViewById(R.id.deile_button);
        }
    }
}
