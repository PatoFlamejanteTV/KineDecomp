package com.xiaomi.licensinglibrary;

import android.app.Activity;

/* loaded from: classes.dex */
class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f4927a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(g gVar) {
        this.f4927a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        Activity activity;
        cVar = this.f4927a.f4922a.purchaseWindow;
        activity = this.f4927a.f4922a.mActivity;
        cVar.a(activity, "正在查询购买结果");
    }
}
