package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: MergedStream.java */
/* loaded from: classes.dex */
public final class e extends InputStream {

    /* renamed from: a */
    private final c f9769a;

    /* renamed from: b */
    private final InputStream f9770b;

    /* renamed from: c */
    private byte[] f9771c;

    /* renamed from: d */
    private int f9772d;

    /* renamed from: e */
    private final int f9773e;

    public e(c cVar, InputStream inputStream, byte[] bArr, int i, int i2) {
        this.f9769a = cVar;
        this.f9770b = inputStream;
        this.f9771c = bArr;
        this.f9772d = i;
        this.f9773e = i2;
    }

    private void a() {
        byte[] bArr = this.f9771c;
        if (bArr != null) {
            this.f9771c = null;
            c cVar = this.f9769a;
            if (cVar != null) {
                cVar.a(bArr);
            }
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.f9771c != null) {
            return this.f9773e - this.f9772d;
        }
        return this.f9770b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a();
        this.f9770b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        if (this.f9771c == null) {
            this.f9770b.mark(i);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f9771c == null && this.f9770b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = this.f9771c;
        if (bArr != null) {
            int i = this.f9772d;
            this.f9772d = i + 1;
            int i2 = bArr[i] & 255;
            if (this.f9772d >= this.f9773e) {
                a();
            }
            return i2;
        }
        return this.f9770b.read();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        if (this.f9771c == null) {
            this.f9770b.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long j2;
        if (this.f9771c != null) {
            int i = this.f9773e;
            int i2 = this.f9772d;
            long j3 = i - i2;
            if (j3 > j) {
                this.f9772d = i2 + ((int) j);
                return j;
            }
            a();
            j2 = j3 + 0;
            j -= j3;
        } else {
            j2 = 0;
        }
        return j > 0 ? j2 + this.f9770b.skip(j) : j2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f9771c != null) {
            int i3 = this.f9773e - this.f9772d;
            if (i2 > i3) {
                i2 = i3;
            }
            System.arraycopy(this.f9771c, this.f9772d, bArr, i, i2);
            this.f9772d += i2;
            if (this.f9772d >= this.f9773e) {
                a();
            }
            return i2;
        }
        return this.f9770b.read(bArr, i, i2);
    }
}
