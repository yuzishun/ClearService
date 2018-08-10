package com.example.yuzishun.clearservice.activity.mainfragment_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.adapter.RecyclerViewmessage_adapter;
import com.example.yuzishun.clearservice.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.RecyclerView_message_id)
    RecyclerView RecyclerView_message_id;
    private RecyclerViewmessage_adapter adapter;

    @Override
    public int intiLayout() {
        return R.layout.activity_message;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);

        title_text.setText("消息通知");
        onclickc();
    }

    private void onclickc() {
        image_back.setOnClickListener(this);

    }

    @Override
    public void initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("订单--拼团成功" + i);
        }

        adapter = new RecyclerViewmessage_adapter(this,list);
        RecyclerView_message_id.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView_message_id.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:
                finish();
                break;

        }
    }
}
