package com.example.yuzishun.clearservice.activity.information;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.present.BaseMvpPresenter;
import com.example.yuzishun.clearservice.present.MvpPresenter;

import java.util.ArrayList;

/**
 * Created by yuzishun on 2018/8/2.
 */

public class InformationPresenterImpl extends BaseMvpPresenter<InformationContact.infomationView> implements InformationContact.infomationPresenter {

    private ArrayList<String> framily;
    private OptionsPickerView framilyPickerView;

    @Override
    public void initView() {


    }

    @Override
    public void framilyname(LinearLayout framily_lyout, final TextView framily_name, final InformationActivity informationActivity) {
        framily = new ArrayList<>();
        framily.add(informationActivity.getString(R.string.grandfather));framily.add("奶奶");framily.add("爸爸");framily.add("妈妈");framily.add("儿子");
        framily.add("女儿");framily.add("外公");framily.add("外婆");
        framily_lyout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                framilyPickerView = new OptionsPickerBuilder(informationActivity, new OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3, View v) {
                        //返回的分别是三个级别的选中位置
                        String tx = framily.get(options1);
                        framily_name.setText(tx);
                    }
                })
//                        .setDecorView((RelativeLayout)informationActivity.findViewById(R.id.activity_rootview))//必须是RelativeLayout，不设置setDecorView的话，底部虚拟导航栏会显示在弹出的选择器区域
                        .setCancelText("取消")//取消按钮文字
                        .setCancelColor(informationActivity.getResources().getColor(R.color.gray))//取消按钮文字颜色
                        .setSubmitText("确定")//确认按钮文字
                        .setSubmitColor(informationActivity.getResources().getColor(R.color.gray))//确定按钮文字颜色
                        .setContentTextSize(20)//滚轮文字大小
                        .setTextColorCenter(informationActivity.getResources().getColor(R.color.black_shou))//设置选中文本的颜色值
                        .setLineSpacingMultiplier(1.8f)//行间距
                        .setDividerColor(informationActivity.getResources().getColor(R.color.gray))//设置分割线的颜色
                        .setSelectOptions(0)//设置选择的值
                        .build();

                framilyPickerView.setPicker(framily);

                framilyPickerView.show();


            }
        });


    }


}
