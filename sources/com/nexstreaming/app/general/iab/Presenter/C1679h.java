package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.Purchase;

/* compiled from: IABGooglePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1679h<T> implements io.reactivex.o<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1695y f19386a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Purchase f19387b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1679h(C1695y c1695y, Purchase purchase) {
        this.f19386a = c1695y;
        this.f19387b = purchase;
    }

    @Override // io.reactivex.o
    public final void a(io.reactivex.n<com.nexstreaming.app.general.iab.b.b> nVar) {
        kotlin.jvm.internal.h.b(nVar, "it");
        this.f19386a.a(new RunnableC1678g(this, nVar));
    }
}
