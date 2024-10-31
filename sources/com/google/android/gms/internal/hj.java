package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;
import com.google.android.gms.internal.zznr;
import com.google.android.gms.internal.zzos;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class hj extends zznr.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzos.a f1601a;
    final /* synthetic */ com.google.android.gms.fitness.data.zzj b;
    final /* synthetic */ PendingIntent c;
    final /* synthetic */ zzos d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hj(zzos zzosVar, GoogleApiClient googleApiClient, zzos.a aVar, com.google.android.gms.fitness.data.zzj zzjVar, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.d = zzosVar;
        this.f1601a = aVar;
        this.b = zzjVar;
        this.c = pendingIntent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zznr.b, com.google.android.gms.internal.zzlc
    /* renamed from: a */
    public Status zzb(Status status) {
        return status;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zznr zznrVar) throws RemoteException {
        ((zzoc) zznrVar.zzpc()).zza(new SensorUnregistrationRequest(this.b, this.c, new zzos.c(this, this.f1601a, null)));
    }
}
