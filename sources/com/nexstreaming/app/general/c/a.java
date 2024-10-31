package com.nexstreaming.app.general.c;

import android.graphics.Color;
import android.graphics.ColorMatrix;

/* compiled from: NexTheme_Math.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static C0062a f3123a = new C0062a(1.164d, 0.0d, 1.596d, -0.871d, 1.164d, -0.392d, -0.813d, 0.53d, 1.164d, 2.017d, 0.0d, -1.081d, 0.0d, 0.0d, 0.0d, 1.0d);
    static C0062a b = new C0062a(1.164d, 0.0d, 1.596d, 0.0d, 1.164d, -0.392d, -0.813d, 0.0d, 1.164d, 2.017d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d);
    static C0062a c = new C0062a(0.257d, 0.504d, 0.098d, 0.0d, -0.148d, -0.291d, 0.439d, 0.0d, 0.439d, -0.368d, -0.071d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d);
    static C0062a d = new C0062a(0.257d, 0.504d, 0.098d, 0.0625d, -0.148d, -0.291d, 0.439d, 0.5d, 0.439d, -0.368d, -0.071d, 0.5d, 0.0d, 0.0d, 0.0d, 1.0d);
    static C0062a e = new C0062a(1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NexTheme_Math.java */
    /* renamed from: com.nexstreaming.app.general.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0062a {

        /* renamed from: a, reason: collision with root package name */
        float[] f3124a;

        C0062a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
            this.f3124a = new float[]{f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16};
        }

        C0062a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16) {
            this.f3124a = new float[]{(float) d, (float) d2, (float) d3, (float) d4, (float) d5, (float) d6, (float) d7, (float) d8, (float) d9, (float) d10, (float) d11, (float) d12, (float) d13, (float) d14, (float) d15, (float) d16};
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NexTheme_Math.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        float[] f3125a;

        b(float f, float f2, float f3, float f4) {
            this.f3125a = new float[]{f, f2, f3, f4};
        }

        b(double d, double d2, double d3, double d4) {
            this.f3125a = new float[]{(float) d, (float) d2, (float) d3, (float) d4};
        }
    }

    static C0062a a() {
        return new C0062a(1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d);
    }

    static C0062a a(float f, float f2, float f3) {
        return new C0062a(f, 0.0d, 0.0d, 0.0d, 0.0d, f2, 0.0d, 0.0d, 0.0d, 0.0d, f3, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d);
    }

    static C0062a a(b bVar) {
        return new C0062a(1.0d, 0.0d, 0.0d, bVar.f3125a[0], 0.0d, 1.0d, 0.0d, bVar.f3125a[1], 0.0d, 0.0d, 1.0d, bVar.f3125a[2], 0.0d, 0.0d, 0.0d, 1.0d);
    }

    static C0062a a(float f, float f2, float f3, b bVar, boolean z) {
        C0062a c0062a;
        C0062a a2;
        C0062a a3;
        if (f < -1.0d) {
            f = -1.0f;
        } else if (f > 1.0d) {
            f = 1.0f;
        }
        if (f2 < -1.0d) {
            f2 = -1.0f;
        } else if (f2 > 1.0d) {
            f2 = 1.0f;
        }
        if (z) {
            c0062a = new C0062a(1.0d, 0.0d, 1.402d, 0.0d, 1.0d, -0.344d, -0.714d, 0.0d, 1.0d, 1.772d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d);
        } else {
            c0062a = new C0062a(1.164d, 0.0d, 1.596d, 0.0d, 1.164d, -0.392d, -0.813d, 0.0d, 1.164d, 2.017d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d);
        }
        C0062a a4 = a(new b(f, 0.0d, 0.0d, 0.0d));
        C0062a a5 = a(a(a(new b(0.5d, 0.5d, 0.5d, 0.0d)), a(1.0f + f2, 1.0f + f2, 1.0f + f2)), a(new b(-0.5d, -0.5d, -0.5d, 0.0d)));
        if (z) {
            a2 = a(new b(0.0d, -0.5d, -0.5d, 0.0d));
        } else {
            a2 = a(new b(-0.0625d, -0.5d, -0.5d, 0.0d));
        }
        C0062a a6 = a(1.0f, 1.0f + f3, 1.0f + f3);
        float f4 = bVar.f3125a[0];
        float f5 = bVar.f3125a[1];
        float f6 = bVar.f3125a[2];
        if (f3 < 0.0f) {
            a3 = new C0062a(0.241f * f4, 0.691f * f4, f4 * 0.068f, 0.0d, 0.241f * f5, 0.691f * f5, f5 * 0.068f, 0.0d, 0.241f * f6, 0.691f * f6, f6 * 0.068f, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d);
            C0062a a7 = a();
            for (int i = 0; i < 16; i++) {
                a3.f3124a[i] = (a3.f3124a[i] * (1.0f - (1.0f + f3))) + (a7.f3124a[i] * (1.0f + f3));
            }
        } else {
            a3 = a();
        }
        return a(a3, a(a(a(c0062a, a(a6, a2)), a4), a5));
    }

    public static ColorMatrix a(float f, float f2, float f3, int i) {
        float[] fArr = a(f, f2, f3, new b(Color.red(i) / 255.0f, Color.green(i) / 255.0f, Color.blue(i) / 255.0f, 1.0f)).f3124a;
        return new ColorMatrix(new float[]{fArr[0], fArr[1], fArr[2], 0.0f, fArr[3], fArr[4], fArr[5], fArr[6], 0.0f, fArr[7], fArr[8], fArr[9], fArr[10], 0.0f, fArr[11], fArr[12], fArr[13], fArr[14], 1.0f, 0.0f});
    }

    static C0062a a(float f, float f2, float f3, b bVar) {
        return a(a(f, f2, f3, bVar, false), d);
    }

    static C0062a a(C0062a c0062a, C0062a c0062a2) {
        float[] fArr = c0062a2.f3124a;
        float[] fArr2 = c0062a.f3124a;
        return new C0062a((fArr[0] * fArr2[0]) + (fArr[4] * fArr2[1]) + (fArr[8] * fArr2[2]) + (fArr[12] * fArr2[3]), (fArr[1] * fArr2[0]) + (fArr[5] * fArr2[1]) + (fArr[9] * fArr2[2]) + (fArr[13] * fArr2[3]), (fArr[2] * fArr2[0]) + (fArr[6] * fArr2[1]) + (fArr[10] * fArr2[2]) + (fArr[14] * fArr2[3]), (fArr[3] * fArr2[0]) + (fArr[7] * fArr2[1]) + (fArr[11] * fArr2[2]) + (fArr[15] * fArr2[3]), (fArr[0] * fArr2[4]) + (fArr[4] * fArr2[5]) + (fArr[8] * fArr2[6]) + (fArr[12] * fArr2[7]), (fArr[1] * fArr2[4]) + (fArr[5] * fArr2[5]) + (fArr[9] * fArr2[6]) + (fArr[13] * fArr2[7]), (fArr[2] * fArr2[4]) + (fArr[6] * fArr2[5]) + (fArr[10] * fArr2[6]) + (fArr[14] * fArr2[7]), (fArr[3] * fArr2[4]) + (fArr[7] * fArr2[5]) + (fArr[11] * fArr2[6]) + (fArr[15] * fArr2[7]), (fArr[0] * fArr2[8]) + (fArr[4] * fArr2[9]) + (fArr[8] * fArr2[10]) + (fArr[12] * fArr2[11]), (fArr[1] * fArr2[8]) + (fArr[5] * fArr2[9]) + (fArr[9] * fArr2[10]) + (fArr[13] * fArr2[11]), (fArr[2] * fArr2[8]) + (fArr[6] * fArr2[9]) + (fArr[10] * fArr2[10]) + (fArr[14] * fArr2[11]), (fArr[3] * fArr2[8]) + (fArr[7] * fArr2[9]) + (fArr[11] * fArr2[10]) + (fArr[15] * fArr2[11]), (fArr[0] * fArr2[12]) + (fArr[4] * fArr2[13]) + (fArr[8] * fArr2[14]) + (fArr[12] * fArr2[15]), (fArr[1] * fArr2[12]) + (fArr[5] * fArr2[13]) + (fArr[9] * fArr2[14]) + (fArr[13] * fArr2[15]), (fArr[2] * fArr2[12]) + (fArr[6] * fArr2[13]) + (fArr[10] * fArr2[14]) + (fArr[14] * fArr2[15]), (fArr[15] * fArr2[15]) + (fArr[3] * fArr2[12]) + (fArr[7] * fArr2[13]) + (fArr[11] * fArr2[14]));
    }
}
