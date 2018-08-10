package com.example.yuzishun.clearservice.activity.myframnet_Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.Custom.CEditText;
import com.example.yuzishun.clearservice.Custom.ClearEditText;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.utils.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class changnameActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.cun)
    Button cun;
    @BindView(R.id.etname)
    CEditText etname;

    @Override
    public int intiLayout() {
        return R.layout.activity_changname;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_text.setText("修改昵称");
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        etname.setText(name);
        etname.setOnClickListener(this);
        etname.setFocusable(true);
        etname.setFocusableInTouchMode(true);
        etname.requestFocus();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

        onclick();


    }

    private void onclick() {
        image_back.setOnClickListener(this);
        cun.setOnClickListener(this);
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
            case R.id.cun:
                String name = etname.getText().toString().trim();

                if(name.equals("")){
                    Toast.makeText(this, "姓名不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    SpUtil spUtil = new SpUtil(changnameActivity.this, "dat1");
                    spUtil.putString("name", name);
                    finish();
                }
                break;

            case R.id.etname:

                break;
        }

    }
}
