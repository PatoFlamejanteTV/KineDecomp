package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.content.Context;
import com.xiaomi.gamecenter.sdk.gam.MiGamMessageResponse;
import com.xiaomi.gamecenter.sdk.gam.MiResponseHandler;

/* loaded from: classes3.dex */
class v extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f26638a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MiResponseHandler f26639b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26640c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(MiCommplatform miCommplatform, Activity activity, MiResponseHandler miResponseHandler) {
        this.f26640c = miCommplatform;
        this.f26638a = activity;
        this.f26639b = miResponseHandler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        int check_and_connect;
        IGameCenterSDK iGameCenterSDK;
        boolean check_user_changed;
        try {
            try {
                check_and_connect = this.f26640c.check_and_connect(this.f26638a, false);
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    this.f26640c.mTouch = false;
                    this.f26639b.sendResultMsg(-107, null);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (check_and_connect != 0) {
                this.f26640c.mTouch = false;
                this.f26639b.sendResultMsg(-107, null);
                return;
            }
            iGameCenterSDK = this.f26640c.sdk;
            MiGamMessageResponse vipList = iGameCenterSDK.getVipList();
            if (vipList != null) {
                this.f26640c.mTouch = false;
                check_user_changed = this.f26640c.check_user_changed(this.f26638a, vipList.getSdkStatus());
                if (!check_user_changed) {
                    this.f26639b.sendResultMsg(vipList.getSdkStatus(), vipList.getMsgResult());
                }
            } else {
                this.f26639b.sendResultMsg(-107, null);
            }
        } finally {
            this.f26640c.mTouch = false;
            MiCommplatform miCommplatform = this.f26640c;
            context = miCommplatform.ctx;
            miCommplatform.disconnect(context);
        }
    }
}
