package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class HttpEncodingStreamingContent implements StreamingContent {

    /* renamed from: a */
    private final StreamingContent f14748a;

    /* renamed from: b */
    private final HttpEncoding f14749b;

    public HttpEncodingStreamingContent(StreamingContent streamingContent, HttpEncoding httpEncoding) {
        Preconditions.a(streamingContent);
        this.f14748a = streamingContent;
        Preconditions.a(httpEncoding);
        this.f14749b = httpEncoding;
    }

    @Override // com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        this.f14749b.a(this.f14748a, outputStream);
    }
}
