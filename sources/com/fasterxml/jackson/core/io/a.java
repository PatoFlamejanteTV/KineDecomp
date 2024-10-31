package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* compiled from: BaseReader.java */
/* loaded from: classes.dex */
abstract class a extends Reader {

    /* renamed from: a, reason: collision with root package name */
    protected final c f432a;
    protected InputStream b;
    protected byte[] c;
    protected int d;
    protected int e;
    protected char[] f = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(c cVar, InputStream inputStream, byte[] bArr, int i, int i2) {
        this.f432a = cVar;
        this.b = inputStream;
        this.c = bArr;
        this.d = i;
        this.e = i2;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.b;
        if (inputStream != null) {
            this.b = null;
            a();
            inputStream.close();
        }
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        if (this.f == null) {
            this.f = new char[1];
        }
        if (read(this.f, 0, 1) < 1) {
            return -1;
        }
        return this.f[0];
    }

    public final void a() {
        byte[] bArr = this.c;
        if (bArr != null) {
            this.c = null;
            this.f432a.a(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(char[] cArr, int i, int i2) throws IOException {
        throw new ArrayIndexOutOfBoundsException("read(buf," + i + "," + i2 + "), cbuf[" + cArr.length + "]");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }
}
