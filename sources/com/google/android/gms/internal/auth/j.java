package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
final class j extends m {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ i f12752a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f12752a = iVar;
    }

    @Override // com.google.android.gms.internal.auth.m, com.google.android.gms.auth.account.zza
    public final void a(Account account) {
        Status status;
        i iVar = this.f12752a;
        if (account == null) {
            status = zzh.zzad;
        } else {
            status = Status.f10704a;
        }
        iVar.a((i) new n(status, account));
    }
}
