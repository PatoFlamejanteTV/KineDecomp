package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.v4.util.LongSparseArray;
import java.util.List;

/* compiled from: GradientStrokeContent.java */
/* renamed from: com.airbnb.lottie.aa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0637aa extends A {
    private final String m;
    private final LongSparseArray<LinearGradient> n;
    private final LongSparseArray<RadialGradient> o;
    private final RectF p;
    private final GradientType q;
    private final int r;
    private final AbstractC0651ha<T> s;
    private final AbstractC0651ha<PointF> t;
    private final AbstractC0651ha<PointF> u;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0637aa(C0661ma c0661ma, AbstractC0683y abstractC0683y, Z z) {
        super(c0661ma, abstractC0683y, z.a().toPaintCap(), z.f().toPaintJoin(), z.i(), z.k(), z.g(), z.b());
        this.n = new LongSparseArray<>();
        this.o = new LongSparseArray<>();
        this.p = new RectF();
        this.m = z.h();
        this.q = z.e();
        this.r = (int) (c0661ma.b().c() / 32);
        this.s = z.d().a2();
        this.s.a(this);
        abstractC0683y.a(this.s);
        this.t = z.j().a2();
        this.t.a(this);
        abstractC0683y.a(this.t);
        this.u = z.c().a2();
        this.u.a(this);
        abstractC0683y.a(this.u);
    }

    private int b() {
        int round = Math.round(this.t.a() * this.r);
        return 527 * round * 31 * Math.round(this.u.a() * this.r) * 31 * Math.round(this.s.a() * this.r);
    }

    private LinearGradient c() {
        long b2 = b();
        LinearGradient linearGradient = this.n.get(b2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.t.b();
        PointF pointF2 = (PointF) this.u.b();
        T t = (T) this.s.b();
        int[] a2 = t.a();
        float[] b3 = t.b();
        RectF rectF = this.p;
        int width = (int) (rectF.left + (rectF.width() / 2.0f) + pointF.x);
        RectF rectF2 = this.p;
        int height = (int) (rectF2.top + (rectF2.height() / 2.0f) + pointF.y);
        RectF rectF3 = this.p;
        int width2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + pointF2.x);
        RectF rectF4 = this.p;
        LinearGradient linearGradient2 = new LinearGradient(width, height, width2, (int) (rectF4.top + (rectF4.height() / 2.0f) + pointF2.y), a2, b3, Shader.TileMode.CLAMP);
        this.n.put(b2, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient d() {
        long b2 = b();
        RadialGradient radialGradient = this.o.get(b2);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.t.b();
        PointF pointF2 = (PointF) this.u.b();
        T t = (T) this.s.b();
        int[] a2 = t.a();
        float[] b3 = t.b();
        RectF rectF = this.p;
        int width = (int) (rectF.left + (rectF.width() / 2.0f) + pointF.x);
        RectF rectF2 = this.p;
        int height = (int) (rectF2.top + (rectF2.height() / 2.0f) + pointF.y);
        RectF rectF3 = this.p;
        int width2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + pointF2.x);
        RectF rectF4 = this.p;
        RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(width2 - width, ((int) ((rectF4.top + (rectF4.height() / 2.0f)) + pointF2.y)) - height), a2, b3, Shader.TileMode.CLAMP);
        this.o.put(b2, radialGradient2);
        return radialGradient2;
    }

    @Override // com.airbnb.lottie.A, com.airbnb.lottie.M
    public /* bridge */ /* synthetic */ void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
    }

    @Override // com.airbnb.lottie.M
    public void a(String str, String str2, ColorFilter colorFilter) {
    }

    @Override // com.airbnb.lottie.J
    public String getName() {
        return this.m;
    }

    @Override // com.airbnb.lottie.A, com.airbnb.lottie.AbstractC0677v.a
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.airbnb.lottie.A, com.airbnb.lottie.J
    public /* bridge */ /* synthetic */ void a(List list, List list2) {
        super.a((List<J>) list, (List<J>) list2);
    }

    @Override // com.airbnb.lottie.A, com.airbnb.lottie.M
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.p, matrix);
        if (this.q == GradientType.Linear) {
            this.f7593h.setShader(c());
        } else {
            this.f7593h.setShader(d());
        }
        super.a(canvas, matrix, i);
    }
}
