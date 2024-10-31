package com.google.api.client.http;

import com.google.api.client.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class AbstractInputStreamContent implements HttpContent {

    /* renamed from: a, reason: collision with root package name */
    private String f2450a;
    private boolean b = true;

    public abstract InputStream b() throws IOException;

    public AbstractInputStreamContent(String str) {
        a(str);
    }

    @Override // com.google.api.client.util.StreamingContent
    public void a(OutputStream outputStream) throws IOException {
        IOUtils.a(b(), outputStream, this.b);
        outputStream.flush();
    }

    @Override // com.google.api.client.http.HttpContent
    public String d() {
        return this.f2450a;
    }

    public final boolean c() {
        return this.b;
    }

    public AbstractInputStreamContent a(String str) {
        this.f2450a = str;
        return this;
    }

    public AbstractInputStreamContent a(boolean z) {
        this.b = z;
        return this;
    }
}
