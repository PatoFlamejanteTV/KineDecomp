package com.airbnb.lottie;

import android.graphics.PointF;

/* compiled from: CubicCurveData.java */
/* loaded from: classes.dex */
class L {

    /* renamed from: a */
    private final PointF f7636a;

    /* renamed from: b */
    private final PointF f7637b;

    /* renamed from: c */
    private final PointF f7638c;

    public L() {
        this.f7636a = new PointF();
        this.f7637b = new PointF();
        this.f7638c = new PointF();
    }

    public void a(float f2, float f3) {
        this.f7636a.set(f2, f3);
    }

    public void b(float f2, float f3) {
        this.f7637b.set(f2, f3);
    }

    public void c(float f2, float f3) {
        this.f7638c.set(f2, f3);
    }

    public PointF a() {
        return this.f7636a;
    }

    public PointF b() {
        return this.f7637b;
    }

    public PointF c() {
        return this.f7638c;
    }

    public L(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f7636a = pointF;
        this.f7637b = pointF2;
        this.f7638c = pointF3;
    }
}
