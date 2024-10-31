package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
final class p implements Result {

    /* renamed from: a */
    private final Status f12757a;

    public p(Status status) {
        this.f12757a = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f12757a;
    }
}
