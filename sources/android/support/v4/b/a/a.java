package android.support.v4.b.a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* compiled from: DrawableCompat.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static final b f70a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawableCompat.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(Drawable drawable);

        void a(Drawable drawable, float f, float f2);

        void a(Drawable drawable, int i);

        void a(Drawable drawable, int i, int i2, int i3, int i4);

        void a(Drawable drawable, ColorStateList colorStateList);

        void a(Drawable drawable, PorterDuff.Mode mode);

        void a(Drawable drawable, boolean z);

        boolean b(Drawable drawable);

        Drawable c(Drawable drawable);
    }

    /* compiled from: DrawableCompat.java */
    /* renamed from: android.support.v4.b.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0007a implements b {
        C0007a() {
        }

        @Override // android.support.v4.b.a.a.b
        public void a(Drawable drawable) {
        }

        @Override // android.support.v4.b.a.a.b
        public void a(Drawable drawable, boolean z) {
        }

        @Override // android.support.v4.b.a.a.b
        public boolean b(Drawable drawable) {
            return false;
        }

        @Override // android.support.v4.b.a.a.b
        public void a(Drawable drawable, float f, float f2) {
        }

        @Override // android.support.v4.b.a.a.b
        public void a(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        @Override // android.support.v4.b.a.a.b
        public void a(Drawable drawable, int i) {
            android.support.v4.b.a.c.a(drawable, i);
        }

        @Override // android.support.v4.b.a.a.b
        public void a(Drawable drawable, ColorStateList colorStateList) {
            android.support.v4.b.a.c.a(drawable, colorStateList);
        }

        @Override // android.support.v4.b.a.a.b
        public void a(Drawable drawable, PorterDuff.Mode mode) {
            android.support.v4.b.a.c.a(drawable, mode);
        }

        @Override // android.support.v4.b.a.a.b
        public Drawable c(Drawable drawable) {
            return android.support.v4.b.a.c.a(drawable);
        }
    }

    /* compiled from: DrawableCompat.java */
    /* loaded from: classes.dex */
    static class c extends C0007a {
        c() {
        }

        @Override // android.support.v4.b.a.a.C0007a, android.support.v4.b.a.a.b
        public void a(Drawable drawable) {
            android.support.v4.b.a.d.a(drawable);
        }

        @Override // android.support.v4.b.a.a.C0007a, android.support.v4.b.a.a.b
        public Drawable c(Drawable drawable) {
            return android.support.v4.b.a.d.b(drawable);
        }
    }

    /* compiled from: DrawableCompat.java */
    /* loaded from: classes.dex */
    static class d extends c {
        d() {
        }

        @Override // android.support.v4.b.a.a.C0007a, android.support.v4.b.a.a.b
        public void a(Drawable drawable, boolean z) {
            android.support.v4.b.a.e.a(drawable, z);
        }

        @Override // android.support.v4.b.a.a.C0007a, android.support.v4.b.a.a.b
        public boolean b(Drawable drawable) {
            return android.support.v4.b.a.e.a(drawable);
        }

        @Override // android.support.v4.b.a.a.c, android.support.v4.b.a.a.C0007a, android.support.v4.b.a.a.b
        public Drawable c(Drawable drawable) {
            return android.support.v4.b.a.e.b(drawable);
        }
    }

    /* compiled from: DrawableCompat.java */
    /* loaded from: classes.dex */
    static class e extends d {
        e() {
        }

        @Override // android.support.v4.b.a.a.C0007a, android.support.v4.b.a.a.b
        public void a(Drawable drawable, float f, float f2) {
            android.support.v4.b.a.f.a(drawable, f, f2);
        }

        @Override // android.support.v4.b.a.a.C0007a, android.support.v4.b.a.a.b
        public void a(Drawable drawable, int i, int i2, int i3, int i4) {
            android.support.v4.b.a.f.a(drawable, i, i2, i3, i4);
        }

        @Override // android.support.v4.b.a.a.C0007a, android.support.v4.b.a.a.b
        public void a(Drawable drawable, int i) {
            android.support.v4.b.a.f.a(drawable, i);
        }

        @Override // android.support.v4.b.a.a.C0007a, android.support.v4.b.a.a.b
        public void a(Drawable drawable, ColorStateList colorStateList) {
            android.support.v4.b.a.f.a(drawable, colorStateList);
        }

        @Override // android.support.v4.b.a.a.C0007a, android.support.v4.b.a.a.b
        public void a(Drawable drawable, PorterDuff.Mode mode) {
            android.support.v4.b.a.f.a(drawable, mode);
        }

        @Override // android.support.v4.b.a.a.d, android.support.v4.b.a.a.c, android.support.v4.b.a.a.C0007a, android.support.v4.b.a.a.b
        public Drawable c(Drawable drawable) {
            return android.support.v4.b.a.f.a(drawable);
        }
    }

    /* compiled from: DrawableCompat.java */
    /* loaded from: classes.dex */
    static class f extends e {
        f() {
        }

        @Override // android.support.v4.b.a.a.e, android.support.v4.b.a.a.d, android.support.v4.b.a.a.c, android.support.v4.b.a.a.C0007a, android.support.v4.b.a.a.b
        public Drawable c(Drawable drawable) {
            return android.support.v4.b.a.b.a(drawable);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 22) {
            f70a = new f();
            return;
        }
        if (i >= 21) {
            f70a = new e();
            return;
        }
        if (i >= 19) {
            f70a = new d();
        } else if (i >= 11) {
            f70a = new c();
        } else {
            f70a = new C0007a();
        }
    }

    public static void a(Drawable drawable) {
        f70a.a(drawable);
    }

    public static void a(Drawable drawable, boolean z) {
        f70a.a(drawable, z);
    }

    public static boolean b(Drawable drawable) {
        return f70a.b(drawable);
    }

    public static void a(Drawable drawable, float f2, float f3) {
        f70a.a(drawable, f2, f3);
    }

    public static void a(Drawable drawable, int i, int i2, int i3, int i4) {
        f70a.a(drawable, i, i2, i3, i4);
    }

    public static void a(Drawable drawable, int i) {
        f70a.a(drawable, i);
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        f70a.a(drawable, colorStateList);
    }

    public static void a(Drawable drawable, PorterDuff.Mode mode) {
        f70a.a(drawable, mode);
    }

    public static Drawable c(Drawable drawable) {
        return f70a.c(drawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T d(Drawable drawable) {
        if (drawable instanceof g) {
            return (T) ((g) drawable).a();
        }
        return drawable;
    }
}
