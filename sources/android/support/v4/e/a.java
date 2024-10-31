package android.support.v4.e;

import android.os.Build;

/* compiled from: ICUCompat.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final InterfaceC0008a f72a;

    /* compiled from: ICUCompat.java */
    /* renamed from: android.support.v4.e.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    interface InterfaceC0008a {
        String a(String str);

        String b(String str);
    }

    /* compiled from: ICUCompat.java */
    /* loaded from: classes.dex */
    static class b implements InterfaceC0008a {
        b() {
        }

        @Override // android.support.v4.e.a.InterfaceC0008a
        public String a(String str) {
            return null;
        }

        @Override // android.support.v4.e.a.InterfaceC0008a
        public String b(String str) {
            return str;
        }
    }

    /* compiled from: ICUCompat.java */
    /* loaded from: classes.dex */
    static class c implements InterfaceC0008a {
        c() {
        }

        @Override // android.support.v4.e.a.InterfaceC0008a
        public String a(String str) {
            return android.support.v4.e.b.a(str);
        }

        @Override // android.support.v4.e.a.InterfaceC0008a
        public String b(String str) {
            return android.support.v4.e.b.b(str);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f72a = new c();
        } else {
            f72a = new b();
        }
    }

    public static String a(String str) {
        return f72a.a(str);
    }

    public static String b(String str) {
        return f72a.b(str);
    }
}
