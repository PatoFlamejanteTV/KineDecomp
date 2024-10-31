package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;

/* loaded from: classes.dex */
class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f4912a;
    final /* synthetic */ OnExitListner b;
    final /* synthetic */ MiCommplatform c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(MiCommplatform miCommplatform, Activity activity, OnExitListner onExitListner) {
        this.c = miCommplatform;
        this.f4912a = activity;
        this.b = onExitListner;
    }

    @Override // java.lang.Runnable
    public void run() {
        int check_and_connect;
        Context context;
        IGameCenterSDK iGameCenterSDK;
        IGameCenterSDK iGameCenterSDK2;
        Context context2;
        check_and_connect = this.c.check_and_connect(this.f4912a, false);
        if (check_and_connect != 0) {
            this.c.mTouch = false;
            return;
        }
        try {
            iGameCenterSDK = this.c.sdk;
            if (iGameCenterSDK != null) {
                iGameCenterSDK2 = this.c.sdk;
                int appExit = iGameCenterSDK2.appExit();
                MiCommplatform miCommplatform = this.c;
                context2 = this.c.ctx;
                miCommplatform.disconnect(context2);
                this.b.onExit(appExit);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } finally {
            MiCommplatform miCommplatform2 = this.c;
            context = this.c.ctx;
            miCommplatform2.disconnect(context);
        }
    }
}
