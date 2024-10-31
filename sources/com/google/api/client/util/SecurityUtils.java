package com.google.api.client.util;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class SecurityUtils {
    private SecurityUtils() {
    }

    public static KeyStore a() throws KeyStoreException {
        return KeyStore.getInstance("JKS");
    }

    public static Signature b() throws NoSuchAlgorithmException {
        return Signature.getInstance("SHA1withRSA");
    }

    public static Signature c() throws NoSuchAlgorithmException {
        return Signature.getInstance("SHA256withRSA");
    }

    public static CertificateFactory d() throws CertificateException {
        return CertificateFactory.getInstance("X.509");
    }

    public static void a(KeyStore keyStore, InputStream inputStream, String str) throws IOException, GeneralSecurityException {
        try {
            keyStore.load(inputStream, str.toCharArray());
        } finally {
            inputStream.close();
        }
    }

    public static byte[] a(Signature signature, PrivateKey privateKey, byte[] bArr) throws InvalidKeyException, SignatureException {
        signature.initSign(privateKey);
        signature.update(bArr);
        return signature.sign();
    }

    public static void a(KeyStore keyStore, CertificateFactory certificateFactory, InputStream inputStream) throws GeneralSecurityException {
        Iterator<? extends Certificate> it = certificateFactory.generateCertificates(inputStream).iterator();
        int i = 0;
        while (it.hasNext()) {
            keyStore.setCertificateEntry(String.valueOf(i), it.next());
            i++;
        }
    }
}
