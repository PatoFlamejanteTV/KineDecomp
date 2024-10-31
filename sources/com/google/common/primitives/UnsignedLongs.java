package com.google.common.primitives;

import com.facebook.appevents.AppEventsConstants;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.math.BigInteger;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class UnsignedLongs {

    /* renamed from: a, reason: collision with root package name */
    private static final long[] f2930a = new long[37];
    private static final int[] b = new int[37];
    private static final int[] c = new int[37];

    private UnsignedLongs() {
    }

    private static long b(long j) {
        return Long.MIN_VALUE ^ j;
    }

    public static int a(long j, long j2) {
        return Longs.a(b(j), b(j2));
    }

    public static long b(long j, long j2) {
        if (j2 < 0) {
            return a(j, j2) < 0 ? 0L : 1L;
        }
        if (j >= 0) {
            return j / j2;
        }
        long j3 = ((j >>> 1) / j2) << 1;
        return (a(j - (j3 * j2), j2) < 0 ? 0 : 1) + j3;
    }

    public static long c(long j, long j2) {
        if (j2 < 0) {
            if (a(j, j2) >= 0) {
                return j - j2;
            }
            return j;
        }
        if (j >= 0) {
            return j % j2;
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if (a(j3, j2) < 0) {
            j2 = 0;
        }
        return j3 - j2;
    }

    public static long a(String str, int i) {
        Preconditions.a(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        if (i < 2 || i > 36) {
            throw new NumberFormatException("illegal radix: " + i);
        }
        int i2 = c[i] - 1;
        long j = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            int digit = Character.digit(str.charAt(i3), i);
            if (digit == -1) {
                throw new NumberFormatException(str);
            }
            if (i3 > i2 && a(j, digit, i)) {
                throw new NumberFormatException("Too large for unsigned long: " + str);
            }
            j = (j * i) + digit;
        }
        return j;
    }

    private static boolean a(long j, int i, int i2) {
        if (j < 0) {
            return true;
        }
        if (j < f2930a[i2]) {
            return false;
        }
        return j > f2930a[i2] || i > b[i2];
    }

    public static String a(long j) {
        return a(j, 10);
    }

    public static String a(long j, int i) {
        int i2;
        Preconditions.a(i >= 2 && i <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", Integer.valueOf(i));
        if (j == 0) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        char[] cArr = new char[64];
        int length = cArr.length;
        if (j < 0) {
            long b2 = b(j, i);
            int i3 = length - 1;
            cArr[i3] = Character.forDigit((int) (j - (i * b2)), i);
            i2 = i3;
            j = b2;
        } else {
            i2 = length;
        }
        while (j > 0) {
            int i4 = i2 - 1;
            cArr[i4] = Character.forDigit((int) (j % i), i);
            j /= i;
            i2 = i4;
        }
        return new String(cArr, i2, cArr.length - i2);
    }

    static {
        BigInteger bigInteger = new BigInteger("10000000000000000", 16);
        for (int i = 2; i <= 36; i++) {
            f2930a[i] = b(-1L, i);
            b[i] = (int) c(-1L, i);
            c[i] = bigInteger.toString(i).length() - 1;
        }
    }
}
