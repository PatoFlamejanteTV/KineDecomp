package com.squareup.okhttp;

import com.facebook.stetho.server.http.HttpHeaders;
import com.squareup.okhttp.E;
import com.squareup.okhttp.H;
import com.squareup.okhttp.a.f;
import com.squareup.okhttp.x;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okio.ByteString;

/* compiled from: Cache.java */
/* renamed from: com.squareup.okhttp.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2379e {

    /* renamed from: a, reason: collision with root package name */
    final com.squareup.okhttp.a.i f25224a;

    /* renamed from: b, reason: collision with root package name */
    private final com.squareup.okhttp.a.f f25225b;

    /* renamed from: c, reason: collision with root package name */
    private int f25226c;

    /* renamed from: d, reason: collision with root package name */
    private int f25227d;

    /* renamed from: e, reason: collision with root package name */
    private int f25228e;

    /* renamed from: f, reason: collision with root package name */
    private int f25229f;

    /* renamed from: g, reason: collision with root package name */
    private int f25230g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cache.java */
    /* renamed from: com.squareup.okhttp.e$a */
    /* loaded from: classes3.dex */
    public final class a implements com.squareup.okhttp.internal.http.b {

        /* renamed from: a, reason: collision with root package name */
        private final f.a f25231a;

        /* renamed from: b, reason: collision with root package name */
        private okio.y f25232b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f25233c;

        /* renamed from: d, reason: collision with root package name */
        private okio.y f25234d;

        public a(f.a aVar) throws IOException {
            this.f25231a = aVar;
            this.f25232b = aVar.a(1);
            this.f25234d = new C2378d(this, this.f25232b, C2379e.this, aVar);
        }

        @Override // com.squareup.okhttp.internal.http.b
        public void abort() {
            synchronized (C2379e.this) {
                if (this.f25233c) {
                    return;
                }
                this.f25233c = true;
                C2379e.c(C2379e.this);
                com.squareup.okhttp.a.o.a(this.f25232b);
                try {
                    this.f25231a.a();
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.squareup.okhttp.internal.http.b
        public okio.y body() {
            return this.f25234d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cache.java */
    /* renamed from: com.squareup.okhttp.e$b */
    /* loaded from: classes3.dex */
    public static class b extends I {

        /* renamed from: a, reason: collision with root package name */
        private final f.c f25236a;

        /* renamed from: b, reason: collision with root package name */
        private final okio.i f25237b;

        /* renamed from: c, reason: collision with root package name */
        private final String f25238c;

        /* renamed from: d, reason: collision with root package name */
        private final String f25239d;

        public b(f.c cVar, String str, String str2) {
            this.f25236a = cVar;
            this.f25238c = str;
            this.f25239d = str2;
            this.f25237b = okio.s.a(new C2380f(this, cVar.a(1), cVar));
        }

        @Override // com.squareup.okhttp.I
        public long b() {
            try {
                if (this.f25239d != null) {
                    return Long.parseLong(this.f25239d);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // com.squareup.okhttp.I
        public okio.i c() {
            return this.f25237b;
        }
    }

    public C2379e(File file, long j) {
        this(file, j, com.squareup.okhttp.a.a.b.f25139a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int b(C2379e c2379e) {
        int i = c2379e.f25226c;
        c2379e.f25226c = i + 1;
        return i;
    }

    static /* synthetic */ int c(C2379e c2379e) {
        int i = c2379e.f25227d;
        c2379e.f25227d = i + 1;
        return i;
    }

    C2379e(File file, long j, com.squareup.okhttp.a.a.b bVar) {
        this.f25224a = new C2377c(this);
        this.f25225b = com.squareup.okhttp.a.f.a(bVar, file, 201105, 2, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(E e2) throws IOException {
        this.f25225b.g(c(e2));
    }

    private static String c(E e2) {
        return com.squareup.okhttp.a.o.a(e2.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(okio.i iVar) throws IOException {
        try {
            long m = iVar.m();
            String h2 = iVar.h();
            if (m >= 0 && m <= 2147483647L && h2.isEmpty()) {
                return (int) m;
            }
            throw new IOException("expected an int but was \"" + m + h2 + "\"");
        } catch (NumberFormatException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public H a(E e2) {
        try {
            f.c f2 = this.f25225b.f(c(e2));
            if (f2 == null) {
                return null;
            }
            try {
                c cVar = new c(f2.a(0));
                H a2 = cVar.a(e2, f2);
                if (cVar.a(e2, a2)) {
                    return a2;
                }
                com.squareup.okhttp.a.o.a(a2.a());
                return null;
            } catch (IOException unused) {
                com.squareup.okhttp.a.o.a(f2);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.squareup.okhttp.internal.http.b a(H h2) throws IOException {
        f.a aVar;
        String f2 = h2.l().f();
        if (com.squareup.okhttp.internal.http.n.a(h2.l().f())) {
            try {
                b(h2.l());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!f2.equals("GET") || com.squareup.okhttp.internal.http.q.b(h2)) {
            return null;
        }
        c cVar = new c(h2);
        try {
            aVar = this.f25225b.e(c(h2.l()));
            if (aVar == null) {
                return null;
            }
            try {
                cVar.a(aVar);
                return new a(aVar);
            } catch (IOException unused2) {
                a(aVar);
                return null;
            }
        } catch (IOException unused3) {
            aVar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(H h2, H h3) {
        f.a aVar;
        c cVar = new c(h3);
        try {
            aVar = ((b) h2.a()).f25236a.a();
            if (aVar != null) {
                try {
                    cVar.a(aVar);
                    aVar.b();
                } catch (IOException unused) {
                    a(aVar);
                }
            }
        } catch (IOException unused2) {
            aVar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cache.java */
    /* renamed from: com.squareup.okhttp.e$c */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final String f25240a;

        /* renamed from: b, reason: collision with root package name */
        private final x f25241b;

        /* renamed from: c, reason: collision with root package name */
        private final String f25242c;

        /* renamed from: d, reason: collision with root package name */
        private final Protocol f25243d;

        /* renamed from: e, reason: collision with root package name */
        private final int f25244e;

        /* renamed from: f, reason: collision with root package name */
        private final String f25245f;

        /* renamed from: g, reason: collision with root package name */
        private final x f25246g;

        /* renamed from: h, reason: collision with root package name */
        private final v f25247h;

        public c(okio.z zVar) throws IOException {
            try {
                okio.i a2 = okio.s.a(zVar);
                this.f25240a = a2.h();
                this.f25242c = a2.h();
                x.a aVar = new x.a();
                int b2 = C2379e.b(a2);
                for (int i = 0; i < b2; i++) {
                    aVar.a(a2.h());
                }
                this.f25241b = aVar.a();
                com.squareup.okhttp.internal.http.v a3 = com.squareup.okhttp.internal.http.v.a(a2.h());
                this.f25243d = a3.f25495a;
                this.f25244e = a3.f25496b;
                this.f25245f = a3.f25497c;
                x.a aVar2 = new x.a();
                int b3 = C2379e.b(a2);
                for (int i2 = 0; i2 < b3; i2++) {
                    aVar2.a(a2.h());
                }
                this.f25246g = aVar2.a();
                if (a()) {
                    String h2 = a2.h();
                    if (h2.length() <= 0) {
                        this.f25247h = v.a(a2.h(), a(a2), a(a2));
                    } else {
                        throw new IOException("expected \"\" but was \"" + h2 + "\"");
                    }
                } else {
                    this.f25247h = null;
                }
            } finally {
                zVar.close();
            }
        }

        public void a(f.a aVar) throws IOException {
            okio.h a2 = okio.s.a(aVar.a(0));
            a2.a(this.f25240a);
            a2.writeByte(10);
            a2.a(this.f25242c);
            a2.writeByte(10);
            a2.d(this.f25241b.b());
            a2.writeByte(10);
            int b2 = this.f25241b.b();
            for (int i = 0; i < b2; i++) {
                a2.a(this.f25241b.a(i));
                a2.a(": ");
                a2.a(this.f25241b.b(i));
                a2.writeByte(10);
            }
            a2.a(new com.squareup.okhttp.internal.http.v(this.f25243d, this.f25244e, this.f25245f).toString());
            a2.writeByte(10);
            a2.d(this.f25246g.b());
            a2.writeByte(10);
            int b3 = this.f25246g.b();
            for (int i2 = 0; i2 < b3; i2++) {
                a2.a(this.f25246g.a(i2));
                a2.a(": ");
                a2.a(this.f25246g.b(i2));
                a2.writeByte(10);
            }
            if (a()) {
                a2.writeByte(10);
                a2.a(this.f25247h.a());
                a2.writeByte(10);
                a(a2, this.f25247h.c());
                a(a2, this.f25247h.b());
            }
            a2.close();
        }

        public c(H h2) {
            this.f25240a = h2.l().i();
            this.f25241b = com.squareup.okhttp.internal.http.q.c(h2);
            this.f25242c = h2.l().f();
            this.f25243d = h2.k();
            this.f25244e = h2.e();
            this.f25245f = h2.h();
            this.f25246g = h2.g();
            this.f25247h = h2.f();
        }

        private boolean a() {
            return this.f25240a.startsWith("https://");
        }

        private List<Certificate> a(okio.i iVar) throws IOException {
            int b2 = C2379e.b(iVar);
            if (b2 == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(b2);
                for (int i = 0; i < b2; i++) {
                    String h2 = iVar.h();
                    okio.g gVar = new okio.g();
                    gVar.a(ByteString.decodeBase64(h2));
                    arrayList.add(certificateFactory.generateCertificate(gVar.p()));
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private void a(okio.h hVar, List<Certificate> list) throws IOException {
            try {
                hVar.d(list.size());
                hVar.writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    hVar.a(ByteString.of(list.get(i).getEncoded()).base64());
                    hVar.writeByte(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public boolean a(E e2, H h2) {
            return this.f25240a.equals(e2.i()) && this.f25242c.equals(e2.f()) && com.squareup.okhttp.internal.http.q.a(h2, this.f25241b, e2);
        }

        public H a(E e2, f.c cVar) {
            String a2 = this.f25246g.a(HttpHeaders.CONTENT_TYPE);
            String a3 = this.f25246g.a(HttpHeaders.CONTENT_LENGTH);
            E.a aVar = new E.a();
            aVar.b(this.f25240a);
            aVar.a(this.f25242c, (F) null);
            aVar.a(this.f25241b);
            E a4 = aVar.a();
            H.a aVar2 = new H.a();
            aVar2.a(a4);
            aVar2.a(this.f25243d);
            aVar2.a(this.f25244e);
            aVar2.a(this.f25245f);
            aVar2.a(this.f25246g);
            aVar2.a(new b(cVar, a2, a3));
            aVar2.a(this.f25247h);
            return aVar2.a();
        }
    }

    private void a(f.a aVar) {
        if (aVar != null) {
            try {
                aVar.a();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.squareup.okhttp.internal.http.d dVar) {
        this.f25230g++;
        if (dVar.f25413a != null) {
            this.f25228e++;
        } else if (dVar.f25414b != null) {
            this.f25229f++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f25229f++;
    }
}
