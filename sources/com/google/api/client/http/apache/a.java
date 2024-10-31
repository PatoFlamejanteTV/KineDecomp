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
/* loaded from: classes.dex */
final class a extends LowLevelHttpRequest {

    /* renamed from: a, reason: collision with root package name */
    private final HttpClient f2478a;
    private final HttpRequestBase b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HttpClient httpClient, HttpRequestBase httpRequestBase) {
        this.f2478a = httpClient;
        this.b = httpRequestBase;
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void a(String str, String str2) {
        this.b.addHeader(str, str2);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void a(int i, int i2) throws IOException {
        HttpParams params = this.b.getParams();
        ConnManagerParams.setTimeout(params, i);
        HttpConnectionParams.setConnectionTimeout(params, i);
        HttpConnectionParams.setSoTimeout(params, i2);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public LowLevelHttpResponse a() throws IOException {
        if (e() != null) {
            Preconditions.a(this.b instanceof HttpEntityEnclosingRequest, "Apache HTTP client does not support %s requests with content.", this.b.getRequestLine().getMethod());
            c cVar = new c(b(), e());
            cVar.setContentEncoding(c());
            cVar.setContentType(d());
            ((HttpEntityEnclosingRequest) this.b).setEntity(cVar);
        }
        return new b(this.b, this.f2478a.execute(this.b));
    }
}
