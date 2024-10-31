package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzjv;
import com.google.android.gms.internal.zzjx;

/* loaded from: classes.dex */
class es extends zzjx.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzjv.b f1538a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public es(zzjv.b bVar) {
        this.f1538a = bVar;
    }

    @Override // com.google.android.gms.internal.zzjx
    public void zze(Status status) throws RemoteException {
        this.f1538a.zzb((zzjv.b) status);
    }
}
