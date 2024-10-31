package com.xiaomi.licensinglibrary;

/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4923a;
    final /* synthetic */ g b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, int i) {
        this.b = gVar;
        this.f4923a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        cVar = this.b.f4922a.purchaseWindow;
        cVar.a(this.f4923a);
    }
}
