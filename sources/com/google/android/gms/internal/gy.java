package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResult;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.internal.zzop;

/* loaded from: classes.dex */
class gy extends zzno.a<DataReadResult> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DataReadRequest f1589a;
    final /* synthetic */ zzop b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gy(zzop zzopVar, GoogleApiClient googleApiClient, DataReadRequest dataReadRequest) {
        super(googleApiClient);
        this.b = zzopVar;
        this.f1589a = dataReadRequest;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataReadResult zzb(Status status) {
        return DataReadResult.a(status, this.f1589a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzno zznoVar) throws RemoteException {
        ((zznz) zznoVar.zzpc()).zza(new DataReadRequest(this.f1589a, new zzop.a(this, null)));
    }
}
