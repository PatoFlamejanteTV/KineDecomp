package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes.dex */
public class GZipEncoding implements HttpEncoding {
    @Override // com.google.api.client.http.HttpEncoding
    public String a() {
        return "gzip";
    }

    @Override // com.google.api.client.http.HttpEncoding
    public void a(StreamingContent streamingContent, OutputStream outputStream) throws IOException {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new a(this, outputStream));
        streamingContent.a(gZIPOutputStream);
        gZIPOutputStream.close();
    }
}
