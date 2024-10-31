package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class zzp extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f2398a;
    private volatile u b;

    private int a(int i) throws ChannelIOException {
        u uVar;
        if (i != -1 || (uVar = this.b) == null) {
            return i;
        }
        throw new ChannelIOException("Channel closed unexpectedly before stream was finished", uVar.f2380a, uVar.b);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f2398a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2398a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f2398a.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f2398a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return a(this.f2398a.read());
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return a(this.f2398a.read(bArr));
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return a(this.f2398a.read(bArr, i, i2));
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.f2398a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        return this.f2398a.skip(j);
    }
}
