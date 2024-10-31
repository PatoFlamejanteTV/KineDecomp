package com.nexstreaming.app.general.iab.Presenter;

import com.android.billingclient.api.AbstractC0693g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABGooglePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.x, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1694x<T> implements io.reactivex.o<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1695y f19414a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1694x(C1695y c1695y) {
        this.f19414a = c1695y;
    }

    @Override // io.reactivex.o
    public final void a(io.reactivex.n<com.nexstreaming.app.general.iab.b.a> nVar) {
        AbstractC0693g abstractC0693g;
        AbstractC0693g abstractC0693g2;
        kotlin.jvm.internal.h.b(nVar, "it");
        abstractC0693g = this.f19414a.l;
        kotlin.jvm.internal.h.a((Object) abstractC0693g, "billingClient");
        if (!abstractC0693g.b()) {
            C1695y c1695y = this.f19414a;
            AbstractC0693g.a a2 = AbstractC0693g.a(c1695y.f());
            a2.b();
            a2.a(this.f19414a);
            c1695y.l = a2.a();
        }
        abstractC0693g2 = this.f19414a.l;
        abstractC0693g2.a(new C1693w(this, nVar));
    }
}
