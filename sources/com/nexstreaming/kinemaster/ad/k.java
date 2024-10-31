package com.nexstreaming.kinemaster.ad;

import com.airbnb.lottie.C0657ka;
import com.airbnb.lottie.C0661ma;
import com.airbnb.lottie.InterfaceC0682xa;
import com.nexstreaming.kinemaster.ad.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LottieBanner.java */
/* loaded from: classes.dex */
public class k implements InterfaceC0682xa {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f.a f19964a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ l f19965b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(l lVar, f.a aVar) {
        this.f19965b = lVar;
        this.f19964a = aVar;
    }

    @Override // com.airbnb.lottie.InterfaceC0682xa
    public void a(C0657ka c0657ka) {
        C0661ma c0661ma;
        this.f19965b.f19967g = new C0661ma();
        c0661ma = this.f19965b.f19967g;
        c0661ma.a(c0657ka);
        f.a aVar = this.f19964a;
        if (aVar != null) {
            aVar.a(this.f19965b);
        }
    }
}
