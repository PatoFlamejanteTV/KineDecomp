package com.bumptech.glide.g;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;

/* compiled from: LogTime.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a */
    private static final double f8509a;

    static {
        f8509a = Build.VERSION.SDK_INT >= 17 ? 1.0d / Math.pow(10.0d, 6.0d) : 1.0d;
    }

    @TargetApi(17)
    public static long a() {
        if (Build.VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }

    public static double a(long j) {
        double a2 = a() - j;
        double d2 = f8509a;
        Double.isNaN(a2);
        return a2 * d2;
    }
}
