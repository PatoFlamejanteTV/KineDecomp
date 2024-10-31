package com.google.api.client.http.javanet;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
public final class NetHttpTransport extends HttpTransport {
    private static final String[] SUPPORTED_METHODS = {"DELETE", "GET", "HEAD", "OPTIONS", "POST", "PUT", "TRACE"};

    /* renamed from: a */
    private final ConnectionFactory f14813a;

    /* renamed from: b */
    private final SSLSocketFactory f14814b;

    /* renamed from: c */
    private final HostnameVerifier f14815c;

    /* loaded from: classes2.dex */
    public static final class Builder {
    }

    static {
        Arrays.sort(SUPPORTED_METHODS);
    }

    public NetHttpTransport() {
        this(null, null, null);
    }

    private static Proxy a() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("https.proxyHost"), Integer.parseInt(System.getProperty("https.proxyPort"))));
    }

    @Override // com.google.api.client.http.HttpTransport
    public boolean supportsMethod(String str) {
        return Arrays.binarySearch(SUPPORTED_METHODS, str) >= 0;
    }

    NetHttpTransport(ConnectionFactory connectionFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        this.f14813a = a(connectionFactory);
        this.f14814b = sSLSocketFactory;
        this.f14815c = hostnameVerifier;
    }

    @Override // com.google.api.client.http.HttpTransport
    public a buildRequest(String str, String str2) throws IOException {
        Preconditions.a(supportsMethod(str), "HTTP method %s not supported", str);
        HttpURLConnection a2 = this.f14813a.a(new URL(str2));
        a2.setRequestMethod(str);
        if (a2 instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) a2;
            HostnameVerifier hostnameVerifier = this.f14815c;
            if (hostnameVerifier != null) {
                httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            }
            SSLSocketFactory sSLSocketFactory = this.f14814b;
            if (sSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
            }
        }
        return new a(a2);
    }

    private ConnectionFactory a(ConnectionFactory connectionFactory) {
        if (connectionFactory != null) {
            return connectionFactory;
        }
        if (System.getProperty("com.google.api.client.should_use_proxy") != null) {
            return new DefaultConnectionFactory(a());
        }
        return new DefaultConnectionFactory();
    }
}
