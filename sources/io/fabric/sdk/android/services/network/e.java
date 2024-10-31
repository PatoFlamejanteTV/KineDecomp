package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

/* compiled from: HttpRequest.java */
/* loaded from: classes3.dex */
class e implements HttpRequest.b {
    @Override // io.fabric.sdk.android.services.network.HttpRequest.b
    public HttpURLConnection a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    @Override // io.fabric.sdk.android.services.network.HttpRequest.b
    public HttpURLConnection a(URL url, Proxy proxy) throws IOException {
        return (HttpURLConnection) url.openConnection(proxy);
    }
}
