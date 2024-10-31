package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* loaded from: classes.dex */
public class zzkm implements ProxyApi {
    public PendingResult<ProxyApi.ProxyResult> performProxyRequest(GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        com.google.android.gms.common.internal.zzx.a(googleApiClient);
        com.google.android.gms.common.internal.zzx.a(proxyRequest);
        return googleApiClient.zzb(new ew(this, googleApiClient, proxyRequest));
    }
}
