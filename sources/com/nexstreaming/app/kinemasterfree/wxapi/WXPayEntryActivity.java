package com.nexstreaming.app.kinemasterfree.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.google.gson.Gson;
import com.nexstreaming.app.kinemasterfree.R;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelpay.PayResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

/* loaded from: classes2.dex */
public class WXPayEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {

    /* renamed from: a, reason: collision with root package name */
    private IWXAPI f19916a;

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        setContentView(R.layout.activity_wx_result);
        this.f19916a = e.b(this);
        this.f19916a.handleIntent(getIntent(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f19916a.handleIntent(intent, this);
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        WxPayInfo wxPayInfo;
        Log.d("WXPayEntryActivity", "errCode = " + baseResp.errCode);
        if (baseResp.getType() == 5 && (baseResp instanceof PayResp)) {
            Intent intent = new Intent("com.nexstreaming.app.kinemasterfree.wxpay.result");
            PayResp payResp = (PayResp) baseResp;
            if (payResp.extData != null && (wxPayInfo = (WxPayInfo) new Gson().fromJson(payResp.extData, WxPayInfo.class)) != null) {
                intent.putExtra(WxPayInfo.class.getName(), wxPayInfo);
            }
            intent.putExtra("code", baseResp.errCode);
            sendBroadcast(intent);
            finish();
        }
    }
}
