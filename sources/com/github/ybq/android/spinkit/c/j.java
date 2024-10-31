package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;

/* compiled from: Pulse.java */
/* loaded from: classes.dex */
public class j extends com.github.ybq.android.spinkit.b.b {
    public j() {
        c(0.0f);
    }

    @Override // com.github.ybq.android.spinkit.b.q
    public ValueAnimator p() {
        float[] fArr = {0.0f, 1.0f};
        com.github.ybq.android.spinkit.a.d dVar = new com.github.ybq.android.spinkit.a.d(this);
        dVar.a(fArr, Float.valueOf(0.0f), Float.valueOf(1.0f));
        dVar.a(fArr, 255, 0);
        dVar.a(1000L);
        dVar.a(fArr);
        return dVar.a();
    }
}
