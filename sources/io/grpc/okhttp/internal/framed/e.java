package io.grpc.okhttp.internal.framed;

import android.support.v7.widget.ActivityChooserView;
import io.grpc.okhttp.internal.framed.a;
import io.grpc.okhttp.internal.framed.d;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.B;
import okio.ByteString;
import okio.i;
import okio.z;

/* compiled from: Http2.java */
/* loaded from: classes3.dex */
public final class e implements h {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f27927a = Logger.getLogger(b.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final ByteString f27928b = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2.java */
    /* loaded from: classes3.dex */
    public static final class a implements z {

        /* renamed from: a, reason: collision with root package name */
        private final i f27929a;

        /* renamed from: b, reason: collision with root package name */
        int f27930b;

        /* renamed from: c, reason: collision with root package name */
        byte f27931c;

        /* renamed from: d, reason: collision with root package name */
        int f27932d;

        /* renamed from: e, reason: collision with root package name */
        int f27933e;

        /* renamed from: f, reason: collision with root package name */
        short f27934f;

        public a(i iVar) {
            this.f27929a = iVar;
        }

        private void a() throws IOException {
            int i = this.f27932d;
            int b2 = e.b(this.f27929a);
            this.f27933e = b2;
            this.f27930b = b2;
            byte readByte = (byte) (this.f27929a.readByte() & 255);
            this.f27931c = (byte) (this.f27929a.readByte() & 255);
            if (e.f27927a.isLoggable(Level.FINE)) {
                e.f27927a.fine(b.a(true, this.f27932d, this.f27930b, readByte, this.f27931c));
            }
            this.f27932d = this.f27929a.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (readByte == 9) {
                if (this.f27932d == i) {
                    return;
                }
                e.a("TYPE_CONTINUATION streamId changed", new Object[0]);
                throw null;
            }
            e.a("%s != TYPE_CONTINUATION", new Object[]{Byte.valueOf(readByte)});
            throw null;
        }

        @Override // okio.z
        public long b(okio.g gVar, long j) throws IOException {
            while (true) {
                int i = this.f27933e;
                if (i == 0) {
                    this.f27929a.skip(this.f27934f);
                    this.f27934f = (short) 0;
                    if ((this.f27931c & 4) != 0) {
                        return -1L;
                    }
                    a();
                } else {
                    long b2 = this.f27929a.b(gVar, Math.min(j, i));
                    if (b2 == -1) {
                        return -1L;
                    }
                    this.f27933e -= (int) b2;
                    return b2;
                }
            }
        }

        @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.z
        public B e() {
            return this.f27929a.e();
        }
    }

    private static IllegalArgumentException c(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    private static IOException d(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(str, objArr));
    }

    static /* synthetic */ IOException a(String str, Object[] objArr) throws IOException {
        d(str, objArr);
        throw null;
    }

    static /* synthetic */ IllegalArgumentException b(String str, Object[] objArr) {
        c(str, objArr);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2.java */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final String[] f27935a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        /* renamed from: b, reason: collision with root package name */
        private static final String[] f27936b = new String[64];

        /* renamed from: c, reason: collision with root package name */
        private static final String[] f27937c = new String[256];

        static {
            int i = 0;
            int i2 = 0;
            while (true) {
                String[] strArr = f27937c;
                if (i2 >= strArr.length) {
                    break;
                }
                strArr[i2] = String.format("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
                i2++;
            }
            String[] strArr2 = f27936b;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] iArr = {1};
            strArr2[8] = "PADDED";
            for (int i3 : iArr) {
                f27936b[i3 | 8] = f27936b[i3] + "|PADDED";
            }
            String[] strArr3 = f27936b;
            strArr3[4] = "END_HEADERS";
            strArr3[32] = "PRIORITY";
            strArr3[36] = "END_HEADERS|PRIORITY";
            for (int i4 : new int[]{4, 32, 36}) {
                for (int i5 : iArr) {
                    int i6 = i5 | i4;
                    f27936b[i6] = f27936b[i5] + '|' + f27936b[i4];
                    f27936b[i6 | 8] = f27936b[i5] + '|' + f27936b[i4] + "|PADDED";
                }
            }
            while (true) {
                String[] strArr4 = f27936b;
                if (i >= strArr4.length) {
                    return;
                }
                if (strArr4[i] == null) {
                    strArr4[i] = f27937c[i];
                }
                i++;
            }
        }

        b() {
        }

        static String a(boolean z, int i, int i2, byte b2, byte b3) {
            String[] strArr = f27935a;
            String format = b2 < strArr.length ? strArr[b2] : String.format("0x%02x", Byte.valueOf(b2));
            String a2 = a(b2, b3);
            Object[] objArr = new Object[5];
            objArr[0] = z ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = format;
            objArr[4] = a2;
            return String.format("%s 0x%08x %5d %-13s %s", objArr);
        }

        static String a(byte b2, byte b3) {
            if (b3 == 0) {
                return "";
            }
            if (b2 != 2 && b2 != 3) {
                if (b2 == 4 || b2 == 6) {
                    return b3 == 1 ? "ACK" : f27937c[b3];
                }
                if (b2 != 7 && b2 != 8) {
                    String[] strArr = f27936b;
                    String str = b3 < strArr.length ? strArr[b3] : f27937c[b3];
                    if (b2 != 5 || (b3 & 4) == 0) {
                        return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                    }
                    return str.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            return f27937c[b3];
        }
    }

    /* compiled from: Http2.java */
    /* loaded from: classes3.dex */
    static final class d implements io.grpc.okhttp.internal.framed.b {

        /* renamed from: a, reason: collision with root package name */
        private final okio.h f27942a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f27943b;

        /* renamed from: c, reason: collision with root package name */
        private final okio.g f27944c = new okio.g();

        /* renamed from: d, reason: collision with root package name */
        private final d.b f27945d = new d.b(this.f27944c);

        /* renamed from: e, reason: collision with root package name */
        private int f27946e = 16384;

        /* renamed from: f, reason: collision with root package name */
        private boolean f27947f;

        d(okio.h hVar, boolean z) {
            this.f27942a = hVar;
            this.f27943b = z;
        }

        private void b(int i, long j) throws IOException {
            while (j > 0) {
                int min = (int) Math.min(this.f27946e, j);
                long j2 = min;
                j -= j2;
                a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
                this.f27942a.a(this.f27944c, j2);
            }
        }

        @Override // io.grpc.okhttp.internal.framed.b
        public synchronized void a(g gVar) throws IOException {
            if (!this.f27947f) {
                this.f27946e = gVar.b(this.f27946e);
                a(0, 0, (byte) 4, (byte) 1);
                this.f27942a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            this.f27947f = true;
            this.f27942a.close();
        }

        @Override // io.grpc.okhttp.internal.framed.b
        public synchronized void flush() throws IOException {
            if (!this.f27947f) {
                this.f27942a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // io.grpc.okhttp.internal.framed.b
        public synchronized void q() throws IOException {
            if (!this.f27947f) {
                if (this.f27943b) {
                    if (e.f27927a.isLoggable(Level.FINE)) {
                        e.f27927a.fine(String.format(">> CONNECTION %s", e.f27928b.hex()));
                    }
                    this.f27942a.write(e.f27928b.toByteArray());
                    this.f27942a.flush();
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        @Override // io.grpc.okhttp.internal.framed.b
        public int t() {
            return this.f27946e;
        }

        @Override // io.grpc.okhttp.internal.framed.b
        public synchronized void b(g gVar) throws IOException {
            if (!this.f27947f) {
                int i = 0;
                a(0, gVar.b() * 6, (byte) 4, (byte) 0);
                while (i < 10) {
                    if (gVar.c(i)) {
                        this.f27942a.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                        this.f27942a.writeInt(gVar.a(i));
                    }
                    i++;
                }
                this.f27942a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // io.grpc.okhttp.internal.framed.b
        public synchronized void a(boolean z, boolean z2, int i, int i2, List<io.grpc.okhttp.internal.framed.c> list) throws IOException {
            try {
                if (!z2) {
                    if (!this.f27947f) {
                        a(z, i, list);
                    } else {
                        throw new IOException("closed");
                    }
                } else {
                    throw new UnsupportedOperationException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        void a(boolean z, int i, List<io.grpc.okhttp.internal.framed.c> list) throws IOException {
            if (!this.f27947f) {
                this.f27945d.a(list);
                long size = this.f27944c.size();
                int min = (int) Math.min(this.f27946e, size);
                long j = min;
                byte b2 = size == j ? (byte) 4 : (byte) 0;
                if (z) {
                    b2 = (byte) (b2 | 1);
                }
                a(i, min, (byte) 1, b2);
                this.f27942a.a(this.f27944c, j);
                if (size > j) {
                    b(i, size - j);
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        @Override // io.grpc.okhttp.internal.framed.b
        public synchronized void a(int i, ErrorCode errorCode) throws IOException {
            if (!this.f27947f) {
                if (errorCode.httpCode != -1) {
                    a(i, 4, (byte) 3, (byte) 0);
                    this.f27942a.writeInt(errorCode.httpCode);
                    this.f27942a.flush();
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                throw new IOException("closed");
            }
        }

        @Override // io.grpc.okhttp.internal.framed.b
        public synchronized void a(boolean z, int i, okio.g gVar, int i2) throws IOException {
            if (!this.f27947f) {
                a(i, z ? (byte) 1 : (byte) 0, gVar, i2);
            } else {
                throw new IOException("closed");
            }
        }

        void a(int i, byte b2, okio.g gVar, int i2) throws IOException {
            a(i, i2, (byte) 0, b2);
            if (i2 > 0) {
                this.f27942a.a(gVar, i2);
            }
        }

        @Override // io.grpc.okhttp.internal.framed.b
        public synchronized void a(boolean z, int i, int i2) throws IOException {
            if (!this.f27947f) {
                a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
                this.f27942a.writeInt(i);
                this.f27942a.writeInt(i2);
                this.f27942a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // io.grpc.okhttp.internal.framed.b
        public synchronized void a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
            if (!this.f27947f) {
                if (errorCode.httpCode != -1) {
                    a(0, bArr.length + 8, (byte) 7, (byte) 0);
                    this.f27942a.writeInt(i);
                    this.f27942a.writeInt(errorCode.httpCode);
                    if (bArr.length > 0) {
                        this.f27942a.write(bArr);
                    }
                    this.f27942a.flush();
                } else {
                    e.b("errorCode.httpCode == -1", new Object[0]);
                    throw null;
                }
            } else {
                throw new IOException("closed");
            }
        }

        @Override // io.grpc.okhttp.internal.framed.b
        public synchronized void a(int i, long j) throws IOException {
            if (this.f27947f) {
                throw new IOException("closed");
            }
            if (j != 0 && j <= 2147483647L) {
                a(i, 4, (byte) 8, (byte) 0);
                this.f27942a.writeInt((int) j);
                this.f27942a.flush();
            } else {
                e.b("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[]{Long.valueOf(j)});
                throw null;
            }
        }

        void a(int i, int i2, byte b2, byte b3) throws IOException {
            if (e.f27927a.isLoggable(Level.FINE)) {
                e.f27927a.fine(b.a(false, i, i2, b2, b3));
            }
            int i3 = this.f27946e;
            if (i2 > i3) {
                e.b("FRAME_SIZE_ERROR length > %d: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
                throw null;
            }
            if ((Integer.MIN_VALUE & i) == 0) {
                e.b(this.f27942a, i2);
                this.f27942a.writeByte(b2 & 255);
                this.f27942a.writeByte(b3 & 255);
                this.f27942a.writeInt(i & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                return;
            }
            e.b("reserved bit set: %s", new Object[]{Integer.valueOf(i)});
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(i iVar) throws IOException {
        return (iVar.readByte() & 255) | ((iVar.readByte() & 255) << 16) | ((iVar.readByte() & 255) << 8);
    }

    @Override // io.grpc.okhttp.internal.framed.h
    public io.grpc.okhttp.internal.framed.a a(i iVar, boolean z) {
        return new c(iVar, 4096, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(okio.h hVar, int i) throws IOException {
        hVar.writeByte((i >>> 16) & 255);
        hVar.writeByte((i >>> 8) & 255);
        hVar.writeByte(i & 255);
    }

    @Override // io.grpc.okhttp.internal.framed.h
    public io.grpc.okhttp.internal.framed.b a(okio.h hVar, boolean z) {
        return new d(hVar, z);
    }

    /* compiled from: Http2.java */
    /* loaded from: classes3.dex */
    static final class c implements io.grpc.okhttp.internal.framed.a {

        /* renamed from: a, reason: collision with root package name */
        private final i f27938a;

        /* renamed from: b, reason: collision with root package name */
        private final a f27939b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f27940c;

        /* renamed from: d, reason: collision with root package name */
        final d.a f27941d;

        c(i iVar, int i, boolean z) {
            this.f27938a = iVar;
            this.f27940c = z;
            this.f27939b = new a(this.f27938a);
            this.f27941d = new d.a(i, this.f27939b);
        }

        private void b(a.InterfaceC0159a interfaceC0159a, int i, byte b2, int i2) throws IOException {
            if (i < 8) {
                e.a("TYPE_GOAWAY length < 8: %s", new Object[]{Integer.valueOf(i)});
                throw null;
            }
            if (i2 == 0) {
                int readInt = this.f27938a.readInt();
                int readInt2 = this.f27938a.readInt();
                int i3 = i - 8;
                ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
                if (fromHttp2 != null) {
                    ByteString byteString = ByteString.EMPTY;
                    if (i3 > 0) {
                        byteString = this.f27938a.e(i3);
                    }
                    interfaceC0159a.a(readInt, fromHttp2, byteString);
                    return;
                }
                e.a("TYPE_GOAWAY unexpected error code: %d", new Object[]{Integer.valueOf(readInt2)});
                throw null;
            }
            e.a("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }

        private void c(a.InterfaceC0159a interfaceC0159a, int i, byte b2, int i2) throws IOException {
            if (i2 != 0) {
                boolean z = (b2 & 1) != 0;
                short readByte = (b2 & 8) != 0 ? (short) (this.f27938a.readByte() & 255) : (short) 0;
                if ((b2 & 32) != 0) {
                    a(interfaceC0159a, i2);
                    i -= 5;
                }
                interfaceC0159a.a(false, z, i2, -1, a(e.b(i, b2, readByte), readByte, b2, i2), HeadersMode.HTTP_20_HEADERS);
                return;
            }
            e.a("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            throw null;
        }

        private void d(a.InterfaceC0159a interfaceC0159a, int i, byte b2, int i2) throws IOException {
            if (i != 8) {
                e.a("TYPE_PING length != 8: %s", new Object[]{Integer.valueOf(i)});
                throw null;
            }
            if (i2 == 0) {
                interfaceC0159a.a((b2 & 1) != 0, this.f27938a.readInt(), this.f27938a.readInt());
                return;
            }
            e.a("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }

        private void e(a.InterfaceC0159a interfaceC0159a, int i, byte b2, int i2) throws IOException {
            if (i != 5) {
                e.a("TYPE_PRIORITY length: %d != 5", new Object[]{Integer.valueOf(i)});
                throw null;
            }
            if (i2 != 0) {
                a(interfaceC0159a, i2);
            } else {
                e.a("TYPE_PRIORITY streamId == 0", new Object[0]);
                throw null;
            }
        }

        private void f(a.InterfaceC0159a interfaceC0159a, int i, byte b2, int i2) throws IOException {
            if (i2 != 0) {
                short readByte = (b2 & 8) != 0 ? (short) (this.f27938a.readByte() & 255) : (short) 0;
                interfaceC0159a.a(i2, this.f27938a.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, a(e.b(i - 4, b2, readByte), readByte, b2, i2));
            } else {
                e.a("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
                throw null;
            }
        }

        private void g(a.InterfaceC0159a interfaceC0159a, int i, byte b2, int i2) throws IOException {
            if (i != 4) {
                e.a("TYPE_RST_STREAM length: %d != 4", new Object[]{Integer.valueOf(i)});
                throw null;
            }
            if (i2 != 0) {
                int readInt = this.f27938a.readInt();
                ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
                if (fromHttp2 != null) {
                    interfaceC0159a.a(i2, fromHttp2);
                    return;
                } else {
                    e.a("TYPE_RST_STREAM unexpected error code: %d", new Object[]{Integer.valueOf(readInt)});
                    throw null;
                }
            }
            e.a("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:16:0x002e. Please report as an issue. */
        private void h(a.InterfaceC0159a interfaceC0159a, int i, byte b2, int i2) throws IOException {
            if (i2 != 0) {
                e.a("TYPE_SETTINGS streamId != 0", new Object[0]);
                throw null;
            }
            if ((b2 & 1) != 0) {
                if (i == 0) {
                    interfaceC0159a.b();
                    return;
                } else {
                    e.a("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                    throw null;
                }
            }
            if (i % 6 == 0) {
                g gVar = new g();
                for (int i3 = 0; i3 < i; i3 += 6) {
                    short readShort = this.f27938a.readShort();
                    int readInt = this.f27938a.readInt();
                    switch (readShort) {
                        case 1:
                        case 6:
                            gVar.a(readShort, 0, readInt);
                        case 2:
                            if (readInt != 0 && readInt != 1) {
                                e.a("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                                throw null;
                            }
                            gVar.a(readShort, 0, readInt);
                        case 3:
                            readShort = 4;
                            gVar.a(readShort, 0, readInt);
                        case 4:
                            readShort = 7;
                            if (readInt < 0) {
                                e.a("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                throw null;
                            }
                            gVar.a(readShort, 0, readInt);
                        case 5:
                            if (readInt < 16384 || readInt > 16777215) {
                                e.a("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[]{Integer.valueOf(readInt)});
                                throw null;
                            }
                            gVar.a(readShort, 0, readInt);
                            break;
                        default:
                    }
                }
                interfaceC0159a.a(false, gVar);
                if (gVar.a() >= 0) {
                    this.f27941d.a(gVar.a());
                    return;
                }
                return;
            }
            e.a("TYPE_SETTINGS length %% 6 != 0: %s", new Object[]{Integer.valueOf(i)});
            throw null;
        }

        private void i(a.InterfaceC0159a interfaceC0159a, int i, byte b2, int i2) throws IOException {
            if (i == 4) {
                long readInt = this.f27938a.readInt() & 2147483647L;
                if (readInt != 0) {
                    interfaceC0159a.a(i2, readInt);
                    return;
                } else {
                    e.a("windowSizeIncrement was 0", new Object[]{Long.valueOf(readInt)});
                    throw null;
                }
            }
            e.a("TYPE_WINDOW_UPDATE length !=4: %s", new Object[]{Integer.valueOf(i)});
            throw null;
        }

        @Override // io.grpc.okhttp.internal.framed.a
        public boolean a(a.InterfaceC0159a interfaceC0159a) throws IOException {
            try {
                this.f27938a.c(9L);
                int b2 = e.b(this.f27938a);
                if (b2 >= 0 && b2 <= 16384) {
                    byte readByte = (byte) (this.f27938a.readByte() & 255);
                    byte readByte2 = (byte) (this.f27938a.readByte() & 255);
                    int readInt = this.f27938a.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    if (e.f27927a.isLoggable(Level.FINE)) {
                        e.f27927a.fine(b.a(true, readInt, b2, readByte, readByte2));
                    }
                    switch (readByte) {
                        case 0:
                            a(interfaceC0159a, b2, readByte2, readInt);
                            return true;
                        case 1:
                            c(interfaceC0159a, b2, readByte2, readInt);
                            return true;
                        case 2:
                            e(interfaceC0159a, b2, readByte2, readInt);
                            return true;
                        case 3:
                            g(interfaceC0159a, b2, readByte2, readInt);
                            return true;
                        case 4:
                            h(interfaceC0159a, b2, readByte2, readInt);
                            return true;
                        case 5:
                            f(interfaceC0159a, b2, readByte2, readInt);
                            return true;
                        case 6:
                            d(interfaceC0159a, b2, readByte2, readInt);
                            return true;
                        case 7:
                            b(interfaceC0159a, b2, readByte2, readInt);
                            return true;
                        case 8:
                            i(interfaceC0159a, b2, readByte2, readInt);
                            return true;
                        default:
                            this.f27938a.skip(b2);
                            return true;
                    }
                }
                e.a("FRAME_SIZE_ERROR: %s", new Object[]{Integer.valueOf(b2)});
                throw null;
            } catch (IOException unused) {
                return false;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f27938a.close();
        }

        private List<io.grpc.okhttp.internal.framed.c> a(int i, short s, byte b2, int i2) throws IOException {
            a aVar = this.f27939b;
            aVar.f27933e = i;
            aVar.f27930b = i;
            aVar.f27934f = s;
            aVar.f27931c = b2;
            aVar.f27932d = i2;
            this.f27941d.c();
            return this.f27941d.a();
        }

        private void a(a.InterfaceC0159a interfaceC0159a, int i, byte b2, int i2) throws IOException {
            boolean z = (b2 & 1) != 0;
            if (!((b2 & 32) != 0)) {
                short readByte = (b2 & 8) != 0 ? (short) (this.f27938a.readByte() & 255) : (short) 0;
                interfaceC0159a.a(z, i2, this.f27938a, e.b(i, b2, readByte));
                this.f27938a.skip(readByte);
                return;
            }
            e.a("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            throw null;
        }

        private void a(a.InterfaceC0159a interfaceC0159a, int i) throws IOException {
            int readInt = this.f27938a.readInt();
            interfaceC0159a.a(i, readInt & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, (this.f27938a.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
        }
    }
}
