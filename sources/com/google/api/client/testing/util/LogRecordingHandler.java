package com.google.api.client.testing.util;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Lists;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

@Beta
/* loaded from: classes.dex */
public class LogRecordingHandler extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final List<LogRecord> f2517a = Lists.a();

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        this.f2517a.add(logRecord);
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void close() throws SecurityException {
    }
}
