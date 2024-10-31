package com.google.android.gms.internal.config;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzaw extends zzbb<zzaw> {
    private static volatile zzaw[] zzbu;
    public int resourceId = 0;
    public long zzbv = 0;
    public String zzbn = "";

    public zzaw() {
        this.zzch = null;
        this.zzcq = -1;
    }

    public static zzaw[] zzx() {
        if (zzbu == null) {
            synchronized (zzbf.zzcp) {
                if (zzbu == null) {
                    zzbu = new zzaw[0];
                }
            }
        }
        return zzbu;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaw)) {
            return false;
        }
        zzaw zzawVar = (zzaw) obj;
        if (this.resourceId != zzawVar.resourceId || this.zzbv != zzawVar.zzbv) {
            return false;
        }
        String str = this.zzbn;
        if (str == null) {
            if (zzawVar.zzbn != null) {
                return false;
            }
        } else if (!str.equals(zzawVar.zzbn)) {
            return false;
        }
        zzbd zzbdVar = this.zzch;
        if (zzbdVar != null && !zzbdVar.isEmpty()) {
            return this.zzch.equals(zzawVar.zzch);
        }
        zzbd zzbdVar2 = zzawVar.zzch;
        return zzbdVar2 == null || zzbdVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (((zzaw.class.getName().hashCode() + 527) * 31) + this.resourceId) * 31;
        long j = this.zzbv;
        int i = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        String str = this.zzbn;
        int i2 = 0;
        int hashCode2 = (i + (str == null ? 0 : str.hashCode())) * 31;
        zzbd zzbdVar = this.zzch;
        if (zzbdVar != null && !zzbdVar.isEmpty()) {
            i2 = this.zzch.hashCode();
        }
        return hashCode2 + i2;
    }

    @Override // com.google.android.gms.internal.config.zzbb, com.google.android.gms.internal.config.zzbh
    public final void zza(zzaz zzazVar) throws IOException {
        int i = this.resourceId;
        if (i != 0) {
            zzazVar.zzc(1, i);
        }
        long j = this.zzbv;
        if (j != 0) {
            zzazVar.zza(2, j);
        }
        String str = this.zzbn;
        if (str != null && !str.equals("")) {
            zzazVar.zza(3, this.zzbn);
        }
        super.zza(zzazVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.config.zzbb, com.google.android.gms.internal.config.zzbh
    public final int zzu() {
        int zzu = super.zzu();
        int i = this.resourceId;
        if (i != 0) {
            zzu += zzaz.zzd(1, i);
        }
        if (this.zzbv != 0) {
            zzu += zzaz.zzl(2) + 8;
        }
        String str = this.zzbn;
        return (str == null || str.equals("")) ? zzu : zzu + zzaz.zzb(3, this.zzbn);
    }

    @Override // com.google.android.gms.internal.config.zzbh
    public final /* synthetic */ zzbh zza(zzay zzayVar) throws IOException {
        while (true) {
            int zzy = zzayVar.zzy();
            if (zzy == 0) {
                return this;
            }
            if (zzy == 8) {
                this.resourceId = zzayVar.zzz();
            } else if (zzy == 17) {
                this.zzbv = zzayVar.zzaa();
            } else if (zzy != 26) {
                if (!super.zza(zzayVar, zzy)) {
                    return this;
                }
            } else {
                this.zzbn = zzayVar.readString();
            }
        }
    }
}
