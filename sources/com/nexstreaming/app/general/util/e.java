package com.nexstreaming.app.general.util;

/* compiled from: SimplexNoise.java */
/* loaded from: classes2.dex */
public class E {

    /* renamed from: a */
    private static a[] f19808a = {new a(1.0d, 1.0d, 0.0d), new a(-1.0d, 1.0d, 0.0d), new a(1.0d, -1.0d, 0.0d), new a(-1.0d, -1.0d, 0.0d), new a(1.0d, 0.0d, 1.0d), new a(-1.0d, 0.0d, 1.0d), new a(1.0d, 0.0d, -1.0d), new a(-1.0d, 0.0d, -1.0d), new a(0.0d, 1.0d, 1.0d), new a(0.0d, -1.0d, 1.0d), new a(0.0d, 1.0d, -1.0d), new a(0.0d, -1.0d, -1.0d)};

    /* renamed from: b */
    private static a[] f19809b = {new a(0.0d, 1.0d, 1.0d, 1.0d), new a(0.0d, 1.0d, 1.0d, -1.0d), new a(0.0d, 1.0d, -1.0d, 1.0d), new a(0.0d, 1.0d, -1.0d, -1.0d), new a(0.0d, -1.0d, 1.0d, 1.0d), new a(0.0d, -1.0d, 1.0d, -1.0d), new a(0.0d, -1.0d, -1.0d, 1.0d), new a(0.0d, -1.0d, -1.0d, -1.0d), new a(1.0d, 0.0d, 1.0d, 1.0d), new a(1.0d, 0.0d, 1.0d, -1.0d), new a(1.0d, 0.0d, -1.0d, 1.0d), new a(1.0d, 0.0d, -1.0d, -1.0d), new a(-1.0d, 0.0d, 1.0d, 1.0d), new a(-1.0d, 0.0d, 1.0d, -1.0d), new a(-1.0d, 0.0d, -1.0d, 1.0d), new a(-1.0d, 0.0d, -1.0d, -1.0d), new a(1.0d, 1.0d, 0.0d, 1.0d), new a(1.0d, 1.0d, 0.0d, -1.0d), new a(1.0d, -1.0d, 0.0d, 1.0d), new a(1.0d, -1.0d, 0.0d, -1.0d), new a(-1.0d, 1.0d, 0.0d, 1.0d), new a(-1.0d, 1.0d, 0.0d, -1.0d), new a(-1.0d, -1.0d, 0.0d, 1.0d), new a(-1.0d, -1.0d, 0.0d, -1.0d), new a(1.0d, 1.0d, 1.0d, 0.0d), new a(1.0d, 1.0d, -1.0d, 0.0d), new a(1.0d, -1.0d, 1.0d, 0.0d), new a(1.0d, -1.0d, -1.0d, 0.0d), new a(-1.0d, 1.0d, 1.0d, 0.0d), new a(-1.0d, 1.0d, -1.0d, 0.0d), new a(-1.0d, -1.0d, 1.0d, 0.0d), new a(-1.0d, -1.0d, -1.0d, 0.0d)};

    /* renamed from: c */
    private static short[] f19810c = {151, 160, 137, 91, 90, 15, 131, 13, 201, 95, 96, 53, 194, 233, 7, 225, 140, 36, 103, 30, 69, 142, 8, 99, 37, 240, 21, 10, 23, 190, 6, 148, 247, 120, 234, 75, 0, 26, 197, 62, 94, 252, 219, 203, 117, 35, 11, 32, 57, 177, 33, 88, 237, 149, 56, 87, 174, 20, 125, 136, 171, 168, 68, 175, 74, 165, 71, 134, 139, 48, 27, 166, 77, 146, 158, 231, 83, 111, 229, 122, 60, 211, 133, 230, 220, 105, 92, 41, 55, 46, 245, 40, 244, 102, 143, 54, 65, 25, 63, 161, 1, 216, 80, 73, 209, 76, 132, 187, 208, 89, 18, 169, 200, 196, 135, 130, 116, 188, 159, 86, 164, 100, 109, 198, 173, 186, 3, 64, 52, 217, 226, 250, 124, 123, 5, 202, 38, 147, 118, 126, 255, 82, 85, 212, 207, 206, 59, 227, 47, 16, 58, 17, 182, 189, 28, 42, 223, 183, 170, 213, 119, 248, 152, 2, 44, 154, 163, 70, 221, 153, 101, 155, 167, 43, 172, 9, 129, 22, 39, 253, 19, 98, 108, 110, 79, 113, 224, 232, 178, 185, 112, 104, 218, 246, 97, 228, 251, 34, 242, 193, 238, 210, 144, 12, 191, 179, 162, 241, 81, 51, 145, 235, 249, 14, 239, 107, 49, 192, 214, 31, 181, 199, 106, 157, 184, 84, 204, 176, 115, 121, 50, 45, 127, 4, 150, 254, 138, 236, 205, 93, 222, 114, 67, 29, 24, 72, 243, 141, 128, 195, 78, 66, 215, 61, 156, 180};

    /* renamed from: d */
    private static short[] f19811d = new short[512];

    /* renamed from: e */
    private static short[] f19812e = new short[512];

    /* renamed from: f */
    private static final double f19813f;

    /* renamed from: g */
    private static final double f19814g;

    /* renamed from: h */
    private static final double f19815h;
    private static final double i;

