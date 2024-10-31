package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* compiled from: PathKeyframeAnimation.java */
/* loaded from: classes.dex */
public class Ba extends AbstractC0651ha<PointF> {

    /* renamed from: f */
    private final PointF f7597f;

    /* renamed from: g */
    private final float[] f7598g;

    /* renamed from: h */
    private Aa f7599h;
    private PathMeasure i;

    public Ba(List<? extends C0649ga<PointF>> list) {
        super(list);
        this.f7597f = new PointF();
        this.f7598g = new float[2];
    }

    @Override // com.airbnb.lottie.AbstractC0677v
    public /* bridge */ /* synthetic */ Object a(C0649ga c0649ga, float f2) {
        return a((C0649ga<PointF>) c0649ga, f2);
    }

    @Override // com.airbnb.lottie.AbstractC0677v
    public PointF a(C0649ga<PointF> c0649ga, float f2) {
        Aa aa = (Aa) c0649ga;
        Path e2 = aa.e();
        if (e2 == null) {
            return c0649ga.f7772c;
        }
        if (this.f7599h != aa) {
            this.i = new PathMeasure(e2, false);
            this.f7599h = aa;
        }
        PathMeasure pathMeasure = this.i;
        pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f7598g, null);
        PointF pointF = this.f7597f;
        float[] fArr = this.f7598g;
        pointF.set(fArr[0], fArr[1]);
        return this.f7597f;
    }
}
