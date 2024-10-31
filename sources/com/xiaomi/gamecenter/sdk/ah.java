package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import com.xiaomi.gamecenter.sdk.entry.MiBuyInfo;

/* loaded from: classes.dex */
class ah implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f4884a;
    final /* synthetic */ String b;
    final /* synthetic */ ag c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar, Activity activity, String str) {
        this.c = agVar;
        this.f4884a = activity;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            MiBuyInfo miBuyInfo = new MiBuyInfo();
            miBuyInfo.setProductCode(this.f4884a.getPackageName());
            miBuyInfo.setCpOrderId(this.b);
            miBuyInfo.setCount(1);
            MiCommplatform.getInstance().miUniPay(this.f4884a, miBuyInfo, new ai(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
