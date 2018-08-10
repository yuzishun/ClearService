package com.example.yuzishun.clearservice.activity.mainfragment_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.adapter.RecyclerViewTel_Adapter;
import com.example.yuzishun.clearservice.adapter.telAdapterbeyond;
import com.example.yuzishun.clearservice.adapter.telAdapternobeyond;
import com.example.yuzishun.clearservice.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChoosetelActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.right_text)
    LinearLayout right_text;
    @BindView(R.id.tel_add)
    TextView tel_add;
    @BindView(R.id.nobeyondRV)
    RecyclerView nobeyondRV;
    @BindView(R.id.beyondRV)
    RecyclerView beyondRV;
    private telAdapterbeyond telAdapterbeyond;
    private telAdapternobeyond telAdapternobeyond;
    private List<String> list = new ArrayList<String>();

    @Override
    public int intiLayout() {
        return R.layout.activity_choosetel;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_text.setText("选择服务地址");
        tel_add.setText(R.string.newtel_add);
        onclick();
    }

    private void onclick() {
        image_back.setOnClickListener(this);
        right_text.setOnClickListener(this);
    }
    @Override
    public void initData() {
        for (int i = 0; i <5; i++) {
            list.add(getString(R.string.name_idid)+i);
        }
        telAdapterbeyond = new telAdapterbeyond(this,list);

        nobeyondRV.setLayoutManager(new LinearLayoutManager(this));
        nobeyondRV.setAdapter(telAdapterbeyond);

        telAdapternobeyond = new telAdapternobeyond(this,list);
        beyondRV.setLayoutManager(new LinearLayoutManager(this));
        beyondRV.setAdapter(telAdapternobeyond);

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
