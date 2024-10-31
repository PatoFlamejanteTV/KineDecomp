package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public final class zzb extends zzn.zza {

    /* renamed from: a, reason: collision with root package name */
    private final zza f538a;

    public zzb(zza zzaVar) {
        this.f538a = zzaVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzn
    public void a() {
        this.f538a.onAdClicked();
    }
}
