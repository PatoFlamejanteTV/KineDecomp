package com.bumptech.glide.load.a;

import com.facebook.stetho.dumpapp.Framer;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ExifOrientationStream.java */
/* loaded from: classes.dex */
public final class h extends FilterInputStream {

    /* renamed from: a */
    private static final byte[] f8556a = {-1, -31, 0, 28, 69, Framer.EXIT_FRAME_PREFIX, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    /* renamed from: b */
    private static final int f8557b = f8556a.length;

    /* renamed from: c */
    private static final int f8558c = f8557b + 2;

    /* renamed from: d */
    private final byte f8559d;

    /* renamed from: e */
    private int f8560e;

    public h(InputStream inputStream, int i) {
        super(inputStream);
        if (i >= -1 && i <= 8) {
            this.f8559d = (byte) i;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read;
        int i;
        int i2 = this.f8560e;
        if (i2 < 2 || i2 > (i = f8558c)) {
            read = super.read();
        } else if (i2 == i) {
            read = this.f8559d;
        } else {
            read = f8556a[i2 - 2] & 255;
        }
        if (read != -1) {
            this.f8560e++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = super.skip(j);
        if (skip > 0) {
            this.f8560e = (int) (this.f8560e + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4 = this.f8560e;
        int i5 = f8558c;
        if (i4 > i5) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == i5) {
            bArr[i] = this.f8559d;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int min = Math.min(i5 - i4, i2);
            System.arraycopy(f8556a, this.f8560e - 2, bArr, i, min);
            i3 = min;
        }
        if (i3 > 0) {
            this.f8560e += i3;
        }
        return i3;
    }
}
