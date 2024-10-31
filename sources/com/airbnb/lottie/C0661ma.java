package com.airbnb.lottie;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.Layer;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LottieDrawable.java */
/* renamed from: com.airbnb.lottie.ma */
/* loaded from: classes.dex */
public class C0661ma extends Drawable implements Drawable.Callback {

    /* renamed from: b */
    private C0657ka f7791b;

    /* renamed from: h */
    private C0639ba f7797h;
    private String i;
    private InterfaceC0641ca j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private H o;

    /* renamed from: a */
    private final Matrix f7790a = new Matrix();

    /* renamed from: c */
    private final ValueAnimator f7792c = ValueAnimator.ofFloat(0.0f, 1.0f);

    /* renamed from: d */
    private float f7793d = 1.0f;

    /* renamed from: e */
    private float f7794e = 1.0f;

    /* renamed from: f */
    private float f7795f = 0.0f;

    /* renamed from: g */
    private final Set<a> f7796g = new HashSet();
    private int p = 255;

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.ma$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        final String f7798a;

        /* renamed from: b */
        final String f7799b;

        /* renamed from: c */
        final ColorFilter f7800c;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return hashCode() == aVar.hashCode() && this.f7800c == aVar.f7800c;
        }

        public int hashCode() {
            String str = this.f7798a;
            int hashCode = str != null ? 527 * str.hashCode() : 17;
            String str2 = this.f7799b;
            return str2 != null ? hashCode * 31 * str2.hashCode() : hashCode;
        }
    }

    public C0661ma() {
        this.f7792c.setRepeatCount(0);
        this.f7792c.setInterpolator(new LinearInterpolator());
        this.f7792c.addUpdateListener(new C0659la(this));
    }

    private void g() {
        if (this.o == null) {
            return;
        }
        for (a aVar : this.f7796g) {
            this.o.a(aVar.f7798a, aVar.f7799b, aVar.f7800c);
        }
    }

    private void h() {
        this.o = new H(this, Layer.a.a(this.f7791b), this.f7791b.h(), this.f7791b);
    }

    private void i() {
        e();
        this.o = null;
        this.f7797h = null;
        invalidateSelf();
    }

    private Context j() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private C0639ba k() {
        C0639ba c0639ba = this.f7797h;
        if (c0639ba != null && !c0639ba.a(j())) {
            this.f7797h.a();
            this.f7797h = null;
        }
        if (this.f7797h == null) {
            this.f7797h = new C0639ba(getCallback(), this.i, this.j, this.f7791b.g());
        }
        return this.f7797h;
    }

    private void l() {
    }

    public void c(float f2) {
        this.f7793d = f2;
        if (f2 < 0.0f) {
            this.f7792c.setFloatValues(1.0f, 0.0f);
        } else {
            this.f7792c.setFloatValues(0.0f, 1.0f);
        }
        if (this.f7791b != null) {
            this.f7792c.setDuration(((float) r0.c()) / Math.abs(f2));
        }
    }

    public void d() {
        float f2 = this.f7795f;
        a(((double) f2) > 0.0d && ((double) f2) < 1.0d);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.o == null) {
            return;
        }
        this.f7790a.reset();
        float width = this.f7791b.a().width();
        float height = this.f7791b.a().height();
        float width2 = getBounds().width();
        float height2 = getBounds().height();
        this.f7790a.preTranslate(getBounds().left, getBounds().top);
        this.f7790a.preScale(width2 / width, height2 / height);
        this.o.a(canvas, this.f7790a, this.p);
    }

    public void e() {
        C0639ba c0639ba = this.f7797h;
        if (c0639ba != null) {
            c0639ba.a();
        }
    }

    public void f() {
        float f2 = this.f7795f;
        b(((double) f2) > 0.0d && ((double) f2) < 1.0d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.p;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f7791b == null) {
            return -1;
        }
        return (int) (r0.a().height() * this.f7794e);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f7791b == null) {
            return -1;
        }
        return (int) (r0.a().width() * this.f7794e);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.p = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    private void b(boolean z) {
        if (this.o == null) {
            this.k = false;
            this.l = true;
        } else {
            if (z) {
                this.f7792c.setCurrentPlayTime(this.f7795f * ((float) r4.getDuration()));
            }
            this.f7792c.reverse();
        }
    }

    public boolean a() {
        return this.n;
    }

    public boolean a(C0657ka c0657ka) {
        if (this.f7791b == c0657ka) {
            return false;
        }
        i();
        this.f7791b = c0657ka;
        c(this.f7793d);
        b(1.0f);
        l();
        h();
        g();
        a(this.f7795f);
        if (this.k) {
            this.k = false;
            d();
        }
        if (!this.l) {
            return true;
        }
        this.l = false;
        f();
        return true;
    }

    public float c() {
        return this.f7794e;
    }

    public void b(float f2) {
        this.f7794e = f2;
        l();
    }

    public C0657ka b() {
        return this.f7791b;
    }

    private void a(boolean z) {
        if (this.o == null) {
            this.k = true;
            this.l = false;
        } else {
            if (z) {
                this.f7792c.setCurrentPlayTime(this.f7795f * ((float) r4.getDuration()));
            }
            this.f7792c.start();
        }
    }

    public void a(float f2) {
        this.f7795f = f2;
        H h2 = this.o;
        if (h2 != null) {
            h2.a(f2);
        }
    }

    public Bitmap a(String str) {
        return k().a(str);
    }
}
