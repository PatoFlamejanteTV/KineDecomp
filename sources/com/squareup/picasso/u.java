package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MarkableInputStream.java */
/* loaded from: classes3.dex */
public final class u extends InputStream {

    /* renamed from: a */
    private final InputStream f25672a;

    /* renamed from: b */
    private long f25673b;

    /* renamed from: c */
    private long f25674c;

    /* renamed from: d */
    private long f25675d;

    /* renamed from: e */
    private long f25676e;

    public u(InputStream inputStream) {
        this(inputStream, 4096);
    }

    private void h(long j) {
        try {
            if (this.f25674c < this.f25673b && this.f25673b <= this.f25675d) {
                this.f25672a.reset();
                this.f25672a.mark((int) (j - this.f25674c));
                a(this.f25674c, this.f25673b);
            } else {
                this.f25674c = this.f25673b;
                this.f25672a.mark((int) (j - this.f25673b));
            }
            this.f25675d = j;
        } catch (IOException e2) {
            throw new IllegalStateException("Unable to mark: " + e2);
        }
    }

    public long a(int i) {
        long j = this.f25673b + i;
        if (this.f25675d < j) {
            h(j);
        }
        return this.f25673b;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f25672a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f25672a.close();
    }

    public void g(long j) throws IOException {
        if (this.f25673b <= this.f25675d && j >= this.f25674c) {
            this.f25672a.reset();
            a(this.f25674c, j);
            this.f25673b = j;
            return;
        }
        throw new IOException("Cannot reset");
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f25676e = a(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f25672a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int read = this.f25672a.read();
        if (read != -1) {
            this.f25673b++;
        }
        return read;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        g(this.f25676e);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = this.f25672a.skip(j);
        this.f25673b += skip;
        return skip;
    }

    public u(InputStream inputStream, int i) {
        this.f25676e = -1L;
        this.f25672a = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream, i);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int read = this.f25672a.read(bArr);
        if (read != -1) {
            this.f25673b += read;
        }
        return read;
    }

    private void a(long j, long j2) throws IOException {
        while (j < j2) {
            long skip = this.f25672a.skip(j2 - j);
            if (skip == 0) {
                if (read() == -1) {
                    return;
                } else {
                    skip = 1;
                }
            }
            j += skip;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.f25672a.read(bArr, i, i2);
        if (read != -1) {
            this.f25673b += read;
        }
        return read;
    }
}
