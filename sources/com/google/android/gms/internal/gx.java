package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.internal.zzno;

/* loaded from: classes.dex */
class gx extends zzno.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DataDeleteRequest f1588a;
    final /* synthetic */ zzop b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gx(zzop zzopVar, GoogleApiClient googleApiClient, DataDeleteRequest dataDeleteRequest) {
        super(googleApiClient);
        this.b = zzopVar;
        this.f1588a = dataDeleteRequest;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzno zznoVar) throws RemoteException {
        ((zznz) zznoVar.zzpc()).zza(new DataDeleteRequest(this.f1588a, new zzou(this)));
    }
}
