package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzoj;

/* loaded from: classes.dex */
public class zzou extends zzoj.zza {
    private final zzlb.zzb<Status> zzagy;

    public zzou(zzlb.zzb<Status> zzbVar) {
        this.zzagy = zzbVar;
    }

    @Override // com.google.android.gms.internal.zzoj
    public void zzo(Status status) {
        this.zzagy.zzp(status);
    }
}
