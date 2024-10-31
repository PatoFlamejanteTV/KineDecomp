package com.nexstreaming.kinemaster.ui.projectedit.timeline;

/* compiled from: TimelineItemDragDecoration.java */
/* loaded from: classes2.dex */
class D implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bolts.q f22564a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ I f22565b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(I i, bolts.q qVar) {
        this.f22565b = i;
        this.f22564a = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f22564a.a((bolts.q) this.f22565b);
    }
}
