package com.xiaomi.licensinglibrary;

import android.app.Activity;

/* loaded from: classes3.dex */
class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f26660a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar) {
        this.f26660a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        Activity activity;
        cVar = this.f26660a.f26655a.purchaseWindow;
        activity = this.f26660a.f26655a.mActivity;
        cVar.a(activity);
    }
}
