package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.Presenter.IABBasePresent;
import com.nexstreaming.app.general.iab.b.a;
import com.nexstreaming.app.kinemasterfree.wxapi.WXAccessToken;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
public final class ga<T> implements io.reactivex.o<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ B f19385a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ga(B b2) {
        this.f19385a = b2;
    }

    @Override // io.reactivex.o
    public final void a(io.reactivex.n<com.nexstreaming.app.general.iab.b.a> nVar) {
        kotlin.jvm.internal.h.b(nVar, "it");
        if (this.f19385a.q != null) {
            WXAccessToken wXAccessToken = this.f19385a.q;
            if (wXAccessToken == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            if (wXAccessToken.f()) {
                com.nexstreaming.app.kinemasterfree.wxapi.e.c().a(this.f19385a.q, new fa(this, nVar));
                return;
            }
            B b2 = this.f19385a;
            WXAccessToken wXAccessToken2 = b2.q;
            if (wXAccessToken2 == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            b2.a(wXAccessToken2);
            this.f19385a.n = true;
            nVar.onNext(new a.b(BillingResponse.OK.getIntErrorCode()));
            return;
        }
        if (!this.f19385a.E()) {
            this.f19385a.n = false;
            nVar.onNext(new a.C0096a(BillingResponse.SERVICE_DISCONNECTED.getIntErrorCode()));
        } else if (this.f19385a.j() == IABBasePresent.State.NONE) {
            com.nexstreaming.app.kinemasterfree.wxapi.e.c().f();
            this.f19385a.n = false;
            nVar.onNext(new a.C0096a(BillingResponse.USER_CANCELED.getIntErrorCode()));
        } else {
            if (this.f19385a.j() == IABBasePresent.State.SEND_RESULT) {
                this.f19385a.n = false;
                nVar.onNext(new a.C0096a(BillingResponse.SERVICE_DISCONNECTED.getIntErrorCode()));
            }
            this.f19385a.b(false);
        }
    }
}
