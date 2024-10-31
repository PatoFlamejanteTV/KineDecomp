package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
final class hx extends Api.zza<zzpt, Api.ApiOptions.NoOptions> {
    @Override // com.google.android.gms.common.api.Api.zza
    /* renamed from: a */
    public zzpt zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzpt(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
    }
}
