package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import javax.annotation.Nullable;

@Beta
/* loaded from: classes2.dex */
public final class BloomFilter<T> implements Predicate<T>, Serializable {
    private final BloomFilterStrategies.a bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    /* loaded from: classes2.dex */
    private static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<? super T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        SerialForm(BloomFilter<T> bloomFilter) {
            this.data = ((BloomFilter) bloomFilter).bits.f15937a;
            this.numHashFunctions = ((BloomFilter) bloomFilter).numHashFunctions;
            this.funnel = ((BloomFilter) bloomFilter).funnel;
            this.strategy = ((BloomFilter) bloomFilter).strategy;
        }

        Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.a(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }

    /* loaded from: classes2.dex */
    public interface Strategy extends Serializable {
        <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, BloomFilterStrategies.a aVar);

        int ordinal();

        <T> boolean put(T t, Funnel<? super T> funnel, int i, BloomFilterStrategies.a aVar);
    }

    /* synthetic */ BloomFilter(BloomFilterStrategies.a aVar, int i, Funnel funnel, Strategy strategy, b bVar) {
        this(aVar, i, funnel, strategy);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i, double d2) {
        return create(funnel, i, d2);
    }

    @VisibleForTesting
    static long optimalNumOfBits(long j, double d2) {
        if (d2 == 0.0d) {
            d2 = Double.MIN_VALUE;
        }
        double d3 = -j;
        double log = Math.log(d2);
        Double.isNaN(d3);
        return (long) ((d3 * log) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    @VisibleForTesting
    static int optimalNumOfHashFunctions(long j, long j2) {
        double d2 = j2;
        double d3 = j;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return Math.max(1, (int) Math.round((d2 / d3) * Math.log(2.0d)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<T> funnel) throws IOException {
        byte b2;
        int i;
        DataInputStream dataInputStream;
        Preconditions.a(inputStream, "InputStream");
        Preconditions.a(funnel, "Funnel");
        int i2 = -1;
        try {
            dataInputStream = new DataInputStream(inputStream);
            b2 = dataInputStream.readByte();
        } catch (RuntimeException e2) {
            e = e2;
            b2 = -1;
        }
        try {
            i = UnsignedBytes.a(dataInputStream.readByte());
            try {
                i2 = dataInputStream.readInt();
                BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[b2];
                long[] jArr = new long[i2];
                for (int i3 = 0; i3 < jArr.length; i3++) {
                    jArr[i3] = dataInputStream.readLong();
                }
                return new BloomFilter<>(new BloomFilterStrategies.a(jArr), i, funnel, bloomFilterStrategies);
            } catch (RuntimeException e3) {
                e = e3;
                throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b2) + " numHashFunctions: " + i + " dataLength: " + i2, e);
            }
        } catch (RuntimeException e4) {
            e = e4;
            i = -1;
            throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b2) + " numHashFunctions: " + i + " dataLength: " + i2, e);
        }
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(T t) {
        return mightContain(t);
    }

    @VisibleForTesting
    long bitSize() {
        return this.bits.b();
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.c(), this.numHashFunctions, this.funnel, this.strategy);
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        return this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy);
    }

    public double expectedFpp() {
        double a2 = this.bits.a();
        double bitSize = bitSize();
        Double.isNaN(a2);
        Double.isNaN(bitSize);
        return Math.pow(a2 / bitSize, this.numHashFunctions);
    }

    public int hashCode() {
        return Objects.a(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        Preconditions.a(bloomFilter);
        return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
    }

    public boolean mightContain(T t) {
        return this.strategy.mightContain(t, this.funnel, this.numHashFunctions, this.bits);
    }

    @CanIgnoreReturnValue
    public boolean put(T t) {
        return this.strategy.put(t, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        Preconditions.a(bloomFilter);
        Preconditions.a(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
        Preconditions.a(this.numHashFunctions == bloomFilter.numHashFunctions, "BloomFilters must have the same number of hash functions (%s != %s)", this.numHashFunctions, bloomFilter.numHashFunctions);
        Preconditions.a(bitSize() == bloomFilter.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), bloomFilter.bitSize());
        Preconditions.a(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        Preconditions.a(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.a(bloomFilter.bits);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.a(this.strategy.ordinal()));
        dataOutputStream.writeByte(UnsignedBytes.a(this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.f15937a.length);
        for (long j : this.bits.f15937a) {
            dataOutputStream.writeLong(j);
        }
    }

    private BloomFilter(BloomFilterStrategies.a aVar, int i, Funnel<? super T> funnel, Strategy strategy) {
        Preconditions.a(i > 0, "numHashFunctions (%s) must be > 0", i);
        Preconditions.a(i <= 255, "numHashFunctions (%s) must be <= 255", i);
        Preconditions.a(aVar);
        this.bits = aVar;
        this.numHashFunctions = i;
        Preconditions.a(funnel);
        this.funnel = funnel;
        Preconditions.a(strategy);
        this.strategy = strategy;
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j, double d2) {
        return create(funnel, j, d2, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    @VisibleForTesting
    static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j, double d2, Strategy strategy) {
        Preconditions.a(funnel);
        Preconditions.a(j >= 0, "Expected insertions (%s) must be >= 0", j);
        Preconditions.a(d2 > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d2));
        Preconditions.a(d2 < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(d2));
        Preconditions.a(strategy);
        if (j == 0) {
            j = 1;
        }
        long optimalNumOfBits = optimalNumOfBits(j, d2);
        try {
            return new BloomFilter<>(new BloomFilterStrategies.a(optimalNumOfBits), optimalNumOfHashFunctions(j, optimalNumOfBits), funnel, strategy);
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException("Could not create BloomFilter of " + optimalNumOfBits + " bits", e2);
        }
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i) {
        return create(funnel, i);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j) {
        return create(funnel, j, 0.03d);
    }
}
