package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.b.b;

/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
final class F<T> implements io.reactivex.o<T> {

    /* renamed from: a */
    public static final F f19332a = new F();

    F() {
    }

    @Override // io.reactivex.o
    public final void a(io.reactivex.n<com.nexstreaming.app.general.iab.b.b> nVar) {
        kotlin.jvm.internal.h.b(nVar, "it");
        new b.C0097b(BillingResponse.OK.getIntErrorCode(), null);
    }
}
