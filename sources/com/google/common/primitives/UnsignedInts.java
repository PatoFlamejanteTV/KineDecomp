package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class UnsignedInts {
    private UnsignedInts() {
    }

    static int a(int i) {
        return Integer.MIN_VALUE ^ i;
    }

    public static int a(int i, int i2) {
        return Ints.a(a(i), a(i2));
    }

    public static long b(int i) {
        return i & 4294967295L;
    }

    public static int b(int i, int i2) {
        return (int) (b(i) / b(i2));
    }

    public static int c(int i, int i2) {
        return (int) (b(i) % b(i2));
    }

    public static int a(String str, int i) {
        Preconditions.a(str);
        long parseLong = Long.parseLong(str, i);
        if ((4294967295L & parseLong) != parseLong) {
            throw new NumberFormatException("Input " + str + " in base " + i + " is not in the range of an unsigned integer");
        }
        return (int) parseLong;
    }

    public static String d(int i, int i2) {
        return Long.toString(i & 4294967295L, i2);
    }
}
