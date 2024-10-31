package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.content.Context;
import com.xiaomi.gamecenter.sdk.entry.LoginResult;
import com.xiaomi.gamecenter.sdk.entry.MiAppInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f4877a;
    final /* synthetic */ OnLoginProcessListener b;
    final /* synthetic */ MiCommplatform c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(MiCommplatform miCommplatform, Activity activity, OnLoginProcessListener onLoginProcessListener) {
        this.c = miCommplatform;
        this.f4877a = activity;
        this.b = onLoginProcessListener;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean isTopActivity;
        Context context;
        Context context2;
        int check_and_connect;
        IGameCenterSDK iGameCenterSDK;
        String version;
        Context context3;
        Context context4;
        MiAppInfo miAppInfo;
        Context context5;
        Context context6;
        try {
            try {
                check_and_connect = this.c.check_and_connect(this.f4877a, true);
                if (check_and_connect != 0) {
                    this.c.mTouch = false;
                    this.b.finishLoginProcess(-102, null);
                    this.c.mTouch = false;
                    MiCommplatform miCommplatform = this.c;
                    context6 = this.c.ctx;
                    miCommplatform.disconnect(context6);
                    return;
                }
                iGameCenterSDK = this.c.sdk;
                version = this.c.getVersion();
                LoginResult miLogin = iGameCenterSDK.miLogin(version);
                this.c.mTouch = false;
                if (miLogin != null) {
                    MiCommplatform miCommplatform2 = this.c;
                    context4 = this.c.ctx;
                    miCommplatform2.disconnect(context4);
                    if (miLogin.getErrcode() == -18008) {
                        this.c.sendToastMsg();
                        this.b.finishLoginProcess(-102, null);
                        this.c.mTouch = false;
                        MiCommplatform miCommplatform3 = this.c;
                        context5 = this.c.ctx;
                        miCommplatform3.disconnect(context5);
                        return;
                    }
                    miAppInfo = this.c.appInfo;
                    miAppInfo.setAccount(miLogin.getAccount());
                    this.b.finishLoginProcess(miLogin.getErrcode(), miLogin.getAccount());
                } else {
                    this.b.finishLoginProcess(-102, null);
                }
                this.c.mTouch = false;
                MiCommplatform miCommplatform4 = this.c;
                context3 = this.c.ctx;
                miCommplatform4.disconnect(context3);
            } catch (Exception e) {
                e.printStackTrace();
                this.c.mTouch = false;
                if (this.c.isSdkServiceExist(this.f4877a)) {
                    this.b.finishLoginProcess(-102, null);
                } else {
                    while (true) {
                        try {
                            isTopActivity = this.c.isTopActivity(this.f4877a);
                            if (isTopActivity) {
                                break;
                            }
                            try {
                                Thread.sleep(500L);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        } catch (Exception e3) {
                            this.b.finishLoginProcess(-102, null);
                            e3.printStackTrace();
                        }
                    }
                    if (this.c.isSdkServiceExist(this.f4877a)) {
                        this.c.miLogin(this.f4877a, this.b);
                    } else {
                        this.b.finishLoginProcess(-102, null);
                    }
                }
                this.c.mTouch = false;
                MiCommplatform miCommplatform5 = this.c;
                context = this.c.ctx;
                miCommplatform5.disconnect(context);
            }
        } catch (Throwable th) {
            this.c.mTouch = false;
            MiCommplatform miCommplatform6 = this.c;
            context2 = this.c.ctx;
            miCommplatform6.disconnect(context2);
            throw th;
        }
    }
}
