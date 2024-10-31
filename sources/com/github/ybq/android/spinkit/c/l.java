package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;

/* compiled from: RotatingCircle.java */
/* loaded from: classes.dex */
public class l extends com.github.ybq.android.spinkit.b.b {
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
