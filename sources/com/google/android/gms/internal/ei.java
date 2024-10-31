package com.google.android.gms.internal;

import com.google.android.gms.internal.zzja;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ei implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzja f1528a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ei(zzja zzjaVar) {
        this.f1528a = zzjaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzja.zzb zzbVar;
        zzja.zzb zzbVar2;
        this.f1528a.zzoM.zzho();
        com.google.android.gms.ads.internal.overlay.zzd zzhc = this.f1528a.zzoM.zzhc();
        if (zzhc != null) {
            zzhc.d();
        }
        zzbVar = this.f1528a.zzJY;
        if (zzbVar != null) {
            zzbVar2 = this.f1528a.zzJY;
            zzbVar2.zzbf();
            this.f1528a.zzJY = null;
        }
    }
}
