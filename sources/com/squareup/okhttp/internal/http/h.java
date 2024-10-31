package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.E;
import com.squareup.okhttp.H;
import com.squareup.okhttp.I;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.x;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import okio.y;
import okio.z;

/* compiled from: Http2xStream.java */
/* loaded from: classes3.dex */
public final class h implements o {

    /* renamed from: a, reason: collision with root package name */
    private static final ByteString f25446a = ByteString.encodeUtf8("connection");

    /* renamed from: b, reason: collision with root package name */
    private static final ByteString f25447b = ByteString.encodeUtf8("host");

    /* renamed from: c, reason: collision with root package name */
    private static final ByteString f25448c = ByteString.encodeUtf8("keep-alive");

    /* renamed from: d, reason: collision with root package name */
    private static final ByteString f25449d = ByteString.encodeUtf8("proxy-connection");

    /* renamed from: e, reason: collision with root package name */
    private static final ByteString f25450e = ByteString.encodeUtf8("transfer-encoding");

    /* renamed from: f, reason: collision with root package name */
    private static final ByteString f25451f = ByteString.encodeUtf8("te");

    /* renamed from: g, reason: collision with root package name */
    private static final ByteString f25452g = ByteString.encodeUtf8("encoding");

    /* renamed from: h, reason: collision with root package name */
    private static final ByteString f25453h = ByteString.encodeUtf8("upgrade");
    private static final List<ByteString> i = com.squareup.okhttp.a.o.a(f25446a, f25447b, f25448c, f25449d, f25450e, com.squareup.okhttp.internal.framed.q.f25356b, com.squareup.okhttp.internal.framed.q.f25357c, com.squareup.okhttp.internal.framed.q.f25358d, com.squareup.okhttp.internal.framed.q.f25359e, com.squareup.okhttp.internal.framed.q.f25360f, com.squareup.okhttp.internal.framed.q.f25361g);
    private static final List<ByteString> j = com.squareup.okhttp.a.o.a(f25446a, f25447b, f25448c, f25449d, f25450e);
    private static final List<ByteString> k = com.squareup.okhttp.a.o.a(f25446a, f25447b, f25448c, f25449d, f25451f, f25450e, f25452g, f25453h, com.squareup.okhttp.internal.framed.q.f25356b, com.squareup.okhttp.internal.framed.q.f25357c, com.squareup.okhttp.internal.framed.q.f25358d, com.squareup.okhttp.internal.framed.q.f25359e, com.squareup.okhttp.internal.framed.q.f25360f, com.squareup.okhttp.internal.framed.q.f25361g);
    private static final List<ByteString> l = com.squareup.okhttp.a.o.a(f25446a, f25447b, f25448c, f25449d, f25451f, f25450e, f25452g, f25453h);
    private final w m;
    private final com.squareup.okhttp.internal.framed.j n;
    private m o;
    private com.squareup.okhttp.internal.framed.p p;

    /* compiled from: Http2xStream.java */
    /* loaded from: classes3.dex */
    class a extends okio.l {
        public a(z zVar) {
            super(zVar);
        }

