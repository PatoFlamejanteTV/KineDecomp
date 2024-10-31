package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: ByteArrayBuilder.java */
/* loaded from: classes.dex */
public final class a extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f441a = new byte[0];
    private final BufferRecycler b;
    private final LinkedList<byte[]> c;
    private int d;
    private byte[] e;
    private int f;

    public a() {
        this(null);
    }

    public a(BufferRecycler bufferRecycler) {
        this(bufferRecycler, 500);
    }

    public a(BufferRecycler bufferRecycler, int i) {
        this.c = new LinkedList<>();
        this.b = bufferRecycler;
        if (bufferRecycler == null) {
            this.e = new byte[i];
        } else {
            this.e = bufferRecycler.a(BufferRecycler.ByteBufferType.WRITE_CONCAT_BUFFER);
        }
    }

    public void a() {
        this.d = 0;
        this.f = 0;
        if (!this.c.isEmpty()) {
            this.c.clear();
        }
    }

    public void a(int i) {
        if (this.f >= this.e.length) {
            g();
        }
        byte[] bArr = this.e;
        int i2 = this.f;
        this.f = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public byte[] b() {
        int i = this.d + this.f;
        if (i == 0) {
            return f441a;
        }
        byte[] bArr = new byte[i];
        Iterator<byte[]> it = this.c.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            byte[] next = it.next();
            int length = next.length;
            System.arraycopy(next, 0, bArr, i2, length);
            i2 += length;
        }
        System.arraycopy(this.e, 0, bArr, i2, this.f);
        int i3 = this.f + i2;
        if (i3 != i) {
            throw new RuntimeException("Internal error: total len assumed to be " + i + ", copied " + i3 + " bytes");
        }
        if (!this.c.isEmpty()) {
            a();
        }
        return bArr;
    }

    public byte[] c() {
        a();
        return this.e;
    }

    public byte[] d() {
        g();
        return this.e;
    }

    public byte[] b(int i) {
        this.f = i;
        return b();
    }

    public byte[] e() {
        return this.e;
    }

    public void c(int i) {
        this.f = i;
    }

    public int f() {
        return this.f;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        while (true) {
            int min = Math.min(this.e.length - this.f, i2);
            if (min > 0) {
                System.arraycopy(bArr, i, this.e, this.f, min);
                i += min;
                this.f += min;
                i2 -= min;
            }
            if (i2 > 0) {
                g();
            } else {
                return;
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        a(i);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    private void g() {
        this.d += this.e.length;
        int max = Math.max(this.d >> 1, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED);
        int i = max <= 262144 ? max : 262144;
        this.c.add(this.e);
        this.e = new byte[i];
        this.f = 0;
    }
}
