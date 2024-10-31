package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.internal.zznm;

/* loaded from: classes.dex */
class go extends zznm.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BleScanCallback f1579a;
    final /* synthetic */ zzon b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public go(zzon zzonVar, GoogleApiClient googleApiClient, BleScanCallback bleScanCallback) {
        super(googleApiClient);
        this.b = zzonVar;
        this.f1579a = bleScanCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zznm zznmVar) throws RemoteException {
        ((zznx) zznmVar.zzpc()).zza(new StopBleScanRequest(this.f1579a, new zzou(this)));
    }
}
