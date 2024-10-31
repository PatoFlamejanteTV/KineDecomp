package com.nexstreaming.kinemaster.ui.projectedit;

/* compiled from: TimelineView.java */
/* loaded from: classes.dex */
class md implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TimelineView f4085a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public md(TimelineView timelineView) {
        this.f4085a = timelineView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4085a.c(true);
    }
}