        @Override // okio.l, okio.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            h.this.m.a(h.this);
            super.close();
        }
    }

    public h(w wVar, com.squareup.okhttp.internal.framed.j jVar) {
        this.m = wVar;
        this.n = jVar;
    }

    public static List<com.squareup.okhttp.internal.framed.q> c(E e2) {
        x c2 = e2.c();
        ArrayList arrayList = new ArrayList(c2.b() + 5);
        arrayList.add(new com.squareup.okhttp.internal.framed.q(com.squareup.okhttp.internal.framed.q.f25356b, e2.f()));
        arrayList.add(new com.squareup.okhttp.internal.framed.q(com.squareup.okhttp.internal.framed.q.f25357c, s.a(e2.d())));
        arrayList.add(new com.squareup.okhttp.internal.framed.q(com.squareup.okhttp.internal.framed.q.f25361g, "HTTP/1.1"));
        arrayList.add(new com.squareup.okhttp.internal.framed.q(com.squareup.okhttp.internal.framed.q.f25360f, com.squareup.okhttp.a.o.a(e2.d())));
        arrayList.add(new com.squareup.okhttp.internal.framed.q(com.squareup.okhttp.internal.framed.q.f25358d, e2.d().l()));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int b2 = c2.b();
        for (int i2 = 0; i2 < b2; i2++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(c2.a(i2).toLowerCase(Locale.US));
            if (!i.contains(encodeUtf8)) {
                String b3 = c2.b(i2);
                if (linkedHashSet.add(encodeUtf8)) {
                    arrayList.add(new com.squareup.okhttp.internal.framed.q(encodeUtf8, b3));
                } else {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= arrayList.size()) {
                            break;
                        }
                        if (((com.squareup.okhttp.internal.framed.q) arrayList.get(i3)).f25362h.equals(encodeUtf8)) {
                            arrayList.set(i3, new com.squareup.okhttp.internal.framed.q(encodeUtf8, a(((com.squareup.okhttp.internal.framed.q) arrayList.get(i3)).i.utf8(), b3)));
                            break;
                        }
                        i3++;
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.squareup.okhttp.internal.http.o
    public H.a b() throws IOException {
        if (this.n.b() == Protocol.HTTP_2) {
            return a(this.p.b());
        }
        return b(this.p.b());
    }

    @Override // com.squareup.okhttp.internal.http.o
    public void a(m mVar) {
        this.o = mVar;
    }

    @Override // com.squareup.okhttp.internal.http.o
    public y a(E e2, long j2) throws IOException {
        return this.p.c();
    }

    public static List<com.squareup.okhttp.internal.framed.q> b(E e2) {
        x c2 = e2.c();
        ArrayList arrayList = new ArrayList(c2.b() + 4);
        arrayList.add(new com.squareup.okhttp.internal.framed.q(com.squareup.okhttp.internal.framed.q.f25356b, e2.f()));
        arrayList.add(new com.squareup.okhttp.internal.framed.q(com.squareup.okhttp.internal.framed.q.f25357c, s.a(e2.d())));
        arrayList.add(new com.squareup.okhttp.internal.framed.q(com.squareup.okhttp.internal.framed.q.f25359e, com.squareup.okhttp.a.o.a(e2.d())));
        arrayList.add(new com.squareup.okhttp.internal.framed.q(com.squareup.okhttp.internal.framed.q.f25358d, e2.d().l()));
        int b2 = c2.b();
        for (int i2 = 0; i2 < b2; i2++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(c2.a(i2).toLowerCase(Locale.US));
            if (!k.contains(encodeUtf8)) {
                arrayList.add(new com.squareup.okhttp.internal.framed.q(encodeUtf8, c2.b(i2)));
            }
        }
        return arrayList;
    }

    @Override // com.squareup.okhttp.internal.http.o
    public void a(E e2) throws IOException {
        List<com.squareup.okhttp.internal.framed.q> c2;
        if (this.p != null) {
            return;
        }
        this.o.h();
        boolean a2 = this.o.a(e2);
        if (this.n.b() == Protocol.HTTP_2) {
            c2 = b(e2);
        } else {
            c2 = c(e2);
        }
        this.p = this.n.a(c2, a2, true);
        this.p.g().a(this.o.f25465b.p(), TimeUnit.MILLISECONDS);
        this.p.i().a(this.o.f25465b.t(), TimeUnit.MILLISECONDS);
    }

    @Override // com.squareup.okhttp.internal.http.o
    public void a(t tVar) throws IOException {
        tVar.a(this.p.c());
    }

    public static H.a b(List<com.squareup.okhttp.internal.framed.q> list) throws IOException {
        x.a aVar = new x.a();
        int size = list.size();
        String str = "HTTP/1.1";
        String str2 = null;
        int i2 = 0;
        while (i2 < size) {
            ByteString byteString = list.get(i2).f25362h;
            String utf8 = list.get(i2).i.utf8();
            String str3 = str;
            String str4 = str2;
            int i3 = 0;
            while (i3 < utf8.length()) {
                int indexOf = utf8.indexOf(0, i3);
                if (indexOf == -1) {
                    indexOf = utf8.length();
                }
                String substring = utf8.substring(i3, indexOf);
                if (byteString.equals(com.squareup.okhttp.internal.framed.q.f25355a)) {
                    str4 = substring;
                } else if (byteString.equals(com.squareup.okhttp.internal.framed.q.f25361g)) {
                    str3 = substring;
                } else if (!j.contains(byteString)) {
                    aVar.a(byteString.utf8(), substring);
                }
                i3 = indexOf + 1;
            }
            i2++;
            str2 = str4;
            str = str3;
        }
        if (str2 != null) {
            v a2 = v.a(str + " " + str2);
            H.a aVar2 = new H.a();
            aVar2.a(Protocol.SPDY_3);
            aVar2.a(a2.f25496b);
            aVar2.a(a2.f25497c);
            aVar2.a(aVar.a());
            return aVar2;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // com.squareup.okhttp.internal.http.o
    public void a() throws IOException {
        this.p.c().close();
    }

    private static String a(String str, String str2) {
        return str + (char) 0 + str2;
    }

    public static H.a a(List<com.squareup.okhttp.internal.framed.q> list) throws IOException {
        x.a aVar = new x.a();
        int size = list.size();
        String str = null;
        for (int i2 = 0; i2 < size; i2++) {
            ByteString byteString = list.get(i2).f25362h;
            String utf8 = list.get(i2).i.utf8();
            if (byteString.equals(com.squareup.okhttp.internal.framed.q.f25355a)) {
                str = utf8;
            } else if (!l.contains(byteString)) {
                aVar.a(byteString.utf8(), utf8);
            }
        }
        if (str != null) {
            v a2 = v.a("HTTP/1.1 " + str);
            H.a aVar2 = new H.a();
            aVar2.a(Protocol.HTTP_2);
            aVar2.a(a2.f25496b);
            aVar2.a(a2.f25497c);
            aVar2.a(aVar.a());
            return aVar2;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // com.squareup.okhttp.internal.http.o
    public I a(H h2) throws IOException {
        return new r(h2.g(), okio.s.a(new a(this.p.d())));
    }
}
