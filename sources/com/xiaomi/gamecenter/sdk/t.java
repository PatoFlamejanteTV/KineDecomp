package com.xiaomi.gamecenter.sdk;

import android.content.Context;
import android.os.RemoteException;

/* loaded from: classes.dex */
class t extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f4907a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MiCommplatform miCommplatform) {
        this.f4907a = miCommplatform;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        int check_and_connect;
        Context context2;
        IGameCenterSDK iGameCenterSDK;
        MiCommplatform miCommplatform = this.f4907a;
        context = this.f4907a.ctx;
        check_and_connect = miCommplatform.check_and_connect(context, false);
        try {
        } catch (RemoteException e) {
            e.printStackTrace();
        } finally {
            this.f4907a.mTouch = false;
            MiCommplatform miCommplatform2 = this.f4907a;
            context2 = this.f4907a.ctx;
            miCommplatform2.disconnect(context2);
        }
        if (check_and_connect != 0) {
            this.f4907a.mTouch = false;
        } else {
            iGameCenterSDK = this.f4907a.sdk;
            iGameCenterSDK.openMiTalkUpdateSite();
        }
    }
}
