package android.support.design.widget;

import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: AnimationUtils.java */
/* renamed from: android.support.design.widget.a */
/* loaded from: classes.dex */
class C0175a {

    /* renamed from: a */
    static final Interpolator f462a = new LinearInterpolator();

    /* renamed from: b */
    static final Interpolator f463b = new FastOutSlowInInterpolator();

    /* renamed from: c */
    static final Interpolator f464c = new FastOutLinearInInterpolator();

    /* renamed from: d */
    static final Interpolator f465d = new LinearOutSlowInInterpolator();

    /* renamed from: e */
    static final Interpolator f466e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int a(int i, int i2, float f2) {
        return i + Math.round(f2 * (i2 - i));
    }
}
