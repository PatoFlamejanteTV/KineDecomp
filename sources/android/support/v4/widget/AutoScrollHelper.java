package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;

    /* renamed from: a */
    private static final int f1897a = ViewConfiguration.getTapTimeout();

    /* renamed from: d */
    final View f1900d;

    /* renamed from: e */
    private Runnable f1901e;

    /* renamed from: h */
    private int f1904h;
    private int i;
    private boolean m;
    boolean n;
    boolean o;
    boolean p;
    private boolean q;
    private boolean r;

    /* renamed from: b */
    final ClampedScroller f1898b = new ClampedScroller();

    /* renamed from: c */
    private final Interpolator f1899c = new AccelerateInterpolator();

    /* renamed from: f */
    private float[] f1902f = {0.0f, 0.0f};

    /* renamed from: g */
    private float[] f1903g = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] j = {0.0f, 0.0f};
    private float[] k = {0.0f, 0.0f};
    private float[] l = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* loaded from: classes.dex */
    public static class ClampedScroller {

        /* renamed from: a */
        private int f1905a;

        /* renamed from: b */
        private int f1906b;

        /* renamed from: c */
        private float f1907c;

        /* renamed from: d */
        private float f1908d;
        private float j;
        private int k;

        /* renamed from: e */
        private long f1909e = Long.MIN_VALUE;
        private long i = -1;

        /* renamed from: f */
        private long f1910f = 0;

        /* renamed from: g */
        private int f1911g = 0;

        /* renamed from: h */
        private int f1912h = 0;

        ClampedScroller() {
        }

        private float a(float f2) {
            return ((-4.0f) * f2 * f2) + (f2 * 4.0f);
        }

        private float a(long j) {
            if (j < this.f1909e) {
                return 0.0f;
            }
            long j2 = this.i;
            if (j2 >= 0 && j >= j2) {
                long j3 = j - j2;
                float f2 = this.j;
                return (1.0f - f2) + (f2 * AutoScrollHelper.a(((float) j3) / this.k, 0.0f, 1.0f));
            }
            return AutoScrollHelper.a(((float) (j - this.f1909e)) / this.f1905a, 0.0f, 1.0f) * 0.5f;
        }

        public void computeScrollDelta() {
            if (this.f1910f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float a2 = a(a(currentAnimationTimeMillis));
                long j = currentAnimationTimeMillis - this.f1910f;
                this.f1910f = currentAnimationTimeMillis;
                float f2 = ((float) j) * a2;
                this.f1911g = (int) (this.f1907c * f2);
                this.f1912h = (int) (f2 * this.f1908d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int getDeltaX() {
            return this.f1911g;
        }

        public int getDeltaY() {
            return this.f1912h;
        }

        public int getHorizontalDirection() {
            float f2 = this.f1907c;
            return (int) (f2 / Math.abs(f2));
        }

        public int getVerticalDirection() {
            float f2 = this.f1908d;
            return (int) (f2 / Math.abs(f2));
        }

        public boolean isFinished() {
            return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
        }

        public void requestStop() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = AutoScrollHelper.a((int) (currentAnimationTimeMillis - this.f1909e), 0, this.f1906b);
            this.j = a(currentAnimationTimeMillis);
            this.i = currentAnimationTimeMillis;
        }

        public void setRampDownDuration(int i) {
            this.f1906b = i;
        }

        public void setRampUpDuration(int i) {
            this.f1905a = i;
        }

        public void setTargetVelocity(float f2, float f3) {
            this.f1907c = f2;
            this.f1908d = f3;
        }

        public void start() {
            this.f1909e = AnimationUtils.currentAnimationTimeMillis();
            this.i = -1L;
            this.f1910f = this.f1909e;
            this.j = 0.5f;
            this.f1911g = 0;
            this.f1912h = 0;
        }
    }

    /* loaded from: classes.dex */
    public class ScrollAnimationRunnable implements Runnable {
        ScrollAnimationRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (autoScrollHelper.p) {
                if (autoScrollHelper.n) {
                    autoScrollHelper.n = false;
                    autoScrollHelper.f1898b.start();
                }
                ClampedScroller clampedScroller = AutoScrollHelper.this.f1898b;
                if (!clampedScroller.isFinished() && AutoScrollHelper.this.b()) {
                    AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                    if (autoScrollHelper2.o) {
                        autoScrollHelper2.o = false;
                        autoScrollHelper2.a();
                    }
                    clampedScroller.computeScrollDelta();
                    AutoScrollHelper.this.scrollTargetBy(clampedScroller.getDeltaX(), clampedScroller.getDeltaY());
                    ViewCompat.postOnAnimation(AutoScrollHelper.this.f1900d, this);
                    return;
                }
                AutoScrollHelper.this.p = false;
            }
        }
    }

    public AutoScrollHelper(View view) {
        this.f1900d = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f3 = (int) ((1575.0f * f2) + 0.5f);
        setMaximumVelocity(f3, f3);
        float f4 = (int) ((f2 * 315.0f) + 0.5f);
        setMinimumVelocity(f4, f4);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(f1897a);
        setRampUpDuration(500);
        setRampDownDuration(500);
    }

    static float a(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    private float a(int i, float f2, float f3, float f4) {
        float a2 = a(this.f1902f[i], f3, this.f1903g[i], f2);
        if (a2 == 0.0f) {
            return 0.0f;
        }
        float f5 = this.j[i];
        float f6 = this.k[i];
        float f7 = this.l[i];
        float f8 = f5 * f4;
        if (a2 > 0.0f) {
            return a(a2 * f8, f6, f7);
        }
        return -a((-a2) * f8, f6, f7);
    }

    static int a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    private void c() {
        if (this.n) {
            this.p = false;
        } else {
            this.f1898b.requestStop();
        }
    }

    private void d() {
        int i;
        if (this.f1901e == null) {
            this.f1901e = new ScrollAnimationRunnable();
        }
        this.p = true;
        this.n = true;
        if (!this.m && (i = this.i) > 0) {
            ViewCompat.postOnAnimationDelayed(this.f1900d, this.f1901e, i);
        } else {
            this.f1901e.run();
        }
        this.m = true;
    }

    boolean b() {
        ClampedScroller clampedScroller = this.f1898b;
        int verticalDirection = clampedScroller.getVerticalDirection();
        int horizontalDirection = clampedScroller.getHorizontalDirection();
        return (verticalDirection != 0 && canTargetScrollVertically(verticalDirection)) || (horizontalDirection != 0 && canTargetScrollHorizontally(horizontalDirection));
    }

    public abstract boolean canTargetScrollHorizontally(int i);

    public abstract boolean canTargetScrollVertically(int i);

    public boolean isEnabled() {
        return this.q;
    }

    public boolean isExclusive() {
        return this.r;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:            if (r0 != 3) goto L48;     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.q
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.c()
            goto L58
        L1a:
            r5.o = r2
            r5.m = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f1900d
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.a(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f1900d
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.a(r2, r7, r6, r3)
            android.support.v4.widget.AutoScrollHelper$ClampedScroller r7 = r5.f1898b
            r7.setTargetVelocity(r0, r6)
            boolean r6 = r5.p
            if (r6 != 0) goto L58
            boolean r6 = r5.b()
            if (r6 == 0) goto L58
            r5.d()
        L58:
            boolean r6 = r5.r
            if (r6 == 0) goto L61
            boolean r6 = r5.p
            if (r6 == 0) goto L61
            r1 = 1
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public abstract void scrollTargetBy(int i, int i2);

    public AutoScrollHelper setActivationDelay(int i) {
        this.i = i;
        return this;
    }

    public AutoScrollHelper setEdgeType(int i) {
        this.f1904h = i;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean z) {
        if (this.q && !z) {
            c();
        }
        this.q = z;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean z) {
        this.r = z;
        return this;
    }

    public AutoScrollHelper setMaximumEdges(float f2, float f3) {
        float[] fArr = this.f1903g;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public AutoScrollHelper setMaximumVelocity(float f2, float f3) {
        float[] fArr = this.l;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setMinimumVelocity(float f2, float f3) {
        float[] fArr = this.k;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setRampDownDuration(int i) {
        this.f1898b.setRampDownDuration(i);
        return this;
    }

    public AutoScrollHelper setRampUpDuration(int i) {
        this.f1898b.setRampUpDuration(i);
        return this;
    }

    public AutoScrollHelper setRelativeEdges(float f2, float f3) {
        float[] fArr = this.f1902f;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public AutoScrollHelper setRelativeVelocity(float f2, float f3) {
        float[] fArr = this.j;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    private float a(float f2, float f3, float f4, float f5) {
        float interpolation;
        float a2 = a(f2 * f3, 0.0f, f4);
        float a3 = a(f3 - f5, a2) - a(f5, a2);
        if (a3 < 0.0f) {
            interpolation = -this.f1899c.getInterpolation(-a3);
        } else {
            if (a3 <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f1899c.getInterpolation(a3);
        }
        return a(interpolation, -1.0f, 1.0f);
    }

    private float a(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i = this.f1904h;
        if (i == 0 || i == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                if (this.p && this.f1904h == 1) {
                    return 1.0f;
                }
            }
        } else if (i == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
        return 0.0f;
    }

    void a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1900d.onTouchEvent(obtain);
        obtain.recycle();
    }
}
