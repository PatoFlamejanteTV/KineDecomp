package com.xiaomi.gamecenter.sdk;

import android.content.Context;
import com.xiaomi.gamecenter.sdk.gam.MiGamMessageResponse;
import com.xiaomi.gamecenter.sdk.gam.MiResponseListener;

/* loaded from: classes.dex */
class o extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiResponseListener f4902a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ MiCommplatform d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(MiCommplatform miCommplatform, MiResponseListener miResponseListener, String str, String str2) {
        this.d = miCommplatform;
        this.f4902a = miResponseListener;
        this.b = str;
        this.c = str2;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0082 -> B:7:0x002e). Please report as a decompilation issue!!! */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        int check_and_connect;
        IGameCenterSDK iGameCenterSDK;
        Context context3;
        Context context4;
        try {
            MiCommplatform miCommplatform = this.d;
            context2 = this.d.ctx;
            check_and_connect = miCommplatform.check_and_connect(context2, false);
            if (check_and_connect != 0) {
                this.d.mTouch = false;
                this.f4902a.sendResultCode(-107, null);
            } else {
                iGameCenterSDK = this.d.sdk;
                MiGamMessageResponse joinUnion = iGameCenterSDK.joinUnion(this.b, this.c);
                if (joinUnion == null) {
                    this.f4902a.sendResultCode(-107, null);
                    this.d.mTouch = false;
                    MiCommplatform miCommplatform2 = this.d;
                    context4 = this.d.ctx;
                    miCommplatform2.disconnect(context4);
                } else {
                    this.f4902a.sendResultCode(joinUnion.getSdkStatus(), joinUnion.getMsgResult());
                    this.d.mTouch = false;
                    MiCommplatform miCommplatform3 = this.d;
                    context3 = this.d.ctx;
                    miCommplatform3.disconnect(context3);
                }
            }
        } catch (Exception e) {
            this.f4902a.sendResultCode(-107, null);
            e.printStackTrace();
        } finally {
            this.d.mTouch = false;
            MiCommplatform miCommplatform4 = this.d;
            context = this.d.ctx;
            miCommplatform4.disconnect(context);
        }
    }
}
