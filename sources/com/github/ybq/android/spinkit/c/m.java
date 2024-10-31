package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;
import android.graphics.Rect;

/* compiled from: RotatingPlane.java */
/* loaded from: classes.dex */
public class m extends com.github.ybq.android.spinkit.b.c {
    @Override // com.github.ybq.android.spinkit.b.q, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        b(a(rect));
    }

    @Override // com.github.ybq.android.spinkit.b.q
    public ValueAnimator p() {
        float[] fArr = {0.0f, 0.5f, 1.0f};
        com.github.ybq.android.spinkit.a.d dVar = new com.github.ybq.android.spinkit.a.d(this);
        dVar.c(fArr, 0, -180, -180);
        dVar.d(fArr, 0, 0, -180);
        dVar.a(1200L);
        dVar.a(fArr);
        return dVar.a();
    }
}
