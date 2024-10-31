package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* loaded from: classes2.dex */
public final class C implements zzbbl<zzafr, ParcelFileDescriptor> {

    /* renamed from: a */
    private final /* synthetic */ zzafl f11432a;

    public C(zzaft zzaftVar, zzafl zzaflVar) {
        this.f11432a = zzaflVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbl
    public final /* synthetic */ zzbcb<ParcelFileDescriptor> zzf(zzafr zzafrVar) throws Exception {
        zzbcl zzbclVar = new zzbcl();
        zzafrVar.zza(this.f11432a, new D(this, zzbclVar));
        return zzbclVar;
    }
}
