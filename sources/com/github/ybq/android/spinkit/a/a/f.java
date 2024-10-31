package com.github.ybq.android.spinkit.a.a;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* compiled from: PathInterpolatorDonut.java */
/* loaded from: classes.dex */
class f implements Interpolator {

    /* renamed from: a */
    private final float[] f9870a;

    /* renamed from: b */
    private final float[] f9871b;

    public f(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / 0.002f)) + 1;
        this.f9870a = new float[i];
        this.f9871b = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((i2 * length) / (i - 1), fArr, null);
            this.f9870a[i2] = fArr[0];
            this.f9871b[i2] = fArr[1];
        }
    }

    private static Path a(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f2, f3, f4, f5, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f9870a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f2 < this.f9870a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.f9870a;
        float f3 = fArr[length] - fArr[i];
        if (f3 == 0.0f) {
            return this.f9871b[i];
        }
        float f4 = (f2 - fArr[i]) / f3;
        float[] fArr2 = this.f9871b;
        float f5 = fArr2[i];
        return f5 + (f4 * (fArr2[length] - f5));
    }

    public f(float f2, float f3, float f4, float f5) {
        this(a(f2, f3, f4, f5));
    }
}
