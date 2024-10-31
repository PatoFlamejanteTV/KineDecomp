package io.fabric.sdk.android.services.network;

import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: PinningTrustManager.java */
/* loaded from: classes3.dex */
class i implements X509TrustManager {

    /* renamed from: a */
    private static final X509Certificate[] f26983a = new X509Certificate[0];

    /* renamed from: b */
    private final TrustManager[] f26984b;

    /* renamed from: c */
    private final j f26985c;

    /* renamed from: d */
    private final long f26986d;

    /* renamed from: e */
    private final List<byte[]> f26987e = new LinkedList();

    /* renamed from: f */
    private final Set<X509Certificate> f26988f = Collections.synchronizedSet(new HashSet());

    public i(j jVar, h hVar) {
        this.f26984b = a(jVar);
        this.f26985c = jVar;
        this.f26986d = hVar.getPinCreationTimeInMillis();
        for (String str : hVar.getPins()) {
            this.f26987e.add(a(str));
        }
    }

    private TrustManager[] a(j jVar) {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init(jVar.f26989a);
            return trustManagerFactory.getTrustManagers();
        } catch (KeyStoreException e2) {
            throw new AssertionError(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new AssertionError(e3);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (this.f26988f.contains(x509CertificateArr[0])) {
            return;
        }
        a(x509CertificateArr, str);
        a(x509CertificateArr);
        this.f26988f.add(x509CertificateArr[0]);
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return f26983a;
    }

    private boolean a(X509Certificate x509Certificate) throws CertificateException {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            Iterator<byte[]> it = this.f26987e.iterator();
            while (it.hasNext()) {
                if (Arrays.equals(it.next(), digest)) {
                    return true;
                }
            }
            return false;
        } catch (NoSuchAlgorithmException e2) {
            throw new CertificateException(e2);
        }
    }

    private void a(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        for (TrustManager trustManager : this.f26984b) {
            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
        }
    }

    private void a(X509Certificate[] x509CertificateArr) throws CertificateException {
        if (this.f26986d != -1 && System.currentTimeMillis() - this.f26986d > 15552000000L) {
            io.fabric.sdk.android.f.f().b("Fabric", "Certificate pins are stale, (" + (System.currentTimeMillis() - this.f26986d) + " millis vs 15552000000 millis) falling back to system trust.");
            return;
        }
        for (X509Certificate x509Certificate : a.a(x509CertificateArr, this.f26985c)) {
            if (a(x509Certificate)) {
                return;
            }
        }
        throw new CertificateException("No valid pins found in chain!");
    }

    private byte[] a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
