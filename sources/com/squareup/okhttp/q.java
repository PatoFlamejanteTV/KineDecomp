package com.squareup.okhttp;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpec.java */
/* loaded from: classes3.dex */
public final class q {

    /* renamed from: a */
    private static final CipherSuite[] f25518a = {CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};

    /* renamed from: b */
    public static final q f25519b;

    /* renamed from: c */
    public static final q f25520c;

    /* renamed from: d */
    public static final q f25521d;

    /* renamed from: e */
    private final boolean f25522e;

    /* renamed from: f */
    private final boolean f25523f;

    /* renamed from: g */
    private final String[] f25524g;

    /* renamed from: h */
    private final String[] f25525h;

    /* compiled from: ConnectionSpec.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        private boolean f25526a;

        /* renamed from: b */
        private String[] f25527b;

        /* renamed from: c */
        private String[] f25528c;

        /* renamed from: d */
        private boolean f25529d;

        a(boolean z) {
            this.f25526a = z;
        }

        public a a(CipherSuite... cipherSuiteArr) {
            if (this.f25526a) {
                String[] strArr = new String[cipherSuiteArr.length];
                for (int i = 0; i < cipherSuiteArr.length; i++) {
                    strArr[i] = cipherSuiteArr[i].javaName;
                }
                a(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a b(String... strArr) {
            if (this.f25526a) {
                if (strArr.length != 0) {
                    this.f25528c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(q qVar) {
            this.f25526a = qVar.f25522e;
            this.f25527b = qVar.f25524g;
            this.f25528c = qVar.f25525h;
            this.f25529d = qVar.f25523f;
        }

        public a a(String... strArr) {
            if (this.f25526a) {
                if (strArr.length != 0) {
                    this.f25527b = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a a(TlsVersion... tlsVersionArr) {
            if (this.f25526a) {
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
            if (this.f25526a) {
                this.f25529d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public q a() {
            return new q(this);
        }
    }

    static {
        a aVar = new a(true);
        aVar.a(f25518a);
        aVar.a(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        aVar.a(true);
        f25519b = aVar.a();
        a aVar2 = new a(f25519b);
        aVar2.a(TlsVersion.TLS_1_0);
        aVar2.a(true);
        f25520c = aVar2.a();
        f25521d = new a(false).a();
    }

    /* synthetic */ q(a aVar, p pVar) {
        this(aVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        q qVar = (q) obj;
        boolean z = this.f25522e;
        if (z != qVar.f25522e) {
            return false;
        }
        return !z || (Arrays.equals(this.f25524g, qVar.f25524g) && Arrays.equals(this.f25525h, qVar.f25525h) && this.f25523f == qVar.f25523f);
    }

    public int hashCode() {
        if (this.f25522e) {
            return ((((527 + Arrays.hashCode(this.f25524g)) * 31) + Arrays.hashCode(this.f25525h)) * 31) + (!this.f25523f ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f25522e) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f25524g != null ? a().toString() : "[all enabled]") + ", tlsVersions=" + (this.f25525h != null ? c().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f25523f + ")";
    }

    private q(a aVar) {
        this.f25522e = aVar.f25526a;
        this.f25524g = aVar.f25527b;
        this.f25525h = aVar.f25528c;
        this.f25523f = aVar.f25529d;
    }

    public List<CipherSuite> a() {
        String[] strArr = this.f25524g;
        if (strArr == null) {
            return null;
        }
        CipherSuite[] cipherSuiteArr = new CipherSuite[strArr.length];
        int i = 0;
        while (true) {
            String[] strArr2 = this.f25524g;
            if (i < strArr2.length) {
                cipherSuiteArr[i] = CipherSuite.forJavaName(strArr2[i]);
                i++;
            } else {
                return com.squareup.okhttp.a.o.a(cipherSuiteArr);
            }
        }
    }

    public boolean b() {
        return this.f25523f;
    }

    public List<TlsVersion> c() {
        String[] strArr = this.f25525h;
        if (strArr == null) {
            return null;
        }
        TlsVersion[] tlsVersionArr = new TlsVersion[strArr.length];
        int i = 0;
        while (true) {
            String[] strArr2 = this.f25525h;
            if (i < strArr2.length) {
                tlsVersionArr[i] = TlsVersion.forJavaName(strArr2[i]);
                i++;
            } else {
                return com.squareup.okhttp.a.o.a(tlsVersionArr);
            }
        }
    }

    private q b(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        String[] strArr = this.f25524g;
        if (strArr != null) {
            enabledCipherSuites = (String[]) com.squareup.okhttp.a.o.a(String.class, strArr, sSLSocket.getEnabledCipherSuites());
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        String[] strArr2 = this.f25525h;
        if (strArr2 != null) {
            enabledProtocols = (String[]) com.squareup.okhttp.a.o.a(String.class, strArr2, sSLSocket.getEnabledProtocols());
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        if (z && com.squareup.okhttp.a.o.b(sSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV")) {
            enabledCipherSuites = com.squareup.okhttp.a.o.a(enabledCipherSuites, "TLS_FALLBACK_SCSV");
        }
        a aVar = new a(this);
        aVar.a(enabledCipherSuites);
        aVar.b(enabledProtocols);
        return aVar.a();
    }

    public void a(SSLSocket sSLSocket, boolean z) {
        q b2 = b(sSLSocket, z);
        String[] strArr = b2.f25525h;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b2.f25524g;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean a(SSLSocket sSLSocket) {
        if (!this.f25522e) {
            return false;
        }
        String[] strArr = this.f25525h;
        if (strArr != null && !a(strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f25524g;
        return strArr2 == null || a(strArr2, sSLSocket.getEnabledCipherSuites());
    }

    private static boolean a(String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                if (com.squareup.okhttp.a.o.b(strArr2, str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
