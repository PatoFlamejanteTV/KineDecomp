package com.airbnb.lottie;

import java.util.List;

/* compiled from: FloatKeyframeAnimation.java */
/* loaded from: classes.dex */
public class Q extends AbstractC0651ha<Float> {
    public Q(List<C0649ga<Float>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.AbstractC0677v
    /* bridge */ /* synthetic */ Object a(C0649ga c0649ga, float f2) {
        return a((C0649ga<Float>) c0649ga, f2);
    }

    @Override // com.airbnb.lottie.AbstractC0677v
    Float a(C0649ga<Float> c0649ga, float f2) {
        Float f3 = c0649ga.f7772c;
        if (f3 != null && c0649ga.f7773d != null) {
            return Float.valueOf(C0676ua.b(f3.floatValue(), c0649ga.f7773d.floatValue(), f2));
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
