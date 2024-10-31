package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzjq;
import com.google.android.gms.internal.zzlb;

/* loaded from: classes.dex */
public abstract class zzjr<T> extends zzjq.zza {
    protected zzlb.zzb<T> zzRb;

    public zzjr(zzlb.zzb<T> zzbVar) {
        this.zzRb = zzbVar;
    }

    public void zza(GetRecentContextCall.Response response) {
    }

    @Override // com.google.android.gms.internal.zzjq
    public void zza(Status status, ParcelFileDescriptor parcelFileDescriptor) {
    }

    @Override // com.google.android.gms.internal.zzjq
    public void zza(Status status, boolean z) {
    }

    @Override // com.google.android.gms.internal.zzjq
    public void zzc(Status status) {
    }
}
