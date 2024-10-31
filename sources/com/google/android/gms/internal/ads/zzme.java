package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public abstract class zzme implements zzpi {
    public final int type;
    protected final zzov zzagy;
    public final zzoz zzazo;
    public final zzfs zzazp;
    public final int zzazq;
    public final Object zzazr;
    public final long zzazs;
    public final long zzazt;

    public zzme(zzov zzovVar, zzoz zzozVar, int i, zzfs zzfsVar, int i2, Object obj, long j, long j2) {
        zzpo.checkNotNull(zzovVar);
        this.zzagy = zzovVar;
        zzpo.checkNotNull(zzozVar);
        this.zzazo = zzozVar;
        this.type = i;
        this.zzazp = zzfsVar;
        this.zzazq = i2;
        this.zzazr = obj;
        this.zzazs = j;
        this.zzazt = j2;
    }

    public abstract long zzfv();
}
