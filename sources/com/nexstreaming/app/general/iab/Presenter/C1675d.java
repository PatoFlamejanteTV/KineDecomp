package com.nexstreaming.app.general.iab.Presenter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABBasePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1675d<T> implements io.reactivex.o<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABBasePresent f19373a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1675d(IABBasePresent iABBasePresent) {
        this.f19373a = iABBasePresent;
    }

    @Override // io.reactivex.o
    public final void a(io.reactivex.n<com.nexstreaming.app.general.iab.b.e> nVar) {
        kotlin.jvm.internal.h.b(nVar, "it");
        new RunnableC1674c(this, nVar).run();
    }
}
