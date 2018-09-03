package com.example.yuzishun.clearservice.activity.mainfragment_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.OrderdetailsActivity;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.base.Content;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaySucessActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.look_order)
    Button look_order;
    @BindView(R.id.finish)
    TextView finish;
    @BindView(R.id.money_text)
    TextView money_text;

    @Override
    public int intiLayout() {
        return R.layout.activity_pay_sucess;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        finish.setOnClickListener(this);
        look_order.setOnClickListener(this);
        Intent intent = getIntent();

        money_text.setText("¥:"+ Content.OrderMoney);

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.finish:
                PayActivity.intentstan.finish();
                SubmissionActivity.intentsat.finish();
                finish();

                break;
            case R.id.look_order:
                Intent intent = new Intent(PaySucessActivity.this,OrderdetailsActivity.class);
                intent.putExtra("id",Content.OrderId);
                startActivity(intent);

                break;


        }
    }
}
