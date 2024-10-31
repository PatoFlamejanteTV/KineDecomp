package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.api.internal.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class BinderC0809m extends com.google.android.gms.signin.internal.zac {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<zaak> f10845a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BinderC0809m(zaak zaakVar) {
        this.f10845a = new WeakReference<>(zaakVar);
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zad
    public final void a(com.google.android.gms.signin.internal.zaj zajVar) {
        zabe zabeVar;
        zaak zaakVar = this.f10845a.get();
        if (zaakVar == null) {
            return;
        }
        zabeVar = zaakVar.f10872a;
        zabeVar.a(new C0810n(this, zaakVar, zaakVar, zajVar));
    }
}
