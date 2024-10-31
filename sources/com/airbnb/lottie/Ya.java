package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SolidLayer.java */
/* loaded from: classes.dex */
public class Ya extends AbstractC0683y {
    private final RectF u;
    private final Paint v;
    private final Layer w;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ya(C0661ma c0661ma, Layer layer) {
        super(c0661ma, layer);
        this.u = new RectF();
        this.v = new Paint();
        this.w = layer;
        this.v.setAlpha(0);
        this.v.setStyle(Paint.Style.FILL);
        this.v.setColor(layer.j());
    }

    @Override // com.airbnb.lottie.AbstractC0683y, com.airbnb.lottie.M
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        a(this.k);
        rectF.set(this.u);
    }

    @Override // com.airbnb.lottie.AbstractC0683y
    public void b(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.w.j());
        if (alpha == 0) {
            return;
        }
        int intValue = (int) ((((alpha / 255.0f) * this.s.b().b().intValue()) / 100.0f) * 255.0f);
        this.v.setAlpha(intValue);
        if (intValue > 0) {
            a(matrix);
            canvas.drawRect(this.u, this.v);
        }
    }

    private void a(Matrix matrix) {
        this.u.set(0.0f, 0.0f, this.w.l(), this.w.k());
        matrix.mapRect(this.u);
    }

    @Override // com.airbnb.lottie.AbstractC0683y, com.airbnb.lottie.M
    public void a(String str, String str2, ColorFilter colorFilter) {
        this.v.setColorFilter(colorFilter);
    }
}
