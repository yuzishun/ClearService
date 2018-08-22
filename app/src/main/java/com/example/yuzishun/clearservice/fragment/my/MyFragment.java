package com.example.yuzishun.clearservice.fragment.my;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.main.MainPresenterImpl;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.OrtherActivity;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.PersonalActivity;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.ReleaseserviceActivity;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.RewardonActivity;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.SettingActivity;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.telActivity;
import com.example.yuzishun.clearservice.activity.register.PassWordActivity;
import com.example.yuzishun.clearservice.base.BaseMvpFragment;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.fragment.homepager.HomePagerPresenterImpl;
import com.example.yuzishun.clearservice.model.UserBean;
import com.example.yuzishun.clearservice.model.regiserBean;
import com.example.yuzishun.clearservice.net.ApiMethods;
import com.example.yuzishun.clearservice.present.MvpPresenter;
import com.example.yuzishun.clearservice.present.MvpPresenterFragment;
import com.example.yuzishun.clearservice.utils.SpUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.BindViews;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseMvpFragment implements View.OnClickListener {
    @BindView(R.id.waitmoney_layout)
    LinearLayout waitmoney_layout;
    @BindView(R.id.waitteam_layout)
    LinearLayout waitteam_layout;
    @BindView(R.id.waitService_layout)
    LinearLayout waitService_layout;
    @BindView(R.id.coffee_layout)
    LinearLayout coffee_layout;
    @BindView(R.id.success_layout)
    LinearLayout success_layout;
    @BindView(R.id.integral_layout)
    LinearLayout integral_layout;
    @BindView(R.id.demand_layout)
    LinearLayout demand_layout;
    @BindView(R.id.evaluate_layout)
    LinearLayout evaluate_layout;
    @BindView(R.id.tel_layout)
    LinearLayout tel_layout;
    @BindView(R.id.setting_id)
    ImageView setting_id;
    @BindView(R.id.icon_mytx)
    ImageView icon_mytx;
    @BindView(R.id.name_id)
    TextView name_id;
    @BindView(R.id.layout_everOrder)
    LinearLayout layout_everOrder;
    private int i=0;
    private String User_id;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_my;
    }

    @Override
    protected void setUpView() {

        onclik();
//        regiserBean regiserBean = (com.example.yuzishun.clearservice.model.regiserBean) getArguments().get("regiserBean");
//        name_id.setText(regiserBean.getData().getNickname());


    }

    private void onclik() {
        waitmoney_layout.setOnClickListener(this);
        waitteam_layout.setOnClickListener(this);
        waitService_layout.setOnClickListener(this);
        coffee_layout.setOnClickListener(this);
        success_layout.setOnClickListener(this);
        integral_layout.setOnClickListener(this);
        demand_layout.setOnClickListener(this);
        evaluate_layout.setOnClickListener(this);
        tel_layout.setOnClickListener(this);
        setting_id.setOnClickListener(this);
        icon_mytx.setOnClickListener(this);
        name_id.setOnClickListener(this);
        layout_everOrder.setOnClickListener(this);


    }

    @Override
    protected void setUpData() {
        SpUtil spUtil1 = new SpUtil(getContext(),"Userid");
        User_id = spUtil1.getString("User_id","null");
        Log.e("YZS", User_id);

        HashMap<String,String> hashMap = new HashMap();
        hashMap.put("user_access_token",Content.Token);
        hashMap.put("_id",User_id);
        if(!User_id.equals("")){
            Observer<UserBean> observer = new Observer<UserBean>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(UserBean userBean) {
                    Log.e("YZS",userBean.toString());
                    if(userBean.getCode()==200){
                        name_id.setText(userBean.getData().getNickname());

                    }else {

                        Toast.makeText(getMContext(), "请求用户信息错误", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onError(Throwable e) {
                    Log.e("YZS",e.getMessage());
                    Toast.makeText(getMContext(), "请求用户信息错误", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onComplete() {

                }
            };
            ApiMethods.getUser(observer,hashMap);


        }else {
            Toast.makeText(getContext(), "User_id为空", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected MvpPresenterFragment createPresenter() {
        return new HomePagerPresenterImpl();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.waitmoney_layout:
                Intent intent = new Intent(getMContext(), OrtherActivity.class);
                i=1;
                intent.putExtra("index",i);
                startActivity(intent);
                break;

            case R.id.waitteam_layout:
                Intent intent2 = new Intent(getMContext(), OrtherActivity.class);
                i=2;
                intent2.putExtra("index",i);
                startActivity(intent2);
                break;
            case R.id.waitService_layout:
                Intent intent3 = new Intent(getMContext(), OrtherActivity.class);
                i=3;
                intent3.putExtra("index",i);
                startActivity(intent3);
                break;
            case R.id.coffee_layout:
                Intent intent4 = new Intent(getMContext(), OrtherActivity.class);
                i=4;
                intent4.putExtra("index",i);
                startActivity(intent4);
                break;
            case R.id.success_layout:
                Intent intent5 = new Intent(getMContext(), OrtherActivity.class);
                i=5;
                intent5.putExtra("index",i);
                startActivity(intent5);
                break;
            case R.id.integral_layout:
                Toast.makeText(getContext(), "111", Toast.LENGTH_SHORT).show();
                break;
            case R.id.demand_layout:

                startActivity(new Intent(getMContext(), ReleaseserviceActivity.class));

                break;
            case R.id.evaluate_layout:
                startActivity(new Intent(getMContext(), RewardonActivity.class));
                break;
            case R.id.tel_layout:
                //这里要传过去id 用id拿值
                Intent intent6 = new Intent(getMContext(),telActivity.class);

                startActivity(intent6);
                break;
            case R.id.setting_id:
                Intent intent1 = new Intent(getMContext(), SettingActivity.class);

                startActivity(intent1);
                break;

            case R.id.name_id:
                Intent intent7  = new Intent(getMContext(), PersonalActivity.class);

                startActivity(intent7);
                break;
            case R.id.icon_mytx:
                Intent intent8  = new Intent(getMContext(), PersonalActivity.class);

                startActivity(intent8);
                break;
            case R.id.layout_everOrder:

                startActivity(new Intent(getMContext(), OrtherActivity.class));
                break;

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
