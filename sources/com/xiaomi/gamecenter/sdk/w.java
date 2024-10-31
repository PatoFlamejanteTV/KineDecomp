package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;

/* loaded from: classes3.dex */
class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f26641a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnExitListner f26642b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26643c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(MiCommplatform miCommplatform, Activity activity, OnExitListner onExitListner) {
        this.f26643c = miCommplatform;
        this.f26641a = activity;
        this.f26642b = onExitListner;
    }

    @Override // java.lang.Runnable
    public void run() {
        int check_and_connect;
        Context context;
        IGameCenterSDK iGameCenterSDK;
        IGameCenterSDK iGameCenterSDK2;
        Context context2;
        check_and_connect = this.f26643c.check_and_connect(this.f26641a, false);
        try {
            if (check_and_connect != 0) {
                this.f26643c.mTouch = false;
                return;
            }
            try {
                iGameCenterSDK = this.f26643c.sdk;
                if (iGameCenterSDK != null) {
                    iGameCenterSDK2 = this.f26643c.sdk;
                    int appExit = iGameCenterSDK2.appExit();
                    MiCommplatform miCommplatform = this.f26643c;
                    context2 = this.f26643c.ctx;
                    miCommplatform.disconnect(context2);
                    this.f26642b.onExit(appExit);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        } finally {
            MiCommplatform miCommplatform2 = this.f26643c;
            context = miCommplatform2.ctx;
            miCommplatform2.disconnect(context);
        }
    }
}
