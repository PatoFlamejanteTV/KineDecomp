package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Build;
import com.github.ybq.android.spinkit.b.q;
import com.github.ybq.android.spinkit.b.r;

/* compiled from: Wave.java */
/* loaded from: classes.dex */
public class p extends r {

    /* compiled from: Wave.java */
    /* loaded from: classes.dex */
    private class a extends com.github.ybq.android.spinkit.b.c {
        a() {
            e(0.4f);
        }

        @Override // com.github.ybq.android.spinkit.b.q
        public ValueAnimator p() {
            float[] fArr = {0.0f, 0.2f, 0.4f, 1.0f};
            com.github.ybq.android.spinkit.a.d dVar = new com.github.ybq.android.spinkit.a.d(this);
            Float valueOf = Float.valueOf(0.4f);
            dVar.b(fArr, valueOf, Float.valueOf(1.0f), valueOf, valueOf);
            dVar.a(1200L);
            dVar.a(fArr);
            return dVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.ybq.android.spinkit.b.r, com.github.ybq.android.spinkit.b.q, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect a2 = a(rect);
        int width = a2.width() / r();
        int width2 = ((a2.width() / 5) * 3) / 5;
        for (int i = 0; i < r(); i++) {
            q h2 = h(i);
            int i2 = a2.left + (i * width) + (width / 5);
            h2.a(i2, a2.top, i2 + width2, a2.bottom);
        }
    }

    @Override // com.github.ybq.android.spinkit.b.r
    public q[] s() {
        a[] aVarArr = new a[5];
        for (int i = 0; i < aVarArr.length; i++) {
            aVarArr[i] = new a();
            if (Build.VERSION.SDK_INT >= 24) {
                aVarArr[i].a((i * 100) + 600);
            } else {
                aVarArr[i].a((i * 100) - 1200);
            }
        }
        return aVarArr;
    }
}
