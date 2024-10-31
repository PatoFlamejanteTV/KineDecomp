package com.google.zxing.common;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class BitArray implements Cloneable {

    /* renamed from: a */
    private int[] f19065a;

    /* renamed from: b */
    private int f19066b;

    public BitArray() {
        this.f19066b = 0;
        this.f19065a = new int[1];
    }

    private static int[] c(int i) {
        return new int[(i + 31) / 32];
    }

    public int a() {
        return this.f19066b;
    }

    public int b() {
        return (this.f19066b + 7) / 8;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) obj;
        return this.f19066b == bitArray.f19066b && Arrays.equals(this.f19065a, bitArray.f19065a);
    }

    public int hashCode() {
        return (this.f19066b * 31) + Arrays.hashCode(this.f19065a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f19066b);
        for (int i = 0; i < this.f19066b; i++) {
            if ((i & 7) == 0) {
                sb.append(' ');
            }
            sb.append(a(i) ? 'X' : '.');
        }
        return sb.toString();
    }

    private void b(int i) {
        if (i > (this.f19065a.length << 5)) {
            int[] c2 = c(i);
            int[] iArr = this.f19065a;
            System.arraycopy(iArr, 0, c2, 0, iArr.length);
            this.f19065a = c2;
        }
    }

    public boolean a(int i) {
        return ((1 << (i & 31)) & this.f19065a[i / 32]) != 0;
    }

    /* renamed from: clone */
    public BitArray m19clone() {
        return new BitArray((int[]) this.f19065a.clone(), this.f19066b);
    }

    public void a(boolean z) {
        b(this.f19066b + 1);
        if (z) {
            int[] iArr = this.f19065a;
            int i = this.f19066b;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.f19066b++;
    }

    BitArray(int[] iArr, int i) {
        this.f19065a = iArr;
        this.f19066b = i;
    }

    public void a(int i, int i2) {
        if (i2 >= 0 && i2 <= 32) {
            b(this.f19066b + i2);
            while (i2 > 0) {
                boolean z = true;
                if (((i >> (i2 - 1)) & 1) != 1) {
                    z = false;
                }
                a(z);
                i2--;
            }
            return;
        }
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }

    public void b(BitArray bitArray) {
        if (this.f19066b != bitArray.f19066b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i = 0;
        while (true) {
            int[] iArr = this.f19065a;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = iArr[i] ^ bitArray.f19065a[i];
            i++;
        }
    }

    public void a(BitArray bitArray) {
        int i = bitArray.f19066b;
        b(this.f19066b + i);
        for (int i2 = 0; i2 < i; i2++) {
            a(bitArray.a(i2));
        }
    }

    public void a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = i4;
            int i7 = 0;
            for (int i8 = 0; i8 < 8; i8++) {
                if (a(i6)) {
                    i7 |= 1 << (7 - i8);
                }
                i6++;
            }
            bArr[i2 + i5] = (byte) i7;
            i5++;
            i4 = i6;
        }
    }
}
