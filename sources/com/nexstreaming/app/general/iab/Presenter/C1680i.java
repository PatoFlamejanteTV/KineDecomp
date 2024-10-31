package com.nexstreaming.app.general.iab.Presenter;

/* compiled from: IABGooglePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.i */
/* loaded from: classes2.dex */
final class C1680i<T> implements io.reactivex.c.e<com.nexstreaming.app.general.iab.b.a> {

    /* renamed from: a */
    final /* synthetic */ Runnable f19388a;

    public C1680i(Runnable runnable) {
        this.f19388a = runnable;
    }

    @Override // io.reactivex.c.e
    /* renamed from: a */
    public final void accept(com.nexstreaming.app.general.iab.b.a aVar) {
        if (aVar.a() == 0) {
            this.f19388a.run();
        }
    }
}
