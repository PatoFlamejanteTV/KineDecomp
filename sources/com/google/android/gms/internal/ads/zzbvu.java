package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbvu extends zzbut<zzbvu> {
    public String zzgcc = null;
    public Long zzgcd = null;
    public Boolean zzgce = null;

    public zzbvu() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        String str = this.zzgcc;
        if (str != null) {
            zzburVar.zzf(1, str);
        }
        Long l = this.zzgcd;
        if (l != null) {
            zzburVar.zzr(2, l.longValue());
        }
        Boolean bool = this.zzgce;
        if (bool != null) {
            zzburVar.zzj(3, bool.booleanValue());
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        String str = this.zzgcc;
        if (str != null) {
            zzt += zzbur.zzg(1, str);
        }
        Long l = this.zzgcd;
        if (l != null) {
            zzt += zzbur.zzm(2, l.longValue());
        }
        Boolean bool = this.zzgce;
        if (bool == null) {
            return zzt;
        }
        bool.booleanValue();
        return zzt + zzbur.zzfd(3) + 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 10) {
                this.zzgcc = zzbuqVar.readString();
            } else if (zzaku == 16) {
                this.zzgcd = Long.valueOf(zzbuqVar.zzakw());
            } else if (zzaku != 24) {
                if (!super.zza(zzbuqVar, zzaku)) {
                    return this;
                }
            } else {
                this.zzgce = Boolean.valueOf(zzbuqVar.zzala());
            }
        }
    }
}
