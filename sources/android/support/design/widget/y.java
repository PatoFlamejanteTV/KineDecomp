package android.support.design.widget;

import android.graphics.Rect;
import android.support.v7.graphics.drawable.DrawableWrapper;

/* compiled from: ShadowDrawableWrapper.java */
/* loaded from: classes.dex */
class y extends DrawableWrapper {

    /* renamed from: b */
    static final double f523b = Math.cos(Math.toRadians(45.0d));

    public static float a(float f2, float f3, boolean z) {
        if (!z) {
            return f2;
        }
        double d2 = f2;
        double d3 = 1.0d - f523b;
        double d4 = f3;
        Double.isNaN(d4);
        Double.isNaN(d2);
        return (float) (d2 + (d3 * d4));
    }

    public static float b(float f2, float f3, boolean z) {
        if (!z) {
            return f2 * 1.5f;
        }
        double d2 = f2 * 1.5f;
        double d3 = 1.0d - f523b;
        double d4 = f3;
        Double.isNaN(d4);
        Double.isNaN(d2);
        return (float) (d2 + (d3 * d4));
    }

    public float a() {
        throw null;
    }

    public final void a(float f2) {
        throw null;
    }

    public void a(float f2, float f3) {
        throw null;
    }

    public void b(float f2) {
        throw null;
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        throw null;
    }
}
