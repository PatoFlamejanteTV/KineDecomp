package com.google.common.hash;

import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Murmur3_32HashFunction extends AbstractStreamingHashFunction implements Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Murmur3_32HashFunction(int i) {
        this.seed = i;
    }

    public int bits() {
        return 32;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new a(this.seed);
    }

    @Override // com.google.common.hash.AbstractStreamingHashFunction
    public HashCode hashInt(int i) {
        return b(a(this.seed, a(i)), 4);
    }

    @Override // com.google.common.hash.AbstractStreamingHashFunction
    public HashCode hashLong(long j) {
        int i = (int) (j >>> 32);
        return b(a(a(this.seed, a((int) j)), a(i)), 8);
    }

    @Override // com.google.common.hash.AbstractStreamingHashFunction
    public HashCode hashString(CharSequence charSequence) {
        int i = this.seed;
        for (int i2 = 1; i2 < charSequence.length(); i2 += 2) {
            i = a(i, a(charSequence.charAt(i2 - 1) | (charSequence.charAt(i2) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            i ^= a(charSequence.charAt(charSequence.length() - 1));
        }
        return b(i, charSequence.length() * 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(int i) {
        return Integer.rotateLeft((-862048943) * i, 15) * 461845907;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(int i, int i2) {
        return (Integer.rotateLeft(i ^ i2, 13) * 5) - 430675100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashCode b(int i, int i2) {
        int i3 = i ^ i2;
        int i4 = (i3 ^ (i3 >>> 16)) * (-2048144789);
        int i5 = (i4 ^ (i4 >>> 13)) * (-1028477387);
        return HashCodes.a(i5 ^ (i5 >>> 16));
    }

    /* loaded from: classes2.dex */
    private static final class a extends AbstractStreamingHashFunction.AbstractStreamingHasher {

        /* renamed from: a, reason: collision with root package name */
        private int f2907a;
        private int b;

        a(int i) {
            super(4);
            this.f2907a = i;
            this.b = 0;
        }

        @Override // com.google.common.hash.AbstractStreamingHashFunction.AbstractStreamingHasher
        protected void a(ByteBuffer byteBuffer) {
            this.f2907a = Murmur3_32HashFunction.a(this.f2907a, Murmur3_32HashFunction.a(byteBuffer.getInt()));
            this.b += 4;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000e. Please report as an issue. */
        @Override // com.google.common.hash.AbstractStreamingHashFunction.AbstractStreamingHasher
        protected void b(ByteBuffer byteBuffer) {
            int i;
            int i2;
            this.b += byteBuffer.remaining();
            switch (byteBuffer.remaining()) {
                case 1:
                    i = 0;
                    this.f2907a = Murmur3_32HashFunction.a(i ^ UnsignedBytes.a(byteBuffer.get(0))) ^ this.f2907a;
                    return;
                case 2:
                    i2 = 0;
                    i = i2 ^ (UnsignedBytes.a(byteBuffer.get(1)) << 8);
                    this.f2907a = Murmur3_32HashFunction.a(i ^ UnsignedBytes.a(byteBuffer.get(0))) ^ this.f2907a;
                    return;
                case 3:
                    i2 = (UnsignedBytes.a(byteBuffer.get(2)) << 16) ^ 0;
                    i = i2 ^ (UnsignedBytes.a(byteBuffer.get(1)) << 8);
                    this.f2907a = Murmur3_32HashFunction.a(i ^ UnsignedBytes.a(byteBuffer.get(0))) ^ this.f2907a;
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }

        @Override // com.google.common.hash.AbstractStreamingHashFunction.AbstractStreamingHasher
        public HashCode b() {
            return Murmur3_32HashFunction.b(this.f2907a, this.b);
        }
    }
}
