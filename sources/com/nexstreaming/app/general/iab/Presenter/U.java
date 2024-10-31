package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.iab.b.c;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
public final class U<T> implements io.reactivex.o<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ B f19360a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public U(B b2) {
        this.f19360a = b2;
    }

    @Override // io.reactivex.o
    public final void a(io.reactivex.n<com.nexstreaming.app.general.iab.b.c> nVar) {
        kotlin.jvm.internal.h.b(nVar, "it");
        if (this.f19360a.l().get(IABConstant.SKUType.wechat) == null) {
            this.f19360a.l().put(IABConstant.SKUType.wechat, new ArrayList());
        }
        if (this.f19360a.q != null) {
            this.f19360a.a(new T(this, nVar));
        } else {
            nVar.onNext(new c.a(BillingResponse.SERVICE_DISCONNECTED.getIntErrorCode()));
        }
    }
}
