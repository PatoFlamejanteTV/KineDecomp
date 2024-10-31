package com.airbnb.lottie;

import com.airbnb.lottie.AbstractC0677v;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseLayer.java */
/* renamed from: com.airbnb.lottie.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0679w implements AbstractC0677v.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Q f7835a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AbstractC0683y f7836b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0679w(AbstractC0683y abstractC0683y, Q q) {
        this.f7836b = abstractC0683y;
        this.f7835a = q;
    }

    @Override // com.airbnb.lottie.AbstractC0677v.a
    public void a() {
        this.f7836b.a(((Float) this.f7835a.b()).floatValue() == 1.0f);
    }
}
