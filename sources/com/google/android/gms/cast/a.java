package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
final class a extends Api.zza<zze, Cast.CastOptions> {
    @Override // com.google.android.gms.common.api.Api.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zze zza(Context context, Looper looper, zzf zzfVar, Cast.CastOptions castOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        int i;
        zzx.a(castOptions, "Setting the API options is required.");
        CastDevice castDevice = castOptions.f819a;
        i = castOptions.c;
        return new zze(context, looper, zzfVar, castDevice, i, castOptions.b, connectionCallbacks, onConnectionFailedListener);
    }
}
