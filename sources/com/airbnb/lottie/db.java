package com.airbnb.lottie;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.io.Closeable;

/* compiled from: Utils.java */
/* loaded from: classes.dex */
public final class db {

    /* renamed from: a */
    private static final PathMeasure f7764a = new PathMeasure();

    /* renamed from: b */
    private static final Path f7765b = new Path();

    /* renamed from: c */
    private static final Path f7766c = new Path();

    /* renamed from: d */
    private static final float[] f7767d = new float[4];

    /* renamed from: e */
    private static final float f7768e = (float) Math.sqrt(2.0d);

    public static Path a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF3.length() != 0.0f && pointF4 != null && pointF4.length() != 0.0f) {
            float f2 = pointF3.x + pointF.x;
            float f3 = pointF.y + pointF3.y;
            float f4 = pointF2.x;
            float f5 = f4 + pointF4.x;
            float f6 = pointF2.y;
            path.cubicTo(f2, f3, f5, f6 + pointF4.y, f4, f6);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static float a(Matrix matrix) {
        float[] fArr = f7767d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = f7768e;
        fArr[2] = f2;
        fArr[3] = f2;
        matrix.mapPoints(fArr);
        float[] fArr2 = f7767d;
        return ((float) Math.hypot(fArr2[2] - fArr2[0], fArr2[3] - fArr2[1])) / 2.0f;
    }

    public static void a(Path path, cb cbVar) {
        if (cbVar == null) {
            return;
        }
        a(path, cbVar.d().b().floatValue() / 100.0f, cbVar.b().b().floatValue() / 100.0f, cbVar.c().b().floatValue() / 360.0f);
    }

    public static void a(Path path, float f2, float f3, float f4) {
        if (f2 == f3) {
            path.reset();
        }
        f7764a.setPath(path, false);
        float length = f7764a.getLength();
        if (length == 0.0f) {
            return;
        }
        float f5 = f2 * length;
        float f6 = f3 * length;
        float f7 = f4 * length;
        float min = Math.min(f5, f6) + f7;
        float max = Math.max(f5, f6) + f7;
        if (min >= length && max >= length) {
            min = C0676ua.a(min, length);
            max = C0676ua.a(max, length);
        }
        if (min < 0.0f) {
            min = C0676ua.a(min, length);
        }
        if (max < 0.0f) {
            max = C0676ua.a(max, length);
        }
        if (min >= max) {
            min -= length;
        }
        f7765b.reset();
        f7764a.getSegment(min, max, f7765b, true);
        if (max > length) {
            f7766c.reset();
            f7764a.getSegment(0.0f, max % length, f7766c, true);
            f7765b.addPath(f7766c);
        } else if (min < 0.0f) {
            f7766c.reset();
            f7764a.getSegment(min + length, length, f7766c, true);
            f7765b.addPath(f7766c);
        }
        path.set(f7765b);
    }
}
