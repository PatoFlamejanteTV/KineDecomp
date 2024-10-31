package com.xiaomi.licensinglibrary;

/* loaded from: classes.dex */
class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f4925a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.f4925a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        cVar = this.f4925a.f4922a.purchaseWindow;
        cVar.a();
    }
}
