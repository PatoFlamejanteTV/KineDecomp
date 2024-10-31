package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeLayer.java */
/* loaded from: classes.dex */
public class Ta extends AbstractC0683y {
    private final Matrix u;
    private final K v;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ta(C0661ma c0661ma, Layer layer) {
        super(c0661ma, layer);
        this.u = new Matrix();
        this.v = new K(c0661ma, this, new Ra(layer.f(), layer.i()));
        this.v.a(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.AbstractC0683y, com.airbnb.lottie.M
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.v.a(rectF, this.k);
    }

    @Override // com.airbnb.lottie.AbstractC0683y
    void b(Canvas canvas, Matrix matrix, int i) {
        this.v.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.AbstractC0683y, com.airbnb.lottie.M
    public void a(String str, String str2, ColorFilter colorFilter) {
        this.v.a(str, str2, colorFilter);
    }
}
