package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzhs;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f586a;
    final /* synthetic */ zzhs b;
    final /* synthetic */ zzn c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(zzn zznVar, String str, zzhs zzhsVar) {
        this.c = zznVar;
        this.f586a = str;
        this.b = zzhsVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.c.zzot.v.get(this.f586a).zza((com.google.android.gms.ads.internal.formats.zzf) this.b.zzHB);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
        }
    }
}
