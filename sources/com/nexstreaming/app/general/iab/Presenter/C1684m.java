package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.iab.b.d;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import com.nexstreaming.app.general.util.SupportLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: IABGooglePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1684m implements com.android.billingclient.api.T {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RunnableC1685n f19395a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LinkedHashMap f19396b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ LinkedHashMap f19397c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1684m(RunnableC1685n runnableC1685n, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2) {
        this.f19395a = runnableC1685n;
        this.f19396b = linkedHashMap;
        this.f19397c = linkedHashMap2;
    }

    @Override // com.android.billingclient.api.T
    public final void a(com.android.billingclient.api.H h2, List<com.android.billingclient.api.P> list) {
        kotlin.jvm.internal.h.a((Object) h2, "billingResult");
        if (h2.a() == 0) {
            Iterator<com.android.billingclient.api.P> it = list.iterator();
            while (it.hasNext()) {
                SKUDetails a2 = this.f19395a.f19398a.f19400a.a(it.next());
                try {
                    String k = a2.k();
                    kotlin.jvm.internal.h.a((Object) k, "details.type");
                    IABConstant.SKUType.valueOf(k);
                } catch (IllegalArgumentException unused) {
                    a2.m(this.f19395a.f19398a.f19402c.name());
                }
                this.f19396b.put(a2.g(), a2);
            }
            DiagnosticLogger.b().a(DiagnosticLogger.ParamTag.IH_GETSKU_OK, list.size());
        } else {
            SupportLogger.Event.IH_GetSkuFail.log(h2.a());
            DiagnosticLogger.b().a(DiagnosticLogger.ParamTag.IH_GETSKU_FAIL, h2.a());
        }
        this.f19397c.put(this.f19395a.f19398a.f19402c, this.f19396b);
        this.f19395a.f19399b.onNext(new d.b(BillingResponse.OK.getIntErrorCode(), this.f19397c));
    }
}
