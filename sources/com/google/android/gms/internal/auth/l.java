package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
final class l extends m {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ k f12753a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f12753a = kVar;
    }

    @Override // com.google.android.gms.internal.auth.m, com.google.android.gms.auth.account.zza
    public final void zza(boolean z) {
        Status status;
        k kVar = this.f12753a;
        if (!z) {
            status = zzh.zzad;
        } else {
            status = Status.f10704a;
        }
        kVar.a((k) new p(status));
    }
}
