package com.google.api.client.http;

import com.google.api.client.util.Charsets;
import com.google.api.client.util.IOUtils;
import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class AbstractHttpContent implements HttpContent {

    /* renamed from: a, reason: collision with root package name */
    private HttpMediaType f2449a;
    private long b;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractHttpContent(String str) {
        this(str == null ? null : new HttpMediaType(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractHttpContent(HttpMediaType httpMediaType) {
        this.b = -1L;
        this.f2449a = httpMediaType;
    }

    @Override // com.google.api.client.http.HttpContent
    public long a() throws IOException {
        if (this.b == -1) {
            this.b = e();
        }
        return this.b;
    }

    public final HttpMediaType b() {
        return this.f2449a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Charset c() {
        return (this.f2449a == null || this.f2449a.d() == null) ? Charsets.f2530a : this.f2449a.d();
    }

    @Override // com.google.api.client.http.HttpContent
    public String d() {
        if (this.f2449a == null) {
            return null;
        }
        return this.f2449a.c();
    }

    protected long e() throws IOException {
        return a(this);
    }

    @Override // com.google.api.client.http.HttpContent
    public boolean f() {
        return true;
    }

    public static long a(HttpContent httpContent) throws IOException {
        if (httpContent.f()) {
            return IOUtils.a((StreamingContent) httpContent);
        }
        return -1L;
    }
}
