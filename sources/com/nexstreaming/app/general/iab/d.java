package com.nexstreaming.app.general.iab;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABManager.kt */
/* loaded from: classes2.dex */
public final class d<T> implements io.reactivex.c.e<com.nexstreaming.app.general.iab.b.b> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABManager f19468a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Purchase f19469b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f19470c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(IABManager iABManager, Purchase purchase, Context context) {
        this.f19468a = iABManager;
        this.f19469b = purchase;
        this.f19470c = context;
    }

    @Override // io.reactivex.c.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(com.nexstreaming.app.general.iab.b.b bVar) {
        if (bVar.a() == BillingResponse.OK.getIntErrorCode()) {
            this.f19468a.a(this.f19469b);
            Toast.makeText(this.f19470c, "Consume Success", 0).show();
        } else {
            this.f19468a.a((Purchase) null);
            Toast.makeText(this.f19470c, "Consume error", 0).show();
        }
    }
}
