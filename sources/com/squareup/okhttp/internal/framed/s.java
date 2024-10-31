package com.squareup.okhttp.internal.framed;

import android.support.v7.widget.ActivityChooserView;
import com.squareup.okhttp.internal.framed.InterfaceC2384a;
import com.squareup.okhttp.internal.framed.r;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.ByteString;

/* compiled from: Http2.java */
/* loaded from: classes3.dex */
public final class s implements C {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f25374a = Logger.getLogger(b.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final ByteString f25375b = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2.java */
    /* loaded from: classes3.dex */
    public static final class a implements okio.z {

        /* renamed from: a, reason: collision with root package name */
        private final okio.i f25376a;

        /* renamed from: b, reason: collision with root package name */
        int f25377b;

        /* renamed from: c, reason: collision with root package name */
        byte f25378c;

        /* renamed from: d, reason: collision with root package name */
        int f25379d;

        /* renamed from: e, reason: collision with root package name */
        int f25380e;

        /* renamed from: f, reason: collision with root package name */
        short f25381f;

        public a(okio.i iVar) {
            this.f25376a = iVar;
        }

        private void a() throws IOException {
            int i = this.f25379d;
            int b2 = s.b(this.f25376a);
            this.f25380e = b2;
            this.f25377b = b2;
            byte readByte = (byte) (this.f25376a.readByte() & 255);
            this.f25378c = (byte) (this.f25376a.readByte() & 255);
            if (s.f25374a.isLoggable(Level.FINE)) {
                s.f25374a.fine(b.a(true, this.f25379d, this.f25377b, readByte, this.f25378c));
            }
            this.f25379d = this.f25376a.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (readByte == 9) {
                if (this.f25379d == i) {
                    return;
                }
                s.a("TYPE_CONTINUATION streamId changed", new Object[0]);
                throw null;
            }
            s.a("%s != TYPE_CONTINUATION", new Object[]{Byte.valueOf(readByte)});
            throw null;
        }

        @Override // okio.z
        public long b(okio.g gVar, long j) throws IOException {
            while (true) {
                int i = this.f25380e;
                if (i == 0) {
                    this.f25376a.skip(this.f25381f);
                    this.f25381f = (short) 0;
                    if ((this.f25378c & 4) != 0) {
                        return -1L;
                    }
                    a();
                } else {
                    long b2 = this.f25376a.b(gVar, Math.min(j, i));
                    if (b2 == -1) {
                        return -1L;
                    }
                    this.f25380e = (int) (this.f25380e - b2);
                    return b2;
                }
            }
        }

        @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.z
        public okio.B e() {
            return this.f25376a.e();
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
        private static final String[] f25382a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        /* renamed from: b, reason: collision with root package name */
        private static final String[] f25383b = new String[64];

        /* renamed from: c, reason: collision with root package name */
        private static final String[] f25384c = new String[256];

        static {
            int i = 0;
            int i2 = 0;
            while (true) {
                String[] strArr = f25384c;
                if (i2 >= strArr.length) {
                    break;
                }
                strArr[i2] = String.format("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
                i2++;
            }
            String[] strArr2 = f25383b;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] iArr = {1};
            strArr2[8] = "PADDED";
            for (int i3 : iArr) {
                f25383b[i3 | 8] = f25383b[i3] + "|PADDED";
            }
            String[] strArr3 = f25383b;
            strArr3[4] = "END_HEADERS";
            strArr3[32] = "PRIORITY";
            strArr3[36] = "END_HEADERS|PRIORITY";
            for (int i4 : new int[]{4, 32, 36}) {
                for (int i5 : iArr) {
                    int i6 = i5 | i4;
                    f25383b[i6] = f25383b[i5] + '|' + f25383b[i4];
                    f25383b[i6 | 8] = f25383b[i5] + '|' + f25383b[i4] + "|PADDED";
                }
            }
            while (true) {
                String[] strArr4 = f25383b;
                if (i >= strArr4.length) {
                    return;
                }
                if (strArr4[i] == null) {
                    strArr4[i] = f25384c[i];
                }
                i++;
            }
        }

        b() {
        }

        static String a(boolean z, int i, int i2, byte b2, byte b3) {
            String[] strArr = f25382a;
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
                    return b3 == 1 ? "ACK" : f25384c[b3];
                }
                if (b2 != 7 && b2 != 8) {
                    String[] strArr = f25383b;
                    String str = b3 < strArr.length ? strArr[b3] : f25384c[b3];
                    if (b2 != 5 || (b3 & 4) == 0) {
                        return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                    }
                    return str.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            return f25384c[b3];
        }
    }

    /* compiled from: Http2.java */
    /* loaded from: classes3.dex */
    static final class d implements InterfaceC2385b {

        /* renamed from: a, reason: collision with root package name */
        private final okio.h f25389a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f25390b;

        /* renamed from: c, reason: collision with root package name */
        private final okio.g f25391c = new okio.g();

        /* renamed from: d, reason: collision with root package name */
        private final r.b f25392d = new r.b(this.f25391c);

        /* renamed from: e, reason: collision with root package name */
        private int f25393e = 16384;

        /* renamed from: f, reason: collision with root package name */
        private boolean f25394f;

        d(okio.h hVar, boolean z) {
            this.f25389a = hVar;
            this.f25390b = z;
        }

        private void b(int i, long j) throws IOException {
            while (j > 0) {
                int min = (int) Math.min(this.f25393e, j);
                long j2 = min;
                j -= j2;
                a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
                this.f25389a.a(this.f25391c, j2);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void a(A a2) throws IOException {
            if (!this.f25394f) {
                this.f25393e = a2.e(this.f25393e);
                a(0, 0, (byte) 4, (byte) 1);
                this.f25389a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            this.f25394f = true;
            this.f25389a.close();
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void flush() throws IOException {
            if (!this.f25394f) {
                this.f25389a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void q() throws IOException {
            if (!this.f25394f) {
                if (this.f25390b) {
                    if (s.f25374a.isLoggable(Level.FINE)) {
                        s.f25374a.fine(String.format(">> CONNECTION %s", s.f25375b.hex()));
                    }
                    this.f25389a.write(s.f25375b.toByteArray());
                    this.f25389a.flush();
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public int t() {
            return this.f25393e;
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void b(A a2) throws IOException {
            if (!this.f25394f) {
                int i = 0;
                a(0, a2.c() * 6, (byte) 4, (byte) 0);
                while (i < 10) {
                    if (a2.g(i)) {
                        this.f25389a.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                        this.f25389a.writeInt(a2.b(i));
                    }
                    i++;
                }
                this.f25389a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void a(boolean z, boolean z2, int i, int i2, List<q> list) throws IOException {
            try {
                if (!z2) {
                    if (!this.f25394f) {
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

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void a(int i, int i2, List<q> list) throws IOException {
            if (!this.f25394f) {
                this.f25392d.a(list);
                long size = this.f25391c.size();
                int min = (int) Math.min(this.f25393e - 4, size);
                long j = min;
                a(i, min + 4, (byte) 5, size == j ? (byte) 4 : (byte) 0);
                this.f25389a.writeInt(i2 & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.f25389a.a(this.f25391c, j);
                if (size > j) {
                    b(i, size - j);
                }
            } else {
                throw new IOException("closed");
            }
        }

        void a(boolean z, int i, List<q> list) throws IOException {
            if (!this.f25394f) {
                this.f25392d.a(list);
                long size = this.f25391c.size();
                int min = (int) Math.min(this.f25393e, size);
                long j = min;
                byte b2 = size == j ? (byte) 4 : (byte) 0;
                if (z) {
                    b2 = (byte) (b2 | 1);
                }
                a(i, min, (byte) 1, b2);
                this.f25389a.a(this.f25391c, j);
                if (size > j) {
                    b(i, size - j);
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void a(int i, ErrorCode errorCode) throws IOException {
            if (!this.f25394f) {
                if (errorCode.httpCode != -1) {
                    a(i, 4, (byte) 3, (byte) 0);
                    this.f25389a.writeInt(errorCode.httpCode);
                    this.f25389a.flush();
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                throw new IOException("closed");
            }
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void a(boolean z, int i, okio.g gVar, int i2) throws IOException {
            if (!this.f25394f) {
                a(i, z ? (byte) 1 : (byte) 0, gVar, i2);
            } else {
                throw new IOException("closed");
            }
        }

        void a(int i, byte b2, okio.g gVar, int i2) throws IOException {
            a(i, i2, (byte) 0, b2);
            if (i2 > 0) {
                this.f25389a.a(gVar, i2);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void a(boolean z, int i, int i2) throws IOException {
            if (!this.f25394f) {
                a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
                this.f25389a.writeInt(i);
                this.f25389a.writeInt(i2);
                this.f25389a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
            if (!this.f25394f) {
                if (errorCode.httpCode != -1) {
                    a(0, bArr.length + 8, (byte) 7, (byte) 0);
                    this.f25389a.writeInt(i);
                    this.f25389a.writeInt(errorCode.httpCode);
                    if (bArr.length > 0) {
                        this.f25389a.write(bArr);
                    }
                    this.f25389a.flush();
                } else {
                    s.b("errorCode.httpCode == -1", new Object[0]);
                    throw null;
                }
            } else {
                throw new IOException("closed");
            }
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void a(int i, long j) throws IOException {
            if (this.f25394f) {
                throw new IOException("closed");
            }
            if (j != 0 && j <= 2147483647L) {
                a(i, 4, (byte) 8, (byte) 0);
                this.f25389a.writeInt((int) j);
                this.f25389a.flush();
            } else {
                s.b("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[]{Long.valueOf(j)});
                throw null;
            }
        }

        void a(int i, int i2, byte b2, byte b3) throws IOException {
            if (s.f25374a.isLoggable(Level.FINE)) {
                s.f25374a.fine(b.a(false, i, i2, b2, b3));
            }
            int i3 = this.f25393e;
            if (i2 > i3) {
                s.b("FRAME_SIZE_ERROR length > %d: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
                throw null;
            }
            if ((Integer.MIN_VALUE & i) == 0) {
                s.b(this.f25389a, i2);
                this.f25389a.writeByte(b2 & 255);
                this.f25389a.writeByte(b3 & 255);
                this.f25389a.writeInt(i & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                return;
            }
            s.b("reserved bit set: %s", new Object[]{Integer.valueOf(i)});
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
    public static int b(okio.i iVar) throws IOException {
        return (iVar.readByte() & 255) | ((iVar.readByte() & 255) << 16) | ((iVar.readByte() & 255) << 8);
    }

    @Override // com.squareup.okhttp.internal.framed.C
    public InterfaceC2384a a(okio.i iVar, boolean z) {
        return new c(iVar, 4096, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(okio.h hVar, int i) throws IOException {
        hVar.writeByte((i >>> 16) & 255);
        hVar.writeByte((i >>> 8) & 255);
        hVar.writeByte(i & 255);
    }

    @Override // com.squareup.okhttp.internal.framed.C
    public InterfaceC2385b a(okio.h hVar, boolean z) {
        return new d(hVar, z);
    }

    /* compiled from: Http2.java */
    /* loaded from: classes3.dex */
    static final class c implements InterfaceC2384a {

        /* renamed from: a, reason: collision with root package name */
        private final okio.i f25385a;

        /* renamed from: b, reason: collision with root package name */
        private final a f25386b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f25387c;

        /* renamed from: d, reason: collision with root package name */
        final r.a f25388d;

        c(okio.i iVar, int i, boolean z) {
            this.f25385a = iVar;
            this.f25387c = z;
            this.f25386b = new a(this.f25385a);
            this.f25388d = new r.a(i, this.f25386b);
        }

        private void b(InterfaceC2384a.InterfaceC0130a interfaceC0130a, int i, byte b2, int i2) throws IOException {
            if (i < 8) {
                s.a("TYPE_GOAWAY length < 8: %s", new Object[]{Integer.valueOf(i)});
                throw null;
            }
            if (i2 == 0) {
                int readInt = this.f25385a.readInt();
                int readInt2 = this.f25385a.readInt();
                int i3 = i - 8;
                ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
                if (fromHttp2 != null) {
                    ByteString byteString = ByteString.EMPTY;
                    if (i3 > 0) {
                        byteString = this.f25385a.e(i3);
                    }
                    interfaceC0130a.a(readInt, fromHttp2, byteString);
                    return;
                }
                s.a("TYPE_GOAWAY unexpected error code: %d", new Object[]{Integer.valueOf(readInt2)});
                throw null;
            }
            s.a("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }

        private void c(InterfaceC2384a.InterfaceC0130a interfaceC0130a, int i, byte b2, int i2) throws IOException {
            if (i2 != 0) {
                boolean z = (b2 & 1) != 0;
                short readByte = (b2 & 8) != 0 ? (short) (this.f25385a.readByte() & 255) : (short) 0;
                if ((b2 & 32) != 0) {
                    a(interfaceC0130a, i2);
                    i -= 5;
                }
                interfaceC0130a.a(false, z, i2, -1, a(s.b(i, b2, readByte), readByte, b2, i2), HeadersMode.HTTP_20_HEADERS);
                return;
            }
            s.a("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            throw null;
        }

        private void d(InterfaceC2384a.InterfaceC0130a interfaceC0130a, int i, byte b2, int i2) throws IOException {
            if (i != 8) {
                s.a("TYPE_PING length != 8: %s", new Object[]{Integer.valueOf(i)});
                throw null;
            }
            if (i2 == 0) {
                interfaceC0130a.a((b2 & 1) != 0, this.f25385a.readInt(), this.f25385a.readInt());
                return;
            }
            s.a("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }

        private void e(InterfaceC2384a.InterfaceC0130a interfaceC0130a, int i, byte b2, int i2) throws IOException {
            if (i != 5) {
                s.a("TYPE_PRIORITY length: %d != 5", new Object[]{Integer.valueOf(i)});
                throw null;
            }
            if (i2 != 0) {
                a(interfaceC0130a, i2);
            } else {
                s.a("TYPE_PRIORITY streamId == 0", new Object[0]);
                throw null;
            }
        }

        private void f(InterfaceC2384a.InterfaceC0130a interfaceC0130a, int i, byte b2, int i2) throws IOException {
            if (i2 != 0) {
                short readByte = (b2 & 8) != 0 ? (short) (this.f25385a.readByte() & 255) : (short) 0;
                interfaceC0130a.a(i2, this.f25385a.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, a(s.b(i - 4, b2, readByte), readByte, b2, i2));
            } else {
                s.a("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
                throw null;
            }
        }

        private void g(InterfaceC2384a.InterfaceC0130a interfaceC0130a, int i, byte b2, int i2) throws IOException {
            if (i != 4) {
                s.a("TYPE_RST_STREAM length: %d != 4", new Object[]{Integer.valueOf(i)});
                throw null;
            }
            if (i2 != 0) {
                int readInt = this.f25385a.readInt();
                ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
                if (fromHttp2 != null) {
                    interfaceC0130a.a(i2, fromHttp2);
                    return;
                } else {
                    s.a("TYPE_RST_STREAM unexpected error code: %d", new Object[]{Integer.valueOf(readInt)});
                    throw null;
                }
            }
            s.a("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }

        private void h(InterfaceC2384a.InterfaceC0130a interfaceC0130a, int i, byte b2, int i2) throws IOException {
            if (i2 != 0) {
                s.a("TYPE_SETTINGS streamId != 0", new Object[0]);
                throw null;
            }
            if ((b2 & 1) != 0) {
                if (i == 0) {
                    interfaceC0130a.b();
                    return;
                } else {
                    s.a("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                    throw null;
                }
            }
            if (i % 6 == 0) {
                A a2 = new A();
                for (int i3 = 0; i3 < i; i3 += 6) {
                    short readShort = this.f25385a.readShort();
                    int readInt = this.f25385a.readInt();
                    switch (readShort) {
                        case 1:
                        case 6:
                            break;
                        case 2:
                            if (readInt != 0 && readInt != 1) {
                                s.a("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                                throw null;
                            }
                            break;
                        case 3:
                            readShort = 4;
                            break;
                        case 4:
                            readShort = 7;
                            if (readInt < 0) {
                                s.a("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                throw null;
                            }
                            break;
                        case 5:
                            if (readInt < 16384 || readInt > 16777215) {
                                s.a("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[]{Integer.valueOf(readInt)});
                                throw null;
                            }
                            break;
                            break;
                        default:
                            s.a("PROTOCOL_ERROR invalid settings id: %s", new Object[]{Short.valueOf(readShort)});
                            throw null;
                    }
                    a2.a(readShort, 0, readInt);
                }
                interfaceC0130a.a(false, a2);
                if (a2.b() >= 0) {
                    this.f25388d.a(a2.b());
                    return;
                }
                return;
            }
            s.a("TYPE_SETTINGS length %% 6 != 0: %s", new Object[]{Integer.valueOf(i)});
            throw null;
        }

        private void i(InterfaceC2384a.InterfaceC0130a interfaceC0130a, int i, byte b2, int i2) throws IOException {
            if (i == 4) {
                long readInt = this.f25385a.readInt() & 2147483647L;
                if (readInt != 0) {
                    interfaceC0130a.a(i2, readInt);
                    return;
                } else {
                    s.a("windowSizeIncrement was 0", new Object[]{Long.valueOf(readInt)});
                    throw null;
                }
            }
            s.a("TYPE_WINDOW_UPDATE length !=4: %s", new Object[]{Integer.valueOf(i)});
            throw null;
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2384a
        public void H() throws IOException {
            if (this.f25387c) {
                return;
            }
            ByteString e2 = this.f25385a.e(s.f25375b.size());
            if (s.f25374a.isLoggable(Level.FINE)) {
                s.f25374a.fine(String.format("<< CONNECTION %s", e2.hex()));
            }
            if (s.f25375b.equals(e2)) {
                return;
            }
            s.a("Expected a connection header but was %s", new Object[]{e2.utf8()});
            throw null;
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2384a
        public boolean a(InterfaceC2384a.InterfaceC0130a interfaceC0130a) throws IOException {
            try {
                this.f25385a.c(9L);
                int b2 = s.b(this.f25385a);
                if (b2 >= 0 && b2 <= 16384) {
                    byte readByte = (byte) (this.f25385a.readByte() & 255);
                    byte readByte2 = (byte) (this.f25385a.readByte() & 255);
                    int readInt = this.f25385a.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    if (s.f25374a.isLoggable(Level.FINE)) {
                        s.f25374a.fine(b.a(true, readInt, b2, readByte, readByte2));
                    }
                    switch (readByte) {
                        case 0:
                            a(interfaceC0130a, b2, readByte2, readInt);
                            return true;
                        case 1:
                            c(interfaceC0130a, b2, readByte2, readInt);
                            return true;
                        case 2:
                            e(interfaceC0130a, b2, readByte2, readInt);
                            return true;
                        case 3:
                            g(interfaceC0130a, b2, readByte2, readInt);
                            return true;
                        case 4:
                            h(interfaceC0130a, b2, readByte2, readInt);
                            return true;
                        case 5:
                            f(interfaceC0130a, b2, readByte2, readInt);
                            return true;
                        case 6:
                            d(interfaceC0130a, b2, readByte2, readInt);
                            return true;
                        case 7:
                            b(interfaceC0130a, b2, readByte2, readInt);
                            return true;
                        case 8:
                            i(interfaceC0130a, b2, readByte2, readInt);
                            return true;
                        default:
                            this.f25385a.skip(b2);
                            return true;
                    }
                }
                s.a("FRAME_SIZE_ERROR: %s", new Object[]{Integer.valueOf(b2)});
                throw null;
            } catch (IOException unused) {
                return false;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f25385a.close();
        }

        private List<q> a(int i, short s, byte b2, int i2) throws IOException {
            a aVar = this.f25386b;
            aVar.f25380e = i;
            aVar.f25377b = i;
            aVar.f25381f = s;
            aVar.f25378c = b2;
            aVar.f25379d = i2;
            this.f25388d.c();
            return this.f25388d.a();
        }

        private void a(InterfaceC2384a.InterfaceC0130a interfaceC0130a, int i, byte b2, int i2) throws IOException {
            boolean z = (b2 & 1) != 0;
            if (!((b2 & 32) != 0)) {
                short readByte = (b2 & 8) != 0 ? (short) (this.f25385a.readByte() & 255) : (short) 0;
                interfaceC0130a.a(z, i2, this.f25385a, s.b(i, b2, readByte));
                this.f25385a.skip(readByte);
                return;
            }
            s.a("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            throw null;
        }

        private void a(InterfaceC2384a.InterfaceC0130a interfaceC0130a, int i) throws IOException {
            int readInt = this.f25385a.readInt();
            interfaceC0130a.a(i, readInt & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, (this.f25385a.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
        }
    }
}
