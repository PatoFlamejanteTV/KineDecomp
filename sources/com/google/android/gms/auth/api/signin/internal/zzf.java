package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public final class zzf implements GoogleSignInApi {
    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public final PendingResult<Status> a(GoogleApiClient googleApiClient) {
        return zzh.b(googleApiClient, googleApiClient.f(), false);
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public final PendingResult<Status> b(GoogleApiClient googleApiClient) {
        return zzh.a(googleApiClient, googleApiClient.f(), false);
    }
}
