package com.google.android.gms.internal.p000authapi;

import android.app.PendingIntent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
public final class zzi implements CredentialsApi {
    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public final PendingResult<Status> delete(GoogleApiClient googleApiClient, Credential credential) {
        Preconditions.a(googleApiClient, "client must not be null");
        Preconditions.a(credential, "credential must not be null");
        return googleApiClient.b((GoogleApiClient) new d(this, googleApiClient, credential));
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public final PendingResult<Status> disableAutoSignIn(GoogleApiClient googleApiClient) {
        Preconditions.a(googleApiClient, "client must not be null");
        return googleApiClient.b((GoogleApiClient) new e(this, googleApiClient));
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public final PendingIntent getHintPickerIntent(GoogleApiClient googleApiClient, HintRequest hintRequest) {
        Preconditions.a(googleApiClient, "client must not be null");
        Preconditions.a(hintRequest, "request must not be null");
        return zzq.zzc(googleApiClient.f(), ((zzr) googleApiClient.a(Auth.f10417a)).zzd(), hintRequest);
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public final PendingResult<CredentialRequestResult> request(GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
        Preconditions.a(googleApiClient, "client must not be null");
        Preconditions.a(credentialRequest, "request must not be null");
        return googleApiClient.a((GoogleApiClient) new a(this, googleApiClient, credentialRequest));
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public final PendingResult<Status> save(GoogleApiClient googleApiClient, Credential credential) {
        Preconditions.a(googleApiClient, "client must not be null");
        Preconditions.a(credential, "credential must not be null");
        return googleApiClient.b((GoogleApiClient) new c(this, googleApiClient, credential));
    }
}
