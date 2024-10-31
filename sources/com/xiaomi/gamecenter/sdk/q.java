package com.xiaomi.gamecenter.sdk;

import android.content.Context;
import com.xiaomi.gamecenter.sdk.gam.MiGamMessageResponse;
import com.xiaomi.gamecenter.sdk.gam.MiResponseListener;

/* loaded from: classes3.dex */
class q extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiResponseListener f26622a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f26623b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26624c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(MiCommplatform miCommplatform, MiResponseListener miResponseListener, String str) {
        this.f26624c = miCommplatform;
        this.f26622a = miResponseListener;
        this.f26623b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        int check_and_connect;
        IGameCenterSDK iGameCenterSDK;
        MiResponseListener miResponseListener;
        try {
            try {
                MiCommplatform miCommplatform = this.f26624c;
                context2 = this.f26624c.ctx;
                check_and_connect = miCommplatform.check_and_connect(context2, false);
            } catch (Exception e2) {
                this.f26622a.sendResultCode(-107, null);
                e2.printStackTrace();
            }
            if (check_and_connect != 0) {
                this.f26624c.mTouch = false;
                miResponseListener = this.f26622a;
            } else {
                iGameCenterSDK = this.f26624c.sdk;
                MiGamMessageResponse subscribeVip = iGameCenterSDK.subscribeVip(this.f26623b);
                if (subscribeVip != null) {
                    this.f26622a.sendResultCode(subscribeVip.getSdkStatus(), subscribeVip.getMsgResult());
                    return;
                }
                miResponseListener = this.f26622a;
            }
            miResponseListener.sendResultCode(-107, null);
        } finally {
            this.f26624c.mTouch = false;
            MiCommplatform miCommplatform2 = this.f26624c;
            context = miCommplatform2.ctx;
            miCommplatform2.disconnect(context);
        }
    }
}
