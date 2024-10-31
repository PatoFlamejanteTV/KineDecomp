package com.nexstreaming.app.general.iab;

import com.nexstreaming.app.general.iab.Presenter.B;
import com.nexstreaming.app.general.iab.Presenter.C1695y;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABManager.kt */
/* loaded from: classes2.dex */
public final class p<T> implements io.reactivex.c.e<com.nexstreaming.app.general.iab.b.e> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABManager f19484a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(IABManager iABManager) {
        this.f19484a = iABManager;
    }

    @Override // io.reactivex.c.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(com.nexstreaming.app.general.iab.b.e eVar) {
        List<InterfaceC1821j> list;
        io.reactivex.disposables.a aVar;
        SKUDetails a2;
        SKUDetails a3;
        if (eVar.b() != BillingResponse.OK.getIntErrorCode() || eVar.a() == null) {
            return;
        }
        this.f19484a.M = eVar.a();
        ArrayList<String> arrayList = new ArrayList<>();
        list = this.f19484a.M;
        if (list != null) {
            for (InterfaceC1821j interfaceC1821j : list) {
                arrayList.add(interfaceC1821j.b());
                if (this.f19484a.n() instanceof B) {
                    if (this.f19484a.n().n().get(IABConstant.SKUType.wechat) != null) {
                        LinkedHashMap<String, SKUDetails> linkedHashMap = this.f19484a.n().n().get(IABConstant.SKUType.wechat);
                        if (linkedHashMap == null) {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                        kotlin.jvm.internal.h.a((Object) linkedHashMap, "present.getSkuInventorie…onstant.SKUType.wechat]!!");
                        String b2 = interfaceC1821j.b();
                        a2 = this.f19484a.a(interfaceC1821j, IABConstant.SKUType.wechat);
                        linkedHashMap.put(b2, a2);
                    } else {
                        LinkedHashMap<String, SKUDetails> linkedHashMap2 = new LinkedHashMap<>();
                        String b3 = interfaceC1821j.b();
                        a3 = this.f19484a.a(interfaceC1821j, IABConstant.SKUType.wechat);
                        linkedHashMap2.put(b3, a3);
                        this.f19484a.n().n().put(IABConstant.SKUType.wechat, linkedHashMap2);
                    }
                }
            }
            LinkedHashMap<String, SKUDetails> linkedHashMap3 = this.f19484a.n().n().get(IABConstant.SKUType.wechat);
            if (linkedHashMap3 != null && linkedHashMap3.size() > 0) {
                this.f19484a.N = true;
            }
            if (this.f19484a.n() instanceof C1695y) {
                io.reactivex.disposables.b a4 = this.f19484a.n().a(arrayList, IABConstant.SKUType.inapp).b(io.reactivex.g.b.b()).a(io.reactivex.a.b.b.a()).a(new n(this), new o(this));
                aVar = this.f19484a.J;
                aVar.b(a4);
                return;
            }
            return;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }
}
