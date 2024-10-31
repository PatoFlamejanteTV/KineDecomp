package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.auth.api.signin.internal.zzb;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;

/* loaded from: classes.dex */
final class f extends Api.zza<zzb, GoogleSignInConfig> {
    @Override // com.google.android.gms.common.api.Api.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzb zza(Context context, Looper looper, zzf zzfVar, GoogleSignInConfig googleSignInConfig, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzb(context, looper, zzfVar, googleSignInConfig, connectionCallbacks, onConnectionFailedListener);
    }
}
