package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public interface GoogleSignInApi {
    PendingResult<Status> a(GoogleApiClient googleApiClient);

    PendingResult<Status> b(GoogleApiClient googleApiClient);
}
