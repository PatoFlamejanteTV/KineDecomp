package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.internal.zzns;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ho extends zzns.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PendingIntent f1606a;
    final /* synthetic */ int b;
    final /* synthetic */ zzot c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ho(zzot zzotVar, GoogleApiClient googleApiClient, PendingIntent pendingIntent, int i) {
        super(googleApiClient);
        this.c = zzotVar;
        this.f1606a = pendingIntent;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzns zznsVar) throws RemoteException {
        ((zzod) zznsVar.zzpc()).zza(new SessionRegistrationRequest(this.f1606a, new zzou(this), this.b));
    }
}
