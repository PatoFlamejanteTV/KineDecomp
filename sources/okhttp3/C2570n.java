package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpec.java */
/* renamed from: okhttp3.n */
/* loaded from: classes3.dex */
public final class C2570n {

    /* renamed from: a */
    private static final C2566j[] f29182a = {C2566j.lb, C2566j.mb, C2566j.nb, C2566j.ob, C2566j.pb, C2566j.Ya, C2566j.bb, C2566j.Za, C2566j.cb, C2566j.ib, C2566j.hb};

    /* renamed from: b */
    private static final C2566j[] f29183b = {C2566j.lb, C2566j.mb, C2566j.nb, C2566j.ob, C2566j.pb, C2566j.Ya, C2566j.bb, C2566j.Za, C2566j.cb, C2566j.ib, C2566j.hb, C2566j.Ja, C2566j.Ka, C2566j.ha, C2566j.ia, C2566j.F, C2566j.J, C2566j.j};

    /* renamed from: c */
    public static final C2570n f29184c;

    /* renamed from: d */
    public static final C2570n f29185d;

    /* renamed from: e */
    public static final C2570n f29186e;

    /* renamed from: f */
    public static final C2570n f29187f;

    /* renamed from: g */
    final boolean f29188g;

    /* renamed from: h */
    final boolean f29189h;

    @Nullable
    final String[] i;

    @Nullable
    final String[] j;

    static {
        a aVar = new a(true);
        aVar.a(f29182a);
        aVar.a(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2);
        aVar.a(true);
        f29184c = aVar.a();
        a aVar2 = new a(true);
        aVar2.a(f29183b);
        aVar2.a(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        aVar2.a(true);
        f29185d = aVar2.a();
        a aVar3 = new a(true);
        aVar3.a(f29183b);
        aVar3.a(TlsVersion.TLS_1_0);
        aVar3.a(true);
        f29186e = aVar3.a();
        f29187f = new a(false).a();
    }

    C2570n(a aVar) {
        this.f29188g = aVar.f29190a;
        this.i = aVar.f29191b;
        this.j = aVar.f29192c;
        this.f29189h = aVar.f29193d;
    }

    @Nullable
    public List<C2566j> a() {
        String[] strArr = this.i;
        if (strArr != null) {
            return C2566j.a(strArr);
        }
        return null;
    }

    public boolean b() {
        return this.f29188g;
    }

    public boolean c() {
        return this.f29189h;
    }

    @Nullable
    public List<TlsVersion> d() {
        String[] strArr = this.j;
        if (strArr != null) {
            return TlsVersion.forJavaNames(strArr);
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof C2570n)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C2570n c2570n = (C2570n) obj;
        boolean z = this.f29188g;
        if (z != c2570n.f29188g) {
            return false;
        }
        return !z || (Arrays.equals(this.i, c2570n.i) && Arrays.equals(this.j, c2570n.j) && this.f29189h == c2570n.f29189h);
    }

    public int hashCode() {
        if (this.f29188g) {
            return ((((527 + Arrays.hashCode(this.i)) * 31) + Arrays.hashCode(this.j)) * 31) + (!this.f29189h ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f29188g) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.i != null ? a().toString() : "[all enabled]") + ", tlsVersions=" + (this.j != null ? d().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f29189h + ")";
    }

    /* compiled from: ConnectionSpec.java */
    /* renamed from: okhttp3.n$a */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        boolean f29190a;

        /* renamed from: b */
        @Nullable
        String[] f29191b;

        /* renamed from: c */
        @Nullable
        String[] f29192c;

        /* renamed from: d */
        boolean f29193d;

        a(boolean z) {
            this.f29190a = z;
        }

        public a a(C2566j... c2566jArr) {
            if (this.f29190a) {
                String[] strArr = new String[c2566jArr.length];
                for (int i = 0; i < c2566jArr.length; i++) {
                    strArr[i] = c2566jArr[i].qb;
                }
                a(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a b(String... strArr) {
            if (this.f29190a) {
                if (strArr.length != 0) {
                    this.f29192c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(C2570n c2570n) {
            this.f29190a = c2570n.f29188g;
            this.f29191b = c2570n.i;
            this.f29192c = c2570n.j;
            this.f29193d = c2570n.f29189h;
        }

        public a a(String... strArr) {
            if (this.f29190a) {
                if (strArr.length != 0) {
                    this.f29191b = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a a(TlsVersion... tlsVersionArr) {
            if (this.f29190a) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i = 0; i < tlsVersionArr.length; i++) {
                    strArr[i] = tlsVersionArr[i].javaName;
                }
                b(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a a(boolean z) {
            if (this.f29190a) {
                this.f29193d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public C2570n a() {
            return new C2570n(this);
        }
    }

    private C2570n b(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.i != null) {
            enabledCipherSuites = okhttp3.a.e.a(C2566j.f29166a, sSLSocket.getEnabledCipherSuites(), this.i);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.j != null) {
            enabledProtocols = okhttp3.a.e.a(okhttp3.a.e.q, sSLSocket.getEnabledProtocols(), this.j);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a2 = okhttp3.a.e.a(C2566j.f29166a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a2 != -1) {
            enabledCipherSuites = okhttp3.a.e.a(enabledCipherSuites, supportedCipherSuites[a2]);
        }
        a aVar = new a(this);
        aVar.a(enabledCipherSuites);
        aVar.b(enabledProtocols);
        return aVar.a();
    }

    public void a(SSLSocket sSLSocket, boolean z) {
        C2570n b2 = b(sSLSocket, z);
        String[] strArr = b2.j;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b2.i;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean a(SSLSocket sSLSocket) {
        if (!this.f29188g) {
            return false;
        }
        String[] strArr = this.j;
        if (strArr != null && !okhttp3.a.e.b(okhttp3.a.e.q, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.i;
        return strArr2 == null || okhttp3.a.e.b(C2566j.f29166a, strArr2, sSLSocket.getEnabledCipherSuites());
    }
}
