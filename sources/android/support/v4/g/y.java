package android.support.v4.g;

import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: ViewPropertyAnimatorCompat.java */
/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    static final g f102a;
    private WeakReference<View> b;
    private Runnable c = null;
    private Runnable d = null;
    private int e = -1;

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    interface g {
        void a(y yVar, View view);

        void a(y yVar, View view, float f);

        void a(y yVar, View view, long j);

        void a(y yVar, View view, ad adVar);

        void a(y yVar, View view, Interpolator interpolator);

        void b(y yVar, View view);

        void b(y yVar, View view, float f);

        void c(y yVar, View view, float f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(View view) {
        this.b = new WeakReference<>(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    public static class a implements g {

        /* renamed from: a, reason: collision with root package name */
        WeakHashMap<View, Runnable> f103a = null;

        a() {
        }

        @Override // android.support.v4.g.y.g
        public void a(y yVar, View view, long j) {
        }

        @Override // android.support.v4.g.y.g
        public void a(y yVar, View view, float f) {
            d(yVar, view);
        }

        @Override // android.support.v4.g.y.g
        public void b(y yVar, View view, float f) {
            d(yVar, view);
        }

        @Override // android.support.v4.g.y.g
        public void a(y yVar, View view, Interpolator interpolator) {
        }

        @Override // android.support.v4.g.y.g
        public void c(y yVar, View view, float f) {
            d(yVar, view);
        }

        @Override // android.support.v4.g.y.g
        public void a(y yVar, View view) {
            d(yVar, view);
        }

        @Override // android.support.v4.g.y.g
        public void b(y yVar, View view) {
            a(view);
            c(yVar, view);
        }

        @Override // android.support.v4.g.y.g
        public void a(y yVar, View view, ad adVar) {
            view.setTag(2113929216, adVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(y yVar, View view) {
            ad adVar;
            Object tag = view.getTag(2113929216);
            if (!(tag instanceof ad)) {
                adVar = null;
            } else {
                adVar = (ad) tag;
            }
            Runnable runnable = yVar.c;
            Runnable runnable2 = yVar.d;
            if (runnable != null) {
                runnable.run();
            }
            if (adVar != null) {
                adVar.a(view);
                adVar.b(view);
            }
            if (runnable2 != null) {
                runnable2.run();
            }
            if (this.f103a != null) {
                this.f103a.remove(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ViewPropertyAnimatorCompat.java */
        /* renamed from: android.support.v4.g.y$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0012a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            WeakReference<View> f104a;
            y b;

            private RunnableC0012a(y yVar, View view) {
                this.f104a = new WeakReference<>(view);
                this.b = yVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                View view = this.f104a.get();
                if (view != null) {
                    a.this.c(this.b, view);
                }
            }
        }

        private void a(View view) {
            Runnable runnable;
            if (this.f103a != null && (runnable = this.f103a.get(view)) != null) {
                view.removeCallbacks(runnable);
            }
        }

        private void d(y yVar, View view) {
            Runnable runnable = this.f103a != null ? this.f103a.get(view) : null;
            if (runnable == null) {
                runnable = new RunnableC0012a(yVar, view);
                if (this.f103a == null) {
                    this.f103a = new WeakHashMap<>();
                }
                this.f103a.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    static class b extends a {
        WeakHashMap<View, Integer> b = null;

        b() {
        }

        @Override // android.support.v4.g.y.a, android.support.v4.g.y.g
        public void a(y yVar, View view, long j) {
            z.a(view, j);
        }

        @Override // android.support.v4.g.y.a, android.support.v4.g.y.g
        public void a(y yVar, View view, float f) {
            z.a(view, f);
        }

        @Override // android.support.v4.g.y.a, android.support.v4.g.y.g
        public void b(y yVar, View view, float f) {
            z.b(view, f);
        }

        @Override // android.support.v4.g.y.a, android.support.v4.g.y.g
        public void a(y yVar, View view, Interpolator interpolator) {
            z.a(view, interpolator);
        }

        @Override // android.support.v4.g.y.a, android.support.v4.g.y.g
        public void c(y yVar, View view, float f) {
            z.c(view, f);
        }

        @Override // android.support.v4.g.y.a, android.support.v4.g.y.g
        public void a(y yVar, View view) {
            z.a(view);
        }

        @Override // android.support.v4.g.y.a, android.support.v4.g.y.g
        public void b(y yVar, View view) {
            z.b(view);
        }

        @Override // android.support.v4.g.y.a, android.support.v4.g.y.g
        public void a(y yVar, View view, ad adVar) {
            view.setTag(2113929216, adVar);
            z.a(view, new a(yVar));
        }

        /* compiled from: ViewPropertyAnimatorCompat.java */
        /* loaded from: classes.dex */
        static class a implements ad {

            /* renamed from: a, reason: collision with root package name */
            y f105a;

            a(y yVar) {
                this.f105a = yVar;
            }

            @Override // android.support.v4.g.ad
            public void a(View view) {
                if (this.f105a.e >= 0) {
                    p.a(view, 2, (Paint) null);
                }
                if (this.f105a.c != null) {
                    this.f105a.c.run();
                }
                Object tag = view.getTag(2113929216);
                ad adVar = tag instanceof ad ? (ad) tag : null;
                if (adVar != null) {
                    adVar.a(view);
                }
            }

            @Override // android.support.v4.g.ad
            public void b(View view) {
                if (this.f105a.e >= 0) {
                    p.a(view, this.f105a.e, (Paint) null);
                    this.f105a.e = -1;
                }
                if (this.f105a.d != null) {
                    this.f105a.d.run();
                }
                Object tag = view.getTag(2113929216);
                ad adVar = tag instanceof ad ? (ad) tag : null;
                if (adVar != null) {
                    adVar.b(view);
                }
            }

            @Override // android.support.v4.g.ad
            public void c(View view) {
                ad adVar;
                Object tag = view.getTag(2113929216);
                if (!(tag instanceof ad)) {
                    adVar = null;
                } else {
                    adVar = (ad) tag;
                }
                if (adVar != null) {
                    adVar.c(view);
                }
            }
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    static class d extends b {
        d() {
        }

        @Override // android.support.v4.g.y.b, android.support.v4.g.y.a, android.support.v4.g.y.g
        public void a(y yVar, View view, ad adVar) {
            ab.a(view, adVar);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    static class c extends d {
        c() {
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    static class e extends c {
        e() {
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    static class f extends e {
        f() {
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f102a = new f();
            return;
        }
        if (i >= 19) {
            f102a = new e();
            return;
        }
        if (i >= 18) {
            f102a = new c();
            return;
        }
        if (i >= 16) {
            f102a = new d();
        } else if (i >= 14) {
            f102a = new b();
        } else {
            f102a = new a();
        }
    }

    public y a(long j) {
        View view = this.b.get();
        if (view != null) {
            f102a.a(this, view, j);
        }
        return this;
    }

    public y a(float f2) {
        View view = this.b.get();
        if (view != null) {
            f102a.a(this, view, f2);
        }
        return this;
    }

    public y b(float f2) {
        View view = this.b.get();
        if (view != null) {
            f102a.b(this, view, f2);
        }
        return this;
    }

    public y a(Interpolator interpolator) {
        View view = this.b.get();
        if (view != null) {
            f102a.a(this, view, interpolator);
        }
        return this;
    }

    public y c(float f2) {
        View view = this.b.get();
        if (view != null) {
            f102a.c(this, view, f2);
        }
        return this;
    }

    public void a() {
        View view = this.b.get();
        if (view != null) {
            f102a.a(this, view);
        }
    }

    public void b() {
        View view = this.b.get();
        if (view != null) {
            f102a.b(this, view);
        }
    }

    public y a(ad adVar) {
        View view = this.b.get();
        if (view != null) {
            f102a.a(this, view, adVar);
        }
        return this;
    }
}
