package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.v4.util.LongSparseArray;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CompositionLayer.java */
/* loaded from: classes.dex */
public class H extends AbstractC0683y {
    private final List<AbstractC0683y> u;
    private final RectF v;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(C0661ma c0661ma, Layer layer, List<Layer> list, C0657ka c0657ka) {
        super(c0661ma, layer);
        int i;
        this.u = new ArrayList();
        this.v = new RectF();
        LongSparseArray longSparseArray = new LongSparseArray(c0657ka.h().size());
        int size = list.size() - 1;
        AbstractC0683y abstractC0683y = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            AbstractC0683y a2 = AbstractC0683y.a(layer2, c0661ma, c0657ka);
            if (a2 != null) {
                longSparseArray.put(a2.b().a(), a2);
                if (abstractC0683y != null) {
                    abstractC0683y.a(a2);
                    abstractC0683y = null;
                } else {
                    this.u.add(0, a2);
                    int i2 = G.f7615a[layer2.e().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        abstractC0683y = a2;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            AbstractC0683y abstractC0683y2 = (AbstractC0683y) longSparseArray.get(longSparseArray.keyAt(i));
            AbstractC0683y abstractC0683y3 = (AbstractC0683y) longSparseArray.get(abstractC0683y2.b().g());
            if (abstractC0683y3 != null) {
                abstractC0683y2.b(abstractC0683y3);
            }
        }
    }

    @Override // com.airbnb.lottie.AbstractC0683y, com.airbnb.lottie.M
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.v.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.u.size() - 1; size >= 0; size--) {
            this.u.get(size).a(this.v, this.k);
            if (rectF.isEmpty()) {
                rectF.set(this.v);
            } else {
                rectF.set(Math.min(rectF.left, this.v.left), Math.min(rectF.top, this.v.top), Math.max(rectF.right, this.v.right), Math.max(rectF.bottom, this.v.bottom));
            }
        }
    }

    @Override // com.airbnb.lottie.AbstractC0683y
    void b(Canvas canvas, Matrix matrix, int i) {
        for (int size = this.u.size() - 1; size >= 0; size--) {
            this.u.get(size).a(canvas, matrix, i);
        }
    }

    @Override // com.airbnb.lottie.AbstractC0683y
    public void a(float f2) {
        super.a(f2);
        float m = f2 - this.m.m();
        for (int size = this.u.size() - 1; size >= 0; size--) {
            this.u.get(size).a(m);
        }
    }

    @Override // com.airbnb.lottie.AbstractC0683y, com.airbnb.lottie.M
    public void a(String str, String str2, ColorFilter colorFilter) {
        for (int i = 0; i < this.u.size(); i++) {
            AbstractC0683y abstractC0683y = this.u.get(i);
            String f2 = abstractC0683y.b().f();
            if (str == null) {
                abstractC0683y.a((String) null, (String) null, colorFilter);
            } else if (f2.equals(str)) {
                abstractC0683y.a(str, str2, colorFilter);
            }
        }
    }
}
