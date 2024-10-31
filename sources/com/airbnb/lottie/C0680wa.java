package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NullLayer.java */
/* renamed from: com.airbnb.lottie.wa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0680wa extends AbstractC0683y {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0680wa(C0661ma c0661ma, Layer layer) {
        super(c0661ma, layer);
    }

    @Override // com.airbnb.lottie.AbstractC0683y, com.airbnb.lottie.M
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // com.airbnb.lottie.AbstractC0683y
    void b(Canvas canvas, Matrix matrix, int i) {
    }
}
