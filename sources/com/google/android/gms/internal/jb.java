package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
final class jb extends Api.zza<com.google.android.gms.signin.internal.zzi, zzqx> {
    @Override // com.google.android.gms.common.api.Api.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.signin.internal.zzi zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, zzqx zzqxVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new com.google.android.gms.signin.internal.zzi(context, looper, true, zzfVar, zzqxVar == null ? zzqx.zzaUZ : zzqxVar, connectionCallbacks, onConnectionFailedListener, Executors.newSingleThreadExecutor());
    }
}
