package com.google.api.client.testing.util;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Lists;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

@Beta
/* loaded from: classes2.dex */
public class LogRecordingHandler extends Handler {

    /* renamed from: a */
    private final List<LogRecord> f14885a = Lists.a();

    @Override // java.util.logging.Handler
    public void close() throws SecurityException {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        this.f14885a.add(logRecord);
    }
}
