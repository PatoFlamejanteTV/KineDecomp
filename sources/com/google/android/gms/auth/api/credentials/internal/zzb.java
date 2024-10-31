package com.google.android.gms.auth.api.credentials.internal;

import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public final class zzb implements CredentialRequestResult {

    /* renamed from: a, reason: collision with root package name */
    private final Status f796a;

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f796a;
    }
}
