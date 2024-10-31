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
import com.google.android.gms.internal.zznz;

/* loaded from: classes.dex */
public class zzno extends zznl<zznz> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class a<R extends Result> extends zzlb.zza<R, zzno> {
        public a(GoogleApiClient googleApiClient) {
            super(Fitness.c, googleApiClient);
        }
    }

    /* loaded from: classes.dex */
    static abstract class b extends a<Status> {
        public b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a */
        public Status zzb(Status status) {
            com.google.android.gms.common.internal.zzx.b(!status.d());
            return status;
        }
    }

    /* loaded from: classes.dex */
    public static class zzb extends Api.zza<zzno, Api.ApiOptions.NoOptions> {
        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzh */
        public zzno zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzno(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public zzno(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 57, connectionCallbacks, onConnectionFailedListener, zzfVar);
    }

    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzbo */
    public zznz zzW(IBinder iBinder) {
        return zznz.zza.zzbz(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.fitness.HistoryApi";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.fitness.internal.IGoogleFitHistoryApi";
    }
}
