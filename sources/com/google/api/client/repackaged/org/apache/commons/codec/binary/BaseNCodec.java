package com.google.api.client.repackaged.org.apache.commons.codec.binary;

import com.facebook.internal.Utility;
import com.google.api.client.repackaged.org.apache.commons.codec.BinaryDecoder;
import com.google.api.client.repackaged.org.apache.commons.codec.BinaryEncoder;

/* loaded from: classes.dex */
public abstract class BaseNCodec implements BinaryDecoder, BinaryEncoder {

    /* renamed from: a, reason: collision with root package name */
    private final int f2505a;
    protected final byte b = 61;
    protected final int c;
    protected byte[] d;
    protected int e;
    protected boolean f;
    protected int g;
    protected int h;
    private final int i;
    private final int j;
    private int k;

    abstract void a(byte[] bArr, int i, int i2);

    protected abstract boolean a(byte b);

    abstract void b(byte[] bArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseNCodec(int i, int i2, int i3, int i4) {
        this.f2505a = i;
        this.i = i2;
        this.c = (i3 <= 0 || i4 <= 0) ? 0 : (i3 / i2) * i2;
        this.j = i4;
    }

    int a() {
        if (this.d != null) {
            return this.e - this.k;
        }
        return 0;
    }

    protected int b() {
        return Utility.DEFAULT_STREAM_BUFFER_SIZE;
    }

    private void c() {
        if (this.d == null) {
            this.d = new byte[b()];
            this.e = 0;
            this.k = 0;
        } else {
            byte[] bArr = new byte[this.d.length * 2];
            System.arraycopy(this.d, 0, bArr, 0, this.d.length);
            this.d = bArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        if (this.d == null || this.d.length < this.e + i) {
            c();
        }
    }

    int c(byte[] bArr, int i, int i2) {
        if (this.d == null) {
            return this.f ? -1 : 0;
        }
        int min = Math.min(a(), i2);
        System.arraycopy(this.d, this.k, bArr, i, min);
        this.k += min;
        if (this.k >= this.e) {
            this.d = null;
            return min;
        }
        return min;
    }

    private void d() {
        this.d = null;
        this.e = 0;
        this.k = 0;
        this.g = 0;
        this.h = 0;
        this.f = false;
    }

    public byte[] b(String str) {
        return d(StringUtils.a(str));
    }

    public byte[] d(byte[] bArr) {
        d();
        if (bArr != null && bArr.length != 0) {
            b(bArr, 0, bArr.length);
            b(bArr, 0, -1);
            byte[] bArr2 = new byte[this.e];
            c(bArr2, 0, bArr2.length);
            return bArr2;
        }
        return bArr;
    }

    public byte[] e(byte[] bArr) {
        d();
        if (bArr != null && bArr.length != 0) {
            a(bArr, 0, bArr.length);
            a(bArr, 0, -1);
            byte[] bArr2 = new byte[this.e - this.k];
            c(bArr2, 0, bArr2.length);
            return bArr2;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if (61 == b || a(b)) {
                return true;
            }
        }
        return false;
    }

    public long g(byte[] bArr) {
        long length = (((bArr.length + this.f2505a) - 1) / this.f2505a) * this.i;
        if (this.c > 0) {
            return length + ((((this.c + length) - 1) / this.c) * this.j);
        }
        return length;
    }
}
