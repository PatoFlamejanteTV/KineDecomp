package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.content.Context;
import com.xiaomi.gamecenter.sdk.entry.LoginResult;
import com.xiaomi.gamecenter.sdk.entry.MiAppInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class aa extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f26547a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnLoginProcessListener f26548b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26549c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(MiCommplatform miCommplatform, Activity activity, OnLoginProcessListener onLoginProcessListener) {
        this.f26549c = miCommplatform;
        this.f26547a = activity;
        this.f26548b = onLoginProcessListener;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        boolean isTopActivity;
        int check_and_connect;
        IGameCenterSDK iGameCenterSDK;
        String version;
        Context context2;
        MiAppInfo miAppInfo;
        OnLoginProcessListener onLoginProcessListener;
        try {
            try {
                check_and_connect = this.f26549c.check_and_connect(this.f26547a, true);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f26549c.mTouch = false;
                if (this.f26549c.isSdkServiceExist(this.f26547a)) {
                    this.f26548b.finishLoginProcess(-102, null);
                } else {
                    while (true) {
                        try {
                            isTopActivity = this.f26549c.isTopActivity(this.f26547a);
                            if (isTopActivity) {
                                break;
                            }
                            try {
                                Thread.sleep(500L);
                            } catch (InterruptedException e3) {
                                e3.printStackTrace();
                            }
                        } catch (Exception e4) {
                            this.f26548b.finishLoginProcess(-102, null);
                            e4.printStackTrace();
                        }
                    }
                    if (this.f26549c.isSdkServiceExist(this.f26547a)) {
                        this.f26549c.miLogin(this.f26547a, this.f26548b);
                    } else {
                        this.f26548b.finishLoginProcess(-102, null);
                    }
                }
            }
            if (check_and_connect == 0) {
                iGameCenterSDK = this.f26549c.sdk;
                version = this.f26549c.getVersion();
                LoginResult miLogin = iGameCenterSDK.miLogin(version);
                this.f26549c.mTouch = false;
                if (miLogin != null) {
                    MiCommplatform miCommplatform = this.f26549c;
                    context2 = this.f26549c.ctx;
                    miCommplatform.disconnect(context2);
                    if (miLogin.getErrcode() == -18008) {
                        this.f26549c.sendToastMsg();
                        onLoginProcessListener = this.f26548b;
                    } else {
                        miAppInfo = this.f26549c.appInfo;
                        miAppInfo.setAccount(miLogin.getAccount());
                        this.f26548b.finishLoginProcess(miLogin.getErrcode(), miLogin.getAccount());
                    }
                } else {
                    this.f26548b.finishLoginProcess(-102, null);
                }
                return;
            }
            this.f26549c.mTouch = false;
            onLoginProcessListener = this.f26548b;
            onLoginProcessListener.finishLoginProcess(-102, null);
        } finally {
            this.f26549c.mTouch = false;
            MiCommplatform miCommplatform2 = this.f26549c;
            context = miCommplatform2.ctx;
            miCommplatform2.disconnect(context);
        }
    }
}
