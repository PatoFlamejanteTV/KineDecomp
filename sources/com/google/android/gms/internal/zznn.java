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
import com.google.android.gms.internal.zzny;

/* loaded from: classes.dex */
public class zznn extends zznl<zzny> {

    /* loaded from: classes.dex */
    static abstract class a<R extends Result> extends zzlb.zza<R, zznn> {
        public a(GoogleApiClient googleApiClient) {
            super(Fitness.b, googleApiClient);
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
    public static class zzb extends Api.zza<zznn, Api.ApiOptions.NoOptions> {
        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
        public zznn zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zznn(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public zznn(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 60, connectionCallbacks, onConnectionFailedListener, zzfVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzbn, reason: merged with bridge method [inline-methods] */
    public zzny zzW(IBinder iBinder) {
        return zzny.zza.zzby(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.fitness.ConfigApi";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.fitness.internal.IGoogleFitConfigApi";
    }
}
