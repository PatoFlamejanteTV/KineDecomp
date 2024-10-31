package com.google.zxing.common.reedsolomon;

import com.qq.e.comm.constants.ErrorCode;

/* loaded from: classes2.dex */
public final class GenericGF {

    /* renamed from: a */
    public static final GenericGF f19078a = new GenericGF(4201, 4096, 1);

    /* renamed from: b */
    public static final GenericGF f19079b = new GenericGF(1033, 1024, 1);

    /* renamed from: c */
    public static final GenericGF f19080c = new GenericGF(67, 64, 1);

    /* renamed from: d */
    public static final GenericGF f19081d = new GenericGF(19, 16, 1);

    /* renamed from: e */
    public static final GenericGF f19082e = new GenericGF(285, 256, 0);

    /* renamed from: f */
    public static final GenericGF f19083f;

    /* renamed from: g */
    public static final GenericGF f19084g;

    /* renamed from: h */
    public static final GenericGF f19085h;
    private final int[] i;
    private final int[] j;
    private final a k;
    private final a l;
    private final int m;
    private final int n;
    private final int o;

    static {
        GenericGF genericGF = new GenericGF(ErrorCode.InitError.INIT_ADMANGER_ERROR, 256, 1);
        f19083f = genericGF;
        f19084g = genericGF;
        f19085h = f19080c;
    }

    public GenericGF(int i, int i2, int i3) {
        this.n = i;
        this.m = i2;
        this.o = i3;
        this.i = new int[i2];
        this.j = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.i[i5] = i4;
            i4 <<= 1;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.j[this.i[i6]] = i6;
        }
        this.k = new a(this, new int[]{0});
        this.l = new a(this, new int[]{1});
    }

    public static int a(int i, int i2) {
        return i ^ i2;
    }

    public int a(int i) {
        return this.i[i];
    }

    public a b() {
        return this.k;
    }

    public int c(int i) {
        if (i != 0) {
            return this.j[i];
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.n) + ',' + this.m + ')';
    }

    public int a() {
        return this.o;
    }

    public a b(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.k;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new a(this, iArr);
    }

    public int c(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.i;
        int[] iArr2 = this.j;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.m - 1)];
    }

    public int b(int i) {
        if (i != 0) {
            return this.i[(this.m - this.j[i]) - 1];
        }
        throw new ArithmeticException();
    }
}
