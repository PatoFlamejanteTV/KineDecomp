package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class AbstractStreamingHashFunction implements HashFunction {

    /* JADX INFO: Access modifiers changed from: protected */
    @CanIgnoreReturnValue
    /* loaded from: classes2.dex */
    public static abstract class AbstractStreamingHasher extends a {

        /* renamed from: a */
        private final ByteBuffer f15934a;

        /* renamed from: b */
        private final int f15935b;

        /* renamed from: c */
        private final int f15936c;

        public AbstractStreamingHasher(int i) {
            this(i, i);
        }

        private Hasher c(ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() <= this.f15934a.remaining()) {
                this.f15934a.put(byteBuffer);
                d();
                return this;
            }
            int position = this.f15935b - this.f15934a.position();
            for (int i = 0; i < position; i++) {
                this.f15934a.put(byteBuffer.get());
            }
            c();
            while (byteBuffer.remaining() >= this.f15936c) {
                a(byteBuffer);
            }
            this.f15934a.put(byteBuffer);
            return this;
        }

        private void d() {
            if (this.f15934a.remaining() < 8) {
                c();
            }
        }

        @Override // com.google.common.hash.Hasher
        public final Hasher a(byte[] bArr) {
            return a(bArr, 0, bArr.length);
        }

        protected abstract void a(ByteBuffer byteBuffer);

        abstract HashCode b();

        protected void b(ByteBuffer byteBuffer) {
            byteBuffer.position(byteBuffer.limit());
            byteBuffer.limit(this.f15936c + 7);
            while (true) {
                int position = byteBuffer.position();
                int i = this.f15936c;
                if (position < i) {
                    byteBuffer.putLong(0L);
                } else {
                    byteBuffer.limit(i);
                    byteBuffer.flip();
                    a(byteBuffer);
                    return;
                }
            }
        }

        protected AbstractStreamingHasher(int i, int i2) {
            Preconditions.a(i2 % i == 0);
            this.f15934a = ByteBuffer.allocate(i2 + 7).order(ByteOrder.LITTLE_ENDIAN);
            this.f15935b = i2;
            this.f15936c = i;
        }

        @Override // com.google.common.hash.Hasher
        public final Hasher a(byte[] bArr, int i, int i2) {
            c(ByteBuffer.wrap(bArr, i, i2).order(ByteOrder.LITTLE_ENDIAN));
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public final Hasher a(CharSequence charSequence) {
            for (int i = 0; i < charSequence.length(); i++) {
                a(charSequence.charAt(i));
            }
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public final Hasher a(byte b2) {
            this.f15934a.put(b2);
            d();
            return this;
        }

        public final Hasher a(char c2) {
            this.f15934a.putChar(c2);
            d();
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public final Hasher a(int i) {
            this.f15934a.putInt(i);
            d();
            return this;
        }

        private void c() {
            this.f15934a.flip();
            while (this.f15934a.remaining() >= this.f15936c) {
                a(this.f15934a);
            }
            this.f15934a.compact();
        }

        @Override // com.google.common.hash.Hasher
        public final Hasher a(long j) {
            this.f15934a.putLong(j);
            d();
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public final <T> Hasher a(T t, Funnel<? super T> funnel) {
            funnel.funnel(t, this);
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public final HashCode a() {
            c();
            this.f15934a.flip();
            if (this.f15934a.remaining() > 0) {
                b(this.f15934a);
            }
            return b();
        }
    }

    public HashCode hashBytes(byte[] bArr) {
        return newHasher().a(bArr).a();
    }

    public HashCode hashInt(int i) {
        return newHasher().a(i).a();
    }

    public HashCode hashLong(long j) {
        return newHasher().a(j).a();
    }

    @Override // com.google.common.hash.HashFunction
    public <T> HashCode hashObject(T t, Funnel<? super T> funnel) {
        return newHasher().a((Hasher) t, (Funnel<? super Hasher>) funnel).a();
    }

    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return newHasher().a(charSequence, charset).a();
    }

    public HashCode hashUnencodedChars(CharSequence charSequence) {
        return newHasher().a(charSequence).a();
    }

    public Hasher newHasher(int i) {
        Preconditions.a(i >= 0);
        return newHasher();
    }

    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        return newHasher().a(bArr, i, i2).a();
    }
}
