package android.support.v4.g;

import android.os.Build;
import android.view.LayoutInflater;

/* compiled from: LayoutInflaterCompat.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    static final a f91a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LayoutInflaterCompat.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(LayoutInflater layoutInflater, h hVar);
    }

    /* compiled from: LayoutInflaterCompat.java */
    /* loaded from: classes.dex */
    static class b implements a {
        b() {
        }

        @Override // android.support.v4.g.d.a
        public void a(LayoutInflater layoutInflater, h hVar) {
            e.a(layoutInflater, hVar);
        }
    }

    /* compiled from: LayoutInflaterCompat.java */
    /* loaded from: classes.dex */
    static class c extends b {
        c() {
        }

        @Override // android.support.v4.g.d.b, android.support.v4.g.d.a
        public void a(LayoutInflater layoutInflater, h hVar) {
            f.a(layoutInflater, hVar);
        }
    }

    /* compiled from: LayoutInflaterCompat.java */
    /* renamed from: android.support.v4.g.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0011d extends c {
        C0011d() {
        }

        @Override // android.support.v4.g.d.c, android.support.v4.g.d.b, android.support.v4.g.d.a
        public void a(LayoutInflater layoutInflater, h hVar) {
            g.a(layoutInflater, hVar);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f91a = new C0011d();
        } else if (i >= 11) {
            f91a = new c();
        } else {
            f91a = new b();
        }
    }

    public static void a(LayoutInflater layoutInflater, h hVar) {
        f91a.a(layoutInflater, hVar);
    }
}
