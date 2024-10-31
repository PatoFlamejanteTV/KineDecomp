package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.math.BigInteger;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable {
    private final long value;
    public static final UnsignedLong ZERO = new UnsignedLong(0);
    public static final UnsignedLong ONE = new UnsignedLong(1);
    public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1);

    private UnsignedLong(long j) {
        this.value = j;
    }

    public static UnsignedLong fromLongBits(long j) {
        return new UnsignedLong(j);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(long j) {
        Preconditions.a(j >= 0, "value (%s) is outside the range for an unsigned long value", j);
        return fromLongBits(j);
    }

    public BigInteger bigIntegerValue() {
        BigInteger valueOf = BigInteger.valueOf(this.value & Long.MAX_VALUE);
        return this.value < 0 ? valueOf.setBit(63) : valueOf;
    }

    public UnsignedLong dividedBy(UnsignedLong unsignedLong) {
        long j = this.value;
        Preconditions.a(unsignedLong);
        return fromLongBits(UnsignedLongs.b(j, unsignedLong.value));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        long j = this.value;
        double d2 = Long.MAX_VALUE & j;
        if (j >= 0) {
            return d2;
        }
        Double.isNaN(d2);
        return d2 + 9.223372036854776E18d;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof UnsignedLong) && this.value == ((UnsignedLong) obj).value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        long j = this.value;
        float f2 = (float) (Long.MAX_VALUE & j);
        return j < 0 ? f2 + 9.223372E18f : f2;
    }

    public int hashCode() {
        return Longs.a(this.value);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public UnsignedLong minus(UnsignedLong unsignedLong) {
        long j = this.value;
        Preconditions.a(unsignedLong);
        return fromLongBits(j - unsignedLong.value);
    }

    public UnsignedLong mod(UnsignedLong unsignedLong) {
        long j = this.value;
        Preconditions.a(unsignedLong);
        return fromLongBits(UnsignedLongs.c(j, unsignedLong.value));
    }

    public UnsignedLong plus(UnsignedLong unsignedLong) {
        long j = this.value;
        Preconditions.a(unsignedLong);
        return fromLongBits(j + unsignedLong.value);
    }

    public UnsignedLong times(UnsignedLong unsignedLong) {
        long j = this.value;
        Preconditions.a(unsignedLong);
        return fromLongBits(j * unsignedLong.value);
    }

    public String toString() {
        return UnsignedLongs.a(this.value);
    }

    @Override // java.lang.Comparable
    public int compareTo(UnsignedLong unsignedLong) {
        Preconditions.a(unsignedLong);
        return UnsignedLongs.a(this.value, unsignedLong.value);
    }

    public String toString(int i) {
        return UnsignedLongs.a(this.value, i);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(BigInteger bigInteger) {
        Preconditions.a(bigInteger);
        Preconditions.a(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", bigInteger);
        return fromLongBits(bigInteger.longValue());
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(String str) {
        return valueOf(str, 10);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(String str, int i) {
        return fromLongBits(UnsignedLongs.a(str, i));
    }
}
