package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Hashing.java */
@GwtCompatible
/* loaded from: classes2.dex */
public final class Q {
    public static int a(int i) {
        return Integer.rotateLeft(i * (-862048943), 15) * 461845907;
    }

    public static int a(@Nullable Object obj) {
        return a(obj == null ? 0 : obj.hashCode());
    }

    public static int a(int i, double d2) {
        int max = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(max);
        double d3 = highestOneBit;
        Double.isNaN(d3);
        if (max <= ((int) (d2 * d3))) {
            return highestOneBit;
        }
        int i2 = highestOneBit << 1;
        if (i2 > 0) {
            return i2;
        }
        return 1073741824;
    }

    public static boolean a(int i, int i2, double d2) {
        double d3 = i;
        double d4 = i2;
        Double.isNaN(d4);
        return d3 > d2 * d4 && i2 < 1073741824;
    }
}
