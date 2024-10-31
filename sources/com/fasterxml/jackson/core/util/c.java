package com.fasterxml.jackson.core.util;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: ByteArrayBuilder.java */
/* loaded from: classes.dex */
public final class c extends OutputStream {

    /* renamed from: a */
    public static final byte[] f9805a = new byte[0];

    /* renamed from: b */
    private final a f9806b;

    /* renamed from: c */
    private final LinkedList<byte[]> f9807c;

    /* renamed from: d */
    private int f9808d;

    /* renamed from: e */
    private byte[] f9809e;

    /* renamed from: f */
    private int f9810f;

    public c(a aVar) {
        this(aVar, 500);
    }

    private void v() {
        int length = this.f9808d + this.f9809e.length;
        if (length >= 0) {
            this.f9808d = length;
            int max = Math.max(this.f9808d >> 1, 1000);
            if (max > 262144) {
                max = 262144;
            }
            this.f9807c.add(this.f9809e);
            this.f9809e = new byte[max];
            this.f9810f = 0;
            return;
        }
        throw new IllegalStateException("Maximum Java array size (2GB) exceeded by `ByteArrayBuilder`");
    }

    public void a(int i) {
        if (this.f9810f >= this.f9809e.length) {
            v();
        }
        byte[] bArr = this.f9809e;
        int i2 = this.f9810f;
        this.f9810f = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public byte[] b(int i) {
        this.f9810f = i;
        return u();
    }

    public void c(int i) {
        this.f9810f = i;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    public void r() {
        this.f9808d = 0;
        this.f9810f = 0;
        if (this.f9807c.isEmpty()) {
            return;
        }
        this.f9807c.clear();
    }

    public byte[] s() {
        r();
        return this.f9809e;
    }

    public byte[] u() {
        int i = this.f9808d + this.f9810f;
        if (i == 0) {
            return f9805a;
        }
        byte[] bArr = new byte[i];
        Iterator<byte[]> it = this.f9807c.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            byte[] next = it.next();
            int length = next.length;
            System.arraycopy(next, 0, bArr, i2, length);
            i2 += length;
        }
        System.arraycopy(this.f9809e, 0, bArr, i2, this.f9810f);
        int i3 = i2 + this.f9810f;
        if (i3 == i) {
            if (!this.f9807c.isEmpty()) {
                r();
            }
            return bArr;
        }
        throw new RuntimeException("Internal error: total len assumed to be " + i + ", copied " + i3 + " bytes");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public c(a aVar, int i) {
        this.f9807c = new LinkedList<>();
        this.f9806b = aVar;
        this.f9809e = aVar == null ? new byte[i] : aVar.a(2);
    }

    public int c() {
        return this.f9810f;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        while (true) {
            int min = Math.min(this.f9809e.length - this.f9810f, i2);
            if (min > 0) {
                System.arraycopy(bArr, i, this.f9809e, this.f9810f, min);
                i += min;
                this.f9810f += min;
                i2 -= min;
            }
            if (i2 <= 0) {
                return;
            } else {
                v();
            }
        }
    }

    public byte[] b() {
        return this.f9809e;
    }

    public byte[] a() {
        v();
        return this.f9809e;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        a(i);
    }
}
