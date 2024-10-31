package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.animation.LinearInterpolator;
import com.github.ybq.android.spinkit.b.q;
import com.github.ybq.android.spinkit.b.r;

/* compiled from: FoldingCube.java */
/* loaded from: classes.dex */
public class g extends r {
    private boolean G = false;

    /* compiled from: FoldingCube.java */
    /* loaded from: classes.dex */
    private class a extends com.github.ybq.android.spinkit.b.c {
        a() {
            setAlpha(0);
            d(-180);
        }

        @Override // com.github.ybq.android.spinkit.b.q
        public ValueAnimator p() {
            float[] fArr = {0.0f, 0.1f, 0.25f, 0.75f, 0.9f, 1.0f};
            com.github.ybq.android.spinkit.a.d dVar = new com.github.ybq.android.spinkit.a.d(this);
            dVar.a(fArr, 0, 0, 255, 255, 0, 0);
            dVar.c(fArr, -180, -180, 0, 0, 0, 0);
            dVar.d(fArr, 0, 0, 0, 0, 180, 180);
            dVar.a(2400L);
            dVar.a(new LinearInterpolator());
            return dVar.a();
        }
    }

    @Override // com.github.ybq.android.spinkit.b.r
    public void b(Canvas canvas) {
        Rect a2 = a(getBounds());
        for (int i = 0; i < r(); i++) {
            int save = canvas.save();
            canvas.rotate((i * 90) + 45, a2.centerX(), a2.centerY());
            h(i).draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.ybq.android.spinkit.b.r, com.github.ybq.android.spinkit.b.q, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect a2 = a(rect);
        int min = Math.min(a2.width(), a2.height());
        if (this.G) {
            min = (int) Math.sqrt((min * min) / 2);
            int width = (a2.width() - min) / 2;
            int height = (a2.height() - min) / 2;
            a2 = new Rect(a2.left + width, a2.top + height, a2.right - width, a2.bottom - height);
        }
        int i = min / 2;
        int i2 = a2.left + i + 1;
        int i3 = a2.top + i + 1;
        for (int i4 = 0; i4 < r(); i4++) {
            q h2 = h(i4);
            h2.a(a2.left, a2.top, i2, i3);
            h2.a(h2.b().right);
            h2.b(h2.b().bottom);
        }
    }

    @Override // com.github.ybq.android.spinkit.b.r
    public q[] s() {
        a[] aVarArr = new a[4];
        for (int i = 0; i < aVarArr.length; i++) {
            aVarArr[i] = new a();
            if (Build.VERSION.SDK_INT >= 24) {
                aVarArr[i].a(i * 300);
            } else {
                aVarArr[i].a((i * 300) - 1200);
            }
        }
        return aVarArr;
    }
}
