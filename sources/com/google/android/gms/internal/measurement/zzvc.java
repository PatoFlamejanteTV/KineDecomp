package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public class zzvc {
    private static final zzub zzbtk = zzub.zzvr();
    private zzte zzbzu;
    private volatile zzvv zzbzv;
    private volatile zzte zzbzw;

    private final zzvv zzh(zzvv zzvvVar) {
        if (this.zzbzv == null) {
            synchronized (this) {
                if (this.zzbzv == null) {
                    try {
                        this.zzbzv = zzvvVar;
                        this.zzbzw = zzte.zzbtq;
                    } catch (zzuv unused) {
                        this.zzbzv = zzvvVar;
                        this.zzbzw = zzte.zzbtq;
                    }
                }
            }
        }
        return this.zzbzv;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzvc)) {
            return false;
        }
        zzvc zzvcVar = (zzvc) obj;
        zzvv zzvvVar = this.zzbzv;
        zzvv zzvvVar2 = zzvcVar.zzbzv;
        if (zzvvVar == null && zzvvVar2 == null) {
            return zztw().equals(zzvcVar.zztw());
        }
        if (zzvvVar != null && zzvvVar2 != null) {
            return zzvvVar.equals(zzvvVar2);
        }
        if (zzvvVar != null) {
            return zzvvVar.equals(zzvcVar.zzh(zzvvVar.zzwj()));
        }
        return zzh(zzvvVar2.zzwj()).equals(zzvvVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzvv zzi(zzvv zzvvVar) {
        zzvv zzvvVar2 = this.zzbzv;
        this.zzbzu = null;
        this.zzbzw = null;
        this.zzbzv = zzvvVar;
        return zzvvVar2;
    }

    public final zzte zztw() {
        if (this.zzbzw != null) {
            return this.zzbzw;
        }
        synchronized (this) {
            if (this.zzbzw != null) {
                return this.zzbzw;
            }
            if (this.zzbzv == null) {
                this.zzbzw = zzte.zzbtq;
            } else {
                this.zzbzw = this.zzbzv.zztw();
            }
            return this.zzbzw;
        }
    }

    public final int zzvx() {
        if (this.zzbzw != null) {
            return this.zzbzw.size();
        }
        if (this.zzbzv != null) {
            return this.zzbzv.zzvx();
        }
        return 0;
    }
}
