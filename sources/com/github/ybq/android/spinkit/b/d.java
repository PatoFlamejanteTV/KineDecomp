package com.github.ybq.android.spinkit.b;

import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: RingSprite.java */
/* loaded from: classes.dex */
public class d extends e {
    @Override // com.github.ybq.android.spinkit.b.e
    public void a(Canvas canvas, Paint paint) {
        if (b() != null) {
            paint.setStyle(Paint.Style.STROKE);
            int min = Math.min(b().width(), b().height()) / 2;
            paint.setStrokeWidth(min / 12);
            canvas.drawCircle(b().centerX(), b().centerY(), min, paint);
        }
    }
}
