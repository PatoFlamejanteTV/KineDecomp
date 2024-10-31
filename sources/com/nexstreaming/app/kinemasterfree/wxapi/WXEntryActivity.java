package com.nexstreaming.app.kinemasterfree.wxapi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.tracelog.APCManager;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

/* loaded from: classes2.dex */
public class WXEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {

    /* renamed from: a, reason: collision with root package name */
    private IWXAPI f19915a = null;

    private void b(BaseResp baseResp) {
        int i = baseResp.errCode;
        if (i == -5) {
            Log.i("WXEntryActivity", "onReceiveFail : Unsupport errorCode :" + baseResp.errCode);
            return;
        }
        if (i == -4) {
            Log.i("WXEntryActivity", "onReceiveFail : Auth Denied errorCode :" + baseResp.errCode);
            e.c().g();
            return;
        }
        if (i == -3) {
            Log.i("WXEntryActivity", "onReceiveFail : Sent Fail errorCode :" + baseResp.errCode);
            return;
        }
        if (i == -2) {
            Log.i("WXEntryActivity", "onReceiveFail : User Cancel errorCode :" + baseResp.errCode);
            e.c().g();
            return;
        }
        if (i != -1) {
            return;
        }
        Log.i("WXEntryActivity", "onReceiveFail : Comm errorCode :" + baseResp.errCode);
    }

    private void c(BaseResp baseResp) {
        if (baseResp != null) {
            if (baseResp.getType() == 1) {
                a((SendAuth.Resp) baseResp);
            } else if (baseResp.getType() == 2) {
                a(baseResp);
            }
        }
    }

    protected void a(SendAuth.Resp resp) {
        e.c().a(resp.code, new f(this));
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        setContentView(R.layout.activity_wx_result);
        this.f19915a = e.c().e();
        this.f19915a.handleIntent(getIntent(), this);
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        Log.d("WXEntryActivity", "onReq() returned: " + baseReq.toString());
        int type = baseReq.getType();
        if (type == 3 || type != 4) {
        }
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        if (baseResp.errCode != 0) {
            b(baseResp);
        } else {
            c(baseResp);
        }
        finish();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(0, 0);
    }

    protected void a(BaseResp baseResp) {
        if (baseResp == null || !(baseResp instanceof SendMessageToWX.Resp)) {
            return;
        }
        String str = ((SendMessageToWX.Resp) baseResp).transaction;
        if (str != null && str.startsWith("video")) {
            finish();
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (!defaultSharedPreferences.getBoolean("wx_event", false)) {
            Log.i("WXEntryActivity", "onReceiveSendMessageToWXEvent() called with: [" + baseResp.openId + "]");
            APCManager.a((Context) this, APCManager.a(0), baseResp.openId, true).onResultAvailable(new h(this, defaultSharedPreferences)).onFailure((Task.OnFailListener) new g(this));
            return;
        }
        finish();
    }
}
