package com.nexstreaming.kinemaster.ui.projectedit;

/* compiled from: TimelineView.java */
/* loaded from: classes.dex */
class me implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TimelineView f4086a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public me(TimelineView timelineView) {
        this.f4086a = timelineView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4086a.c(false);
    }
}
