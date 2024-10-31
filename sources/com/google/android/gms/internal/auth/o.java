package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
final class o implements Result {

    /* renamed from: a */
    private final Status f12756a;

    public o(Status status) {
        this.f12756a = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f12756a;
    }
}
