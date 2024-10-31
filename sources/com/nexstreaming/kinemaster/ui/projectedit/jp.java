package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class jp extends Animation {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4013a;
    final /* synthetic */ int b;
    final /* synthetic */ ProjectEditActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jp(ProjectEditActivity projectEditActivity, int i, int i2) {
        this.c = projectEditActivity;
        this.f4013a = i;
        this.b = i2;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        TimelineView timelineView;
        TimelineView timelineView2;
        timelineView = this.c.k;
        timelineView.getLayoutParams().height = (int) (this.f4013a + ((this.b - this.f4013a) * f));
        timelineView2 = this.c.k;
        timelineView2.requestLayout();
    }

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return true;
    }
}
