package com.xiaomi.gamecenter.sdk;

import android.content.Context;
import com.xiaomi.gamecenter.sdk.entry.MiAppInfo;

/* loaded from: classes3.dex */
class ab extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnLoginProcessListener f26550a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26551b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(MiCommplatform miCommplatform, OnLoginProcessListener onLoginProcessListener) {
        this.f26551b = miCommplatform;
        this.f26550a = onLoginProcessListener;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        int check_and_connect;
        IGameCenterSDK iGameCenterSDK;
        String version;
        MiAppInfo miAppInfo;
        try {
            try {
                MiCommplatform miCommplatform = this.f26551b;
                context2 = this.f26551b.ctx;
                check_and_connect = miCommplatform.check_and_connect(context2, false);
            } catch (Exception e2) {
                this.f26551b.mTouch = false;
                this.f26550a.finishLoginProcess(-103, null);
                e2.printStackTrace();
            }
            if (check_and_connect != 0) {
                this.f26551b.mTouch = false;
                this.f26550a.finishLoginProcess(-103, null);
                return;
            }
            iGameCenterSDK = this.f26551b.sdk;
            version = this.f26551b.getVersion();
            iGameCenterSDK.miLogout(version);
            miAppInfo = this.f26551b.appInfo;
            miAppInfo.setAccount(null);
            this.f26551b.mTouch = false;
            this.f26550a.finishLoginProcess(-104, null);
        } finally {
            this.f26551b.mTouch = false;
            MiCommplatform miCommplatform2 = this.f26551b;
            context = miCommplatform2.ctx;
            miCommplatform2.disconnect(context);
        }
    }
}
