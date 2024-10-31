package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public class GoogleSignInResult implements Result {

    /* renamed from: a */
    private Status f10576a;

    /* renamed from: b */
    private GoogleSignInAccount f10577b;

    public GoogleSignInResult(GoogleSignInAccount googleSignInAccount, Status status) {
        this.f10577b = googleSignInAccount;
        this.f10576a = status;
    }

    public GoogleSignInAccount a() {
        return this.f10577b;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f10576a;
    }
}
