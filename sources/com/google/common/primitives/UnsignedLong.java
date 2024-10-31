package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.math.BigInteger;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class UnsignedLong extends Number implements Serializable, Comparable<UnsignedLong> {
    private final long value;
    public static final UnsignedLong ZERO = new UnsignedLong(0);
    public static final UnsignedLong ONE = new UnsignedLong(1);
    public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1);

    private UnsignedLong(long j) {
        this.value = j;
    }

    public static UnsignedLong asUnsigned(long j) {
        return new UnsignedLong(j);
    }

    public static UnsignedLong valueOf(BigInteger bigInteger) {
        Preconditions.a(bigInteger);
        Preconditions.a(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", bigInteger);
        return asUnsigned(bigInteger.longValue());
    }

    public static UnsignedLong valueOf(String str) {
        return valueOf(str, 10);
    }

    public static UnsignedLong valueOf(String str, int i) {
        return asUnsigned(UnsignedLongs.a(str, i));
    }

    public UnsignedLong add(UnsignedLong unsignedLong) {
        Preconditions.a(unsignedLong);
        return asUnsigned(this.value + unsignedLong.value);
    }

    public UnsignedLong subtract(UnsignedLong unsignedLong) {
        Preconditions.a(unsignedLong);
        return asUnsigned(this.value - unsignedLong.value);
    }

    public UnsignedLong multiply(UnsignedLong unsignedLong) {
        Preconditions.a(unsignedLong);
        return asUnsigned(this.value * unsignedLong.value);
    }

    public UnsignedLong divide(UnsignedLong unsignedLong) {
        Preconditions.a(unsignedLong);
        return asUnsigned(UnsignedLongs.b(this.value, unsignedLong.value));
    }

    public UnsignedLong remainder(UnsignedLong unsignedLong) {
        Preconditions.a(unsignedLong);
        return asUnsigned(UnsignedLongs.c(this.value, unsignedLong.value));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        float f = (float) (this.value & Long.MAX_VALUE);
        if (this.value < 0) {
            return f + 9.223372E18f;
        }
        return f;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        double d = this.value & Long.MAX_VALUE;
        if (this.value < 0) {
            return d + 9.223372036854776E18d;
        }
        return d;
    }

    public BigInteger bigIntegerValue() {
        BigInteger valueOf = BigInteger.valueOf(this.value & Long.MAX_VALUE);
        if (this.value < 0) {
            return valueOf.setBit(63);
        }
        return valueOf;
    }

    @Override // java.lang.Comparable
    public int compareTo(UnsignedLong unsignedLong) {
        Preconditions.a(unsignedLong);
        return UnsignedLongs.a(this.value, unsignedLong.value);
    }

    public int hashCode() {
        return Longs.a(this.value);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof UnsignedLong) && this.value == ((UnsignedLong) obj).value;
    }

    public String toString() {
        return UnsignedLongs.a(this.value);
    }

    public String toString(int i) {
        return UnsignedLongs.a(this.value, i);
    }
}
