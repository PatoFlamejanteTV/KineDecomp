package com.google.api.client.http.javanet;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public final class NetHttpTransport extends HttpTransport {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f2484a = {"DELETE", "GET", "HEAD", "OPTIONS", "POST", "PUT", "TRACE"};
    private final ConnectionFactory b;
    private final SSLSocketFactory c;
    private final HostnameVerifier d;

    /* loaded from: classes.dex */
    public static final class Builder {
    }

    static {
        Arrays.sort(f2484a);
    }

    public NetHttpTransport() {
        this((ConnectionFactory) null, null, null);
    }

    NetHttpTransport(ConnectionFactory connectionFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        this.b = connectionFactory == null ? new DefaultConnectionFactory() : connectionFactory;
        this.c = sSLSocketFactory;
        this.d = hostnameVerifier;
    }

    @Override // com.google.api.client.http.HttpTransport
    public boolean supportsMethod(String str) {
        return Arrays.binarySearch(f2484a, str) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.api.client.http.HttpTransport
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a buildRequest(String str, String str2) throws IOException {
        Preconditions.a(supportsMethod(str), "HTTP method %s not supported", str);
        HttpURLConnection a2 = this.b.a(new URL(str2));
        a2.setRequestMethod(str);
        if (a2 instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) a2;
            if (this.d != null) {
                httpsURLConnection.setHostnameVerifier(this.d);
            }
            if (this.c != null) {
                httpsURLConnection.setSSLSocketFactory(this.c);
            }
        }
        return new a(a2);
    }
}
