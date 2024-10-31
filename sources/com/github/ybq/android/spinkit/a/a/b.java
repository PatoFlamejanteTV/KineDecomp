package com.github.ybq.android.spinkit.a.a;

import android.animation.TimeInterpolator;
import android.view.animation.Interpolator;

/* compiled from: KeyFrameInterpolator.java */
/* loaded from: classes.dex */
public class b implements Interpolator {

    /* renamed from: a */
    private TimeInterpolator f9868a;

    /* renamed from: b */
    private float[] f9869b;

    public b(TimeInterpolator timeInterpolator, float... fArr) {
        this.f9868a = timeInterpolator;
        this.f9869b = fArr;
    }

    public static b a(float... fArr) {
        b bVar = new b(a.a(), new float[0]);
        bVar.b(fArr);
        return bVar;
    }

    public void b(float... fArr) {
        this.f9869b = fArr;
    }

    @Override // android.animation.TimeInterpolator
    public synchronized float getInterpolation(float f2) {
        if (this.f9869b.length > 1) {
            int i = 0;
            while (i < this.f9869b.length - 1) {
                float f3 = this.f9869b[i];
                i++;
                float f4 = this.f9869b[i];
                float f5 = f4 - f3;
                if (f2 >= f3 && f2 <= f4) {
                    return f3 + (this.f9868a.getInterpolation((f2 - f3) / f5) * f5);
                }
            }
        }
        return this.f9868a.getInterpolation(f2);
    }

    public static b a(float f2, float f3, float f4, float f5, float... fArr) {
        b bVar = new b(c.a(f2, f3, f4, f5), new float[0]);
        bVar.b(fArr);
        return bVar;
    }
}
