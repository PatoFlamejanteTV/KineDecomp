package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.internal.zznm;

/* loaded from: classes.dex */
class gn extends zznm.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ StartBleScanRequest f1578a;
    final /* synthetic */ zzon b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gn(zzon zzonVar, GoogleApiClient googleApiClient, StartBleScanRequest startBleScanRequest) {
        super(googleApiClient);
        this.b = zzonVar;
        this.f1578a = startBleScanRequest;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zznm zznmVar) throws RemoteException {
        ((zznx) zznmVar.zzpc()).zza(new StartBleScanRequest(this.f1578a, new zzou(this)));
    }
}
