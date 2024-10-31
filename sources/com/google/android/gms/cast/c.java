package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzkx;

/* loaded from: classes.dex */
final class c extends Api.zza<zzkx, CastRemoteDisplay.CastRemoteDisplayOptions> {
    @Override // com.google.android.gms.common.api.Api.zza
    /* renamed from: a */
    public zzkx zza(Context context, Looper looper, zzf zzfVar, CastRemoteDisplay.CastRemoteDisplayOptions castRemoteDisplayOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzkx(context, looper, zzfVar, castRemoteDisplayOptions.f822a, castRemoteDisplayOptions.b, connectionCallbacks, onConnectionFailedListener);
    }
}
