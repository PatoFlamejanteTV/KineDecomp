package com.nexstreaming.app.kinemasterfree.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelpay.PayResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

/* loaded from: classes.dex */
public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    /* renamed from: a, reason: collision with root package name */
    private IWXAPI f3247a;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_wx_result);
        this.f3247a = KMUsage.getWXAPIInstance(this);
        this.f3247a.handleIntent(getIntent(), this);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f3247a.handleIntent(intent, this);
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
            if (((PayResp) baseResp).extData != null && (wxPayInfo = (WxPayInfo) new Gson().fromJson(((PayResp) baseResp).extData, WxPayInfo.class)) != null) {
                intent.putExtra(WxPayInfo.class.getName(), wxPayInfo);
            }
            intent.putExtra("code", baseResp.errCode);
            sendBroadcast(intent);
            finish();
        }
    }
}
