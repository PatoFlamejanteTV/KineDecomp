package com.google.android.gms.internal.config;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzar extends zzbb<zzar> {
    public zzau[] zzbe = zzau.zzw();
    public long timestamp = 0;
    public byte[][] zzbf = zzbk.zzdc;

    public zzar() {
        this.zzch = null;
        this.zzcq = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzar)) {
            return false;
        }
        zzar zzarVar = (zzar) obj;
        if (!zzbf.equals(this.zzbe, zzarVar.zzbe) || this.timestamp != zzarVar.timestamp || !zzbf.zza(this.zzbf, zzarVar.zzbf)) {
            return false;
        }
        zzbd zzbdVar = this.zzch;
        if (zzbdVar != null && !zzbdVar.isEmpty()) {
            return this.zzch.equals(zzarVar.zzch);
        }
        zzbd zzbdVar2 = zzarVar.zzch;
        return zzbdVar2 == null || zzbdVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (((zzar.class.getName().hashCode() + 527) * 31) + zzbf.hashCode(this.zzbe)) * 31;
        long j = this.timestamp;
        int zza = (((hashCode + ((int) (j ^ (j >>> 32)))) * 31) + zzbf.zza(this.zzbf)) * 31;
        zzbd zzbdVar = this.zzch;
        return zza + ((zzbdVar == null || zzbdVar.isEmpty()) ? 0 : this.zzch.hashCode());
    }

    @Override // com.google.android.gms.internal.config.zzbb, com.google.android.gms.internal.config.zzbh
    public final void zza(zzaz zzazVar) throws IOException {
        zzau[] zzauVarArr = this.zzbe;
        int i = 0;
        if (zzauVarArr != null && zzauVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzau[] zzauVarArr2 = this.zzbe;
                if (i2 >= zzauVarArr2.length) {
                    break;
                }
                zzau zzauVar = zzauVarArr2[i2];
                if (zzauVar != null) {
                    zzazVar.zza(1, zzauVar);
                }
                i2++;
            }
        }
        long j = this.timestamp;
        if (j != 0) {
            zzazVar.zza(2, j);
        }
        byte[][] bArr = this.zzbf;
        if (bArr != null && bArr.length > 0) {
            while (true) {
                byte[][] bArr2 = this.zzbf;
                if (i >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i];
                if (bArr3 != null) {
                    zzazVar.zza(3, bArr3);
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
        zzau[] zzauVarArr = this.zzbe;
        int i = 0;
        if (zzauVarArr != null && zzauVarArr.length > 0) {
            int i2 = zzu;
            int i3 = 0;
            while (true) {
                zzau[] zzauVarArr2 = this.zzbe;
                if (i3 >= zzauVarArr2.length) {
                    break;
                }
                zzau zzauVar = zzauVarArr2[i3];
                if (zzauVar != null) {
                    i2 += zzaz.zzb(1, zzauVar);
                }
                i3++;
            }
            zzu = i2;
        }
        if (this.timestamp != 0) {
            zzu += zzaz.zzl(2) + 8;
        }
        byte[][] bArr = this.zzbf;
        if (bArr == null || bArr.length <= 0) {
            return zzu;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            byte[][] bArr2 = this.zzbf;
            if (i >= bArr2.length) {
                return zzu + i4 + (i5 * 1);
            }
            byte[] bArr3 = bArr2[i];
            if (bArr3 != null) {
                i5++;
                i4 += zzaz.zzb(bArr3);
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.config.zzbh
    public final /* synthetic */ zzbh zza(zzay zzayVar) throws IOException {
        while (true) {
            int zzy = zzayVar.zzy();
            if (zzy == 0) {
                return this;
            }
            if (zzy == 10) {
                int zzb = zzbk.zzb(zzayVar, 10);
                zzau[] zzauVarArr = this.zzbe;
                int length = zzauVarArr == null ? 0 : zzauVarArr.length;
                zzau[] zzauVarArr2 = new zzau[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzbe, 0, zzauVarArr2, 0, length);
                }
                while (length < zzauVarArr2.length - 1) {
                    zzauVarArr2[length] = new zzau();
                    zzayVar.zza(zzauVarArr2[length]);
                    zzayVar.zzy();
                    length++;
                }
                zzauVarArr2[length] = new zzau();
                zzayVar.zza(zzauVarArr2[length]);
                this.zzbe = zzauVarArr2;
            } else if (zzy == 17) {
                this.timestamp = zzayVar.zzaa();
            } else if (zzy != 26) {
                if (!super.zza(zzayVar, zzy)) {
                    return this;
                }
            } else {
                int zzb2 = zzbk.zzb(zzayVar, 26);
                byte[][] bArr = this.zzbf;
                int length2 = bArr == null ? 0 : bArr.length;
                byte[][] bArr2 = new byte[zzb2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.zzbf, 0, bArr2, 0, length2);
                }
                while (length2 < bArr2.length - 1) {
                    bArr2[length2] = zzayVar.readBytes();
                    zzayVar.zzy();
                    length2++;
                }
                bArr2[length2] = zzayVar.readBytes();
                this.zzbf = bArr2;
            }
        }
    }
}
