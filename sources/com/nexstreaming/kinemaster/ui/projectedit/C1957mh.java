package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: TimelineView.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.mh, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1957mh extends Animation {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TimelineView f22452a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1957mh(TimelineView timelineView) {
        this.f22452a = timelineView;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f2, Transformation transformation) {
        this.f22452a.sb = f2;
        this.f22452a.invalidate();
    }
}
