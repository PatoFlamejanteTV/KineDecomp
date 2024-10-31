package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MessageDigestHashFunction.java */
/* loaded from: classes2.dex */
final class b extends AbstractStreamingHashFunction {

    /* renamed from: a, reason: collision with root package name */
    private final String f2908a;
    private final int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str) {
        this.f2908a = str;
        this.b = a(str).getDigestLength() * 8;
    }

    private static MessageDigest a(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new a(a(this.f2908a));
    }

    /* compiled from: MessageDigestHashFunction.java */
    /* loaded from: classes2.dex */
    private static class a implements Hasher {

        /* renamed from: a, reason: collision with root package name */
        private final MessageDigest f2909a;
        private final ByteBuffer b;
        private boolean c;

        private a(MessageDigest messageDigest) {
            this.f2909a = messageDigest;
            this.b = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
        }

        @Override // com.google.common.hash.Hasher
        public Hasher a(byte[] bArr) {
            b();
            this.f2909a.update(bArr);
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public Hasher a(byte[] bArr, int i, int i2) {
            b();
            Preconditions.a(i, i + i2, bArr.length);
            this.f2909a.update(bArr, i, i2);
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public Hasher a(int i) {
            b();
            this.b.putInt(i);
            this.f2909a.update(this.b.array(), 0, 4);
            this.b.clear();
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public Hasher a(long j) {
            b();
            this.b.putLong(j);
            this.f2909a.update(this.b.array(), 0, 8);
            this.b.clear();
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public Hasher a(char c) {
            b();
            this.b.putChar(c);
            this.f2909a.update(this.b.array(), 0, 2);
            this.b.clear();
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public Hasher a(CharSequence charSequence) {
            for (int i = 0; i < charSequence.length(); i++) {
                a(charSequence.charAt(i));
            }
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public Hasher a(CharSequence charSequence, Charset charset) {
            ByteBuffer encode = charset.encode(CharBuffer.wrap(charSequence));
            if (encode.hasArray()) {
                return a(encode.array(), encode.arrayOffset() + encode.position(), encode.arrayOffset() + encode.limit());
            }
            byte[] bArr = new byte[encode.remaining()];
            encode.get(bArr);
            return a(bArr);
        }

        @Override // com.google.common.hash.Hasher
        public <T> Hasher a(T t, Funnel<? super T> funnel) {
            b();
            funnel.funnel(t, this);
            return this;
        }

        private void b() {
            Preconditions.b(!this.c, "Cannot use Hasher after calling #hash() on it");
        }

        @Override // com.google.common.hash.Hasher
        public HashCode a() {
            this.c = true;
            return HashCodes.a(this.f2909a.digest());
        }
    }
}
