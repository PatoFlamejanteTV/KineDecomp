package android.support.v4.b.a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* compiled from: DrawableCompatLollipop.java */
/* loaded from: classes2.dex */
class f {
    public static void a(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    public static void a(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    public static void a(Drawable drawable, int i) {
        if (drawable instanceof k) {
            c.a(drawable, i);
        } else {
            drawable.setTint(i);
        }
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof k) {
            c.a(drawable, colorStateList);
        } else {
            drawable.setTintList(colorStateList);
        }
    }

    public static void a(Drawable drawable, PorterDuff.Mode mode) {
        if (drawable instanceof k) {
            c.a(drawable, mode);
        } else {
            drawable.setTintMode(mode);
        }
    }

    public static Drawable a(Drawable drawable) {
        if (drawable instanceof GradientDrawable) {
            return new k(drawable);
        }
        return drawable;
    }
}
