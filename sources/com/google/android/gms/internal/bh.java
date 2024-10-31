package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzis;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements zzis.zzc<zzbb> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzdz.zze f1448a;
    final /* synthetic */ zzdz b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(zzdz zzdzVar, zzdz.zze zzeVar) {
        this.b = zzdzVar;
        this.f1448a = zzeVar;
    }

    @Override // com.google.android.gms.internal.zzis.zzc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zzc(zzbb zzbbVar) {
        Object obj;
        zzdz.zze zzeVar;
        zzdz.zze zzeVar2;
        zzdz.zze zzeVar3;
        obj = this.b.zzpd;
        synchronized (obj) {
            this.b.zzys = 0;
            zzeVar = this.b.zzyr;
            if (zzeVar != null) {
                zzdz.zze zzeVar4 = this.f1448a;
                zzeVar2 = this.b.zzyr;
                if (zzeVar4 != zzeVar2) {
                    com.google.android.gms.ads.internal.util.client.zzb.d("New JS engine is loaded, marking previous one as destroyable.");
                    zzeVar3 = this.b.zzyr;
                    zzeVar3.zzdR();
                }
            }
            this.b.zzyr = this.f1448a;
        }
    }
}
