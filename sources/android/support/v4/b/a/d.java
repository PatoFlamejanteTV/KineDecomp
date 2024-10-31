package android.support.v4.b.a;

import android.graphics.drawable.Drawable;

/* compiled from: DrawableCompatHoneycomb.java */
/* loaded from: classes.dex */
class d {
    public static void a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static Drawable b(Drawable drawable) {
        if (!(drawable instanceof i)) {
            return new i(drawable);
        }
        return drawable;
    }
}
