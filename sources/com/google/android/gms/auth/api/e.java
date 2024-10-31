package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;

/* loaded from: classes.dex */
final class e extends Api.zza<zzg, com.google.android.gms.auth.api.signin.zzg> {
    @Override // com.google.android.gms.common.api.Api.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzg zza(Context context, Looper looper, zzf zzfVar, com.google.android.gms.auth.api.signin.zzg zzgVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzg(context, looper, zzfVar, zzgVar, connectionCallbacks, onConnectionFailedListener);
    }
}
