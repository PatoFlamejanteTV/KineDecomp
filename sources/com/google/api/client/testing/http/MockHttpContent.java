package com.google.api.client.testing.http;

import com.google.api.client.http.HttpContent;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.io.OutputStream;

@Beta
/* loaded from: classes2.dex */
public class MockHttpContent implements HttpContent {

    /* renamed from: b */
    private String f14850b;

    /* renamed from: a */
    private long f14849a = -1;

    /* renamed from: c */
    private byte[] f14851c = new byte[0];

    @Override // com.google.api.client.http.HttpContent
    public boolean a() {
        return true;
    }

    @Override // com.google.api.client.http.HttpContent
    public long getLength() throws IOException {
        return this.f14849a;
    }

    @Override // com.google.api.client.http.HttpContent
    public String getType() {
        return this.f14850b;
    }

    @Override // com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.f14851c);
        outputStream.flush();
    }
}
