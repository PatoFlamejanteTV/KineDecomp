package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ByteArrayOutputStream.java */
/* loaded from: classes3.dex */
public class a extends OutputStream {

    /* renamed from: a */
    private static final byte[] f29322a = new byte[0];

    /* renamed from: b */
    private final List<byte[]> f29323b;

    /* renamed from: c */
    private int f29324c;

    /* renamed from: d */
    private int f29325d;

    /* renamed from: e */
    private byte[] f29326e;

    /* renamed from: f */
    private int f29327f;

    public a() {
        this(1024);
    }

    private void a(int i) {
        if (this.f29324c < this.f29323b.size() - 1) {
            this.f29325d += this.f29326e.length;
            this.f29324c++;
            this.f29326e = this.f29323b.get(this.f29324c);
            return;
        }
        byte[] bArr = this.f29326e;
        if (bArr == null) {
            this.f29325d = 0;
        } else {
            i = Math.max(bArr.length << 1, i - this.f29325d);
            this.f29325d += this.f29326e.length;
        }
        this.f29324c++;
        this.f29326e = new byte[i];
        this.f29323b.add(this.f29326e);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public String toString() {
        return new String(a());
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        int i3;
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return;
        }
        synchronized (this) {
            int i4 = this.f29327f + i2;
            int i5 = this.f29327f - this.f29325d;
            while (i2 > 0) {
                int min = Math.min(i2, this.f29326e.length - i5);
                System.arraycopy(bArr, i3 - i2, this.f29326e, i5, min);
                i2 -= min;
                if (i2 > 0) {
                    a(i4);
                    i5 = 0;
                }
            }
            this.f29327f = i4;
        }
    }

    public a(int i) {
        this.f29323b = new ArrayList();
        if (i >= 0) {
            synchronized (this) {
                a(i);
            }
        } else {
            throw new IllegalArgumentException("Negative initial size: " + i);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        int i2 = this.f29327f - this.f29325d;
        if (i2 == this.f29326e.length) {
            a(this.f29327f + 1);
            i2 = 0;
        }
        this.f29326e[i2] = (byte) i;
        this.f29327f++;
    }

    public synchronized byte[] a() {
        int i = this.f29327f;
        if (i == 0) {
            return f29322a;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (byte[] bArr2 : this.f29323b) {
            int min = Math.min(bArr2.length, i);
            System.arraycopy(bArr2, 0, bArr, i2, min);
            i2 += min;
            i -= min;
            if (i == 0) {
                break;
            }
        }
        return bArr;
    }
}
