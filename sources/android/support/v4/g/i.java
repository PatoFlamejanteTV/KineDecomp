package android.support.v4.g;

import android.os.Build;
import android.view.ViewGroup;

/* compiled from: MarginLayoutParamsCompat.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    static final a f94a;

    /* compiled from: MarginLayoutParamsCompat.java */
    /* loaded from: classes.dex */
    interface a {
        int a(ViewGroup.MarginLayoutParams marginLayoutParams);

        int b(ViewGroup.MarginLayoutParams marginLayoutParams);
    }

    /* compiled from: MarginLayoutParamsCompat.java */
    /* loaded from: classes.dex */
    static class b implements a {
        b() {
        }

        @Override // android.support.v4.g.i.a
        public int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.leftMargin;
        }

        @Override // android.support.v4.g.i.a
        public int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.rightMargin;
        }
    }

    /* compiled from: MarginLayoutParamsCompat.java */
    /* loaded from: classes.dex */
    static class c implements a {
        c() {
        }

        @Override // android.support.v4.g.i.a
        public int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return j.a(marginLayoutParams);
        }

        @Override // android.support.v4.g.i.a
        public int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return j.b(marginLayoutParams);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f94a = new c();
        } else {
            f94a = new b();
        }
    }

    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return f94a.a(marginLayoutParams);
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return f94a.b(marginLayoutParams);
    }
}
