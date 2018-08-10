package com.example.yuzishun.clearservice.activity.myframnet_Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.adapter.RecyclerViewTel_Adapter;
import com.example.yuzishun.clearservice.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    private RecyclerViewTel_Adapter recyclerViewTel_adapter;
    private List<String> list = new ArrayList<String>();

    @Override
    public int intiLayout() {
        return R.layout.activity_tel;

    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_text.setText(R.string.my_tel);
        tel_add.setText(R.string.newtel_add);

        onclick();

    }

    private void onclick() {
        image_back.setOnClickListener(this);

    }

    @Override
    public void initData() {
        for (int i = 0; i <10 ; i++) {
            list.add(getString(R.string.name_idid)+i);
        }


        recyclerViewTel_adapter = new RecyclerViewTel_Adapter(this,list);
        tel_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tel_recyclerView.setAdapter(recyclerViewTel_adapter);
        tel_recyclerView.setItemAnimator(new DefaultItemAnimator());
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
