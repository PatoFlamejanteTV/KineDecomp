package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzkw;

/* loaded from: classes.dex */
class fi extends zzkw.zzb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1553a;
    final /* synthetic */ zzkw b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fi(zzkw zzkwVar, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.b = zzkwVar;
        this.f1553a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzkx zzkxVar) throws RemoteException {
        zzla zzlaVar;
        zzkw.zzb.zza zzaVar = new zzkw.zzb.zza(zzkxVar);
        zzlaVar = this.b.zzZO;
        zzkxVar.zza(zzaVar, zzlaVar, this.f1553a);
    }
}