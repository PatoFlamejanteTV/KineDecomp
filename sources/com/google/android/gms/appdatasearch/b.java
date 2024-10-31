package com.google.android.gms.appdatasearch;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzjs;

/* loaded from: classes.dex */
final class b extends Api.zza<zzjs, Api.ApiOptions.NoOptions> {
    @Override // com.google.android.gms.common.api.Api.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzjs zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzjs(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
    }
}
