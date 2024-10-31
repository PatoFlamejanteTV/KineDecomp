package c.d.a.a.e;

import android.graphics.Color;
import android.graphics.ColorMatrix;

/* compiled from: NexTheme_Math.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a */
    static C0012a f3568a = new C0012a(1.164d, 0.0d, 1.596d, -0.871d, 1.164d, -0.392d, -0.813d, 0.53d, 1.164d, 2.017d, 0.0d, -1.081d, 0.0d, 0.0d, 0.0d, 1.0d);

    /* renamed from: b */
    static C0012a f3569b = new C0012a(1.164d, 0.0d, 1.596d, 0.0d, 1.164d, -0.392d, -0.813d, 0.0d, 1.164d, 2.017d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d);

    /* renamed from: c */
    static C0012a f3570c = new C0012a(0.257d, 0.504d, 0.098d, 0.0d, -0.148d, -0.291d, 0.439d, 0.0d, 0.439d, -0.368d, -0.071d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d);

    /* renamed from: d */
    static C0012a f3571d = new C0012a(0.257d, 0.504d, 0.098d, 0.0625d, -0.148d, -0.291d, 0.439d, 0.5d, 0.439d, -0.368d, -0.071d, 0.5d, 0.0d, 0.0d, 0.0d, 1.0d);

    /* renamed from: e */
    static C0012a f3572e = new C0012a(1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d);

    static C0012a a() {
        return new C0012a(1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d);
    }

    /* compiled from: NexTheme_Math.java */
    /* renamed from: c.d.a.a.e.a$a */
    /* loaded from: classes2.dex */
    public static class C0012a {

        /* renamed from: a */
        float[] f3573a;

        C0012a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
            this.f3573a = new float[]{f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17};
        }

        C0012a(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17) {
            this.f3573a = new float[]{(float) d2, (float) d3, (float) d4, (float) d5, (float) d6, (float) d7, (float) d8, (float) d9, (float) d10, (float) d11, (float) d12, (float) d13, (float) d14, (float) d15, (float) d16, (float) d17};
        }
    }

    /* compiled from: NexTheme_Math.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a */
        float[] f3574a;

        b(float f2, float f3, float f4, float f5) {
            this.f3574a = new float[]{f2, f3, f4, f5};
        }

        b(double d2, double d3, double d4, double d5) {
            this.f3574a = new float[]{(float) d2, (float) d3, (float) d4, (float) d5};
        }
    }

    static C0012a a(float f2, float f3, float f4) {
        return new C0012a(f2, 0.0d, 0.0d, 0.0d, 0.0d, f3, 0.0d, 0.0d, 0.0d, 0.0d, f4, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d);
    }

    static C0012a a(b bVar) {
        float[] fArr = bVar.f3574a;
        return new C0012a(1.0d, 0.0d, 0.0d, fArr[0], 0.0d, 1.0d, 0.0d, fArr[1], 0.0d, 0.0d, 1.0d, fArr[2], 0.0d, 0.0d, 0.0d, 1.0d);
    }

    static C0012a a(float f2, float f3, float f4, b bVar, boolean z) {
        float f5;
        float f6;
        C0012a c0012a;
        C0012a a2;
        C0012a a3;
        double d2 = f2;
        if (d2 < -1.0d) {
            f6 = f3;
            f5 = -1.0f;
        } else if (d2 > 1.0d) {
            f6 = f3;
            f5 = 1.0f;
        } else {
            f5 = f2;
            f6 = f3;
        }
        double d3 = f6;
        if (d3 < -1.0d) {
            f6 = -1.0f;
        } else if (d3 > 1.0d) {
            f6 = 1.0f;
        }
        if (z) {
            c0012a = new C0012a(1.0d, 0.0d, 1.402d, 0.0d, 1.0d, -0.344d, -0.714d, 0.0d, 1.0d, 1.772d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d);
        } else {
            c0012a = new C0012a(1.164d, 0.0d, 1.596d, 0.0d, 1.164d, -0.392d, -0.813d, 0.0d, 1.164d, 2.017d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d);
        }
        C0012a a4 = a(new b(f5, 0.0d, 0.0d, 0.0d));
        float f7 = f6 + 1.0f;
        C0012a a5 = a(a(a(new b(0.5d, 0.5d, 0.5d, 0.0d)), a(f7, f7, f7)), a(new b(-0.5d, -0.5d, -0.5d, 0.0d)));
        if (z) {
            a2 = a(new b(0.0d, -0.5d, -0.5d, 0.0d));
        } else {
            a2 = a(new b(-0.0625d, -0.5d, -0.5d, 0.0d));
        }
        float f8 = f4 + 1.0f;
        C0012a a6 = a(1.0f, f8, f8);
        float[] fArr = bVar.f3574a;
        float f9 = fArr[0];
        float f10 = fArr[1];
        float f11 = fArr[2];
        if (f4 < 0.0f) {
            a3 = new C0012a(f9 * 0.241f, f9 * 0.691f, f9 * 0.068f, 0.0d, f10 * 0.241f, f10 * 0.691f, f10 * 0.068f, 0.0d, f11 * 0.241f, f11 * 0.691f, f11 * 0.068f, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d);
            C0012a a7 = a();
            for (int i = 0; i < 16; i++) {
                float[] fArr2 = a3.f3573a;
                fArr2[i] = (fArr2[i] * (1.0f - f8)) + (a7.f3573a[i] * f8);
            }
        } else {
            a3 = a();
        }
        return a(a3, a(a(a(c0012a, a(a6, a2)), a4), a5));
    }

    public static ColorMatrix a(float f2, float f3, float f4, int i) {
        float[] fArr = a(f2, f3, f4, new b(Color.red(i) / 255.0f, Color.green(i) / 255.0f, Color.blue(i) / 255.0f, 1.0f)).f3573a;
        return new ColorMatrix(new float[]{fArr[0], fArr[1], fArr[2], 0.0f, fArr[3], fArr[4], fArr[5], fArr[6], 0.0f, fArr[7], fArr[8], fArr[9], fArr[10], 0.0f, fArr[11], fArr[12], fArr[13], fArr[14], 1.0f, 0.0f});
    }

    static C0012a a(float f2, float f3, float f4, b bVar) {
        return a(a(f2, f3, f4, bVar, false), f3571d);
    }

    static C0012a a(C0012a c0012a, C0012a c0012a2) {
        float[] fArr = c0012a2.f3573a;
        float[] fArr2 = c0012a.f3573a;
        return new C0012a((fArr[0] * fArr2[0]) + (fArr[4] * fArr2[1]) + (fArr[8] * fArr2[2]) + (fArr[12] * fArr2[3]), (fArr[1] * fArr2[0]) + (fArr[5] * fArr2[1]) + (fArr[9] * fArr2[2]) + (fArr[13] * fArr2[3]), (fArr[2] * fArr2[0]) + (fArr[6] * fArr2[1]) + (fArr[10] * fArr2[2]) + (fArr[14] * fArr2[3]), (fArr[3] * fArr2[0]) + (fArr[7] * fArr2[1]) + (fArr[11] * fArr2[2]) + (fArr[15] * fArr2[3]), (fArr[0] * fArr2[4]) + (fArr[4] * fArr2[5]) + (fArr[8] * fArr2[6]) + (fArr[12] * fArr2[7]), (fArr[1] * fArr2[4]) + (fArr[5] * fArr2[5]) + (fArr[9] * fArr2[6]) + (fArr[13] * fArr2[7]), (fArr[2] * fArr2[4]) + (fArr[6] * fArr2[5]) + (fArr[10] * fArr2[6]) + (fArr[14] * fArr2[7]), (fArr[3] * fArr2[4]) + (fArr[7] * fArr2[5]) + (fArr[11] * fArr2[6]) + (fArr[15] * fArr2[7]), (fArr[0] * fArr2[8]) + (fArr[4] * fArr2[9]) + (fArr[8] * fArr2[10]) + (fArr[12] * fArr2[11]), (fArr[1] * fArr2[8]) + (fArr[5] * fArr2[9]) + (fArr[9] * fArr2[10]) + (fArr[13] * fArr2[11]), (fArr[2] * fArr2[8]) + (fArr[6] * fArr2[9]) + (fArr[10] * fArr2[10]) + (fArr[14] * fArr2[11]), (fArr[3] * fArr2[8]) + (fArr[7] * fArr2[9]) + (fArr[11] * fArr2[10]) + (fArr[15] * fArr2[11]), (fArr[0] * fArr2[12]) + (fArr[4] * fArr2[13]) + (fArr[8] * fArr2[14]) + (fArr[12] * fArr2[15]), (fArr[1] * fArr2[12]) + (fArr[5] * fArr2[13]) + (fArr[9] * fArr2[14]) + (fArr[13] * fArr2[15]), (fArr[2] * fArr2[12]) + (fArr[6] * fArr2[13]) + (fArr[10] * fArr2[14]) + (fArr[14] * fArr2[15]), (fArr[3] * fArr2[12]) + (fArr[7] * fArr2[13]) + (fArr[11] * fArr2[14]) + (fArr[15] * fArr2[15]));
    }
}
