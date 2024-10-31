package com.google.api.client.http;

import com.google.api.client.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public abstract class AbstractInputStreamContent implements HttpContent {

    /* renamed from: a */
    private String f14724a;

    /* renamed from: b */
    private boolean f14725b = true;

    public AbstractInputStreamContent(String str) {
        a(str);
    }

    public AbstractInputStreamContent a(String str) {
        this.f14724a = str;
        return this;
    }

    public final boolean b() {
        return this.f14725b;
    }

    public abstract InputStream c() throws IOException;

    @Override // com.google.api.client.http.HttpContent
    public String getType() {
        return this.f14724a;
    }

    @Override // com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        IOUtils.a(c(), outputStream, this.f14725b);
        outputStream.flush();
    }

    public AbstractInputStreamContent a(boolean z) {
        this.f14725b = z;
        return this;
    }
}
