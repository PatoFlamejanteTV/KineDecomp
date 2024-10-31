package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
public interface zar extends GoogleApiClient.ConnectionCallbacks {
    void a(ConnectionResult connectionResult, Api<?> api, boolean z);
}
