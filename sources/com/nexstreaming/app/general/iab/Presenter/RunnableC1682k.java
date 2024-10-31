package com.nexstreaming.app.general.iab.Presenter;

import com.android.billingclient.api.AbstractC0693g;
import com.android.billingclient.api.F;
import com.nexstreaming.app.general.iab.b.f;

/* compiled from: IABGooglePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1682k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1683l f19390a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ io.reactivex.n f19391b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1682k(C1683l c1683l, io.reactivex.n nVar) {
        this.f19390a = c1683l;
        this.f19391b = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.android.billingclient.api.P b2;
        AbstractC0693g abstractC0693g;
        F.a j = com.android.billingclient.api.F.j();
        C1683l c1683l = this.f19390a;
        b2 = c1683l.f19392a.b(c1683l.f19393b);
        j.a(b2);
        com.android.billingclient.api.F a2 = j.a();
        abstractC0693g = this.f19390a.f19392a.l;
        com.android.billingclient.api.H a3 = abstractC0693g.a(this.f19390a.f19394c, a2);
        kotlin.jvm.internal.h.a((Object) a3, "billingResult");
        if (a3.a() == 0) {
            this.f19391b.onNext(new f.b(a3.a()));
        } else {
            this.f19391b.onNext(new f.a(a3.a()));
        }
    }
}
