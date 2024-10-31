package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.AbstractC0677v;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientFillContent.java */
/* loaded from: classes.dex */
class X implements M, AbstractC0677v.a {

    /* renamed from: a, reason: collision with root package name */
    private final String f7726a;

    /* renamed from: b, reason: collision with root package name */
    private final LongSparseArray<LinearGradient> f7727b = new LongSparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    private final LongSparseArray<RadialGradient> f7728c = new LongSparseArray<>();

    /* renamed from: d, reason: collision with root package name */
    private final Path f7729d = new Path();

    /* renamed from: e, reason: collision with root package name */
    private final Paint f7730e = new Paint(1);

    /* renamed from: f, reason: collision with root package name */
    private final RectF f7731f = new RectF();

    /* renamed from: g, reason: collision with root package name */
    private final List<InterfaceC0684ya> f7732g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final GradientType f7733h;
    private final AbstractC0651ha<T> i;
    private final AbstractC0651ha<Integer> j;
    private final AbstractC0651ha<PointF> k;
    private final AbstractC0651ha<PointF> l;
    private final C0661ma m;
    private final int n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X(C0661ma c0661ma, AbstractC0683y abstractC0683y, W w) {
        this.f7726a = w.e();
        this.m = c0661ma;
        this.f7733h = w.d();
        this.f7729d.setFillType(w.b());
        this.n = (int) (c0661ma.b().c() / 32);
        this.i = w.c().a2();
        this.i.a(this);
        abstractC0683y.a(this.i);
        this.j = w.f().a2();
        this.j.a(this);
        abstractC0683y.a(this.j);
        this.k = w.g().a2();
        this.k.a(this);
        abstractC0683y.a(this.k);
        this.l = w.a().a2();
        this.l.a(this);
        abstractC0683y.a(this.l);
    }

    private int b() {
        int round = Math.round(this.k.a() * this.n);
        return 527 * round * 31 * Math.round(this.l.a() * this.n) * 31 * Math.round(this.i.a() * this.n);
    }

    private LinearGradient c() {
        long b2 = b();
        LinearGradient linearGradient = this.f7727b.get(b2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.k.b();
        PointF pointF2 = (PointF) this.l.b();
        T t = (T) this.i.b();
        int[] a2 = t.a();
        float[] b3 = t.b();
        RectF rectF = this.f7731f;
        int width = (int) (rectF.left + (rectF.width() / 2.0f) + pointF.x);
        RectF rectF2 = this.f7731f;
        int height = (int) (rectF2.top + (rectF2.height() / 2.0f) + pointF.y);
        RectF rectF3 = this.f7731f;
        int width2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + pointF2.x);
        RectF rectF4 = this.f7731f;
        LinearGradient linearGradient2 = new LinearGradient(width, height, width2, (int) (rectF4.top + (rectF4.height() / 2.0f) + pointF2.y), a2, b3, Shader.TileMode.CLAMP);
        this.f7727b.put(b2, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient d() {
        long b2 = b();
        RadialGradient radialGradient = this.f7728c.get(b2);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.k.b();
        PointF pointF2 = (PointF) this.l.b();
        T t = (T) this.i.b();
        int[] a2 = t.a();
        float[] b3 = t.b();
        RectF rectF = this.f7731f;
        int width = (int) (rectF.left + (rectF.width() / 2.0f) + pointF.x);
        RectF rectF2 = this.f7731f;
        int height = (int) (rectF2.top + (rectF2.height() / 2.0f) + pointF.y);
        RectF rectF3 = this.f7731f;
        int width2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + pointF2.x);
        RectF rectF4 = this.f7731f;
        RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(width2 - width, ((int) ((rectF4.top + (rectF4.height() / 2.0f)) + pointF2.y)) - height), a2, b3, Shader.TileMode.CLAMP);
        this.f7728c.put(b2, radialGradient2);
        return radialGradient2;
    }

    @Override // com.airbnb.lottie.AbstractC0677v.a
    public void a() {
        this.m.invalidateSelf();
    }

    @Override // com.airbnb.lottie.M
    public void a(String str, String str2, ColorFilter colorFilter) {
    }

    @Override // com.airbnb.lottie.J
    public String getName() {
        return this.f7726a;
    }

    @Override // com.airbnb.lottie.J
    public void a(List<J> list, List<J> list2) {
        for (int i = 0; i < list2.size(); i++) {
            J j = list2.get(i);
            if (j instanceof InterfaceC0684ya) {
                this.f7732g.add((InterfaceC0684ya) j);
            }
        }
    }

    @Override // com.airbnb.lottie.M
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.f7729d.reset();
        for (int i2 = 0; i2 < this.f7732g.size(); i2++) {
            this.f7729d.addPath(this.f7732g.get(i2).getPath(), matrix);
        }
        this.f7729d.computeBounds(this.f7731f, false);
        if (this.f7733h == GradientType.Linear) {
            this.f7730e.setShader(c());
        } else {
            this.f7730e.setShader(d());
        }
        this.f7730e.setAlpha((int) ((((i / 255.0f) * ((Integer) this.j.b()).intValue()) / 100.0f) * 255.0f));
        canvas.drawPath(this.f7729d, this.f7730e);
    }

    @Override // com.airbnb.lottie.M
    public void a(RectF rectF, Matrix matrix) {
        this.f7729d.reset();
        for (int i = 0; i < this.f7732g.size(); i++) {
            this.f7729d.addPath(this.f7732g.get(i).getPath(), matrix);
        }
        this.f7729d.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
