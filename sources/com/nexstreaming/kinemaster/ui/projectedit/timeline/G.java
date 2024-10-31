package com.nexstreaming.kinemaster.ui.projectedit.timeline;

/* compiled from: TimelineItemDragDecoration.java */
/* loaded from: classes2.dex */
class G implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bolts.q f22573a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ I f22574b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G(I i, bolts.q qVar) {
        this.f22574b = i;
        this.f22573a = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f22574b.n().postOnAnimationDelayed(new F(this), 125L);
    }
}
