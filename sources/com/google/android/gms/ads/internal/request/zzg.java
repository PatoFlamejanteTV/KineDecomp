package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.request.zzc;
import com.google.android.gms.ads.internal.request.zzk;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class zzg extends zzk.zza {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<zzc.zza> f639a;

    public zzg(zzc.zza zzaVar) {
        this.f639a = new WeakReference<>(zzaVar);
    }

    @Override // com.google.android.gms.ads.internal.request.zzk
    public void a(AdResponseParcel adResponseParcel) {
        zzc.zza zzaVar = this.f639a.get();
        if (zzaVar != null) {
            zzaVar.a(adResponseParcel);
        }
    }
}
