package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.BloomFilter;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 { // from class: com.google.common.hash.BloomFilterStrategies.1
        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t, Funnel<? super T> funnel, int i, a aVar) {
            long asLong = Hashing.a().newHasher().a((Hasher) t, (Funnel<? super Hasher>) funnel).a().asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            boolean z = false;
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 ^= -1;
                }
                z |= aVar.a(i5 % aVar.a());
            }
            return z;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, a aVar) {
            long asLong = Hashing.a().newHasher().a((Hasher) t, (Funnel<? super Hasher>) funnel).a().asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 ^= -1;
                }
                if (!aVar.b(i5 % aVar.a())) {
                    return false;
                }
            }
            return true;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final long[] f2903a;
        int b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i) {
            this(new long[IntMath.a(i, 64, RoundingMode.CEILING)]);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(long[] jArr) {
            Preconditions.a(jArr.length > 0, "data length is zero!");
            this.f2903a = jArr;
            int i = 0;
            for (long j : jArr) {
                i += Long.bitCount(j);
            }
            this.b = i;
        }

        boolean a(int i) {
            if (b(i)) {
                return false;
            }
            long[] jArr = this.f2903a;
            int i2 = i >> 6;
            jArr[i2] = jArr[i2] | (1 << i);
            this.b++;
            return true;
        }

        boolean b(int i) {
            return (this.f2903a[i >> 6] & (1 << i)) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a() {
            return this.f2903a.length * 64;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a c() {
            return new a((long[]) this.f2903a.clone());
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return Arrays.equals(this.f2903a, ((a) obj).f2903a);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f2903a);
        }
    }
}
