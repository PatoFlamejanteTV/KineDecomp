package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.content.Context;
import com.xiaomi.gamecenter.sdk.gam.MiGamMessageResponse;
import com.xiaomi.gamecenter.sdk.gam.MiResponseHandler;

/* loaded from: classes3.dex */
class u extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f26630a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MiResponseHandler f26631b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26632c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MiCommplatform miCommplatform, Activity activity, MiResponseHandler miResponseHandler) {
        this.f26632c = miCommplatform;
        this.f26630a = activity;
        this.f26631b = miResponseHandler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        int check_and_connect;
        IGameCenterSDK iGameCenterSDK;
        boolean check_user_changed;
        try {
            try {
                check_and_connect = this.f26632c.check_and_connect(this.f26630a, false);
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    this.f26632c.mTouch = false;
                    this.f26631b.sendResultMsg(-107, null);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (check_and_connect != 0) {
                this.f26632c.mTouch = false;
                this.f26631b.sendResultMsg(-107, null);
                return;
            }
            iGameCenterSDK = this.f26632c.sdk;
            MiGamMessageResponse unionList = iGameCenterSDK.getUnionList();
            if (unionList != null) {
                this.f26632c.mTouch = false;
                check_user_changed = this.f26632c.check_user_changed(this.f26630a, unionList.getSdkStatus());
                if (!check_user_changed) {
                    this.f26631b.sendResultMsg(unionList.getSdkStatus(), unionList.getMsgResult());
                }
            } else {
                this.f26631b.sendResultMsg(-107, null);
            }
        } finally {
            this.f26632c.mTouch = false;
            MiCommplatform miCommplatform = this.f26632c;
            context = miCommplatform.ctx;
            miCommplatform.disconnect(context);
        }
    }
}
