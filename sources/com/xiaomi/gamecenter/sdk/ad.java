package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.content.Context;
import com.xiaomi.gamecenter.sdk.entry.MiBuyInfoOffline;

/* loaded from: classes3.dex */
class ad extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiBuyInfoOffline f26554a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnPayProcessListener f26555b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Activity f26556c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26557d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MiCommplatform miCommplatform, MiBuyInfoOffline miBuyInfoOffline, OnPayProcessListener onPayProcessListener, Activity activity) {
        this.f26557d = miCommplatform;
        this.f26554a = miBuyInfoOffline;
        this.f26555b = onPayProcessListener;
        this.f26556c = activity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        int check_and_connect;
        IGameCenterSDK iGameCenterSDK;
        String version;
        boolean check_user_changed;
        OnPayProcessListener onPayProcessListener;
        try {
            try {
            } catch (Exception e2) {
                this.f26557d.sendLogToSDKSerivce("=============Offline ex:" + e2.toString());
                e2.printStackTrace();
                this.f26557d.mTouch = false;
                this.f26555b.finishPayProcess(-18003);
            }
            if (this.f26554a.isValid()) {
                check_and_connect = this.f26557d.check_and_connect(this.f26556c, false);
                if (check_and_connect == 0) {
                    iGameCenterSDK = this.f26557d.sdk;
                    MiBuyInfoOffline miBuyInfoOffline = this.f26554a;
                    version = this.f26557d.getVersion();
                    int miUniPayOffline = iGameCenterSDK.miUniPayOffline(miBuyInfoOffline, version, null);
                    this.f26557d.mTouch = false;
                    check_user_changed = this.f26557d.check_user_changed(this.f26556c, miUniPayOffline);
                    if (!check_user_changed) {
                        this.f26555b.finishPayProcess(miUniPayOffline);
                        this.f26557d.sendLogToSDKSerivce("=============Offline:" + miUniPayOffline);
                    }
                    return;
                }
                this.f26557d.mTouch = false;
                onPayProcessListener = this.f26555b;
            } else {
                this.f26557d.mTouch = false;
                onPayProcessListener = this.f26555b;
            }
            onPayProcessListener.finishPayProcess(-18003);
        } finally {
            this.f26557d.mTouch = false;
            MiCommplatform miCommplatform = this.f26557d;
            context = miCommplatform.ctx;
            miCommplatform.disconnect(context);
        }
    }
}
