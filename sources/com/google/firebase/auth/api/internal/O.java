package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;

/* loaded from: classes2.dex */
public final class O extends Api.AbstractClientBuilder<zzdq, zzef> {
    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* synthetic */ zzdq a(Context context, Looper looper, ClientSettings clientSettings, zzef zzefVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzdr(context, looper, clientSettings, zzefVar, connectionCallbacks, onConnectionFailedListener);
    }
}
