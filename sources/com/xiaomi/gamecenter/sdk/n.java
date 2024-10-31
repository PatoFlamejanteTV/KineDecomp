package com.xiaomi.gamecenter.sdk;

import android.content.Context;
import com.xiaomi.gamecenter.sdk.gam.MiGamMessageResponse;
import com.xiaomi.gamecenter.sdk.gam.MiResponseListener;

/* loaded from: classes3.dex */
class n extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiResponseListener f26613a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26614b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(MiCommplatform miCommplatform, MiResponseListener miResponseListener) {
        this.f26614b = miCommplatform;
        this.f26613a = miResponseListener;
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
                MiCommplatform miCommplatform = this.f26614b;
                context2 = this.f26614b.ctx;
                check_and_connect = miCommplatform.check_and_connect(context2, false);
            } catch (Exception e2) {
                this.f26613a.sendResultCode(-107, null);
                e2.printStackTrace();
            }
            if (check_and_connect != 0) {
                this.f26614b.mTouch = false;
                miResponseListener = this.f26613a;
            } else {
                iGameCenterSDK = this.f26614b.sdk;
                MiGamMessageResponse checkMiTalkStatus = iGameCenterSDK.checkMiTalkStatus();
                if (checkMiTalkStatus != null) {
                    this.f26613a.sendResultCode(checkMiTalkStatus.getSdkStatus(), checkMiTalkStatus.getMsgResult());
                    return;
                }
                miResponseListener = this.f26613a;
            }
            miResponseListener.sendResultCode(-107, null);
        } finally {
            this.f26614b.mTouch = false;
            MiCommplatform miCommplatform2 = this.f26614b;
            context = miCommplatform2.ctx;
            miCommplatform2.disconnect(context);
        }
    }
}
