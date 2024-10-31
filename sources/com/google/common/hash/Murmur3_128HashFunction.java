package com.google.common.hash;

import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Murmur3_128HashFunction extends AbstractStreamingHashFunction implements Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Murmur3_128HashFunction(int i) {
        this.seed = i;
    }

    public int bits() {
        return 128;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new a(this.seed);
    }

    /* loaded from: classes2.dex */
    private static final class a extends AbstractStreamingHashFunction.AbstractStreamingHasher {

        /* renamed from: a, reason: collision with root package name */
        private long f2906a;
        private long b;
        private int c;

        a(int i) {
            super(16);
            this.f2906a = i;
            this.b = i;
            this.c = 0;
        }

        @Override // com.google.common.hash.AbstractStreamingHashFunction.AbstractStreamingHasher
        protected void a(ByteBuffer byteBuffer) {
            a(byteBuffer.getLong(), byteBuffer.getLong());
            this.c += 16;
        }

        private void a(long j, long j2) {
            this.f2906a ^= c(j);
            this.f2906a = Long.rotateLeft(this.f2906a, 27);
            this.f2906a += this.b;
            this.f2906a = (this.f2906a * 5) + 1390208809;
            this.b ^= d(j2);
            this.b = Long.rotateLeft(this.b, 31);
            this.b += this.f2906a;
            this.b = (this.b * 5) + 944331445;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x001b. Please report as an issue. */
        @Override // com.google.common.hash.AbstractStreamingHashFunction.AbstractStreamingHasher
        protected void b(ByteBuffer byteBuffer) {
            long a2;
            long j = 0;
            long j2 = 0;
            this.c += byteBuffer.remaining();
            switch (byteBuffer.remaining()) {
                case 1:
                    a2 = j ^ UnsignedBytes.a(byteBuffer.get(0));
                    this.f2906a = c(a2) ^ this.f2906a;
                    this.b = d(j2) ^ this.b;
                    return;
                case 2:
                    j ^= UnsignedBytes.a(byteBuffer.get(1)) << 8;
                    a2 = j ^ UnsignedBytes.a(byteBuffer.get(0));
                    this.f2906a = c(a2) ^ this.f2906a;
                    this.b = d(j2) ^ this.b;
                    return;
                case 3:
                    j ^= UnsignedBytes.a(byteBuffer.get(2)) << 16;
                    j ^= UnsignedBytes.a(byteBuffer.get(1)) << 8;
                    a2 = j ^ UnsignedBytes.a(byteBuffer.get(0));
                    this.f2906a = c(a2) ^ this.f2906a;
                    this.b = d(j2) ^ this.b;
                    return;
                case 4:
                    j ^= UnsignedBytes.a(byteBuffer.get(3)) << 24;
                    j ^= UnsignedBytes.a(byteBuffer.get(2)) << 16;
                    j ^= UnsignedBytes.a(byteBuffer.get(1)) << 8;
                    a2 = j ^ UnsignedBytes.a(byteBuffer.get(0));
                    this.f2906a = c(a2) ^ this.f2906a;
                    this.b = d(j2) ^ this.b;
                    return;
                case 5:
                    j ^= UnsignedBytes.a(byteBuffer.get(4)) << 32;
                    j ^= UnsignedBytes.a(byteBuffer.get(3)) << 24;
                    j ^= UnsignedBytes.a(byteBuffer.get(2)) << 16;
                    j ^= UnsignedBytes.a(byteBuffer.get(1)) << 8;
                    a2 = j ^ UnsignedBytes.a(byteBuffer.get(0));
                    this.f2906a = c(a2) ^ this.f2906a;
                    this.b = d(j2) ^ this.b;
                    return;
                case 6:
                    j ^= UnsignedBytes.a(byteBuffer.get(5)) << 40;
                    j ^= UnsignedBytes.a(byteBuffer.get(4)) << 32;
                    j ^= UnsignedBytes.a(byteBuffer.get(3)) << 24;
                    j ^= UnsignedBytes.a(byteBuffer.get(2)) << 16;
                    j ^= UnsignedBytes.a(byteBuffer.get(1)) << 8;
                    a2 = j ^ UnsignedBytes.a(byteBuffer.get(0));
                    this.f2906a = c(a2) ^ this.f2906a;
                    this.b = d(j2) ^ this.b;
                    return;
                case 7:
                    j = 0 ^ (UnsignedBytes.a(byteBuffer.get(6)) << 48);
                    j ^= UnsignedBytes.a(byteBuffer.get(5)) << 40;
                    j ^= UnsignedBytes.a(byteBuffer.get(4)) << 32;
                    j ^= UnsignedBytes.a(byteBuffer.get(3)) << 24;
                    j ^= UnsignedBytes.a(byteBuffer.get(2)) << 16;
                    j ^= UnsignedBytes.a(byteBuffer.get(1)) << 8;
                    a2 = j ^ UnsignedBytes.a(byteBuffer.get(0));
                    this.f2906a = c(a2) ^ this.f2906a;
                    this.b = d(j2) ^ this.b;
                    return;
                case 8:
                    a2 = 0 ^ byteBuffer.getLong();
                    this.f2906a = c(a2) ^ this.f2906a;
                    this.b = d(j2) ^ this.b;
                    return;
                case 9:
                    j2 ^= UnsignedBytes.a(byteBuffer.get(8));
                    a2 = 0 ^ byteBuffer.getLong();
                    this.f2906a = c(a2) ^ this.f2906a;
                    this.b = d(j2) ^ this.b;
                    return;
                case 10:
                    j2 ^= UnsignedBytes.a(byteBuffer.get(9)) << 8;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(8));
                    a2 = 0 ^ byteBuffer.getLong();
                    this.f2906a = c(a2) ^ this.f2906a;
                    this.b = d(j2) ^ this.b;
                    return;
                case 11:
                    j2 ^= UnsignedBytes.a(byteBuffer.get(10)) << 16;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(9)) << 8;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(8));
                    a2 = 0 ^ byteBuffer.getLong();
                    this.f2906a = c(a2) ^ this.f2906a;
                    this.b = d(j2) ^ this.b;
                    return;
                case 12:
                    j2 ^= UnsignedBytes.a(byteBuffer.get(11)) << 24;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(10)) << 16;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(9)) << 8;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(8));
                    a2 = 0 ^ byteBuffer.getLong();
                    this.f2906a = c(a2) ^ this.f2906a;
                    this.b = d(j2) ^ this.b;
                    return;
                case 13:
                    j2 ^= UnsignedBytes.a(byteBuffer.get(12)) << 32;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(11)) << 24;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(10)) << 16;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(9)) << 8;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(8));
                    a2 = 0 ^ byteBuffer.getLong();
                    this.f2906a = c(a2) ^ this.f2906a;
                    this.b = d(j2) ^ this.b;
                    return;
                case 14:
                    j2 ^= UnsignedBytes.a(byteBuffer.get(13)) << 40;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(12)) << 32;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(11)) << 24;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(10)) << 16;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(9)) << 8;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(8));
                    a2 = 0 ^ byteBuffer.getLong();
                    this.f2906a = c(a2) ^ this.f2906a;
                    this.b = d(j2) ^ this.b;
                    return;
                case 15:
                    j2 = 0 ^ (UnsignedBytes.a(byteBuffer.get(14)) << 48);
                    j2 ^= UnsignedBytes.a(byteBuffer.get(13)) << 40;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(12)) << 32;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(11)) << 24;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(10)) << 16;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(9)) << 8;
                    j2 ^= UnsignedBytes.a(byteBuffer.get(8));
                    a2 = 0 ^ byteBuffer.getLong();
                    this.f2906a = c(a2) ^ this.f2906a;
                    this.b = d(j2) ^ this.b;
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }

        @Override // com.google.common.hash.AbstractStreamingHashFunction.AbstractStreamingHasher
        public HashCode b() {
            this.f2906a ^= this.c;
            this.b ^= this.c;
            this.f2906a += this.b;
            this.b += this.f2906a;
            this.f2906a = b(this.f2906a);
            this.b = b(this.b);
            this.f2906a += this.b;
            this.b += this.f2906a;
            return HashCodes.a(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f2906a).putLong(this.b).array());
        }

        private static long b(long j) {
            long j2 = ((j >>> 33) ^ j) * (-49064778989728563L);
            long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
            return j3 ^ (j3 >>> 33);
        }

        private static long c(long j) {
            return Long.rotateLeft((-8663945395140668459L) * j, 31) * 5545529020109919103L;
        }

        private static long d(long j) {
            return Long.rotateLeft(5545529020109919103L * j, 33) * (-8663945395140668459L);
        }
    }
}