    static {
        for (int i2 = 0; i2 < 512; i2++) {
            short[] sArr = f19811d;
            sArr[i2] = f19810c[i2 & 255];
            f19812e[i2] = (short) (sArr[i2] % 12);
        }
        f19813f = (Math.sqrt(3.0d) - 1.0d) * 0.5d;
        f19814g = (3.0d - Math.sqrt(3.0d)) / 6.0d;
        f19815h = (Math.sqrt(5.0d) - 1.0d) / 4.0d;
        i = (5.0d - Math.sqrt(5.0d)) / 20.0d;
    }

    private static double a(a aVar, double d2, double d3, double d4) {
        return (aVar.f19816a * d2) + (aVar.f19817b * d3) + (aVar.f19818c * d4);
    }

    private static int a(double d2) {
        int i2 = (int) d2;
        return d2 < ((double) i2) ? i2 - 1 : i2;
    }

    public static double a(double d2, double d3, double d4) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        double a2;
        double a3;
        double a4;
        double d5 = (d2 + d3 + d4) * 0.3333333333333333d;
        int a5 = a(d2 + d5);
        int a6 = a(d3 + d5);
        int a7 = a(d4 + d5);
        double d6 = a5 + a6 + a7;
        Double.isNaN(d6);
        double d7 = d6 * 0.16666666666666666d;
        double d8 = a5;
        Double.isNaN(d8);
        double d9 = a6;
        Double.isNaN(d9);
        double d10 = a7;
        Double.isNaN(d10);
        double d11 = d2 - (d8 - d7);
        double d12 = d3 - (d9 - d7);
        double d13 = d4 - (d10 - d7);
        int i7 = 0;
        if (d11 < d12) {
            if (d12 < d13) {
                i2 = 0;
                i3 = 1;
            } else if (d11 < d13) {
                i2 = 1;
                i3 = 0;
            } else {
                i2 = 1;
                i3 = 0;
                i4 = 1;
                i5 = 1;
                i6 = 0;
            }
            i4 = 0;
            i5 = 1;
            i6 = 1;
        } else if (d12 >= d13) {
            i7 = 1;
            i2 = 0;
            i3 = 0;
            i4 = 1;
            i5 = 1;
            i6 = 0;
        } else {
            if (d11 >= d13) {
                i7 = 1;
                i2 = 0;
                i3 = 0;
            } else {
                i2 = 0;
                i3 = 1;
            }
            i4 = 1;
            i5 = 0;
            i6 = 1;
        }
        double d14 = i7;
        Double.isNaN(d14);
        double d15 = (d11 - d14) + 0.16666666666666666d;
        double d16 = i2;
        Double.isNaN(d16);
        double d17 = (d12 - d16) + 0.16666666666666666d;
        double d18 = i3;
        Double.isNaN(d18);
        double d19 = (d13 - d18) + 0.16666666666666666d;
        double d20 = i4;
        Double.isNaN(d20);
        double d21 = (d11 - d20) + 0.3333333333333333d;
        double d22 = i5;
        Double.isNaN(d22);
        double d23 = (d12 - d22) + 0.3333333333333333d;
        double d24 = i6;
        Double.isNaN(d24);
        double d25 = (d13 - d24) + 0.3333333333333333d;
        double d26 = (d11 - 1.0d) + 0.5d;
        double d27 = (d12 - 1.0d) + 0.5d;
        double d28 = (d13 - 1.0d) + 0.5d;
        int i8 = a5 & 255;
        int i9 = a6 & 255;
        int i10 = a7 & 255;
        short[] sArr = f19812e;
        short[] sArr2 = f19811d;
        short s = sArr[sArr2[sArr2[i10] + i9] + i8];
        short s2 = sArr[i7 + i8 + sArr2[i2 + i9 + sArr2[i3 + i10]]];
        short s3 = sArr[i4 + i8 + sArr2[i5 + i9 + sArr2[i6 + i10]]];
        short s4 = sArr[i8 + 1 + sArr2[i9 + 1 + sArr2[i10 + 1]]];
        double d29 = ((0.6d - (d11 * d11)) - (d12 * d12)) - (d13 * d13);
        double d30 = 0.0d;
        if (d29 < 0.0d) {
            a2 = 0.0d;
        } else {
            double d31 = d29 * d29;
            a2 = d31 * d31 * a(f19808a[s], d11, d12, d13);
        }
        double d32 = ((0.6d - (d15 * d15)) - (d17 * d17)) - (d19 * d19);
        if (d32 < 0.0d) {
            a3 = 0.0d;
        } else {
            double d33 = d32 * d32;
            a3 = d33 * d33 * a(f19808a[s2], d15, d17, d19);
        }
        double d34 = ((0.6d - (d21 * d21)) - (d23 * d23)) - (d25 * d25);
        if (d34 < 0.0d) {
            a4 = 0.0d;
        } else {
            double d35 = d34 * d34;
            a4 = a(f19808a[s3], d21, d23, d25) * d35 * d35;
        }
        double d36 = ((0.6d - (d26 * d26)) - (d27 * d27)) - (d28 * d28);
        if (d36 >= 0.0d) {
            double d37 = d36 * d36;
            d30 = d37 * d37 * a(f19808a[s4], d26, d27, d28);
        }
        return (a2 + a3 + a4 + d30) * 32.0d;
    }

    /* compiled from: SimplexNoise.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        double f19816a;

        /* renamed from: b */
        double f19817b;

        /* renamed from: c */
        double f19818c;

        /* renamed from: d */
        double f19819d;

        a(double d2, double d3, double d4) {
            this.f19816a = d2;
            this.f19817b = d3;
            this.f19818c = d4;
        }

        a(double d2, double d3, double d4, double d5) {
            this.f19816a = d2;
            this.f19817b = d3;
            this.f19818c = d4;
            this.f19819d = d5;
        }
    }
}
