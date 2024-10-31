package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzi implements zzaa {
    private final Executor zzv;

    public zzi(Handler handler) {
        this.zzv = new Jk(this, handler);
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    public final void zza(zzr<?> zzrVar, zzx<?> zzxVar, Runnable runnable) {
        zzrVar.zzl();
        zzrVar.zzb("post-response");
        this.zzv.execute(new _k(zzrVar, zzxVar, runnable));
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    public final void zzb(zzr<?> zzrVar, zzx<?> zzxVar) {
        zza(zzrVar, zzxVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    public final void zza(zzr<?> zzrVar, zzae zzaeVar) {
        zzrVar.zzb("post-error");
        this.zzv.execute(new _k(zzrVar, zzx.zzc(zzaeVar), null));
    }
}
