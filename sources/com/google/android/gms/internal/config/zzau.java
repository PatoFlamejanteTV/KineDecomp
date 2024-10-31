package com.google.android.gms.internal.config;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzau extends zzbb<zzau> {
    private static volatile zzau[] zzbm;
    public String zzbn = "";
    public zzas[] zzbo = zzas.zzv();

    public zzau() {
        this.zzch = null;
        this.zzcq = -1;
    }

    public static zzau[] zzw() {
        if (zzbm == null) {
            synchronized (zzbf.zzcp) {
                if (zzbm == null) {
                    zzbm = new zzau[0];
                }
            }
        }
        return zzbm;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzau)) {
            return false;
        }
        zzau zzauVar = (zzau) obj;
        String str = this.zzbn;
        if (str == null) {
            if (zzauVar.zzbn != null) {
                return false;
            }
        } else if (!str.equals(zzauVar.zzbn)) {
            return false;
        }
        if (!zzbf.equals(this.zzbo, zzauVar.zzbo)) {
            return false;
        }
        zzbd zzbdVar = this.zzch;
        if (zzbdVar != null && !zzbdVar.isEmpty()) {
            return this.zzch.equals(zzauVar.zzch);
        }
        zzbd zzbdVar2 = zzauVar.zzch;
        return zzbdVar2 == null || zzbdVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzau.class.getName().hashCode() + 527) * 31;
        String str = this.zzbn;
        int i = 0;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + zzbf.hashCode(this.zzbo)) * 31;
        zzbd zzbdVar = this.zzch;
        if (zzbdVar != null && !zzbdVar.isEmpty()) {
            i = this.zzch.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // com.google.android.gms.internal.config.zzbb, com.google.android.gms.internal.config.zzbh
    public final void zza(zzaz zzazVar) throws IOException {
        String str = this.zzbn;
        if (str != null && !str.equals("")) {
            zzazVar.zza(1, this.zzbn);
        }
        zzas[] zzasVarArr = this.zzbo;
        if (zzasVarArr != null && zzasVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzas[] zzasVarArr2 = this.zzbo;
                if (i >= zzasVarArr2.length) {
                    break;
                }
                zzas zzasVar = zzasVarArr2[i];
                if (zzasVar != null) {
                    zzazVar.zza(2, zzasVar);
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
        String str = this.zzbn;
        if (str != null && !str.equals("")) {
            zzu += zzaz.zzb(1, this.zzbn);
        }
        zzas[] zzasVarArr = this.zzbo;
        if (zzasVarArr != null && zzasVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzas[] zzasVarArr2 = this.zzbo;
                if (i >= zzasVarArr2.length) {
                    break;
                }
                zzas zzasVar = zzasVarArr2[i];
                if (zzasVar != null) {
                    zzu += zzaz.zzb(2, zzasVar);
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
                this.zzbn = zzayVar.readString();
            } else if (zzy != 18) {
                if (!super.zza(zzayVar, zzy)) {
                    return this;
                }
            } else {
                int zzb = zzbk.zzb(zzayVar, 18);
                zzas[] zzasVarArr = this.zzbo;
                int length = zzasVarArr == null ? 0 : zzasVarArr.length;
                zzas[] zzasVarArr2 = new zzas[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzbo, 0, zzasVarArr2, 0, length);
                }
                while (length < zzasVarArr2.length - 1) {
                    zzasVarArr2[length] = new zzas();
                    zzayVar.zza(zzasVarArr2[length]);
                    zzayVar.zzy();
                    length++;
                }
                zzasVarArr2[length] = new zzas();
                zzayVar.zza(zzasVarArr2[length]);
                this.zzbo = zzasVarArr2;
            }
        }
    }
}
