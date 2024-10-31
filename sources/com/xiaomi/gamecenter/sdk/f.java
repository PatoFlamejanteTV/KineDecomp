package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.content.Context;
import com.xiaomi.gamecenter.sdk.entry.MiBuyInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class f extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiBuyInfo f26593a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnPayProcessListener f26594b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Activity f26595c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26596d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MiCommplatform miCommplatform, MiBuyInfo miBuyInfo, OnPayProcessListener onPayProcessListener, Activity activity) {
        this.f26596d = miCommplatform;
        this.f26593a = miBuyInfo;
        this.f26594b = onPayProcessListener;
        this.f26595c = activity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        int check_and_connect;
        IGameCenterSDK iGameCenterSDK;
        String version;
        Context context2;
        boolean check_user_changed;
        OnPayProcessListener onPayProcessListener;
        try {
            try {
            } catch (Exception e2) {
                this.f26596d.sendLogToSDKSerivce("=============uni ex:" + e2.toString());
                e2.printStackTrace();
                try {
                    this.f26596d.mTouch = false;
                    this.f26594b.finishPayProcess(-18003);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (this.f26593a.isValid()) {
                check_and_connect = this.f26596d.check_and_connect(this.f26595c, false);
                if (check_and_connect != 0) {
                    this.f26596d.mTouch = false;
                    onPayProcessListener = this.f26594b;
                } else {
                    iGameCenterSDK = this.f26596d.sdk;
                    MiBuyInfo miBuyInfo = this.f26593a;
                    version = this.f26596d.getVersion();
                    int miUniPay = iGameCenterSDK.miUniPay(miBuyInfo, version);
                    this.f26596d.mTouch = false;
                    MiCommplatform miCommplatform = this.f26596d;
                    context2 = this.f26596d.ctx;
                    miCommplatform.disconnect(context2);
                    if (miUniPay != -18008) {
                        check_user_changed = this.f26596d.check_user_changed(this.f26595c, miUniPay);
                        if (!check_user_changed) {
                            this.f26594b.finishPayProcess(miUniPay);
                            this.f26596d.sendLogToSDKSerivce("=============uni:" + miUniPay);
                        }
                        return;
                    }
                    this.f26596d.sendToastMsg();
                    onPayProcessListener = this.f26594b;
                }
            } else {
                this.f26596d.mTouch = false;
                onPayProcessListener = this.f26594b;
            }
            onPayProcessListener.finishPayProcess(-18003);
        } finally {
            this.f26596d.mTouch = false;
            MiCommplatform miCommplatform2 = this.f26596d;
            context = miCommplatform2.ctx;
            miCommplatform2.disconnect(context);
        }
    }
}
