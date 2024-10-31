package com.google.android.gms.internal.clearcut;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class mb extends BaseImplementation.ApiMethodImpl<Status, zzj> {
    private final com.google.android.gms.clearcut.zze s;

    /* JADX INFO: Access modifiers changed from: package-private */
    public mb(com.google.android.gms.clearcut.zze zzeVar, GoogleApiClient googleApiClient) {
        super(ClearcutLogger.f10620c, googleApiClient);
        this.s = zzeVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result a(Status status) {
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzj zzjVar) throws RemoteException {
        zzj zzjVar2 = zzjVar;
        nb nbVar = new nb(this);
        try {
            com.google.android.gms.clearcut.zze zzeVar = this.s;
            if (zzeVar.j != null && zzeVar.i.zzbjp.length == 0) {
                zzeVar.i.zzbjp = zzeVar.j.zza();
            }
            if (zzeVar.k != null && zzeVar.i.zzbjw.length == 0) {
                zzeVar.i.zzbjw = zzeVar.k.zza();
            }
            zzha zzhaVar = zzeVar.i;
            byte[] bArr = new byte[zzhaVar.zzas()];
            zzfz.zza(zzhaVar, bArr, 0, bArr.length);
            zzeVar.f10638b = bArr;
            ((zzn) zzjVar2.getService()).zza(nbVar, this.s);
        } catch (RuntimeException e2) {
            Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageProducer ", e2);
            c(new Status(10, "MessageProducer"));
        }
    }
}
