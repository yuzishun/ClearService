package com.example.yuzishun.clearservice.fragment.my;


import android.app.AlertDialog;
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

import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.main.MainPresenterImpl;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.ChooseCrdeActivity;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.OrderdetailsActivity;
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
import com.example.yuzishun.clearservice.utils.OnEvent;
import com.example.yuzishun.clearservice.utils.SpUtil;

import org.greenrobot.eventbus.EventBus;

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
    CircleImageView icon_mytx;
    @BindView(R.id.name_id)
    TextView name_id;
    @BindView(R.id.layout_one)
    LinearLayout layout_one;
    @BindView(R.id.layout_two)
    LinearLayout layout_two;
    @BindView(R.id.layout_everOrder)
    LinearLayout layout_everOrder;
    @BindView(R.id.chooseCrde)
    LinearLayout chooseCrde;
    private String i="";
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
        chooseCrde.setOnClickListener(this);

    }

    @Override
    protected void setUpData() {



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

                i="1";
                intent.putExtra("index",i);
                startActivity(intent);
                break;

            case R.id.waitteam_layout:
                Intent intent2 = new Intent(getMContext(), OrtherActivity.class);
                i="2";

                intent2.putExtra("index",i);
                startActivity(intent2);
                break;
            case R.id.waitService_layout:
                Intent intent3 = new Intent(getMContext(), OrtherActivity.class);
                i="2";

                intent3.putExtra("index",i);
                startActivity(intent3);
                break;
            case R.id.coffee_layout:
                Intent intent4 = new Intent(getMContext(), OrtherActivity.class);
                i="4";

                intent4.putExtra("index",i);
                startActivity(intent4);
                break;
            case R.id.success_layout:
                Intent intent5 = new Intent(getMContext(), OrtherActivity.class);
                i="5";

                intent5.putExtra("index",i);
                startActivity(intent5);
                break;
            case R.id.integral_layout:
                //第三方弹出的dialog 暂时不用
//                new AlertView("清楚缓存","您确定要清楚所有本地缓存吗?","取消",new String[]{"确定"},null,getContext(),AlertView.Style.Alert,null).show();
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
                Intent intent9  = new Intent(getMContext(), OrtherActivity.class);
                i="0";

                intent9.putExtra("index",i);
                startActivity(intent9);
                break;
            case R.id.chooseCrde:
                startActivity(new Intent(getMContext(), ChooseCrdeActivity.class));
                break;

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onResume() {
        super.onResume();
        User_xinxi();
        layout_one.setBackgroundColor(getResources().getColor(R.color.white));
        layout_two.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void User_xinxi(){
//        SpUtil spUtil1 = new SpUtil(getContext(),"Userid");
//        User_id = spUtil1.getString("User_id","null");
//        Log.e("YZS", User_id);

        HashMap<String,String> hashMap = new HashMap();
        hashMap.put("user_access_token",Content.Token);
//        hashMap.put("_id",User_id);
            Observer<UserBean> observer = new Observer<UserBean>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(UserBean userBean) {
                    Log.e("YZS",userBean.toString());
                    if(userBean.getCode()==200){
                        name_id.setText(userBean.getData().getNickname());

                    try {



                        if(userBean.getData().getHeaderimg_url().equals("")){

                            Glide.with(getMContext()).load(getResources().getDrawable(R.mipmap.logo)).into(icon_mytx);

                        }else {
                            Glide.with(getMContext()).load(userBean.getData().getHeaderimg_url()).into(icon_mytx);

                        }
                    }catch (Exception e){

                    }
                    }else {

                        Toast.makeText(getMContext(), userBean.getMsg()+"", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onError(Throwable e) {
                    Log.e("YZS",e.getMessage());
                }

                @Override
                public void onComplete() {

                }
            };
            ApiMethods.getUser(observer,hashMap);


    }

}
