package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import com.github.ybq.android.spinkit.b.q;
import com.github.ybq.android.spinkit.b.r;

/* compiled from: CubeGrid.java */
/* loaded from: classes.dex */
public class d extends r {

    /* compiled from: CubeGrid.java */
    /* loaded from: classes.dex */
    private class a extends com.github.ybq.android.spinkit.b.c {
        private a() {
        }

        @Override // com.github.ybq.android.spinkit.b.q
        public ValueAnimator p() {
            float[] fArr = {0.0f, 0.35f, 0.7f, 1.0f};
            com.github.ybq.android.spinkit.a.d dVar = new com.github.ybq.android.spinkit.a.d(this);
            Float valueOf = Float.valueOf(1.0f);
            dVar.a(fArr, valueOf, Float.valueOf(0.0f), valueOf, valueOf);
            dVar.a(1300L);
            dVar.a(fArr);
            return dVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.ybq.android.spinkit.b.r, com.github.ybq.android.spinkit.b.q, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect a2 = a(rect);
        int width = (int) (a2.width() * 0.33f);
        int height = (int) (a2.height() * 0.33f);
        for (int i = 0; i < r(); i++) {
            int i2 = a2.left + ((i % 3) * width);
            int i3 = a2.top + ((i / 3) * height);
            h(i).a(i2, i3, i2 + width, i3 + height);
        }
    }

    @Override // com.github.ybq.android.spinkit.b.r
    public q[] s() {
        int[] iArr = {200, 300, 400, 100, 200, 300, 0, 100, 200};
        a[] aVarArr = new a[9];
        for (int i = 0; i < aVarArr.length; i++) {
            aVarArr[i] = new a();
            aVarArr[i].a(iArr[i]);
        }
        return aVarArr;
    }
}
