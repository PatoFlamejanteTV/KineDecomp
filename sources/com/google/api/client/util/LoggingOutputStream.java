package com.google.api.client.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class LoggingOutputStream extends FilterOutputStream {

    /* renamed from: a, reason: collision with root package name */
    private final LoggingByteArrayOutputStream f2542a;

    public LoggingOutputStream(OutputStream outputStream, Logger logger, Level level, int i) {
        super(outputStream);
        this.f2542a = new LoggingByteArrayOutputStream(logger, level, i);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        this.out.write(i);
        this.f2542a.write(i);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        this.f2542a.write(bArr, i, i2);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2542a.close();
        super.close();
    }

    public final LoggingByteArrayOutputStream a() {
        return this.f2542a;
    }
}
