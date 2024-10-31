package com.nexstreaming.app.general.iab;

import com.nexstreaming.app.general.iab.Presenter.C1695y;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABManager.kt */
/* loaded from: classes2.dex */
public final class f<T> implements io.reactivex.c.e<com.nexstreaming.app.general.iab.b.f> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABManager f19472a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(IABManager iABManager) {
        this.f19472a = iABManager;
    }

    @Override // io.reactivex.c.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(com.nexstreaming.app.general.iab.b.f fVar) {
        int a2 = fVar.a();
        if (a2 == BillingResponse.OK.getIntErrorCode()) {
            boolean z = this.f19472a.n() instanceof C1695y;
        } else {
            if (a2 == BillingResponse.PENDING_PURCHASE.getIntErrorCode()) {
                return;
            }
            this.f19472a.a(false, (Purchase) null, String.valueOf(fVar.a()));
        }
    }
}
