package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
final class jc extends Api.zza<com.google.android.gms.signin.internal.zzi, Api.ApiOptions.NoOptions> {
    @Override // com.google.android.gms.common.api.Api.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.signin.internal.zzi zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new com.google.android.gms.signin.internal.zzi(context, looper, false, zzfVar, zzqx.zzaUZ, connectionCallbacks, onConnectionFailedListener, Executors.newSingleThreadExecutor());
    }
}
