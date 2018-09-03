package com.example.yuzishun.clearservice.activity.myframnet_Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.AddtelActivity;
import com.example.yuzishun.clearservice.adapter.RecyclerViewTel_Adapter;
import com.example.yuzishun.clearservice.adapter.listActivityAdapter;
import com.example.yuzishun.clearservice.adapter.telAdapterbeyond;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.fragment.homepager.HomeseachActivity;
import com.example.yuzishun.clearservice.model.Bean;
import com.example.yuzishun.clearservice.model.addressBean;
import com.example.yuzishun.clearservice.model.telupdataBean;
import com.example.yuzishun.clearservice.net.ApiMethods;
import com.example.yuzishun.clearservice.utils.OnEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class telActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.tel_recyclerView)
    RecyclerView tel_recyclerView;
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.right_text)
    LinearLayout right_text;
    @BindView(R.id.tel_add)
    TextView tel_add;
    private List<Bean> mDatas = new ArrayList<>();
    private List<addressBean.DataBean.ListBean> listYse = new ArrayList();
    private RecyclerViewTel_Adapter recyclerViewTel_adapter;

    @Override
    public int intiLayout() {
        return R.layout.activity_tel;

    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_text.setText(R.string.my_tel);
        tel_add.setText(R.string.newtel_add);
        newTel();
        onclick();

    }

    private void newTel() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("user_access_token", Content.Token);
        hashMap.put("page","0");
        hashMap.put("size","100");
        Observer<addressBean> observer = new Observer<addressBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(final addressBean addressBean) {
                if(addressBean.getCode()==200) {
                    for (int i = 0; i <addressBean.getData().getList().size() ; i++) {
                        listYse.add(addressBean.getData().getList().get(i));
                        for (int j = 0; j <addressBean.getData().getList().size() ; j++) {
                                if(j==0){
                                    mDatas.add(new Bean(true));

                                    continue;
                                }
                            mDatas.add(new Bean(false));
                        }
                        recyclerViewTel_adapter = new RecyclerViewTel_Adapter(telActivity.this,listYse,mDatas);
                        tel_recyclerView.setLayoutManager(new LinearLayoutManager(telActivity.this));
                        tel_recyclerView.setAdapter(recyclerViewTel_adapter);
                        tel_recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerViewTel_adapter.setOnRecyclerViewListener(new listActivityAdapter.OnRecyclerViewListener() {
                            @Override
                            public void onItemClick(int position) {
                                for (Bean bean : mDatas) {//全部设为未选中
                                    bean.setChecked(false);
                                }
                                mDatas.get(position).setChecked(true);//点击的设为选中
                                recyclerViewTel_adapter.notifyDataSetChanged();

                                HashMap<String,String> hashMap1 = new HashMap<>();
                                hashMap1.put("_id",addressBean.getData().getList().get(position).get_id());
                                hashMap1.put("user_access_token",Content.Token);
                                hashMap1.put("is_default","1");
                                Observer<telupdataBean> observer1  = new Observer<telupdataBean>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {

                                    }

                                    @Override
                                    public void onNext(telupdataBean telupdataBean) {
                                        if(telupdataBean.getCode()
                                                ==200){
                                            Toast.makeText(telActivity.this, "设置默认成功", Toast.LENGTH_SHORT).show();

                                            recyclerViewTel_adapter.notifyDataSetChanged();

                                        }else {

                                            Toast.makeText(telActivity.this, telupdataBean.getMsg()+"", Toast.LENGTH_SHORT).show();
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

                                ApiMethods.getupdatatel(observer1,hashMap1);




                            }
                        });
                    }
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
        ApiMethods.getaddress(observer,hashMap);
        Log.e("YZS",hashMap.toString());
    }

    private void onclick() {
        image_back.setOnClickListener(this);
        right_text.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:
                finish();
                break;
            case R.id.right_text:
                startActivity(new Intent(this,AddtelActivity.class));
                break;
        }
    }

}
