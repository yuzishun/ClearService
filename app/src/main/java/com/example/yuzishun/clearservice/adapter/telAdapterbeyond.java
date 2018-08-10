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
 * Created by yuzishun on 2018/8/7.
 */

public class telAdapterbeyond extends RecyclerView.Adapter<telAdapterbeyond.ViewHolder> {
    private Context mContext;
    private List<String> list;

    public telAdapterbeyond(Context mContext, List<String> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public telAdapterbeyond.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.beyondrv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(telAdapterbeyond.ViewHolder holder, int position) {
        holder.textView.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tel_name);

        }
    }
}
