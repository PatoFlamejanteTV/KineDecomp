package com.xiaomi.gamecenter.sdk;

import android.content.Context;
import com.xiaomi.gamecenter.sdk.gam.MiGamMessageResponse;
import com.xiaomi.gamecenter.sdk.gam.MiResponseListener;

/* loaded from: classes3.dex */
class s extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiResponseListener f26626a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f26627b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26628c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MiCommplatform miCommplatform, MiResponseListener miResponseListener, String str) {
        this.f26628c = miCommplatform;
        this.f26626a = miResponseListener;
        this.f26627b = str;
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
                MiCommplatform miCommplatform = this.f26628c;
                context2 = this.f26628c.ctx;
                check_and_connect = miCommplatform.check_and_connect(context2, false);
            } catch (Exception e2) {
                this.f26626a.sendResultCode(-107, null);
                e2.printStackTrace();
            }
            if (check_and_connect != 0) {
                this.f26628c.mTouch = false;
                miResponseListener = this.f26626a;
            } else {
                iGameCenterSDK = this.f26628c.sdk;
                MiGamMessageResponse checkVipIsScubscribed = iGameCenterSDK.checkVipIsScubscribed(this.f26627b);
                if (checkVipIsScubscribed != null) {
                    this.f26626a.sendResultCode(checkVipIsScubscribed.getSdkStatus(), checkVipIsScubscribed.getMsgResult());
                    return;
                }
                miResponseListener = this.f26626a;
            }
            miResponseListener.sendResultCode(-107, null);
        } finally {
            this.f26628c.mTouch = false;
            MiCommplatform miCommplatform2 = this.f26628c;
            context = miCommplatform2.ctx;
            miCommplatform2.disconnect(context);
        }
    }
}
