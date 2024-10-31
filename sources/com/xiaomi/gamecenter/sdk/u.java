package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.content.Context;
import com.xiaomi.gamecenter.sdk.gam.MiGamMessageResponse;
import com.xiaomi.gamecenter.sdk.gam.MiResponseHandler;

/* loaded from: classes.dex */
class u extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f4908a;
    final /* synthetic */ MiResponseHandler b;
    final /* synthetic */ MiCommplatform c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MiCommplatform miCommplatform, Activity activity, MiResponseHandler miResponseHandler) {
        this.c = miCommplatform;
        this.f4908a = activity;
        this.b = miResponseHandler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        int check_and_connect;
        IGameCenterSDK iGameCenterSDK;
        Context context3;
        boolean check_user_changed;
        Context context4;
        try {
            try {
                check_and_connect = this.c.check_and_connect(this.f4908a, false);
                if (check_and_connect != 0) {
                    this.c.mTouch = false;
                    this.b.sendResultMsg(-107, null);
                    this.c.mTouch = false;
                    MiCommplatform miCommplatform = this.c;
                    context4 = this.c.ctx;
                    miCommplatform.disconnect(context4);
                    return;
                }
                iGameCenterSDK = this.c.sdk;
                MiGamMessageResponse unionList = iGameCenterSDK.getUnionList();
                if (unionList != null) {
                    this.c.mTouch = false;
                    check_user_changed = this.c.check_user_changed(this.f4908a, unionList.getSdkStatus());
                    if (!check_user_changed) {
                        this.b.sendResultMsg(unionList.getSdkStatus(), unionList.getMsgResult());
                    }
                } else {
                    this.b.sendResultMsg(-107, null);
                }
                this.c.mTouch = false;
                MiCommplatform miCommplatform2 = this.c;
                context3 = this.c.ctx;
                miCommplatform2.disconnect(context3);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    this.c.mTouch = false;
                    this.b.sendResultMsg(-107, null);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.c.mTouch = false;
                MiCommplatform miCommplatform3 = this.c;
                context = this.c.ctx;
                miCommplatform3.disconnect(context);
            }
        } catch (Throwable th) {
            this.c.mTouch = false;
            MiCommplatform miCommplatform4 = this.c;
            context2 = this.c.ctx;
            miCommplatform4.disconnect(context2);
            throw th;
        }
    }
}
