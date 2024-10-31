package com.google.android.gms.internal.config;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzav extends zzbb<zzav> {
    public zzar zzbp = null;
    public zzar zzbq = null;
    public zzar zzbr = null;
    public zzat zzbs = null;
    public zzaw[] zzbt = zzaw.zzx();

    public zzav() {
        this.zzch = null;
        this.zzcq = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzav)) {
            return false;
        }
        zzav zzavVar = (zzav) obj;
        zzar zzarVar = this.zzbp;
        if (zzarVar == null) {
            if (zzavVar.zzbp != null) {
                return false;
            }
        } else if (!zzarVar.equals(zzavVar.zzbp)) {
            return false;
        }
        zzar zzarVar2 = this.zzbq;
        if (zzarVar2 == null) {
            if (zzavVar.zzbq != null) {
                return false;
            }
        } else if (!zzarVar2.equals(zzavVar.zzbq)) {
            return false;
        }
        zzar zzarVar3 = this.zzbr;
        if (zzarVar3 == null) {
            if (zzavVar.zzbr != null) {
                return false;
            }
        } else if (!zzarVar3.equals(zzavVar.zzbr)) {
            return false;
        }
        zzat zzatVar = this.zzbs;
        if (zzatVar == null) {
            if (zzavVar.zzbs != null) {
                return false;
            }
        } else if (!zzatVar.equals(zzavVar.zzbs)) {
            return false;
        }
        if (!zzbf.equals(this.zzbt, zzavVar.zzbt)) {
            return false;
        }
        zzbd zzbdVar = this.zzch;
        if (zzbdVar != null && !zzbdVar.isEmpty()) {
            return this.zzch.equals(zzavVar.zzch);
        }
        zzbd zzbdVar2 = zzavVar.zzch;
        return zzbdVar2 == null || zzbdVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = zzav.class.getName().hashCode() + 527;
        zzar zzarVar = this.zzbp;
        int i = 0;
        int hashCode2 = (hashCode * 31) + (zzarVar == null ? 0 : zzarVar.hashCode());
        zzar zzarVar2 = this.zzbq;
        int hashCode3 = (hashCode2 * 31) + (zzarVar2 == null ? 0 : zzarVar2.hashCode());
        zzar zzarVar3 = this.zzbr;
        int hashCode4 = (hashCode3 * 31) + (zzarVar3 == null ? 0 : zzarVar3.hashCode());
        zzat zzatVar = this.zzbs;
        int hashCode5 = ((((hashCode4 * 31) + (zzatVar == null ? 0 : zzatVar.hashCode())) * 31) + zzbf.hashCode(this.zzbt)) * 31;
        zzbd zzbdVar = this.zzch;
        if (zzbdVar != null && !zzbdVar.isEmpty()) {
            i = this.zzch.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // com.google.android.gms.internal.config.zzbb, com.google.android.gms.internal.config.zzbh
    public final void zza(zzaz zzazVar) throws IOException {
        zzar zzarVar = this.zzbp;
        if (zzarVar != null) {
            zzazVar.zza(1, zzarVar);
        }
        zzar zzarVar2 = this.zzbq;
        if (zzarVar2 != null) {
            zzazVar.zza(2, zzarVar2);
        }
        zzar zzarVar3 = this.zzbr;
        if (zzarVar3 != null) {
            zzazVar.zza(3, zzarVar3);
        }
        zzat zzatVar = this.zzbs;
        if (zzatVar != null) {
            zzazVar.zza(4, zzatVar);
        }
        zzaw[] zzawVarArr = this.zzbt;
        if (zzawVarArr != null && zzawVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzaw[] zzawVarArr2 = this.zzbt;
                if (i >= zzawVarArr2.length) {
                    break;
                }
                zzaw zzawVar = zzawVarArr2[i];
                if (zzawVar != null) {
                    zzazVar.zza(5, zzawVar);
                }
                i++;
            }
        }
        super.zza(zzazVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.config.zzbb, com.google.android.gms.internal.config.zzbh
    public final int zzu() {
        int zzu = super.zzu();
        zzar zzarVar = this.zzbp;
        if (zzarVar != null) {
            zzu += zzaz.zzb(1, zzarVar);
        }
        zzar zzarVar2 = this.zzbq;
        if (zzarVar2 != null) {
            zzu += zzaz.zzb(2, zzarVar2);
        }
        zzar zzarVar3 = this.zzbr;
        if (zzarVar3 != null) {
            zzu += zzaz.zzb(3, zzarVar3);
        }
        zzat zzatVar = this.zzbs;
        if (zzatVar != null) {
            zzu += zzaz.zzb(4, zzatVar);
        }
        zzaw[] zzawVarArr = this.zzbt;
        if (zzawVarArr != null && zzawVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzaw[] zzawVarArr2 = this.zzbt;
                if (i >= zzawVarArr2.length) {
                    break;
                }
                zzaw zzawVar = zzawVarArr2[i];
                if (zzawVar != null) {
                    zzu += zzaz.zzb(5, zzawVar);
                }
                i++;
            }
        }
        return zzu;
    }

    @Override // com.google.android.gms.internal.config.zzbh
    public final /* synthetic */ zzbh zza(zzay zzayVar) throws IOException {
        while (true) {
            int zzy = zzayVar.zzy();
            if (zzy == 0) {
                return this;
            }
            if (zzy == 10) {
                if (this.zzbp == null) {
                    this.zzbp = new zzar();
                }
                zzayVar.zza(this.zzbp);
            } else if (zzy == 18) {
                if (this.zzbq == null) {
                    this.zzbq = new zzar();
                }
                zzayVar.zza(this.zzbq);
            } else if (zzy == 26) {
                if (this.zzbr == null) {
                    this.zzbr = new zzar();
                }
                zzayVar.zza(this.zzbr);
            } else if (zzy == 34) {
                if (this.zzbs == null) {
                    this.zzbs = new zzat();
                }
                zzayVar.zza(this.zzbs);
            } else if (zzy != 42) {
                if (!super.zza(zzayVar, zzy)) {
                    return this;
                }
            } else {
                int zzb = zzbk.zzb(zzayVar, 42);
                zzaw[] zzawVarArr = this.zzbt;
                int length = zzawVarArr == null ? 0 : zzawVarArr.length;
                zzaw[] zzawVarArr2 = new zzaw[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzbt, 0, zzawVarArr2, 0, length);
                }
                while (length < zzawVarArr2.length - 1) {
                    zzawVarArr2[length] = new zzaw();
                    zzayVar.zza(zzawVarArr2[length]);
                    zzayVar.zzy();
                    length++;
                }
                zzawVarArr2[length] = new zzaw();
                zzayVar.zza(zzawVarArr2[length]);
                this.zzbt = zzawVarArr2;
            }
        }
    }
}
