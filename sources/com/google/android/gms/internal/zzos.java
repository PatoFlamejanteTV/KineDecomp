package com.google.android.gms.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zzoj;

/* loaded from: classes.dex */
public class zzos implements SensorsApi {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends zznv.zza {

        /* renamed from: a, reason: collision with root package name */
        private final zzlb.zzb<DataSourcesResult> f1792a;

        private b(zzlb.zzb<DataSourcesResult> zzbVar) {
            this.f1792a = zzbVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(zzlb.zzb zzbVar, hg hgVar) {
            this(zzbVar);
        }

        @Override // com.google.android.gms.internal.zznv
        public void zza(DataSourcesResult dataSourcesResult) {
            this.f1792a.zzp(dataSourcesResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends zzoj.zza {

        /* renamed from: a, reason: collision with root package name */
        private final zzlb.zzb<Status> f1793a;
        private final a b;

        private c(zzlb.zzb<Status> zzbVar, a aVar) {
            this.f1793a = zzbVar;
            this.b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ c(zzlb.zzb zzbVar, a aVar, hg hgVar) {
            this(zzbVar, aVar);
        }

        @Override // com.google.android.gms.internal.zzoj
        public void zzo(Status status) {
            if (this.b != null && status.d()) {
                this.b.a();
            }
            this.f1793a.zzp(status);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, com.google.android.gms.fitness.data.zzj zzjVar, PendingIntent pendingIntent, a aVar) {
        return googleApiClient.zzb(new hj(this, googleApiClient, aVar, zzjVar, pendingIntent));
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, SensorRequest sensorRequest, com.google.android.gms.fitness.data.zzj zzjVar, PendingIntent pendingIntent) {
        return googleApiClient.zza((GoogleApiClient) new hh(this, googleApiClient, sensorRequest, zzjVar, pendingIntent));
    }

    public PendingResult<Status> add(GoogleApiClient googleApiClient, SensorRequest sensorRequest, PendingIntent pendingIntent) {
        return zza(googleApiClient, sensorRequest, (com.google.android.gms.fitness.data.zzj) null, pendingIntent);
    }

    public PendingResult<Status> add(GoogleApiClient googleApiClient, SensorRequest sensorRequest, OnDataPointListener onDataPointListener) {
        return zza(googleApiClient, sensorRequest, zzk.zza.a().a(onDataPointListener), (PendingIntent) null);
    }

    public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient googleApiClient, DataSourcesRequest dataSourcesRequest) {
        return googleApiClient.zza((GoogleApiClient) new hg(this, googleApiClient, dataSourcesRequest));
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return zza(googleApiClient, (com.google.android.gms.fitness.data.zzj) null, pendingIntent, (a) null);
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, OnDataPointListener onDataPointListener) {
        com.google.android.gms.fitness.data.zzk b2 = zzk.zza.a().b(onDataPointListener);
        return b2 == null ? PendingResults.a(Status.f979a, googleApiClient) : zza(googleApiClient, b2, (PendingIntent) null, new hi(this, onDataPointListener));
    }
}
