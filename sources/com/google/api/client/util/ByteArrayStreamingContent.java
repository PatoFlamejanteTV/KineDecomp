package com.google.api.client.util;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class ByteArrayStreamingContent implements StreamingContent {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f2528a;
    private final int b;
    private final int c;

    @Override // com.google.api.client.util.StreamingContent
    public void a(OutputStream outputStream) throws IOException {
        outputStream.write(this.f2528a, this.b, this.c);
        outputStream.flush();
    }
}
