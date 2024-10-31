package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.xiaomi.gamecenter.sdk.entry.MiBuyInfoOnline;

/* loaded from: classes3.dex */
class e extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiBuyInfoOnline f26588a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnPayProcessListener f26589b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Activity f26590c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Bundle f26591d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26592e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MiCommplatform miCommplatform, MiBuyInfoOnline miBuyInfoOnline, OnPayProcessListener onPayProcessListener, Activity activity, Bundle bundle) {
        this.f26592e = miCommplatform;
        this.f26588a = miBuyInfoOnline;
        this.f26589b = onPayProcessListener;
        this.f26590c = activity;
        this.f26591d = bundle;
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
                this.f26592e.sendLogToSDKSerivce("=============Online ex:" + e2.toString());
                e2.printStackTrace();
                try {
                    this.f26592e.mTouch = false;
                    this.f26589b.finishPayProcess(-18003);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (this.f26588a.isValid()) {
                check_and_connect = this.f26592e.check_and_connect(this.f26590c, false);
                if (check_and_connect == 0) {
                    iGameCenterSDK = this.f26592e.sdk;
                    MiBuyInfoOnline miBuyInfoOnline = this.f26588a;
                    version = this.f26592e.getVersion();
                    int miUniPayOnline = iGameCenterSDK.miUniPayOnline(miBuyInfoOnline, version, this.f26591d);
                    this.f26592e.mTouch = false;
                    check_user_changed = this.f26592e.check_user_changed(this.f26590c, miUniPayOnline);
                    if (!check_user_changed) {
                        this.f26589b.finishPayProcess(miUniPayOnline);
                        this.f26592e.sendLogToSDKSerivce("=============Online:" + miUniPayOnline);
                    }
                    return;
                }
                this.f26592e.mTouch = false;
                onPayProcessListener = this.f26589b;
            } else {
                this.f26592e.mTouch = false;
                onPayProcessListener = this.f26589b;
            }
            onPayProcessListener.finishPayProcess(-18003);
        } finally {
            this.f26592e.mTouch = false;
            MiCommplatform miCommplatform = this.f26592e;
            context = miCommplatform.ctx;
            miCommplatform.disconnect(context);
        }
    }
}
