package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzk extends zzuq<zzk> {
    public zzj[] zzqj = zzj.zzz();
    public zzi zzqk = null;
    public String zzql = "";

    public zzk() {
        this.zzbhb = null;
        this.zzbhl = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzk)) {
            return false;
        }
        zzk zzkVar = (zzk) obj;
        if (!zzuu.equals(this.zzqj, zzkVar.zzqj)) {
            return false;
        }
        zzi zziVar = this.zzqk;
        if (zziVar == null) {
            if (zzkVar.zzqk != null) {
                return false;
            }
        } else if (!zziVar.equals(zzkVar.zzqk)) {
            return false;
        }
        String str = this.zzql;
        if (str == null) {
            if (zzkVar.zzql != null) {
                return false;
            }
        } else if (!str.equals(zzkVar.zzql)) {
            return false;
        }
        zzus zzusVar = this.zzbhb;
        if (zzusVar != null && !zzusVar.isEmpty()) {
            return this.zzbhb.equals(zzkVar.zzbhb);
        }
        zzus zzusVar2 = zzkVar.zzbhb;
        return zzusVar2 == null || zzusVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = ((zzk.class.getName().hashCode() + 527) * 31) + zzuu.hashCode(this.zzqj);
        zzi zziVar = this.zzqk;
        int i = 0;
        int hashCode2 = ((hashCode * 31) + (zziVar == null ? 0 : zziVar.hashCode())) * 31;
        String str = this.zzql;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        zzus zzusVar = this.zzbhb;
        if (zzusVar != null && !zzusVar.isEmpty()) {
            i = this.zzbhb.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    public final void zza(zzuo zzuoVar) throws IOException {
        zzj[] zzjVarArr = this.zzqj;
        if (zzjVarArr != null && zzjVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzj[] zzjVarArr2 = this.zzqj;
                if (i >= zzjVarArr2.length) {
                    break;
                }
                zzj zzjVar = zzjVarArr2[i];
                if (zzjVar != null) {
                    zzuoVar.zza(1, zzjVar);
                }
                i++;
            }
        }
        zzi zziVar = this.zzqk;
        if (zziVar != null) {
            zzuoVar.zza(2, zziVar);
        }
        String str = this.zzql;
        if (str != null && !str.equals("")) {
            zzuoVar.zza(3, this.zzql);
        }
        super.zza(zzuoVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    public final int zzy() {
        int zzy = super.zzy();
        zzj[] zzjVarArr = this.zzqj;
        if (zzjVarArr != null && zzjVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzj[] zzjVarArr2 = this.zzqj;
                if (i >= zzjVarArr2.length) {
                    break;
                }
                zzj zzjVar = zzjVarArr2[i];
                if (zzjVar != null) {
                    zzy += zzuo.zzb(1, zzjVar);
                }
                i++;
            }
        }
        zzi zziVar = this.zzqk;
        if (zziVar != null) {
            zzy += zzuo.zzb(2, zziVar);
        }
        String str = this.zzql;
        return (str == null || str.equals("")) ? zzy : zzy + zzuo.zzb(3, this.zzql);
    }

    @Override // com.google.android.gms.internal.gtm.zzuw
    public final /* synthetic */ zzuw zza(zzun zzunVar) throws IOException {
        while (true) {
            int zzni = zzunVar.zzni();
            if (zzni == 0) {
                return this;
            }
            if (zzni == 10) {
                int zzb = zzuz.zzb(zzunVar, 10);
                zzj[] zzjVarArr = this.zzqj;
                int length = zzjVarArr == null ? 0 : zzjVarArr.length;
                zzj[] zzjVarArr2 = new zzj[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzqj, 0, zzjVarArr2, 0, length);
                }
                while (length < zzjVarArr2.length - 1) {
                    zzjVarArr2[length] = new zzj();
                    zzunVar.zza(zzjVarArr2[length]);
                    zzunVar.zzni();
                    length++;
                }
                zzjVarArr2[length] = new zzj();
                zzunVar.zza(zzjVarArr2[length]);
                this.zzqj = zzjVarArr2;
            } else if (zzni == 18) {
                if (this.zzqk == null) {
                    this.zzqk = new zzi();
                }
                zzunVar.zza(this.zzqk);
            } else if (zzni != 26) {
                if (!super.zza(zzunVar, zzni)) {
                    return this;
                }
            } else {
                this.zzql = zzunVar.readString();
            }
        }
    }
}
