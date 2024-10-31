package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzafs extends zzew implements zzafr {
    public zzafs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final void zza(zzafl zzaflVar, zzafp zzafpVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzaflVar);
        zzey.zza(obtainAndWriteInterfaceToken, zzafpVar);
        zzb(2, obtainAndWriteInterfaceToken);
    }
}
