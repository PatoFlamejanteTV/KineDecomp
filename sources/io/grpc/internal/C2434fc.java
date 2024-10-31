package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* compiled from: ReadableBuffers.java */
/* renamed from: io.grpc.internal.fc */
/* loaded from: classes3.dex */
public final class C2434fc {

    /* renamed from: a */
    private static final InterfaceC2426dc f27610a = new b(new byte[0]);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReadableBuffers.java */
    /* renamed from: io.grpc.internal.fc$b */
    /* loaded from: classes3.dex */
    public static class b extends AbstractC2423d {

        /* renamed from: a */
        int f27612a;

        /* renamed from: b */
        final int f27613b;

        /* renamed from: c */
        final byte[] f27614c;

        b(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // io.grpc.internal.InterfaceC2426dc
        public int B() {
            return this.f27613b - this.f27612a;
        }

        @Override // io.grpc.internal.InterfaceC2426dc
        public void a(byte[] bArr, int i, int i2) {
            System.arraycopy(this.f27614c, this.f27612a, bArr, i, i2);
            this.f27612a += i2;
        }

        @Override // io.grpc.internal.InterfaceC2426dc
        public int readUnsignedByte() {
            a(1);
            byte[] bArr = this.f27614c;
            int i = this.f27612a;
            this.f27612a = i + 1;
            return bArr[i] & 255;
        }

        b(byte[] bArr, int i, int i2) {
            Preconditions.a(i >= 0, "offset must be >= 0");
            Preconditions.a(i2 >= 0, "length must be >= 0");
            int i3 = i2 + i;
            Preconditions.a(i3 <= bArr.length, "offset + length exceeds array boundary");
            Preconditions.a(bArr, "bytes");
            this.f27614c = bArr;
            this.f27612a = i;
            this.f27613b = i3;
        }

        @Override // io.grpc.internal.InterfaceC2426dc
        public b g(int i) {
            a(i);
            int i2 = this.f27612a;
            this.f27612a = i2 + i;
            return new b(this.f27614c, i2, i);
        }
    }

    public static InterfaceC2426dc a(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    public static byte[] b(InterfaceC2426dc interfaceC2426dc) {
        Preconditions.a(interfaceC2426dc, "buffer");
        int B = interfaceC2426dc.B();
        byte[] bArr = new byte[B];
        interfaceC2426dc.a(bArr, 0, B);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReadableBuffers.java */
    /* renamed from: io.grpc.internal.fc$a */
    /* loaded from: classes3.dex */
    public static final class a extends InputStream implements io.grpc.I {

        /* renamed from: a */
        final InterfaceC2426dc f27611a;

        public a(InterfaceC2426dc interfaceC2426dc) {
            Preconditions.a(interfaceC2426dc, "buffer");
            this.f27611a = interfaceC2426dc;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f27611a.B();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f27611a.close();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f27611a.B() == 0) {
                return -1;
            }
            return this.f27611a.readUnsignedByte();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (this.f27611a.B() == 0) {
                return -1;
            }
            int min = Math.min(this.f27611a.B(), i2);
            this.f27611a.a(bArr, i, min);
            return min;
        }
    }

    public static String a(InterfaceC2426dc interfaceC2426dc, Charset charset) {
        Preconditions.a(charset, "charset");
        return new String(b(interfaceC2426dc), charset);
    }

    public static InputStream a(InterfaceC2426dc interfaceC2426dc, boolean z) {
        if (!z) {
            interfaceC2426dc = a(interfaceC2426dc);
        }
        return new a(interfaceC2426dc);
    }

    public static InterfaceC2426dc a(InterfaceC2426dc interfaceC2426dc) {
        return new C2430ec(interfaceC2426dc);
    }
}
