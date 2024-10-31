package com.xiaomi.licensinglibrary;

import android.app.Activity;

/* loaded from: classes3.dex */
class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f26661a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(g gVar) {
        this.f26661a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        Activity activity;
        cVar = this.f26661a.f26655a.purchaseWindow;
        activity = this.f26661a.f26655a.mActivity;
        cVar.a(activity, "正在查询购买结果");
    }
}
