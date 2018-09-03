package com.example.yuzishun.clearservice.activity.myframnet_Activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yuzishun.clearservice.MainActivity;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.changename.changepswActivity;
import com.example.yuzishun.clearservice.activity.login.LoginActivity;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.searchActivity;
import com.example.yuzishun.clearservice.activity.register.PassWordActivity;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.utils.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.outlog_id)
    Button outlog_id;
    @BindView(R.id.layout_langer)
    LinearLayout layout_langer;
    @BindView(R.id.layout_changepw)
    LinearLayout layout_changepw;
    @BindView(R.id.layout_zong)
    LinearLayout layout_zong;
    @BindView(R.id.layout_title_bar)
    LinearLayout layout_title_bar;
    @Override
    public int intiLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        title_text.setText(R.string.setting);
        onclickc();
    }

    private void onclickc() {
        image_back.setOnClickListener(this);
        outlog_id.setOnClickListener(this);
        layout_langer.setOnClickListener(this);
        layout_changepw.setOnClickListener(this);
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
            case R.id.outlog_id:


                int mWindowWidth, mWindowHeight;
                final Dialog dialog = new Dialog(this, R.style.simpleDialogStyle);
                View view = LayoutInflater.from(this).inflate(R.layout.dialog_styleone, null);
                DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
                mWindowWidth = displayMetrics.widthPixels;
                mWindowHeight = displayMetrics.heightPixels;

                dialog.setContentView(view, new ViewGroup.MarginLayoutParams(mWindowWidth,
                        ViewGroup.MarginLayoutParams.MATCH_PARENT));
                dialog.show();
                TextView seach_id = view.findViewById(R.id.cancel_ids);
                TextView begin_id = view.findViewById(R.id.sure_ids);
                seach_id.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                begin_id.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String ToKen="";
                        Intent intent = new Intent(SettingActivity.this, LoginActivity.class);
                        SpUtil spUtil = new SpUtil(SettingActivity.this, "file");
                        spUtil.putString("login", ToKen);
                        MainActivity.instance.finish();
                        startActivity(intent);
                        finish();
                    }
                });

                break;
            case R.id.layout_langer:
                startActivity(new Intent(this,new langerActivity().getClass()));
                break;
            case R.id.layout_changepw:

                startActivity(new Intent(this,changepswActivity.class));
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        layout_zong.setBackgroundColor(getResources().getColor(R.color.white));
        layout_title_bar.setBackgroundColor(getResources().getColor(R.color.white));
    }
}
