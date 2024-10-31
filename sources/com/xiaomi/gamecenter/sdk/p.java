package com.xiaomi.gamecenter.sdk;

import android.content.Context;
import com.xiaomi.gamecenter.sdk.gam.MiGamMessageResponse;
import com.xiaomi.gamecenter.sdk.gam.MiResponseListener;

/* loaded from: classes.dex */
class p extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiResponseListener f4903a;
    final /* synthetic */ String b;
    final /* synthetic */ MiCommplatform c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MiCommplatform miCommplatform, MiResponseListener miResponseListener, String str) {
        this.c = miCommplatform;
        this.f4903a = miResponseListener;
        this.b = str;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0080 -> B:7:0x002e). Please report as a decompilation issue!!! */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        int check_and_connect;
        IGameCenterSDK iGameCenterSDK;
        Context context3;
        Context context4;
        try {
            MiCommplatform miCommplatform = this.c;
            context2 = this.c.ctx;
            check_and_connect = miCommplatform.check_and_connect(context2, false);
            if (check_and_connect != 0) {
                this.c.mTouch = false;
                this.f4903a.sendResultCode(-107, null);
            } else {
                iGameCenterSDK = this.c.sdk;
                MiGamMessageResponse checkJoinedUnion = iGameCenterSDK.checkJoinedUnion(this.b);
                if (checkJoinedUnion == null) {
                    this.f4903a.sendResultCode(-107, null);
                    this.c.mTouch = false;
                    MiCommplatform miCommplatform2 = this.c;
                    context4 = this.c.ctx;
                    miCommplatform2.disconnect(context4);
                } else {
                    this.f4903a.sendResultCode(checkJoinedUnion.getSdkStatus(), checkJoinedUnion.getMsgResult());
                    this.c.mTouch = false;
                    MiCommplatform miCommplatform3 = this.c;
                    context3 = this.c.ctx;
                    miCommplatform3.disconnect(context3);
                }
            }
        } catch (Exception e) {
            this.f4903a.sendResultCode(-107, null);
            e.printStackTrace();
        } finally {
            this.c.mTouch = false;
            MiCommplatform miCommplatform4 = this.c;
            context = this.c.ctx;
            miCommplatform4.disconnect(context);
        }
    }
}
