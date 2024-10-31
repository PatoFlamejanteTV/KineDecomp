package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;

/* loaded from: classes.dex */
public abstract class zzb<R extends Result> extends zzlb.zza<R, zze> {
    public zzb(GoogleApiClient googleApiClient) {
        super(zzk.f856a, googleApiClient);
    }

    public void zzba(int i) {
        zzb((zzb<R>) zzb(new Status(i)));
    }

    public void zze(int i, String str) {
        zzb((zzb<R>) zzb(new Status(i, str, null)));
    }
}
