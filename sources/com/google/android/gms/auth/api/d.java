package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzkf;

/* loaded from: classes.dex */
final class d extends Api.zza<zzkf, Api.ApiOptions.NoOptions> {
    @Override // com.google.android.gms.common.api.Api.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzkf zza(Context context, Looper looper, zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzkf(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
    }
}
