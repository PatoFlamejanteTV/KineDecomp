package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdz;
import java.util.Map;

/* loaded from: classes.dex */
class bd implements zzdk {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbb f1444a;
    final /* synthetic */ az b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(az azVar, zzbb zzbbVar) {
        this.b = azVar;
        this.f1444a = zzbbVar;
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        Object obj;
        zzdz.zzb zzbVar;
        obj = this.b.b.zzpd;
        synchronized (obj) {
            if (this.b.f1440a.getStatus() == -1 || this.b.f1440a.getStatus() == 1) {
                return;
            }
            this.b.b.zzys = 0;
            zzbVar = this.b.b.zzyp;
            zzbVar.zzc(this.f1444a);
            this.b.f1440a.zzg(this.f1444a);
            this.b.b.zzyr = this.b.f1440a;
            com.google.android.gms.ads.internal.util.client.zzb.d("Successfully loaded JS Engine.");
        }
    }
}
