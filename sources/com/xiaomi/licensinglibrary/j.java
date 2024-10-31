package com.xiaomi.licensinglibrary;

/* loaded from: classes3.dex */
class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f26659a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.f26659a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        cVar = this.f26659a.f26655a.purchaseWindow;
        cVar.a();
    }
}
