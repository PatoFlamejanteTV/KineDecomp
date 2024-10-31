package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* compiled from: Handshake.java */
/* loaded from: classes3.dex */
public final class y {

    /* renamed from: a */
    private final TlsVersion f29219a;

    /* renamed from: b */
    private final C2566j f29220b;

    /* renamed from: c */
    private final List<Certificate> f29221c;

    /* renamed from: d */
    private final List<Certificate> f29222d;

    private y(TlsVersion tlsVersion, C2566j c2566j, List<Certificate> list, List<Certificate> list2) {
        this.f29219a = tlsVersion;
        this.f29220b = c2566j;
        this.f29221c = list;
        this.f29222d = list2;
    }

    public static y a(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        List emptyList;
        List emptyList2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
                C2566j a2 = C2566j.a(cipherSuite);
                String protocol = sSLSession.getProtocol();
                if (protocol != null) {
                    if (!"NONE".equals(protocol)) {
                        TlsVersion forJavaName = TlsVersion.forJavaName(protocol);
                        try {
                            certificateArr = sSLSession.getPeerCertificates();
                        } catch (SSLPeerUnverifiedException unused) {
                            certificateArr = null;
                        }
                        if (certificateArr != null) {
                            emptyList = okhttp3.a.e.a(certificateArr);
                        } else {
                            emptyList = Collections.emptyList();
                        }
                        Certificate[] localCertificates = sSLSession.getLocalCertificates();
                        if (localCertificates != null) {
                            emptyList2 = okhttp3.a.e.a(localCertificates);
                        } else {
                            emptyList2 = Collections.emptyList();
                        }
                        return new y(forJavaName, a2, emptyList, emptyList2);
                    }
                    throw new IOException("tlsVersion == NONE");
                }
                throw new IllegalStateException("tlsVersion == null");
            }
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public List<Certificate> b() {
        return this.f29221c;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.f29219a.equals(yVar.f29219a) && this.f29220b.equals(yVar.f29220b) && this.f29221c.equals(yVar.f29221c) && this.f29222d.equals(yVar.f29222d);
    }

    public int hashCode() {
        return ((((((527 + this.f29219a.hashCode()) * 31) + this.f29220b.hashCode()) * 31) + this.f29221c.hashCode()) * 31) + this.f29222d.hashCode();
    }

    public C2566j a() {
        return this.f29220b;
    }
}
