package com.xiaomi.gamecenter.sdk;

import android.content.Context;
import com.xiaomi.gamecenter.sdk.gam.MiGamMessageResponse;
import com.xiaomi.gamecenter.sdk.gam.MiResponseListener;

/* loaded from: classes.dex */
class n extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiResponseListener f4901a;
    final /* synthetic */ MiCommplatform b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(MiCommplatform miCommplatform, MiResponseListener miResponseListener) {
        this.b = miCommplatform;
        this.f4901a = miResponseListener;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        int check_and_connect;
        IGameCenterSDK iGameCenterSDK;
        Context context3;
        Context context4;
        try {
            MiCommplatform miCommplatform = this.b;
            context2 = this.b.ctx;
            check_and_connect = miCommplatform.check_and_connect(context2, false);
            if (check_and_connect != 0) {
                this.b.mTouch = false;
                this.f4901a.sendResultCode(-107, null);
            } else {
                iGameCenterSDK = this.b.sdk;
                MiGamMessageResponse checkMiTalkStatus = iGameCenterSDK.checkMiTalkStatus();
                if (checkMiTalkStatus == null) {
                    this.f4901a.sendResultCode(-107, null);
                    this.b.mTouch = false;
                    MiCommplatform miCommplatform2 = this.b;
                    context4 = this.b.ctx;
                    miCommplatform2.disconnect(context4);
                } else {
                    this.f4901a.sendResultCode(checkMiTalkStatus.getSdkStatus(), checkMiTalkStatus.getMsgResult());
                    this.b.mTouch = false;
                    MiCommplatform miCommplatform3 = this.b;
                    context3 = this.b.ctx;
                    miCommplatform3.disconnect(context3);
                }
            }
        } catch (Exception e) {
            this.f4901a.sendResultCode(-107, null);
            e.printStackTrace();
        } finally {
            this.b.mTouch = false;
            MiCommplatform miCommplatform4 = this.b;
            context = this.b.ctx;
            miCommplatform4.disconnect(context);
        }
    }
}
