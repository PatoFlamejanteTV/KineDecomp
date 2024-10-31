package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
final class n implements WorkAccountApi.AddAccountResult {

    /* renamed from: a */
    private final Status f12754a;

    /* renamed from: b */
    private final Account f12755b;

    public n(Status status, Account account) {
        this.f12754a = status;
        this.f12755b = account;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f12754a;
    }
}
