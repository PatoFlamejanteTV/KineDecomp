package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes2.dex */
public final class SignedBytes {
    private SignedBytes() {
    }

    public static byte a(long j) {
        byte b2 = (byte) j;
        if (b2 == j) {
            return b2;
        }
        throw new IllegalArgumentException("Out of range: " + j);
    }
}
