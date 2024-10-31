package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zaq implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    public final Api<?> f10953a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f10954b;

    /* renamed from: c, reason: collision with root package name */
    private zar f10955c;

    public zaq(Api<?> api, boolean z) {
        this.f10953a = api;
        this.f10954b = z;
    }

    public final void a(zar zarVar) {
        this.f10955c = zarVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        a();
        this.f10955c.onConnected(bundle);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        a();
        this.f10955c.a(connectionResult, this.f10953a, this.f10954b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        a();
        this.f10955c.onConnectionSuspended(i);
    }

    private final void a() {
        Preconditions.a(this.f10955c, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }
}
