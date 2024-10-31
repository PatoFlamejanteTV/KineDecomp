package android.support.v4.b.a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* compiled from: DrawableCompatBase.java */
/* loaded from: classes.dex */
class c {
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Drawable drawable, int i) {
        if (drawable instanceof g) {
            ((g) drawable).setTint(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof g) {
            ((g) drawable).setTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Drawable drawable, PorterDuff.Mode mode) {
        if (drawable instanceof g) {
            ((g) drawable).setTintMode(mode);
        }
    }

    public static Drawable a(Drawable drawable) {
        if (!(drawable instanceof h)) {
            return new h(drawable);
        }
        return drawable;
    }
}
