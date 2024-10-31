package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;
import android.os.Build;
import com.github.ybq.android.spinkit.b.q;

/* compiled from: FadingCircle.java */
/* loaded from: classes.dex */
public class f extends com.github.ybq.android.spinkit.b.a {

    /* compiled from: FadingCircle.java */
    /* loaded from: classes.dex */
    private class a extends com.github.ybq.android.spinkit.b.b {
        a() {
            setAlpha(0);
        }

        @Override // com.github.ybq.android.spinkit.b.q
        public ValueAnimator p() {
            float[] fArr = {0.0f, 0.39f, 0.4f, 1.0f};
            com.github.ybq.android.spinkit.a.d dVar = new com.github.ybq.android.spinkit.a.d(this);
            dVar.a(fArr, 0, 0, 255, 0);
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
