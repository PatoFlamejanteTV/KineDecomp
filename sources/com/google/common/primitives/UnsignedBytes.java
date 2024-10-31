package com.google.common.primitives;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@GwtIncompatible
/* loaded from: classes2.dex */
public final class UnsignedBytes {
    private UnsignedBytes() {
    }

    @CanIgnoreReturnValue
    public static byte a(long j) {
        if ((j >> 8) == 0) {
            return (byte) j;
        }
        throw new IllegalArgumentException("Out of range: " + j);
    }

    public static int a(byte b2) {
        return b2 & 255;
    }
}
