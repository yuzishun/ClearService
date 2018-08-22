package com.example.yuzishun.clearservice.activity.mainfragment_activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.adapter.HP_ReAdapter;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.model.ServiceinfocationBean;
import com.example.yuzishun.clearservice.model.classificationvideoBean;
import com.example.yuzishun.clearservice.net.ApiMethods;
import com.example.yuzishun.clearservice.utils.DateUtils;
import com.example.yuzishun.clearservice.utils.TimeUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static com.example.yuzishun.clearservice.model.ServiceinfocationBean.*;

public class choosetimeActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.teablayout)
    TabLayout tabLayout;
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.suer)
    Button sure;
    private String tiem;
    private ArrayList<String> datas = new ArrayList<>();//页卡标题集合
    private List<Integer> datas2 = new ArrayList<>();//页卡标题集合

    private String id;
    private List<Fragment> fragments;

    @Override
    public int intiLayout() {
        return R.layout.activity_choosetime;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_text.setText("选择服务时间");
        image_back.setOnClickListener(this);
        sure.setOnClickListener(this);
        Intent intent =getIntent();
        id = intent.getStringExtra("_id");
        newTel();

    }

    private void newTel() {
       HashMap<String,String> hashMap = new HashMap<>();
       hashMap.put("_id",id);

       Observer<ServiceinfocationBean> observer = new Observer<ServiceinfocationBean>() {
           @Override
           public void onSubscribe(Disposable d) {

           }

           @Override
           public void onNext(final ServiceinfocationBean serviceinfocationBean) {
                Log.e("YZS",serviceinfocationBean.getData().toString());
               if(serviceinfocationBean.getCode()==200){
                   datas2 = serviceinfocationBean.getData().getService_time();
                   for (int i = 0; i <datas2.size() ; i++) {
//                       if(datas2.size()<5){
                           long ping_end = (int) datas2.get(i);
                           String s = TimeUtils.getFetureDate(ping_end * 1000);
                           datas.add(s);
//                       }else {
//
//                       }
                   }
                   Log.e("YZS",datas.size()+""+datas.toString());
                   for (int i = 0; i <datas.size() ; i++) {
                       tabLayout.addTab(tabLayout.newTab().setText(datas.get(i)));//添加tab选项

                   }

                   tabLayout.setTabMode(TabLayout.MODE_FIXED);
                   for (int i = 0; i < datas.size(); i++) {
                       ContentFragmentchoose fragment = ContentFragmentchoose.newInstance(datas,id);
                       fragments.add(fragment);
                   }
                   initview();

                   sure.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {


                           for (int i = 0; i <serviceinfocationBean.getData().getService_detail_time().size() ; i++) {
                               List<Integer> integers = serviceinfocationBean.getData().getService_detail_time().get(i);
                               for (int j = 0; j <integers.size() ; j++) {
                                   long len = (int)integers.get(j);
                                   if(TimeUtils.getFeture(len * 1000).equals(Content.chooseTime)){

                                       Content.chooseTime = String.valueOf(len);
                                       finish();
                                   }else {

                                   }

                               }


                           }

                           finish();

                       }
                   });

               }else {

               }


           }

           @Override
           public void onError(Throwable e) {
               Toast.makeText(choosetimeActivity.this, "服务人员id有误", Toast.LENGTH_SHORT).show();

           }

           @Override
           public void onComplete() {

           }
       };

       ApiMethods.getServiceinfo(observer,hashMap);

    }

    @Override
    public void initData() {

        fragments = new ArrayList<>();
        //根据日期里面的值
//        DateUtils dateUtils = new DateUtils();
//        datas = dateUtils.getSevendate();


    }


    private void initview() {
        //fragment的适配器
        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
            @Override
            public CharSequence getPageTitle(int position) {
                return datas.get(position);
            }

        };

        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);//将TabLayout和ViewPager关联起来。
//        quotation_tab.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器
//        datas.clear();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:
                finish();
                break;
            case R.id.suer:






                finish();
                break;

        }
    }
    @Override
    public void onPause() {
        super.onPause();
        datas.clear();
    }
}
