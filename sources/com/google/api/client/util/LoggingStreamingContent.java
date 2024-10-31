package com.google.api.client.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class LoggingStreamingContent implements StreamingContent {

    /* renamed from: a, reason: collision with root package name */
    private final StreamingContent f2543a;
    private final int b;
    private final Level c;
    private final Logger d;

    public LoggingStreamingContent(StreamingContent streamingContent, Logger logger, Level level, int i) {
        this.f2543a = streamingContent;
        this.d = logger;
        this.c = level;
        this.b = i;
    }

    @Override // com.google.api.client.util.StreamingContent
    public void a(OutputStream outputStream) throws IOException {
        LoggingOutputStream loggingOutputStream = new LoggingOutputStream(outputStream, this.d, this.c, this.b);
        try {
            this.f2543a.a(loggingOutputStream);
            loggingOutputStream.a().close();
            outputStream.flush();
        } catch (Throwable th) {
            loggingOutputStream.a().close();
            throw th;
        }
    }
}
