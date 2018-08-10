package com.example.yuzishun.clearservice.activity.myframnet_Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.AddtelActivity;
import com.example.yuzishun.clearservice.adapter.Recyclerview_ServiewAdapter;
import com.example.yuzishun.clearservice.adapter.listActivityAdapter;
import com.example.yuzishun.clearservice.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReleaseserviceActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.right_text)
    LinearLayout right_text;
    @BindView(R.id.tel_add)
    TextView tel_add;
    @BindView(R.id.recyclerview_Service)
    RecyclerView recyclerview_Service;
    private Recyclerview_ServiewAdapter recyclerview_serviewAdapter;

    @Override
    public int intiLayout() {
        return R.layout.activity_releaseservice;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_text.setText("发布列表");
        tel_add.setText("新建发布");
        onclick();
    }

    private void onclick() {
        image_back.setOnClickListener(this);
        right_text.setOnClickListener(this);
    }

    @Override
    public void initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("待商家应征" + i);
        }

        recyclerview_serviewAdapter = new Recyclerview_ServiewAdapter(this,list);
        recyclerview_Service.setLayoutManager(new LinearLayoutManager(this));
        recyclerview_Service.setAdapter(recyclerview_serviewAdapter);
        recyclerview_serviewAdapter.setOnRecyclerViewListener(new listActivityAdapter.OnRecyclerViewListener() {
            @Override
            public void onItemClick(int position) {

                startActivity(new Intent(ReleaseserviceActivity.this,ServiceDeileActivity.class));
            }
        });

        
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:
                finish();
                break;
            case R.id.right_text:
                startActivity(new Intent(this,ReleaseActivity.class));
                break;
        }
    }
}
