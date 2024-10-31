package com.google.android.gms.internal.ads;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.qq.e.comm.constants.ErrorCode;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbl extends zzbut<zzbl> {
    public Integer zzff;
    public Integer zzfg;
    public Integer zzfm;
    private Integer zzfy;
    private Integer zzfz;
    private Integer zzga;
    public Integer zzgf;
    public String zzdw = null;
    public String zzdp = null;
    public Long zzdx = null;
    private Long zzdy = null;
    public Long zzdz = null;
    public Long zzea = null;
    private Long zzeb = null;
    private Long zzec = null;
    private Long zzed = null;
    private Long zzee = null;
    private Long zzef = null;
    public Long zzeg = null;
    private String zzeh = null;
    public Long zzei = null;
    public Long zzej = null;
    public Long zzek = null;
    public Long zzel = null;
    private Long zzem = null;
    private Long zzen = null;
    public Long zzeo = null;
    public Long zzep = null;
    public Long zzeq = null;
    public String zzdq = null;
    public String zzer = null;
    public Long zzes = null;
    public Long zzet = null;
    public Long zzeu = null;
    public String zzds = null;
    public Long zzev = null;
    public Long zzew = null;
    public Long zzex = null;
    private zzbo zzey = null;
    public Long zzez = null;
    public Long zzfa = null;
    public Long zzfb = null;
    public Long zzfc = null;
    public Long zzfd = null;
    public Long zzfe = null;
    public String zzdt = null;
    public String zzdu = null;
    public Long zzfh = null;
    public Long zzfi = null;
    public Long zzfj = null;
    private Long zzfk = null;
    private Long zzfl = null;
    public zzbm zzfn = null;
    public zzbm[] zzfo = zzbm.zzu();
    public zzbn zzfp = null;
    private Long zzfq = null;
    public Long zzfr = null;
    public Long zzfs = null;
    public Long zzft = null;
    public Long zzfu = null;
    public Long zzfv = null;
    public String zzfw = null;
    private Long zzfx = null;
    public zzbr zzgb = null;
    private Long zzgc = null;
    private Long zzgd = null;
    public String zzge = null;
    public Boolean zzgg = null;
    private String zzgh = null;
    public Long zzgi = null;
    public zzbq zzgj = null;

    public zzbl() {
        this.zzfwt = -1;
    }

    private final zzbl zzb(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            switch (zzaku) {
                case 0:
                    return this;
                case 10:
                    this.zzdw = zzbuqVar.readString();
                    break;
                case 18:
                    this.zzdp = zzbuqVar.readString();
                    break;
                case 24:
                    this.zzdx = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 32:
                    this.zzdy = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 40:
                    this.zzdz = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 48:
                    this.zzea = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 56:
                    this.zzeb = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 64:
                    this.zzec = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 72:
                    this.zzed = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 80:
                    this.zzee = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 88:
                    this.zzef = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 96:
                    this.zzeg = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 106:
                    this.zzeh = zzbuqVar.readString();
                    break;
                case 112:
                    this.zzei = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 120:
                    this.zzej = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 128:
                    this.zzek = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 136:
                    this.zzel = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 144:
                    this.zzem = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 152:
                    this.zzen = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 160:
                    this.zzeo = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 168:
                    this.zzgd = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 176:
                    this.zzep = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 184:
                    this.zzeq = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 194:
                    this.zzge = zzbuqVar.readString();
                    break;
                case 200:
                    this.zzgi = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 208:
                    int position = zzbuqVar.getPosition();
                    try {
                        int zzalm = zzbuqVar.zzalm();
                        if (zzalm >= 0 && zzalm <= 6) {
                            this.zzgf = Integer.valueOf(zzalm);
                            break;
                        } else {
                            StringBuilder sb = new StringBuilder(44);
                            sb.append(zzalm);
                            sb.append(" is not a valid enum DeviceIdType");
                            throw new IllegalArgumentException(sb.toString());
                            break;
                        }
                    } catch (IllegalArgumentException unused) {
                        zzbuqVar.zzgc(position);
                        zza(zzbuqVar, zzaku);
                        break;
                    }
                case 218:
                    this.zzdq = zzbuqVar.readString();
                    break;
                case 224:
                    this.zzgg = Boolean.valueOf(zzbuqVar.zzala());
                    break;
                case 234:
                    this.zzer = zzbuqVar.readString();
                    break;
                case 242:
                    this.zzgh = zzbuqVar.readString();
                    break;
                case 248:
                    this.zzes = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 256:
                    this.zzet = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 264:
                    this.zzeu = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 274:
                    this.zzds = zzbuqVar.readString();
                    break;
                case 280:
                    this.zzev = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 288:
                    this.zzew = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 296:
                    this.zzex = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 306:
                    if (this.zzey == null) {
                        this.zzey = new zzbo();
                    }
                    zzbuqVar.zza(this.zzey);
                    break;
                case 312:
                    this.zzez = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case ModuleDescriptor.MODULE_VERSION /* 320 */:
                    this.zzfa = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 328:
                    this.zzfb = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 336:
                    this.zzfc = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 346:
                    int zzb = zzbvc.zzb(zzbuqVar, 346);
                    zzbm[] zzbmVarArr = this.zzfo;
                    int length = zzbmVarArr == null ? 0 : zzbmVarArr.length;
                    zzbm[] zzbmVarArr2 = new zzbm[zzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzfo, 0, zzbmVarArr2, 0, length);
                    }
                    while (length < zzbmVarArr2.length - 1) {
                        zzbmVarArr2[length] = new zzbm();
                        zzbuqVar.zza(zzbmVarArr2[length]);
                        zzbuqVar.zzaku();
                        length++;
                    }
                    zzbmVarArr2[length] = new zzbm();
                    zzbuqVar.zza(zzbmVarArr2[length]);
                    this.zzfo = zzbmVarArr2;
                    break;
                case 352:
                    this.zzfd = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 360:
                    this.zzfe = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 370:
                    this.zzdt = zzbuqVar.readString();
                    break;
                case 378:
                    this.zzdu = zzbuqVar.readString();
                    break;
                case 384:
                    int position2 = zzbuqVar.getPosition();
                    try {
                        int zzalm2 = zzbuqVar.zzalm();
                        zzbk.zzd(zzalm2);
                        this.zzff = Integer.valueOf(zzalm2);
                        break;
                    } catch (IllegalArgumentException unused2) {
                        zzbuqVar.zzgc(position2);
                        zza(zzbuqVar, zzaku);
                        break;
                    }
                case 392:
                    int position3 = zzbuqVar.getPosition();
                    try {
                        int zzalm3 = zzbuqVar.zzalm();
                        zzbk.zzd(zzalm3);
                        this.zzfg = Integer.valueOf(zzalm3);
                        break;
                    } catch (IllegalArgumentException unused3) {
                        zzbuqVar.zzgc(position3);
                        zza(zzbuqVar, zzaku);
                        break;
                    }
                case ErrorCode.NetWorkError.RETRY_TIME_NATIVE_ERROR /* 402 */:
                    if (this.zzfn == null) {
                        this.zzfn = new zzbm();
                    }
                    zzbuqVar.zza(this.zzfn);
                    break;
                case 408:
                    this.zzfh = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 416:
                    this.zzfi = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 424:
                    this.zzfj = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 432:
                    this.zzfk = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 440:
                    this.zzfl = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 448:
                    int position4 = zzbuqVar.getPosition();
                    try {
                        int zzalm4 = zzbuqVar.zzalm();
                        zzbk.zzd(zzalm4);
                        this.zzfm = Integer.valueOf(zzalm4);
                        break;
                    } catch (IllegalArgumentException unused4) {
                        zzbuqVar.zzgc(position4);
                        zza(zzbuqVar, zzaku);
                        break;
                    }
                case FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED /* 458 */:
                    if (this.zzfp == null) {
                        this.zzfp = new zzbn();
                    }
                    zzbuqVar.zza(this.zzfp);
                    break;
                case 464:
                    this.zzfq = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 472:
                    this.zzfr = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 480:
                    this.zzfs = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 488:
                    this.zzft = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 496:
                    this.zzfu = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 504:
                    this.zzfv = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 512:
                    this.zzfx = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 520:
                    int position5 = zzbuqVar.getPosition();
                    try {
                        int zzalm5 = zzbuqVar.zzalm();
                        zzbk.zzf(zzalm5);
                        this.zzfy = Integer.valueOf(zzalm5);
                        break;
                    } catch (IllegalArgumentException unused5) {
                        zzbuqVar.zzgc(position5);
                        zza(zzbuqVar, zzaku);
                        break;
                    }
                case 528:
                    int position6 = zzbuqVar.getPosition();
                    try {
                        int zzalm6 = zzbuqVar.zzalm();
                        zzbk.zze(zzalm6);
                        this.zzfz = Integer.valueOf(zzalm6);
                        break;
                    } catch (IllegalArgumentException unused6) {
                        zzbuqVar.zzgc(position6);
                        zza(zzbuqVar, zzaku);
                        break;
                    }
                case 538:
                    this.zzfw = zzbuqVar.readString();
                    break;
                case 544:
                    int position7 = zzbuqVar.getPosition();
                    try {
                        int zzalm7 = zzbuqVar.zzalm();
                        if (zzalm7 >= 0 && zzalm7 <= 3) {
                            this.zzga = Integer.valueOf(zzalm7);
                            break;
                        } else {
                            StringBuilder sb2 = new StringBuilder(45);
                            sb2.append(zzalm7);
                            sb2.append(" is not a valid enum DebuggerState");
                            throw new IllegalArgumentException(sb2.toString());
                            break;
                        }
                    } catch (IllegalArgumentException unused7) {
                        zzbuqVar.zzgc(position7);
                        zza(zzbuqVar, zzaku);
                        break;
                    }
                case 554:
                    if (this.zzgb == null) {
                        this.zzgb = new zzbr();
                    }
                    zzbuqVar.zza(this.zzgb);
                    break;
                case 560:
                    this.zzgc = Long.valueOf(zzbuqVar.zzaln());
                    break;
                case 1610:
                    if (this.zzgj == null) {
                        this.zzgj = new zzbq();
                    }
                    zzbuqVar.zza(this.zzgj);
                    break;
                default:
                    if (!super.zza(zzbuqVar, zzaku)) {
                        return this;
                    }
                    break;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        String str = this.zzdw;
        if (str != null) {
            zzburVar.zzf(1, str);
        }
        String str2 = this.zzdp;
        if (str2 != null) {
            zzburVar.zzf(2, str2);
        }
        Long l = this.zzdx;
        if (l != null) {
            zzburVar.zzr(3, l.longValue());
        }
        Long l2 = this.zzdy;
        if (l2 != null) {
            zzburVar.zzr(4, l2.longValue());
        }
        Long l3 = this.zzdz;
        if (l3 != null) {
            zzburVar.zzr(5, l3.longValue());
        }
        Long l4 = this.zzea;
        if (l4 != null) {
            zzburVar.zzr(6, l4.longValue());
        }
        Long l5 = this.zzeb;
        if (l5 != null) {
            zzburVar.zzr(7, l5.longValue());
        }
        Long l6 = this.zzec;
        if (l6 != null) {
            zzburVar.zzr(8, l6.longValue());
        }
        Long l7 = this.zzed;
        if (l7 != null) {
            zzburVar.zzr(9, l7.longValue());
        }
        Long l8 = this.zzee;
        if (l8 != null) {
            zzburVar.zzr(10, l8.longValue());
        }
        Long l9 = this.zzef;
        if (l9 != null) {
            zzburVar.zzr(11, l9.longValue());
        }
        Long l10 = this.zzeg;
        if (l10 != null) {
            zzburVar.zzr(12, l10.longValue());
        }
        String str3 = this.zzeh;
        if (str3 != null) {
            zzburVar.zzf(13, str3);
        }
        Long l11 = this.zzei;
        if (l11 != null) {
            zzburVar.zzr(14, l11.longValue());
        }
        Long l12 = this.zzej;
        if (l12 != null) {
            zzburVar.zzr(15, l12.longValue());
        }
        Long l13 = this.zzek;
        if (l13 != null) {
            zzburVar.zzr(16, l13.longValue());
        }
        Long l14 = this.zzel;
        if (l14 != null) {
            zzburVar.zzr(17, l14.longValue());
        }
        Long l15 = this.zzem;
        if (l15 != null) {
            zzburVar.zzr(18, l15.longValue());
        }
        Long l16 = this.zzen;
        if (l16 != null) {
            zzburVar.zzr(19, l16.longValue());
        }
        Long l17 = this.zzeo;
        if (l17 != null) {
            zzburVar.zzr(20, l17.longValue());
        }
        Long l18 = this.zzgd;
        if (l18 != null) {
            zzburVar.zzr(21, l18.longValue());
        }
        Long l19 = this.zzep;
        if (l19 != null) {
            zzburVar.zzr(22, l19.longValue());
        }
        Long l20 = this.zzeq;
        if (l20 != null) {
            zzburVar.zzr(23, l20.longValue());
        }
        String str4 = this.zzge;
        if (str4 != null) {
            zzburVar.zzf(24, str4);
        }
        Long l21 = this.zzgi;
        if (l21 != null) {
            zzburVar.zzr(25, l21.longValue());
        }
        Integer num = this.zzgf;
        if (num != null) {
            zzburVar.zzv(26, num.intValue());
        }
        String str5 = this.zzdq;
        if (str5 != null) {
            zzburVar.zzf(27, str5);
        }
        Boolean bool = this.zzgg;
        if (bool != null) {
            zzburVar.zzj(28, bool.booleanValue());
        }
        String str6 = this.zzer;
        if (str6 != null) {
            zzburVar.zzf(29, str6);
        }
        String str7 = this.zzgh;
        if (str7 != null) {
            zzburVar.zzf(30, str7);
        }
        Long l22 = this.zzes;
        if (l22 != null) {
            zzburVar.zzr(31, l22.longValue());
        }
        Long l23 = this.zzet;
        if (l23 != null) {
            zzburVar.zzr(32, l23.longValue());
        }
        Long l24 = this.zzeu;
        if (l24 != null) {
            zzburVar.zzr(33, l24.longValue());
        }
        String str8 = this.zzds;
        if (str8 != null) {
            zzburVar.zzf(34, str8);
        }
        Long l25 = this.zzev;
        if (l25 != null) {
            zzburVar.zzr(35, l25.longValue());
        }
        Long l26 = this.zzew;
        if (l26 != null) {
            zzburVar.zzr(36, l26.longValue());
        }
        Long l27 = this.zzex;
        if (l27 != null) {
            zzburVar.zzr(37, l27.longValue());
        }
        zzbo zzboVar = this.zzey;
        if (zzboVar != null) {
            zzburVar.zza(38, zzboVar);
        }
        Long l28 = this.zzez;
        if (l28 != null) {
            zzburVar.zzr(39, l28.longValue());
        }
        Long l29 = this.zzfa;
        if (l29 != null) {
            zzburVar.zzr(40, l29.longValue());
        }
        Long l30 = this.zzfb;
        if (l30 != null) {
            zzburVar.zzr(41, l30.longValue());
        }
        Long l31 = this.zzfc;
        if (l31 != null) {
            zzburVar.zzr(42, l31.longValue());
        }
        zzbm[] zzbmVarArr = this.zzfo;
        if (zzbmVarArr != null && zzbmVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzbm[] zzbmVarArr2 = this.zzfo;
                if (i >= zzbmVarArr2.length) {
                    break;
                }
                zzbm zzbmVar = zzbmVarArr2[i];
                if (zzbmVar != null) {
                    zzburVar.zza(43, zzbmVar);
                }
                i++;
            }
        }
        Long l32 = this.zzfd;
        if (l32 != null) {
            zzburVar.zzr(44, l32.longValue());
        }
        Long l33 = this.zzfe;
        if (l33 != null) {
            zzburVar.zzr(45, l33.longValue());
        }
        String str9 = this.zzdt;
        if (str9 != null) {
            zzburVar.zzf(46, str9);
        }
        String str10 = this.zzdu;
        if (str10 != null) {
            zzburVar.zzf(47, str10);
        }
        Integer num2 = this.zzff;
        if (num2 != null) {
            zzburVar.zzv(48, num2.intValue());
        }
        Integer num3 = this.zzfg;
        if (num3 != null) {
            zzburVar.zzv(49, num3.intValue());
        }
        zzbm zzbmVar2 = this.zzfn;
        if (zzbmVar2 != null) {
            zzburVar.zza(50, zzbmVar2);
        }
        Long l34 = this.zzfh;
        if (l34 != null) {
            zzburVar.zzr(51, l34.longValue());
        }
        Long l35 = this.zzfi;
        if (l35 != null) {
            zzburVar.zzr(52, l35.longValue());
        }
        Long l36 = this.zzfj;
        if (l36 != null) {
            zzburVar.zzr(53, l36.longValue());
        }
        Long l37 = this.zzfk;
        if (l37 != null) {
            zzburVar.zzr(54, l37.longValue());
        }
        Long l38 = this.zzfl;
        if (l38 != null) {
            zzburVar.zzr(55, l38.longValue());
        }
        Integer num4 = this.zzfm;
        if (num4 != null) {
            zzburVar.zzv(56, num4.intValue());
        }
        zzbn zzbnVar = this.zzfp;
        if (zzbnVar != null) {
            zzburVar.zza(57, zzbnVar);
        }
        Long l39 = this.zzfq;
        if (l39 != null) {
            zzburVar.zzr(58, l39.longValue());
        }
        Long l40 = this.zzfr;
        if (l40 != null) {
            zzburVar.zzr(59, l40.longValue());
        }
        Long l41 = this.zzfs;
        if (l41 != null) {
            zzburVar.zzr(60, l41.longValue());
        }
        Long l42 = this.zzft;
        if (l42 != null) {
            zzburVar.zzr(61, l42.longValue());
        }
        Long l43 = this.zzfu;
        if (l43 != null) {
            zzburVar.zzr(62, l43.longValue());
        }
        Long l44 = this.zzfv;
        if (l44 != null) {
            zzburVar.zzr(63, l44.longValue());
        }
        Long l45 = this.zzfx;
        if (l45 != null) {
            zzburVar.zzr(64, l45.longValue());
        }
        Integer num5 = this.zzfy;
        if (num5 != null) {
            zzburVar.zzv(65, num5.intValue());
        }
        Integer num6 = this.zzfz;
        if (num6 != null) {
            zzburVar.zzv(66, num6.intValue());
        }
        String str11 = this.zzfw;
        if (str11 != null) {
            zzburVar.zzf(67, str11);
        }
        Integer num7 = this.zzga;
        if (num7 != null) {
            zzburVar.zzv(68, num7.intValue());
        }
        zzbr zzbrVar = this.zzgb;
        if (zzbrVar != null) {
            zzburVar.zza(69, zzbrVar);
        }
        Long l46 = this.zzgc;
        if (l46 != null) {
            zzburVar.zzr(70, l46.longValue());
        }
        zzbq zzbqVar = this.zzgj;
        if (zzbqVar != null) {
            zzburVar.zza(201, zzbqVar);
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        String str = this.zzdw;
        if (str != null) {
            zzt += zzbur.zzg(1, str);
        }
        String str2 = this.zzdp;
        if (str2 != null) {
            zzt += zzbur.zzg(2, str2);
        }
        Long l = this.zzdx;
        if (l != null) {
            zzt += zzbur.zzm(3, l.longValue());
        }
        Long l2 = this.zzdy;
        if (l2 != null) {
            zzt += zzbur.zzm(4, l2.longValue());
        }
        Long l3 = this.zzdz;
        if (l3 != null) {
            zzt += zzbur.zzm(5, l3.longValue());
        }
        Long l4 = this.zzea;
        if (l4 != null) {
            zzt += zzbur.zzm(6, l4.longValue());
        }
        Long l5 = this.zzeb;
        if (l5 != null) {
            zzt += zzbur.zzm(7, l5.longValue());
        }
        Long l6 = this.zzec;
        if (l6 != null) {
            zzt += zzbur.zzm(8, l6.longValue());
        }
        Long l7 = this.zzed;
        if (l7 != null) {
            zzt += zzbur.zzm(9, l7.longValue());
        }
        Long l8 = this.zzee;
        if (l8 != null) {
            zzt += zzbur.zzm(10, l8.longValue());
        }
        Long l9 = this.zzef;
        if (l9 != null) {
            zzt += zzbur.zzm(11, l9.longValue());
        }
        Long l10 = this.zzeg;
        if (l10 != null) {
            zzt += zzbur.zzm(12, l10.longValue());
        }
        String str3 = this.zzeh;
        if (str3 != null) {
            zzt += zzbur.zzg(13, str3);
        }
        Long l11 = this.zzei;
        if (l11 != null) {
            zzt += zzbur.zzm(14, l11.longValue());
        }
        Long l12 = this.zzej;
        if (l12 != null) {
            zzt += zzbur.zzm(15, l12.longValue());
        }
        Long l13 = this.zzek;
        if (l13 != null) {
            zzt += zzbur.zzm(16, l13.longValue());
        }
        Long l14 = this.zzel;
        if (l14 != null) {
            zzt += zzbur.zzm(17, l14.longValue());
        }
        Long l15 = this.zzem;
        if (l15 != null) {
            zzt += zzbur.zzm(18, l15.longValue());
        }
        Long l16 = this.zzen;
        if (l16 != null) {
            zzt += zzbur.zzm(19, l16.longValue());
        }
        Long l17 = this.zzeo;
        if (l17 != null) {
            zzt += zzbur.zzm(20, l17.longValue());
        }
        Long l18 = this.zzgd;
        if (l18 != null) {
            zzt += zzbur.zzm(21, l18.longValue());
        }
        Long l19 = this.zzep;
        if (l19 != null) {
            zzt += zzbur.zzm(22, l19.longValue());
        }
        Long l20 = this.zzeq;
        if (l20 != null) {
            zzt += zzbur.zzm(23, l20.longValue());
        }
        String str4 = this.zzge;
        if (str4 != null) {
            zzt += zzbur.zzg(24, str4);
        }
        Long l21 = this.zzgi;
        if (l21 != null) {
            zzt += zzbur.zzm(25, l21.longValue());
        }
        Integer num = this.zzgf;
        if (num != null) {
            zzt += zzbur.zzz(26, num.intValue());
        }
        String str5 = this.zzdq;
        if (str5 != null) {
            zzt += zzbur.zzg(27, str5);
        }
        Boolean bool = this.zzgg;
        if (bool != null) {
            bool.booleanValue();
            zzt += zzbur.zzfd(28) + 1;
        }
        String str6 = this.zzer;
        if (str6 != null) {
            zzt += zzbur.zzg(29, str6);
        }
        String str7 = this.zzgh;
        if (str7 != null) {
            zzt += zzbur.zzg(30, str7);
        }
        Long l22 = this.zzes;
        if (l22 != null) {
            zzt += zzbur.zzm(31, l22.longValue());
        }
        Long l23 = this.zzet;
        if (l23 != null) {
            zzt += zzbur.zzm(32, l23.longValue());
        }
        Long l24 = this.zzeu;
        if (l24 != null) {
            zzt += zzbur.zzm(33, l24.longValue());
        }
        String str8 = this.zzds;
        if (str8 != null) {
            zzt += zzbur.zzg(34, str8);
        }
        Long l25 = this.zzev;
        if (l25 != null) {
            zzt += zzbur.zzm(35, l25.longValue());
        }
        Long l26 = this.zzew;
        if (l26 != null) {
            zzt += zzbur.zzm(36, l26.longValue());
        }
        Long l27 = this.zzex;
        if (l27 != null) {
            zzt += zzbur.zzm(37, l27.longValue());
        }
        zzbo zzboVar = this.zzey;
        if (zzboVar != null) {
            zzt += zzbur.zzb(38, zzboVar);
        }
        Long l28 = this.zzez;
        if (l28 != null) {
            zzt += zzbur.zzm(39, l28.longValue());
        }
        Long l29 = this.zzfa;
        if (l29 != null) {
            zzt += zzbur.zzm(40, l29.longValue());
        }
        Long l30 = this.zzfb;
        if (l30 != null) {
            zzt += zzbur.zzm(41, l30.longValue());
        }
        Long l31 = this.zzfc;
        if (l31 != null) {
            zzt += zzbur.zzm(42, l31.longValue());
        }
        zzbm[] zzbmVarArr = this.zzfo;
        if (zzbmVarArr != null && zzbmVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzbm[] zzbmVarArr2 = this.zzfo;
                if (i >= zzbmVarArr2.length) {
                    break;
                }
                zzbm zzbmVar = zzbmVarArr2[i];
                if (zzbmVar != null) {
                    zzt += zzbur.zzb(43, zzbmVar);
                }
                i++;
            }
        }
        Long l32 = this.zzfd;
        if (l32 != null) {
            zzt += zzbur.zzm(44, l32.longValue());
        }
        Long l33 = this.zzfe;
        if (l33 != null) {
            zzt += zzbur.zzm(45, l33.longValue());
        }
        String str9 = this.zzdt;
        if (str9 != null) {
            zzt += zzbur.zzg(46, str9);
        }
        String str10 = this.zzdu;
        if (str10 != null) {
            zzt += zzbur.zzg(47, str10);
        }
        Integer num2 = this.zzff;
        if (num2 != null) {
            zzt += zzbur.zzz(48, num2.intValue());
        }
        Integer num3 = this.zzfg;
        if (num3 != null) {
            zzt += zzbur.zzz(49, num3.intValue());
        }
        zzbm zzbmVar2 = this.zzfn;
        if (zzbmVar2 != null) {
            zzt += zzbur.zzb(50, zzbmVar2);
        }
        Long l34 = this.zzfh;
        if (l34 != null) {
            zzt += zzbur.zzm(51, l34.longValue());
        }
        Long l35 = this.zzfi;
        if (l35 != null) {
            zzt += zzbur.zzm(52, l35.longValue());
        }
        Long l36 = this.zzfj;
        if (l36 != null) {
            zzt += zzbur.zzm(53, l36.longValue());
        }
        Long l37 = this.zzfk;
        if (l37 != null) {
            zzt += zzbur.zzm(54, l37.longValue());
        }
        Long l38 = this.zzfl;
        if (l38 != null) {
            zzt += zzbur.zzm(55, l38.longValue());
        }
        Integer num4 = this.zzfm;
        if (num4 != null) {
            zzt += zzbur.zzz(56, num4.intValue());
        }
        zzbn zzbnVar = this.zzfp;
        if (zzbnVar != null) {
            zzt += zzbur.zzb(57, zzbnVar);
        }
        Long l39 = this.zzfq;
        if (l39 != null) {
            zzt += zzbur.zzm(58, l39.longValue());
        }
        Long l40 = this.zzfr;
        if (l40 != null) {
            zzt += zzbur.zzm(59, l40.longValue());
        }
        Long l41 = this.zzfs;
        if (l41 != null) {
            zzt += zzbur.zzm(60, l41.longValue());
        }
        Long l42 = this.zzft;
        if (l42 != null) {
            zzt += zzbur.zzm(61, l42.longValue());
        }
        Long l43 = this.zzfu;
        if (l43 != null) {
            zzt += zzbur.zzm(62, l43.longValue());
        }
        Long l44 = this.zzfv;
        if (l44 != null) {
            zzt += zzbur.zzm(63, l44.longValue());
        }
        Long l45 = this.zzfx;
        if (l45 != null) {
            zzt += zzbur.zzm(64, l45.longValue());
        }
        Integer num5 = this.zzfy;
        if (num5 != null) {
            zzt += zzbur.zzz(65, num5.intValue());
        }
        Integer num6 = this.zzfz;
        if (num6 != null) {
            zzt += zzbur.zzz(66, num6.intValue());
        }
        String str11 = this.zzfw;
        if (str11 != null) {
            zzt += zzbur.zzg(67, str11);
        }
        Integer num7 = this.zzga;
        if (num7 != null) {
            zzt += zzbur.zzz(68, num7.intValue());
        }
        zzbr zzbrVar = this.zzgb;
        if (zzbrVar != null) {
            zzt += zzbur.zzb(69, zzbrVar);
        }
        Long l46 = this.zzgc;
        if (l46 != null) {
            zzt += zzbur.zzm(70, l46.longValue());
        }
        zzbq zzbqVar = this.zzgj;
        return zzbqVar != null ? zzt + zzbur.zzb(201, zzbqVar) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        zzb(zzbuqVar);
        return this;
    }
}
