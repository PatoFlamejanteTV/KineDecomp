package com.adobe.creativesdk.foundation.internal.twowayview;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearSmoothScroller;

/* compiled from: TwoWayLayoutManager.java */
/* loaded from: classes.dex */
class d extends LinearSmoothScroller {
    final /* synthetic */ TwoWayLayoutManager n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TwoWayLayoutManager twoWayLayoutManager, Context context) {
        super(context);
        this.n = twoWayLayoutManager;
    }

    @Override // android.support.v7.widget.LinearSmoothScroller
    public PointF computeScrollVectorForPosition(int i) {
        boolean z;
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < this.n.e() ? -1 : 1;
        z = this.n.t;
        if (z) {
            return new PointF(0.0f, i2);
        }
        return new PointF(i2, 0.0f);
    }

    @Override // android.support.v7.widget.LinearSmoothScroller
    protected int d() {
        return -1;
    }

    @Override // android.support.v7.widget.LinearSmoothScroller
    protected int e() {
        return -1;
    }
}
