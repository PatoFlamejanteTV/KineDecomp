package com.airbnb.lottie;

import java.util.List;

/* compiled from: ColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public class F extends AbstractC0651ha<Integer> {
    public F(List<C0649ga<Integer>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.AbstractC0677v
    public /* bridge */ /* synthetic */ Object a(C0649ga c0649ga, float f2) {
        return a((C0649ga<Integer>) c0649ga, f2);
    }

    @Override // com.airbnb.lottie.AbstractC0677v
    public Integer a(C0649ga<Integer> c0649ga, float f2) {
        Integer num = c0649ga.f7772c;
        if (num != null && c0649ga.f7773d != null) {
            return Integer.valueOf(S.a(f2, num.intValue(), c0649ga.f7773d.intValue()));
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
