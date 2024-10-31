package okhttp3.a.f;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import okhttp3.a.d.f;

/* compiled from: CertificateChainCleaner.java */
/* loaded from: classes3.dex */
public abstract class c {
    public static c a(X509TrustManager x509TrustManager) {
        return f.a().a(x509TrustManager);
    }

    public abstract List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
