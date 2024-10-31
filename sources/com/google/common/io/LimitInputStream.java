package com.google.common.io;

import com.google.common.annotations.Beta;
import java.io.FilterInputStream;
import java.io.IOException;

@Beta
/* loaded from: classes2.dex */
public final class LimitInputStream extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private long f2915a;
    private long b;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return (int) Math.min(this.in.available(), this.f2915a);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.in.mark(i);
        this.b = this.f2915a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.f2915a == 0) {
            return -1;
        }
        int read = this.in.read();
        if (read != -1) {
            this.f2915a--;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f2915a == 0) {
            return -1;
        }
        int read = this.in.read(bArr, i, (int) Math.min(i2, this.f2915a));
        if (read != -1) {
            this.f2915a -= read;
        }
        return read;
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
        this.f2915a = this.b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = this.in.skip(Math.min(j, this.f2915a));
        this.f2915a -= skip;
        return skip;
    }
}
