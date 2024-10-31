package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzis;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements zzis.zzc<zzbb> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzdz.zze f1455a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(zzdz.zze zzeVar) {
        this.f1455a = zzeVar;
    }

    @Override // com.google.android.gms.internal.zzis.zzc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zzc(zzbb zzbbVar) {
        zzid.runOnUiThread(new bp(this, zzbbVar));
    }
}
