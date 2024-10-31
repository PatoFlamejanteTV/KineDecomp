package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
public final class zzar implements ProxyApi {
    public final PendingResult<ProxyApi.SpatulaHeaderResult> getSpatulaHeader(GoogleApiClient googleApiClient) {
        Preconditions.a(googleApiClient);
        return googleApiClient.b((GoogleApiClient) new e(this, googleApiClient));
    }

    public final PendingResult<ProxyApi.ProxyResult> performProxyRequest(GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        Preconditions.a(googleApiClient);
        Preconditions.a(proxyRequest);
        return googleApiClient.b((GoogleApiClient) new c(this, googleApiClient, proxyRequest));
    }
}
