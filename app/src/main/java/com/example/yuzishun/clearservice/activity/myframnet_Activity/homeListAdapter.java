package com.example.yuzishun.clearservice.activity.myframnet_Activity;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.adapter.listActivityAdapter;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/8.
 */

public class homeListAdapter  extends RecyclerView.Adapter<homeListAdapter.ViewHolder> {
    private Context context;
    private List<String> list;//存放数据

    public homeListAdapter(Context context, List<String> list) {
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

        holder.yuanjiaText.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        holder.xinajiaText.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView yuanjiaText,xinajiaText;

        public ViewHolder(View itemView) {
            super(itemView);
            yuanjiaText = itemView.findViewById(R.id.yuanjia);
            xinajiaText = itemView.findViewById(R.id.xianjia);


        }
    }
}
