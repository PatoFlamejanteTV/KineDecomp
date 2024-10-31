package com.airbnb.lottie;

import android.graphics.PointF;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatableSplitDimensionPathValue.java */
/* renamed from: com.airbnb.lottie.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0666p implements InterfaceC0671s<PointF> {

    /* renamed from: a, reason: collision with root package name */
    private final C0642d f7806a;

    /* renamed from: b, reason: collision with root package name */
    private final C0642d f7807b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0666p(C0642d c0642d, C0642d c0642d2) {
        this.f7806a = c0642d;
        this.f7807b = c0642d2;
    }

    @Override // com.airbnb.lottie.InterfaceC0671s
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC0677v<?, PointF> a2() {
        return new Za(this.f7806a.a2(), this.f7807b.a2());
    }
}
