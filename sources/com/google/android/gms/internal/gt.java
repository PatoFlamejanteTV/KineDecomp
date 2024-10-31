package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.result.DataTypeResult;
import com.google.android.gms.internal.zznn;
import com.google.android.gms.internal.zzoo;

/* loaded from: classes.dex */
class gt extends zznn.a<DataTypeResult> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DataTypeCreateRequest f1584a;
    final /* synthetic */ zzoo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gt(zzoo zzooVar, GoogleApiClient googleApiClient, DataTypeCreateRequest dataTypeCreateRequest) {
        super(googleApiClient);
        this.b = zzooVar;
        this.f1584a = dataTypeCreateRequest;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataTypeResult zzb(Status status) {
        return DataTypeResult.a(status);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zznn zznnVar) throws RemoteException {
        ((zzny) zznnVar.zzpc()).zza(new DataTypeCreateRequest(this.f1584a, new zzoo.a(this, null)));
    }
}
