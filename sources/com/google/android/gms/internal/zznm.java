package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zznx;

/* loaded from: classes.dex */
public class zznm extends zznl<zznx> {

    /* loaded from: classes.dex */
    static abstract class a<R extends Result> extends zzlb.zza<R, zznm> {
        public a(GoogleApiClient googleApiClient) {
            super(Fitness.f1214a, googleApiClient);
        }
    }

    /* loaded from: classes.dex */
    static abstract class b extends a<Status> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status zzb(Status status) {
            com.google.android.gms.common.internal.zzx.b(!status.d());
            return status;
        }
    }

    /* loaded from: classes.dex */
    public static class zzb extends Api.zza<zznm, Api.ApiOptions.NoOptions> {
        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
        public zznm zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zznm(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public zznm(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 59, connectionCallbacks, onConnectionFailedListener, zzfVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzbm, reason: merged with bridge method [inline-methods] */
    public zznx zzW(IBinder iBinder) {
        return zznx.zza.zzbx(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.fitness.BleApi";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.fitness.internal.IGoogleFitBleApi";
    }
}
