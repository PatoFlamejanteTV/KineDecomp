package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: MergedStream.java */
/* loaded from: classes.dex */
public final class e extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    protected final c f436a;
    final InputStream b;
    byte[] c;
    int d;
    final int e;

    public e(c cVar, InputStream inputStream, byte[] bArr, int i, int i2) {
        this.f436a = cVar;
        this.b = inputStream;
        this.c = bArr;
        this.d = i;
        this.e = i2;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.c != null ? this.e - this.d : this.b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a();
        this.b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        if (this.c == null) {
            this.b.mark(i);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.c == null && this.b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.c == null) {
            return this.b.read();
        }
        byte[] bArr = this.c;
        int i = this.d;
        this.d = i + 1;
        int i2 = bArr[i] & 255;
        if (this.d >= this.e) {
            a();
            return i2;
        }
        return i2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.c == null) {
            return this.b.read(bArr, i, i2);
        }
        int i3 = this.e - this.d;
        if (i2 > i3) {
            i2 = i3;
        }
        System.arraycopy(this.c, this.d, bArr, i, i2);
        this.d += i2;
        if (this.d >= this.e) {
            a();
            return i2;
        }
        return i2;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        if (this.c == null) {
            this.b.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long j2;
        if (this.c != null) {
            int i = this.e - this.d;
            if (i > j) {
                this.d += (int) j;
                return j;
            }
            a();
            j2 = i + 0;
            j -= i;
        } else {
            j2 = 0;
        }
        if (j > 0) {
            j2 += this.b.skip(j);
        }
        return j2;
    }

    private void a() {
        byte[] bArr = this.c;
        if (bArr != null) {
            this.c = null;
            if (this.f436a != null) {
                this.f436a.a(bArr);
            }
        }
    }
}
