package com.google.android.gms.appinvite;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzjw;

/* loaded from: classes.dex */
final class a extends Api.zza<zzjw, Api.ApiOptions.NoOptions> {
    @Override // com.google.android.gms.common.api.Api.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzjw zza(Context context, Looper looper, zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzjw(context, looper, connectionCallbacks, onConnectionFailedListener, zzfVar);
    }
}
