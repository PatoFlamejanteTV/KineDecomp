package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;
import com.google.android.gms.internal.zzns;

/* loaded from: classes.dex */
class hp extends zzns.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PendingIntent f1607a;
    final /* synthetic */ zzot b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hp(zzot zzotVar, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.b = zzotVar;
        this.f1607a = pendingIntent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzns zznsVar) throws RemoteException {
        ((zzod) zznsVar.zzpc()).zza(new SessionUnregistrationRequest(this.f1607a, new zzou(this)));
    }
}
