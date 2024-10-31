package com.google.android.gms.ads.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.ads.internal.formats.zze f585a;
    final /* synthetic */ zzn b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(zzn zznVar, com.google.android.gms.ads.internal.formats.zze zzeVar) {
        this.b = zznVar;
        this.f585a = zzeVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.b.zzot.t.zza(this.f585a);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
        }
    }
}
