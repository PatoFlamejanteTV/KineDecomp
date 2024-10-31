package android.support.design.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;

/* compiled from: FloatingActionButtonImpl.java */
/* renamed from: android.support.design.widget.u */
/* loaded from: classes.dex */
public class C0194u {

    /* renamed from: a */
    static final Interpolator f496a = C0175a.f464c;

    /* renamed from: b */
    static final int[] f497b = {R.attr.state_pressed, R.attr.state_enabled};

    /* renamed from: c */
    static final int[] f498c = {R.attr.state_focused, R.attr.state_enabled};

    /* renamed from: d */
    static final int[] f499d = {R.attr.state_enabled};

    /* renamed from: e */
    static final int[] f500e = new int[0];

    /* renamed from: h */
    y f503h;
    private float i;
    Drawable j;
    Drawable k;
    C0186l l;
    Drawable m;
    float n;
    float o;
    final U p;
    final z q;
    private ViewTreeObserver.OnPreDrawListener s;

    /* renamed from: f */
    int f501f = 0;
    private final Rect r = new Rect();

    /* renamed from: g */
    private final B f502g = new B();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: android.support.design.widget.u$a */
    /* loaded from: classes.dex */
    public class a extends e {
        a() {
            super(C0194u.this, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: android.support.design.widget.u$b */
    /* loaded from: classes.dex */
    public class b extends e {
        b() {
            super(C0194u.this, null);
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: android.support.design.widget.u$c */
    /* loaded from: classes.dex */
    public interface c {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: android.support.design.widget.u$d */
    /* loaded from: classes.dex */
    public class d extends e {
        d() {
            super(C0194u.this, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: android.support.design.widget.u$e */
    /* loaded from: classes.dex */
    public abstract class e extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        private boolean f507a;

        /* renamed from: b */
        private float f508b;

        /* renamed from: c */
        private float f509c;

        private e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C0194u.this.f503h.b(this.f509c);
            throw null;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f507a) {
                C0194u.this.f503h.a();
                throw null;
            }
            y yVar = C0194u.this.f503h;
            float f2 = this.f508b;
            yVar.b(f2 + ((this.f509c - f2) * valueAnimator.getAnimatedFraction()));
            throw null;
        }

        /* synthetic */ e(C0194u c0194u, r rVar) {
            this();
        }
    }

    public C0194u(U u, z zVar) {
        this.p = u;
        this.q = zVar;
        this.f502g.a(f497b, a(new b()));
        this.f502g.a(f498c, a(new b()));
        this.f502g.a(f499d, a(new d()));
        this.f502g.a(f500e, a(new a()));
        this.i = this.p.getRotation();
    }

    private void l() {
        if (this.s == null) {
            this.s = new ViewTreeObserverOnPreDrawListenerC0193t(this);
        }
    }

    private boolean m() {
        return ViewCompat.isLaidOut(this.p) && !this.p.isInEditMode();
    }

    private void n() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.i % 90.0f != 0.0f) {
                if (this.p.getLayerType() != 1) {
                    this.p.setLayerType(1, null);
                }
            } else if (this.p.getLayerType() != 0) {
                this.p.setLayerType(0, null);
            }
        }
        y yVar = this.f503h;
        if (yVar == null) {
            C0186l c0186l = this.l;
            if (c0186l == null) {
                return;
            }
            c0186l.a(-this.i);
            throw null;
        }
        yVar.a(-this.i);
        throw null;
    }

    public void a(ColorStateList colorStateList) {
        Drawable drawable = this.j;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
        C0186l c0186l = this.l;
        if (c0186l == null) {
            return;
        }
        c0186l.a(colorStateList);
        throw null;
    }

    public float b() {
        return this.n;
    }

    void b(Rect rect) {
    }

    boolean c() {
        return this.p.getVisibility() == 0 ? this.f501f == 1 : this.f501f != 2;
    }

    boolean d() {
        return this.p.getVisibility() != 0 ? this.f501f == 2 : this.f501f != 1;
    }

    public void e() {
        this.f502g.a();
    }

    public void f() {
        if (j()) {
            l();
            this.p.getViewTreeObserver().addOnPreDrawListener(this.s);
        }
    }

    public void g() {
    }

    public void h() {
        if (this.s != null) {
            this.p.getViewTreeObserver().removeOnPreDrawListener(this.s);
            this.s = null;
        }
    }

    public void i() {
        float rotation = this.p.getRotation();
        if (this.i != rotation) {
            this.i = rotation;
            n();
        }
    }

    boolean j() {
        return true;
    }

    public final void k() {
        Rect rect = this.r;
        a(rect);
        b(rect);
        this.q.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void b(c cVar, boolean z) {
        if (d()) {
            return;
        }
        this.p.animate().cancel();
        if (m()) {
            this.f501f = 2;
            if (this.p.getVisibility() != 0) {
                this.p.setAlpha(0.0f);
                this.p.setScaleY(0.0f);
                this.p.setScaleX(0.0f);
            }
            this.p.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200L).setInterpolator(C0175a.f465d).setListener(new C0192s(this, z, cVar));
            return;
        }
        this.p.a(0, z);
        this.p.setAlpha(1.0f);
        this.p.setScaleY(1.0f);
        this.p.setScaleX(1.0f);
        if (cVar != null) {
            cVar.a();
        }
    }

    public void a(PorterDuff.Mode mode) {
        Drawable drawable = this.j;
        if (drawable != null) {
            DrawableCompat.setTintMode(drawable, mode);
        }
    }

    public void a(int i) {
        Drawable drawable = this.k;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, b(i));
        }
    }

    public final void a(float f2) {
        if (this.n != f2) {
            this.n = f2;
            a(f2, this.o);
        }
    }

    void a(float f2, float f3) {
        y yVar = this.f503h;
        if (yVar == null) {
            return;
        }
        yVar.a(f2, this.o + f2);
        throw null;
    }

    public void a(int[] iArr) {
        this.f502g.a(iArr);
    }

    public void a(c cVar, boolean z) {
        if (c()) {
            return;
        }
        this.p.animate().cancel();
        if (m()) {
            this.f501f = 1;
            this.p.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200L).setInterpolator(C0175a.f464c).setListener(new r(this, z, cVar));
        } else {
            this.p.a(z ? 8 : 4, z);
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    private static ColorStateList b(int i) {
        return new ColorStateList(new int[][]{f498c, f497b, new int[0]}, new int[]{i, i, 0});
    }

    public final Drawable a() {
        return this.m;
    }

    void a(Rect rect) {
        this.f503h.getPadding(rect);
        throw null;
    }

    private ValueAnimator a(e eVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f496a);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(eVar);
        valueAnimator.addUpdateListener(eVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }
}
