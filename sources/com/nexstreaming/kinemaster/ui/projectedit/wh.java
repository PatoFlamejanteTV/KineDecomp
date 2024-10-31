package com.nexstreaming.kinemaster.ui.projectedit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* loaded from: classes2.dex */
public class wh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TimelineView f22760a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public wh(TimelineView timelineView) {
        this.f22760a = timelineView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f22760a.c(true);
    }
}
