package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import java.util.Arrays;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Longs {

    /* renamed from: a */
    private static final byte[] f16039a = a();

    private Longs() {
    }

    public static int a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    public static long a(byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9) {
        return ((b3 & 255) << 48) | ((b2 & 255) << 56) | ((b4 & 255) << 40) | ((b5 & 255) << 32) | ((b6 & 255) << 24) | ((b7 & 255) << 16) | ((b8 & 255) << 8) | (b9 & 255);
    }

    private static byte[] a() {
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i = 0; i <= 9; i++) {
            bArr[i + 48] = (byte) i;
        }
        for (int i2 = 0; i2 <= 26; i2++) {
            byte b2 = (byte) (i2 + 10);
            bArr[i2 + 65] = b2;
            bArr[i2 + 97] = b2;
        }
        return bArr;
    }

    public static byte[] b(long j) {
        byte[] bArr = new byte[8];
        for (int i = 7; i >= 0; i--) {
            bArr[i] = (byte) (255 & j);
            j >>= 8;
        }
        return bArr;
    }
}
