package android.support.v4.g;

import android.os.Build;
import android.view.ViewConfiguration;

/* compiled from: ViewConfigurationCompat.java */
/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    static final e f101a;

    /* compiled from: ViewConfigurationCompat.java */
    /* loaded from: classes.dex */
    interface e {
        boolean a(ViewConfiguration viewConfiguration);
    }

    /* compiled from: ViewConfigurationCompat.java */
    /* loaded from: classes.dex */
    static class a implements e {
        a() {
        }

        @Override // android.support.v4.g.w.e
        public boolean a(ViewConfiguration viewConfiguration) {
            return true;
        }
    }

    /* compiled from: ViewConfigurationCompat.java */
    /* loaded from: classes.dex */
    static class b extends a {
        b() {
        }
    }

    /* compiled from: ViewConfigurationCompat.java */
    /* loaded from: classes.dex */
    static class c extends b {
        c() {
        }

        @Override // android.support.v4.g.w.a, android.support.v4.g.w.e
        public boolean a(ViewConfiguration viewConfiguration) {
            return false;
        }
    }

    /* compiled from: ViewConfigurationCompat.java */
    /* loaded from: classes.dex */
    static class d extends c {
        d() {
        }

        @Override // android.support.v4.g.w.c, android.support.v4.g.w.a, android.support.v4.g.w.e
        public boolean a(ViewConfiguration viewConfiguration) {
            return x.a(viewConfiguration);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f101a = new d();
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            f101a = new c();
        } else if (Build.VERSION.SDK_INT >= 8) {
            f101a = new b();
        } else {
            f101a = new a();
        }
    }

    public static boolean a(ViewConfiguration viewConfiguration) {
        return f101a.a(viewConfiguration);
    }
}
