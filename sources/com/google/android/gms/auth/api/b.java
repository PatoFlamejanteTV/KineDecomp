package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.internal.zze;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;

/* loaded from: classes.dex */
final class b extends Api.zza<zze, Auth.AuthCredentialsOptions> {
    @Override // com.google.android.gms.common.api.Api.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zze zza(Context context, Looper looper, zzf zzfVar, Auth.AuthCredentialsOptions authCredentialsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zze(context, looper, zzfVar, authCredentialsOptions, connectionCallbacks, onConnectionFailedListener);
    }
}
