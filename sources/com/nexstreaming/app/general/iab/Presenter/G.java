package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.BillingResponse;

/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
final class G<T> implements io.reactivex.c.e<com.nexstreaming.app.general.iab.b.a> {

    /* renamed from: a */
    final /* synthetic */ Runnable f19333a;

    public G(Runnable runnable) {
        this.f19333a = runnable;
    }

    @Override // io.reactivex.c.e
    /* renamed from: a */
    public final void accept(com.nexstreaming.app.general.iab.b.a aVar) {
        if (aVar.a() == BillingResponse.OK.getIntErrorCode()) {
            this.f19333a.run();
        }
    }
}
