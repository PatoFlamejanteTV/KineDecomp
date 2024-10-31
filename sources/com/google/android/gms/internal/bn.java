package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzis;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements zzis.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzdz.zzd f1454a;
    final /* synthetic */ zzdz.zze b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(zzdz.zze zzeVar, zzdz.zzd zzdVar) {
        this.b = zzeVar;
        this.f1454a = zzdVar;
    }

    @Override // com.google.android.gms.internal.zzis.zza
    public void run() {
        com.google.android.gms.ads.internal.util.client.zzb.d("Rejecting reference for JS Engine.");
        this.f1454a.reject();
    }
}
