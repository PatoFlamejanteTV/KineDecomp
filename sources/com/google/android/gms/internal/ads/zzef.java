package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzef implements Callable {
    private final zzdl zzqo;
    private final zzbl zzun;

    public zzef(zzdl zzdlVar, zzbl zzblVar) {
        this.zzqo = zzdlVar;
        this.zzun = zzblVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: zzau, reason: merged with bridge method [inline-methods] */
    public final Void call() throws Exception {
        if (this.zzqo.zzal() != null) {
            this.zzqo.zzal().get();
        }
        zzbl zzak = this.zzqo.zzak();
        if (zzak == null) {
            return null;
        }
        try {
            synchronized (this.zzun) {
                zzbuz.zza(this.zzun, zzbuz.zzb(zzak));
            }
            return null;
        } catch (zzbuy unused) {
            return null;
        }
    }
}
