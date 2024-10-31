package com.xiaomi.gamecenter.sdk;

import android.content.Context;
import com.xiaomi.gamecenter.sdk.gam.MiGamMessageResponse;
import com.xiaomi.gamecenter.sdk.gam.MiResponseListener;

/* loaded from: classes3.dex */
class p extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiResponseListener f26619a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f26620b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26621c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MiCommplatform miCommplatform, MiResponseListener miResponseListener, String str) {
        this.f26621c = miCommplatform;
        this.f26619a = miResponseListener;
        this.f26620b = str;
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
                MiCommplatform miCommplatform = this.f26621c;
                context2 = this.f26621c.ctx;
                check_and_connect = miCommplatform.check_and_connect(context2, false);
            } catch (Exception e2) {
                this.f26619a.sendResultCode(-107, null);
                e2.printStackTrace();
            }
            if (check_and_connect != 0) {
                this.f26621c.mTouch = false;
                miResponseListener = this.f26619a;
            } else {
                iGameCenterSDK = this.f26621c.sdk;
                MiGamMessageResponse checkJoinedUnion = iGameCenterSDK.checkJoinedUnion(this.f26620b);
                if (checkJoinedUnion != null) {
                    this.f26619a.sendResultCode(checkJoinedUnion.getSdkStatus(), checkJoinedUnion.getMsgResult());
                    return;
                }
                miResponseListener = this.f26619a;
            }
            miResponseListener.sendResultCode(-107, null);
        } finally {
            this.f26621c.mTouch = false;
            MiCommplatform miCommplatform2 = this.f26621c;
            context = miCommplatform2.ctx;
            miCommplatform2.disconnect(context);
        }
    }
}
