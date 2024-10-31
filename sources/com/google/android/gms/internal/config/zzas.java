package com.google.android.gms.internal.config;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzas extends zzbb<zzas> {
    private static volatile zzas[] zzbg;
    public String zzbh = "";
    public byte[] zzbi = zzbk.zzdd;

    public zzas() {
        this.zzch = null;
        this.zzcq = -1;
    }

    public static zzas[] zzv() {
        if (zzbg == null) {
            synchronized (zzbf.zzcp) {
                if (zzbg == null) {
                    zzbg = new zzas[0];
                }
            }
        }
        return zzbg;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzas)) {
            return false;
        }
        zzas zzasVar = (zzas) obj;
        String str = this.zzbh;
        if (str == null) {
            if (zzasVar.zzbh != null) {
                return false;
            }
        } else if (!str.equals(zzasVar.zzbh)) {
            return false;
        }
        if (!Arrays.equals(this.zzbi, zzasVar.zzbi)) {
            return false;
        }
        zzbd zzbdVar = this.zzch;
        if (zzbdVar != null && !zzbdVar.isEmpty()) {
            return this.zzch.equals(zzasVar.zzch);
        }
        zzbd zzbdVar2 = zzasVar.zzch;
        return zzbdVar2 == null || zzbdVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzas.class.getName().hashCode() + 527) * 31;
        String str = this.zzbh;
        int i = 0;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Arrays.hashCode(this.zzbi)) * 31;
        zzbd zzbdVar = this.zzch;
        if (zzbdVar != null && !zzbdVar.isEmpty()) {
            i = this.zzch.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // com.google.android.gms.internal.config.zzbb, com.google.android.gms.internal.config.zzbh
    public final void zza(zzaz zzazVar) throws IOException {
        String str = this.zzbh;
        if (str != null && !str.equals("")) {
            zzazVar.zza(1, this.zzbh);
        }
        if (!Arrays.equals(this.zzbi, zzbk.zzdd)) {
            zzazVar.zza(2, this.zzbi);
        }
        super.zza(zzazVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.config.zzbb, com.google.android.gms.internal.config.zzbh
    public final int zzu() {
        int zzu = super.zzu();
        String str = this.zzbh;
        if (str != null && !str.equals("")) {
            zzu += zzaz.zzb(1, this.zzbh);
        }
        if (Arrays.equals(this.zzbi, zzbk.zzdd)) {
            return zzu;
        }
        return zzu + zzaz.zzl(2) + zzaz.zzb(this.zzbi);
    }

    @Override // com.google.android.gms.internal.config.zzbh
    public final /* synthetic */ zzbh zza(zzay zzayVar) throws IOException {
        while (true) {
            int zzy = zzayVar.zzy();
            if (zzy == 0) {
                return this;
            }
            if (zzy == 10) {
                this.zzbh = zzayVar.readString();
            } else if (zzy != 18) {
                if (!super.zza(zzayVar, zzy)) {
                    return this;
                }
            } else {
                this.zzbi = zzayVar.readBytes();
            }
        }
    }
}
