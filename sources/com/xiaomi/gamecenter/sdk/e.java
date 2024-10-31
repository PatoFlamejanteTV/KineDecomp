package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.xiaomi.gamecenter.sdk.entry.MiBuyInfoOnline;

/* loaded from: classes.dex */
class e extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiBuyInfoOnline f4891a;
    final /* synthetic */ OnPayProcessListener b;
    final /* synthetic */ Activity c;
    final /* synthetic */ Bundle d;
    final /* synthetic */ MiCommplatform e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MiCommplatform miCommplatform, MiBuyInfoOnline miBuyInfoOnline, OnPayProcessListener onPayProcessListener, Activity activity, Bundle bundle) {
        this.e = miCommplatform;
        this.f4891a = miBuyInfoOnline;
        this.b = onPayProcessListener;
        this.c = activity;
        this.d = bundle;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        int check_and_connect;
        IGameCenterSDK iGameCenterSDK;
        String version;
        boolean check_user_changed;
        Context context3;
        Context context4;
        Context context5;
        try {
            try {
                if (!this.f4891a.isValid()) {
                    this.e.mTouch = false;
                    this.b.finishPayProcess(-18003);
                    this.e.mTouch = false;
                    MiCommplatform miCommplatform = this.e;
                    context5 = this.e.ctx;
                    miCommplatform.disconnect(context5);
                    return;
                }
                check_and_connect = this.e.check_and_connect(this.c, false);
                if (check_and_connect != 0) {
                    this.e.mTouch = false;
                    this.b.finishPayProcess(-18003);
                    this.e.mTouch = false;
                    MiCommplatform miCommplatform2 = this.e;
                    context4 = this.e.ctx;
                    miCommplatform2.disconnect(context4);
                    return;
                }
                iGameCenterSDK = this.e.sdk;
                MiBuyInfoOnline miBuyInfoOnline = this.f4891a;
                version = this.e.getVersion();
                int miUniPayOnline = iGameCenterSDK.miUniPayOnline(miBuyInfoOnline, version, this.d);
                this.e.mTouch = false;
                check_user_changed = this.e.check_user_changed(this.c, miUniPayOnline);
                if (!check_user_changed) {
                    this.b.finishPayProcess(miUniPayOnline);
                    this.e.sendLogToSDKSerivce("=============Online:" + miUniPayOnline);
                }
                this.e.mTouch = false;
                MiCommplatform miCommplatform3 = this.e;
                context3 = this.e.ctx;
                miCommplatform3.disconnect(context3);
            } catch (Exception e) {
                this.e.sendLogToSDKSerivce("=============Online ex:" + e.toString());
                e.printStackTrace();
                try {
                    this.e.mTouch = false;
                    this.b.finishPayProcess(-18003);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.e.mTouch = false;
                MiCommplatform miCommplatform4 = this.e;
                context = this.e.ctx;
                miCommplatform4.disconnect(context);
            }
        } catch (Throwable th) {
            this.e.mTouch = false;
            MiCommplatform miCommplatform5 = this.e;
            context2 = this.e.ctx;
            miCommplatform5.disconnect(context2);
            throw th;
        }
    }
}
