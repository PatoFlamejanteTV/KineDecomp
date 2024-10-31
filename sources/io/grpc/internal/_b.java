package io.grpc.internal;

import io.grpc.internal.C2418bc;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: ProxyDetectorImpl.java */
/* loaded from: classes3.dex */
class _b implements C2418bc.a {
    @Override // io.grpc.internal.C2418bc.a
    public PasswordAuthentication a(String str, InetAddress inetAddress, int i, String str2, String str3, String str4) {
        Logger logger;
        URL url;
        try {
            url = new URL(str2, str, i, "");
        } catch (MalformedURLException unused) {
            logger = C2418bc.f27568a;
            logger.log(Level.WARNING, String.format("failed to create URL for Authenticator: %s %s", str2, str));
            url = null;
        }
        return Authenticator.requestPasswordAuthentication(str, inetAddress, i, str2, str3, str4, url, Authenticator.RequestorType.PROXY);
    }
}
