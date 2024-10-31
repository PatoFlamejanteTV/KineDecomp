package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzis;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements zzis.zzc<zzbe> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzdz.zzd f1450a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(zzdz.zzd zzdVar) {
        this.f1450a = zzdVar;
    }

    @Override // com.google.android.gms.internal.zzis.zzc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zzc(zzbe zzbeVar) {
        com.google.android.gms.ads.internal.util.client.zzb.d("Ending javascript session.");
        ((zzbf) zzbeVar).zzck();
    }
}
