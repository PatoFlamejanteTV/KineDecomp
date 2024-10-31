package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.zznr;
import com.google.android.gms.internal.zzos;

/* loaded from: classes.dex */
class hg extends zznr.a<DataSourcesResult> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DataSourcesRequest f1598a;
    final /* synthetic */ zzos b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hg(zzos zzosVar, GoogleApiClient googleApiClient, DataSourcesRequest dataSourcesRequest) {
        super(googleApiClient);
        this.b = zzosVar;
        this.f1598a = dataSourcesRequest;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataSourcesResult zzb(Status status) {
        return DataSourcesResult.a(status);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zznr zznrVar) throws RemoteException {
        ((zzoc) zznrVar.zzpc()).zza(new DataSourcesRequest(this.f1598a, new zzos.b(this, null)));
    }
}
