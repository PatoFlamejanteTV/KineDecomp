package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public interface HttpEncoding {
    void a(StreamingContent streamingContent, OutputStream outputStream) throws IOException;

    String getName();
}
