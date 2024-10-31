package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzjv;
import com.google.android.gms.internal.zzjx;

/* loaded from: classes.dex */
class et extends zzjx.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzjv.c f1539a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public et(zzjv.c cVar) {
        this.f1539a = cVar;
    }

    @Override // com.google.android.gms.internal.zzjx
    public void zze(Status status) throws RemoteException {
        this.f1539a.zzb((zzjv.c) status);
    }
}
