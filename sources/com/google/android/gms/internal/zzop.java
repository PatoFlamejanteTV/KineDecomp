package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zznu;

/* loaded from: classes.dex */
public class zzop implements HistoryApi {

    /* loaded from: classes.dex */
    public static class a extends zznu.zza {

        /* renamed from: a */
        private final zzlb.zzb<DataReadResult> f1790a;
        private int b;
        private DataReadResult c;

        private a(zzlb.zzb<DataReadResult> zzbVar) {
            this.b = 0;
            this.c = null;
            this.f1790a = zzbVar;
        }

        public /* synthetic */ a(zzlb.zzb zzbVar, gw gwVar) {
            this(zzbVar);
        }

        @Override // com.google.android.gms.internal.zznu
        public void zza(DataReadResult dataReadResult) {
            synchronized (this) {
                Log.v("Fitness", "Received batch result");
                if (this.c == null) {
                    this.c = dataReadResult;
                } else {
                    this.c.a(dataReadResult);
                }
                this.b++;
                if (this.b == this.c.c()) {
                    this.f1790a.zzp(this.c);
                }
            }
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, DataSet dataSet, boolean z) {
        com.google.android.gms.common.internal.zzx.a(dataSet, "Must set the data set");
        com.google.android.gms.common.internal.zzx.a(!dataSet.c().isEmpty(), "Cannot use an empty data set");
        com.google.android.gms.common.internal.zzx.a(dataSet.a().d(), "Must set the app package name for the data source");
        return googleApiClient.zza((GoogleApiClient) new gw(this, googleApiClient, dataSet, z));
    }

    public PendingResult<Status> deleteData(GoogleApiClient googleApiClient, DataDeleteRequest dataDeleteRequest) {
        return googleApiClient.zza((GoogleApiClient) new gx(this, googleApiClient, dataDeleteRequest));
    }

    public PendingResult<Status> insertData(GoogleApiClient googleApiClient, DataSet dataSet) {
        return zza(googleApiClient, dataSet, false);
    }

    public PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient googleApiClient, DataType dataType) {
        return googleApiClient.zza((GoogleApiClient) new gz(this, googleApiClient, dataType));
    }

    public PendingResult<DataReadResult> readData(GoogleApiClient googleApiClient, DataReadRequest dataReadRequest) {
        return googleApiClient.zza((GoogleApiClient) new gy(this, googleApiClient, dataReadRequest));
    }
}
