package io.grpc.okhttp.internal.framed;

import com.facebook.places.model.PlaceFields;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import okio.i;
import okio.s;
import okio.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Hpack.java */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final c[] f27916a = {new c(c.f27912e, ""), new c(c.f27909b, "GET"), new c(c.f27909b, "POST"), new c(c.f27910c, "/"), new c(c.f27910c, "/index.html"), new c(c.f27911d, "http"), new c(c.f27911d, "https"), new c(c.f27908a, "200"), new c(c.f27908a, "204"), new c(c.f27908a, "206"), new c(c.f27908a, "304"), new c(c.f27908a, "400"), new c(c.f27908a, "404"), new c(c.f27908a, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c(PlaceFields.LOCATION, ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};

    /* renamed from: b, reason: collision with root package name */
    private static final Map<ByteString, Integer> f27917b = c();

    /* compiled from: Hpack.java */
    /* loaded from: classes3.dex */
    static final class a {

        /* renamed from: b, reason: collision with root package name */
        private final i f27919b;

        /* renamed from: c, reason: collision with root package name */
        private int f27920c;

        /* renamed from: d, reason: collision with root package name */
        private int f27921d;

        /* renamed from: a, reason: collision with root package name */
        private final List<c> f27918a = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        c[] f27922e = new c[8];

        /* renamed from: f, reason: collision with root package name */
        int f27923f = this.f27922e.length - 1;

        /* renamed from: g, reason: collision with root package name */
        int f27924g = 0;

        /* renamed from: h, reason: collision with root package name */
        int f27925h = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, z zVar) {
            this.f27920c = i;
            this.f27921d = i;
            this.f27919b = s.a(zVar);
        }

        private int b(int i) {
            return this.f27923f + 1 + i;
        }

        private int c(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f27922e.length;
                while (true) {
                    length--;
                    if (length < this.f27923f || i <= 0) {
                        break;
                    }
                    c[] cVarArr = this.f27922e;
                    i -= cVarArr[length].j;
                    this.f27925h -= cVarArr[length].j;
                    this.f27924g--;
                    i2++;
                }
                c[] cVarArr2 = this.f27922e;
                int i3 = this.f27923f;
                System.arraycopy(cVarArr2, i3 + 1, cVarArr2, i3 + 1 + i2, this.f27924g);
                this.f27923f += i2;
            }
            return i2;
        }

        private void d() {
            int i = this.f27921d;
            int i2 = this.f27925h;
            if (i < i2) {
                if (i == 0) {
                    e();
                } else {
                    c(i2 - i);
                }
            }
        }

        private void e() {
            Arrays.fill(this.f27922e, (Object) null);
            this.f27923f = this.f27922e.length - 1;
            this.f27924g = 0;
            this.f27925h = 0;
        }

        private void f(int i) throws IOException {
            if (e(i)) {
                this.f27918a.add(d.f27916a[i]);
                return;
            }
            int b2 = b(i - d.f27916a.length);
            if (b2 >= 0) {
                c[] cVarArr = this.f27922e;
                if (b2 <= cVarArr.length - 1) {
                    this.f27918a.add(cVarArr[b2]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void g(int i) throws IOException {
            a(-1, new c(d(i), b()));
        }

        private void h(int i) throws IOException {
            this.f27918a.add(new c(d(i), b()));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(int i) {
            this.f27920c = i;
            this.f27921d = i;
            d();
        }

        ByteString b() throws IOException {
            int f2 = f();
            boolean z = (f2 & 128) == 128;
            int a2 = a(f2, 127);
            if (z) {
                return ByteString.of(f.a().a(this.f27919b.b(a2)));
            }
            return this.f27919b.e(a2);
        }

        private ByteString d(int i) {
            return e(i) ? d.f27916a[i].f27915h : this.f27922e[b(i - d.f27916a.length)].f27915h;
        }

        private void g() throws IOException {
            ByteString b2 = b();
            d.a(b2);
            a(-1, new c(b2, b()));
        }

        private void h() throws IOException {
            ByteString b2 = b();
            d.a(b2);
            this.f27918a.add(new c(b2, b()));
        }

        public List<c> a() {
            ArrayList arrayList = new ArrayList(this.f27918a);
            this.f27918a.clear();
            return arrayList;
        }

        private boolean e(int i) {
            return i >= 0 && i <= d.f27916a.length - 1;
        }

        private void a(int i, c cVar) {
            this.f27918a.add(cVar);
            int i2 = cVar.j;
            if (i != -1) {
                i2 -= this.f27922e[b(i)].j;
            }
            int i3 = this.f27921d;
            if (i2 > i3) {
                e();
                return;
            }
            int c2 = c((this.f27925h + i2) - i3);
            if (i == -1) {
                int i4 = this.f27924g + 1;
                c[] cVarArr = this.f27922e;
                if (i4 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f27923f = this.f27922e.length - 1;
                    this.f27922e = cVarArr2;
                }
                int i5 = this.f27923f;
                this.f27923f = i5 - 1;
                this.f27922e[i5] = cVar;
                this.f27924g++;
            } else {
                this.f27922e[i + b(i) + c2] = cVar;
            }
            this.f27925h += i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c() throws IOException {
            while (!this.f27919b.l()) {
                int readByte = this.f27919b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    f(a(readByte, 127) - 1);
                } else if (readByte == 64) {
                    g();
                } else if ((readByte & 64) == 64) {
                    g(a(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    this.f27921d = a(readByte, 31);
                    int i = this.f27921d;
                    if (i >= 0 && i <= this.f27920c) {
                        d();
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.f27921d);
                    }
                } else if (readByte != 16 && readByte != 0) {
                    h(a(readByte, 15) - 1);
                } else {
                    h();
                }
            }
        }

        private int f() throws IOException {
            return this.f27919b.readByte() & 255;
        }

        int a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int f2 = f();
                if ((f2 & 128) == 0) {
                    return i2 + (f2 << i4);
                }
                i2 += (f2 & 127) << i4;
                i4 += 7;
            }
        }
    }

    private static Map<ByteString, Integer> c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f27916a.length);
        int i = 0;
        while (true) {
            c[] cVarArr = f27916a;
            if (i < cVarArr.length) {
                if (!linkedHashMap.containsKey(cVarArr[i].f27915h)) {
                    linkedHashMap.put(f27916a[i].f27915h, Integer.valueOf(i));
                }
                i++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    static /* synthetic */ ByteString a(ByteString byteString) throws IOException {
        b(byteString);
        return byteString;
    }

    private static ByteString b(ByteString byteString) throws IOException {
        int size = byteString.size();
        for (int i = 0; i < size; i++) {
            byte b2 = byteString.getByte(i);
            if (b2 >= 65 && b2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    /* compiled from: Hpack.java */
    /* loaded from: classes3.dex */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final okio.g f27926a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(okio.g gVar) {
            this.f27926a = gVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(List<c> list) throws IOException {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ByteString asciiLowercase = list.get(i).f27915h.toAsciiLowercase();
                Integer num = (Integer) d.f27917b.get(asciiLowercase);
                if (num != null) {
                    a(num.intValue() + 1, 15, 0);
                    a(list.get(i).i);
                } else {
                    this.f27926a.writeByte(0);
                    a(asciiLowercase);
                    a(list.get(i).i);
                }
            }
        }

        void a(int i, int i2, int i3) throws IOException {
            if (i < i2) {
                this.f27926a.writeByte(i | i3);
                return;
            }
            this.f27926a.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f27926a.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.f27926a.writeByte(i4);
        }

        void a(ByteString byteString) throws IOException {
            a(byteString.size(), 127, 0);
            this.f27926a.a(byteString);
        }
    }
}
