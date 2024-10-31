package com.squareup.okhttp.internal.framed;

import com.facebook.places.model.PlaceFields;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Hpack.java */
/* loaded from: classes3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private static final q[] f25363a = {new q(q.f25359e, ""), new q(q.f25356b, "GET"), new q(q.f25356b, "POST"), new q(q.f25357c, "/"), new q(q.f25357c, "/index.html"), new q(q.f25358d, "http"), new q(q.f25358d, "https"), new q(q.f25355a, "200"), new q(q.f25355a, "204"), new q(q.f25355a, "206"), new q(q.f25355a, "304"), new q(q.f25355a, "400"), new q(q.f25355a, "404"), new q(q.f25355a, "500"), new q("accept-charset", ""), new q("accept-encoding", "gzip, deflate"), new q("accept-language", ""), new q("accept-ranges", ""), new q("accept", ""), new q("access-control-allow-origin", ""), new q("age", ""), new q("allow", ""), new q("authorization", ""), new q("cache-control", ""), new q("content-disposition", ""), new q("content-encoding", ""), new q("content-language", ""), new q("content-length", ""), new q("content-location", ""), new q("content-range", ""), new q("content-type", ""), new q("cookie", ""), new q("date", ""), new q("etag", ""), new q("expect", ""), new q("expires", ""), new q("from", ""), new q("host", ""), new q("if-match", ""), new q("if-modified-since", ""), new q("if-none-match", ""), new q("if-range", ""), new q("if-unmodified-since", ""), new q("last-modified", ""), new q("link", ""), new q(PlaceFields.LOCATION, ""), new q("max-forwards", ""), new q("proxy-authenticate", ""), new q("proxy-authorization", ""), new q("range", ""), new q("referer", ""), new q("refresh", ""), new q("retry-after", ""), new q("server", ""), new q("set-cookie", ""), new q("strict-transport-security", ""), new q("transfer-encoding", ""), new q("user-agent", ""), new q("vary", ""), new q("via", ""), new q("www-authenticate", "")};

    /* renamed from: b, reason: collision with root package name */
    private static final Map<ByteString, Integer> f25364b = c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Hpack.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        private final okio.i f25366b;

        /* renamed from: c, reason: collision with root package name */
        private int f25367c;

        /* renamed from: d, reason: collision with root package name */
        private int f25368d;

        /* renamed from: a, reason: collision with root package name */
        private final List<q> f25365a = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        q[] f25369e = new q[8];

        /* renamed from: f, reason: collision with root package name */
        int f25370f = this.f25369e.length - 1;

        /* renamed from: g, reason: collision with root package name */
        int f25371g = 0;

        /* renamed from: h, reason: collision with root package name */
        int f25372h = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, okio.z zVar) {
            this.f25367c = i;
            this.f25368d = i;
            this.f25366b = okio.s.a(zVar);
        }

        private int b(int i) {
            return this.f25370f + 1 + i;
        }

        private int c(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f25369e.length;
                while (true) {
                    length--;
                    if (length < this.f25370f || i <= 0) {
                        break;
                    }
                    q[] qVarArr = this.f25369e;
                    i -= qVarArr[length].j;
                    this.f25372h -= qVarArr[length].j;
                    this.f25371g--;
                    i2++;
                }
                q[] qVarArr2 = this.f25369e;
                int i3 = this.f25370f;
                System.arraycopy(qVarArr2, i3 + 1, qVarArr2, i3 + 1 + i2, this.f25371g);
                this.f25370f += i2;
            }
            return i2;
        }

        private void d() {
            int i = this.f25368d;
            int i2 = this.f25372h;
            if (i < i2) {
                if (i == 0) {
                    e();
                } else {
                    c(i2 - i);
                }
            }
        }

        private void e() {
            this.f25365a.clear();
            Arrays.fill(this.f25369e, (Object) null);
            this.f25370f = this.f25369e.length - 1;
            this.f25371g = 0;
            this.f25372h = 0;
        }

        private void f(int i) throws IOException {
            if (e(i)) {
                this.f25365a.add(r.f25363a[i]);
                return;
            }
            int b2 = b(i - r.f25363a.length);
            if (b2 >= 0) {
                q[] qVarArr = this.f25369e;
                if (b2 <= qVarArr.length - 1) {
                    this.f25365a.add(qVarArr[b2]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void g(int i) throws IOException {
            a(-1, new q(d(i), b()));
        }

        private void h(int i) throws IOException {
            this.f25365a.add(new q(d(i), b()));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(int i) {
            this.f25367c = i;
            this.f25368d = i;
            d();
        }

        ByteString b() throws IOException {
            int f2 = f();
            boolean z = (f2 & 128) == 128;
            int a2 = a(f2, 127);
            if (z) {
                return ByteString.of(t.a().a(this.f25366b.b(a2)));
            }
            return this.f25366b.e(a2);
        }

        private ByteString d(int i) {
            return e(i) ? r.f25363a[i].f25362h : this.f25369e[b(i - r.f25363a.length)].f25362h;
        }

        private void g() throws IOException {
            ByteString b2 = b();
            r.a(b2);
            a(-1, new q(b2, b()));
        }

        private void h() throws IOException {
            ByteString b2 = b();
            r.a(b2);
            this.f25365a.add(new q(b2, b()));
        }

        public List<q> a() {
            ArrayList arrayList = new ArrayList(this.f25365a);
            this.f25365a.clear();
            return arrayList;
        }

        private void a(int i, q qVar) {
            this.f25365a.add(qVar);
            int i2 = qVar.j;
            if (i != -1) {
                i2 -= this.f25369e[b(i)].j;
            }
            int i3 = this.f25368d;
            if (i2 > i3) {
                e();
                return;
            }
            int c2 = c((this.f25372h + i2) - i3);
            if (i == -1) {
                int i4 = this.f25371g + 1;
                q[] qVarArr = this.f25369e;
                if (i4 > qVarArr.length) {
                    q[] qVarArr2 = new q[qVarArr.length * 2];
                    System.arraycopy(qVarArr, 0, qVarArr2, qVarArr.length, qVarArr.length);
                    this.f25370f = this.f25369e.length - 1;
                    this.f25369e = qVarArr2;
                }
                int i5 = this.f25370f;
                this.f25370f = i5 - 1;
                this.f25369e[i5] = qVar;
                this.f25371g++;
            } else {
                this.f25369e[i + b(i) + c2] = qVar;
            }
            this.f25372h += i2;
        }

        private boolean e(int i) {
            return i >= 0 && i <= r.f25363a.length - 1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c() throws IOException {
            while (!this.f25366b.l()) {
                int readByte = this.f25366b.readByte() & 255;
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
                    this.f25368d = a(readByte, 31);
                    int i = this.f25368d;
                    if (i >= 0 && i <= this.f25367c) {
                        d();
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.f25368d);
                    }
                } else if (readByte != 16 && readByte != 0) {
                    h(a(readByte, 15) - 1);
                } else {
                    h();
                }
            }
        }

        private int f() throws IOException {
            return this.f25366b.readByte() & 255;
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
        LinkedHashMap linkedHashMap = new LinkedHashMap(f25363a.length);
        int i = 0;
        while (true) {
            q[] qVarArr = f25363a;
            if (i < qVarArr.length) {
                if (!linkedHashMap.containsKey(qVarArr[i].f25362h)) {
                    linkedHashMap.put(f25363a[i].f25362h, Integer.valueOf(i));
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Hpack.java */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final okio.g f25373a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(okio.g gVar) {
            this.f25373a = gVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(List<q> list) throws IOException {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ByteString asciiLowercase = list.get(i).f25362h.toAsciiLowercase();
                Integer num = (Integer) r.f25364b.get(asciiLowercase);
                if (num != null) {
                    a(num.intValue() + 1, 15, 0);
                    a(list.get(i).i);
                } else {
                    this.f25373a.writeByte(0);
                    a(asciiLowercase);
                    a(list.get(i).i);
                }
            }
        }

        void a(int i, int i2, int i3) throws IOException {
            if (i < i2) {
                this.f25373a.writeByte(i | i3);
                return;
            }
            this.f25373a.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f25373a.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.f25373a.writeByte(i4);
        }

        void a(ByteString byteString) throws IOException {
            a(byteString.size(), 127, 0);
            this.f25373a.a(byteString);
        }
    }
}
