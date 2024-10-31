package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import com.xiaomi.gamecenter.sdk.entry.MiBuyInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ah implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Activity f26576a;

    /* renamed from: b */
    final /* synthetic */ String f26577b;

    /* renamed from: c */
    final /* synthetic */ ag f26578c;

    public ah(ag agVar, Activity activity, String str) {
        this.f26578c = agVar;
        this.f26576a = activity;
        this.f26577b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            MiBuyInfo miBuyInfo = new MiBuyInfo();
            miBuyInfo.setProductCode(this.f26576a.getPackageName());
            miBuyInfo.setCpOrderId(this.f26577b);
            miBuyInfo.setCount(1);
            MiCommplatform.getInstance().miUniPay(this.f26576a, miBuyInfo, new ai(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
