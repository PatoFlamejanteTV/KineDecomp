package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzki;

/* loaded from: classes.dex */
final class a extends Api.zza<zzki, Auth.zza> {
    @Override // com.google.android.gms.common.api.Api.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzki zza(Context context, Looper looper, zzf zzfVar, Auth.zza zzaVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzki(context, looper, zzfVar, zzaVar, connectionCallbacks, onConnectionFailedListener);
    }
}
