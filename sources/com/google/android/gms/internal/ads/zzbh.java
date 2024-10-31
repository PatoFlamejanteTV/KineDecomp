package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbh extends zzbut<zzbh> {
    public String zzdh = null;
    public Long zzdi = null;
    private String stackTrace = null;
    private String zzdj = null;
    private String zzdk = null;
    private Long zzdl = null;
    private Long zzdm = null;
    private String zzdn = null;
    private Long zzdo = null;
    private String zzdp = null;

    public zzbh() {
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        String str = this.zzdh;
        if (str != null) {
            zzburVar.zzf(1, str);
        }
        Long l = this.zzdi;
        if (l != null) {
            zzburVar.zzr(2, l.longValue());
        }
        String str2 = this.stackTrace;
        if (str2 != null) {
            zzburVar.zzf(3, str2);
        }
        String str3 = this.zzdj;
        if (str3 != null) {
            zzburVar.zzf(4, str3);
        }
        String str4 = this.zzdk;
        if (str4 != null) {
            zzburVar.zzf(5, str4);
        }
        Long l2 = this.zzdl;
        if (l2 != null) {
            zzburVar.zzr(6, l2.longValue());
        }
        Long l3 = this.zzdm;
        if (l3 != null) {
            zzburVar.zzr(7, l3.longValue());
        }
        String str5 = this.zzdn;
        if (str5 != null) {
            zzburVar.zzf(8, str5);
        }
        Long l4 = this.zzdo;
        if (l4 != null) {
            zzburVar.zzr(9, l4.longValue());
        }
        String str6 = this.zzdp;
        if (str6 != null) {
            zzburVar.zzf(10, str6);
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        String str = this.zzdh;
        if (str != null) {
            zzt += zzbur.zzg(1, str);
        }
        Long l = this.zzdi;
        if (l != null) {
            zzt += zzbur.zzm(2, l.longValue());
        }
        String str2 = this.stackTrace;
        if (str2 != null) {
            zzt += zzbur.zzg(3, str2);
        }
        String str3 = this.zzdj;
        if (str3 != null) {
            zzt += zzbur.zzg(4, str3);
        }
        String str4 = this.zzdk;
        if (str4 != null) {
            zzt += zzbur.zzg(5, str4);
        }
        Long l2 = this.zzdl;
        if (l2 != null) {
            zzt += zzbur.zzm(6, l2.longValue());
        }
        Long l3 = this.zzdm;
        if (l3 != null) {
            zzt += zzbur.zzm(7, l3.longValue());
        }
        String str5 = this.zzdn;
        if (str5 != null) {
            zzt += zzbur.zzg(8, str5);
        }
        Long l4 = this.zzdo;
        if (l4 != null) {
            zzt += zzbur.zzm(9, l4.longValue());
        }
        String str6 = this.zzdp;
        return str6 != null ? zzt + zzbur.zzg(10, str6) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            switch (zzaku) {
                case 0:
                    return this;
                case 10:
                    this.zzdh = zzbuqVar.readString();
                    break;
                case 16:
                    this.zzdi = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 26:
                    this.stackTrace = zzbuqVar.readString();
                    break;
                case 34:
                    this.zzdj = zzbuqVar.readString();
                    break;
                case 42:
                    this.zzdk = zzbuqVar.readString();
                    break;
                case 48:
                    this.zzdl = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 56:
                    this.zzdm = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 66:
                    this.zzdn = zzbuqVar.readString();
                    break;
                case 72:
                    this.zzdo = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 82:
                    this.zzdp = zzbuqVar.readString();
                    break;
                default:
                    if (!super.zza(zzbuqVar, zzaku)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
