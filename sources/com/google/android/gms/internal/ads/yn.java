package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class yn extends zzxe {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzzh f12691a;

    private yn(zzzh zzzhVar) {
        this.f12691a = zzzhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final void zza(zzwb zzwbVar, int i) throws RemoteException {
        zzbbd.e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzbat.zztu.post(new zn(this));
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final void zzd(zzwb zzwbVar) throws RemoteException {
        zza(zzwbVar, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final String zzje() throws RemoteException {
        return null;
    }
}
