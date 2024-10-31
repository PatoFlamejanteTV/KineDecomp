package com.google.android.gms.internal.firebase_auth;

/* loaded from: classes2.dex */
public class zzgj {
    private static final zzfg zzsj = zzfg.zzgq();
    private zzeh zzyo;
    private volatile zzhc zzyp;
    private volatile zzeh zzyq;

    private final zzhc zzi(zzhc zzhcVar) {
        if (this.zzyp == null) {
            synchronized (this) {
                if (this.zzyp == null) {
                    try {
                        this.zzyp = zzhcVar;
                        this.zzyq = zzeh.zzso;
                    } catch (zzgc unused) {
                        this.zzyp = zzhcVar;
                        this.zzyq = zzeh.zzso;
                    }
                }
            }
        }
        return this.zzyp;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgj)) {
            return false;
        }
        zzgj zzgjVar = (zzgj) obj;
        zzhc zzhcVar = this.zzyp;
        zzhc zzhcVar2 = zzgjVar.zzyp;
        if (zzhcVar == null && zzhcVar2 == null) {
            return zzer().equals(zzgjVar.zzer());
        }
        if (zzhcVar != null && zzhcVar2 != null) {
            return zzhcVar.equals(zzhcVar2);
        }
        if (zzhcVar != null) {
            return zzhcVar.equals(zzgjVar.zzi(zzhcVar.zzhi()));
        }
        return zzi(zzhcVar2.zzhi()).equals(zzhcVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzeh zzer() {
        if (this.zzyq != null) {
            return this.zzyq;
        }
        synchronized (this) {
            if (this.zzyq != null) {
                return this.zzyq;
            }
            if (this.zzyp == null) {
                this.zzyq = zzeh.zzso;
            } else {
                this.zzyq = this.zzyp.zzer();
            }
            return this.zzyq;
        }
    }

    public final int zzgw() {
        if (this.zzyq != null) {
            return this.zzyq.size();
        }
        if (this.zzyp != null) {
            return this.zzyp.zzgw();
        }
        return 0;
    }

    public final zzhc zzj(zzhc zzhcVar) {
        zzhc zzhcVar2 = this.zzyp;
        this.zzyo = null;
        this.zzyq = null;
        this.zzyp = zzhcVar;
        return zzhcVar2;
    }
}
