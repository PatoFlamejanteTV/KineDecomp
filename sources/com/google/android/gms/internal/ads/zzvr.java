package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzuw;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzvr extends zzbut<zzvr> {
    private static volatile zzvr[] zzcib;
    private zzuw.zzr zzcic = null;
    private zzuw.zzt zzcid = null;
    private zzuw.zzu zzcie = null;
    private zzuw.zzv zzcif = null;
    private zzuw.zzp zzcig = null;
    private zzuw.zzs zzcih = null;
    private zzvs zzcii = null;
    private Integer zzcij = null;
    private Integer zzcik = null;
    private zzuw.zzn zzcil = null;
    private Integer zzcim = null;
    private Integer zzcin = null;
    private Integer zzcio = null;
    private Integer zzcip = null;
    private Integer zzciq = null;
    private Long zzcir = null;

    public zzvr() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    public static zzvr[] zzpl() {
        if (zzcib == null) {
            synchronized (zzbux.zzfws) {
                if (zzcib == null) {
                    zzcib = new zzvr[0];
                }
            }
        }
        return zzcib;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        zzuw.zzr zzrVar = this.zzcic;
        if (zzrVar != null) {
            zzburVar.zze(5, zzrVar);
        }
        zzuw.zzt zztVar = this.zzcid;
        if (zztVar != null) {
            zzburVar.zze(6, zztVar);
        }
        zzuw.zzu zzuVar = this.zzcie;
        if (zzuVar != null) {
            zzburVar.zze(7, zzuVar);
        }
        zzuw.zzv zzvVar = this.zzcif;
        if (zzvVar != null) {
            zzburVar.zze(8, zzvVar);
        }
        zzuw.zzp zzpVar = this.zzcig;
        if (zzpVar != null) {
            zzburVar.zze(9, zzpVar);
        }
        zzuw.zzs zzsVar = this.zzcih;
        if (zzsVar != null) {
            zzburVar.zze(10, zzsVar);
        }
        zzvs zzvsVar = this.zzcii;
        if (zzvsVar != null) {
            zzburVar.zza(11, zzvsVar);
        }
        Integer num = this.zzcij;
        if (num != null) {
            zzburVar.zzv(12, num.intValue());
        }
        Integer num2 = this.zzcik;
        if (num2 != null) {
            zzburVar.zzv(13, num2.intValue());
        }
        zzuw.zzn zznVar = this.zzcil;
        if (zznVar != null) {
            zzburVar.zze(14, zznVar);
        }
        Integer num3 = this.zzcim;
        if (num3 != null) {
            zzburVar.zzv(15, num3.intValue());
        }
        Integer num4 = this.zzcin;
        if (num4 != null) {
            zzburVar.zzv(16, num4.intValue());
        }
        Integer num5 = this.zzcio;
        if (num5 != null) {
            zzburVar.zzv(17, num5.intValue());
        }
        Integer num6 = this.zzcip;
        if (num6 != null) {
            zzburVar.zzv(18, num6.intValue());
        }
        Integer num7 = this.zzciq;
        if (num7 != null) {
            zzburVar.zzv(19, num7.intValue());
        }
        Long l = this.zzcir;
        if (l != null) {
            zzburVar.zzj(20, l.longValue());
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        zzuw.zzr zzrVar = this.zzcic;
        if (zzrVar != null) {
            zzt += zzbqk.zzc(5, zzrVar);
        }
        zzuw.zzt zztVar = this.zzcid;
        if (zztVar != null) {
            zzt += zzbqk.zzc(6, zztVar);
        }
        zzuw.zzu zzuVar = this.zzcie;
        if (zzuVar != null) {
            zzt += zzbqk.zzc(7, zzuVar);
        }
        zzuw.zzv zzvVar = this.zzcif;
        if (zzvVar != null) {
            zzt += zzbqk.zzc(8, zzvVar);
        }
        zzuw.zzp zzpVar = this.zzcig;
        if (zzpVar != null) {
            zzt += zzbqk.zzc(9, zzpVar);
        }
        zzuw.zzs zzsVar = this.zzcih;
        if (zzsVar != null) {
            zzt += zzbqk.zzc(10, zzsVar);
        }
        zzvs zzvsVar = this.zzcii;
        if (zzvsVar != null) {
            zzt += zzbur.zzb(11, zzvsVar);
        }
        Integer num = this.zzcij;
        if (num != null) {
            zzt += zzbur.zzz(12, num.intValue());
        }
        Integer num2 = this.zzcik;
        if (num2 != null) {
            zzt += zzbur.zzz(13, num2.intValue());
        }
        zzuw.zzn zznVar = this.zzcil;
        if (zznVar != null) {
            zzt += zzbqk.zzc(14, zznVar);
        }
        Integer num3 = this.zzcim;
        if (num3 != null) {
            zzt += zzbur.zzz(15, num3.intValue());
        }
        Integer num4 = this.zzcin;
        if (num4 != null) {
            zzt += zzbur.zzz(16, num4.intValue());
        }
        Integer num5 = this.zzcio;
        if (num5 != null) {
            zzt += zzbur.zzz(17, num5.intValue());
        }
        Integer num6 = this.zzcip;
        if (num6 != null) {
            zzt += zzbur.zzz(18, num6.intValue());
        }
        Integer num7 = this.zzciq;
        if (num7 != null) {
            zzt += zzbur.zzz(19, num7.intValue());
        }
        Long l = this.zzcir;
        return l != null ? zzt + zzbur.zzn(20, l.longValue()) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            switch (zzaku) {
                case 0:
                    return this;
                case 42:
                    this.zzcic = (zzuw.zzr) zzbuqVar.zza(zzuw.zzr.zzon());
                    break;
                case 50:
                    this.zzcid = (zzuw.zzt) zzbuqVar.zza(zzuw.zzt.zzon());
                    break;
                case 58:
                    this.zzcie = (zzuw.zzu) zzbuqVar.zza(zzuw.zzu.zzon());
                    break;
                case 66:
                    this.zzcif = (zzuw.zzv) zzbuqVar.zza(zzuw.zzv.zzon());
                    break;
                case 74:
                    this.zzcig = (zzuw.zzp) zzbuqVar.zza(zzuw.zzp.zzon());
                    break;
                case 82:
                    this.zzcih = (zzuw.zzs) zzbuqVar.zza(zzuw.zzs.zzon());
                    break;
                case 90:
                    if (this.zzcii == null) {
                        this.zzcii = new zzvs();
                    }
                    zzbuqVar.zza(this.zzcii);
                    break;
                case 96:
                    this.zzcij = Integer.valueOf(zzbuqVar.zzalm());
                    break;
                case 104:
                    this.zzcik = Integer.valueOf(zzbuqVar.zzalm());
                    break;
                case 114:
                    this.zzcil = (zzuw.zzn) zzbuqVar.zza(zzuw.zzn.zzon());
                    break;
                case 120:
                    this.zzcim = Integer.valueOf(zzbuqVar.zzalm());
                    break;
                case 128:
                    this.zzcin = Integer.valueOf(zzbuqVar.zzalm());
                    break;
                case 136:
                    this.zzcio = Integer.valueOf(zzbuqVar.zzalm());
                    break;
                case 144:
                    this.zzcip = Integer.valueOf(zzbuqVar.zzalm());
                    break;
                case 152:
                    this.zzciq = Integer.valueOf(zzbuqVar.zzalm());
                    break;
                case 160:
                    this.zzcir = Long.valueOf(zzbuqVar.zzaln());
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
