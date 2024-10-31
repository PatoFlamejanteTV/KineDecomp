package com.google.api.client.http.apache;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* compiled from: ApacheHttpRequest.java */
/* loaded from: classes2.dex */
final class a extends LowLevelHttpRequest {

    /* renamed from: e */
    private final HttpClient f14803e;

    /* renamed from: f */
    private final HttpRequestBase f14804f;

    public a(HttpClient httpClient, HttpRequestBase httpRequestBase) {
        this.f14803e = httpClient;
        this.f14804f = httpRequestBase;
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void a(String str, String str2) {
        this.f14804f.addHeader(str, str2);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void a(int i, int i2) throws IOException {
        HttpParams params = this.f14804f.getParams();
        ConnManagerParams.setTimeout(params, i);
        HttpConnectionParams.setConnectionTimeout(params, i);
        HttpConnectionParams.setSoTimeout(params, i2);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public LowLevelHttpResponse a() throws IOException {
        if (e() != null) {
            HttpRequestBase httpRequestBase = this.f14804f;
            Preconditions.a(httpRequestBase instanceof HttpEntityEnclosingRequest, "Apache HTTP client does not support %s requests with content.", httpRequestBase.getRequestLine().getMethod());
            c cVar = new c(c(), e());
            cVar.setContentEncoding(b());
            cVar.setContentType(d());
            ((HttpEntityEnclosingRequest) this.f14804f).setEntity(cVar);
        }
        HttpRequestBase httpRequestBase2 = this.f14804f;
        return new b(httpRequestBase2, this.f14803e.execute(httpRequestBase2));
    }
}
