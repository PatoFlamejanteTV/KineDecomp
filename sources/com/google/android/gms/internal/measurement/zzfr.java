package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzfr extends zzyc<zzfr> {
    private static volatile zzfr[] zzaws;
    public Integer zzave = null;
    public zzfx zzawt = null;
    public zzfx zzawu = null;
    public Boolean zzawv = null;

    public zzfr() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public static zzfr[] zzmx() {
        if (zzaws == null) {
            synchronized (zzyg.zzcfc) {
                if (zzaws == null) {
                    zzaws = new zzfr[0];
                }
            }
        }
        return zzaws;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfr)) {
            return false;
        }
        zzfr zzfrVar = (zzfr) obj;
        Integer num = this.zzave;
        if (num == null) {
            if (zzfrVar.zzave != null) {
                return false;
            }
        } else if (!num.equals(zzfrVar.zzave)) {
            return false;
        }
        zzfx zzfxVar = this.zzawt;
        if (zzfxVar == null) {
            if (zzfrVar.zzawt != null) {
                return false;
            }
        } else if (!zzfxVar.equals(zzfrVar.zzawt)) {
            return false;
        }
        zzfx zzfxVar2 = this.zzawu;
        if (zzfxVar2 == null) {
            if (zzfrVar.zzawu != null) {
                return false;
            }
        } else if (!zzfxVar2.equals(zzfrVar.zzawu)) {
            return false;
        }
        Boolean bool = this.zzawv;
        if (bool == null) {
            if (zzfrVar.zzawv != null) {
                return false;
            }
        } else if (!bool.equals(zzfrVar.zzawv)) {
            return false;
        }
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            return this.zzcet.equals(zzfrVar.zzcet);
        }
        zzye zzyeVar2 = zzfrVar.zzcet;
        return zzyeVar2 == null || zzyeVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzfr.class.getName().hashCode() + 527) * 31;
        Integer num = this.zzave;
        int i = 0;
        int hashCode2 = hashCode + (num == null ? 0 : num.hashCode());
        zzfx zzfxVar = this.zzawt;
        int hashCode3 = (hashCode2 * 31) + (zzfxVar == null ? 0 : zzfxVar.hashCode());
        zzfx zzfxVar2 = this.zzawu;
        int hashCode4 = ((hashCode3 * 31) + (zzfxVar2 == null ? 0 : zzfxVar2.hashCode())) * 31;
        Boolean bool = this.zzawv;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        Integer num = this.zzave;
        if (num != null) {
            zzyaVar.zzd(1, num.intValue());
        }
        zzfx zzfxVar = this.zzawt;
        if (zzfxVar != null) {
            zzyaVar.zza(2, zzfxVar);
        }
        zzfx zzfxVar2 = this.zzawu;
        if (zzfxVar2 != null) {
            zzyaVar.zza(3, zzfxVar2);
        }
        Boolean bool = this.zzawv;
        if (bool != null) {
            zzyaVar.zzb(4, bool.booleanValue());
        }
        super.zza(zzyaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final int zzf() {
        int zzf = super.zzf();
        Integer num = this.zzave;
        if (num != null) {
            zzf += zzya.zzh(1, num.intValue());
        }
        zzfx zzfxVar = this.zzawt;
        if (zzfxVar != null) {
            zzf += zzya.zzb(2, zzfxVar);
        }
        zzfx zzfxVar2 = this.zzawu;
        if (zzfxVar2 != null) {
            zzf += zzya.zzb(3, zzfxVar2);
        }
        Boolean bool = this.zzawv;
        if (bool == null) {
            return zzf;
        }
        bool.booleanValue();
        return zzf + zzya.zzbd(4) + 1;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int zzuj = zzxzVar.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                this.zzave = Integer.valueOf(zzxzVar.zzvb());
            } else if (zzuj == 18) {
                if (this.zzawt == null) {
                    this.zzawt = new zzfx();
                }
                zzxzVar.zza(this.zzawt);
            } else if (zzuj == 26) {
                if (this.zzawu == null) {
                    this.zzawu = new zzfx();
                }
                zzxzVar.zza(this.zzawu);
            } else if (zzuj != 32) {
                if (!super.zza(zzxzVar, zzuj)) {
                    return this;
                }
            } else {
                this.zzawv = Boolean.valueOf(zzxzVar.zzup());
            }
        }
    }
}
