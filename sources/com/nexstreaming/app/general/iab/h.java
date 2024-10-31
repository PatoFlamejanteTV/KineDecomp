package com.nexstreaming.app.general.iab;

import com.nexstreaming.app.general.iab.Presenter.B;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABManager.kt */
/* loaded from: classes2.dex */
public final class h<T> implements io.reactivex.c.e<com.nexstreaming.app.general.iab.b.c> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABManager f19474a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(IABManager iABManager) {
        this.f19474a = iABManager;
    }

    @Override // io.reactivex.c.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(com.nexstreaming.app.general.iab.b.c cVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (cVar.a() != BillingResponse.OK.getIntErrorCode()) {
            z = this.f19474a.B;
            if (z) {
                this.f19474a.a(R.string.Restore_failed);
                this.f19474a.B = false;
            }
            this.f19474a.a((LinkedHashMap<IABConstant.SKUType, List<Purchase>>) null, IABError.PurchaseError, BillingResponse.fromCode(cVar.a()).name());
            return;
        }
        LinkedHashMap<IABConstant.SKUType, List<Purchase>> b2 = cVar.b();
        if (b2 != null) {
            this.f19474a.a((Map<IABConstant.SKUType, ? extends List<? extends Purchase>>) b2);
            if (b2.get(IABConstant.SKUType.subs) != null) {
                List<Purchase> list = b2.get(IABConstant.SKUType.subs);
                if (list == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                if (list.isEmpty()) {
                    Purchase d2 = this.f19474a.n().d("subs");
                    if (d2 != null) {
                        HashMap hashMap = new HashMap();
                        String c2 = d2.c();
                        if (c2 == null) {
                            c2 = "unknown";
                        }
                        hashMap.put("OrderId", c2);
                        String j = d2.j();
                        if (j == null) {
                            j = "unknown";
                        }
                        hashMap.put("Sku", j);
                        String date = d2.g().toString();
                        kotlin.jvm.internal.h.a((Object) date, "p.purchaseTime.toString()");
                        hashMap.put("PurchaseTime", date);
                        KMEvents.EMPTY_PURCHASE_SUBSCRIPTION.logEvent(hashMap);
                    }
                    this.f19474a.n().a("subs", (Purchase) null, 0L);
                    this.f19474a.o = null;
                }
            }
            boolean z4 = true;
            if (this.f19474a.n() instanceof B) {
                if (b2.get(IABConstant.SKUType.wechat) == null) {
                    z2 = this.f19474a.B;
                    if (z2) {
                        this.f19474a.a(R.string.Restore_failed);
                        this.f19474a.B = false;
                    }
                    z4 = false;
                } else {
                    List<Purchase> list2 = b2.get(IABConstant.SKUType.wechat);
                    if (list2 != null) {
                        Iterator<Purchase> it = list2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z4 = false;
                                break;
                            } else {
                                if (this.f19474a.f().c(it.next().d())) {
                                    break;
                                }
                            }
                        }
                        z3 = this.f19474a.B;
                        if (z3) {
                            this.f19474a.a(R.string.Restore_complete);
                            this.f19474a.B = false;
                        }
                    } else {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                }
            } else {
                if (b2.get(IABConstant.SKUType.inapp) != null) {
                    List<Purchase> list3 = b2.get(IABConstant.SKUType.inapp);
                    if (list3 != null) {
                        Iterator<Purchase> it2 = list3.iterator();
                        while (it2.hasNext()) {
                            if (this.f19474a.f().c(it2.next().d())) {
                                break;
                            }
                        }
                    } else {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                }
                z4 = false;
            }
            if (!z4) {
                this.f19474a.n().a("one", (Purchase) null, 0L);
                this.f19474a.G();
            }
            this.f19474a.a(b2, IABError.NoError, (String) null);
        }
    }
}
