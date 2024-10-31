package com.airbnb.lottie;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.AbstractC0677v;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TransformKeyframeAnimation.java */
/* loaded from: classes.dex */
public class bb {

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f7751a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    private final AbstractC0677v<?, PointF> f7752b;

    /* renamed from: c, reason: collision with root package name */
    private final AbstractC0677v<?, PointF> f7753c;

    /* renamed from: d, reason: collision with root package name */
    private final AbstractC0677v<?, La> f7754d;

    /* renamed from: e, reason: collision with root package name */
    private final AbstractC0677v<?, Float> f7755e;

    /* renamed from: f, reason: collision with root package name */
    private final AbstractC0677v<?, Integer> f7756f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(r rVar) {
        this.f7752b = rVar.b().a2();
        this.f7753c = rVar.d().a2();
        this.f7754d = rVar.f().a2();
        this.f7755e = rVar.e().a2();
        this.f7756f = rVar.c().a2();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AbstractC0683y abstractC0683y) {
        abstractC0683y.a(this.f7752b);
        abstractC0683y.a(this.f7753c);
        abstractC0683y.a(this.f7754d);
        abstractC0683y.a(this.f7755e);
        abstractC0683y.a(this.f7756f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0677v<?, Integer> b() {
        return this.f7756f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AbstractC0677v.a aVar) {
        this.f7752b.a(aVar);
        this.f7753c.a(aVar);
        this.f7754d.a(aVar);
        this.f7755e.a(aVar);
        this.f7756f.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix a() {
        this.f7751a.reset();
        PointF b2 = this.f7753c.b();
        if (b2.x != 0.0f || b2.y != 0.0f) {
            this.f7751a.preTranslate(b2.x, b2.y);
        }
        float floatValue = this.f7755e.b().floatValue();
        if (floatValue != 0.0f) {
            this.f7751a.preRotate(floatValue);
        }
        La b3 = this.f7754d.b();
        if (b3.a() != 1.0f || b3.b() != 1.0f) {
            this.f7751a.preScale(b3.a(), b3.b());
        }
        PointF b4 = this.f7752b.b();
        if (b4.x != 0.0f || b4.y != 0.0f) {
            this.f7751a.preTranslate(-b4.x, -b4.y);
        }
        return this.f7751a;
    }
}
