package com.google.api.client.http.apache;

import com.google.api.client.http.LowLevelHttpResponse;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpRequestBase;

/* compiled from: ApacheHttpResponse.java */
/* loaded from: classes.dex */
final class b extends LowLevelHttpResponse {

    /* renamed from: a, reason: collision with root package name */
    private final HttpRequestBase f2479a;
    private final HttpResponse b;
    private final Header[] c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HttpRequestBase httpRequestBase, HttpResponse httpResponse) {
        this.f2479a = httpRequestBase;
        this.b = httpResponse;
        this.c = httpResponse.getAllHeaders();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public int e() {
        StatusLine statusLine = this.b.getStatusLine();
        if (statusLine == null) {
            return 0;
        }
        return statusLine.getStatusCode();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public InputStream a() throws IOException {
        HttpEntity entity = this.b.getEntity();
        if (entity == null) {
            return null;
        }
        return entity.getContent();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String b() {
        Header contentEncoding;
        HttpEntity entity = this.b.getEntity();
        if (entity == null || (contentEncoding = entity.getContentEncoding()) == null) {
            return null;
        }
        return contentEncoding.getValue();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String c() {
        Header contentType;
        HttpEntity entity = this.b.getEntity();
        if (entity == null || (contentType = entity.getContentType()) == null) {
            return null;
        }
        return contentType.getValue();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String f() {
        StatusLine statusLine = this.b.getStatusLine();
        if (statusLine == null) {
            return null;
        }
        return statusLine.getReasonPhrase();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String d() {
        StatusLine statusLine = this.b.getStatusLine();
        if (statusLine == null) {
            return null;
        }
        return statusLine.toString();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public int g() {
        return this.c.length;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String a(int i) {
        return this.c[i].getName();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String b(int i) {
        return this.c[i].getValue();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public void h() {
        this.f2479a.abort();
    }
}
