package com.google.api.client.http.javanet;

import com.facebook.stetho.server.http.HttpHeaders;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/* compiled from: NetHttpRequest.java */
/* loaded from: classes2.dex */
final class a extends LowLevelHttpRequest {

    /* renamed from: e */
    private final HttpURLConnection f14816e;

    public a(HttpURLConnection httpURLConnection) {
        this.f14816e = httpURLConnection;
        httpURLConnection.setInstanceFollowRedirects(false);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void a(String str, String str2) {
        this.f14816e.addRequestProperty(str, str2);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void a(int i, int i2) {
        this.f14816e.setReadTimeout(i2);
        this.f14816e.setConnectTimeout(i);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public LowLevelHttpResponse a() throws IOException {
        HttpURLConnection httpURLConnection = this.f14816e;
        if (e() != null) {
            String d2 = d();
            if (d2 != null) {
                a(HttpHeaders.CONTENT_TYPE, d2);
            }
            String b2 = b();
            if (b2 != null) {
                a("Content-Encoding", b2);
            }
            long c2 = c();
            if (c2 >= 0) {
                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, Long.toString(c2));
            }
            String requestMethod = httpURLConnection.getRequestMethod();
            if (!"POST".equals(requestMethod) && !"PUT".equals(requestMethod)) {
                Preconditions.a(c2 == 0, "%s with non-zero content length is not supported", requestMethod);
            } else {
                httpURLConnection.setDoOutput(true);
                if (c2 >= 0 && c2 <= 2147483647L) {
                    httpURLConnection.setFixedLengthStreamingMode((int) c2);
                } else {
                    httpURLConnection.setChunkedStreamingMode(0);
                }
                OutputStream outputStream = httpURLConnection.getOutputStream();
                try {
                    e().writeTo(outputStream);
                    try {
                    } catch (IOException e2) {
                        throw e2;
                    }
                } finally {
                    try {
                        outputStream.close();
                    } catch (IOException unused) {
                    }
                }
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
