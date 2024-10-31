package com.airbnb.lottie;

import android.graphics.PointF;
import java.util.List;

/* compiled from: PointKeyframeAnimation.java */
/* loaded from: classes.dex */
class Da extends AbstractC0651ha<PointF> {

    /* renamed from: f */
    private final PointF f7604f;

    public Da(List<C0649ga<PointF>> list) {
        super(list);
        this.f7604f = new PointF();
    }

    @Override // com.airbnb.lottie.AbstractC0677v
    public /* bridge */ /* synthetic */ Object a(C0649ga c0649ga, float f2) {
        return a((C0649ga<PointF>) c0649ga, f2);
    }

    @Override // com.airbnb.lottie.AbstractC0677v
    public PointF a(C0649ga<PointF> c0649ga, float f2) {
        PointF pointF;
        PointF pointF2 = c0649ga.f7772c;
        if (pointF2 != null && (pointF = c0649ga.f7773d) != null) {
            PointF pointF3 = pointF2;
            PointF pointF4 = pointF;
            PointF pointF5 = this.f7604f;
            float f3 = pointF3.x;
            float f4 = f3 + ((pointF4.x - f3) * f2);
            float f5 = pointF3.y;
            pointF5.set(f4, f5 + (f2 * (pointF4.y - f5)));
            return this.f7604f;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
