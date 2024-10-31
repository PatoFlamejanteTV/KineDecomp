package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbj extends zzbut<zzbj> {
    public String zzdq;
    private String zzdr;
    private String zzds;
    private String zzdt;
    private String zzdu;
    public String zzdv;

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        String str = this.zzdq;
        if (str != null) {
            zzburVar.zzf(1, str);
        }
        String str2 = this.zzdr;
        if (str2 != null) {
            zzburVar.zzf(2, str2);
        }
        String str3 = this.zzds;
        if (str3 != null) {
            zzburVar.zzf(3, str3);
        }
        String str4 = this.zzdt;
        if (str4 != null) {
            zzburVar.zzf(4, str4);
        }
        String str5 = this.zzdu;
        if (str5 != null) {
            zzburVar.zzf(5, str5);
        }
        String str6 = this.zzdv;
        if (str6 != null) {
            zzburVar.zzf(6, str6);
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        String str = this.zzdq;
        if (str != null) {
            zzt += zzbur.zzg(1, str);
        }
        String str2 = this.zzdr;
        if (str2 != null) {
            zzt += zzbur.zzg(2, str2);
        }
        String str3 = this.zzds;
        if (str3 != null) {
            zzt += zzbur.zzg(3, str3);
        }
        String str4 = this.zzdt;
        if (str4 != null) {
            zzt += zzbur.zzg(4, str4);
        }
        String str5 = this.zzdu;
        if (str5 != null) {
            zzt += zzbur.zzg(5, str5);
        }
        String str6 = this.zzdv;
        return str6 != null ? zzt + zzbur.zzg(6, str6) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 10) {
                this.zzdq = zzbuqVar.readString();
            } else if (zzaku == 18) {
                this.zzdr = zzbuqVar.readString();
            } else if (zzaku == 26) {
                this.zzds = zzbuqVar.readString();
            } else if (zzaku == 34) {
                this.zzdt = zzbuqVar.readString();
            } else if (zzaku == 42) {
                this.zzdu = zzbuqVar.readString();
            } else if (zzaku != 50) {
                if (!super.zza(zzbuqVar, zzaku)) {
                    return this;
                }
            } else {
                this.zzdv = zzbuqVar.readString();
            }
        }
    }
}
