package c.d.a.a.b;

import android.view.animation.Interpolator;

/* compiled from: Elastic.java */
/* loaded from: classes2.dex */
public class a implements Interpolator {

    /* renamed from: a */
    private final float f3540a;

    /* renamed from: b */
    private final float f3541b;

    public a(float f2, float f3) {
        this.f3540a = f2;
        this.f3541b = f3;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        float asin;
        float f3 = this.f3540a;
        if (f2 == 0.0f) {
            return 0.0f;
        }
        if (f2 / 1.0f == 1.0f) {
            return 1.0f;
        }
        if (f3 < Math.abs(1.0f)) {
            asin = this.f3541b / 4.0f;
            f3 = 1.0f;
        } else {
            asin = (this.f3541b / 6.2831855f) * ((float) Math.asin(1.0f / f3));
        }
        return (f3 * ((float) Math.pow(2.0d, (-10.0f) * r10)) * ((float) Math.sin((((r10 * 1.0f) - asin) * 6.2831855f) / this.f3541b))) + 1.0f + 0.0f;
    }
}
