package com.google.common.hash;

import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
final class Murmur3_128HashFunction extends AbstractStreamingHashFunction implements Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;

    public Murmur3_128HashFunction(int i) {
        this.seed = i;
    }

    public int bits() {
        return 128;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof Murmur3_128HashFunction) && this.seed == ((Murmur3_128HashFunction) obj).seed;
    }

    public int hashCode() {
        return Murmur3_128HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new a(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_128(" + this.seed + ")";
    }

    /* loaded from: classes2.dex */
    private static final class a extends AbstractStreamingHashFunction.AbstractStreamingHasher {

        /* renamed from: d */
        private long f15945d;

        /* renamed from: e */
        private long f15946e;

        /* renamed from: f */
        private int f15947f;

        a(int i) {
            super(16);
            long j = i;
            this.f15945d = j;
            this.f15946e = j;
            this.f15947f = 0;
        }

        private static long b(long j) {
            long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
            long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
            return j3 ^ (j3 >>> 33);
        }

        private static long c(long j) {
            return Long.rotateLeft(j * (-8663945395140668459L), 31) * 5545529020109919103L;
        }

        private static long d(long j) {
            return Long.rotateLeft(j * 5545529020109919103L, 33) * (-8663945395140668459L);
        }

        @Override // com.google.common.hash.AbstractStreamingHashFunction.AbstractStreamingHasher
        protected void a(ByteBuffer byteBuffer) {
            a(byteBuffer.getLong(), byteBuffer.getLong());
            this.f15947f += 16;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x001b. Please report as an issue. */
        @Override // com.google.common.hash.AbstractStreamingHashFunction.AbstractStreamingHasher
        protected void b(ByteBuffer byteBuffer) {
            long j;
            long j2;
            long j3;
            long j4;
            long j5;
            long j6;
            long a2;
            long j7;
            long j8;
            long j9;
            long j10;
            long j11;
            long j12;
            long j13;
            this.f15947f += byteBuffer.remaining();
            switch (byteBuffer.remaining()) {
                case 1:
                    j = 0;
                    a2 = UnsignedBytes.a(byteBuffer.get(0)) ^ j;
                    j7 = 0;
                    this.f15945d = c(a2) ^ this.f15945d;
                    this.f15946e = d(j7) ^ this.f15946e;
                    return;
                case 2:
                    j2 = 0;
                    j = j2 ^ (UnsignedBytes.a(byteBuffer.get(1)) << 8);
                    a2 = UnsignedBytes.a(byteBuffer.get(0)) ^ j;
                    j7 = 0;
                    this.f15945d = c(a2) ^ this.f15945d;
                    this.f15946e = d(j7) ^ this.f15946e;
                    return;
                case 3:
                    j3 = 0;
                    j2 = j3 ^ (UnsignedBytes.a(byteBuffer.get(2)) << 16);
                    j = j2 ^ (UnsignedBytes.a(byteBuffer.get(1)) << 8);
                    a2 = UnsignedBytes.a(byteBuffer.get(0)) ^ j;
                    j7 = 0;
                    this.f15945d = c(a2) ^ this.f15945d;
                    this.f15946e = d(j7) ^ this.f15946e;
                    return;
                case 4:
                    j4 = 0;
                    j3 = j4 ^ (UnsignedBytes.a(byteBuffer.get(3)) << 24);
                    j2 = j3 ^ (UnsignedBytes.a(byteBuffer.get(2)) << 16);
                    j = j2 ^ (UnsignedBytes.a(byteBuffer.get(1)) << 8);
                    a2 = UnsignedBytes.a(byteBuffer.get(0)) ^ j;
                    j7 = 0;
                    this.f15945d = c(a2) ^ this.f15945d;
                    this.f15946e = d(j7) ^ this.f15946e;
                    return;
                case 5:
                    j5 = 0;
                    j4 = j5 ^ (UnsignedBytes.a(byteBuffer.get(4)) << 32);
                    j3 = j4 ^ (UnsignedBytes.a(byteBuffer.get(3)) << 24);
                    j2 = j3 ^ (UnsignedBytes.a(byteBuffer.get(2)) << 16);
                    j = j2 ^ (UnsignedBytes.a(byteBuffer.get(1)) << 8);
                    a2 = UnsignedBytes.a(byteBuffer.get(0)) ^ j;
                    j7 = 0;
                    this.f15945d = c(a2) ^ this.f15945d;
                    this.f15946e = d(j7) ^ this.f15946e;
                    return;
                case 6:
                    j6 = 0;
                    j5 = j6 ^ (UnsignedBytes.a(byteBuffer.get(5)) << 40);
                    j4 = j5 ^ (UnsignedBytes.a(byteBuffer.get(4)) << 32);
                    j3 = j4 ^ (UnsignedBytes.a(byteBuffer.get(3)) << 24);
                    j2 = j3 ^ (UnsignedBytes.a(byteBuffer.get(2)) << 16);
                    j = j2 ^ (UnsignedBytes.a(byteBuffer.get(1)) << 8);
                    a2 = UnsignedBytes.a(byteBuffer.get(0)) ^ j;
                    j7 = 0;
                    this.f15945d = c(a2) ^ this.f15945d;
                    this.f15946e = d(j7) ^ this.f15946e;
                    return;
                case 7:
                    j6 = (UnsignedBytes.a(byteBuffer.get(6)) << 48) ^ 0;
                    j5 = j6 ^ (UnsignedBytes.a(byteBuffer.get(5)) << 40);
                    j4 = j5 ^ (UnsignedBytes.a(byteBuffer.get(4)) << 32);
                    j3 = j4 ^ (UnsignedBytes.a(byteBuffer.get(3)) << 24);
                    j2 = j3 ^ (UnsignedBytes.a(byteBuffer.get(2)) << 16);
                    j = j2 ^ (UnsignedBytes.a(byteBuffer.get(1)) << 8);
                    a2 = UnsignedBytes.a(byteBuffer.get(0)) ^ j;
                    j7 = 0;
                    this.f15945d = c(a2) ^ this.f15945d;
                    this.f15946e = d(j7) ^ this.f15946e;
                    return;
                case 8:
                    j7 = 0;
                    a2 = byteBuffer.getLong() ^ 0;
                    this.f15945d = c(a2) ^ this.f15945d;
                    this.f15946e = d(j7) ^ this.f15946e;
                    return;
                case 9:
                    j8 = 0;
                    j7 = j8 ^ UnsignedBytes.a(byteBuffer.get(8));
                    a2 = byteBuffer.getLong() ^ 0;
                    this.f15945d = c(a2) ^ this.f15945d;
                    this.f15946e = d(j7) ^ this.f15946e;
                    return;
                case 10:
                    j9 = 0;
                    j8 = j9 ^ (UnsignedBytes.a(byteBuffer.get(9)) << 8);
                    j7 = j8 ^ UnsignedBytes.a(byteBuffer.get(8));
                    a2 = byteBuffer.getLong() ^ 0;
                    this.f15945d = c(a2) ^ this.f15945d;
                    this.f15946e = d(j7) ^ this.f15946e;
                    return;
                case 11:
                    j10 = 0;
                    j9 = j10 ^ (UnsignedBytes.a(byteBuffer.get(10)) << 16);
                    j8 = j9 ^ (UnsignedBytes.a(byteBuffer.get(9)) << 8);
                    j7 = j8 ^ UnsignedBytes.a(byteBuffer.get(8));
                    a2 = byteBuffer.getLong() ^ 0;
                    this.f15945d = c(a2) ^ this.f15945d;
                    this.f15946e = d(j7) ^ this.f15946e;
                    return;
                case 12:
                    j11 = 0;
                    j10 = j11 ^ (UnsignedBytes.a(byteBuffer.get(11)) << 24);
                    j9 = j10 ^ (UnsignedBytes.a(byteBuffer.get(10)) << 16);
                    j8 = j9 ^ (UnsignedBytes.a(byteBuffer.get(9)) << 8);
                    j7 = j8 ^ UnsignedBytes.a(byteBuffer.get(8));
                    a2 = byteBuffer.getLong() ^ 0;
                    this.f15945d = c(a2) ^ this.f15945d;
                    this.f15946e = d(j7) ^ this.f15946e;
                    return;
                case 13:
                    j12 = 0;
                    j11 = j12 ^ (UnsignedBytes.a(byteBuffer.get(12)) << 32);
                    j10 = j11 ^ (UnsignedBytes.a(byteBuffer.get(11)) << 24);
                    j9 = j10 ^ (UnsignedBytes.a(byteBuffer.get(10)) << 16);
                    j8 = j9 ^ (UnsignedBytes.a(byteBuffer.get(9)) << 8);
                    j7 = j8 ^ UnsignedBytes.a(byteBuffer.get(8));
                    a2 = byteBuffer.getLong() ^ 0;
                    this.f15945d = c(a2) ^ this.f15945d;
                    this.f15946e = d(j7) ^ this.f15946e;
                    return;
                case 14:
                    j13 = 0;
                    j12 = j13 ^ (UnsignedBytes.a(byteBuffer.get(13)) << 40);
                    j11 = j12 ^ (UnsignedBytes.a(byteBuffer.get(12)) << 32);
                    j10 = j11 ^ (UnsignedBytes.a(byteBuffer.get(11)) << 24);
                    j9 = j10 ^ (UnsignedBytes.a(byteBuffer.get(10)) << 16);
                    j8 = j9 ^ (UnsignedBytes.a(byteBuffer.get(9)) << 8);
                    j7 = j8 ^ UnsignedBytes.a(byteBuffer.get(8));
                    a2 = byteBuffer.getLong() ^ 0;
                    this.f15945d = c(a2) ^ this.f15945d;
                    this.f15946e = d(j7) ^ this.f15946e;
                    return;
                case 15:
                    j13 = (UnsignedBytes.a(byteBuffer.get(14)) << 48) ^ 0;
                    j12 = j13 ^ (UnsignedBytes.a(byteBuffer.get(13)) << 40);
                    j11 = j12 ^ (UnsignedBytes.a(byteBuffer.get(12)) << 32);
                    j10 = j11 ^ (UnsignedBytes.a(byteBuffer.get(11)) << 24);
                    j9 = j10 ^ (UnsignedBytes.a(byteBuffer.get(10)) << 16);
                    j8 = j9 ^ (UnsignedBytes.a(byteBuffer.get(9)) << 8);
                    j7 = j8 ^ UnsignedBytes.a(byteBuffer.get(8));
                    a2 = byteBuffer.getLong() ^ 0;
                    this.f15945d = c(a2) ^ this.f15945d;
                    this.f15946e = d(j7) ^ this.f15946e;
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }

        private void a(long j, long j2) {
            this.f15945d = c(j) ^ this.f15945d;
            this.f15945d = Long.rotateLeft(this.f15945d, 27);
            long j3 = this.f15945d;
            long j4 = this.f15946e;
            this.f15945d = j3 + j4;
            this.f15945d = (this.f15945d * 5) + 1390208809;
            this.f15946e = d(j2) ^ j4;
            this.f15946e = Long.rotateLeft(this.f15946e, 31);
            this.f15946e += this.f15945d;
            this.f15946e = (this.f15946e * 5) + 944331445;
        }

        @Override // com.google.common.hash.AbstractStreamingHashFunction.AbstractStreamingHasher
        public HashCode b() {
            long j = this.f15945d;
            int i = this.f15947f;
            this.f15945d = j ^ i;
            this.f15946e ^= i;
            long j2 = this.f15945d;
            long j3 = this.f15946e;
            this.f15945d = j2 + j3;
            long j4 = this.f15945d;
            this.f15946e = j3 + j4;
            this.f15945d = b(j4);
            this.f15946e = b(this.f15946e);
            long j5 = this.f15945d;
            long j6 = this.f15946e;
            this.f15945d = j5 + j6;
            this.f15946e = j6 + this.f15945d;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f15945d).putLong(this.f15946e).array());
        }
    }
}
