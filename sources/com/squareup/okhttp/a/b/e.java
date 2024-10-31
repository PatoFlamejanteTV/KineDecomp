package com.squareup.okhttp.a.b;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.security.auth.x500.X500Principal;

/* compiled from: RealTrustRootIndex.java */
/* loaded from: classes3.dex */
public final class e implements f {

    /* renamed from: a */
    private final Map<X500Principal, List<X509Certificate>> f25161a = new LinkedHashMap();

    public e(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            List<X509Certificate> list = this.f25161a.get(subjectX500Principal);
            if (list == null) {
                list = new ArrayList<>(1);
                this.f25161a.put(subjectX500Principal, list);
            }
            list.add(x509Certificate);
        }
    }

    @Override // com.squareup.okhttp.a.b.f
    public X509Certificate a(X509Certificate x509Certificate) {
        List<X509Certificate> list = this.f25161a.get(x509Certificate.getIssuerX500Principal());
        if (list == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : list) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
