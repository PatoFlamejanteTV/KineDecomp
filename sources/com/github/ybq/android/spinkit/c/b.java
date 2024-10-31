package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;
import android.os.Build;
import com.github.ybq.android.spinkit.b.q;

/* compiled from: Circle.java */
/* loaded from: classes.dex */
public class b extends com.github.ybq.android.spinkit.b.a {

    /* compiled from: Circle.java */
    /* loaded from: classes.dex */
    private class a extends com.github.ybq.android.spinkit.b.b {
        a() {
            c(0.0f);
        }

        @Override // com.github.ybq.android.spinkit.b.q
        public ValueAnimator p() {
            float[] fArr = {0.0f, 0.5f, 1.0f};
            com.github.ybq.android.spinkit.a.d dVar = new com.github.ybq.android.spinkit.a.d(this);
            Float valueOf = Float.valueOf(0.0f);
            dVar.a(fArr, valueOf, Float.valueOf(1.0f), valueOf);
            dVar.a(1200L);
            dVar.a(fArr);
            return dVar.a();
        }
    }

    @Override // com.github.ybq.android.spinkit.b.r
    public q[] s() {
        a[] aVarArr = new a[12];
        for (int i = 0; i < aVarArr.length; i++) {
            aVarArr[i] = new a();
            if (Build.VERSION.SDK_INT >= 24) {
                aVarArr[i].a(i * 100);
            } else {
                aVarArr[i].a((i * 100) - 1200);
            }
        }
        return aVarArr;
    }
}
