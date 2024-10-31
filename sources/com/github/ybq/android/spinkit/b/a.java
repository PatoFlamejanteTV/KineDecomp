package com.github.ybq.android.spinkit.b;

import android.graphics.Canvas;
import android.graphics.Rect;

/* compiled from: CircleLayoutContainer.java */
/* loaded from: classes.dex */
public abstract class a extends r {
    @Override // com.github.ybq.android.spinkit.b.r
    public void b(Canvas canvas) {
        for (int i = 0; i < r(); i++) {
            q h2 = h(i);
            int save = canvas.save();
            canvas.rotate((i * 360) / r(), getBounds().centerX(), getBounds().centerY());
            h2.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // com.github.ybq.android.spinkit.b.r, com.github.ybq.android.spinkit.b.q, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect a2 = a(rect);
        double width = a2.width();
        Double.isNaN(width);
        double r = r();
        Double.isNaN(r);
        int i = (int) (((width * 3.141592653589793d) / 3.5999999046325684d) / r);
        int centerX = a2.centerX() - i;
        int centerX2 = a2.centerX() + i;
        for (int i2 = 0; i2 < r(); i2++) {
            q h2 = h(i2);
            int i3 = a2.top;
            h2.a(centerX, i3, centerX2, (i * 2) + i3);
        }
    }
}
