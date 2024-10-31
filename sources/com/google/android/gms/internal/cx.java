package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.internal.zzja;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cx implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f1490a;
    final /* synthetic */ AdRequestInfoParcel b;
    final /* synthetic */ zzgv c;
    final /* synthetic */ zzcg d;
    final /* synthetic */ zzce e;
    final /* synthetic */ String f;
    final /* synthetic */ zzbr g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(Context context, AdRequestInfoParcel adRequestInfoParcel, zzgv zzgvVar, zzcg zzcgVar, zzce zzceVar, String str, zzbr zzbrVar) {
        this.f1490a = context;
        this.b = adRequestInfoParcel;
        this.c = zzgvVar;
        this.d = zzcgVar;
        this.e = zzceVar;
        this.f = str;
        this.g = zzbrVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzja.zza zza;
        zziz zza2 = com.google.android.gms.ads.internal.zzp.f().zza(this.f1490a, new AdSizeParcel(), false, false, null, this.b.k);
        if (com.google.android.gms.ads.internal.zzp.h().zzgu()) {
            zza2.clearCache(true);
        }
        zza2.getWebView().setWillNotDraw(true);
        this.c.zze(zza2);
        this.d.zza(this.e, "rwc");
        zza = zzgt.zza(this.f, this.d, this.d.zzdn());
        zzja zzhe = zza2.zzhe();
        zzhe.zza("/invalidRequest", this.c.zzFR);
        zzhe.zza("/loadAdURL", this.c.zzFS);
        zzhe.zza("/log", zzdj.zzxv);
        zzhe.zza(zza);
        com.google.android.gms.ads.internal.util.client.zzb.a("Loading the JS library.");
        zza2.loadUrl(this.g.zzdc());
    }
}
