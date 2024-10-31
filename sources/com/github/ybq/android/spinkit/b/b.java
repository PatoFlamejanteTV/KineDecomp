package com.github.ybq.android.spinkit.b;

import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: CircleSprite.java */
/* loaded from: classes.dex */
public class b extends e {
    @Override // com.github.ybq.android.spinkit.b.e
    public void a(Canvas canvas, Paint paint) {
        if (b() != null) {
            canvas.drawCircle(b().centerX(), b().centerY(), Math.min(b().width(), b().height()) / 2, paint);
        }
    }
}
