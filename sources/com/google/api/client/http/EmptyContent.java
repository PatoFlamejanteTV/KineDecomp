package com.google.api.client.http;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class EmptyContent implements HttpContent {
    @Override // com.google.api.client.http.HttpContent
    public long a() throws IOException {
        return 0L;
    }

    @Override // com.google.api.client.http.HttpContent
    public String d() {
        return null;
    }

    @Override // com.google.api.client.util.StreamingContent
    public void a(OutputStream outputStream) throws IOException {
        outputStream.flush();
    }

    @Override // com.google.api.client.http.HttpContent
    public boolean f() {
        return true;
    }
}
