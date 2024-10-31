package com.github.ybq.android.spinkit.a.a;

import android.os.Build;
import android.view.animation.Interpolator;

/* compiled from: PathInterpolatorCompat.java */
/* loaded from: classes.dex */
public class c {
    public static Interpolator a(float f2, float f3, float f4, float f5) {
        if (Build.VERSION.SDK_INT >= 21) {
            return d.a(f2, f3, f4, f5);
        }
        return e.a(f2, f3, f4, f5);
    }
}
