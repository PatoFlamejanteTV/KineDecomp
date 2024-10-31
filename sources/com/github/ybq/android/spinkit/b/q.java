package com.github.ybq.android.spinkit.b;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* compiled from: Sprite.java */
/* loaded from: classes.dex */
public abstract class q extends Drawable implements ValueAnimator.AnimatorUpdateListener, Animatable, Drawable.Callback {

    /* renamed from: a */
    private static final Rect f9884a = new Rect();

    /* renamed from: b */
    public static final Property<q, Integer> f9885b = new h("rotateX");

    /* renamed from: c */
    public static final Property<q, Integer> f9886c = new i("rotate");

    /* renamed from: d */
    public static final Property<q, Integer> f9887d = new j("rotateY");

    /* renamed from: e */
    public static final Property<q, Integer> f9888e = new k("translateX");

    /* renamed from: f */
    public static final Property<q, Integer> f9889f = new l("translateY");

    /* renamed from: g */
    public static final Property<q, Float> f9890g = new m("translateXPercentage");

    /* renamed from: h */
    public static final Property<q, Float> f9891h = new n("translateYPercentage");
    public static final Property<q, Float> i = new o("scaleX");
    public static final Property<q, Float> j = new p("scaleY");
    public static final Property<q, Float> k = new f("scale");
    public static final Property<q, Integer> l = new g("alpha");
    private float p;
    private float q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private float x;
    private float y;
    private ValueAnimator z;
    private float m = 1.0f;
    private float n = 1.0f;
    private float o = 1.0f;
    private int A = 255;
    protected Rect B = f9884a;
    private Camera C = new Camera();
    private Matrix D = new Matrix();

    public abstract int a();

    public void a(float f2) {
        this.p = f2;
    }

    protected abstract void a(Canvas canvas);

    public void b(float f2) {
        this.q = f2;
    }

    public abstract void b(int i2);

    public void c(int i2) {
        this.w = i2;
    }

    public void d(float f2) {
        this.n = f2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int k2 = k();
        if (k2 == 0) {
            k2 = (int) (getBounds().width() * l());
        }
        int m = m();
        if (m == 0) {
            m = (int) (getBounds().height() * n());
        }
        canvas.translate(k2, m);
        canvas.scale(i(), j(), c(), d());
        canvas.rotate(e(), c(), d());
        if (f() != 0 || g() != 0) {
            this.C.save();
            this.C.rotateX(f());
            this.C.rotateY(g());
            this.C.getMatrix(this.D);
            this.D.preTranslate(-c(), -d());
            this.D.postTranslate(c(), d());
            this.C.restore();
            canvas.concat(this.D);
        }
        a(canvas);
    }

    public int e() {
        return this.w;
    }

    public void f(float f2) {
        this.x = f2;
    }

    public void g(float f2) {
        this.y = f2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.A;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float h() {
        return this.m;
    }

    public float i() {
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return com.github.ybq.android.spinkit.a.a.a(this.z);
    }

    public float j() {
        return this.o;
    }

    public int k() {
        return this.u;
    }

    public float l() {
        return this.x;
    }

    public int m() {
        return this.v;
    }

    public float n() {
        return this.y;
    }

    public ValueAnimator o() {
        if (this.z == null) {
            this.z = p();
        }
        ValueAnimator valueAnimator = this.z;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(this);
            this.z.setStartDelay(this.r);
        }
        return this.z;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        b(rect);
    }

    public abstract ValueAnimator p();

    public void q() {
        this.m = 1.0f;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0.0f;
        this.y = 0.0f;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.A = i2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (com.github.ybq.android.spinkit.a.a.b(this.z)) {
            return;
        }
        this.z = o();
        ValueAnimator valueAnimator = this.z;
        if (valueAnimator == null) {
            return;
        }
        com.github.ybq.android.spinkit.a.a.a((Animator) valueAnimator);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (com.github.ybq.android.spinkit.a.a.b(this.z)) {
            this.z.removeAllUpdateListeners();
            this.z.end();
            q();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }

    public q a(int i2) {
        this.r = i2;
        return this;
    }

    public void b(Rect rect) {
        a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void c(float f2) {
        this.m = f2;
        d(f2);
        e(f2);
    }

    public void d(int i2) {
        this.s = i2;
    }

    public void e(float f2) {
        this.o = f2;
    }

    public void f(int i2) {
        this.u = i2;
    }

    public void g(int i2) {
        this.v = i2;
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.B = new Rect(i2, i3, i4, i5);
        a(b().centerX());
        b(b().centerY());
    }

    public Rect b() {
        return this.B;
    }

    public float d() {
        return this.q;
    }

    public void e(int i2) {
        this.t = i2;
    }

    public int f() {
        return this.s;
    }

    public int g() {
        return this.t;
    }

    public float c() {
        return this.p;
    }

    public Rect a(Rect rect) {
        int min = Math.min(rect.width(), rect.height());
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        int i2 = min / 2;
        return new Rect(centerX - i2, centerY - i2, centerX + i2, centerY + i2);
    }
}
