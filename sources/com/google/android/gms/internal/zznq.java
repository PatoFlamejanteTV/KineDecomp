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
import com.google.android.gms.internal.zzob;

/* loaded from: classes.dex */
public class zznq extends zznl<zzob> {

    /* loaded from: classes.dex */
    static abstract class a<R extends Result> extends zzlb.zza<R, zznq> {
        public a(GoogleApiClient googleApiClient) {
            super(Fitness.e, googleApiClient);
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
    public static class zzb extends Api.zza<zznq, Api.ApiOptions.NoOptions> {
        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzj, reason: merged with bridge method [inline-methods] */
        public zznq zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zznq(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public zznq(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 56, connectionCallbacks, onConnectionFailedListener, zzfVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzbq, reason: merged with bridge method [inline-methods] */
    public zzob zzW(IBinder iBinder) {
        return zzob.zza.zzbB(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.fitness.RecordingApi";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.fitness.internal.IGoogleFitRecordingApi";
    }
}
