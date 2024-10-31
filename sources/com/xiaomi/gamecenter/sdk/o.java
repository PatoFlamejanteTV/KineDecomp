package com.xiaomi.gamecenter.sdk;

import android.content.Context;
import com.xiaomi.gamecenter.sdk.gam.MiGamMessageResponse;
import com.xiaomi.gamecenter.sdk.gam.MiResponseListener;

/* loaded from: classes3.dex */
class o extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiResponseListener f26615a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f26616b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f26617c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26618d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(MiCommplatform miCommplatform, MiResponseListener miResponseListener, String str, String str2) {
        this.f26618d = miCommplatform;
        this.f26615a = miResponseListener;
        this.f26616b = str;
        this.f26617c = str2;
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
                MiCommplatform miCommplatform = this.f26618d;
                context2 = this.f26618d.ctx;
                check_and_connect = miCommplatform.check_and_connect(context2, false);
            } catch (Exception e2) {
                this.f26615a.sendResultCode(-107, null);
                e2.printStackTrace();
            }
            if (check_and_connect != 0) {
                this.f26618d.mTouch = false;
                miResponseListener = this.f26615a;
            } else {
                iGameCenterSDK = this.f26618d.sdk;
                MiGamMessageResponse joinUnion = iGameCenterSDK.joinUnion(this.f26616b, this.f26617c);
                if (joinUnion != null) {
                    this.f26615a.sendResultCode(joinUnion.getSdkStatus(), joinUnion.getMsgResult());
                    return;
                }
                miResponseListener = this.f26615a;
            }
            miResponseListener.sendResultCode(-107, null);
        } finally {
            this.f26618d.mTouch = false;
            MiCommplatform miCommplatform2 = this.f26618d;
            context = miCommplatform2.ctx;
            miCommplatform2.disconnect(context);
        }
    }
}
