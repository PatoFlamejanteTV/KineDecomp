package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzkw;

/* loaded from: classes.dex */
class fj extends zzkw.zzb {

    /* renamed from: a */
    final /* synthetic */ zzkw f1554a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fj(zzkw zzkwVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f1554a = zzkwVar;
    }

    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a */
    public void zza(zzkx zzkxVar) throws RemoteException {
        zzkxVar.zza(new zzkw.zzb.BinderC0035zzb());
    }
}
