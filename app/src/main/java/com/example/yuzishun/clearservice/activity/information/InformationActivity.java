package com.example.yuzishun.clearservice.activity.information;

import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.Custom.ClearEditText;
import com.example.yuzishun.clearservice.MainActivity;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.adapter.GridViewAdapter;
import com.example.yuzishun.clearservice.base.BaseMvpActivity;
import com.example.yuzishun.clearservice.utils.RegexUtils;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InformationActivity extends BaseMvpActivity<InformationContact.infomationPresenter> implements InformationContact.infomationView, View.OnClickListener {

    @BindView(R.id.button_man)
    Button button_man;
    @BindView(R.id.button_woman)
    Button button_woman;
    @BindView(R.id.icon_man)
    RadioButton icon_man;
    @BindView(R.id.icon_woman)
    RadioButton icon_woman;
    @BindView(R.id.layout_man)
    RelativeLayout layout_man;
    @BindView(R.id.layout_woman)
    RelativeLayout layout_woman;
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.framily_name)
    TextView framily_name;
    @BindView(R.id.layout_framily)
    LinearLayout layout_framily;
    @BindView(R.id.Sure_id)
    Button Sure_id;
    @BindView(R.id.name_cltext)
    ClearEditText name_cltext;
    @BindView(R.id.tel_cltext)
    ClearEditText tel_cltext;
    @BindView(R.id.number_cltext)
    ClearEditText number_cltext;
    @BindView(R.id.layout_cord)
    LinearLayout layout_cord;
    private RegexUtils regexUtils;
    private String[] array=new String[]{"家庭保洁","做饭阿姨","保姆月嫂"};

    private InformationPresenterImpl informationPresenter;
    @Override
    public int intiLayout() {
        return R.layout.activity_infomation;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        informationPresenter = new InformationPresenterImpl();
        button_man.setEnabled(true);
        title_text.setText(R.string.information_id);
        icon_man.setChecked(true);
        informationPresenter.framilyname(layout_framily,framily_name,this);
        regexUtils = new RegexUtils(this);
        onclick();


    }

    @Override
    public void initData() {

    }
    public void onclick(){
        icon_man.setOnClickListener(this);
        icon_woman.setOnClickListener(this);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button_man.setOnClickListener(this);
        title_text.setOnClickListener(this);
        button_woman.setOnClickListener(this);
        layout_man.setOnClickListener(this);
        layout_woman.setOnClickListener(this);
        Sure_id.setOnClickListener(this);
        layout_cord.setOnClickListener(this);
    }

    @Override
    protected InformationContact.infomationPresenter createPresenter() {
        return new InformationPresenterImpl();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.icon_man:
                icon_woman.setChecked(false);
                button_woman.setEnabled(false);
                icon_man.setChecked(true);
                button_man.setEnabled(true);

                break;
            case R.id.icon_woman:
                icon_woman.setChecked(true);
                button_woman.setEnabled(true);
                icon_man.setChecked(false);
                button_man.setEnabled(false);
                break;

            case R.id.layout_man:
                icon_woman.setChecked(false);
                button_woman.setEnabled(false);
                icon_man.setChecked(true);
                button_man.setEnabled(true);

                break;
            case R.id.layout_woman:
                icon_woman.setChecked(true);
                button_woman.setEnabled(true);
                icon_man.setChecked(false);
                button_man.setEnabled(false);
                break;

            case R.id.Sure_id:
                if(framily_name.getText().toString().trim().equals("请选择")||name_cltext.getText().toString().trim().equals("")||
                        tel_cltext.getText().toString().toString().equals("")||number_cltext.getText().toString().trim().equals("")
                        ){

                    Toast.makeText(mActivity, "请您把信息完善", Toast.LENGTH_SHORT).show();
                }else {
                    if(regexUtils.isLegalName(name_cltext.getText().toString().trim())==false){
                        Toast.makeText(mActivity, "您的姓名必须是中文", Toast.LENGTH_SHORT).show();

                    }else {
                        if(regexUtils.isPhone(number_cltext.getText().toString().trim())==false){
                            Toast.makeText(mActivity, "您的手机号不合法", Toast.LENGTH_SHORT).show();

                        }else {
                            Intent intent = new Intent(this, MainActivity.class);
                            startActivity(intent);
//                    finish();
                        }
                    }

                }


                break;

            case R.id.layout_cord:
                showdialog();


                break;
        }
    }



    public void showdialog(){
        List<String> list=new ArrayList<String>();
        for(int i=0;i<array.length;i++){
            list.add(array[i]);
        }
        final Dialog dialog = new Dialog(this, R.style.Theme_Light_Dialog);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_gridview,null);
        //获得dialog的window窗口
        Window window = dialog.getWindow();
        //设置dialog在屏幕底部
        window.setGravity(Gravity.BOTTOM);
        //设置dialog弹出时的动画效果，从屏幕底部向上弹出
        window.setWindowAnimations(R.style.dialogStyle);
        window.getDecorView().setPadding(0, 0, 0, 0);
        //获得window窗口的属性
        android.view.WindowManager.LayoutParams lp = window.getAttributes();
        //设置窗口宽度为充满全屏
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置窗口高度为包裹内容
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //将设置好的属性set回去
        window.setAttributes(lp);
        //将自定义布局加载到dialog上
        dialog.setContentView(dialogView);
        GridView gridView = dialogView.findViewById(R.id.gridview_id);
//        GridViewAdapter Adapter = new GridViewAdapter(this,list);
//        gridView.setAdapter(Adapter);
        TextView cancel_id = dialogView.findViewById(R.id.cancel_);
        TextView sure_id = dialogView.findViewById(R.id.sure_);
        cancel_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        sure_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.cancel();
            }
        });

        dialog.show();


    }
}
