package com.xiaomi.licensinglibrary;

/* loaded from: classes3.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f26656a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f26657b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, int i) {
        this.f26657b = gVar;
        this.f26656a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        cVar = this.f26657b.f26655a.purchaseWindow;
        cVar.a(this.f26656a);
    }
}
