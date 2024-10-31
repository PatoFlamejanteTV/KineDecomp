package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.result.DataTypeResult;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zznw;

/* loaded from: classes.dex */
public class zzoo implements ConfigApi {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends zznw.zza {

        /* renamed from: a, reason: collision with root package name */
        private final zzlb.zzb<DataTypeResult> f1789a;

        private a(zzlb.zzb<DataTypeResult> zzbVar) {
            this.f1789a = zzbVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(zzlb.zzb zzbVar, gt gtVar) {
            this(zzbVar);
        }

        @Override // com.google.android.gms.internal.zznw
        public void zza(DataTypeResult dataTypeResult) {
            this.f1789a.zzp(dataTypeResult);
        }
    }

    public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient googleApiClient, DataTypeCreateRequest dataTypeCreateRequest) {
        return googleApiClient.zzb(new gt(this, googleApiClient, dataTypeCreateRequest));
    }

    public PendingResult<Status> disableFit(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new gv(this, googleApiClient));
    }

    public PendingResult<DataTypeResult> readDataType(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza((GoogleApiClient) new gu(this, googleApiClient, str));
    }
}
