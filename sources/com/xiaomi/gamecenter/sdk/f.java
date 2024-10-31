package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.content.Context;
import com.xiaomi.gamecenter.sdk.entry.MiBuyInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiBuyInfo f4892a;
    final /* synthetic */ OnPayProcessListener b;
    final /* synthetic */ Activity c;
    final /* synthetic */ MiCommplatform d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MiCommplatform miCommplatform, MiBuyInfo miBuyInfo, OnPayProcessListener onPayProcessListener, Activity activity) {
        this.d = miCommplatform;
        this.f4892a = miBuyInfo;
        this.b = onPayProcessListener;
        this.c = activity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        int check_and_connect;
        IGameCenterSDK iGameCenterSDK;
        String version;
        Context context3;
        boolean check_user_changed;
        Context context4;
        Context context5;
        Context context6;
        Context context7;
        try {
            try {
                if (!this.f4892a.isValid()) {
                    this.d.mTouch = false;
                    this.b.finishPayProcess(-18003);
                    this.d.mTouch = false;
                    MiCommplatform miCommplatform = this.d;
                    context7 = this.d.ctx;
                    miCommplatform.disconnect(context7);
                    return;
                }
                check_and_connect = this.d.check_and_connect(this.c, false);
                if (check_and_connect != 0) {
                    this.d.mTouch = false;
                    this.b.finishPayProcess(-18003);
                    this.d.mTouch = false;
                    MiCommplatform miCommplatform2 = this.d;
                    context6 = this.d.ctx;
                    miCommplatform2.disconnect(context6);
                    return;
                }
                iGameCenterSDK = this.d.sdk;
                MiBuyInfo miBuyInfo = this.f4892a;
                version = this.d.getVersion();
                int miUniPay = iGameCenterSDK.miUniPay(miBuyInfo, version);
                this.d.mTouch = false;
                MiCommplatform miCommplatform3 = this.d;
                context3 = this.d.ctx;
                miCommplatform3.disconnect(context3);
                if (miUniPay == -18008) {
                    this.d.sendToastMsg();
                    this.b.finishPayProcess(-18003);
                    this.d.mTouch = false;
                    MiCommplatform miCommplatform4 = this.d;
                    context5 = this.d.ctx;
                    miCommplatform4.disconnect(context5);
                    return;
                }
                check_user_changed = this.d.check_user_changed(this.c, miUniPay);
                if (!check_user_changed) {
                    this.b.finishPayProcess(miUniPay);
                    this.d.sendLogToSDKSerivce("=============uni:" + miUniPay);
                }
                this.d.mTouch = false;
                MiCommplatform miCommplatform5 = this.d;
                context4 = this.d.ctx;
                miCommplatform5.disconnect(context4);
            } catch (Exception e) {
                this.d.sendLogToSDKSerivce("=============uni ex:" + e.toString());
                e.printStackTrace();
                try {
                    this.d.mTouch = false;
                    this.b.finishPayProcess(-18003);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.d.mTouch = false;
                MiCommplatform miCommplatform6 = this.d;
                context = this.d.ctx;
                miCommplatform6.disconnect(context);
            }
        } catch (Throwable th) {
            this.d.mTouch = false;
            MiCommplatform miCommplatform7 = this.d;
            context2 = this.d.ctx;
            miCommplatform7.disconnect(context2);
            throw th;
        }
    }
}
