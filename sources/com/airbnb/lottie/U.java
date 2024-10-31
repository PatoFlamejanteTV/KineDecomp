package com.airbnb.lottie;

import java.util.List;

/* compiled from: GradientColorKeyframeAnimation.java */
/* loaded from: classes.dex */
class U extends AbstractC0651ha<T> {

    /* renamed from: f */
    private final T f7712f;

    public U(List<? extends C0649ga<T>> list) {
        super(list);
        T t = list.get(0).f7772c;
        int c2 = t != null ? t.c() : 0;
        this.f7712f = new T(new float[c2], new int[c2]);
    }

    @Override // com.airbnb.lottie.AbstractC0677v
    /* bridge */ /* synthetic */ Object a(C0649ga c0649ga, float f2) {
        return a((C0649ga<T>) c0649ga, f2);
    }

    @Override // com.airbnb.lottie.AbstractC0677v
    T a(C0649ga<T> c0649ga, float f2) {
        this.f7712f.a(c0649ga.f7772c, c0649ga.f7773d, f2);
        return this.f7712f;
    }
}
