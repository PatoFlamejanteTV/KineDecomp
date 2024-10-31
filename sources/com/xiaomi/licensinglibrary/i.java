package com.xiaomi.licensinglibrary;

/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f4924a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.f4924a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        cVar = this.f4924a.f4922a.purchaseWindow;
        cVar.a();
    }
}
