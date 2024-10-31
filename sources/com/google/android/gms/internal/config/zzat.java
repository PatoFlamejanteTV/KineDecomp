package com.google.android.gms.internal.config;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzat extends zzbb<zzat> {
    public int zzbj = 0;
    public boolean zzbk = false;
    private long zzbl = 0;

    public zzat() {
        this.zzch = null;
        this.zzcq = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzat)) {
            return false;
        }
        zzat zzatVar = (zzat) obj;
        if (this.zzbj != zzatVar.zzbj || this.zzbk != zzatVar.zzbk || this.zzbl != zzatVar.zzbl) {
            return false;
        }
        zzbd zzbdVar = this.zzch;
        if (zzbdVar != null && !zzbdVar.isEmpty()) {
            return this.zzch.equals(zzatVar.zzch);
        }
        zzbd zzbdVar2 = zzatVar.zzch;
        return zzbdVar2 == null || zzbdVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (((((zzat.class.getName().hashCode() + 527) * 31) + this.zzbj) * 31) + (this.zzbk ? 1231 : 1237)) * 31;
        long j = this.zzbl;
        int i = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        zzbd zzbdVar = this.zzch;
        return i + ((zzbdVar == null || zzbdVar.isEmpty()) ? 0 : this.zzch.hashCode());
    }

    @Override // com.google.android.gms.internal.config.zzbb, com.google.android.gms.internal.config.zzbh
    public final void zza(zzaz zzazVar) throws IOException {
        int i = this.zzbj;
        if (i != 0) {
            zzazVar.zzc(1, i);
        }
        boolean z = this.zzbk;
        if (z) {
            zzazVar.zze(2, 0);
            zzazVar.zza(z ? (byte) 1 : (byte) 0);
        }
        long j = this.zzbl;
        if (j != 0) {
            zzazVar.zza(3, j);
        }
        super.zza(zzazVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.config.zzbb, com.google.android.gms.internal.config.zzbh
    public final int zzu() {
        int zzu = super.zzu();
        int i = this.zzbj;
        if (i != 0) {
            zzu += zzaz.zzd(1, i);
        }
        if (this.zzbk) {
            zzu += zzaz.zzl(2) + 1;
        }
        return this.zzbl != 0 ? zzu + zzaz.zzl(3) + 8 : zzu;
    }

    @Override // com.google.android.gms.internal.config.zzbh
    public final /* synthetic */ zzbh zza(zzay zzayVar) throws IOException {
        while (true) {
            int zzy = zzayVar.zzy();
            if (zzy == 0) {
                return this;
            }
            if (zzy == 8) {
                this.zzbj = zzayVar.zzz();
            } else if (zzy == 16) {
                this.zzbk = zzayVar.zzz() != 0;
            } else if (zzy != 25) {
                if (!super.zza(zzayVar, zzy)) {
                    return this;
                }
            } else {
                this.zzbl = zzayVar.zzaa();
            }
        }
    }
}
