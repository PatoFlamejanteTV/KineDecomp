package com.google.api.client.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class LoggingInputStream extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private final LoggingByteArrayOutputStream f2541a;

    public LoggingInputStream(InputStream inputStream, Logger logger, Level level, int i) {
        super(inputStream);
        this.f2541a = new LoggingByteArrayOutputStream(logger, level, i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = super.read();
        this.f2541a.write(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read > 0) {
            this.f2541a.write(bArr, i, read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2541a.close();
        super.close();
    }
}
