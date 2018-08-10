package com.example.yuzishun.clearservice.tools;

/**
 * Created by admin on 2016/7/22.
 */

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;


import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.utils.SpUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 *
 * 国家码选择
 *
 * <p>
 * 类详细描述
 * </p>
 *
 * @author duanbokan
 *
 */

public class CountrySortAdapter extends BaseAdapter implements SectionIndexer
{

    private List<CountrySortModel> mList;

    private Context mContext;

    LayoutInflater mInflater;
    public int check = 0;

    /***
     * 初始化
     *
     * @param mContext
     * @param list
     */
    public CountrySortAdapter(Context mContext, List<CountrySortModel> list)
    {
        this.mContext = mContext;
        if (list == null)
        {
            this.mList = new ArrayList<CountrySortModel>();
        }
        else
        {
            this.mList = list;
        }
    }

    @Override
    public int getCount()
    {
        return this.mList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent)
    {
        ViewHolder viewHolder = null;
        final CountrySortModel mContent = mList.get(position);

        if (view == null)
        {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.coogame_country_item, null);
            viewHolder.country_sortName = (TextView) view.findViewById(R.id.country_catalog);
            viewHolder.country_name = (TextView) view.findViewById(R.id.country_name);
            viewHolder.country_number = (TextView) view.findViewById(R.id.country_number);
            viewHolder.chooseright = (ImageView) view.findViewById(R.id.chooseright);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }

        // 根据position获取分类的首字母的Char ascii值
        int section = getSectionForPosition(position);
        viewHolder.chooseright.setVisibility(check==position?View.VISIBLE:View.GONE);
        viewHolder.country_name.setTextColor(check==position?Color.parseColor("#108EE9"):Color.parseColor("#333333"));
        viewHolder.country_number.setTextColor(check==position?Color.parseColor("#108EE9"):Color.parseColor("#333333"));
        // 如果当前位置等于该分类首字母的Char的位置 ，则认为是第一次出现
        if (position == getPositionForSection(section))
        {
            viewHolder.country_sortName.setVisibility(View.VISIBLE);
            viewHolder.country_sortName.setText(mContent.sortLetters);
        }
        else
        {
            viewHolder.country_sortName.setVisibility(View.GONE);
        }

        viewHolder.country_name.setText(this.mList.get(position).countryName);
        viewHolder.country_number.setText(this.mList.get(position).countryNumber);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check = position;
                Activity activity = (Activity) mContext;
                String countryNumber = mList.get(position).countryNumber;
                SpUtil spUtil = new SpUtil(mContext,"country_number");
                spUtil.putString("countryNumber",countryNumber);
                SpUtil spUtil2 = new SpUtil(mContext,"postion");
                spUtil2.putInt("postion",position);
                activity.finish();
                notifyDataSetChanged();


            }
        });
        return view;
    }

    @Override
    public int getPositionForSection(int section)
    {
        if (section != 42)
        {
            for (int i = 0; i < getCount(); i++)
            {
                String sortStr = mList.get(i).sortLetters;
                char firstChar = sortStr.toUpperCase(Locale.CHINESE).charAt(0);
                if (firstChar == section)
                {
                    return i;
                }
            }
        }
        else
        {
            return 0;
        }

        return -1;
    }

    @Override
    public int getSectionForPosition(int position)
    {
        return mList.get(position).sortLetters.charAt(0);
    }

    @Override
    public Object[] getSections()
    {
        return null;
    }

    /**
     * 当ListView数据发生变化时,调用此方法来更新ListView
     *
     * @param list
     */
    public void updateListView(List<CountrySortModel> list)
    {
        if (list == null)
        {
            this.mList = new ArrayList<CountrySortModel>();
        }
        else
        {
            this.mList = list;
        }
        notifyDataSetChanged();
    }

    public void setCheck(int position) {

        check = position;
        notifyDataSetChanged();
    }

    public static class ViewHolder
    {
        // 国家码简拼所属的字母范围
        public TextView country_sortName;

        // 国家名
        public TextView country_name;

        // 代码
        public TextView country_number;

        public ImageView chooseright;
    }

}
