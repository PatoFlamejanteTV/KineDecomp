package com.nexstreaming.app.general.iab.Presenter;

import com.android.billingclient.api.AbstractC0693g;
import com.android.billingclient.api.K;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABGooglePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1678g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1679h f19383a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ io.reactivex.n f19384b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1678g(C1679h c1679h, io.reactivex.n nVar) {
        this.f19383a = c1679h;
        this.f19384b = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC0693g abstractC0693g;
        K.a c2 = com.android.billingclient.api.K.c();
        c2.b(this.f19383a.f19387b.h());
        c2.a(this.f19383a.f19387b.a());
        com.android.billingclient.api.K a2 = c2.a();
        abstractC0693g = this.f19383a.f19386a.l;
        abstractC0693g.a(a2, new C1677f(this));
    }
}
