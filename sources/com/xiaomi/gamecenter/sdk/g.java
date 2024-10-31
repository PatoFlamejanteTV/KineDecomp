package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.content.Context;
import com.xiaomi.gamecenter.sdk.entry.CardBuyInfo;

/* loaded from: classes3.dex */
class g extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f26597a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnCardPayProcessListener f26598b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ CardBuyInfo f26599c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26600d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MiCommplatform miCommplatform, Activity activity, OnCardPayProcessListener onCardPayProcessListener, CardBuyInfo cardBuyInfo) {
        this.f26600d = miCommplatform;
        this.f26597a = activity;
        this.f26598b = onCardPayProcessListener;
        this.f26599c = cardBuyInfo;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        int check_and_connect;
        IGameCenterSDK iGameCenterSDK;
        String version;
        boolean check_user_changed;
        try {
            try {
                check_and_connect = this.f26600d.check_and_connect(this.f26597a, false);
            } catch (Exception unused) {
                this.f26600d.mTouch = false;
                this.f26598b.finishCardPayProcess(-18003);
            }
            if (check_and_connect != 0) {
                this.f26600d.mTouch = false;
                this.f26598b.finishCardPayProcess(-18003);
                return;
            }
            iGameCenterSDK = this.f26600d.sdk;
            CardBuyInfo cardBuyInfo = this.f26599c;
            version = this.f26600d.getVersion();
            int miCardPay = iGameCenterSDK.miCardPay(cardBuyInfo, version, null);
            this.f26600d.mTouch = false;
            check_user_changed = this.f26600d.check_user_changed(this.f26597a, miCardPay);
            if (!check_user_changed) {
                this.f26598b.finishCardPayProcess(miCardPay);
            }
        } finally {
            this.f26600d.mTouch = false;
            MiCommplatform miCommplatform = this.f26600d;
            context = miCommplatform.ctx;
            miCommplatform.disconnect(context);
        }
    }
}
