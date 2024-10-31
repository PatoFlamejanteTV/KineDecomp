package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.WindowManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ph, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class RunnableC1984ph implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TimelineView f22482a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1984ph(TimelineView timelineView) {
        this.f22482a = timelineView;
    }

    @Override // java.lang.Runnable
    public void run() {
        WindowManager windowManager;
        int i;
        int i2;
        int i3;
        this.f22482a.removeCallbacks(this);
        this.f22482a.postDelayed(this, 250L);
        windowManager = this.f22482a.N;
        int rotation = windowManager.getDefaultDisplay().getRotation();
        i = this.f22482a.Ya;
        if (i != -1) {
            i2 = this.f22482a.Ya;
            if (i2 != rotation) {
                TimelineView timelineView = this.f22482a;
                i3 = timelineView.Ya;
                timelineView.a(i3, rotation);
                this.f22482a.Ya = rotation;
                return;
            }
            return;
        }
        this.f22482a.Ya = rotation;
    }
}
