package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.internal.zznr;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class hh extends zznr.b {

    /* renamed from: a */
    final /* synthetic */ SensorRequest f1599a;
    final /* synthetic */ com.google.android.gms.fitness.data.zzj b;
    final /* synthetic */ PendingIntent c;
    final /* synthetic */ zzos d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hh(zzos zzosVar, GoogleApiClient googleApiClient, SensorRequest sensorRequest, com.google.android.gms.fitness.data.zzj zzjVar, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.d = zzosVar;
        this.f1599a = sensorRequest;
        this.b = zzjVar;
        this.c = pendingIntent;
    }

    @Override // com.google.android.gms.internal.zznr.b, com.google.android.gms.internal.zzlc
    /* renamed from: a */
    public Status zzb(Status status) {
        return status;
    }

    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a */
    public void zza(zznr zznrVar) throws RemoteException {
        ((zzoc) zznrVar.zzpc()).zza(new SensorRegistrationRequest(this.f1599a, this.b, this.c, new zzou(this)));
    }
}
