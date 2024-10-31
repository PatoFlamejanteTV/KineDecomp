package com.nexstreaming.app.kinemasterfree.wxapi;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

/* loaded from: classes.dex */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    /* renamed from: a, reason: collision with root package name */
    private IWXAPI f3246a = null;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_wx_result);
        this.f3246a = KMUsage.getWXAPIInstance(this);
        this.f3246a.handleIntent(getIntent(), this);
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        Log.d("WXEntryActivity", "onReq() returned: " + baseReq.toString());
        switch (baseReq.getType()) {
            case 3:
            case 4:
            case 5:
            case 6:
            default:
                return;
        }
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        switch (baseResp.errCode) {
            case 0:
                b(baseResp);
                break;
            default:
                c(baseResp);
                break;
        }
        finish();
    }

    private void b(BaseResp baseResp) {
        if (baseResp != null) {
            if (baseResp.getType() == 1) {
                a((SendAuth.Resp) baseResp);
            } else if (baseResp.getType() == 2) {
                a(baseResp);
            }
        }
    }

    private void c(BaseResp baseResp) {
        switch (baseResp.errCode) {
            case BaseResp.ErrCode.ERR_UNSUPPORT /* -5 */:
                Log.i("WXEntryActivity", "onReceiveFail : Unsupport errorCode :" + baseResp.errCode);
                return;
            case -4:
                Log.i("WXEntryActivity", "onReceiveFail : Auth Denied errorCode :" + baseResp.errCode);
                b.a().d();
                return;
            case -3:
                Log.i("WXEntryActivity", "onReceiveFail : Sent Fail errorCode :" + baseResp.errCode);
                return;
            case -2:
                Log.i("WXEntryActivity", "onReceiveFail : User Cancel errorCode :" + baseResp.errCode);
                b.a().d();
                return;
            case -1:
                Log.i("WXEntryActivity", "onReceiveFail : Comm errorCode :" + baseResp.errCode);
                return;
            default:
                return;
        }
    }

    protected void a(SendAuth.Resp resp) {
        b.a().a(resp.code, new e(this));
    }

    protected void a(BaseResp baseResp) {
        if (baseResp != null && (baseResp instanceof SendMessageToWX.Resp)) {
            SendMessageToWX.Resp resp = (SendMessageToWX.Resp) baseResp;
            if (resp.transaction != null && resp.transaction.startsWith(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO)) {
                finish();
                return;
            }
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            if (!defaultSharedPreferences.getBoolean("wx_event", false)) {
                Log.i("WXEntryActivity", "onReceiveSendMessageToWXEvent() called with: [" + baseResp.openId + "]");
                com.nexstreaming.kinemaster.tracelog.a.a((Context) this, com.nexstreaming.kinemaster.tracelog.a.a(0), baseResp.openId, true).onResultAvailable(new g(this, defaultSharedPreferences)).onFailure((Task.OnFailListener) new f(this));
            } else {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
