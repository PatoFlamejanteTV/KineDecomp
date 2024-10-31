package okhttp3.internal.http2;

import android.support.v7.widget.ActivityChooserView;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.b;
import okio.B;
import okio.ByteString;
import okio.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Http2Reader.java */
/* loaded from: classes3.dex */
public final class p implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    static final Logger f29112a = Logger.getLogger(c.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private final okio.i f29113b;

    /* renamed from: c, reason: collision with root package name */
    private final a f29114c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f29115d;

    /* renamed from: e, reason: collision with root package name */
    final b.a f29116e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Reader.java */
    /* loaded from: classes3.dex */
    public static final class a implements z {

        /* renamed from: a, reason: collision with root package name */
        private final okio.i f29117a;

        /* renamed from: b, reason: collision with root package name */
        int f29118b;

        /* renamed from: c, reason: collision with root package name */
        byte f29119c;

        /* renamed from: d, reason: collision with root package name */
        int f29120d;

        /* renamed from: e, reason: collision with root package name */
        int f29121e;

        /* renamed from: f, reason: collision with root package name */
        short f29122f;

        a(okio.i iVar) {
            this.f29117a = iVar;
        }

        private void a() throws IOException {
            int i = this.f29120d;
            int a2 = p.a(this.f29117a);
            this.f29121e = a2;
            this.f29118b = a2;
            byte readByte = (byte) (this.f29117a.readByte() & 255);
            this.f29119c = (byte) (this.f29117a.readByte() & 255);
            if (p.f29112a.isLoggable(Level.FINE)) {
                p.f29112a.fine(c.a(true, this.f29120d, this.f29118b, readByte, this.f29119c));
            }
            this.f29120d = this.f29117a.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (readByte == 9) {
                if (this.f29120d == i) {
                    return;
                }
                c.b("TYPE_CONTINUATION streamId changed", new Object[0]);
                throw null;
            }
            c.b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            throw null;
        }

        @Override // okio.z
        public long b(okio.g gVar, long j) throws IOException {
            while (true) {
                int i = this.f29121e;
                if (i == 0) {
                    this.f29117a.skip(this.f29122f);
                    this.f29122f = (short) 0;
                    if ((this.f29119c & 4) != 0) {
                        return -1L;
                    }
                    a();
                } else {
                    long b2 = this.f29117a.b(gVar, Math.min(j, i));
                    if (b2 == -1) {
                        return -1L;
                    }
                    this.f29121e = (int) (this.f29121e - b2);
                    return b2;
                }
            }
        }

        @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.z
        public B e() {
            return this.f29117a.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Reader.java */
    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2, int i3, boolean z);

        void a(int i, int i2, List<okhttp3.internal.http2.a> list) throws IOException;

        void a(int i, long j);

        void a(int i, ErrorCode errorCode);

        void a(int i, ErrorCode errorCode, ByteString byteString);

        void a(boolean z, int i, int i2);

        void a(boolean z, int i, int i2, List<okhttp3.internal.http2.a> list);

        void a(boolean z, int i, okio.i iVar, int i2) throws IOException;

        void a(boolean z, v vVar);

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(okio.i iVar, boolean z) {
        this.f29113b = iVar;
        this.f29115d = z;
        this.f29114c = new a(this.f29113b);
        this.f29116e = new b.a(4096, this.f29114c);
    }

    private void b(b bVar, int i, byte b2, int i2) throws IOException {
        if (i < 8) {
            c.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            throw null;
        }
        if (i2 == 0) {
            int readInt = this.f29113b.readInt();
            int readInt2 = this.f29113b.readInt();
            int i3 = i - 8;
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
            if (fromHttp2 != null) {
                ByteString byteString = ByteString.EMPTY;
                if (i3 > 0) {
                    byteString = this.f29113b.e(i3);
                }
                bVar.a(readInt, fromHttp2, byteString);
                return;
            }
            c.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            throw null;
        }
        c.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        throw null;
    }

    private void c(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            boolean z = (b2 & 1) != 0;
            short readByte = (b2 & 8) != 0 ? (short) (this.f29113b.readByte() & 255) : (short) 0;
            if ((b2 & 32) != 0) {
                a(bVar, i2);
                i -= 5;
            }
            bVar.a(z, i2, -1, a(a(i, b2, readByte), readByte, b2, i2));
            return;
        }
        c.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        throw null;
    }

    private void d(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 8) {
            c.b("TYPE_PING length != 8: %s", Integer.valueOf(i));
            throw null;
        }
        if (i2 == 0) {
            bVar.a((b2 & 1) != 0, this.f29113b.readInt(), this.f29113b.readInt());
            return;
        }
        c.b("TYPE_PING streamId != 0", new Object[0]);
        throw null;
    }

    private void e(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 5) {
            c.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            a(bVar, i2);
        } else {
            c.b("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    private void f(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            short readByte = (b2 & 8) != 0 ? (short) (this.f29113b.readByte() & 255) : (short) 0;
            bVar.a(i2, this.f29113b.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, a(a(i - 4, b2, readByte), readByte, b2, i2));
        } else {
            c.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw null;
        }
    }

    private void g(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            c.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            int readInt = this.f29113b.readInt();
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
            if (fromHttp2 != null) {
                bVar.a(i2, fromHttp2);
                return;
            } else {
                c.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
                throw null;
            }
        }
        c.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        throw null;
    }

    private void h(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            c.b("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        }
        if ((b2 & 1) != 0) {
            if (i == 0) {
                bVar.b();
                return;
            } else {
                c.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
        }
        if (i % 6 == 0) {
            v vVar = new v();
            for (int i3 = 0; i3 < i; i3 += 6) {
                int readShort = this.f29113b.readShort() & 65535;
                int readInt = this.f29113b.readInt();
                switch (readShort) {
                    case 2:
                        if (readInt != 0 && readInt != 1) {
                            c.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                            throw null;
                        }
                        break;
                    case 3:
                        readShort = 4;
                        break;
                    case 4:
                        readShort = 7;
                        if (readInt < 0) {
                            c.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            throw null;
                        }
                        break;
                    case 5:
                        if (readInt < 16384 || readInt > 16777215) {
                            c.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                            throw null;
                        }
                        break;
                        break;
                }
                vVar.a(readShort, readInt);
            }
            bVar.a(false, vVar);
            return;
        }
        c.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        throw null;
    }

    private void i(b bVar, int i, byte b2, int i2) throws IOException {
        if (i == 4) {
            long readInt = this.f29113b.readInt() & 2147483647L;
            if (readInt != 0) {
                bVar.a(i2, readInt);
                return;
            } else {
                c.b("windowSizeIncrement was 0", Long.valueOf(readInt));
                throw null;
            }
        }
        c.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        throw null;
    }

    public void a(b bVar) throws IOException {
        if (this.f29115d) {
            if (a(true, bVar)) {
                return;
            }
            c.b("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        ByteString e2 = this.f29113b.e(c.f29049a.size());
        if (f29112a.isLoggable(Level.FINE)) {
            f29112a.fine(okhttp3.a.e.a("<< CONNECTION %s", e2.hex()));
        }
        if (c.f29049a.equals(e2)) {
            return;
        }
        c.b("Expected a connection header but was %s", e2.utf8());
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f29113b.close();
    }

    public boolean a(boolean z, b bVar) throws IOException {
        try {
            this.f29113b.c(9L);
            int a2 = a(this.f29113b);
            if (a2 >= 0 && a2 <= 16384) {
                byte readByte = (byte) (this.f29113b.readByte() & 255);
                if (z && readByte != 4) {
                    c.b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
                    throw null;
                }
                byte readByte2 = (byte) (this.f29113b.readByte() & 255);
                int readInt = this.f29113b.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                if (f29112a.isLoggable(Level.FINE)) {
                    f29112a.fine(c.a(true, readInt, a2, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        a(bVar, a2, readByte2, readInt);
                        return true;
                    case 1:
                        c(bVar, a2, readByte2, readInt);
                        return true;
                    case 2:
                        e(bVar, a2, readByte2, readInt);
                        return true;
                    case 3:
                        g(bVar, a2, readByte2, readInt);
                        return true;
                    case 4:
                        h(bVar, a2, readByte2, readInt);
                        return true;
                    case 5:
                        f(bVar, a2, readByte2, readInt);
                        return true;
                    case 6:
                        d(bVar, a2, readByte2, readInt);
                        return true;
                    case 7:
                        b(bVar, a2, readByte2, readInt);
                        return true;
                    case 8:
                        i(bVar, a2, readByte2, readInt);
                        return true;
                    default:
                        this.f29113b.skip(a2);
                        return true;
                }
            }
            c.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a2));
            throw null;
        } catch (IOException unused) {
            return false;
        }
    }

    private List<okhttp3.internal.http2.a> a(int i, short s, byte b2, int i2) throws IOException {
        a aVar = this.f29114c;
        aVar.f29121e = i;
        aVar.f29118b = i;
        aVar.f29122f = s;
        aVar.f29119c = b2;
        aVar.f29120d = i2;
        this.f29116e.c();
        return this.f29116e.a();
    }

    private void a(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            c.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
            throw null;
        }
        boolean z = (b2 & 1) != 0;
        if (!((b2 & 32) != 0)) {
            short readByte = (b2 & 8) != 0 ? (short) (this.f29113b.readByte() & 255) : (short) 0;
            bVar.a(z, i2, this.f29113b, a(i, b2, readByte));
            this.f29113b.skip(readByte);
            return;
        }
        c.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        throw null;
    }

    private void a(b bVar, int i) throws IOException {
        int readInt = this.f29113b.readInt();
        bVar.a(i, readInt & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, (this.f29113b.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    static int a(okio.i iVar) throws IOException {
        return (iVar.readByte() & 255) | ((iVar.readByte() & 255) << 16) | ((iVar.readByte() & 255) << 8);
    }

    static int a(int i, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        c.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        throw null;
    }
}
