package com.google.android.gms.ads.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.ads.internal.formats.zzd f584a;
    final /* synthetic */ zzn b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(zzn zznVar, com.google.android.gms.ads.internal.formats.zzd zzdVar) {
        this.b = zznVar;
        this.f584a = zzdVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.b.zzot.s.zza(this.f584a);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
        }
    }
}
