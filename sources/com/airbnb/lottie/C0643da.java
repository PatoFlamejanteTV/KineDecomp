package com.airbnb.lottie;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageLayer.java */
/* renamed from: com.airbnb.lottie.da, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0643da extends AbstractC0683y {
    private final Paint u;
    private final Rect v;
    private final Rect w;
    private final float x;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0643da(C0661ma c0661ma, Layer layer, float f2) {
        super(c0661ma, layer);
        this.u = new Paint(3);
        this.v = new Rect();
        this.w = new Rect();
        this.x = f2;
    }

    private Bitmap h() {
        return this.l.a(this.m.h());
    }

    @Override // com.airbnb.lottie.AbstractC0683y, com.airbnb.lottie.M
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        if (h() != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, r6.getWidth()), Math.min(rectF.bottom, r6.getHeight()));
            this.k.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.AbstractC0683y
    public void b(Canvas canvas, Matrix matrix, int i) {
        Bitmap h2 = h();
        if (h2 == null) {
            return;
        }
        this.u.setAlpha(i);
        canvas.save();
        canvas.concat(matrix);
        this.v.set(0, 0, h2.getWidth(), h2.getHeight());
        this.w.set(0, 0, (int) (h2.getWidth() * this.x), (int) (h2.getHeight() * this.x));
        canvas.drawBitmap(h2, this.v, this.w, this.u);
        canvas.restore();
    }

    @Override // com.airbnb.lottie.AbstractC0683y, com.airbnb.lottie.M
    public void a(String str, String str2, ColorFilter colorFilter) {
        this.u.setColorFilter(colorFilter);
    }
}
