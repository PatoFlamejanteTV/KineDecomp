package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;

/* compiled from: MiscUtils.java */
/* renamed from: com.airbnb.lottie.ua */
/* loaded from: classes.dex */
public class C0676ua {
    public static double a(double d2, double d3, double d4) {
        return d2 + (d4 * (d3 - d2));
    }

    public static int a(int i, int i2, float f2) {
        return (int) (i + (f2 * (i2 - i)));
    }

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    private static int b(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }

    public static void a(Oa oa, Path path) {
        path.reset();
        PointF b2 = oa.b();
        path.moveTo(b2.x, b2.y);
        for (int i = 0; i < oa.a().size(); i++) {
            L l = oa.a().get(i);
            path.cubicTo(l.a().x, l.a().y, l.b().x, l.b().y, l.c().x, l.c().y);
        }
        if (oa.c()) {
            path.close();
        }
    }

    public static int a(float f2, float f3) {
        return a((int) f2, (int) f3);
    }

    static int a(int i, int i2) {
        return i - (b(i, i2) * i2);
    }

    public static float a(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f4, f2));
    }
}
