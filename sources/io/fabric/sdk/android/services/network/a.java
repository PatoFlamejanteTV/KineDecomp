package io.fabric.sdk.android.services.network;

import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;

/* compiled from: CertificateChainCleaner.java */
/* loaded from: classes3.dex */
final class a {
    public static X509Certificate[] a(X509Certificate[] x509CertificateArr, j jVar) throws CertificateException {
        LinkedList linkedList = new LinkedList();
        boolean b2 = jVar.b(x509CertificateArr[0]);
        linkedList.add(x509CertificateArr[0]);
        boolean z = true;
        boolean z2 = b2;
        int i = 1;
        while (i < x509CertificateArr.length) {
            if (jVar.b(x509CertificateArr[i])) {
                z2 = true;
            }
            if (!a(x509CertificateArr[i], x509CertificateArr[i - 1])) {
                break;
            }
            linkedList.add(x509CertificateArr[i]);
            i++;
        }
        X509Certificate a2 = jVar.a(x509CertificateArr[i - 1]);
        if (a2 != null) {
            linkedList.add(a2);
        } else {
            z = z2;
        }
        if (z) {
            return (X509Certificate[]) linkedList.toArray(new X509Certificate[linkedList.size()]);
        }
        throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
    }

    private static boolean a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getIssuerX500Principal())) {
            return false;
        }
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
