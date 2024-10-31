package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.WindowManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* loaded from: classes.dex */
public class lt implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TimelineView f4074a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public lt(TimelineView timelineView) {
        this.f4074a = timelineView;
    }

    @Override // java.lang.Runnable
    public void run() {
        WindowManager windowManager;
        int i;
        int i2;
        int i3;
        this.f4074a.removeCallbacks(this);
        this.f4074a.postDelayed(this, 250L);
        windowManager = this.f4074a.aj;
        int rotation = windowManager.getDefaultDisplay().getRotation();
        i = this.f4074a.bq;
        if (i == -1) {
            this.f4074a.bq = rotation;
            return;
        }
        i2 = this.f4074a.bq;
        if (i2 != rotation) {
            TimelineView timelineView = this.f4074a;
            i3 = this.f4074a.bq;
            timelineView.a(i3, rotation);
            this.f4074a.bq = rotation;
        }
    }
}
