package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
abstract class AbstractStreamingHashFunction implements HashFunction {
    public HashCode hashString(CharSequence charSequence) {
        return newHasher().a(charSequence).a();
    }

    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return newHasher().a(charSequence, charset).a();
    }

    public HashCode hashInt(int i) {
        return newHasher().a(i).a();
    }

    public HashCode hashLong(long j) {
        return newHasher().a(j).a();
    }

    public HashCode hashBytes(byte[] bArr) {
        return newHasher().a(bArr).a();
    }

    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        return newHasher().a(bArr, i, i2).a();
    }

    public Hasher newHasher(int i) {
        Preconditions.a(i >= 0);
        return newHasher();
    }

    /* loaded from: classes2.dex */
    protected static abstract class AbstractStreamingHasher extends a {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f2901a;
        private final int b;
        private final int c;

        protected abstract void a(ByteBuffer byteBuffer);

        abstract HashCode b();

        /* JADX INFO: Access modifiers changed from: protected */
        public AbstractStreamingHasher(int i) {
            this(i, i);
        }

        protected AbstractStreamingHasher(int i, int i2) {
            Preconditions.a(i2 % i == 0);
            this.f2901a = ByteBuffer.allocate(i2 + 7).order(ByteOrder.LITTLE_ENDIAN);
            this.b = i2;
            this.c = i;
        }

        protected void b(ByteBuffer byteBuffer) {
            byteBuffer.position(byteBuffer.limit());
            byteBuffer.limit(this.c + 7);
            while (byteBuffer.position() < this.c) {
                byteBuffer.putLong(0L);
            }
            byteBuffer.limit(this.c);
            byteBuffer.flip();
            a(byteBuffer);
        }

        @Override // com.google.common.hash.Hasher
        public final Hasher a(byte[] bArr) {
            return a(bArr, 0, bArr.length);
        }

        @Override // com.google.common.hash.Hasher
        public final Hasher a(byte[] bArr, int i, int i2) {
            return c(ByteBuffer.wrap(bArr, i, i2).order(ByteOrder.LITTLE_ENDIAN));
        }

        private final Hasher c(ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() <= this.f2901a.remaining()) {
                this.f2901a.put(byteBuffer);
                c();
            } else {
                int position = this.b - this.f2901a.position();
                for (int i = 0; i < position; i++) {
                    this.f2901a.put(byteBuffer.get());
                }
                d();
                while (byteBuffer.remaining() >= this.c) {
                    a(byteBuffer);
                }
                this.f2901a.put(byteBuffer);
            }
            return this;
        }

        @Override // com.google.common.hash.a, com.google.common.hash.Hasher
        public final Hasher a(CharSequence charSequence) {
            for (int i = 0; i < charSequence.length(); i++) {
                a(charSequence.charAt(i));
            }
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public final Hasher a(char c) {
            this.f2901a.putChar(c);
            c();
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public final Hasher a(int i) {
            this.f2901a.putInt(i);
            c();
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public final Hasher a(long j) {
            this.f2901a.putLong(j);
            c();
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public final <T> Hasher a(T t, Funnel<? super T> funnel) {
            funnel.funnel(t, this);
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public final HashCode a() {
            d();
            this.f2901a.flip();
            if (this.f2901a.remaining() > 0) {
                b(this.f2901a);
            }
            return b();
        }

        private void c() {
            if (this.f2901a.remaining() < 8) {
                d();
            }
        }

        private void d() {
            this.f2901a.flip();
            while (this.f2901a.remaining() >= this.c) {
                a(this.f2901a);
            }
            this.f2901a.compact();
        }
    }
}
