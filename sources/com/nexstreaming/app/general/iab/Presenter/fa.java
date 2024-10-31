package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.b.a;
import com.nexstreaming.app.kinemasterfree.wxapi.WXAccessToken;
import com.nexstreaming.app.kinemasterfree.wxapi.e;

/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
public final class fa implements e.a<WXAccessToken> {

    /* renamed from: a, reason: collision with root package name */
    private int f19380a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ga f19381b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ io.reactivex.n f19382c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fa(ga gaVar, io.reactivex.n nVar) {
        this.f19381b = gaVar;
        this.f19382c = nVar;
    }

    @Override // com.nexstreaming.app.kinemasterfree.wxapi.e.a
    public void onError(Exception exc) {
        kotlin.jvm.internal.h.b(exc, "error");
        int i = this.f19381b.f19385a.k;
        int i2 = this.f19380a;
        if (i > i2) {
            this.f19380a = i2 + 1;
            com.nexstreaming.app.kinemasterfree.wxapi.e.c().a(this.f19381b.f19385a.q, this);
        } else {
            this.f19381b.f19385a.n = false;
            this.f19382c.onNext(new a.C0096a(BillingResponse.SERVICE_DISCONNECTED.getIntErrorCode()));
        }
    }

    @Override // com.nexstreaming.app.kinemasterfree.wxapi.e.a
    public void a(WXAccessToken wXAccessToken) {
        if (wXAccessToken == null) {
            int i = this.f19381b.f19385a.k;
            int i2 = this.f19380a;
            if (i <= i2) {
                this.f19381b.f19385a.n = false;
                this.f19382c.onNext(new a.C0096a(BillingResponse.SERVICE_DISCONNECTED.getIntErrorCode()));
                return;
            }
            this.f19380a = i2 + 1;
            com.nexstreaming.app.kinemasterfree.wxapi.e c2 = com.nexstreaming.app.kinemasterfree.wxapi.e.c();
            WXAccessToken wXAccessToken2 = this.f19381b.f19385a.q;
            if (wXAccessToken2 != null) {
                c2.a(wXAccessToken2, this);
                return;
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
        com.nexstreaming.app.kinemasterfree.wxapi.e.c().a(wXAccessToken);
        this.f19381b.f19385a.q = wXAccessToken;
        B b2 = this.f19381b.f19385a;
        WXAccessToken wXAccessToken3 = b2.q;
        if (wXAccessToken3 != null) {
            b2.a(wXAccessToken3);
            this.f19381b.f19385a.n = true;
            this.f19381b.f19385a.a(new ea(this));
            return;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }
}
