package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.b.b;

/* compiled from: IABGooglePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1677f implements com.android.billingclient.api.L {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RunnableC1678g f19379a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1677f(RunnableC1678g runnableC1678g) {
        this.f19379a = runnableC1678g;
    }

    @Override // com.android.billingclient.api.L
    public final void a(com.android.billingclient.api.H h2, String str) {
        kotlin.jvm.internal.h.a((Object) h2, "billingResult");
        if (h2.a() == 0) {
            this.f19379a.f19384b.onNext(new b.C0097b(h2.a(), str));
        } else {
            this.f19379a.f19384b.onNext(new b.a(h2.a()));
        }
    }
}
