package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;

/* compiled from: StrokeContent.java */
/* loaded from: classes.dex */
class ab extends A {
    private final String m;
    private final AbstractC0651ha<Integer> n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(C0661ma c0661ma, AbstractC0683y abstractC0683y, ShapeStroke shapeStroke) {
        super(c0661ma, abstractC0683y, shapeStroke.a().toPaintCap(), shapeStroke.d().toPaintJoin(), shapeStroke.g(), shapeStroke.h(), shapeStroke.e(), shapeStroke.c());
        this.m = shapeStroke.f();
        this.n = shapeStroke.b().a2();
        this.n.a(this);
        abstractC0683y.a(this.n);
    }

    @Override // com.airbnb.lottie.M
    public void a(String str, String str2, ColorFilter colorFilter) {
        this.f7593h.setColorFilter(colorFilter);
    }

    @Override // com.airbnb.lottie.J
    public String getName() {
        return this.m;
    }

    @Override // com.airbnb.lottie.A, com.airbnb.lottie.M
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.f7593h.setColor(((Integer) this.n.b()).intValue());
        super.a(canvas, matrix, i);
    }
}
