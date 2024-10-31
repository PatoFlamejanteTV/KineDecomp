package android.support.v4.g;

import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import java.util.WeakHashMap;

/* compiled from: ViewCompat.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    static final j f98a;

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    interface j {
        int a(int i, int i2, int i3);

        int a(View view);

        void a(View view, float f);

        void a(View view, int i, Paint paint);

        void a(View view, Runnable runnable);

        void a(View view, Runnable runnable, long j);

        void a(View view, boolean z);

        int b(View view);

        void b(View view, float f);

        void b(View view, boolean z);

        int c(View view);

        void c(View view, float f);

        float d(View view);

        int e(View view);

        y f(View view);

        int g(View view);

        void h(View view);

        void i(View view);

        boolean j(View view);
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class a implements j {

        /* renamed from: a, reason: collision with root package name */
        WeakHashMap<View, y> f99a = null;

        a() {
        }

        @Override // android.support.v4.g.p.j
        public void a(View view, Runnable runnable) {
            view.postDelayed(runnable, a());
        }

        @Override // android.support.v4.g.p.j
        public void a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, a() + j);
        }

        long a() {
            return 10L;
        }

        @Override // android.support.v4.g.p.j
        public void a(View view, int i, Paint paint) {
        }

        @Override // android.support.v4.g.p.j
        public int a(View view) {
            return 0;
        }

        @Override // android.support.v4.g.p.j
        public int a(int i, int i2, int i3) {
            return View.resolveSize(i, i2);
        }

        @Override // android.support.v4.g.p.j
        public int b(View view) {
            return view.getMeasuredWidth();
        }

        @Override // android.support.v4.g.p.j
        public int c(View view) {
            return 0;
        }

        @Override // android.support.v4.g.p.j
        public float d(View view) {
            return 0.0f;
        }

        @Override // android.support.v4.g.p.j
        public int e(View view) {
            return q.b(view);
        }

        @Override // android.support.v4.g.p.j
        public y f(View view) {
            return new y(view);
        }

        @Override // android.support.v4.g.p.j
        public void a(View view, float f) {
        }

        @Override // android.support.v4.g.p.j
        public void b(View view, float f) {
        }

        @Override // android.support.v4.g.p.j
        public void c(View view, float f) {
        }

        @Override // android.support.v4.g.p.j
        public int g(View view) {
            return 0;
        }

        @Override // android.support.v4.g.p.j
        public void h(View view) {
        }

        @Override // android.support.v4.g.p.j
        public void i(View view) {
        }

        @Override // android.support.v4.g.p.j
        public void a(View view, boolean z) {
        }

        @Override // android.support.v4.g.p.j
        public void b(View view, boolean z) {
        }

        @Override // android.support.v4.g.p.j
        public boolean j(View view) {
            return q.a(view);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class b extends a {
        b() {
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class c extends b {
        c() {
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class d extends c {
        d() {
        }

        @Override // android.support.v4.g.p.a
        long a() {
            return r.a();
        }

        @Override // android.support.v4.g.p.a, android.support.v4.g.p.j
        public void a(View view, int i, Paint paint) {
            r.a(view, i, paint);
        }

        @Override // android.support.v4.g.p.a, android.support.v4.g.p.j
        public int a(int i, int i2, int i3) {
            return r.a(i, i2, i3);
        }

        @Override // android.support.v4.g.p.a, android.support.v4.g.p.j
        public int b(View view) {
            return r.a(view);
        }

        @Override // android.support.v4.g.p.a, android.support.v4.g.p.j
        public int c(View view) {
            return r.b(view);
        }

        @Override // android.support.v4.g.p.a, android.support.v4.g.p.j
        public float d(View view) {
            return r.c(view);
        }

        @Override // android.support.v4.g.p.a, android.support.v4.g.p.j
        public void a(View view, float f) {
            r.a(view, f);
        }

        @Override // android.support.v4.g.p.a, android.support.v4.g.p.j
        public void b(View view, float f) {
            r.b(view, f);
        }

        @Override // android.support.v4.g.p.a, android.support.v4.g.p.j
        public void c(View view, float f) {
            r.c(view, f);
        }

        @Override // android.support.v4.g.p.a, android.support.v4.g.p.j
        public void i(View view) {
            r.d(view);
        }

        @Override // android.support.v4.g.p.a, android.support.v4.g.p.j
        public void a(View view, boolean z) {
            r.a(view, z);
        }

        @Override // android.support.v4.g.p.a, android.support.v4.g.p.j
        public void b(View view, boolean z) {
            r.b(view, z);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class e extends d {
        static boolean b = false;

        e() {
        }

        @Override // android.support.v4.g.p.a, android.support.v4.g.p.j
        public y f(View view) {
            if (this.f99a == null) {
                this.f99a = new WeakHashMap<>();
            }
            y yVar = this.f99a.get(view);
            if (yVar == null) {
                y yVar2 = new y(view);
                this.f99a.put(view, yVar2);
                return yVar2;
            }
            return yVar;
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class f extends e {
        f() {
        }

        @Override // android.support.v4.g.p.a, android.support.v4.g.p.j
        public void a(View view, Runnable runnable) {
            s.a(view, runnable);
        }

        @Override // android.support.v4.g.p.a, android.support.v4.g.p.j
        public void a(View view, Runnable runnable, long j) {
            s.a(view, runnable, j);
        }

        @Override // android.support.v4.g.p.a, android.support.v4.g.p.j
        public int e(View view) {
            return s.a(view);
        }

        @Override // android.support.v4.g.p.a, android.support.v4.g.p.j
        public void h(View view) {
            s.b(view);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class g extends f {
        g() {
        }

        @Override // android.support.v4.g.p.a, android.support.v4.g.p.j
        public int a(View view) {
            return t.a(view);
        }

        @Override // android.support.v4.g.p.a, android.support.v4.g.p.j
        public int g(View view) {
            return t.b(view);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class h extends g {
        h() {
        }

        @Override // android.support.v4.g.p.a, android.support.v4.g.p.j
        public boolean j(View view) {
            return u.a(view);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class i extends h {
        i() {
        }

        @Override // android.support.v4.g.p.f, android.support.v4.g.p.a, android.support.v4.g.p.j
        public void h(View view) {
            v.a(view);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            f98a = new i();
            return;
        }
        if (i2 >= 19) {
            f98a = new h();
            return;
        }
        if (i2 >= 17) {
            f98a = new g();
            return;
        }
        if (i2 >= 16) {
            f98a = new f();
            return;
        }
        if (i2 >= 14) {
            f98a = new e();
            return;
        }
        if (i2 >= 11) {
            f98a = new d();
            return;
        }
        if (i2 >= 9) {
            f98a = new c();
        } else if (i2 >= 7) {
            f98a = new b();
        } else {
            f98a = new a();
        }
    }

    public static void a(View view, Runnable runnable) {
        f98a.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long j2) {
        f98a.a(view, runnable, j2);
    }

    public static void a(View view, int i2, Paint paint) {
        f98a.a(view, i2, paint);
    }

    public static int a(View view) {
        return f98a.a(view);
    }

    public static int a(int i2, int i3, int i4) {
        return f98a.a(i2, i3, i4);
    }

    public static int b(View view) {
        return f98a.b(view);
    }

    public static int c(View view) {
        return f98a.c(view);
    }

    public static float d(View view) {
        return f98a.d(view);
    }

    public static int e(View view) {
        return f98a.e(view);
    }

    public static y f(View view) {
        return f98a.f(view);
    }

    public static void a(View view, float f2) {
        f98a.a(view, f2);
    }

    public static void b(View view, float f2) {
        f98a.b(view, f2);
    }

    public static void c(View view, float f2) {
        f98a.c(view, f2);
    }

    public static int g(View view) {
        return f98a.g(view);
    }

    public static void h(View view) {
        f98a.h(view);
    }

    public static void i(View view) {
        f98a.i(view);
    }

    public static void a(View view, boolean z) {
        f98a.a(view, z);
    }

    public static void b(View view, boolean z) {
        f98a.b(view, z);
    }

    public static boolean j(View view) {
        return f98a.j(view);
    }
}
