package com.xiaomi.licensinglibrary;

/* loaded from: classes3.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f26658a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.f26658a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        cVar = this.f26658a.f26655a.purchaseWindow;
        cVar.a();
    }
}
