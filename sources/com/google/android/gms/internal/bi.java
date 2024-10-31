package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzis;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements zzis.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzdz.zze f1449a;
    final /* synthetic */ zzdz b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(zzdz zzdzVar, zzdz.zze zzeVar) {
        this.b = zzdzVar;
        this.f1449a = zzeVar;
    }

    @Override // com.google.android.gms.internal.zzis.zza
    public void run() {
        Object obj;
        obj = this.b.zzpd;
        synchronized (obj) {
            this.b.zzys = 1;
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed loading new engine. Marking new engine destroyable.");
            this.f1449a.zzdR();
        }
    }
}
