package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.iab.b.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABGooglePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.v, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1692v<T> implements io.reactivex.o<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1695y f19411a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1692v(C1695y c1695y) {
        this.f19411a = c1695y;
    }

    @Override // io.reactivex.o
    public final void a(io.reactivex.n<com.nexstreaming.app.general.iab.b.d> nVar) {
        boolean b2;
        kotlin.jvm.internal.h.b(nVar, "it");
        b2 = this.f19411a.b((ArrayList<String>) null, IABConstant.SKUType.subs);
        if (!b2) {
            this.f19411a.a(new RunnableC1691u(this, nVar));
            return;
        }
        LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> n = this.f19411a.n();
        if (n != null) {
            if (n.get(IABConstant.SKUType.subs) != null) {
                LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> n2 = this.f19411a.n();
                if (n2 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                LinkedHashMap<String, SKUDetails> linkedHashMap = n2.get(IABConstant.SKUType.subs);
                if (linkedHashMap != null) {
                    Iterator<SKUDetails> it = linkedHashMap.values().iterator();
                    while (it.hasNext()) {
                        this.f19411a.c(it.next());
                    }
                } else {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
            }
            LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> n3 = this.f19411a.n();
            if (n3 != null) {
                if (n3.get(IABConstant.SKUType.inapp) != null) {
                    LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> n4 = this.f19411a.n();
                    if (n4 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    LinkedHashMap<String, SKUDetails> linkedHashMap2 = n4.get(IABConstant.SKUType.inapp);
                    if (linkedHashMap2 != null) {
                        Iterator<SKUDetails> it2 = linkedHashMap2.values().iterator();
                        while (it2.hasNext()) {
                            this.f19411a.c(it2.next());
                        }
                    } else {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                }
                nVar.onNext(new d.b(0, this.f19411a.n()));
                return;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }
}
