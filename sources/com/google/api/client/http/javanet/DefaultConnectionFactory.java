package com.google.api.client.http.javanet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

/* loaded from: classes2.dex */
public class DefaultConnectionFactory implements ConnectionFactory {

    /* renamed from: a */
    private final Proxy f14812a;

    public DefaultConnectionFactory() {
        this(null);
    }

    @Override // com.google.api.client.http.javanet.ConnectionFactory
    public HttpURLConnection a(URL url) throws IOException {
        Proxy proxy = this.f14812a;
        return (HttpURLConnection) (proxy == null ? url.openConnection() : url.openConnection(proxy));
    }

    public DefaultConnectionFactory(Proxy proxy) {
        this.f14812a = proxy;
    }
}
