package android.support.v4.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.Preconditions;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class CircularProgressDrawable extends Drawable implements Animatable {
    public static final int DEFAULT = 1;
    public static final int LARGE = 0;

    /* renamed from: a */
    private static final Interpolator f1919a = new LinearInterpolator();

    /* renamed from: b */
    private static final Interpolator f1920b = new FastOutSlowInInterpolator();

    /* renamed from: c */
    private static final int[] f1921c = {ViewCompat.MEASURED_STATE_MASK};

    /* renamed from: d */
    private final Ring f1922d;

    /* renamed from: e */
    private float f1923e;

    /* renamed from: f */
    private Resources f1924f;

    /* renamed from: g */
    private Animator f1925g;

    /* renamed from: h */
    private float f1926h;
    private boolean i;

    /* renamed from: android.support.v4.widget.CircularProgressDrawable$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ Ring f1927a;

        AnonymousClass1(Ring ring) {
            ring = ring;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            CircularProgressDrawable.this.b(floatValue, ring);
            CircularProgressDrawable.this.a(floatValue, ring, false);
            CircularProgressDrawable.this.invalidateSelf();
        }
    }

    /* renamed from: android.support.v4.widget.CircularProgressDrawable$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements Animator.AnimatorListener {

        /* renamed from: a */
        final /* synthetic */ Ring f1929a;

        AnonymousClass2(Ring ring) {
            ring = ring;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            CircularProgressDrawable.this.a(1.0f, ring, true);
            ring.v();
            ring.t();
            if (CircularProgressDrawable.this.i) {
                CircularProgressDrawable.this.i = false;
                animator.cancel();
                animator.setDuration(1332L);
                animator.start();
                ring.a(false);
                return;
            }
            CircularProgressDrawable.this.f1926h += 1.0f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            CircularProgressDrawable.this.f1926h = 0.0f;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ProgressDrawableSize {
    }

    /* loaded from: classes.dex */
    public static class Ring {
        int[] i;
        int j;
        float k;
        float l;
        float m;
        boolean n;
        Path o;
        float q;
        int r;
        int s;
        int u;

        /* renamed from: a */
        final RectF f1931a = new RectF();

        /* renamed from: b */
        final Paint f1932b = new Paint();

        /* renamed from: c */
        final Paint f1933c = new Paint();

        /* renamed from: d */
        final Paint f1934d = new Paint();

        /* renamed from: e */
        float f1935e = 0.0f;

        /* renamed from: f */
        float f1936f = 0.0f;

        /* renamed from: g */
        float f1937g = 0.0f;

        /* renamed from: h */
        float f1938h = 5.0f;
        float p = 1.0f;
        int t = 255;

        Ring() {
            this.f1932b.setStrokeCap(Paint.Cap.SQUARE);
            this.f1932b.setAntiAlias(true);
            this.f1932b.setStyle(Paint.Style.STROKE);
            this.f1933c.setStyle(Paint.Style.FILL);
            this.f1933c.setAntiAlias(true);
            this.f1934d.setColor(0);
        }

        void a(float f2, float f3) {
            this.r = (int) f2;
            this.s = (int) f3;
        }

        float b() {
            return this.s;
        }

        void c(int i) {
            this.u = i;
        }

        float d() {
            return this.r;
        }

        int e() {
            return this.f1934d.getColor();
        }

        void f(float f2) {
            this.f1938h = f2;
            this.f1932b.setStrokeWidth(f2);
        }

        int[] g() {
            return this.i;
        }

        float h() {
            return this.f1936f;
        }

        int i() {
            return this.i[j()];
        }

        int j() {
            return (this.j + 1) % this.i.length;
        }

        float k() {
            return this.f1937g;
        }

        boolean l() {
            return this.n;
        }

        float m() {
            return this.f1935e;
        }

        int n() {
            return this.i[this.j];
        }

        float o() {
            return this.l;
        }

        float p() {
            return this.m;
        }

        float q() {
            return this.k;
        }

        Paint.Cap r() {
            return this.f1932b.getStrokeCap();
        }

        float s() {
            return this.f1938h;
        }

        void t() {
            d(j());
        }

        void u() {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            e(0.0f);
            c(0.0f);
            d(0.0f);
        }

        void v() {
            this.k = this.f1935e;
            this.l = this.f1936f;
            this.m = this.f1937g;
        }

        void b(int i) {
            this.f1934d.setColor(i);
        }

        void c(float f2) {
            this.f1936f = f2;
        }

        void d(int i) {
            this.j = i;
            this.u = this.i[this.j];
        }

        void e(float f2) {
            this.f1935e = f2;
        }

        void a(Paint.Cap cap) {
            this.f1932b.setStrokeCap(cap);
        }

        void b(float f2) {
            this.q = f2;
        }

        float c() {
            return this.p;
        }

        float f() {
            return this.q;
        }

        void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f1931a;
            float f2 = this.q;
            float f3 = (this.f1938h / 2.0f) + f2;
            if (f2 <= 0.0f) {
                f3 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.r * this.p) / 2.0f, this.f1938h / 2.0f);
            }
            rectF.set(rect.centerX() - f3, rect.centerY() - f3, rect.centerX() + f3, rect.centerY() + f3);
            float f4 = this.f1935e;
            float f5 = this.f1937g;
            float f6 = (f4 + f5) * 360.0f;
            float f7 = ((this.f1936f + f5) * 360.0f) - f6;
            this.f1932b.setColor(this.u);
            this.f1932b.setAlpha(this.t);
            float f8 = this.f1938h / 2.0f;
            rectF.inset(f8, f8);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f1934d);
            float f9 = -f8;
            rectF.inset(f9, f9);
            canvas.drawArc(rectF, f6, f7, false, this.f1932b);
            a(canvas, f6, f7, rectF);
        }

        void d(float f2) {
            this.f1937g = f2;
        }

        void a(Canvas canvas, float f2, float f3, RectF rectF) {
            if (this.n) {
                Path path = this.o;
                if (path == null) {
                    this.o = new Path();
                    this.o.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f4 = (this.r * this.p) / 2.0f;
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo(this.r * this.p, 0.0f);
                Path path2 = this.o;
                float f5 = this.r;
                float f6 = this.p;
                path2.lineTo((f5 * f6) / 2.0f, this.s * f6);
                this.o.offset((min + rectF.centerX()) - f4, rectF.centerY() + (this.f1938h / 2.0f));
                this.o.close();
                this.f1933c.setColor(this.u);
                this.f1933c.setAlpha(this.t);
                canvas.save();
                canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.o, this.f1933c);
                canvas.restore();
            }
        }

        void a(int[] iArr) {
            this.i = iArr;
            d(0);
        }

        void a(ColorFilter colorFilter) {
            this.f1932b.setColorFilter(colorFilter);
        }

        void a(int i) {
            this.t = i;
        }

        int a() {
            return this.t;
        }

        void a(boolean z) {
            if (this.n != z) {
                this.n = z;
            }
        }

        void a(float f2) {
            if (f2 != this.p) {
                this.p = f2;
            }
        }
    }

    public CircularProgressDrawable(Context context) {
        Preconditions.checkNotNull(context);
        this.f1924f = context.getResources();
        this.f1922d = new Ring();
        this.f1922d.a(f1921c);
        setStrokeWidth(2.5f);
        a();
    }

    private int a(float f2, int i, int i2) {
        return ((((i >> 24) & 255) + ((int) ((((i2 >> 24) & 255) - r0) * f2))) << 24) | ((((i >> 16) & 255) + ((int) ((((i2 >> 16) & 255) - r1) * f2))) << 16) | ((((i >> 8) & 255) + ((int) ((((i2 >> 8) & 255) - r2) * f2))) << 8) | ((i & 255) + ((int) (f2 * ((i2 & 255) - r8))));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f1923e, bounds.exactCenterX(), bounds.exactCenterY());
        this.f1922d.a(canvas, bounds);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1922d.a();
    }

    public boolean getArrowEnabled() {
        return this.f1922d.l();
    }

    public float getArrowHeight() {
        return this.f1922d.b();
    }

    public float getArrowScale() {
        return this.f1922d.c();
    }

    public float getArrowWidth() {
        return this.f1922d.d();
    }

    public int getBackgroundColor() {
        return this.f1922d.e();
    }

    public float getCenterRadius() {
        return this.f1922d.f();
    }

    public int[] getColorSchemeColors() {
        return this.f1922d.g();
    }

    public float getEndTrim() {
        return this.f1922d.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float getProgressRotation() {
        return this.f1922d.k();
    }

    public float getStartTrim() {
        return this.f1922d.m();
    }

    public Paint.Cap getStrokeCap() {
        return this.f1922d.r();
    }

    public float getStrokeWidth() {
        return this.f1922d.s();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f1925g.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f1922d.a(i);
        invalidateSelf();
    }

    public void setArrowDimensions(float f2, float f3) {
        this.f1922d.a(f2, f3);
        invalidateSelf();
    }

    public void setArrowEnabled(boolean z) {
        this.f1922d.a(z);
        invalidateSelf();
    }

    public void setArrowScale(float f2) {
        this.f1922d.a(f2);
        invalidateSelf();
    }

    public void setBackgroundColor(int i) {
        this.f1922d.b(i);
        invalidateSelf();
    }

    public void setCenterRadius(float f2) {
        this.f1922d.b(f2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1922d.a(colorFilter);
        invalidateSelf();
    }

    public void setColorSchemeColors(int... iArr) {
        this.f1922d.a(iArr);
        this.f1922d.d(0);
        invalidateSelf();
    }

    public void setProgressRotation(float f2) {
        this.f1922d.d(f2);
        invalidateSelf();
    }

    public void setStartEndTrim(float f2, float f3) {
        this.f1922d.e(f2);
        this.f1922d.c(f3);
        invalidateSelf();
    }

    public void setStrokeCap(Paint.Cap cap) {
        this.f1922d.a(cap);
        invalidateSelf();
    }

    public void setStrokeWidth(float f2) {
        this.f1922d.f(f2);
        invalidateSelf();
    }

    public void setStyle(int i) {
        if (i == 0) {
            a(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            a(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f1925g.cancel();
        this.f1922d.v();
        if (this.f1922d.h() != this.f1922d.m()) {
            this.i = true;
            this.f1925g.setDuration(666L);
            this.f1925g.start();
        } else {
            this.f1922d.d(0);
            this.f1922d.u();
            this.f1925g.setDuration(1332L);
            this.f1925g.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f1925g.cancel();
        a(0.0f);
        this.f1922d.a(false);
        this.f1922d.d(0);
        this.f1922d.u();
        invalidateSelf();
    }

    public void b(float f2, Ring ring) {
        if (f2 > 0.75f) {
            ring.c(a((f2 - 0.75f) / 0.25f, ring.n(), ring.i()));
        } else {
            ring.c(ring.n());
        }
    }

    private void a(float f2, float f3, float f4, float f5) {
        Ring ring = this.f1922d;
        float f6 = this.f1924f.getDisplayMetrics().density;
        ring.f(f3 * f6);
        ring.b(f2 * f6);
        ring.d(0);
        ring.a(f4 * f6, f5 * f6);
    }

    private void a(float f2) {
        this.f1923e = f2;
    }

    private void a(float f2, Ring ring) {
        b(f2, ring);
        float floor = (float) (Math.floor(ring.p() / 0.8f) + 1.0d);
        ring.e(ring.q() + (((ring.o() - 0.01f) - ring.q()) * f2));
        ring.c(ring.o());
        ring.d(ring.p() + ((floor - ring.p()) * f2));
    }

    public void a(float f2, Ring ring, boolean z) {
        float q;
        float interpolation;
        if (this.i) {
            a(f2, ring);
            return;
        }
        if (f2 != 1.0f || z) {
            float p = ring.p();
            if (f2 < 0.5f) {
                float q2 = ring.q();
                q = (f1920b.getInterpolation(f2 / 0.5f) * 0.79f) + 0.01f + q2;
                interpolation = q2;
            } else {
                q = ring.q() + 0.79f;
                interpolation = q - (((1.0f - f1920b.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            float f3 = p + (0.20999998f * f2);
            float f4 = (f2 + this.f1926h) * 216.0f;
            ring.e(interpolation);
            ring.c(q);
            ring.d(f3);
            a(f4);
        }
    }

    private void a() {
        Ring ring = this.f1922d;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.v4.widget.CircularProgressDrawable.1

            /* renamed from: a */
            final /* synthetic */ Ring f1927a;

            AnonymousClass1(Ring ring2) {
                ring = ring2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressDrawable.this.b(floatValue, ring);
                CircularProgressDrawable.this.a(floatValue, ring, false);
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f1919a);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: android.support.v4.widget.CircularProgressDrawable.2

            /* renamed from: a */
            final /* synthetic */ Ring f1929a;

            AnonymousClass2(Ring ring2) {
                ring = ring2;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                CircularProgressDrawable.this.a(1.0f, ring, true);
                ring.v();
                ring.t();
                if (CircularProgressDrawable.this.i) {
                    CircularProgressDrawable.this.i = false;
                    animator.cancel();
                    animator.setDuration(1332L);
                    animator.start();
                    ring.a(false);
                    return;
                }
                CircularProgressDrawable.this.f1926h += 1.0f;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                CircularProgressDrawable.this.f1926h = 0.0f;
            }
        });
        this.f1925g = ofFloat;
    }
}
