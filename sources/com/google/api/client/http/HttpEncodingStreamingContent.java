package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class HttpEncodingStreamingContent implements StreamingContent {

    /* renamed from: a, reason: collision with root package name */
    private final StreamingContent f2460a;
    private final HttpEncoding b;

    public HttpEncodingStreamingContent(StreamingContent streamingContent, HttpEncoding httpEncoding) {
        this.f2460a = (StreamingContent) Preconditions.a(streamingContent);
        this.b = (HttpEncoding) Preconditions.a(httpEncoding);
    }

    @Override // com.google.api.client.util.StreamingContent
    public void a(OutputStream outputStream) throws IOException {
        this.b.a(this.f2460a, outputStream);
    }
}
