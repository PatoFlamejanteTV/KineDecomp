package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.hash.BloomFilterStrategies;
import java.io.Serializable;

@Beta
/* loaded from: classes2.dex */
public final class BloomFilter<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private static final double f2902a = Math.log(2.0d);
    private static final double b = f2902a * f2902a;
    private final BloomFilterStrategies.a bits;
    private final Funnel<T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface Strategy extends Serializable {
        <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, BloomFilterStrategies.a aVar);

        int ordinal();

        <T> boolean put(T t, Funnel<? super T> funnel, int i, BloomFilterStrategies.a aVar);
    }

    private BloomFilter(BloomFilterStrategies.a aVar, int i, Funnel<T> funnel, Strategy strategy) {
        Preconditions.a(i > 0, "numHashFunctions zero or negative");
        this.bits = (BloomFilterStrategies.a) Preconditions.a(aVar);
        this.numHashFunctions = i;
        this.funnel = (Funnel) Preconditions.a(funnel);
        this.strategy = strategy;
        if (i > 255) {
            throw new AssertionError("Currently we don't allow BloomFilters that would use more than255 hash functions, please contact the guava team");
        }
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.c(), this.numHashFunctions, this.funnel, this.strategy);
    }

    public boolean mightContain(T t) {
        return this.strategy.mightContain(t, this.funnel, this.numHashFunctions, this.bits);
    }

    public boolean put(T t) {
        return this.strategy.put(t, this.funnel, this.numHashFunctions, this.bits);
    }

    public double expectedFalsePositiveProbability() {
        return Math.pow(this.bits.b() / this.bits.a(), this.numHashFunctions);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        return this.numHashFunctions == bloomFilter.numHashFunctions && this.bits.equals(bloomFilter.bits) && this.funnel == bloomFilter.funnel && this.strategy == bloomFilter.strategy;
    }

    public int hashCode() {
        return this.bits.hashCode();
    }

    @VisibleForTesting
    int getHashCount() {
        return this.numHashFunctions;
    }

    public static <T> BloomFilter<T> create(Funnel<T> funnel, int i, double d) {
        Preconditions.a(funnel);
        Preconditions.a(i >= 0, "Expected insertions cannot be negative");
        Preconditions.a((d > 0.0d) & (d < 1.0d), "False positive probability in (0.0, 1.0)");
        int i2 = i != 0 ? i : 1;
        int optimalNumOfBits = optimalNumOfBits(i2, d);
        return new BloomFilter<>(new BloomFilterStrategies.a(optimalNumOfBits), optimalNumOfHashFunctions(i2, optimalNumOfBits), funnel, BloomFilterStrategies.MURMUR128_MITZ_32);
    }

    public static <T> BloomFilter<T> create(Funnel<T> funnel, int i) {
        return create(funnel, i, 0.03d);
    }

    @VisibleForTesting
    static int optimalNumOfHashFunctions(int i, int i2) {
        return Math.max(1, (int) Math.round((i2 / i) * f2902a));
    }

    @VisibleForTesting
    static int optimalNumOfBits(int i, double d) {
        return (int) (((-i) * Math.log(d)) / b);
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    /* loaded from: classes2.dex */
    private static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        SerialForm(BloomFilter<T> bloomFilter) {
            this.data = ((BloomFilter) bloomFilter).bits.f2903a;
            this.numHashFunctions = ((BloomFilter) bloomFilter).numHashFunctions;
            this.funnel = ((BloomFilter) bloomFilter).funnel;
            this.strategy = ((BloomFilter) bloomFilter).strategy;
        }

        Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.a(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }
}
