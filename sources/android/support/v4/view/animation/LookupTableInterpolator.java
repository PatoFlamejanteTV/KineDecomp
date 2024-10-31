package android.support.v4.view.animation;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
abstract class LookupTableInterpolator implements Interpolator {

    /* renamed from: a */
    private final float[] f1893a;

    /* renamed from: b */
    private final float f1894b;

    public LookupTableInterpolator(float[] fArr) {
        this.f1893a = fArr;
        this.f1894b = 1.0f / (this.f1893a.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f1893a;
        int min = Math.min((int) ((fArr.length - 1) * f2), fArr.length - 2);
        float f3 = this.f1894b;
        float f4 = (f2 - (min * f3)) / f3;
        float[] fArr2 = this.f1893a;
        return fArr2[min] + (f4 * (fArr2[min + 1] - fArr2[min]));
    }
}
