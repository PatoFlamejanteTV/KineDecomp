package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Longs {
    private Longs() {
    }

    public static int a(long j) {
        return (int) ((j >>> 32) ^ j);
    }

    public static int a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    public static byte[] b(long j) {
        byte[] bArr = new byte[8];
        for (int i = 7; i >= 0; i--) {
            bArr[i] = (byte) (255 & j);
            j >>= 8;
        }
        return bArr;
    }

    public static long a(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8) {
        return ((b & 255) << 56) | ((b2 & 255) << 48) | ((b3 & 255) << 40) | ((b4 & 255) << 32) | ((b5 & 255) << 24) | ((b6 & 255) << 16) | ((b7 & 255) << 8) | (b8 & 255);
    }
}
