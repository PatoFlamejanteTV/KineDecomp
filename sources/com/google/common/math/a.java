package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DoubleUtils.java */
@GwtIncompatible
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a */
    private static final long f16008a = Double.doubleToRawLongBits(1.0d);

    public static double a(double d2) {
        Preconditions.a(!Double.isNaN(d2));
        if (d2 > 0.0d) {
            return d2;
        }
        return 0.0d;
    }

    public static boolean b(double d2) {
        return Math.getExponent(d2) <= 1023;
    }
}
