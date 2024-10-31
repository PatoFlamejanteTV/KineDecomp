package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzis;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements zzis.zzc<zzbb> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzdz.zzd f1453a;
    final /* synthetic */ zzdz.zze b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(zzdz.zze zzeVar, zzdz.zzd zzdVar) {
        this.b = zzeVar;
        this.f1453a = zzdVar;
    }

    @Override // com.google.android.gms.internal.zzis.zzc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zzc(zzbb zzbbVar) {
        com.google.android.gms.ads.internal.util.client.zzb.d("Getting a new session for JS Engine.");
        this.f1453a.zzg(zzbbVar.zzci());
    }
}
