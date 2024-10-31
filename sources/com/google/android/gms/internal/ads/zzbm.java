package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbm extends zzbut<zzbm> {
    private static volatile zzbm[] zzgk;
    public Integer zzgp;
    public Integer zzgt;
    public Long zzei = null;
    public Long zzej = null;
    public Long zzgl = null;
    public Long zzgm = null;
    public Long zzgn = null;
    public Long zzgo = null;
    public Long zzgq = null;
    public Long zzgr = null;
    public Long zzgs = null;
    public Long zzgu = null;
    public Long zzgv = null;
    public Long zzgw = null;
    public Long zzgx = null;
    public Long zzgy = null;
    public Long zzgz = null;
    public Long zzha = null;
    public Long zzhb = null;
    private Long zzhc = null;
    private Long zzhd = null;

    public zzbm() {
        this.zzfwt = -1;
    }

    private final zzbm zzc(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            switch (zzaku) {
                case 0:
                    return this;
                case 8:
                    this.zzei = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 16:
                    this.zzej = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 24:
                    this.zzgl = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 32:
                    this.zzgm = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 40:
                    this.zzgn = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 48:
                    this.zzgo = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 56:
                    int position = zzbuqVar.getPosition();
                    try {
                        int zzalm = zzbuqVar.zzalm();
                        zzbk.zzd(zzalm);
                        this.zzgp = Integer.valueOf(zzalm);
                        break;
                    } catch (IllegalArgumentException unused) {
                        zzbuqVar.zzgc(position);
                        zza(zzbuqVar, zzaku);
                        break;
                    }
                case 64:
                    this.zzgq = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 72:
                    this.zzgr = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 80:
                    this.zzgs = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 88:
                    int position2 = zzbuqVar.getPosition();
                    try {
                        int zzalm2 = zzbuqVar.zzalm();
                        zzbk.zzd(zzalm2);
                        this.zzgt = Integer.valueOf(zzalm2);
                        break;
                    } catch (IllegalArgumentException unused2) {
                        zzbuqVar.zzgc(position2);
                        zza(zzbuqVar, zzaku);
                        break;
                    }
                case 96:
                    this.zzgu = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 104:
                    this.zzgv = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 112:
                    this.zzgw = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 120:
                    this.zzgx = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 128:
                    this.zzgy = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 136:
                    this.zzgz = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 144:
                    this.zzha = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 152:
                    this.zzhb = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 160:
                    this.zzhc = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 168:
                    this.zzhd = Long.valueOf(zzbuqVar.zzaln());
                    break;
                default:
                    if (!super.zza(zzbuqVar, zzaku)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static zzbm[] zzu() {
        if (zzgk == null) {
            synchronized (zzbux.zzfws) {
                if (zzgk == null) {
                    zzgk = new zzbm[0];
                }
            }
        }
        return zzgk;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        Long l = this.zzei;
        if (l != null) {
            zzburVar.zzr(1, l.longValue());
        }
        Long l2 = this.zzej;
        if (l2 != null) {
            zzburVar.zzr(2, l2.longValue());
        }
        Long l3 = this.zzgl;
        if (l3 != null) {
            zzburVar.zzr(3, l3.longValue());
        }
        Long l4 = this.zzgm;
        if (l4 != null) {
            zzburVar.zzr(4, l4.longValue());
        }
        Long l5 = this.zzgn;
        if (l5 != null) {
            zzburVar.zzr(5, l5.longValue());
        }
        Long l6 = this.zzgo;
        if (l6 != null) {
            zzburVar.zzr(6, l6.longValue());
        }
        Integer num = this.zzgp;
        if (num != null) {
            zzburVar.zzv(7, num.intValue());
        }
        Long l7 = this.zzgq;
        if (l7 != null) {
            zzburVar.zzr(8, l7.longValue());
        }
        Long l8 = this.zzgr;
        if (l8 != null) {
            zzburVar.zzr(9, l8.longValue());
        }
        Long l9 = this.zzgs;
        if (l9 != null) {
            zzburVar.zzr(10, l9.longValue());
        }
        Integer num2 = this.zzgt;
        if (num2 != null) {
            zzburVar.zzv(11, num2.intValue());
        }
        Long l10 = this.zzgu;
        if (l10 != null) {
            zzburVar.zzr(12, l10.longValue());
        }
        Long l11 = this.zzgv;
        if (l11 != null) {
            zzburVar.zzr(13, l11.longValue());
        }
        Long l12 = this.zzgw;
        if (l12 != null) {
            zzburVar.zzr(14, l12.longValue());
        }
        Long l13 = this.zzgx;
        if (l13 != null) {
            zzburVar.zzr(15, l13.longValue());
        }
        Long l14 = this.zzgy;
        if (l14 != null) {
            zzburVar.zzr(16, l14.longValue());
        }
        Long l15 = this.zzgz;
        if (l15 != null) {
            zzburVar.zzr(17, l15.longValue());
        }
        Long l16 = this.zzha;
        if (l16 != null) {
            zzburVar.zzr(18, l16.longValue());
        }
        Long l17 = this.zzhb;
        if (l17 != null) {
            zzburVar.zzr(19, l17.longValue());
        }
        Long l18 = this.zzhc;
        if (l18 != null) {
            zzburVar.zzr(20, l18.longValue());
        }
        Long l19 = this.zzhd;
        if (l19 != null) {
            zzburVar.zzr(21, l19.longValue());
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        Long l = this.zzei;
        if (l != null) {
            zzt += zzbur.zzm(1, l.longValue());
        }
        Long l2 = this.zzej;
        if (l2 != null) {
            zzt += zzbur.zzm(2, l2.longValue());
        }
        Long l3 = this.zzgl;
        if (l3 != null) {
            zzt += zzbur.zzm(3, l3.longValue());
        }
        Long l4 = this.zzgm;
        if (l4 != null) {
            zzt += zzbur.zzm(4, l4.longValue());
        }
        Long l5 = this.zzgn;
        if (l5 != null) {
            zzt += zzbur.zzm(5, l5.longValue());
        }
        Long l6 = this.zzgo;
        if (l6 != null) {
            zzt += zzbur.zzm(6, l6.longValue());
        }
        Integer num = this.zzgp;
        if (num != null) {
            zzt += zzbur.zzz(7, num.intValue());
        }
        Long l7 = this.zzgq;
        if (l7 != null) {
            zzt += zzbur.zzm(8, l7.longValue());
        }
        Long l8 = this.zzgr;
        if (l8 != null) {
            zzt += zzbur.zzm(9, l8.longValue());
        }
        Long l9 = this.zzgs;
        if (l9 != null) {
            zzt += zzbur.zzm(10, l9.longValue());
        }
        Integer num2 = this.zzgt;
        if (num2 != null) {
            zzt += zzbur.zzz(11, num2.intValue());
        }
        Long l10 = this.zzgu;
        if (l10 != null) {
            zzt += zzbur.zzm(12, l10.longValue());
        }
        Long l11 = this.zzgv;
        if (l11 != null) {
            zzt += zzbur.zzm(13, l11.longValue());
        }
        Long l12 = this.zzgw;
        if (l12 != null) {
            zzt += zzbur.zzm(14, l12.longValue());
        }
        Long l13 = this.zzgx;
        if (l13 != null) {
            zzt += zzbur.zzm(15, l13.longValue());
        }
        Long l14 = this.zzgy;
        if (l14 != null) {
            zzt += zzbur.zzm(16, l14.longValue());
        }
        Long l15 = this.zzgz;
        if (l15 != null) {
            zzt += zzbur.zzm(17, l15.longValue());
        }
        Long l16 = this.zzha;
        if (l16 != null) {
            zzt += zzbur.zzm(18, l16.longValue());
        }
        Long l17 = this.zzhb;
        if (l17 != null) {
            zzt += zzbur.zzm(19, l17.longValue());
        }
        Long l18 = this.zzhc;
        if (l18 != null) {
            zzt += zzbur.zzm(20, l18.longValue());
        }
        Long l19 = this.zzhd;
        return l19 != null ? zzt + zzbur.zzm(21, l19.longValue()) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        zzc(zzbuqVar);
        return this;
    }
}
