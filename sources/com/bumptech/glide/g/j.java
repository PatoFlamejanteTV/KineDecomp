package com.bumptech.glide.g;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MarkEnforcingInputStream.java */
/* loaded from: classes.dex */
public class j extends FilterInputStream {

    /* renamed from: a */
    private int f8514a;

    public j(InputStream inputStream) {
        super(inputStream);
        this.f8514a = Integer.MIN_VALUE;
    }

    private long g(long j) {
        int i = this.f8514a;
        if (i == 0) {
            return -1L;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : i;
    }

    private void h(long j) {
        int i = this.f8514a;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.f8514a = (int) (i - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i = this.f8514a;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.f8514a = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (g(1L) == -1) {
            return -1;
        }
        int read = super.read();
        h(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f8514a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long g2 = g(j);
        if (g2 == -1) {
            return 0L;
        }
        long skip = super.skip(g2);
        h(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int g2 = (int) g(i2);
        if (g2 == -1) {
            return -1;
        }
        int read = super.read(bArr, i, g2);
        h(read);
        return read;
    }
}
