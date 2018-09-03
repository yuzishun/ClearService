package com.example.yuzishun.clearservice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.model.ClasssFitterBean;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/2.
 */

public class GridViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<ClasssFitterBean.DataBean> channelList;
    private boolean[] isCheck;
    ViewHolder holder = null;

    public GridViewAdapter(Context mContext, List<ClasssFitterBean.DataBean> channelList) {
        this.mContext = mContext;
        this.channelList = channelList;
        if (channelList != null) {
            isCheck = new boolean[channelList.size()];
            for (int i = 0; i < channelList.size(); i++) {
                if(channelList.get(i).isIs_filter()==true){
                    isCheck[i] = true;

                }else {
                    isCheck[i] = false;

                }
            }
        }
    }

    @Override
    public int getCount() {
        return channelList != null ? channelList.size() : null;
    }

    @Override
    public Object getItem(int position) {
        return channelList != null ? channelList.get(position).getClassify_name() : null;
    }

    @Override
    public long getItemId(int position) {
        return channelList != null ? position : 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.gridview_item, null);
            holder.button=    (Button) convertView.findViewById(R.id.button_crde);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.button.setText(channelList.get(position).getClassify_name());

//        boolean is_filter = channelList.get(position).isIs_filter();

//        if(is_filter==true){
//            holder.button.setTextColor(mContext.getResources().getColor(R.color.white));
//            holder.button.setEnabled(true);
//
//
//        }else {
//            holder.button.setTextColor(mContext.getResources().getColor(R.color.gray_text));
//            holder.button.setEnabled(false);
//
//        }
        if (isCheck[position]) {
            holder.button.setTextColor(mContext.getResources().getColor(R.color.white));
            holder.button.setEnabled(true);
            channelList.get(position).setIs_filter(true);
        } else {

            holder.button.setTextColor(mContext.getResources().getColor(R.color.gray_text));
            holder.button.setEnabled(false);
            channelList.get(position).setIs_filter(false);


        }
        return convertView;

    }
    /**
     * 改变某一个选项的状态
     * @param post
     */
    public void choiceState(int post) {
        /**
         *  传递过来所点击的position,如果是本身已经是选中状态,就让他变成不是选中状态,
         *  如果本身不是选中状态,就让他变成选中状态
         */

        isCheck[post] = isCheck[post] == true ? false : true;

        this.notifyDataSetChanged();
    }

    static class ViewHolder {
        Button  button;

    }


}

