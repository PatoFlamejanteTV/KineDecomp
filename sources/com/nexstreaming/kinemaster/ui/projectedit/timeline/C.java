package com.nexstreaming.kinemaster.ui.projectedit.timeline;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineItemDragDecoration.java */
/* loaded from: classes2.dex */
public class C implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f22563a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(I i) {
        this.f22563a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f22563a.n().isComputingLayout()) {
            this.f22563a.n().postOnAnimation(this);
        } else {
            this.f22563a.n().removeItemDecoration(this.f22563a);
        }
    }
}
