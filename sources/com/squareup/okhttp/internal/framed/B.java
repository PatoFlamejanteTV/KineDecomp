package com.squareup.okhttp.internal.framed;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.ActivityChooserView;
import com.squareup.okhttp.internal.framed.InterfaceC2384a;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.List;
import java.util.zip.Deflater;
import okio.ByteString;

/* compiled from: Spdy3.java */
/* loaded from: classes3.dex */
public final class B implements C {

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f25278a;

    static {
        try {
            f25278a = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(com.squareup.okhttp.a.o.f25219c.name());
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }

    @Override // com.squareup.okhttp.internal.framed.C
    public InterfaceC2384a a(okio.i iVar, boolean z) {
        return new a(iVar, z);
    }

    @Override // com.squareup.okhttp.internal.framed.C
    public InterfaceC2385b a(okio.h hVar, boolean z) {
        return new b(hVar, z);
    }

    /* compiled from: Spdy3.java */
    /* loaded from: classes3.dex */
    static final class b implements InterfaceC2385b {

        /* renamed from: a, reason: collision with root package name */
        private final okio.h f25282a;

        /* renamed from: b, reason: collision with root package name */
        private final okio.g f25283b;

        /* renamed from: c, reason: collision with root package name */
        private final okio.h f25284c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f25285d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f25286e;

        b(okio.h hVar, boolean z) {
            this.f25282a = hVar;
            this.f25285d = z;
            Deflater deflater = new Deflater();
            deflater.setDictionary(B.f25278a);
            this.f25283b = new okio.g();
            this.f25284c = okio.s.a(new okio.j((okio.y) this.f25283b, deflater));
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public void a(int i, int i2, List<q> list) throws IOException {
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public void a(A a2) {
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void a(boolean z, boolean z2, int i, int i2, List<q> list) throws IOException {
            if (!this.f25286e) {
                a(list);
                int size = (int) (this.f25283b.size() + 10);
                int i3 = (z ? 1 : 0) | (z2 ? 2 : 0);
                this.f25282a.writeInt(-2147287039);
                this.f25282a.writeInt(((i3 & 255) << 24) | (size & ViewCompat.MEASURED_SIZE_MASK));
                this.f25282a.writeInt(i & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.f25282a.writeInt(Integer.MAX_VALUE & i2);
                this.f25282a.writeShort(0);
                this.f25282a.a(this.f25283b);
                this.f25282a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void b(A a2) throws IOException {
            if (!this.f25286e) {
                int c2 = a2.c();
                this.f25282a.writeInt(-2147287036);
                this.f25282a.writeInt((((c2 * 8) + 4) & ViewCompat.MEASURED_SIZE_MASK) | 0);
                this.f25282a.writeInt(c2);
                for (int i = 0; i <= 10; i++) {
                    if (a2.g(i)) {
                        this.f25282a.writeInt(((a2.a(i) & 255) << 24) | (i & ViewCompat.MEASURED_SIZE_MASK));
                        this.f25282a.writeInt(a2.b(i));
                    }
                }
                this.f25282a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            this.f25286e = true;
            com.squareup.okhttp.a.o.a((Closeable) this.f25282a, (Closeable) this.f25284c);
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void flush() throws IOException {
            if (!this.f25286e) {
                this.f25282a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void q() {
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public int t() {
            return 16383;
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void a(int i, ErrorCode errorCode) throws IOException {
            if (!this.f25286e) {
                if (errorCode.spdyRstCode != -1) {
                    this.f25282a.writeInt(-2147287037);
                    this.f25282a.writeInt(8);
                    this.f25282a.writeInt(i & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    this.f25282a.writeInt(errorCode.spdyRstCode);
                    this.f25282a.flush();
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                throw new IOException("closed");
            }
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void a(boolean z, int i, okio.g gVar, int i2) throws IOException {
            a(i, z ? 1 : 0, gVar, i2);
        }

        void a(int i, int i2, okio.g gVar, int i3) throws IOException {
            if (this.f25286e) {
                throw new IOException("closed");
            }
            long j = i3;
            if (j <= 16777215) {
                this.f25282a.writeInt(i & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.f25282a.writeInt(((i2 & 255) << 24) | (16777215 & i3));
                if (i3 > 0) {
                    this.f25282a.a(gVar, j);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + i3);
        }

        private void a(List<q> list) throws IOException {
            this.f25284c.writeInt(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ByteString byteString = list.get(i).f25362h;
                this.f25284c.writeInt(byteString.size());
                this.f25284c.a(byteString);
                ByteString byteString2 = list.get(i).i;
                this.f25284c.writeInt(byteString2.size());
                this.f25284c.a(byteString2);
            }
            this.f25284c.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void a(boolean z, int i, int i2) throws IOException {
            if (this.f25286e) {
                throw new IOException("closed");
            }
            if (z == (this.f25285d != ((i & 1) == 1))) {
                this.f25282a.writeInt(-2147287034);
                this.f25282a.writeInt(4);
                this.f25282a.writeInt(i);
                this.f25282a.flush();
            } else {
                throw new IllegalArgumentException("payload != reply");
            }
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
            if (!this.f25286e) {
                if (errorCode.spdyGoAwayCode != -1) {
                    this.f25282a.writeInt(-2147287033);
                    this.f25282a.writeInt(8);
                    this.f25282a.writeInt(i);
                    this.f25282a.writeInt(errorCode.spdyGoAwayCode);
                    this.f25282a.flush();
                } else {
                    throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
                }
            } else {
                throw new IOException("closed");
            }
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2385b
        public synchronized void a(int i, long j) throws IOException {
            if (this.f25286e) {
                throw new IOException("closed");
            }
            if (j != 0 && j <= 2147483647L) {
                this.f25282a.writeInt(-2147287031);
                this.f25282a.writeInt(8);
                this.f25282a.writeInt(i);
                this.f25282a.writeInt((int) j);
                this.f25282a.flush();
            } else {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + j);
            }
        }
    }

    /* compiled from: Spdy3.java */
    /* loaded from: classes3.dex */
    static final class a implements InterfaceC2384a {

        /* renamed from: a, reason: collision with root package name */
        private final okio.i f25279a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f25280b;

        /* renamed from: c, reason: collision with root package name */
        private final w f25281c;

        a(okio.i iVar, boolean z) {
            this.f25279a = iVar;
            this.f25281c = new w(this.f25279a);
            this.f25280b = z;
        }

        private void b(InterfaceC2384a.InterfaceC0130a interfaceC0130a, int i, int i2) throws IOException {
            interfaceC0130a.a(false, false, this.f25279a.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1, this.f25281c.a(i2 - 4), HeadersMode.SPDY_HEADERS);
        }

        private void c(InterfaceC2384a.InterfaceC0130a interfaceC0130a, int i, int i2) throws IOException {
            if (i2 == 4) {
                int readInt = this.f25279a.readInt();
                interfaceC0130a.a(this.f25280b == ((readInt & 1) == 1), readInt, 0);
            } else {
                a("TYPE_PING length: %d != 4", Integer.valueOf(i2));
                throw null;
            }
        }

        private void d(InterfaceC2384a.InterfaceC0130a interfaceC0130a, int i, int i2) throws IOException {
            if (i2 == 8) {
                int readInt = this.f25279a.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                int readInt2 = this.f25279a.readInt();
                ErrorCode fromSpdy3Rst = ErrorCode.fromSpdy3Rst(readInt2);
                if (fromSpdy3Rst != null) {
                    interfaceC0130a.a(readInt, fromSpdy3Rst);
                    return;
                } else {
                    a("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt2));
                    throw null;
                }
            }
            a("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i2));
            throw null;
        }

        private void e(InterfaceC2384a.InterfaceC0130a interfaceC0130a, int i, int i2) throws IOException {
            int readInt = this.f25279a.readInt();
            if (i2 == (readInt * 8) + 4) {
                A a2 = new A();
                for (int i3 = 0; i3 < readInt; i3++) {
                    int readInt2 = this.f25279a.readInt();
                    a2.a(readInt2 & ViewCompat.MEASURED_SIZE_MASK, ((-16777216) & readInt2) >>> 24, this.f25279a.readInt());
                }
                interfaceC0130a.a((i & 1) != 0, a2);
                return;
            }
            a("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i2), Integer.valueOf(readInt));
            throw null;
        }

        private void f(InterfaceC2384a.InterfaceC0130a interfaceC0130a, int i, int i2) throws IOException {
            interfaceC0130a.a(false, (i & 1) != 0, this.f25279a.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1, this.f25281c.a(i2 - 4), HeadersMode.SPDY_REPLY);
        }

        private void g(InterfaceC2384a.InterfaceC0130a interfaceC0130a, int i, int i2) throws IOException {
            int readInt = this.f25279a.readInt();
            int readInt2 = this.f25279a.readInt();
            int i3 = readInt & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int i4 = readInt2 & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.f25279a.readShort();
            interfaceC0130a.a((i & 2) != 0, (i & 1) != 0, i3, i4, this.f25281c.a(i2 - 10), HeadersMode.SPDY_SYN_STREAM);
        }

        private void h(InterfaceC2384a.InterfaceC0130a interfaceC0130a, int i, int i2) throws IOException {
            if (i2 == 8) {
                int readInt = this.f25279a.readInt();
                int readInt2 = this.f25279a.readInt();
                int i3 = readInt & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                long j = readInt2 & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                if (j != 0) {
                    interfaceC0130a.a(i3, j);
                    return;
                } else {
                    a("windowSizeIncrement was 0", Long.valueOf(j));
                    throw null;
                }
            }
            a("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i2));
            throw null;
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2384a
        public void H() {
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2384a
        public boolean a(InterfaceC2384a.InterfaceC0130a interfaceC0130a) throws IOException {
            try {
                int readInt = this.f25279a.readInt();
                int readInt2 = this.f25279a.readInt();
                boolean z = (Integer.MIN_VALUE & readInt) != 0;
                int i = ((-16777216) & readInt2) >>> 24;
                int i2 = readInt2 & ViewCompat.MEASURED_SIZE_MASK;
                if (!z) {
                    interfaceC0130a.a((i & 1) != 0, readInt & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, this.f25279a, i2);
                    return true;
                }
                int i3 = (2147418112 & readInt) >>> 16;
                int i4 = readInt & SupportMenu.USER_MASK;
                if (i3 == 3) {
                    switch (i4) {
                        case 1:
                            g(interfaceC0130a, i, i2);
                            return true;
                        case 2:
                            f(interfaceC0130a, i, i2);
                            return true;
                        case 3:
                            d(interfaceC0130a, i, i2);
                            return true;
                        case 4:
                            e(interfaceC0130a, i, i2);
                            return true;
                        case 5:
                        default:
                            this.f25279a.skip(i2);
                            return true;
                        case 6:
                            c(interfaceC0130a, i, i2);
                            return true;
                        case 7:
                            a(interfaceC0130a, i, i2);
                            return true;
                        case 8:
                            b(interfaceC0130a, i, i2);
                            return true;
                        case 9:
                            h(interfaceC0130a, i, i2);
                            return true;
                    }
                }
                throw new ProtocolException("version != 3: " + i3);
            } catch (IOException unused) {
                return false;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f25281c.a();
        }

        private void a(InterfaceC2384a.InterfaceC0130a interfaceC0130a, int i, int i2) throws IOException {
            if (i2 == 8) {
                int readInt = this.f25279a.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                int readInt2 = this.f25279a.readInt();
                ErrorCode fromSpdyGoAway = ErrorCode.fromSpdyGoAway(readInt2);
                if (fromSpdyGoAway != null) {
                    interfaceC0130a.a(readInt, fromSpdyGoAway, ByteString.EMPTY);
                    return;
                } else {
                    a("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
                    throw null;
                }
            }
            a("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i2));
            throw null;
        }

        private static IOException a(String str, Object... objArr) throws IOException {
            throw new IOException(String.format(str, objArr));
        }
    }
}
