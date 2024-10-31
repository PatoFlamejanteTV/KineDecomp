package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.b.a;

/* compiled from: IABGooglePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.w, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1693w implements com.android.billingclient.api.D {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1694x f19412a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ io.reactivex.n f19413b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1693w(C1694x c1694x, io.reactivex.n nVar) {
        this.f19412a = c1694x;
        this.f19413b = nVar;
    }

    @Override // com.android.billingclient.api.D
    public void a(com.android.billingclient.api.H h2) {
        kotlin.jvm.internal.h.b(h2, "billingResult");
        if (h2.a() == 0) {
            this.f19412a.f19414a.m = true;
            this.f19413b.onNext(new a.b(h2.a()));
        } else {
            this.f19412a.f19414a.m = false;
            this.f19413b.onNext(new a.C0096a(h2.a()));
        }
    }

    @Override // com.android.billingclient.api.D
    public void a() {
        this.f19412a.f19414a.m = false;
        this.f19413b.onNext(new a.C0096a(-1));
    }
}
