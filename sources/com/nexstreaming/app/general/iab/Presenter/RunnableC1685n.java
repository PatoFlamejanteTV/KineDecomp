package com.nexstreaming.app.general.iab.Presenter;

import com.android.billingclient.api.AbstractC0693g;
import com.android.billingclient.api.S;
import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.b.d;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import java.util.LinkedHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABGooglePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1685n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1686o f19398a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ io.reactivex.n f19399b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1685n(C1686o c1686o, io.reactivex.n nVar) {
        this.f19398a = c1686o;
        this.f19399b = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC0693g abstractC0693g;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (this.f19398a.f19401b.size() > 0) {
            S.a c2 = com.android.billingclient.api.S.c();
            c2.a(this.f19398a.f19401b);
            c2.a(this.f19398a.f19402c.name());
            abstractC0693g = this.f19398a.f19400a.l;
            abstractC0693g.a(c2.a(), new C1684m(this, linkedHashMap2, linkedHashMap));
            return;
        }
        DiagnosticLogger.b().a(DiagnosticLogger.Tag.IW_GETSKU_INVALID);
        linkedHashMap.put(this.f19398a.f19402c, linkedHashMap2);
        this.f19399b.onNext(new d.b(BillingResponse.ITEM_UNAVAILABLE.getIntErrorCode(), linkedHashMap));
    }
}
