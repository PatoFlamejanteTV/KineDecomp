package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzoa;

/* loaded from: classes.dex */
public class zznp extends zznl<zzoa> {

    /* loaded from: classes.dex */
    public static class zza extends Api.zza<zznp, Api.ApiOptions.NoOptions> {
        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzi, reason: merged with bridge method [inline-methods] */
        public zznp zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zznp(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public zznp(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 61, connectionCallbacks, onConnectionFailedListener, zzfVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzbp, reason: merged with bridge method [inline-methods] */
    public zzoa zzW(IBinder iBinder) {
        return zzoa.zza.zzbA(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.fitness.InternalApi";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.fitness.internal.IGoogleFitInternalApi";
    }
}
