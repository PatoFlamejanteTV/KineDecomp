package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.internal.zzns;

/* loaded from: classes.dex */
class hm extends zzns.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SessionInsertRequest f1604a;
    final /* synthetic */ zzot b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hm(zzot zzotVar, GoogleApiClient googleApiClient, SessionInsertRequest sessionInsertRequest) {
        super(googleApiClient);
        this.b = zzotVar;
        this.f1604a = sessionInsertRequest;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzns zznsVar) throws RemoteException {
        ((zzod) zznsVar.zzpc()).zza(new SessionInsertRequest(this.f1604a, new zzou(this)));
    }
}
