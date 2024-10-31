package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.iab.b.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
public final class P<T> implements io.reactivex.o<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ B f19354a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ArrayList f19355b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(B b2, ArrayList arrayList) {
        this.f19354a = b2;
        this.f19355b = arrayList;
    }

    @Override // io.reactivex.o
    public final void a(io.reactivex.n<com.nexstreaming.app.general.iab.b.d> nVar) {
        boolean b2;
        kotlin.jvm.internal.h.b(nVar, "it");
        if (this.f19354a.q != null) {
            b2 = this.f19354a.b((ArrayList<String>) this.f19355b, IABConstant.SKUType.wechat);
            if (b2) {
                this.f19354a.a(new O(this, nVar));
                return;
            }
            LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> n = this.f19354a.n();
            if (n == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            LinkedHashMap<String, SKUDetails> linkedHashMap = n.get(IABConstant.SKUType.wechat);
            if (linkedHashMap != null) {
                Iterator<SKUDetails> it = linkedHashMap.values().iterator();
                while (it.hasNext()) {
                    this.f19354a.b(it.next());
                }
                nVar.onNext(new d.b(BillingResponse.OK.getIntErrorCode(), this.f19354a.n()));
                return;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }
}
