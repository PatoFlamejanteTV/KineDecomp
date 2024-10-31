package android.support.v4.widget;

import android.content.Context;
import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* compiled from: ScrollerCompat.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    Object f115a;
    a b;

    /* compiled from: ScrollerCompat.java */
    /* loaded from: classes.dex */
    interface a {
        int a(Object obj);

        Object a(Context context, Interpolator interpolator);

        void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);
    }

    /* compiled from: ScrollerCompat.java */
    /* loaded from: classes.dex */
    static class b implements a {
        b() {
        }

        @Override // android.support.v4.widget.h.a
        public Object a(Context context, Interpolator interpolator) {
            return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
        }

        @Override // android.support.v4.widget.h.a
        public void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        @Override // android.support.v4.widget.h.a
        public int a(Object obj) {
            return ((Scroller) obj).getFinalY();
        }
    }

    /* compiled from: ScrollerCompat.java */
    /* loaded from: classes.dex */
    static class c implements a {
        c() {
        }

        @Override // android.support.v4.widget.h.a
        public Object a(Context context, Interpolator interpolator) {
            return i.a(context, interpolator);
        }

        @Override // android.support.v4.widget.h.a
        public void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            i.a(obj, i, i2, i3, i4, i5, i6, i7, i8);
        }

        @Override // android.support.v4.widget.h.a
        public int a(Object obj) {
            return i.a(obj);
        }
    }

    /* compiled from: ScrollerCompat.java */
    /* loaded from: classes.dex */
    static class d extends c {
        d() {
        }
    }

    public static h a(Context context) {
        return a(context, null);
    }

    public static h a(Context context, Interpolator interpolator) {
        return new h(context, interpolator);
    }

    h(Context context, Interpolator interpolator) {
        this(Build.VERSION.SDK_INT, context, interpolator);
    }

    private h(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.b = new d();
        } else if (i >= 9) {
            this.b = new c();
        } else {
            this.b = new b();
        }
        this.f115a = this.b.a(context, interpolator);
    }

    public int a() {
        return this.b.a(this.f115a);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.b.a(this.f115a, i, i2, i3, i4, i5, i6, i7, i8);
    }
}
