package com.google.common.primitives;

import com.facebook.appevents.AppEventsConstants;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class UnsignedLongs {

    /* renamed from: a */
    private static final long[] f16042a = new long[37];

    /* renamed from: b */
    private static final int[] f16043b = new int[37];

    /* renamed from: c */
    private static final int[] f16044c = new int[37];

    static {
        BigInteger bigInteger = new BigInteger("10000000000000000", 16);
        for (int i = 2; i <= 36; i++) {
            long j = i;
            f16042a[i] = b(-1L, j);
            f16043b[i] = (int) c(-1L, j);
            f16044c[i] = bigInteger.toString(i).length() - 1;
        }
    }

    private UnsignedLongs() {
    }

    public static int a(long j, long j2) {
        return Longs.a(b(j), b(j2));
    }

    private static long b(long j) {
        return j ^ Long.MIN_VALUE;
    }

    public static long b(long j, long j2) {
        if (j2 < 0) {
            return a(j, j2) < 0 ? 0L : 1L;
        }
        if (j >= 0) {
            return j / j2;
        }
        long j3 = ((j >>> 1) / j2) << 1;
        return j3 + (a(j - (j3 * j2), j2) < 0 ? 0 : 1);
    }

    public static long c(long j, long j2) {
        if (j2 < 0) {
            return a(j, j2) < 0 ? j : j - j2;
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

    @CanIgnoreReturnValue
    public static long a(String str, int i) {
        Preconditions.a(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        if (i >= 2 && i <= 36) {
            int i2 = f16044c[i] - 1;
            long j = 0;
            for (int i3 = 0; i3 < str.length(); i3++) {
                int digit = Character.digit(str.charAt(i3), i);
                if (digit != -1) {
                    if (i3 > i2 && a(j, digit, i)) {
                        throw new NumberFormatException("Too large for unsigned long: " + str);
                    }
                    j = (j * i) + digit;
                } else {
                    throw new NumberFormatException(str);
                }
            }
            return j;
        }
        throw new NumberFormatException("illegal radix: " + i);
    }

    private static boolean a(long j, int i, int i2) {
        if (j < 0) {
            return true;
        }
        long[] jArr = f16042a;
        if (j < jArr[i2]) {
            return false;
        }
        return j > jArr[i2] || i > f16043b[i2];
    }

    public static String a(long j) {
        return a(j, 10);
    }

    public static String a(long j, int i) {
        long b2;
        Preconditions.a(i >= 2 && i <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i);
        if (j == 0) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        if (j > 0) {
            return Long.toString(j, i);
        }
        char[] cArr = new char[64];
        int length = cArr.length;
        int i2 = i - 1;
        if ((i & i2) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            do {
                length--;
                cArr[length] = Character.forDigit(((int) j) & i2, i);
                j >>>= numberOfTrailingZeros;
            } while (j != 0);
        } else {
            if ((i & 1) == 0) {
                b2 = (j >>> 1) / (i >>> 1);
            } else {
                b2 = b(j, i);
            }
            long j2 = i;
            length--;
            cArr[length] = Character.forDigit((int) (j - (b2 * j2)), i);
            while (b2 > 0) {
                length--;
                cArr[length] = Character.forDigit((int) (b2 % j2), i);
                b2 /= j2;
            }
        }
        return new String(cArr, length, cArr.length - length);
    }
}
