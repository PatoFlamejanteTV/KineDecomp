package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.BuyResult;
import com.nexstreaming.app.general.iab.DeveloperPayLoad;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.b.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
public final class L<T> implements io.reactivex.o<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ B f19347a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SKUDetails f19348b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ DeveloperPayLoad f19349c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(B b2, SKUDetails sKUDetails, DeveloperPayLoad developerPayLoad) {
        this.f19347a = b2;
        this.f19348b = sKUDetails;
        this.f19349c = developerPayLoad;
    }

    @Override // io.reactivex.o
    public final void a(io.reactivex.n<com.nexstreaming.app.general.iab.b.f> nVar) {
        kotlin.jvm.internal.h.b(nVar, "it");
        if (this.f19347a.q != null) {
            if (this.f19348b.h() > 0) {
                new BuyResult().a(3);
                this.f19347a.a(new K(this, nVar));
                return;
            }
            nVar.onNext(new f.a(BillingResponse.ITEM_UNAVAILABLE.getIntErrorCode()));
            return;
        }
        nVar.onNext(new f.a(BillingResponse.BILLING_UNAVAILABLE.getIntErrorCode()));
    }
}
