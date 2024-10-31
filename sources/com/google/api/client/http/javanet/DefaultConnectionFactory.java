package com.google.api.client.http.javanet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

/* loaded from: classes.dex */
public class DefaultConnectionFactory implements ConnectionFactory {

    /* renamed from: a, reason: collision with root package name */
    private final Proxy f2483a;

    public DefaultConnectionFactory() {
        this(null);
    }

    public DefaultConnectionFactory(Proxy proxy) {
        this.f2483a = proxy;
    }

    @Override // com.google.api.client.http.javanet.ConnectionFactory
    public HttpURLConnection a(URL url) throws IOException {
        return (HttpURLConnection) (this.f2483a == null ? url.openConnection() : url.openConnection(this.f2483a));
    }
}
