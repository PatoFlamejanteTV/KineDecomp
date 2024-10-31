package com.nexstreaming.app.general.iab;

import com.nexstreaming.app.general.iab.Utils.IABConstant;
import java.util.LinkedHashMap;

/* compiled from: IABManager.kt */
/* loaded from: classes2.dex */
final class n<T> implements io.reactivex.c.e<com.nexstreaming.app.general.iab.b.d> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f19482a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(p pVar) {
        this.f19482a = pVar;
    }

    @Override // io.reactivex.c.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(com.nexstreaming.app.general.iab.b.d dVar) {
        if (dVar.a() != BillingResponse.OK.getIntErrorCode() || dVar.b() == null) {
            return;
        }
        LinkedHashMap<String, SKUDetails> linkedHashMap = dVar.b().get(IABConstant.SKUType.inapp);
        if (linkedHashMap != null) {
            if (this.f19482a.f19484a.n().n().get(IABConstant.SKUType.inapp) == null) {
                this.f19482a.f19484a.n().n().put(IABConstant.SKUType.inapp, new LinkedHashMap<>());
            }
            for (SKUDetails sKUDetails : linkedHashMap.values()) {
                LinkedHashMap<String, SKUDetails> linkedHashMap2 = this.f19482a.f19484a.n().n().get(IABConstant.SKUType.inapp);
                if (linkedHashMap2 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                linkedHashMap2.put(sKUDetails.g(), sKUDetails);
            }
        }
        LinkedHashMap<String, SKUDetails> linkedHashMap3 = this.f19482a.f19484a.n().n().get(IABConstant.SKUType.inapp);
        if (linkedHashMap3 == null || linkedHashMap3.size() <= 0) {
            return;
        }
        this.f19482a.f19484a.N = true;
    }
}
