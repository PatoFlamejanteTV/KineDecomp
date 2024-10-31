package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.math.BigInteger;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class UnsignedInteger extends Number implements Comparable<UnsignedInteger> {
    private final int value;
    public static final UnsignedInteger ZERO = asUnsigned(0);
    public static final UnsignedInteger ONE = asUnsigned(1);
    public static final UnsignedInteger MAX_VALUE = asUnsigned(-1);

    private UnsignedInteger(int i) {
        this.value = i & (-1);
    }

    public static UnsignedInteger asUnsigned(int i) {
        return new UnsignedInteger(i);
    }

    public static UnsignedInteger valueOf(long j) {
        Preconditions.a((4294967295L & j) == j, "value (%s) is outside the range for an unsigned integer value", Long.valueOf(j));
        return asUnsigned((int) j);
    }

    public static UnsignedInteger valueOf(BigInteger bigInteger) {
        Preconditions.a(bigInteger);
        Preconditions.a(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 32, "value (%s) is outside the range for an unsigned integer value", bigInteger);
        return asUnsigned(bigInteger.intValue());
    }

    public static UnsignedInteger valueOf(String str) {
        return valueOf(str, 10);
    }

    public static UnsignedInteger valueOf(String str, int i) {
        return asUnsigned(UnsignedInts.a(str, i));
    }

    public UnsignedInteger add(UnsignedInteger unsignedInteger) {
        Preconditions.a(unsignedInteger);
        return asUnsigned(this.value + unsignedInteger.value);
    }

    public UnsignedInteger subtract(UnsignedInteger unsignedInteger) {
        Preconditions.a(unsignedInteger);
        return asUnsigned(this.value - unsignedInteger.value);
    }

    @GwtIncompatible
    public UnsignedInteger multiply(UnsignedInteger unsignedInteger) {
        Preconditions.a(unsignedInteger);
        return asUnsigned(this.value * unsignedInteger.value);
    }

    public UnsignedInteger divide(UnsignedInteger unsignedInteger) {
        Preconditions.a(unsignedInteger);
        return asUnsigned(UnsignedInts.b(this.value, unsignedInteger.value));
    }

    public UnsignedInteger remainder(UnsignedInteger unsignedInteger) {
        Preconditions.a(unsignedInteger);
        return asUnsigned(UnsignedInts.c(this.value, unsignedInteger.value));
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return UnsignedInts.b(this.value);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) longValue();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return longValue();
    }

    public BigInteger bigIntegerValue() {
        return BigInteger.valueOf(longValue());
    }

    @Override // java.lang.Comparable
    public int compareTo(UnsignedInteger unsignedInteger) {
        Preconditions.a(unsignedInteger);
        return UnsignedInts.a(this.value, unsignedInteger.value);
    }

    public int hashCode() {
        return this.value;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof UnsignedInteger) && this.value == ((UnsignedInteger) obj).value;
    }

    public String toString() {
        return toString(10);
    }

    public String toString(int i) {
        return UnsignedInts.d(this.value, i);
    }
}
