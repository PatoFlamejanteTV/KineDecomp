package com.nexstreaming.app.general.util;

/* compiled from: SimplexNoise.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private static a[] f3239a = {new a(1.0d, 1.0d, 0.0d), new a(-1.0d, 1.0d, 0.0d), new a(1.0d, -1.0d, 0.0d), new a(-1.0d, -1.0d, 0.0d), new a(1.0d, 0.0d, 1.0d), new a(-1.0d, 0.0d, 1.0d), new a(1.0d, 0.0d, -1.0d), new a(-1.0d, 0.0d, -1.0d), new a(0.0d, 1.0d, 1.0d), new a(0.0d, -1.0d, 1.0d), new a(0.0d, 1.0d, -1.0d), new a(0.0d, -1.0d, -1.0d)};
    private static a[] b = {new a(0.0d, 1.0d, 1.0d, 1.0d), new a(0.0d, 1.0d, 1.0d, -1.0d), new a(0.0d, 1.0d, -1.0d, 1.0d), new a(0.0d, 1.0d, -1.0d, -1.0d), new a(0.0d, -1.0d, 1.0d, 1.0d), new a(0.0d, -1.0d, 1.0d, -1.0d), new a(0.0d, -1.0d, -1.0d, 1.0d), new a(0.0d, -1.0d, -1.0d, -1.0d), new a(1.0d, 0.0d, 1.0d, 1.0d), new a(1.0d, 0.0d, 1.0d, -1.0d), new a(1.0d, 0.0d, -1.0d, 1.0d), new a(1.0d, 0.0d, -1.0d, -1.0d), new a(-1.0d, 0.0d, 1.0d, 1.0d), new a(-1.0d, 0.0d, 1.0d, -1.0d), new a(-1.0d, 0.0d, -1.0d, 1.0d), new a(-1.0d, 0.0d, -1.0d, -1.0d), new a(1.0d, 1.0d, 0.0d, 1.0d), new a(1.0d, 1.0d, 0.0d, -1.0d), new a(1.0d, -1.0d, 0.0d, 1.0d), new a(1.0d, -1.0d, 0.0d, -1.0d), new a(-1.0d, 1.0d, 0.0d, 1.0d), new a(-1.0d, 1.0d, 0.0d, -1.0d), new a(-1.0d, -1.0d, 0.0d, 1.0d), new a(-1.0d, -1.0d, 0.0d, -1.0d), new a(1.0d, 1.0d, 1.0d, 0.0d), new a(1.0d, 1.0d, -1.0d, 0.0d), new a(1.0d, -1.0d, 1.0d, 0.0d), new a(1.0d, -1.0d, -1.0d, 0.0d), new a(-1.0d, 1.0d, 1.0d, 0.0d), new a(-1.0d, 1.0d, -1.0d, 0.0d), new a(-1.0d, -1.0d, 1.0d, 0.0d), new a(-1.0d, -1.0d, -1.0d, 0.0d)};
    private static short[] c = {151, 160, 137, 91, 90, 15, 131, 13, 201, 95, 96, 53, 194, 233, 7, 225, 140, 36, 103, 30, 69, 142, 8, 99, 37, 240, 21, 10, 23, 190, 6, 148, 247, 120, 234, 75, 0, 26, 197, 62, 94, 252, 219, 203, 117, 35, 11, 32, 57, 177, 33, 88, 237, 149, 56, 87, 174, 20, 125, 136, 171, 168, 68, 175, 74, 165, 71, 134, 139, 48, 27, 166, 77, 146, 158, 231, 83, 111, 229, 122, 60, 211, 133, 230, 220, 105, 92, 41, 55, 46, 245, 40, 244, 102, 143, 54, 65, 25, 63, 161, 1, 216, 80, 73, 209, 76, 132, 187, 208, 89, 18, 169, 200, 196, 135, 130, 116, 188, 159, 86, 164, 100, 109, 198, 173, 186, 3, 64, 52, 217, 226, 250, 124, 123, 5, 202, 38, 147, 118, 126, 255, 82, 85, 212, 207, 206, 59, 227, 47, 16, 58, 17, 182, 189, 28, 42, 223, 183, 170, 213, 119, 248, 152, 2, 44, 154, 163, 70, 221, 153, 101, 155, 167, 43, 172, 9, 129, 22, 39, 253, 19, 98, 108, 110, 79, 113, 224, 232, 178, 185, 112, 104, 218, 246, 97, 228, 251, 34, 242, 193, 238, 210, 144, 12, 191, 179, 162, 241, 81, 51, 145, 235, 249, 14, 239, 107, 49, 192, 214, 31, 181, 199, 106, 157, 184, 84, 204, 176, 115, 121, 50, 45, 127, 4, 150, 254, 138, 236, 205, 93, 222, 114, 67, 29, 24, 72, 243, 141, 128, 195, 78, 66, 215, 61, 156, 180};
    private static short[] d = new short[512];
    private static short[] e = new short[512];
    private static final double f;
    private static final double g;
    private static final double h;
    private static final double i;

    static {
        for (int i2 = 0; i2 < 512; i2++) {
            d[i2] = c[i2 & 255];
            e[i2] = (short) (d[i2] % 12);
        }
        f = 0.5d * (Math.sqrt(3.0d) - 1.0d);
        g = (3.0d - Math.sqrt(3.0d)) / 6.0d;
        h = (Math.sqrt(5.0d) - 1.0d) / 4.0d;
        i = (5.0d - Math.sqrt(5.0d)) / 20.0d;
    }

    private static int a(double d2) {
        int i2 = (int) d2;
        return d2 < ((double) i2) ? i2 - 1 : i2;
    }

    private static double a(a aVar, double d2, double d3, double d4) {
        return (aVar.f3240a * d2) + (aVar.b * d3) + (aVar.c * d4);
    }

    public static double a(double d2, double d3, double d4) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        double a2;
        double a3;
        double a4;
        double a5;
        double d5 = (d2 + d3 + d4) * 0.3333333333333333d;
        int a6 = a(d2 + d5);
        int a7 = a(d3 + d5);
        int a8 = a(d5 + d4);
        double d6 = (a6 + a7 + a8) * 0.16666666666666666d;
        double d7 = d2 - (a6 - d6);
        double d8 = d3 - (a7 - d6);
        double d9 = d4 - (a8 - d6);
        if (d7 >= d8) {
            if (d8 >= d9) {
                i2 = 1;
                i3 = 0;
                i4 = 0;
                i5 = 1;
                i6 = 1;
                i7 = 0;
            } else if (d7 >= d9) {
                i2 = 1;
                i3 = 0;
                i4 = 0;
                i5 = 1;
                i6 = 0;
                i7 = 1;
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 1;
                i5 = 1;
                i6 = 0;
                i7 = 1;
            }
        } else if (d8 < d9) {
            i2 = 0;
            i3 = 0;
            i4 = 1;
            i5 = 0;
            i6 = 1;
            i7 = 1;
        } else if (d7 < d9) {
            i2 = 0;
            i3 = 1;
            i4 = 0;
            i5 = 0;
            i6 = 1;
            i7 = 1;
        } else {
            i2 = 0;
            i3 = 1;
            i4 = 0;
            i5 = 1;
            i6 = 1;
            i7 = 0;
        }
        double d10 = (d7 - i2) + 0.16666666666666666d;
        double d11 = (d8 - i3) + 0.16666666666666666d;
        double d12 = (d9 - i4) + 0.16666666666666666d;
        double d13 = (d7 - i5) + 0.3333333333333333d;
        double d14 = (d8 - i6) + 0.3333333333333333d;
        double d15 = (d9 - i7) + 0.3333333333333333d;
        double d16 = (d7 - 1.0d) + 0.5d;
        double d17 = (d8 - 1.0d) + 0.5d;
        double d18 = (d9 - 1.0d) + 0.5d;
        int i8 = a6 & 255;
        int i9 = a7 & 255;
        int i10 = a8 & 255;
        short s = e[d[d[i10] + i9] + i8];
        short s2 = e[d[d[i4 + i10] + i3 + i9] + i2 + i8];
        short s3 = e[d[d[i7 + i10] + i6 + i9] + i5 + i8];
        short s4 = e[i8 + 1 + d[i9 + 1 + d[i10 + 1]]];
        double d19 = ((0.6d - (d7 * d7)) - (d8 * d8)) - (d9 * d9);
        if (d19 < 0.0d) {
            a2 = 0.0d;
        } else {
            double d20 = d19 * d19;
            a2 = a(f3239a[s], d7, d8, d9) * d20 * d20;
        }
        double d21 = ((0.6d - (d10 * d10)) - (d11 * d11)) - (d12 * d12);
        if (d21 < 0.0d) {
            a3 = 0.0d;
        } else {
            double d22 = d21 * d21;
            a3 = a(f3239a[s2], d10, d11, d12) * d22 * d22;
        }
        double d23 = ((0.6d - (d13 * d13)) - (d14 * d14)) - (d15 * d15);
        if (d23 < 0.0d) {
            a4 = 0.0d;
        } else {
            double d24 = d23 * d23;
            a4 = a(f3239a[s3], d13, d14, d15) * d24 * d24;
        }
        double d25 = ((0.6d - (d16 * d16)) - (d17 * d17)) - (d18 * d18);
        if (d25 < 0.0d) {
            a5 = 0.0d;
        } else {
            double d26 = d25 * d25;
            a5 = a(f3239a[s4], d16, d17, d18) * d26 * d26;
        }
        return (a5 + a2 + a3 + a4) * 32.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SimplexNoise.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        double f3240a;
        double b;
        double c;
        double d;

        a(double d, double d2, double d3) {
            this.f3240a = d;
            this.b = d2;
            this.c = d3;
        }

        a(double d, double d2, double d3, double d4) {
            this.f3240a = d;
            this.b = d2;
            this.c = d3;
            this.d = d4;
        }
    }
}
