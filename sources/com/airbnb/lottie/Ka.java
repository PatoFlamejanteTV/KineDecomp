package com.airbnb.lottie;

import java.util.List;

/* compiled from: ScaleKeyframeAnimation.java */
/* loaded from: classes.dex */
class Ka extends AbstractC0651ha<La> {
    public Ka(List<C0649ga<La>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.AbstractC0677v
    public /* bridge */ /* synthetic */ Object a(C0649ga c0649ga, float f2) {
        return a((C0649ga<La>) c0649ga, f2);
    }

    @Override // com.airbnb.lottie.AbstractC0677v
    public La a(C0649ga<La> c0649ga, float f2) {
        La la;
        La la2 = c0649ga.f7772c;
        if (la2 != null && (la = c0649ga.f7773d) != null) {
            La la3 = la2;
            La la4 = la;
            return new La(C0676ua.b(la3.a(), la4.a(), f2), C0676ua.b(la3.b(), la4.b(), f2));
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
