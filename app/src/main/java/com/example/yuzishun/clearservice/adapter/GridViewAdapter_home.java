package com.example.yuzishun.clearservice.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuzishun.clearservice.MainActivity;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.listActivity;
import com.example.yuzishun.clearservice.model.DataBean;
import com.example.yuzishun.clearservice.model.classificationBean;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

/**
 * Created by MQ on 2016/11/11.
 */

public class GridViewAdapter_home extends BaseAdapter {
    private List<classificationBean.DataBean.ListBean> dataList;
    private int[] lists = new int[]{R.mipmap.familtwork,R.mipmap.clear,R.mipmap.jiaju,R.mipmap.clearcar
    ,R.mipmap.anmo,R.mipmap.meirong,R.mipmap.baomu,R.mipmap.jiadian,R.mipmap.jiadian
    };
    private String[] listsname = new String[]{"家庭保洁","家电清洗","家居养护","上门洗车","上门按摩","美容美妆","保姆月嫂","家电维修"
    };
    private Context context;
    public static int item_grid_num = 8;//每一页中GridView中item的数量
    public static int number_columns = 4;//gridview一行展示的数目
    public GridViewAdapter_home(Context context,List<classificationBean.DataBean.ListBean> datas, int page) {
        dataList = new ArrayList<>();
        this.context = context;
        //start end分别代表要显示的数组在总数据List中的开始和结束位置
        int start = page * item_grid_num;
        int end = start + item_grid_num;
        while ((start < datas.size()) && (start < end)) {
            dataList.add(datas.get(start));

            start++;
        }
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View itemView, ViewGroup viewGroup) {
        ViewHolder mHolder;
        if (itemView == null) {
            mHolder = new ViewHolder();
            itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gridview, viewGroup, false);
            mHolder.iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            mHolder.tv_text = (TextView) itemView.findViewById(R.id.tv_text);
            itemView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) itemView.getTag();
        }
        boolean mainThread = isMainThread();

        System.out.print(mainThread+"");
        classificationBean.DataBean.ListBean listBean= dataList.get(i);

        if (listBean != null) {
//            mHolder.iv_img.setImageResource(R.mipmap.icon_woman_false);
//            mHolder.tv_text.setText(bean.name);
            Glide.with(context).load(lists[i]).into(mHolder.iv_img);

//            Glide.with(context).load(listBean.getClassify_logo()).into(mHolder.iv_img);
            mHolder.tv_text.setText(listBean.getClassify_name());
        }
        return itemView;
    }

    private class ViewHolder {
        private ImageView iv_img;
        private TextView tv_text;
    }
    public boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
