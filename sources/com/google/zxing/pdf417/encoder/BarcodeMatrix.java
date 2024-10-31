package com.google.zxing.pdf417.encoder;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public final class BarcodeMatrix {

    /* renamed from: a */
    private final a[] f19214a;

    /* renamed from: b */
    private int f19215b;

    /* renamed from: c */
    private final int f19216c;

    /* renamed from: d */
    private final int f19217d;

    public BarcodeMatrix(int i, int i2) {
        this.f19214a = new a[i];
        int length = this.f19214a.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f19214a[i3] = new a(((i2 + 4) * 17) + 1);
        }
        this.f19217d = i2 * 17;
        this.f19216c = i;
        this.f19215b = -1;
    }

    public a a() {
        return this.f19214a[this.f19215b];
    }

    public void b() {
        this.f19215b++;
    }

    public byte[][] a(int i, int i2) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) byte.class, this.f19216c * i2, this.f19217d * i);
        int i3 = this.f19216c * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[(i3 - i4) - 1] = this.f19214a[i4 / i2].a(i);
        }
        return bArr;
    }
}
