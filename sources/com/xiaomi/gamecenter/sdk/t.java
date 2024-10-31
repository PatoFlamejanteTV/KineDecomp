package com.xiaomi.gamecenter.sdk;

import android.content.Context;
import android.os.RemoteException;

/* loaded from: classes3.dex */
class t extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26629a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MiCommplatform miCommplatform) {
        this.f26629a = miCommplatform;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        int check_and_connect;
        Context context2;
        IGameCenterSDK iGameCenterSDK;
        MiCommplatform miCommplatform = this.f26629a;
        context = miCommplatform.ctx;
        check_and_connect = miCommplatform.check_and_connect(context, false);
        if (check_and_connect != 0) {
            this.f26629a.mTouch = false;
            return;
        }
        try {
            try {
                iGameCenterSDK = this.f26629a.sdk;
                iGameCenterSDK.openMiTalkUpdateSite();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        } finally {
            this.f26629a.mTouch = false;
            MiCommplatform miCommplatform2 = this.f26629a;
            context2 = miCommplatform2.ctx;
            miCommplatform2.disconnect(context2);
        }
    }
}
