package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.BloomFilter;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 { // from class: com.google.common.hash.BloomFilterStrategies.1
        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, a aVar) {
            long b2 = aVar.b();
            long asLong = Hashing.b().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 ^= -1;
                }
                if (!aVar.a(i5 % b2)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t, Funnel<? super T> funnel, int i, a aVar) {
            long b2 = aVar.b();
            long asLong = Hashing.b().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            boolean z = false;
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 ^= -1;
                }
                z |= aVar.b(i5 % b2);
            }
            return z;
        }
    },
    MURMUR128_MITZ_64 { // from class: com.google.common.hash.BloomFilterStrategies.2
        private long a(byte[] bArr) {
            return Longs.a(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long b(byte[] bArr) {
            return Longs.a(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, a aVar) {
            long b2 = aVar.b();
            byte[] bytesInternal = Hashing.b().hashObject(t, funnel).getBytesInternal();
            long a2 = a(bytesInternal);
            long b3 = b(bytesInternal);
            long j = a2;
            for (int i2 = 0; i2 < i; i2++) {
                if (!aVar.a((Long.MAX_VALUE & j) % b2)) {
                    return false;
                }
                j += b3;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t, Funnel<? super T> funnel, int i, a aVar) {
            long b2 = aVar.b();
            byte[] bytesInternal = Hashing.b().hashObject(t, funnel).getBytesInternal();
            long a2 = a(bytesInternal);
            long b3 = b(bytesInternal);
            long j = a2;
            boolean z = false;
            for (int i2 = 0; i2 < i; i2++) {
                z |= aVar.b((Long.MAX_VALUE & j) % b2);
                j += b3;
            }
            return z;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.hash.BloomFilterStrategies$1 */
    /* loaded from: classes2.dex */
    public enum AnonymousClass1 extends BloomFilterStrategies {
        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, a aVar) {
            long b2 = aVar.b();
            long asLong = Hashing.b().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 ^= -1;
                }
                if (!aVar.a(i5 % b2)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t, Funnel<? super T> funnel, int i, a aVar) {
            long b2 = aVar.b();
            long asLong = Hashing.b().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            boolean z = false;
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 ^= -1;
                }
                z |= aVar.b(i5 % b2);
            }
            return z;
        }
    }

    /* renamed from: com.google.common.hash.BloomFilterStrategies$2 */
    /* loaded from: classes2.dex */
    enum AnonymousClass2 extends BloomFilterStrategies {
        private long a(byte[] bArr) {
            return Longs.a(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long b(byte[] bArr) {
            return Longs.a(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, a aVar) {
            long b2 = aVar.b();
            byte[] bytesInternal = Hashing.b().hashObject(t, funnel).getBytesInternal();
            long a2 = a(bytesInternal);
            long b3 = b(bytesInternal);
            long j = a2;
            for (int i2 = 0; i2 < i; i2++) {
                if (!aVar.a((Long.MAX_VALUE & j) % b2)) {
                    return false;
                }
                j += b3;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t, Funnel<? super T> funnel, int i, a aVar) {
            long b2 = aVar.b();
            byte[] bytesInternal = Hashing.b().hashObject(t, funnel).getBytesInternal();
            long a2 = a(bytesInternal);
            long b3 = b(bytesInternal);
            long j = a2;
            boolean z = false;
            for (int i2 = 0; i2 < i; i2++) {
                z |= aVar.b((Long.MAX_VALUE & j) % b2);
                j += b3;
            }
            return z;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a */
        final long[] f15937a;

        /* renamed from: b */
        long f15938b;

        public a(long j) {
            this(new long[Ints.a(LongMath.a(j, 64L, RoundingMode.CEILING))]);
        }

        boolean a(long j) {
            return ((1 << ((int) j)) & this.f15937a[(int) (j >>> 6)]) != 0;
        }

        boolean b(long j) {
            if (a(j)) {
                return false;
            }
            long[] jArr = this.f15937a;
            int i = (int) (j >>> 6);
            jArr[i] = (1 << ((int) j)) | jArr[i];
            this.f15938b++;
            return true;
        }

        public a c() {
            return new a((long[]) this.f15937a.clone());
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof a) {
                return Arrays.equals(this.f15937a, ((a) obj).f15937a);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f15937a);
        }

        public a(long[] jArr) {
            Preconditions.a(jArr.length > 0, "data length is zero!");
            this.f15937a = jArr;
            long j = 0;
            for (long j2 : jArr) {
                j += Long.bitCount(j2);
            }
            this.f15938b = j;
        }

        public long a() {
            return this.f15938b;
        }

        public void a(a aVar) {
            int i = 0;
            Preconditions.a(this.f15937a.length == aVar.f15937a.length, "BitArrays must be of equal length (%s != %s)", this.f15937a.length, aVar.f15937a.length);
            this.f15938b = 0L;
            while (true) {
                long[] jArr = this.f15937a;
                if (i >= jArr.length) {
                    return;
                }
                jArr[i] = jArr[i] | aVar.f15937a[i];
                this.f15938b += Long.bitCount(jArr[i]);
                i++;
            }
        }

        public long b() {
            return this.f15937a.length * 64;
        }
    }

    /* synthetic */ BloomFilterStrategies(AnonymousClass1 anonymousClass1) {
        this();
    }
}
