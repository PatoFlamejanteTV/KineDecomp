package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;

/* compiled from: PulseRing.java */
/* loaded from: classes.dex */
public class k extends com.github.ybq.android.spinkit.b.d {
    public k() {
        c(0.0f);
    }

    @Override // com.github.ybq.android.spinkit.b.q
    public ValueAnimator p() {
        float[] fArr = {0.0f, 0.7f, 1.0f};
        com.github.ybq.android.spinkit.a.d dVar = new com.github.ybq.android.spinkit.a.d(this);
        Float valueOf = Float.valueOf(1.0f);
        dVar.a(fArr, Float.valueOf(0.0f), valueOf, valueOf);
        dVar.a(fArr, 255, 178, 0);
        dVar.a(1000L);
        dVar.a(com.github.ybq.android.spinkit.a.a.b.a(0.21f, 0.53f, 0.56f, 0.8f, fArr));
        return dVar.a();
    }
}
