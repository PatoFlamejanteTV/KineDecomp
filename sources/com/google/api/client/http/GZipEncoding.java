package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public class GZipEncoding implements HttpEncoding {
    @Override // com.google.api.client.http.HttpEncoding
    public void a(StreamingContent streamingContent, OutputStream outputStream) throws IOException {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new a(this, outputStream));
        streamingContent.writeTo(gZIPOutputStream);
        gZIPOutputStream.close();
    }

    @Override // com.google.api.client.http.HttpEncoding
    public String getName() {
        return "gzip";
    }
}
