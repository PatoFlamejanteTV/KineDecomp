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
/* loaded from: classes2.dex */
final class b extends LowLevelHttpResponse {

    /* renamed from: a */
    private final HttpRequestBase f14805a;

    /* renamed from: b */
    private final HttpResponse f14806b;

    /* renamed from: c */
    private final Header[] f14807c;

    public b(HttpRequestBase httpRequestBase, HttpResponse httpResponse) {
        this.f14805a = httpRequestBase;
        this.f14806b = httpResponse;
        this.f14807c = httpResponse.getAllHeaders();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String a(int i) {
        return this.f14807c[i].getName();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public InputStream b() throws IOException {
        HttpEntity entity = this.f14806b.getEntity();
        if (entity == null) {
            return null;
        }
        return entity.getContent();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String c() {
        Header contentEncoding;
        HttpEntity entity = this.f14806b.getEntity();
        if (entity == null || (contentEncoding = entity.getContentEncoding()) == null) {
            return null;
        }
        return contentEncoding.getValue();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String d() {
        Header contentType;
        HttpEntity entity = this.f14806b.getEntity();
        if (entity == null || (contentType = entity.getContentType()) == null) {
            return null;
        }
        return contentType.getValue();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public int e() {
        return this.f14807c.length;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String f() {
        StatusLine statusLine = this.f14806b.getStatusLine();
        if (statusLine == null) {
            return null;
        }
        return statusLine.getReasonPhrase();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public int g() {
        StatusLine statusLine = this.f14806b.getStatusLine();
        if (statusLine == null) {
            return 0;
        }
        return statusLine.getStatusCode();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String h() {
        StatusLine statusLine = this.f14806b.getStatusLine();
        if (statusLine == null) {
            return null;
        }
        return statusLine.toString();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public void a() {
        this.f14805a.abort();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String b(int i) {
        return this.f14807c[i].getValue();
    }
}
