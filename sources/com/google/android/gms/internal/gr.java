package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;
import com.google.android.gms.internal.zznm;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gr extends zznm.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1582a;
    final /* synthetic */ zzon b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gr(zzon zzonVar, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.b = zzonVar;
        this.f1582a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zznm zznmVar) throws RemoteException {
        ((zznx) zznmVar.zzpc()).zza(new UnclaimBleDeviceRequest(this.f1582a, new zzou(this)));
    }
}
