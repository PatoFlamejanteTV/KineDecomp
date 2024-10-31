package com.google.api.client.http.javanet;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/* compiled from: NetHttpRequest.java */
/* loaded from: classes.dex */
final class a extends LowLevelHttpRequest {

    /* renamed from: a, reason: collision with root package name */
    private final HttpURLConnection f2485a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HttpURLConnection httpURLConnection) {
        this.f2485a = httpURLConnection;
        httpURLConnection.setInstanceFollowRedirects(false);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void a(String str, String str2) {
        this.f2485a.addRequestProperty(str, str2);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void a(int i, int i2) {
        this.f2485a.setReadTimeout(i2);
        this.f2485a.setConnectTimeout(i);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public LowLevelHttpResponse a() throws IOException {
        HttpURLConnection httpURLConnection = this.f2485a;
        if (e() != null) {
            String d = d();
            if (d != null) {
                a("Content-Type", d);
            }
            String c = c();
            if (c != null) {
                a("Content-Encoding", c);
            }
            long b = b();
            if (b >= 0) {
                a("Content-Length", Long.toString(b));
            }
            String requestMethod = httpURLConnection.getRequestMethod();
            if ("POST".equals(requestMethod) || "PUT".equals(requestMethod)) {
                httpURLConnection.setDoOutput(true);
                if (b >= 0 && b <= 2147483647L) {
                    httpURLConnection.setFixedLengthStreamingMode((int) b);
                } else {
                    httpURLConnection.setChunkedStreamingMode(0);
                }
                OutputStream outputStream = httpURLConnection.getOutputStream();
                try {
                    e().a(outputStream);
                } finally {
                    outputStream.close();
                }
            } else {
                Preconditions.a(b == 0, "%s with non-zero content length is not supported", requestMethod);
            }
        }
        try {
            httpURLConnection.connect();
            return new b(httpURLConnection);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
