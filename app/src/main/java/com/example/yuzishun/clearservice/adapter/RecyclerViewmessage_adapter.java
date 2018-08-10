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
 * Created by yuzishun on 2018/8/9.
 */

public class RecyclerViewmessage_adapter extends RecyclerView.Adapter<RecyclerViewmessage_adapter.ViewHolder> {
    private Context context;
    private List<String> list;

    public RecyclerViewmessage_adapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerViewmessage_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_message_recyclerview,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewmessage_adapter.ViewHolder holder, int position) {
        holder.text_tiutle.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_tiutle;
        public ViewHolder(View itemView) {
            super(itemView);
            text_tiutle = itemView.findViewById(R.id.text_tiutle);
        }
    }
}
