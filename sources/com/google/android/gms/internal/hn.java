package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.internal.zzns;
import com.google.android.gms.internal.zzot;

/* loaded from: classes.dex */
class hn extends zzns.a<SessionReadResult> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SessionReadRequest f1605a;
    final /* synthetic */ zzot b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hn(zzot zzotVar, GoogleApiClient googleApiClient, SessionReadRequest sessionReadRequest) {
        super(googleApiClient);
        this.b = zzotVar;
        this.f1605a = sessionReadRequest;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SessionReadResult zzb(Status status) {
        return SessionReadResult.a(status);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzns zznsVar) throws RemoteException {
        ((zzod) zznsVar.zzpc()).zza(new SessionReadRequest(this.f1605a, new zzot.a(this, null)));
    }
}
