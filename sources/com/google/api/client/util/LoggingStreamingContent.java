package com.google.api.client.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class LoggingStreamingContent implements StreamingContent {

    /* renamed from: a */
    private final StreamingContent f14966a;

    /* renamed from: b */
    private final int f14967b;

    /* renamed from: c */
    private final Level f14968c;

    /* renamed from: d */
    private final Logger f14969d;

    public LoggingStreamingContent(StreamingContent streamingContent, Logger logger, Level level, int i) {
        this.f14966a = streamingContent;
        this.f14969d = logger;
        this.f14968c = level;
        this.f14967b = i;
    }

    @Override // com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        LoggingOutputStream loggingOutputStream = new LoggingOutputStream(outputStream, this.f14969d, this.f14968c, this.f14967b);
        try {
            this.f14966a.writeTo(loggingOutputStream);
            loggingOutputStream.a().close();
            outputStream.flush();
        } catch (Throwable th) {
            loggingOutputStream.a().close();
            throw th;
        }
    }
}
