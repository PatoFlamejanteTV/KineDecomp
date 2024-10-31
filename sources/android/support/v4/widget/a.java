package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.g.n;
import android.support.v4.g.p;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* compiled from: AutoScrollHelper.java */
/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {
    private static final int r = ViewConfiguration.getTapTimeout();
    private final View c;
    private Runnable d;
    private int g;
    private int h;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;

    /* renamed from: a, reason: collision with root package name */
    private final C0013a f106a = new C0013a();
    private final Interpolator b = new AccelerateInterpolator();
    private float[] e = {0.0f, 0.0f};
    private float[] f = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] i = {0.0f, 0.0f};
    private float[] j = {0.0f, 0.0f};
    private float[] k = {Float.MAX_VALUE, Float.MAX_VALUE};

    public abstract void a(int i, int i2);

    public abstract boolean e(int i);

    public abstract boolean f(int i);

    public a(View view) {
        this.c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        a(i, i);
        b(i2, i2);
        a(1);
        e(Float.MAX_VALUE, Float.MAX_VALUE);
        d(0.2f, 0.2f);
        c(1.0f, 1.0f);
        b(r);
        c(500);
        d(500);
    }

    public a a(boolean z) {
        if (this.p && !z) {
            c();
        }
        this.p = z;
        return this;
    }

    public a a(float f, float f2) {
        this.k[0] = f / 1000.0f;
        this.k[1] = f2 / 1000.0f;
        return this;
    }

    public a b(float f, float f2) {
        this.j[0] = f / 1000.0f;
        this.j[1] = f2 / 1000.0f;
        return this;
    }

    public a c(float f, float f2) {
        this.i[0] = f / 1000.0f;
        this.i[1] = f2 / 1000.0f;
        return this;
    }

    public a a(int i) {
        this.g = i;
        return this;
    }

    public a d(float f, float f2) {
        this.e[0] = f;
        this.e[1] = f2;
        return this;
    }

    public a e(float f, float f2) {
        this.f[0] = f;
        this.f[1] = f2;
        return this;
    }

    public a b(int i) {
        this.h = i;
        return this;
    }

    public a c(int i) {
        this.f106a.a(i);
        return this;
    }

    public a d(int i) {
        this.f106a.b(i);
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.p) {
            return false;
        }
        switch (n.a(motionEvent)) {
            case 0:
                this.n = true;
                this.l = false;
                this.f106a.a(a(0, motionEvent.getX(), view.getWidth(), this.c.getWidth()), a(1, motionEvent.getY(), view.getHeight(), this.c.getHeight()));
                if (!this.o && a()) {
                    b();
                    break;
                }
                break;
            case 1:
            case 3:
                c();
                break;
            case 2:
                this.f106a.a(a(0, motionEvent.getX(), view.getWidth(), this.c.getWidth()), a(1, motionEvent.getY(), view.getHeight(), this.c.getHeight()));
                if (!this.o) {
                    b();
                    break;
                }
                break;
        }
        return this.q && this.o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        C0013a c0013a = this.f106a;
        int f = c0013a.f();
        int e = c0013a.e();
        return (f != 0 && f(f)) || (e != 0 && e(e));
    }

    private void b() {
        if (this.d == null) {
            this.d = new b();
        }
        this.o = true;
        this.m = true;
        if (!this.l && this.h > 0) {
            p.a(this.c, this.d, this.h);
        } else {
            this.d.run();
        }
        this.l = true;
    }

    private void c() {
        if (this.m) {
            this.o = false;
        } else {
            this.f106a.b();
        }
    }

    private float a(int i, float f, float f2, float f3) {
        float a2 = a(this.e[i], f2, this.f[i], f);
        if (a2 == 0.0f) {
            return 0.0f;
        }
        float f4 = this.i[i];
        float f5 = this.j[i];
        float f6 = this.k[i];
        float f7 = f4 * f3;
        if (a2 > 0.0f) {
            return b(a2 * f7, f5, f6);
        }
        return -b((-a2) * f7, f5, f6);
    }

    private float a(float f, float f2, float f3, float f4) {
        float interpolation;
        float b2 = b(f * f2, 0.0f, f3);
        float f5 = f(f2 - f4, b2) - f(f4, b2);
        if (f5 < 0.0f) {
            interpolation = -this.b.getInterpolation(-f5);
        } else {
            if (f5 <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.b.getInterpolation(f5);
        }
        return b(interpolation, -1.0f, 1.0f);
    }

    private float f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.g) {
            case 0:
            case 1:
                if (f >= f2) {
                    return 0.0f;
                }
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                return (this.o && this.g == 1) ? 1.0f : 0.0f;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        return i < i2 ? i2 : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float b(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        return f < f2 ? f2 : f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.c.onTouchEvent(obtain);
        obtain.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AutoScrollHelper.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.o) {
                if (a.this.m) {
                    a.this.m = false;
                    a.this.f106a.a();
                }
                C0013a c0013a = a.this.f106a;
                if (c0013a.c() || !a.this.a()) {
                    a.this.o = false;
                    return;
                }
                if (a.this.n) {
                    a.this.n = false;
                    a.this.d();
                }
                c0013a.d();
                a.this.a(c0013a.g(), c0013a.h());
                p.a(a.this.c, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AutoScrollHelper.java */
    /* renamed from: android.support.v4.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0013a {

        /* renamed from: a, reason: collision with root package name */
        private int f107a;
        private int b;
        private float c;
        private float d;
        private float j;
        private int k;
        private long e = Long.MIN_VALUE;
        private long i = -1;
        private long f = 0;
        private int g = 0;
        private int h = 0;

        public void a(int i) {
            this.f107a = i;
        }

        public void b(int i) {
            this.b = i;
        }

        public void a() {
            this.e = AnimationUtils.currentAnimationTimeMillis();
            this.i = -1L;
            this.f = this.e;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }

        public void b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.b((int) (currentAnimationTimeMillis - this.e), 0, this.b);
            this.j = a(currentAnimationTimeMillis);
            this.i = currentAnimationTimeMillis;
        }

        public boolean c() {
            return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
        }

        private float a(long j) {
            if (j < this.e) {
                return 0.0f;
            }
            if (this.i < 0 || j < this.i) {
                return a.b(((float) (j - this.e)) / this.f107a, 0.0f, 1.0f) * 0.5f;
            }
            return (a.b(((float) (j - this.i)) / this.k, 0.0f, 1.0f) * this.j) + (1.0f - this.j);
        }

        private float a(float f) {
            return ((-4.0f) * f * f) + (4.0f * f);
        }

        public void d() {
            if (this.f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a2 = a(a(currentAnimationTimeMillis));
            long j = currentAnimationTimeMillis - this.f;
            this.f = currentAnimationTimeMillis;
            this.g = (int) (((float) j) * a2 * this.c);
            this.h = (int) (((float) j) * a2 * this.d);
        }

        public void a(float f, float f2) {
            this.c = f;
            this.d = f2;
        }

        public int e() {
            return (int) (this.c / Math.abs(this.c));
        }

        public int f() {
            return (int) (this.d / Math.abs(this.d));
        }

        public int g() {
            return this.g;
        }

        public int h() {
            return this.h;
        }
    }
}
