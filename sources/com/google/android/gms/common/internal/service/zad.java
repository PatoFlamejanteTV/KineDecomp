package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public final class zad implements zac {
    @Override // com.google.android.gms.common.internal.service.zac
    public final PendingResult<Status> a(GoogleApiClient googleApiClient) {
        return googleApiClient.b((GoogleApiClient) new b(this, googleApiClient));
    }
}
