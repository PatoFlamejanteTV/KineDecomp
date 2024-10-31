package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.iab.b.d;
import java.util.ArrayList;

/* compiled from: IABGooglePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.o, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1686o<T> implements io.reactivex.o<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1695y f19400a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ArrayList f19401b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ IABConstant.SKUType f19402c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1686o(C1695y c1695y, ArrayList arrayList, IABConstant.SKUType sKUType) {
        this.f19400a = c1695y;
        this.f19401b = arrayList;
        this.f19402c = sKUType;
    }

    @Override // io.reactivex.o
    public final void a(io.reactivex.n<com.nexstreaming.app.general.iab.b.d> nVar) {
        boolean b2;
        kotlin.jvm.internal.h.b(nVar, "it");
        b2 = this.f19400a.b((ArrayList<String>) this.f19401b, this.f19402c);
        if (!b2) {
            this.f19400a.a(new RunnableC1685n(this, nVar));
        } else {
            nVar.onNext(new d.b(BillingResponse.OK.getIntErrorCode(), this.f19400a.n()));
        }
    }
}
