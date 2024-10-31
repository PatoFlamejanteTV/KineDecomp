package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.internal.zzns;

/* loaded from: classes.dex */
class hk extends zzns.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Session f1602a;
    final /* synthetic */ zzot b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hk(zzot zzotVar, GoogleApiClient googleApiClient, Session session) {
        super(googleApiClient);
        this.b = zzotVar;
        this.f1602a = session;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzns zznsVar) throws RemoteException {
        ((zzod) zznsVar.zzpc()).zza(new SessionStartRequest(this.f1602a, new zzou(this)));
    }
}
