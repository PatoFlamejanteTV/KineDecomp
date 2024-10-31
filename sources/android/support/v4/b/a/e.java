package android.support.v4.b.a;

import android.graphics.drawable.Drawable;

/* compiled from: DrawableCompatKitKat.java */
/* loaded from: classes.dex */
class e {
    public static void a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static boolean a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable b(Drawable drawable) {
        if (!(drawable instanceof j)) {
            return new j(drawable);
        }
        return drawable;
    }
}
