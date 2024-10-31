package com.google.api.client.util;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class ByteArrayStreamingContent implements StreamingContent {

    /* renamed from: a */
    private final byte[] f14910a;

    /* renamed from: b */
    private final int f14911b;

    /* renamed from: c */
    private final int f14912c;

    @Override // com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.f14910a, this.f14911b, this.f14912c);
        outputStream.flush();
    }
}
