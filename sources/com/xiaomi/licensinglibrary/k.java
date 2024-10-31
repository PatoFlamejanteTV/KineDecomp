package com.xiaomi.licensinglibrary;

import android.app.Activity;

/* loaded from: classes.dex */
class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f4926a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar) {
        this.f4926a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        Activity activity;
        cVar = this.f4926a.f4922a.purchaseWindow;
        activity = this.f4926a.f4922a.mActivity;
        cVar.a(activity);
    }
}
