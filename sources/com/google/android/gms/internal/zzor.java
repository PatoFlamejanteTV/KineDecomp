package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzoe;

/* loaded from: classes.dex */
public class zzor implements RecordingApi {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends zzoe.zza {

        /* renamed from: a, reason: collision with root package name */
        private final zzlb.zzb<ListSubscriptionsResult> f1791a;

        private a(zzlb.zzb<ListSubscriptionsResult> zzbVar) {
            this.f1791a = zzbVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(zzlb.zzb zzbVar, hb hbVar) {
            this(zzbVar);
        }

        @Override // com.google.android.gms.internal.zzoe
        public void zza(ListSubscriptionsResult listSubscriptionsResult) {
            this.f1791a.zzp(listSubscriptionsResult);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, Subscription subscription) {
        return googleApiClient.zza((GoogleApiClient) new hd(this, googleApiClient, subscription));
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient googleApiClient) {
        return googleApiClient.zza((GoogleApiClient) new hb(this, googleApiClient));
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient googleApiClient, DataType dataType) {
        return googleApiClient.zza((GoogleApiClient) new hc(this, googleApiClient, dataType));
    }

    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, DataSource dataSource) {
        return zza(googleApiClient, new Subscription.zza().a(dataSource).a());
    }

    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, DataType dataType) {
        return zza(googleApiClient, new Subscription.zza().a(dataType).a());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, DataSource dataSource) {
        return googleApiClient.zzb(new hf(this, googleApiClient, dataSource));
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, DataType dataType) {
        return googleApiClient.zzb(new he(this, googleApiClient, dataType));
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, Subscription subscription) {
        return subscription.b() == null ? unsubscribe(googleApiClient, subscription.a()) : unsubscribe(googleApiClient, subscription.b());
    }
}
