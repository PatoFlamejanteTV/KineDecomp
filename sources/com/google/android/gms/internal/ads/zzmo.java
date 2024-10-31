package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public abstract class zzmo extends zzme {
    public final int zzbaw;

    public zzmo(zzov zzovVar, zzoz zzozVar, zzfs zzfsVar, int i, Object obj, long j, long j2, int i2) {
        super(zzovVar, zzozVar, 1, zzfsVar, i, obj, j, j2);
        zzpo.checkNotNull(zzfsVar);
        this.zzbaw = i2;
    }

    public int zzfz() {
        return this.zzbaw + 1;
    }

    public abstract boolean zzga();
}
