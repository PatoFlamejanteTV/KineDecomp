package android.support.v4.g;

import android.os.Build;

/* compiled from: GravityCompat.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static final a f90a;

    /* compiled from: GravityCompat.java */
    /* loaded from: classes.dex */
    interface a {
        int a(int i, int i2);
    }

    /* compiled from: GravityCompat.java */
    /* renamed from: android.support.v4.g.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0010b implements a {
        C0010b() {
        }

        @Override // android.support.v4.g.b.a
        public int a(int i, int i2) {
            return (-8388609) & i;
        }
    }

    /* compiled from: GravityCompat.java */
    /* loaded from: classes.dex */
    static class c implements a {
        c() {
        }

        @Override // android.support.v4.g.b.a
        public int a(int i, int i2) {
            return android.support.v4.g.c.a(i, i2);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f90a = new c();
        } else {
            f90a = new C0010b();
        }
    }

    public static int a(int i, int i2) {
        return f90a.a(i, i2);
    }
}
