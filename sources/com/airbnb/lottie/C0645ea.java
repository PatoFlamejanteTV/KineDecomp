package com.airbnb.lottie;

import java.util.List;

/* compiled from: IntegerKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.ea */
/* loaded from: classes.dex */
public class C0645ea extends AbstractC0651ha<Integer> {
    public C0645ea(List<C0649ga<Integer>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.AbstractC0677v
    /* bridge */ /* synthetic */ Object a(C0649ga c0649ga, float f2) {
        return a((C0649ga<Integer>) c0649ga, f2);
    }

    @Override // com.airbnb.lottie.AbstractC0677v
    Integer a(C0649ga<Integer> c0649ga, float f2) {
        Integer num = c0649ga.f7772c;
        if (num != null && c0649ga.f7773d != null) {
            return Integer.valueOf(C0676ua.a(num.intValue(), c0649ga.f7773d.intValue(), f2));
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
