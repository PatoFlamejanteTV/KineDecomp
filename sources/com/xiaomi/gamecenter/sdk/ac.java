package com.xiaomi.gamecenter.sdk;

import android.content.Context;

/* loaded from: classes3.dex */
class ac extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnPayProcessListener f26552a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26553b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(MiCommplatform miCommplatform, OnPayProcessListener onPayProcessListener) {
        this.f26553b = miCommplatform;
        this.f26552a = onPayProcessListener;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        int check_and_connect;
        IGameCenterSDK iGameCenterSDK;
        try {
            try {
                MiCommplatform miCommplatform = this.f26553b;
                context2 = this.f26553b.ctx;
                check_and_connect = miCommplatform.check_and_connect(context2, false);
            } catch (Exception e2) {
                this.f26553b.mTouch = false;
                this.f26552a.finishPayProcess(-18003);
                e2.printStackTrace();
            }
            if (check_and_connect != 0) {
                this.f26553b.mTouch = false;
                this.f26552a.finishPayProcess(-18003);
            } else {
                iGameCenterSDK = this.f26553b.sdk;
                iGameCenterSDK.miWindow();
                this.f26553b.mTouch = false;
                this.f26552a.finishPayProcess(0);
            }
        } finally {
            this.f26553b.mTouch = false;
            MiCommplatform miCommplatform2 = this.f26553b;
            context = miCommplatform2.ctx;
            miCommplatform2.disconnect(context);
        }
    }
}
