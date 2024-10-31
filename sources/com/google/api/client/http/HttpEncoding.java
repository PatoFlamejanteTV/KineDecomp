package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public interface HttpEncoding {
    String a();

    void a(StreamingContent streamingContent, OutputStream outputStream) throws IOException;
}
