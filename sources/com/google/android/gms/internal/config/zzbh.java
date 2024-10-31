package com.google.android.gms.internal.config;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzbh {
    protected volatile int zzcq = -1;

    public String toString() {
        return zzbi.zzb(this);
    }

    public abstract zzbh zza(zzay zzayVar) throws IOException;

    public void zza(zzaz zzazVar) throws IOException {
    }

    @Override // 
    /* renamed from: zzae */
    public zzbh clone() throws CloneNotSupportedException {
        return (zzbh) super.clone();
    }

    public final int zzai() {
        int zzu = zzu();
        this.zzcq = zzu;
        return zzu;
    }

    protected int zzu() {
        return 0;
    }
}
