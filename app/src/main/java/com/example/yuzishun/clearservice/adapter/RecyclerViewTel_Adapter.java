package com.example.yuzishun.clearservice.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yuzishun.clearservice.Custom.ClearEditText;
import com.example.yuzishun.clearservice.R;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/3.
 */

public class RecyclerViewTel_Adapter  extends RecyclerView.Adapter<RecyclerViewTel_Adapter.ViewHolder> {
    private Context mContext;
    private List<String> list;

    public RecyclerViewTel_Adapter(Context mContext, List<String> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item_tel, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewTel_Adapter.ViewHolder holder, final int position) {
        holder.text_name_tel.setText(list.get(position));
        if(position==0){
            holder.text_tel.setText("默认地址");
            holder.checkBox_tel.setChecked(true);
        }else {
            holder.text_tel.setText("设为默认");
            holder.checkBox_tel.setChecked(false);

        }
        holder.layout_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeData(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //  添加数据
    public void addData(int position) {
//      在list中添加数据，并通知条目加入一条
        list.add(position, "" + position);
        //添加动画
        notifyItemInserted(position);
    }

    //  删除数据
    public void removeData(int position) {
        list.remove(position);
        //删除动画
        notifyItemRemoved(position);

        notifyDataSetChanged();


    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox checkBox_tel;
        private TextView text_name_tel,text_tel;
        private LinearLayout layout_remove;
        public ViewHolder(View itemView) {
            super(itemView);
            text_name_tel = itemView.findViewById(R.id.tel_name);
            checkBox_tel = itemView.findViewById(R.id.check_tel);
            text_tel = itemView .findViewById(R.id.text_tel);
            layout_remove = itemView.findViewById(R.id.layout_remove);
        }
    }
}