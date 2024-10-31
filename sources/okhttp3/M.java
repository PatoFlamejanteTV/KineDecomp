package okhttp3;

import java.io.Closeable;
import javax.annotation.Nullable;
import okhttp3.z;

/* compiled from: Response.java */
/* loaded from: classes3.dex */
public final class M implements Closeable {

    /* renamed from: a */
    final I f28819a;

    /* renamed from: b */
    final Protocol f28820b;

    /* renamed from: c */
    final int f28821c;

    /* renamed from: d */
    final String f28822d;

    /* renamed from: e */
    @Nullable
    final y f28823e;

    /* renamed from: f */
    final z f28824f;

    /* renamed from: g */
    @Nullable
    final O f28825g;

    /* renamed from: h */
    @Nullable
    final M f28826h;

    @Nullable
    final M i;

    @Nullable
    final M j;
    final long k;
    final long l;

    @Nullable
    private volatile C2561e m;

    /* compiled from: Response.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        @Nullable
        I f28827a;

        /* renamed from: b */
        @Nullable
        Protocol f28828b;

        /* renamed from: c */
        int f28829c;

        /* renamed from: d */
        String f28830d;

        /* renamed from: e */
        @Nullable
        y f28831e;

        /* renamed from: f */
        z.a f28832f;

        /* renamed from: g */
        @Nullable
        O f28833g;

        /* renamed from: h */
        @Nullable
        M f28834h;

        @Nullable
        M i;

        @Nullable
        M j;
        long k;
        long l;

        public a() {
            this.f28829c = -1;
            this.f28832f = new z.a();
        }

        private void d(M m) {
            if (m.f28825g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(I i) {
            this.f28827a = i;
            return this;
        }

        public a b(String str, String str2) {
            this.f28832f.c(str, str2);
            return this;
        }

        public a c(@Nullable M m) {
            if (m != null) {
                d(m);
            }
            this.j = m;
            return this;
        }

        public a a(Protocol protocol) {
            this.f28828b = protocol;
            return this;
        }

        public a b(@Nullable M m) {
            if (m != null) {
                a("networkResponse", m);
            }
            this.f28834h = m;
            return this;
        }

        public a a(int i) {
            this.f28829c = i;
            return this;
        }

        a(M m) {
            this.f28829c = -1;
            this.f28827a = m.f28819a;
            this.f28828b = m.f28820b;
            this.f28829c = m.f28821c;
            this.f28830d = m.f28822d;
            this.f28831e = m.f28823e;
            this.f28832f = m.f28824f.a();
            this.f28833g = m.f28825g;
            this.f28834h = m.f28826h;
            this.i = m.i;
            this.j = m.j;
            this.k = m.k;
            this.l = m.l;
        }

        public a a(String str) {
            this.f28830d = str;
            return this;
        }

        public a b(long j) {
            this.k = j;
            return this;
        }

        public a a(@Nullable y yVar) {
            this.f28831e = yVar;
            return this;
        }

        public a a(String str, String str2) {
            this.f28832f.a(str, str2);
            return this;
        }

        public a a(z zVar) {
            this.f28832f = zVar.a();
            return this;
        }

        public a a(@Nullable O o) {
            this.f28833g = o;
            return this;
        }

        public a a(@Nullable M m) {
            if (m != null) {
                a("cacheResponse", m);
            }
            this.i = m;
            return this;
        }

        private void a(String str, M m) {
            if (m.f28825g == null) {
                if (m.f28826h == null) {
                    if (m.i == null) {
                        if (m.j == null) {
                            return;
                        }
                        throw new IllegalArgumentException(str + ".priorResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        public a a(long j) {
            this.l = j;
            return this;
        }

        public M a() {
            if (this.f28827a != null) {
                if (this.f28828b != null) {
                    if (this.f28829c >= 0) {
                        if (this.f28830d != null) {
                            return new M(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f28829c);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    M(a aVar) {
        this.f28819a = aVar.f28827a;
        this.f28820b = aVar.f28828b;
        this.f28821c = aVar.f28829c;
        this.f28822d = aVar.f28830d;
        this.f28823e = aVar.f28831e;
        this.f28824f = aVar.f28832f.a();
        this.f28825g = aVar.f28833g;
        this.f28826h = aVar.f28834h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    public long A() {
        return this.k;
    }

    @Nullable
    public String a(String str, @Nullable String str2) {
        String b2 = this.f28824f.b(str);
        return b2 != null ? b2 : str2;
    }

    public C2561e b() {
        C2561e c2561e = this.m;
        if (c2561e != null) {
            return c2561e;
        }
        C2561e a2 = C2561e.a(this.f28824f);
        this.m = a2;
        return a2;
    }

    public int c() {
        return this.f28821c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        O o = this.f28825g;
        if (o != null) {
            o.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    @Nullable
    public String e(String str) {
        return a(str, null);
    }

    @Nullable
    public y r() {
        return this.f28823e;
    }

    public z s() {
        return this.f28824f;
    }

    public String toString() {
        return "Response{protocol=" + this.f28820b + ", code=" + this.f28821c + ", message=" + this.f28822d + ", url=" + this.f28819a.g() + '}';
    }

    public boolean u() {
        int i = this.f28821c;
        return i >= 200 && i < 300;
    }

    public String v() {
        return this.f28822d;
    }

    public a w() {
        return new a(this);
    }

    @Nullable
    public M x() {
        return this.j;
    }

    public long y() {
        return this.l;
    }

    public I z() {
        return this.f28819a;
    }

    @Nullable
    public O a() {
        return this.f28825g;
    }
}
