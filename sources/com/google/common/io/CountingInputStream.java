package com.google.common.io;

import com.google.common.annotations.Beta;
import java.io.FilterInputStream;
import java.io.IOException;

@Beta
/* loaded from: classes2.dex */
public final class CountingInputStream extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private long f2911a;
    private long b;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = this.in.read();
        if (read != -1) {
            this.f2911a++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (read != -1) {
            this.f2911a += read;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = this.in.skip(j);
        this.f2911a += skip;
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.in.mark(i);
        this.b = this.f2911a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (!this.in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.b == -1) {
            throw new IOException("Mark not set");
        }
        this.in.reset();
        this.f2911a = this.b;
    }
}
