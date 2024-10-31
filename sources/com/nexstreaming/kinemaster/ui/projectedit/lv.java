package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* loaded from: classes.dex */
public class lv extends Animation {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TimelineView f4076a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public lv(TimelineView timelineView) {
        this.f4076a = timelineView;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        this.f4076a.bJ = f;
        this.f4076a.invalidate();
    }
}
