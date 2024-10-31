package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.DisableFitRequest;
import com.google.android.gms.internal.zznn;

/* loaded from: classes.dex */
class gv extends zznn.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzoo f1586a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gv(zzoo zzooVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f1586a = zzooVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zznn zznnVar) throws RemoteException {
        ((zzny) zznnVar.zzpc()).zza(new DisableFitRequest(new zzou(this)));
    }
}
