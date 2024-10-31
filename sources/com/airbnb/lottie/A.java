package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.AbstractC0677v;
import com.airbnb.lottie.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseStrokeContent.java */
/* loaded from: classes.dex */
public abstract class A implements M, AbstractC0677v.a {

    /* renamed from: e, reason: collision with root package name */
    private final C0661ma f7590e;

    /* renamed from: g, reason: collision with root package name */
    private final float[] f7592g;
    private final AbstractC0677v<?, Float> i;
    private final AbstractC0677v<?, Integer> j;
    private final List<AbstractC0677v<?, Float>> k;
    private final AbstractC0677v<?, Float> l;

    /* renamed from: a, reason: collision with root package name */
    private final PathMeasure f7586a = new PathMeasure();

    /* renamed from: b, reason: collision with root package name */
    private final Path f7587b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final Path f7588c = new Path();

    /* renamed from: d, reason: collision with root package name */
    private final RectF f7589d = new RectF();

    /* renamed from: f, reason: collision with root package name */
    private final List<a> f7591f = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    final Paint f7593h = new Paint(1);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseStrokeContent.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<InterfaceC0684ya> f7594a;

        /* renamed from: b, reason: collision with root package name */
        private final cb f7595b;

        private a(cb cbVar) {
            this.f7594a = new ArrayList();
            this.f7595b = cbVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(C0661ma c0661ma, AbstractC0683y abstractC0683y, Paint.Cap cap, Paint.Join join, C0650h c0650h, C0642d c0642d, List<C0642d> list, C0642d c0642d2) {
        this.f7590e = c0661ma;
        this.f7593h.setStyle(Paint.Style.STROKE);
        this.f7593h.setStrokeCap(cap);
        this.f7593h.setStrokeJoin(join);
        this.j = c0650h.a2();
        this.i = c0642d.a2();
        if (c0642d2 == null) {
            this.l = null;
        } else {
            this.l = c0642d2.a2();
        }
        this.k = new ArrayList(list.size());
        this.f7592g = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.k.add(list.get(i).a2());
        }
        abstractC0683y.a(this.j);
        abstractC0683y.a(this.i);
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            abstractC0683y.a(this.k.get(i2));
        }
        AbstractC0677v<?, Float> abstractC0677v = this.l;
        if (abstractC0677v != null) {
            abstractC0683y.a(abstractC0677v);
        }
        this.j.a(this);
        this.i.a(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.k.get(i3).a(this);
        }
        AbstractC0677v<?, Float> abstractC0677v2 = this.l;
        if (abstractC0677v2 != null) {
            abstractC0677v2.a(this);
        }
    }

    @Override // com.airbnb.lottie.AbstractC0677v.a
    public void a() {
        this.f7590e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.J
    public void a(List<J> list, List<J> list2) {
        cb cbVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            J j = list.get(size);
            if (j instanceof cb) {
                cb cbVar2 = (cb) j;
                if (cbVar2.e() == ShapeTrimPath.Type.Individually) {
                    cbVar = cbVar2;
                }
            }
        }
        if (cbVar != null) {
            cbVar.a(this);
        }
        a aVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            J j2 = list2.get(size2);
            if (j2 instanceof cb) {
                cb cbVar3 = (cb) j2;
                if (cbVar3.e() == ShapeTrimPath.Type.Individually) {
                    if (aVar != null) {
                        this.f7591f.add(aVar);
                    }
                    aVar = new a(cbVar3);
                    cbVar3.a(this);
                }
            }
            if (j2 instanceof InterfaceC0684ya) {
                if (aVar == null) {
                    aVar = new a(cbVar);
                }
                aVar.f7594a.add((InterfaceC0684ya) j2);
            }
        }
        if (aVar != null) {
            this.f7591f.add(aVar);
        }
    }

    @Override // com.airbnb.lottie.M
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.f7593h.setAlpha((int) ((((i / 255.0f) * this.j.b().intValue()) / 100.0f) * 255.0f));
        this.f7593h.setStrokeWidth(this.i.b().floatValue() * db.a(matrix));
        if (this.f7593h.getStrokeWidth() <= 0.0f) {
            return;
        }
        a(matrix);
        for (int i2 = 0; i2 < this.f7591f.size(); i2++) {
            a aVar = this.f7591f.get(i2);
            if (aVar.f7595b != null) {
                a(canvas, aVar, matrix);
            } else {
                this.f7587b.reset();
                for (int size = aVar.f7594a.size() - 1; size >= 0; size--) {
                    this.f7587b.addPath(((InterfaceC0684ya) aVar.f7594a.get(size)).getPath(), matrix);
                }
                canvas.drawPath(this.f7587b, this.f7593h);
            }
        }
    }

    private void a(Canvas canvas, a aVar, Matrix matrix) {
        if (aVar.f7595b == null) {
            return;
        }
        this.f7587b.reset();
        for (int size = aVar.f7594a.size() - 1; size >= 0; size--) {
            this.f7587b.addPath(((InterfaceC0684ya) aVar.f7594a.get(size)).getPath(), matrix);
        }
        this.f7586a.setPath(this.f7587b, false);
        float length = this.f7586a.getLength();
        while (this.f7586a.nextContour()) {
            length += this.f7586a.getLength();
        }
        float floatValue = (aVar.f7595b.c().b().floatValue() * length) / 360.0f;
        float floatValue2 = ((aVar.f7595b.d().b().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((aVar.f7595b.b().b().floatValue() * length) / 100.0f) + floatValue;
        float f2 = 0.0f;
        for (int size2 = aVar.f7594a.size() - 1; size2 >= 0; size2--) {
            this.f7588c.set(((InterfaceC0684ya) aVar.f7594a.get(size2)).getPath());
            this.f7588c.transform(matrix);
            this.f7586a.setPath(this.f7588c, false);
            float length2 = this.f7586a.getLength();
            if (floatValue3 > length) {
                float f3 = floatValue3 - length;
                if (f3 < f2 + length2 && f2 < f3) {
                    db.a(this.f7588c, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f3 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f7588c, this.f7593h);
                    f2 += length2;
                }
            }
            float f4 = f2 + length2;
            if (f4 >= floatValue2 && f2 <= floatValue3) {
                if (f4 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.f7588c, this.f7593h);
                } else {
                    db.a(this.f7588c, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 <= f4 ? (floatValue3 - f2) / length2 : 1.0f, 0.0f);
                    canvas.drawPath(this.f7588c, this.f7593h);
                }
            }
            f2 += length2;
        }
    }

    @Override // com.airbnb.lottie.M
    public void a(RectF rectF, Matrix matrix) {
        this.f7587b.reset();
        for (int i = 0; i < this.f7591f.size(); i++) {
            a aVar = this.f7591f.get(i);
            for (int i2 = 0; i2 < aVar.f7594a.size(); i2++) {
                this.f7587b.addPath(((InterfaceC0684ya) aVar.f7594a.get(i)).getPath(), matrix);
            }
        }
        this.f7587b.computeBounds(this.f7589d, false);
        float floatValue = this.i.b().floatValue();
        RectF rectF2 = this.f7589d;
        float f2 = floatValue / 2.0f;
        rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
        rectF.set(this.f7589d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    private void a(Matrix matrix) {
        if (this.k.isEmpty()) {
            return;
        }
        float c2 = this.f7590e.c() * db.a(matrix);
        for (int i = 0; i < this.k.size(); i++) {
            this.f7592g[i] = this.k.get(i).b().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.f7592g;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f7592g;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.f7592g;
            fArr3[i] = fArr3[i] * c2;
        }
        AbstractC0677v<?, Float> abstractC0677v = this.l;
        this.f7593h.setPathEffect(new DashPathEffect(this.f7592g, abstractC0677v == null ? 0.0f : abstractC0677v.b().floatValue()));
    }
}
