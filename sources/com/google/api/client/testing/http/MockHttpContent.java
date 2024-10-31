package com.google.api.client.testing.http;

import com.google.api.client.http.HttpContent;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.io.OutputStream;

@Beta
/* loaded from: classes.dex */
public class MockHttpContent implements HttpContent {
    private String b;

    /* renamed from: a, reason: collision with root package name */
    private long f2507a = -1;
    private byte[] c = new byte[0];

    @Override // com.google.api.client.http.HttpContent
    public long a() throws IOException {
        return this.f2507a;
    }

    @Override // com.google.api.client.http.HttpContent
    public String d() {
        return this.b;
    }

    @Override // com.google.api.client.util.StreamingContent
    public void a(OutputStream outputStream) throws IOException {
        outputStream.write(this.c);
        outputStream.flush();
    }

    @Override // com.google.api.client.http.HttpContent
    public boolean f() {
        return true;
    }
}
