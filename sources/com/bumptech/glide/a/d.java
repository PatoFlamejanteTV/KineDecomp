package com.bumptech.glide.a;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader.java */
/* loaded from: classes.dex */
public class d implements Closeable {

    /* renamed from: a */
    private final InputStream f8373a;

    /* renamed from: b */
    private final Charset f8374b;

    /* renamed from: c */
    private byte[] f8375c;

    /* renamed from: d */
    private int f8376d;

    /* renamed from: e */
    private int f8377e;

    public d(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() throws IOException {
        InputStream inputStream = this.f8373a;
        byte[] bArr = this.f8375c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f8376d = 0;
            this.f8377e = read;
            return;
        }
        throw new EOFException();
    }

    public String b() throws IOException {
        int i;
        int i2;
        synchronized (this.f8373a) {
            if (this.f8375c != null) {
                if (this.f8376d >= this.f8377e) {
                    c();
                }
                for (int i3 = this.f8376d; i3 != this.f8377e; i3++) {
                    if (this.f8375c[i3] == 10) {
                        if (i3 != this.f8376d) {
                            i2 = i3 - 1;
                            if (this.f8375c[i2] == 13) {
                                String str = new String(this.f8375c, this.f8376d, i2 - this.f8376d, this.f8374b.name());
                                this.f8376d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f8375c, this.f8376d, i2 - this.f8376d, this.f8374b.name());
                        this.f8376d = i3 + 1;
                        return str2;
                    }
                }
                c cVar = new c(this, (this.f8377e - this.f8376d) + 80);
                loop1: while (true) {
                    cVar.write(this.f8375c, this.f8376d, this.f8377e - this.f8376d);
                    this.f8377e = -1;
                    c();
                    i = this.f8376d;
                    while (i != this.f8377e) {
                        if (this.f8375c[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.f8376d) {
                    cVar.write(this.f8375c, this.f8376d, i - this.f8376d);
                }
                this.f8376d = i + 1;
                return cVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f8373a) {
            if (this.f8375c != null) {
                this.f8375c = null;
                this.f8373a.close();
            }
        }
    }

    public d(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (i >= 0) {
            if (charset.equals(e.f8378a)) {
                this.f8373a = inputStream;
                this.f8374b = charset;
                this.f8375c = new byte[i];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }

    public boolean a() {
        return this.f8377e == -1;
    }
}
