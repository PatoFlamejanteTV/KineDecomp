package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public class zzbrs {
    private static final zzbqq zzfkz = zzbqq.zzamd();
    private zzbpu zzfrl;
    private volatile zzbsl zzfrm;
    private volatile zzbpu zzfrn;

    private final zzbsl zzk(zzbsl zzbslVar) {
        if (this.zzfrm == null) {
            synchronized (this) {
                if (this.zzfrm == null) {
                    try {
                        this.zzfrm = zzbslVar;
                        this.zzfrn = zzbpu.zzfli;
                    } catch (zzbrl unused) {
                        this.zzfrm = zzbslVar;
                        this.zzfrn = zzbpu.zzfli;
                    }
                }
            }
        }
        return this.zzfrm;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbrs)) {
            return false;
        }
        zzbrs zzbrsVar = (zzbrs) obj;
        zzbsl zzbslVar = this.zzfrm;
        zzbsl zzbslVar2 = zzbrsVar.zzfrm;
        if (zzbslVar == null && zzbslVar2 == null) {
            return zzakf().equals(zzbrsVar.zzakf());
        }
        if (zzbslVar != null && zzbslVar2 != null) {
            return zzbslVar.equals(zzbslVar2);
        }
        if (zzbslVar != null) {
            return zzbslVar.equals(zzbrsVar.zzk(zzbslVar.zzamv()));
        }
        return zzk(zzbslVar2.zzamv()).equals(zzbslVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzbpu zzakf() {
        if (this.zzfrn != null) {
            return this.zzfrn;
        }
        synchronized (this) {
            if (this.zzfrn != null) {
                return this.zzfrn;
            }
            if (this.zzfrm == null) {
                this.zzfrn = zzbpu.zzfli;
            } else {
                this.zzfrn = this.zzfrm.zzakf();
            }
            return this.zzfrn;
        }
    }

    public final int zzamj() {
        if (this.zzfrn != null) {
            return this.zzfrn.size();
        }
        if (this.zzfrm != null) {
            return this.zzfrm.zzamj();
        }
        return 0;
    }

    public final zzbsl zzl(zzbsl zzbslVar) {
        zzbsl zzbslVar2 = this.zzfrm;
        this.zzfrl = null;
        this.zzfrn = null;
        this.zzfrm = zzbslVar;
        return zzbslVar2;
    }
}
