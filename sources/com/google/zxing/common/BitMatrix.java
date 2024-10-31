package com.google.zxing.common;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class BitMatrix implements Cloneable {

    /* renamed from: a */
    private final int f19067a;

    /* renamed from: b */
    private final int f19068b;

    /* renamed from: c */
    private final int f19069c;

    /* renamed from: d */
    private final int[] f19070d;

    public BitMatrix(int i) {
        this(i, i);
    }

    public boolean a(int i, int i2) {
        return ((this.f19070d[(i2 * this.f19069c) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public void b(int i, int i2) {
        int i3 = (i2 * this.f19069c) + (i / 32);
        int[] iArr = this.f19070d;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public int c() {
        return this.f19067a;
    }

    public String e(String str, String str2) {
        return a(str, str2, "\n");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitMatrix)) {
            return false;
        }
        BitMatrix bitMatrix = (BitMatrix) obj;
        return this.f19067a == bitMatrix.f19067a && this.f19068b == bitMatrix.f19068b && this.f19069c == bitMatrix.f19069c && Arrays.equals(this.f19070d, bitMatrix.f19070d);
    }

    public int hashCode() {
        int i = this.f19067a;
        return (((((((i * 31) + i) * 31) + this.f19068b) * 31) + this.f19069c) * 31) + Arrays.hashCode(this.f19070d);
    }

    public String toString() {
        return e("X ", "  ");
    }

    public BitMatrix(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.f19067a = i;
            this.f19068b = i2;
            this.f19069c = (i + 31) / 32;
            this.f19070d = new int[this.f19069c * i2];
            return;
        }
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }

    /* renamed from: clone */
    public BitMatrix m20clone() {
        return new BitMatrix(this.f19067a, this.f19068b, this.f19069c, (int[]) this.f19070d.clone());
    }

    public void a() {
        int length = this.f19070d.length;
        for (int i = 0; i < length; i++) {
            this.f19070d[i] = 0;
        }
    }

    public int b() {
        return this.f19068b;
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i4 > 0 && i3 > 0) {
            int i5 = i3 + i;
            int i6 = i4 + i2;
            if (i6 > this.f19068b || i5 > this.f19067a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = this.f19069c * i2;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.f19070d;
                    int i9 = (i8 / 32) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
            return;
        }
        throw new IllegalArgumentException("Height and width must be at least 1");
    }

    private BitMatrix(int i, int i2, int i3, int[] iArr) {
        this.f19067a = i;
        this.f19068b = i2;
        this.f19069c = i3;
        this.f19070d = iArr;
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f19068b * (this.f19067a + 1));
        for (int i = 0; i < this.f19068b; i++) {
            for (int i2 = 0; i2 < this.f19067a; i2++) {
                sb.append(a(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }
}
