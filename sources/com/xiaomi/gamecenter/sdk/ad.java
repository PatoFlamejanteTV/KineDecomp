package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.content.Context;
import com.xiaomi.gamecenter.sdk.entry.MiBuyInfoOffline;

/* loaded from: classes.dex */
class ad extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiBuyInfoOffline f4880a;
    final /* synthetic */ OnPayProcessListener b;
    final /* synthetic */ Activity c;
    final /* synthetic */ MiCommplatform d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MiCommplatform miCommplatform, MiBuyInfoOffline miBuyInfoOffline, OnPayProcessListener onPayProcessListener, Activity activity) {
        this.d = miCommplatform;
        this.f4880a = miBuyInfoOffline;
        this.b = onPayProcessListener;
        this.c = activity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        int check_and_connect;
        IGameCenterSDK iGameCenterSDK;
        String version;
        boolean check_user_changed;
        try {
            if (!this.f4880a.isValid()) {
                this.d.mTouch = false;
                this.b.finishPayProcess(-18003);
                return;
            }
            check_and_connect = this.d.check_and_connect(this.c, false);
            if (check_and_connect != 0) {
                this.d.mTouch = false;
                this.b.finishPayProcess(-18003);
                return;
            }
            iGameCenterSDK = this.d.sdk;
            MiBuyInfoOffline miBuyInfoOffline = this.f4880a;
            version = this.d.getVersion();
            int miUniPayOffline = iGameCenterSDK.miUniPayOffline(miBuyInfoOffline, version, null);
            this.d.mTouch = false;
            check_user_changed = this.d.check_user_changed(this.c, miUniPayOffline);
            if (!check_user_changed) {
                this.b.finishPayProcess(miUniPayOffline);
                this.d.sendLogToSDKSerivce("=============Offline:" + miUniPayOffline);
            }
        } catch (Exception e) {
            this.d.sendLogToSDKSerivce("=============Offline ex:" + e.toString());
            e.printStackTrace();
            this.d.mTouch = false;
            this.b.finishPayProcess(-18003);
        } finally {
            this.d.mTouch = false;
            MiCommplatform miCommplatform = this.d;
            context = this.d.ctx;
            miCommplatform.disconnect(context);
        }
    }
}
