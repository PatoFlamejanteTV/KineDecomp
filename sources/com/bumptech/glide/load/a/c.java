package com.bumptech.glide.load.a;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: BufferedOutputStream.java */
/* loaded from: classes.dex */
public final class c extends OutputStream {

    /* renamed from: a */
    private final OutputStream f8549a;

    /* renamed from: b */
    private byte[] f8550b;

    /* renamed from: c */
    private com.bumptech.glide.load.engine.a.b f8551c;

    /* renamed from: d */
    private int f8552d;

    public c(OutputStream outputStream, com.bumptech.glide.load.engine.a.b bVar) {
        this(outputStream, bVar, 65536);
    }

    private void a() throws IOException {
        int i = this.f8552d;
        if (i > 0) {
            this.f8549a.write(this.f8550b, 0, i);
            this.f8552d = 0;
        }
    }

    private void b() throws IOException {
        if (this.f8552d == this.f8550b.length) {
            a();
        }
    }

    private void c() {
        byte[] bArr = this.f8550b;
        if (bArr != null) {
            this.f8551c.put(bArr);
            this.f8550b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f8549a.close();
            c();
        } catch (Throwable th) {
            this.f8549a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a();
        this.f8549a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.f8550b;
        int i2 = this.f8552d;
        this.f8552d = i2 + 1;
        bArr[i2] = (byte) i;
        b();
    }

    c(OutputStream outputStream, com.bumptech.glide.load.engine.a.b bVar, int i) {
        this.f8549a = outputStream;
        this.f8551c = bVar;
        this.f8550b = (byte[]) bVar.a(i, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            if (this.f8552d == 0 && i4 >= this.f8550b.length) {
                this.f8549a.write(bArr, i5, i4);
                return;
            }
            int min = Math.min(i4, this.f8550b.length - this.f8552d);
            System.arraycopy(bArr, i5, this.f8550b, this.f8552d, min);
            this.f8552d += min;
            i3 += min;
            b();
        } while (i3 < i2);
    }
}
