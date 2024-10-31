package com.google.common.hash;

import com.google.common.annotations.Beta;
import java.io.Serializable;

@Beta
/* loaded from: classes2.dex */
public final class HashCodes {
    private HashCodes() {
    }

    public static HashCode a(int i) {
        return new IntHashCode(i);
    }

    /* loaded from: classes2.dex */
    private static final class IntHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final int hash;

        IntHashCode(int i) {
            this.hash = i;
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 32;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            return new byte[]{(byte) this.hash, (byte) (this.hash >> 8), (byte) (this.hash >> 16), (byte) (this.hash >> 24)};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HashCode a(byte[] bArr) {
        return new BytesHashCode(bArr);
    }

    /* loaded from: classes2.dex */
    private static final class BytesHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final byte[] bytes;

        BytesHashCode(byte[] bArr) {
            this.bytes = bArr;
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return this.bytes.length * 8;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            return (byte[]) this.bytes.clone();
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return (this.bytes[0] & 255) | ((this.bytes[1] & 255) << 8) | ((this.bytes[2] & 255) << 16) | ((this.bytes[3] & 255) << 24);
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            if (this.bytes.length < 8) {
                throw new IllegalStateException("Not enough bytes");
            }
            return (this.bytes[0] & 255) | ((this.bytes[1] & 255) << 8) | ((this.bytes[2] & 255) << 16) | ((this.bytes[3] & 255) << 24) | ((this.bytes[4] & 255) << 32) | ((this.bytes[5] & 255) << 40) | ((this.bytes[6] & 255) << 48) | ((this.bytes[7] & 255) << 56);
        }
    }
}
