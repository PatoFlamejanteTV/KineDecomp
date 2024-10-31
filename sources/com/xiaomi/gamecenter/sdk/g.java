package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.content.Context;
import com.xiaomi.gamecenter.sdk.entry.CardBuyInfo;

/* loaded from: classes.dex */
class g extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f4893a;
    final /* synthetic */ OnCardPayProcessListener b;
    final /* synthetic */ CardBuyInfo c;
    final /* synthetic */ MiCommplatform d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MiCommplatform miCommplatform, Activity activity, OnCardPayProcessListener onCardPayProcessListener, CardBuyInfo cardBuyInfo) {
        this.d = miCommplatform;
        this.f4893a = activity;
        this.b = onCardPayProcessListener;
        this.c = cardBuyInfo;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        int check_and_connect;
        IGameCenterSDK iGameCenterSDK;
        String version;
        boolean check_user_changed;
        try {
            check_and_connect = this.d.check_and_connect(this.f4893a, false);
            if (check_and_connect != 0) {
                this.d.mTouch = false;
                this.b.finishCardPayProcess(-18003);
                return;
            }
            iGameCenterSDK = this.d.sdk;
            CardBuyInfo cardBuyInfo = this.c;
            version = this.d.getVersion();
            int miCardPay = iGameCenterSDK.miCardPay(cardBuyInfo, version, null);
            this.d.mTouch = false;
            check_user_changed = this.d.check_user_changed(this.f4893a, miCardPay);
            if (!check_user_changed) {
                this.b.finishCardPayProcess(miCardPay);
            }
        } catch (Exception e) {
            this.d.mTouch = false;
            this.b.finishCardPayProcess(-18003);
        } finally {
            this.d.mTouch = false;
            MiCommplatform miCommplatform = this.d;
            context = this.d.ctx;
            miCommplatform.disconnect(context);
        }
    }
}
