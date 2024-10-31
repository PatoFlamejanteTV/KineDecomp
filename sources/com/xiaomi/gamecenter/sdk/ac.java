package com.xiaomi.gamecenter.sdk;

import android.content.Context;

/* loaded from: classes.dex */
class ac extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnPayProcessListener f4879a;
    final /* synthetic */ MiCommplatform b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(MiCommplatform miCommplatform, OnPayProcessListener onPayProcessListener) {
        this.b = miCommplatform;
        this.f4879a = onPayProcessListener;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0065 -> B:7:0x002d). Please report as a decompilation issue!!! */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        int check_and_connect;
        IGameCenterSDK iGameCenterSDK;
        Context context3;
        try {
            MiCommplatform miCommplatform = this.b;
            context2 = this.b.ctx;
            check_and_connect = miCommplatform.check_and_connect(context2, false);
            if (check_and_connect != 0) {
                this.b.mTouch = false;
                this.f4879a.finishPayProcess(-18003);
            } else {
                iGameCenterSDK = this.b.sdk;
                iGameCenterSDK.miWindow();
                this.b.mTouch = false;
                this.f4879a.finishPayProcess(0);
                this.b.mTouch = false;
                MiCommplatform miCommplatform2 = this.b;
                context3 = this.b.ctx;
                miCommplatform2.disconnect(context3);
            }
        } catch (Exception e) {
            this.b.mTouch = false;
            this.f4879a.finishPayProcess(-18003);
            e.printStackTrace();
        } finally {
            this.b.mTouch = false;
            MiCommplatform miCommplatform3 = this.b;
            context = this.b.ctx;
            miCommplatform3.disconnect(context);
        }
    }
}
