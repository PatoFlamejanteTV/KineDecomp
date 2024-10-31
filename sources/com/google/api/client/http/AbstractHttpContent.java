package com.google.api.client.http;

import com.google.api.client.util.Charsets;
import com.google.api.client.util.IOUtils;
import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public abstract class AbstractHttpContent implements HttpContent {

    /* renamed from: a */
    private HttpMediaType f14722a;

    /* renamed from: b */
    private long f14723b;

    public AbstractHttpContent(String str) {
        this(str == null ? null : new HttpMediaType(str));
    }

    public static long a(HttpContent httpContent) throws IOException {
        if (httpContent.a()) {
            return IOUtils.a((StreamingContent) httpContent);
        }
        return -1L;
    }

    @Override // com.google.api.client.http.HttpContent
    public boolean a() {
        return true;
    }

    protected long b() throws IOException {
        return a(this);
    }

    public final Charset c() {
        HttpMediaType httpMediaType = this.f14722a;
        if (httpMediaType != null && httpMediaType.b() != null) {
            return this.f14722a.b();
        }
        return Charsets.f14915a;
    }

    public final HttpMediaType d() {
        return this.f14722a;
    }

    @Override // com.google.api.client.http.HttpContent
    public long getLength() throws IOException {
        if (this.f14723b == -1) {
            this.f14723b = b();
        }
        return this.f14723b;
    }

    @Override // com.google.api.client.http.HttpContent
    public String getType() {
        HttpMediaType httpMediaType = this.f14722a;
        if (httpMediaType == null) {
            return null;
        }
        return httpMediaType.a();
    }

    public AbstractHttpContent(HttpMediaType httpMediaType) {
        this.f14723b = -1L;
        this.f14722a = httpMediaType;
    }
}
