package com.google.api.client.util;

import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

/* loaded from: classes2.dex */
public final class SslUtils {
    private SslUtils() {
    }

    public static TrustManagerFactory a() throws NoSuchAlgorithmException {
        return TrustManagerFactory.getInstance("PKIX");
    }

    public static SSLContext b() throws NoSuchAlgorithmException {
        return SSLContext.getInstance("TLS");
    }

    @Beta
    public static SSLContext c() throws GeneralSecurityException {
        TrustManager[] trustManagerArr = {new j()};
        SSLContext b2 = b();
        b2.init(null, trustManagerArr, null);
        return b2;
    }

    public static SSLContext a(SSLContext sSLContext, KeyStore keyStore, TrustManagerFactory trustManagerFactory) throws GeneralSecurityException {
        trustManagerFactory.init(keyStore);
        sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
        return sSLContext;
    }
}
