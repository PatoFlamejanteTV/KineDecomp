package com.google.api.client.util;

import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

/* loaded from: classes.dex */
public final class SslUtils {
    public static SSLContext a() throws NoSuchAlgorithmException {
        return SSLContext.getInstance("TLS");
    }

    public static TrustManagerFactory b() throws NoSuchAlgorithmException {
        return TrustManagerFactory.getInstance("PKIX");
    }

    public static SSLContext a(SSLContext sSLContext, KeyStore keyStore, TrustManagerFactory trustManagerFactory) throws GeneralSecurityException {
        trustManagerFactory.init(keyStore);
        sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
        return sSLContext;
    }

    @Beta
    public static SSLContext c() throws GeneralSecurityException {
        TrustManager[] trustManagerArr = {new i()};
        SSLContext a2 = a();
        a2.init(null, trustManagerArr, null);
        return a2;
    }

    private SslUtils() {
    }
}
