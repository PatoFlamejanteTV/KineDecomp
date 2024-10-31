package io.grpc.okhttp.internal;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpec.java */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a */
    private static final CipherSuite[] f27884a = {CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_DSS_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};

    /* renamed from: b */
    public static final b f27885b;

    /* renamed from: c */
    public static final b f27886c;

    /* renamed from: d */
    public static final b f27887d;

    /* renamed from: e */
    final boolean f27888e;

    /* renamed from: f */
    private final String[] f27889f;

    /* renamed from: g */
    private final String[] f27890g;

    /* renamed from: h */
    final boolean f27891h;

    /* compiled from: ConnectionSpec.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        private boolean f27892a;

        /* renamed from: b */
        private String[] f27893b;

        /* renamed from: c */
        private String[] f27894c;

        /* renamed from: d */
        private boolean f27895d;

        public a(boolean z) {
            this.f27892a = z;
        }

        public a a(CipherSuite... cipherSuiteArr) {
            if (this.f27892a) {
                String[] strArr = new String[cipherSuiteArr.length];
                for (int i = 0; i < cipherSuiteArr.length; i++) {
                    strArr[i] = cipherSuiteArr[i].javaName;
                }
                this.f27893b = strArr;
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a b(String... strArr) {
            if (!this.f27892a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr == null) {
                this.f27894c = null;
            } else {
                this.f27894c = (String[]) strArr.clone();
            }
            return this;
        }

        public a(b bVar) {
            this.f27892a = bVar.f27888e;
            this.f27893b = bVar.f27889f;
            this.f27894c = bVar.f27890g;
            this.f27895d = bVar.f27891h;
        }

        public a a(String... strArr) {
            if (!this.f27892a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr == null) {
                this.f27893b = null;
            } else {
                this.f27893b = (String[]) strArr.clone();
            }
            return this;
        }

        public a a(TlsVersion... tlsVersionArr) {
            if (this.f27892a) {
                if (tlsVersionArr.length != 0) {
                    String[] strArr = new String[tlsVersionArr.length];
                    for (int i = 0; i < tlsVersionArr.length; i++) {
                        strArr[i] = tlsVersionArr[i].javaName;
                    }
                    this.f27894c = strArr;
                    return this;
                }
                throw new IllegalArgumentException("At least one TlsVersion is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a a(boolean z) {
            if (this.f27892a) {
                this.f27895d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public b a() {
            return new b(this);
        }
    }

    static {
        a aVar = new a(true);
        aVar.a(f27884a);
        aVar.a(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        aVar.a(true);
        f27885b = aVar.a();
        a aVar2 = new a(f27885b);
        aVar2.a(TlsVersion.TLS_1_0);
        aVar2.a(true);
        f27886c = aVar2.a();
        f27887d = new a(false).a();
    }

    /* synthetic */ b(a aVar, io.grpc.okhttp.internal.a aVar2) {
        this(aVar);
    }

    public List<TlsVersion> c() {
        TlsVersion[] tlsVersionArr = new TlsVersion[this.f27890g.length];
        int i = 0;
        while (true) {
            String[] strArr = this.f27890g;
            if (i < strArr.length) {
                tlsVersionArr[i] = TlsVersion.forJavaName(strArr[i]);
                i++;
            } else {
                return i.a(tlsVersionArr);
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        b bVar = (b) obj;
        boolean z = this.f27888e;
        if (z != bVar.f27888e) {
            return false;
        }
        return !z || (Arrays.equals(this.f27889f, bVar.f27889f) && Arrays.equals(this.f27890g, bVar.f27890g) && this.f27891h == bVar.f27891h);
    }

    public int hashCode() {
        if (this.f27888e) {
            return ((((527 + Arrays.hashCode(this.f27889f)) * 31) + Arrays.hashCode(this.f27890g)) * 31) + (!this.f27891h ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f27888e) {
            return "ConnectionSpec()";
        }
        List<CipherSuite> a2 = a();
        return "ConnectionSpec(cipherSuites=" + (a2 == null ? "[use default]" : a2.toString()) + ", tlsVersions=" + c() + ", supportsTlsExtensions=" + this.f27891h + ")";
    }

    private b(a aVar) {
        this.f27888e = aVar.f27892a;
        this.f27889f = aVar.f27893b;
        this.f27890g = aVar.f27894c;
        this.f27891h = aVar.f27895d;
    }

    public List<CipherSuite> a() {
        String[] strArr = this.f27889f;
        if (strArr == null) {
            return null;
        }
        CipherSuite[] cipherSuiteArr = new CipherSuite[strArr.length];
        int i = 0;
        while (true) {
            String[] strArr2 = this.f27889f;
            if (i < strArr2.length) {
                cipherSuiteArr[i] = CipherSuite.forJavaName(strArr2[i]);
                i++;
            } else {
                return i.a(cipherSuiteArr);
            }
        }
    }

    public boolean b() {
        return this.f27891h;
    }

    private b b(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        if (this.f27889f != null) {
            strArr = (String[]) i.a(String.class, this.f27889f, sSLSocket.getEnabledCipherSuites());
        } else {
            strArr = null;
        }
        if (z && Arrays.asList(sSLSocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV")) {
            if (strArr == null) {
                strArr = sSLSocket.getEnabledCipherSuites();
            }
            strArr2 = new String[strArr.length + 1];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[strArr2.length - 1] = "TLS_FALLBACK_SCSV";
        } else {
            strArr2 = strArr;
        }
        String[] strArr3 = (String[]) i.a(String.class, this.f27890g, sSLSocket.getEnabledProtocols());
        a aVar = new a(this);
        aVar.a(strArr2);
        aVar.b(strArr3);
        return aVar.a();
    }

    public void a(SSLSocket sSLSocket, boolean z) {
        b b2 = b(sSLSocket, z);
        sSLSocket.setEnabledProtocols(b2.f27890g);
        String[] strArr = b2.f27889f;
        if (strArr != null) {
            sSLSocket.setEnabledCipherSuites(strArr);
        }
    }
}
