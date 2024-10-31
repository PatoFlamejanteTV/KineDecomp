package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.iab.b.d;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.kinemaster.network.SubscriptionInfo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABGooglePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1676e implements com.android.billingclient.api.T {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1695y f19375a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SubscriptionInfo f19376b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ io.reactivex.n f19377c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1676e(C1695y c1695y, SubscriptionInfo subscriptionInfo, io.reactivex.n nVar) {
        this.f19375a = c1695y;
        this.f19376b = subscriptionInfo;
        this.f19377c = nVar;
    }

    @Override // com.android.billingclient.api.T
    public final void a(com.android.billingclient.api.H h2, List<com.android.billingclient.api.P> list) {
        kotlin.jvm.internal.h.a((Object) h2, "billingResult");
        if (h2.a() == 0) {
            LinkedHashMap<String, SKUDetails> linkedHashMap = new LinkedHashMap<>();
            Iterator<com.android.billingclient.api.P> it = list.iterator();
            while (it.hasNext()) {
                SKUDetails a2 = this.f19375a.a(it.next());
                SubscriptionInfo subscriptionInfo = this.f19376b;
                if (subscriptionInfo != null) {
                    for (SubscriptionInfo.SubscriptionProductInfo subscriptionProductInfo : subscriptionInfo.getList()) {
                        Iterator<SubscriptionInfo.SubscriptionItemInfo> it2 = subscriptionProductInfo.getItems().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                SubscriptionInfo.SubscriptionItemInfo next = it2.next();
                                if (kotlin.jvm.internal.h.a((Object) next.getProductId(), (Object) a2.g())) {
                                    a2.a(subscriptionProductInfo.getDisplay());
                                    a2.c(next.getIdx());
                                    break;
                                }
                            }
                        }
                    }
                }
                this.f19375a.c(a2);
                this.f19375a.a(a2);
                linkedHashMap.put(a2.g(), a2);
            }
            LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> n = this.f19375a.n();
            if (n == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            n.put(IABConstant.SKUType.subs, linkedHashMap);
        } else {
            SupportLogger.Event.IH_GetSkuFail.log(h2.a());
            DiagnosticLogger.b().a(DiagnosticLogger.ParamTag.IH_GETSKU_FAIL, h2.a());
        }
        io.reactivex.n nVar = this.f19377c;
        if (nVar != null) {
            nVar.onNext(new d.b(0, this.f19375a.n()));
        }
    }
}
