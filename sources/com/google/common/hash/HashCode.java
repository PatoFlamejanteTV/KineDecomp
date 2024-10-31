package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.security.MessageDigest;

@Beta
/* loaded from: classes2.dex */
public abstract class HashCode {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f2904a = "0123456789abcdef".toCharArray();

    public abstract byte[] asBytes();

    public abstract int asInt();

    public abstract long asLong();

    public abstract int bits();

    public int writeBytesTo(byte[] bArr, int i, int i2) {
        byte[] asBytes = asBytes();
        int a2 = Ints.a(i2, asBytes.length);
        Preconditions.a(i, i + a2, bArr.length);
        System.arraycopy(asBytes, 0, bArr, i, a2);
        return a2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof HashCode) {
            return MessageDigest.isEqual(asBytes(), ((HashCode) obj).asBytes());
        }
        return false;
    }

    public int hashCode() {
        return asInt();
    }

    public String toString() {
        byte[] asBytes = asBytes();
        StringBuilder sb = new StringBuilder(asBytes.length * 2);
        for (byte b : asBytes) {
            sb.append(f2904a[(b >> 4) & 15]).append(f2904a[b & 15]);
        }
        return sb.toString();
    }
}
