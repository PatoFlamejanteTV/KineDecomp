package com.google.protobuf;

import com.google.protobuf.Utf8;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class CodedOutputStream extends ByteOutput {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f18406a = Logger.getLogger(CodedOutputStream.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f18407b = ia.b();

    /* renamed from: c, reason: collision with root package name */
    private static final long f18408c = ia.a();

    /* loaded from: classes2.dex */
    public static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        OutOfSpaceException(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class a extends CodedOutputStream {

        /* renamed from: d, reason: collision with root package name */
        final byte[] f18409d;

        /* renamed from: e, reason: collision with root package name */
        final int f18410e;

        /* renamed from: f, reason: collision with root package name */
        int f18411f;

        /* renamed from: g, reason: collision with root package name */
        int f18412g;

        a(int i) {
            super();
            if (i >= 0) {
                this.f18409d = new byte[Math.max(i, 20)];
                this.f18410e = this.f18409d.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        final void b(byte b2) {
            byte[] bArr = this.f18409d;
            int i = this.f18411f;
            this.f18411f = i + 1;
            bArr[i] = b2;
            this.f18412g++;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int e() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        final void j(int i, int i2) {
            u(WireFormat.a(i, i2));
        }

        final void l(long j) {
            byte[] bArr = this.f18409d;
            int i = this.f18411f;
            this.f18411f = i + 1;
            bArr[i] = (byte) (j & 255);
            int i2 = this.f18411f;
            this.f18411f = i2 + 1;
            bArr[i2] = (byte) ((j >> 8) & 255);
            int i3 = this.f18411f;
            this.f18411f = i3 + 1;
            bArr[i3] = (byte) ((j >> 16) & 255);
            int i4 = this.f18411f;
            this.f18411f = i4 + 1;
            bArr[i4] = (byte) (255 & (j >> 24));
            int i5 = this.f18411f;
            this.f18411f = i5 + 1;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i6 = this.f18411f;
            this.f18411f = i6 + 1;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i7 = this.f18411f;
            this.f18411f = i7 + 1;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            int i8 = this.f18411f;
            this.f18411f = i8 + 1;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
            this.f18412g += 8;
        }

        final void m(long j) {
            if (CodedOutputStream.f18407b) {
                long j2 = CodedOutputStream.f18408c + this.f18411f;
                long j3 = j;
                long j4 = j2;
                while ((j3 & (-128)) != 0) {
                    ia.a(this.f18409d, j4, (byte) ((((int) j3) & 127) | 128));
                    j3 >>>= 7;
                    j4++;
                }
                ia.a(this.f18409d, j4, (byte) j3);
                int i = (int) ((1 + j4) - j2);
                this.f18411f += i;
                this.f18412g += i;
                return;
            }
            long j5 = j;
            while ((j5 & (-128)) != 0) {
                byte[] bArr = this.f18409d;
                int i2 = this.f18411f;
                this.f18411f = i2 + 1;
                bArr[i2] = (byte) ((((int) j5) & 127) | 128);
                this.f18412g++;
                j5 >>>= 7;
            }
            byte[] bArr2 = this.f18409d;
            int i3 = this.f18411f;
            this.f18411f = i3 + 1;
            bArr2[i3] = (byte) j5;
            this.f18412g++;
        }

        final void s(int i) {
            byte[] bArr = this.f18409d;
            int i2 = this.f18411f;
            this.f18411f = i2 + 1;
            bArr[i2] = (byte) (i & 255);
            int i3 = this.f18411f;
            this.f18411f = i3 + 1;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i4 = this.f18411f;
            this.f18411f = i4 + 1;
            bArr[i4] = (byte) ((i >> 16) & 255);
            int i5 = this.f18411f;
            this.f18411f = i5 + 1;
            bArr[i5] = (byte) ((i >> 24) & 255);
            this.f18412g += 4;
        }

        final void t(int i) {
            if (i >= 0) {
                u(i);
            } else {
                m(i);
            }
        }

        final void u(int i) {
            if (CodedOutputStream.f18407b) {
                long j = CodedOutputStream.f18408c + this.f18411f;
                long j2 = j;
                while ((i & (-128)) != 0) {
                    ia.a(this.f18409d, j2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                    j2 = 1 + j2;
                }
                ia.a(this.f18409d, j2, (byte) i);
                int i2 = (int) ((1 + j2) - j);
                this.f18411f += i2;
                this.f18412g += i2;
                return;
            }
            while ((i & (-128)) != 0) {
                byte[] bArr = this.f18409d;
                int i3 = this.f18411f;
                this.f18411f = i3 + 1;
                bArr[i3] = (byte) ((i & 127) | 128);
                this.f18412g++;
                i >>>= 7;
            }
            byte[] bArr2 = this.f18409d;
            int i4 = this.f18411f;
            this.f18411f = i4 + 1;
            bArr2[i4] = (byte) i;
            this.f18412g++;
        }
    }

    public static int a(double d2) {
        return 8;
    }

    public static int a(float f2) {
        return 4;
    }

    public static int a(long j) {
        return 8;
    }

    public static int a(boolean z) {
        return 1;
    }

    public static int b(int i) {
        return 4;
    }

    public static int c(long j) {
        return 8;
    }

    public static int d(int i, int i2) {
        return i(i) + j(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int e(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    @Deprecated
    public static int f(int i) {
        return j(i);
    }

    public static long f(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int g(int i) {
        return 4;
    }

    public static int j(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int k(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract void a(byte b2) throws IOException;

    public abstract void b(int i, ByteString byteString) throws IOException;

    public abstract void b(int i, String str) throws IOException;

    public abstract void b(int i, boolean z) throws IOException;

    public abstract void b(ByteString byteString) throws IOException;

    public abstract void b(String str) throws IOException;

    public abstract void c(int i, MessageLite messageLite) throws IOException;

    public final void c(byte[] bArr) throws IOException {
        c(bArr, 0, bArr.length);
    }

    abstract void c(byte[] bArr, int i, int i2) throws IOException;

    public abstract void d() throws IOException;

    public abstract void d(int i, long j) throws IOException;

    public abstract void d(int i, MessageLite messageLite) throws IOException;

    public abstract void d(MessageLite messageLite) throws IOException;

    public abstract int e();

    public final void e(int i, long j) throws IOException {
        f(i, j);
    }

    public abstract void f(int i, int i2) throws IOException;

    public abstract void f(int i, long j) throws IOException;

    public abstract void g(int i, int i2) throws IOException;

    public abstract void g(long j) throws IOException;

    public abstract void h(int i, int i2) throws IOException;

    public final void h(long j) throws IOException {
        k(j);
    }

    public abstract void i(int i, int i2) throws IOException;

    public final void i(long j) throws IOException {
        g(j);
    }

    public final void j(long j) throws IOException {
        k(f(j));
    }

    public abstract void k(long j) throws IOException;

    public final void l(int i) throws IOException {
        n(i);
    }

    public abstract void m(int i) throws IOException;

    public abstract void n(int i) throws IOException;

    @Deprecated
    public final void o(int i) throws IOException {
        r(i);
    }

    public final void p(int i) throws IOException {
        m(i);
    }

    public final void q(int i) throws IOException {
        r(k(i));
    }

    public abstract void r(int i) throws IOException;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b extends CodedOutputStream {

        /* renamed from: d, reason: collision with root package name */
        private final byte[] f18413d;

        /* renamed from: e, reason: collision with root package name */
        private final int f18414e;

        /* renamed from: f, reason: collision with root package name */
        private final int f18415f;

        /* renamed from: g, reason: collision with root package name */
        private int f18416g;

        b(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.f18413d = bArr;
                    this.f18414e = i;
                    this.f18416g = i;
                    this.f18415f = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            throw new NullPointerException("buffer");
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void a(byte b2) throws IOException {
            try {
                byte[] bArr = this.f18413d;
                int i = this.f18416g;
                this.f18416g = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f18416g), Integer.valueOf(this.f18415f), 1), e2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void b(int i, boolean z) throws IOException {
            h(i, 0);
            a(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void c(byte[] bArr, int i, int i2) throws IOException {
            r(i2);
            d(bArr, i, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void d() {
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void d(int i, long j) throws IOException {
            h(i, 1);
            g(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int e() {
            return this.f18415f - this.f18416g;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void f(int i, int i2) throws IOException {
            h(i, 5);
            m(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void g(int i, int i2) throws IOException {
            h(i, 0);
            n(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void h(int i, int i2) throws IOException {
            r(WireFormat.a(i, i2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void i(int i, int i2) throws IOException {
            h(i, 0);
            r(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void k(long j) throws IOException {
            if (CodedOutputStream.f18407b && e() >= 10) {
                long j2 = CodedOutputStream.f18408c + this.f18416g;
                while ((j & (-128)) != 0) {
                    ia.a(this.f18413d, j2, (byte) ((((int) j) & 127) | 128));
                    this.f18416g++;
                    j >>>= 7;
                    j2 = 1 + j2;
                }
                ia.a(this.f18413d, j2, (byte) j);
                this.f18416g++;
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr = this.f18413d;
                    int i = this.f18416g;
                    this.f18416g = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f18416g), Integer.valueOf(this.f18415f), 1), e2);
                }
            }
            byte[] bArr2 = this.f18413d;
            int i2 = this.f18416g;
            this.f18416g = i2 + 1;
            bArr2[i2] = (byte) j;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void m(int i) throws IOException {
            try {
                byte[] bArr = this.f18413d;
                int i2 = this.f18416g;
                this.f18416g = i2 + 1;
                bArr[i2] = (byte) (i & 255);
                byte[] bArr2 = this.f18413d;
                int i3 = this.f18416g;
                this.f18416g = i3 + 1;
                bArr2[i3] = (byte) ((i >> 8) & 255);
                byte[] bArr3 = this.f18413d;
                int i4 = this.f18416g;
                this.f18416g = i4 + 1;
                bArr3[i4] = (byte) ((i >> 16) & 255);
                byte[] bArr4 = this.f18413d;
                int i5 = this.f18416g;
                this.f18416g = i5 + 1;
                bArr4[i5] = (byte) ((i >> 24) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f18416g), Integer.valueOf(this.f18415f), 1), e2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void n(int i) throws IOException {
            if (i >= 0) {
                r(i);
            } else {
                k(i);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void r(int i) throws IOException {
            if (CodedOutputStream.f18407b && e() >= 10) {
                long j = CodedOutputStream.f18408c + this.f18416g;
                while ((i & (-128)) != 0) {
                    ia.a(this.f18413d, j, (byte) ((i & 127) | 128));
                    this.f18416g++;
                    i >>>= 7;
                    j = 1 + j;
                }
                ia.a(this.f18413d, j, (byte) i);
                this.f18416g++;
                return;
            }
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr = this.f18413d;
                    int i2 = this.f18416g;
                    this.f18416g = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f18416g), Integer.valueOf(this.f18415f), 1), e2);
                }
            }
            byte[] bArr2 = this.f18413d;
            int i3 = this.f18416g;
            this.f18416g = i3 + 1;
            bArr2[i3] = (byte) i;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void b(int i, String str) throws IOException {
            h(i, 2);
            b(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void c(int i, MessageLite messageLite) throws IOException {
            h(i, 2);
            d(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void d(int i, MessageLite messageLite) throws IOException {
            h(1, 3);
            i(2, i);
            c(3, messageLite);
            h(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void f(int i, long j) throws IOException {
            h(i, 0);
            k(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void g(long j) throws IOException {
            try {
                byte[] bArr = this.f18413d;
                int i = this.f18416g;
                this.f18416g = i + 1;
                bArr[i] = (byte) (((int) j) & 255);
                byte[] bArr2 = this.f18413d;
                int i2 = this.f18416g;
                this.f18416g = i2 + 1;
                bArr2[i2] = (byte) (((int) (j >> 8)) & 255);
                byte[] bArr3 = this.f18413d;
                int i3 = this.f18416g;
                this.f18416g = i3 + 1;
                bArr3[i3] = (byte) (((int) (j >> 16)) & 255);
                byte[] bArr4 = this.f18413d;
                int i4 = this.f18416g;
                this.f18416g = i4 + 1;
                bArr4[i4] = (byte) (((int) (j >> 24)) & 255);
                byte[] bArr5 = this.f18413d;
                int i5 = this.f18416g;
                this.f18416g = i5 + 1;
                bArr5[i5] = (byte) (((int) (j >> 32)) & 255);
                byte[] bArr6 = this.f18413d;
                int i6 = this.f18416g;
                this.f18416g = i6 + 1;
                bArr6[i6] = (byte) (((int) (j >> 40)) & 255);
                byte[] bArr7 = this.f18413d;
                int i7 = this.f18416g;
                this.f18416g = i7 + 1;
                bArr7[i7] = (byte) (((int) (j >> 48)) & 255);
                byte[] bArr8 = this.f18413d;
                int i8 = this.f18416g;
                this.f18416g = i8 + 1;
                bArr8[i8] = (byte) (((int) (j >> 56)) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f18416g), Integer.valueOf(this.f18415f), 1), e2);
            }
        }

        @Override // com.google.protobuf.ByteOutput
        public final void a(byte[] bArr, int i, int i2) throws IOException {
            d(bArr, i, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void b(int i, ByteString byteString) throws IOException {
            h(i, 2);
            b(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void b(ByteString byteString) throws IOException {
            r(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void d(MessageLite messageLite) throws IOException {
            r(messageLite.d());
            messageLite.a(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void b(String str) throws IOException {
            int i = this.f18416g;
            try {
                int j = CodedOutputStream.j(str.length() * 3);
                int j2 = CodedOutputStream.j(str.length());
                if (j2 == j) {
                    this.f18416g = i + j2;
                    int a2 = Utf8.a(str, this.f18413d, this.f18416g, e());
                    this.f18416g = i;
                    r((a2 - i) - j2);
                    this.f18416g = a2;
                } else {
                    r(Utf8.a(str));
                    this.f18416g = Utf8.a(str, this.f18413d, this.f18416g, e());
                }
            } catch (Utf8.UnpairedSurrogateException e2) {
                this.f18416g = i;
                a(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        public final void d(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.f18413d, this.f18416g, i2);
                this.f18416g += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f18416g), Integer.valueOf(this.f18415f), Integer.valueOf(i2)), e2);
            }
        }
    }

    /* loaded from: classes2.dex */
    private static final class c extends a {

        /* renamed from: h, reason: collision with root package name */
        private final OutputStream f18417h;

        c(OutputStream outputStream, int i) {
            super(i);
            if (outputStream != null) {
                this.f18417h = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        private void v(int i) throws IOException {
            if (this.f18410e - this.f18411f < i) {
                f();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void a(byte b2) throws IOException {
            if (this.f18411f == this.f18410e) {
                f();
            }
            b(b2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void b(int i, boolean z) throws IOException {
            v(11);
            j(i, 0);
            b(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void c(byte[] bArr, int i, int i2) throws IOException {
            r(i2);
            d(bArr, i, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void d(int i, long j) throws IOException {
            v(18);
            j(i, 1);
            l(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void f(int i, int i2) throws IOException {
            v(14);
            j(i, 5);
            s(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void g(int i, int i2) throws IOException {
            v(20);
            j(i, 0);
            t(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void h(int i, int i2) throws IOException {
            r(WireFormat.a(i, i2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void i(int i, int i2) throws IOException {
            v(20);
            j(i, 0);
            u(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void k(long j) throws IOException {
            v(10);
            m(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void m(int i) throws IOException {
            v(4);
            s(i);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void n(int i) throws IOException {
            if (i >= 0) {
                r(i);
            } else {
                k(i);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void r(int i) throws IOException {
            v(10);
            u(i);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void c(int i, MessageLite messageLite) throws IOException {
            h(i, 2);
            d(messageLite);
        }

        @Override // com.google.protobuf.ByteOutput
        public void a(byte[] bArr, int i, int i2) throws IOException {
            d(bArr, i, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void b(int i, String str) throws IOException {
            h(i, 2);
            b(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void d(int i, MessageLite messageLite) throws IOException {
            h(1, 3);
            i(2, i);
            c(3, messageLite);
            h(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void f(int i, long j) throws IOException {
            v(20);
            j(i, 0);
            m(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void g(long j) throws IOException {
            v(8);
            l(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void b(int i, ByteString byteString) throws IOException {
            h(i, 2);
            b(byteString);
        }

        private void f() throws IOException {
            this.f18417h.write(this.f18409d, 0, this.f18411f);
            this.f18411f = 0;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void b(ByteString byteString) throws IOException {
            r(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void d(MessageLite messageLite) throws IOException {
            r(messageLite.d());
            messageLite.a(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void b(String str) throws IOException {
            int a2;
            try {
                int length = str.length() * 3;
                int j = CodedOutputStream.j(length);
                int i = j + length;
                if (i > this.f18410e) {
                    byte[] bArr = new byte[length];
                    int a3 = Utf8.a(str, bArr, 0, length);
                    r(a3);
                    a(bArr, 0, a3);
                    return;
                }
                if (i > this.f18410e - this.f18411f) {
                    f();
                }
                int j2 = CodedOutputStream.j(str.length());
                int i2 = this.f18411f;
                try {
                    if (j2 == j) {
                        this.f18411f = i2 + j2;
                        int a4 = Utf8.a(str, this.f18409d, this.f18411f, this.f18410e - this.f18411f);
                        this.f18411f = i2;
                        a2 = (a4 - i2) - j2;
                        u(a2);
                        this.f18411f = a4;
                    } else {
                        a2 = Utf8.a(str);
                        u(a2);
                        this.f18411f = Utf8.a(str, this.f18409d, this.f18411f, a2);
                    }
                    this.f18412g += a2;
                } catch (Utf8.UnpairedSurrogateException e2) {
                    this.f18412g -= this.f18411f - i2;
                    this.f18411f = i2;
                    throw e2;
                } catch (ArrayIndexOutOfBoundsException e3) {
                    throw new OutOfSpaceException(e3);
                }
            } catch (Utf8.UnpairedSurrogateException e4) {
                a(str, e4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void d() throws IOException {
            if (this.f18411f > 0) {
                f();
            }
        }

        public void d(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.f18410e;
            int i4 = this.f18411f;
            if (i3 - i4 >= i2) {
                System.arraycopy(bArr, i, this.f18409d, i4, i2);
                this.f18411f += i2;
                this.f18412g += i2;
                return;
            }
            int i5 = i3 - i4;
            System.arraycopy(bArr, i, this.f18409d, i4, i5);
            int i6 = i + i5;
            int i7 = i2 - i5;
            this.f18411f = this.f18410e;
            this.f18412g += i5;
            f();
            if (i7 <= this.f18410e) {
                System.arraycopy(bArr, i6, this.f18409d, 0, i7);
                this.f18411f = i7;
            } else {
                this.f18417h.write(bArr, i6, i7);
            }
            this.f18412g += i7;
        }
    }

    private CodedOutputStream() {
    }

    public static CodedOutputStream a(OutputStream outputStream, int i) {
        return new c(outputStream, i);
    }

    public static CodedOutputStream b(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }

    public static int c(int i, int i2) {
        return i(i) + c(i2);
    }

    public static int d(long j) {
        return e(f(j));
    }

    public static int h(int i) {
        return j(k(i));
    }

    public static int i(int i) {
        return j(WireFormat.a(i, 0));
    }

    public final void e(int i, int i2) throws IOException {
        g(i, i2);
    }

    public static int a(int i, long j) {
        return i(i) + a(j);
    }

    public static CodedOutputStream b(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    public static int c(int i, long j) {
        return i(i) + e(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i) {
        return j(i) + i;
    }

    public static int a(int i, float f2) {
        return i(i) + a(f2);
    }

    public static int c(int i) {
        if (i >= 0) {
            return j(i);
        }
        return 10;
    }

    public final void b(int i, float f2) throws IOException {
        f(i, Float.floatToRawIntBits(f2));
    }

    public static int a(int i, double d2) {
        return i(i) + a(d2);
    }

    public final void b(int i, double d2) throws IOException {
        d(i, Double.doubleToRawLongBits(d2));
    }

    public final void c() {
        if (e() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public static int a(int i, boolean z) {
        return i(i) + a(z);
    }

    public final void b(float f2) throws IOException {
        m(Float.floatToRawIntBits(f2));
    }

    public static int a(int i, int i2) {
        return i(i) + a(i2);
    }

    public final void b(double d2) throws IOException {
        g(Double.doubleToRawLongBits(d2));
    }

    @Deprecated
    public final void c(MessageLite messageLite) throws IOException {
        messageLite.a(this);
    }

    public static int a(int i, String str) {
        return i(i) + a(str);
    }

    public final void b(boolean z) throws IOException {
        a(z ? (byte) 1 : (byte) 0);
    }

    public static int a(int i, ByteString byteString) {
        return i(i) + a(byteString);
    }

    public static int b(int i, int i2) {
        return i(i) + b(i2);
    }

    public static int a(int i, MessageLite messageLite) {
        return i(i) + b(messageLite);
    }

    public static int b(int i, long j) {
        return i(i) + b(j);
    }

    public static int a(int i) {
        return c(i);
    }

    public static int b(long j) {
        return e(j);
    }

    public static int a(String str) {
        int length;
        try {
            length = Utf8.a(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(Internal.f18617a).length;
        }
        return d(length);
    }

    public static int b(MessageLite messageLite) {
        return d(messageLite.d());
    }

    @Deprecated
    public final void b(int i, MessageLite messageLite) throws IOException {
        h(i, 3);
        c(messageLite);
        h(i, 4);
    }

    public static int a(LazyFieldLite lazyFieldLite) {
        return d(lazyFieldLite.a());
    }

    public static int a(ByteString byteString) {
        return d(byteString.size());
    }

    public static int a(byte[] bArr) {
        return d(bArr.length);
    }

    final void a(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        f18406a.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.f18617a);
        try {
            r(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (OutOfSpaceException e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new OutOfSpaceException(e3);
        }
    }

    @Deprecated
    public static int a(MessageLite messageLite) {
        return messageLite.d();
    }
}
