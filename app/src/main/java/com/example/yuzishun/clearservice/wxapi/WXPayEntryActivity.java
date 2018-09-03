package com.example.yuzishun.clearservice.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.yuzishun.clearservice.activity.mainfragment_activity.PayActivity;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.PaySucessActivity;
import com.example.yuzishun.clearservice.base.Content;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by yuzishun on 2018/8/29.
 */

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        api = WXAPIFactory.createWXAPI(this, Content.APP_ID, false);
        api.registerApp(Content.APP_ID);
        try {
            api.handleIntent(getIntent(), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {
        int result = 0;
        //有时候支付结果还需要发送给服务器确认支付状态
        if (resp.getType()== ConstantsAPI.COMMAND_PAY_BY_WX){
            if (resp.errCode==0){

                Toast.makeText(this,"支付成功",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(WXPayEntryActivity.this,PaySucessActivity.class);

                startActivity(intent);
            }else if (resp.errCode==-2){
                Toast.makeText(this,"取消支付",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this,"支付失败",Toast.LENGTH_LONG).show();
//                Log.e("YZS",+"");
            }
            finish();
        }
    }

}