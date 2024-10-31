package okhttp3.internal.http2;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.places.model.PlaceFields;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import okio.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Hpack.java */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    static final okhttp3.internal.http2.a[] f29031a = {new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f29028f, ""), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f29025c, "GET"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f29025c, "POST"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f29026d, "/"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f29026d, "/index.html"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f29027e, "http"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f29027e, "https"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f29024b, "200"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f29024b, "204"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f29024b, "206"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f29024b, "304"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f29024b, "400"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f29024b, "404"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f29024b, "500"), new okhttp3.internal.http2.a("accept-charset", ""), new okhttp3.internal.http2.a("accept-encoding", "gzip, deflate"), new okhttp3.internal.http2.a("accept-language", ""), new okhttp3.internal.http2.a("accept-ranges", ""), new okhttp3.internal.http2.a("accept", ""), new okhttp3.internal.http2.a("access-control-allow-origin", ""), new okhttp3.internal.http2.a("age", ""), new okhttp3.internal.http2.a("allow", ""), new okhttp3.internal.http2.a("authorization", ""), new okhttp3.internal.http2.a("cache-control", ""), new okhttp3.internal.http2.a("content-disposition", ""), new okhttp3.internal.http2.a("content-encoding", ""), new okhttp3.internal.http2.a("content-language", ""), new okhttp3.internal.http2.a("content-length", ""), new okhttp3.internal.http2.a("content-location", ""), new okhttp3.internal.http2.a("content-range", ""), new okhttp3.internal.http2.a("content-type", ""), new okhttp3.internal.http2.a("cookie", ""), new okhttp3.internal.http2.a("date", ""), new okhttp3.internal.http2.a("etag", ""), new okhttp3.internal.http2.a("expect", ""), new okhttp3.internal.http2.a("expires", ""), new okhttp3.internal.http2.a("from", ""), new okhttp3.internal.http2.a("host", ""), new okhttp3.internal.http2.a("if-match", ""), new okhttp3.internal.http2.a("if-modified-since", ""), new okhttp3.internal.http2.a("if-none-match", ""), new okhttp3.internal.http2.a("if-range", ""), new okhttp3.internal.http2.a("if-unmodified-since", ""), new okhttp3.internal.http2.a("last-modified", ""), new okhttp3.internal.http2.a("link", ""), new okhttp3.internal.http2.a(PlaceFields.LOCATION, ""), new okhttp3.internal.http2.a("max-forwards", ""), new okhttp3.internal.http2.a("proxy-authenticate", ""), new okhttp3.internal.http2.a("proxy-authorization", ""), new okhttp3.internal.http2.a("range", ""), new okhttp3.internal.http2.a("referer", ""), new okhttp3.internal.http2.a("refresh", ""), new okhttp3.internal.http2.a("retry-after", ""), new okhttp3.internal.http2.a("server", ""), new okhttp3.internal.http2.a("set-cookie", ""), new okhttp3.internal.http2.a("strict-transport-security", ""), new okhttp3.internal.http2.a("transfer-encoding", ""), new okhttp3.internal.http2.a("user-agent", ""), new okhttp3.internal.http2.a("vary", ""), new okhttp3.internal.http2.a("via", ""), new okhttp3.internal.http2.a("www-authenticate", "")};

    /* renamed from: b, reason: collision with root package name */
    static final Map<ByteString, Integer> f29032b = a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Hpack.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<okhttp3.internal.http2.a> f29033a;

        /* renamed from: b, reason: collision with root package name */
        private final okio.i f29034b;

        /* renamed from: c, reason: collision with root package name */
        private final int f29035c;

        /* renamed from: d, reason: collision with root package name */
        private int f29036d;

        /* renamed from: e, reason: collision with root package name */
        okhttp3.internal.http2.a[] f29037e;

        /* renamed from: f, reason: collision with root package name */
        int f29038f;

        /* renamed from: g, reason: collision with root package name */
        int f29039g;

        /* renamed from: h, reason: collision with root package name */
        int f29040h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, z zVar) {
            this(i, i, zVar);
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f29037e.length;
                while (true) {
                    length--;
                    if (length < this.f29038f || i <= 0) {
                        break;
                    }
                    okhttp3.internal.http2.a[] aVarArr = this.f29037e;
                    i -= aVarArr[length].i;
                    this.f29040h -= aVarArr[length].i;
                    this.f29039g--;
                    i2++;
                }
                okhttp3.internal.http2.a[] aVarArr2 = this.f29037e;
                int i3 = this.f29038f;
                System.arraycopy(aVarArr2, i3 + 1, aVarArr2, i3 + 1 + i2, this.f29039g);
                this.f29038f += i2;
            }
            return i2;
        }

        private void d() {
            int i = this.f29036d;
            int i2 = this.f29040h;
            if (i < i2) {
                if (i == 0) {
                    e();
                } else {
                    b(i2 - i);
                }
            }
        }

        private void e() {
            Arrays.fill(this.f29037e, (Object) null);
            this.f29038f = this.f29037e.length - 1;
            this.f29039g = 0;
            this.f29040h = 0;
        }

        private void f(int i) throws IOException {
            a(-1, new okhttp3.internal.http2.a(c(i), b()));
        }

        private void g(int i) throws IOException {
            this.f29033a.add(new okhttp3.internal.http2.a(c(i), b()));
        }

        private void h() throws IOException {
            ByteString b2 = b();
            b.a(b2);
            this.f29033a.add(new okhttp3.internal.http2.a(b2, b()));
        }

        public List<okhttp3.internal.http2.a> a() {
            ArrayList arrayList = new ArrayList(this.f29033a);
            this.f29033a.clear();
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c() throws IOException {
            while (!this.f29034b.l()) {
                int readByte = this.f29034b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    e(a(readByte, 127) - 1);
                } else if (readByte == 64) {
                    g();
                } else if ((readByte & 64) == 64) {
                    f(a(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    this.f29036d = a(readByte, 31);
                    int i = this.f29036d;
                    if (i >= 0 && i <= this.f29035c) {
                        d();
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.f29036d);
                    }
                } else if (readByte != 16 && readByte != 0) {
                    g(a(readByte, 15) - 1);
                } else {
                    h();
                }
            }
        }

        a(int i, int i2, z zVar) {
            this.f29033a = new ArrayList();
            this.f29037e = new okhttp3.internal.http2.a[8];
            this.f29038f = this.f29037e.length - 1;
            this.f29039g = 0;
            this.f29040h = 0;
            this.f29035c = i;
            this.f29036d = i2;
            this.f29034b = okio.s.a(zVar);
        }

        private int a(int i) {
            return this.f29038f + 1 + i;
        }

        private void a(int i, okhttp3.internal.http2.a aVar) {
            this.f29033a.add(aVar);
            int i2 = aVar.i;
            if (i != -1) {
                i2 -= this.f29037e[a(i)].i;
            }
            int i3 = this.f29036d;
            if (i2 > i3) {
                e();
                return;
            }
            int b2 = b((this.f29040h + i2) - i3);
            if (i == -1) {
                int i4 = this.f29039g + 1;
                okhttp3.internal.http2.a[] aVarArr = this.f29037e;
                if (i4 > aVarArr.length) {
                    okhttp3.internal.http2.a[] aVarArr2 = new okhttp3.internal.http2.a[aVarArr.length * 2];
                    System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                    this.f29038f = this.f29037e.length - 1;
                    this.f29037e = aVarArr2;
                }
                int i5 = this.f29038f;
                this.f29038f = i5 - 1;
                this.f29037e[i5] = aVar;
                this.f29039g++;
            } else {
                this.f29037e[i + a(i) + b2] = aVar;
            }
            this.f29040h += i2;
        }

        private boolean d(int i) {
            return i >= 0 && i <= b.f29031a.length - 1;
        }

        private int f() throws IOException {
            return this.f29034b.readByte() & 255;
        }

        private void g() throws IOException {
            ByteString b2 = b();
            b.a(b2);
            a(-1, new okhttp3.internal.http2.a(b2, b()));
        }

        private void e(int i) throws IOException {
            if (d(i)) {
                this.f29033a.add(b.f29031a[i]);
                return;
            }
            int a2 = a(i - b.f29031a.length);
            if (a2 >= 0) {
                okhttp3.internal.http2.a[] aVarArr = this.f29037e;
                if (a2 < aVarArr.length) {
                    this.f29033a.add(aVarArr[a2]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        ByteString b() throws IOException {
            int f2 = f();
            boolean z = (f2 & 128) == 128;
            int a2 = a(f2, 127);
            if (z) {
                return ByteString.of(s.a().a(this.f29034b.b(a2)));
            }
            return this.f29034b.e(a2);
        }

        private ByteString c(int i) throws IOException {
            if (d(i)) {
                return b.f29031a[i].f29029g;
            }
            int a2 = a(i - b.f29031a.length);
            if (a2 >= 0) {
                okhttp3.internal.http2.a[] aVarArr = this.f29037e;
                if (a2 < aVarArr.length) {
                    return aVarArr[a2].f29029g;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Hpack.java */
    /* renamed from: okhttp3.internal.http2.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0169b {

        /* renamed from: a, reason: collision with root package name */
        private final okio.g f29041a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f29042b;

        /* renamed from: c, reason: collision with root package name */
        private int f29043c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f29044d;

        /* renamed from: e, reason: collision with root package name */
        int f29045e;

        /* renamed from: f, reason: collision with root package name */
        int f29046f;

        /* renamed from: g, reason: collision with root package name */
        okhttp3.internal.http2.a[] f29047g;

        /* renamed from: h, reason: collision with root package name */
        int f29048h;
        int i;
        int j;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0169b(okio.g gVar) {
            this(4096, true, gVar);
        }

        private void a(okhttp3.internal.http2.a aVar) {
            int i = aVar.i;
            int i2 = this.f29046f;
            if (i > i2) {
                b();
                return;
            }
            b((this.j + i) - i2);
            int i3 = this.i + 1;
            okhttp3.internal.http2.a[] aVarArr = this.f29047g;
            if (i3 > aVarArr.length) {
                okhttp3.internal.http2.a[] aVarArr2 = new okhttp3.internal.http2.a[aVarArr.length * 2];
                System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                this.f29048h = this.f29047g.length - 1;
                this.f29047g = aVarArr2;
            }
            int i4 = this.f29048h;
            this.f29048h = i4 - 1;
            this.f29047g[i4] = aVar;
            this.i++;
            this.j += i;
        }

        private void b() {
            Arrays.fill(this.f29047g, (Object) null);
            this.f29048h = this.f29047g.length - 1;
            this.i = 0;
            this.j = 0;
        }

        C0169b(int i, boolean z, okio.g gVar) {
            this.f29043c = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.f29047g = new okhttp3.internal.http2.a[8];
            this.f29048h = this.f29047g.length - 1;
            this.i = 0;
            this.j = 0;
            this.f29045e = i;
            this.f29046f = i;
            this.f29042b = z;
            this.f29041a = gVar;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f29047g.length;
                while (true) {
                    length--;
                    if (length < this.f29048h || i <= 0) {
                        break;
                    }
                    okhttp3.internal.http2.a[] aVarArr = this.f29047g;
                    i -= aVarArr[length].i;
                    this.j -= aVarArr[length].i;
                    this.i--;
                    i2++;
                }
                okhttp3.internal.http2.a[] aVarArr2 = this.f29047g;
                int i3 = this.f29048h;
                System.arraycopy(aVarArr2, i3 + 1, aVarArr2, i3 + 1 + i2, this.i);
                okhttp3.internal.http2.a[] aVarArr3 = this.f29047g;
                int i4 = this.f29048h;
                Arrays.fill(aVarArr3, i4 + 1, i4 + 1 + i2, (Object) null);
                this.f29048h += i2;
            }
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(List<okhttp3.internal.http2.a> list) throws IOException {
            int i;
            int i2;
            if (this.f29044d) {
                int i3 = this.f29043c;
                if (i3 < this.f29046f) {
                    a(i3, 31, 32);
                }
                this.f29044d = false;
                this.f29043c = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                a(this.f29046f, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                okhttp3.internal.http2.a aVar = list.get(i4);
                ByteString asciiLowercase = aVar.f29029g.toAsciiLowercase();
                ByteString byteString = aVar.f29030h;
                Integer num = b.f29032b.get(asciiLowercase);
                if (num != null) {
                    i = num.intValue() + 1;
                    if (i > 1 && i < 8) {
                        if (okhttp3.a.e.a(b.f29031a[i - 1].f29030h, byteString)) {
                            i2 = i;
                        } else if (okhttp3.a.e.a(b.f29031a[i].f29030h, byteString)) {
                            i2 = i;
                            i++;
                        }
                    }
                    i2 = i;
                    i = -1;
                } else {
                    i = -1;
                    i2 = -1;
                }
                if (i == -1) {
                    int i5 = this.f29048h + 1;
                    int length = this.f29047g.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        if (okhttp3.a.e.a(this.f29047g[i5].f29029g, asciiLowercase)) {
                            if (okhttp3.a.e.a(this.f29047g[i5].f29030h, byteString)) {
                                i = b.f29031a.length + (i5 - this.f29048h);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i5 - this.f29048h) + b.f29031a.length;
                            }
                        }
                        i5++;
                    }
                }
                if (i != -1) {
                    a(i, 127, 128);
                } else if (i2 == -1) {
                    this.f29041a.writeByte(64);
                    a(asciiLowercase);
                    a(byteString);
                    a(aVar);
                } else if (asciiLowercase.startsWith(okhttp3.internal.http2.a.f29023a) && !okhttp3.internal.http2.a.f29028f.equals(asciiLowercase)) {
                    a(i2, 15, 0);
                    a(byteString);
                } else {
                    a(i2, 63, 64);
                    a(byteString);
                    a(aVar);
                }
            }
        }

        void a(int i, int i2, int i3) {
            if (i < i2) {
                this.f29041a.writeByte(i | i3);
                return;
            }
            this.f29041a.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f29041a.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.f29041a.writeByte(i4);
        }

        void a(ByteString byteString) throws IOException {
            if (this.f29042b && s.a().a(byteString) < byteString.size()) {
                okio.g gVar = new okio.g();
                s.a().a(byteString, gVar);
                ByteString q = gVar.q();
                a(q.size(), 127, 128);
                this.f29041a.a(q);
                return;
            }
            a(byteString.size(), 127, 0);
            this.f29041a.a(byteString);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(int i) {
            this.f29045e = i;
            int min = Math.min(i, 16384);
            int i2 = this.f29046f;
            if (i2 == min) {
                return;
            }
            if (min < i2) {
                this.f29043c = Math.min(this.f29043c, min);
            }
            this.f29044d = true;
            this.f29046f = min;
            a();
        }

        private void a() {
            int i = this.f29046f;
            int i2 = this.j;
            if (i < i2) {
                if (i == 0) {
                    b();
                } else {
                    b(i2 - i);
                }
            }
        }
    }

    private static Map<ByteString, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f29031a.length);
        int i = 0;
        while (true) {
            okhttp3.internal.http2.a[] aVarArr = f29031a;
            if (i < aVarArr.length) {
                if (!linkedHashMap.containsKey(aVarArr[i].f29029g)) {
                    linkedHashMap.put(f29031a[i].f29029g, Integer.valueOf(i));
                }
                i++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    static ByteString a(ByteString byteString) throws IOException {
        int size = byteString.size();
        for (int i = 0; i < size; i++) {
            byte b2 = byteString.getByte(i);
            if (b2 >= 65 && b2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }
}
