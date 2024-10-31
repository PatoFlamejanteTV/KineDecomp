package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;
import com.google.android.gms.internal.zznm;
import com.google.android.gms.internal.zzon;

/* loaded from: classes.dex */
class gs extends zznm.a<BleDevicesResult> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzon f1583a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gs(zzon zzonVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f1583a = zzonVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BleDevicesResult zzb(Status status) {
        return BleDevicesResult.a(status);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zznm zznmVar) throws RemoteException {
        ((zznx) zznmVar.zzpc()).zza(new ListClaimedBleDevicesRequest(new zzon.a(this, null)));
    }
}
