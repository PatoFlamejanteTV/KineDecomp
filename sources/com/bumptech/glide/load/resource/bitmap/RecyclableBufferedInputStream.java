package com.bumptech.glide.load.resource.bitmap;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: a */
    private volatile byte[] f9004a;

    /* renamed from: b */
    private int f9005b;

    /* renamed from: c */
    private int f9006c;

    /* renamed from: d */
    private int f9007d;

    /* renamed from: e */
    private int f9008e;

    /* renamed from: f */
    private final com.bumptech.glide.load.engine.a.b f9009f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(InputStream inputStream, com.bumptech.glide.load.engine.a.b bVar) {
        this(inputStream, bVar, 65536);
    }

    private static IOException c() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void a() {
        this.f9006c = this.f9004a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f9004a != null && inputStream != null) {
        } else {
            c();
            throw null;
        }
        return (this.f9005b - this.f9008e) + inputStream.available();
    }

    public synchronized void b() {
        if (this.f9004a != null) {
            this.f9009f.put(this.f9004a);
            this.f9004a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f9004a != null) {
            this.f9009f.put(this.f9004a);
            this.f9004a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.f9006c = Math.max(this.f9006c, i);
        this.f9007d = this.f9008e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f9004a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr != null && inputStream != null) {
            if (this.f9008e >= this.f9005b && a(inputStream, bArr) == -1) {
                return -1;
            }
            if (bArr != this.f9004a && (bArr = this.f9004a) == null) {
                c();
                throw null;
            }
            if (this.f9005b - this.f9008e <= 0) {
                return -1;
            }
            int i = this.f9008e;
            this.f9008e = i + 1;
            return bArr[i] & 255;
        }
        c();
        throw null;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f9004a != null) {
            if (-1 != this.f9007d) {
                this.f9008e = this.f9007d;
            } else {
                throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f9008e + " markLimit: " + this.f9006c);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.f9004a;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream == null) {
                c();
                throw null;
            }
            if (this.f9005b - this.f9008e >= j) {
                this.f9008e = (int) (this.f9008e + j);
                return j;
            }
            long j2 = this.f9005b - this.f9008e;
            this.f9008e = this.f9005b;
            if (this.f9007d != -1 && j <= this.f9006c) {
                if (a(inputStream, bArr) == -1) {
                    return j2;
                }
                if (this.f9005b - this.f9008e >= j - j2) {
                    this.f9008e = (int) ((this.f9008e + j) - j2);
                    return j;
                }
                long j3 = (j2 + this.f9005b) - this.f9008e;
                this.f9008e = this.f9005b;
                return j3;
            }
            return j2 + inputStream.skip(j - j2);
        }
        c();
        throw null;
    }

    RecyclableBufferedInputStream(InputStream inputStream, com.bumptech.glide.load.engine.a.b bVar, int i) {
        super(inputStream);
        this.f9007d = -1;
        this.f9009f = bVar;
        this.f9004a = (byte[]) bVar.a(i, byte[].class);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.f9007d;
        if (i != -1) {
            int i2 = this.f9008e - i;
            int i3 = this.f9006c;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.f9005b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length > i3) {
                        length = i3;
                    }
                    byte[] bArr2 = (byte[]) this.f9009f.a(length, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f9004a = bArr2;
                    this.f9009f.put(bArr);
                    bArr = bArr2;
                } else {
                    int i4 = this.f9007d;
                    if (i4 > 0) {
                        System.arraycopy(bArr, i4, bArr, 0, bArr.length - i4);
                    }
                }
                this.f9008e -= this.f9007d;
                this.f9007d = 0;
                this.f9005b = 0;
                int i5 = this.f9008e;
                int read = inputStream.read(bArr, i5, bArr.length - i5);
                this.f9005b = read <= 0 ? this.f9008e : this.f9008e + read;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f9007d = -1;
            this.f9008e = 0;
            this.f9005b = read2;
        }
        return read2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        byte[] bArr2 = this.f9004a;
        if (bArr2 == null) {
            c();
            throw null;
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            if (this.f9008e < this.f9005b) {
                int i5 = this.f9005b - this.f9008e >= i2 ? i2 : this.f9005b - this.f9008e;
                System.arraycopy(bArr2, this.f9008e, bArr, i, i5);
                this.f9008e += i5;
                if (i5 == i2 || inputStream.available() == 0) {
                    return i5;
                }
                i += i5;
                i3 = i2 - i5;
            } else {
                i3 = i2;
            }
            while (true) {
                if (this.f9007d == -1 && i3 >= bArr2.length) {
                    i4 = inputStream.read(bArr, i, i3);
                    if (i4 == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                    if (bArr2 != this.f9004a && (bArr2 = this.f9004a) == null) {
                        c();
                        throw null;
                    }
                    i4 = this.f9005b - this.f9008e >= i3 ? i3 : this.f9005b - this.f9008e;
                    System.arraycopy(bArr2, this.f9008e, bArr, i, i4);
                    this.f9008e += i4;
                }
                i3 -= i4;
                if (i3 == 0) {
                    return i2;
                }
                if (inputStream.available() == 0) {
                    return i2 - i3;
                }
                i += i4;
            }
        } else {
            c();
            throw null;
        }
    }
}
