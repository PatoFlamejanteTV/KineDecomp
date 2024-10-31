package com.nexstreaming.kinemaster.ui.projectedit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* loaded from: classes2.dex */
public class xh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TimelineView f22783a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public xh(TimelineView timelineView) {
        this.f22783a = timelineView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f22783a.c(false);
    }
}
