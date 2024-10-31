package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfe;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzfw extends zzyc<zzfw> {
    private static volatile zzfw[] zzaxg;
    public Integer zzaxh = null;
    public zzft[] zzaxi = zzft.zzmz();
    public zzfz[] zzaxj = zzfz.zznd();
    public Long zzaxk = null;
    public Long zzaxl = null;
    public Long zzaxm = null;
    public Long zzaxn = null;
    public Long zzaxo = null;
    public String zzaxp = null;
    public String zzaxq = null;
    public String zzaxr = null;
    public String zzahr = null;
    public Integer zzaxs = null;
    public String zzafp = null;
    public String zztt = null;
    public String zzts = null;
    public Long zzaxt = null;
    public Long zzaxu = null;
    public String zzaxv = null;
    public Boolean zzaxw = null;
    public String zzafh = null;
    public Long zzaxx = null;
    public Integer zzaxy = null;
    public String zzagm = null;
    public String zzafi = null;
    public Boolean zzaxz = null;
    public zzfr[] zzaya = zzfr.zzmx();
    public String zzafk = null;
    public Integer zzayb = null;
    private Integer zzayc = null;
    private Integer zzayd = null;
    public String zzaye = null;
    public Long zzayf = null;
    public Long zzayg = null;
    public String zzayh = null;
    private String zzayi = null;
    public Integer zzayj = null;
    public String zzawp = null;
    public zzfe.zzb zzayk = null;
    public int[] zzayl = zzyl.zzcao;
    private Long zzaym = null;

    public zzfw() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public static zzfw[] zznb() {
        if (zzaxg == null) {
            synchronized (zzyg.zzcfc) {
                if (zzaxg == null) {
                    zzaxg = new zzfw[0];
                }
            }
        }
        return zzaxg;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfw)) {
            return false;
        }
        zzfw zzfwVar = (zzfw) obj;
        Integer num = this.zzaxh;
        if (num == null) {
            if (zzfwVar.zzaxh != null) {
                return false;
            }
        } else if (!num.equals(zzfwVar.zzaxh)) {
            return false;
        }
        if (!zzyg.equals(this.zzaxi, zzfwVar.zzaxi) || !zzyg.equals(this.zzaxj, zzfwVar.zzaxj)) {
            return false;
        }
        Long l = this.zzaxk;
        if (l == null) {
            if (zzfwVar.zzaxk != null) {
                return false;
            }
        } else if (!l.equals(zzfwVar.zzaxk)) {
            return false;
        }
        Long l2 = this.zzaxl;
        if (l2 == null) {
            if (zzfwVar.zzaxl != null) {
                return false;
            }
        } else if (!l2.equals(zzfwVar.zzaxl)) {
            return false;
        }
        Long l3 = this.zzaxm;
        if (l3 == null) {
            if (zzfwVar.zzaxm != null) {
                return false;
            }
        } else if (!l3.equals(zzfwVar.zzaxm)) {
            return false;
        }
        Long l4 = this.zzaxn;
        if (l4 == null) {
            if (zzfwVar.zzaxn != null) {
                return false;
            }
        } else if (!l4.equals(zzfwVar.zzaxn)) {
            return false;
        }
        Long l5 = this.zzaxo;
        if (l5 == null) {
            if (zzfwVar.zzaxo != null) {
                return false;
            }
        } else if (!l5.equals(zzfwVar.zzaxo)) {
            return false;
        }
        String str = this.zzaxp;
        if (str == null) {
            if (zzfwVar.zzaxp != null) {
                return false;
            }
        } else if (!str.equals(zzfwVar.zzaxp)) {
            return false;
        }
        String str2 = this.zzaxq;
        if (str2 == null) {
            if (zzfwVar.zzaxq != null) {
                return false;
            }
        } else if (!str2.equals(zzfwVar.zzaxq)) {
            return false;
        }
        String str3 = this.zzaxr;
        if (str3 == null) {
            if (zzfwVar.zzaxr != null) {
                return false;
            }
        } else if (!str3.equals(zzfwVar.zzaxr)) {
            return false;
        }
        String str4 = this.zzahr;
        if (str4 == null) {
            if (zzfwVar.zzahr != null) {
                return false;
            }
        } else if (!str4.equals(zzfwVar.zzahr)) {
            return false;
        }
        Integer num2 = this.zzaxs;
        if (num2 == null) {
            if (zzfwVar.zzaxs != null) {
                return false;
            }
        } else if (!num2.equals(zzfwVar.zzaxs)) {
            return false;
        }
        String str5 = this.zzafp;
        if (str5 == null) {
            if (zzfwVar.zzafp != null) {
                return false;
            }
        } else if (!str5.equals(zzfwVar.zzafp)) {
            return false;
        }
        String str6 = this.zztt;
        if (str6 == null) {
            if (zzfwVar.zztt != null) {
                return false;
            }
        } else if (!str6.equals(zzfwVar.zztt)) {
            return false;
        }
        String str7 = this.zzts;
        if (str7 == null) {
            if (zzfwVar.zzts != null) {
                return false;
            }
        } else if (!str7.equals(zzfwVar.zzts)) {
            return false;
        }
        Long l6 = this.zzaxt;
        if (l6 == null) {
            if (zzfwVar.zzaxt != null) {
                return false;
            }
        } else if (!l6.equals(zzfwVar.zzaxt)) {
            return false;
        }
        Long l7 = this.zzaxu;
        if (l7 == null) {
            if (zzfwVar.zzaxu != null) {
                return false;
            }
        } else if (!l7.equals(zzfwVar.zzaxu)) {
            return false;
        }
        String str8 = this.zzaxv;
        if (str8 == null) {
            if (zzfwVar.zzaxv != null) {
                return false;
            }
        } else if (!str8.equals(zzfwVar.zzaxv)) {
            return false;
        }
        Boolean bool = this.zzaxw;
        if (bool == null) {
            if (zzfwVar.zzaxw != null) {
                return false;
            }
        } else if (!bool.equals(zzfwVar.zzaxw)) {
            return false;
        }
        String str9 = this.zzafh;
        if (str9 == null) {
            if (zzfwVar.zzafh != null) {
                return false;
            }
        } else if (!str9.equals(zzfwVar.zzafh)) {
            return false;
        }
        Long l8 = this.zzaxx;
        if (l8 == null) {
            if (zzfwVar.zzaxx != null) {
                return false;
            }
        } else if (!l8.equals(zzfwVar.zzaxx)) {
            return false;
        }
        Integer num3 = this.zzaxy;
        if (num3 == null) {
            if (zzfwVar.zzaxy != null) {
                return false;
            }
        } else if (!num3.equals(zzfwVar.zzaxy)) {
            return false;
        }
        String str10 = this.zzagm;
        if (str10 == null) {
            if (zzfwVar.zzagm != null) {
                return false;
            }
        } else if (!str10.equals(zzfwVar.zzagm)) {
            return false;
        }
        String str11 = this.zzafi;
        if (str11 == null) {
            if (zzfwVar.zzafi != null) {
                return false;
            }
        } else if (!str11.equals(zzfwVar.zzafi)) {
            return false;
        }
        Boolean bool2 = this.zzaxz;
        if (bool2 == null) {
            if (zzfwVar.zzaxz != null) {
                return false;
            }
        } else if (!bool2.equals(zzfwVar.zzaxz)) {
            return false;
        }
        if (!zzyg.equals(this.zzaya, zzfwVar.zzaya)) {
            return false;
        }
        String str12 = this.zzafk;
        if (str12 == null) {
            if (zzfwVar.zzafk != null) {
                return false;
            }
        } else if (!str12.equals(zzfwVar.zzafk)) {
            return false;
        }
        Integer num4 = this.zzayb;
        if (num4 == null) {
            if (zzfwVar.zzayb != null) {
                return false;
            }
        } else if (!num4.equals(zzfwVar.zzayb)) {
            return false;
        }
        Integer num5 = this.zzayc;
        if (num5 == null) {
            if (zzfwVar.zzayc != null) {
                return false;
            }
        } else if (!num5.equals(zzfwVar.zzayc)) {
            return false;
        }
        Integer num6 = this.zzayd;
        if (num6 == null) {
            if (zzfwVar.zzayd != null) {
                return false;
            }
        } else if (!num6.equals(zzfwVar.zzayd)) {
            return false;
        }
        String str13 = this.zzaye;
        if (str13 == null) {
            if (zzfwVar.zzaye != null) {
                return false;
            }
        } else if (!str13.equals(zzfwVar.zzaye)) {
            return false;
        }
        Long l9 = this.zzayf;
        if (l9 == null) {
            if (zzfwVar.zzayf != null) {
                return false;
            }
        } else if (!l9.equals(zzfwVar.zzayf)) {
            return false;
        }
        Long l10 = this.zzayg;
        if (l10 == null) {
            if (zzfwVar.zzayg != null) {
                return false;
            }
        } else if (!l10.equals(zzfwVar.zzayg)) {
            return false;
        }
        String str14 = this.zzayh;
        if (str14 == null) {
            if (zzfwVar.zzayh != null) {
                return false;
            }
        } else if (!str14.equals(zzfwVar.zzayh)) {
            return false;
        }
        String str15 = this.zzayi;
        if (str15 == null) {
            if (zzfwVar.zzayi != null) {
                return false;
            }
        } else if (!str15.equals(zzfwVar.zzayi)) {
            return false;
        }
        Integer num7 = this.zzayj;
        if (num7 == null) {
            if (zzfwVar.zzayj != null) {
                return false;
            }
        } else if (!num7.equals(zzfwVar.zzayj)) {
            return false;
        }
        String str16 = this.zzawp;
        if (str16 == null) {
            if (zzfwVar.zzawp != null) {
                return false;
            }
        } else if (!str16.equals(zzfwVar.zzawp)) {
            return false;
        }
        zzfe.zzb zzbVar = this.zzayk;
        if (zzbVar == null) {
            if (zzfwVar.zzayk != null) {
                return false;
            }
        } else if (!zzbVar.equals(zzfwVar.zzayk)) {
            return false;
        }
        if (!zzyg.equals(this.zzayl, zzfwVar.zzayl)) {
            return false;
        }
        Long l11 = this.zzaym;
        if (l11 == null) {
            if (zzfwVar.zzaym != null) {
                return false;
            }
        } else if (!l11.equals(zzfwVar.zzaym)) {
            return false;
        }
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            return this.zzcet.equals(zzfwVar.zzcet);
        }
        zzye zzyeVar2 = zzfwVar.zzcet;
        return zzyeVar2 == null || zzyeVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzfw.class.getName().hashCode() + 527) * 31;
        Integer num = this.zzaxh;
        int i = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + zzyg.hashCode(this.zzaxi)) * 31) + zzyg.hashCode(this.zzaxj)) * 31;
        Long l = this.zzaxk;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.zzaxl;
        int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.zzaxm;
        int hashCode5 = (hashCode4 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.zzaxn;
        int hashCode6 = (hashCode5 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Long l5 = this.zzaxo;
        int hashCode7 = (hashCode6 + (l5 == null ? 0 : l5.hashCode())) * 31;
        String str = this.zzaxp;
        int hashCode8 = (hashCode7 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.zzaxq;
        int hashCode9 = (hashCode8 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.zzaxr;
        int hashCode10 = (hashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.zzahr;
        int hashCode11 = (hashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num2 = this.zzaxs;
        int hashCode12 = (hashCode11 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str5 = this.zzafp;
        int hashCode13 = (hashCode12 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.zztt;
        int hashCode14 = (hashCode13 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.zzts;
        int hashCode15 = (hashCode14 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Long l6 = this.zzaxt;
        int hashCode16 = (hashCode15 + (l6 == null ? 0 : l6.hashCode())) * 31;
        Long l7 = this.zzaxu;
        int hashCode17 = (hashCode16 + (l7 == null ? 0 : l7.hashCode())) * 31;
        String str8 = this.zzaxv;
        int hashCode18 = (hashCode17 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool = this.zzaxw;
        int hashCode19 = (hashCode18 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str9 = this.zzafh;
        int hashCode20 = (hashCode19 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Long l8 = this.zzaxx;
        int hashCode21 = (hashCode20 + (l8 == null ? 0 : l8.hashCode())) * 31;
        Integer num3 = this.zzaxy;
        int hashCode22 = (hashCode21 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str10 = this.zzagm;
        int hashCode23 = (hashCode22 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.zzafi;
        int hashCode24 = (hashCode23 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Boolean bool2 = this.zzaxz;
        int hashCode25 = (((hashCode24 + (bool2 == null ? 0 : bool2.hashCode())) * 31) + zzyg.hashCode(this.zzaya)) * 31;
        String str12 = this.zzafk;
        int hashCode26 = (hashCode25 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Integer num4 = this.zzayb;
        int hashCode27 = (hashCode26 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.zzayc;
        int hashCode28 = (hashCode27 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.zzayd;
        int hashCode29 = (hashCode28 + (num6 == null ? 0 : num6.hashCode())) * 31;
        String str13 = this.zzaye;
        int hashCode30 = (hashCode29 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Long l9 = this.zzayf;
        int hashCode31 = (hashCode30 + (l9 == null ? 0 : l9.hashCode())) * 31;
        Long l10 = this.zzayg;
        int hashCode32 = (hashCode31 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str14 = this.zzayh;
        int hashCode33 = (hashCode32 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.zzayi;
        int hashCode34 = (hashCode33 + (str15 == null ? 0 : str15.hashCode())) * 31;
        Integer num7 = this.zzayj;
        int hashCode35 = (hashCode34 + (num7 == null ? 0 : num7.hashCode())) * 31;
        String str16 = this.zzawp;
        int hashCode36 = hashCode35 + (str16 == null ? 0 : str16.hashCode());
        zzfe.zzb zzbVar = this.zzayk;
        int hashCode37 = ((((hashCode36 * 31) + (zzbVar == null ? 0 : zzbVar.hashCode())) * 31) + zzyg.hashCode(this.zzayl)) * 31;
        Long l11 = this.zzaym;
        int hashCode38 = (hashCode37 + (l11 == null ? 0 : l11.hashCode())) * 31;
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode38 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        Integer num = this.zzaxh;
        if (num != null) {
            zzyaVar.zzd(1, num.intValue());
        }
        zzft[] zzftVarArr = this.zzaxi;
        if (zzftVarArr != null && zzftVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzft[] zzftVarArr2 = this.zzaxi;
                if (i >= zzftVarArr2.length) {
                    break;
                }
                zzft zzftVar = zzftVarArr2[i];
                if (zzftVar != null) {
                    zzyaVar.zza(2, zzftVar);
                }
                i++;
            }
        }
        zzfz[] zzfzVarArr = this.zzaxj;
        if (zzfzVarArr != null && zzfzVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzfz[] zzfzVarArr2 = this.zzaxj;
                if (i2 >= zzfzVarArr2.length) {
                    break;
                }
                zzfz zzfzVar = zzfzVarArr2[i2];
                if (zzfzVar != null) {
                    zzyaVar.zza(3, zzfzVar);
                }
                i2++;
            }
        }
        Long l = this.zzaxk;
        if (l != null) {
            zzyaVar.zzi(4, l.longValue());
        }
        Long l2 = this.zzaxl;
        if (l2 != null) {
            zzyaVar.zzi(5, l2.longValue());
        }
        Long l3 = this.zzaxm;
        if (l3 != null) {
            zzyaVar.zzi(6, l3.longValue());
        }
        Long l4 = this.zzaxo;
        if (l4 != null) {
            zzyaVar.zzi(7, l4.longValue());
        }
        String str = this.zzaxp;
        if (str != null) {
            zzyaVar.zzb(8, str);
        }
        String str2 = this.zzaxq;
        if (str2 != null) {
            zzyaVar.zzb(9, str2);
        }
        String str3 = this.zzaxr;
        if (str3 != null) {
            zzyaVar.zzb(10, str3);
        }
        String str4 = this.zzahr;
        if (str4 != null) {
            zzyaVar.zzb(11, str4);
        }
        Integer num2 = this.zzaxs;
        if (num2 != null) {
            zzyaVar.zzd(12, num2.intValue());
        }
        String str5 = this.zzafp;
        if (str5 != null) {
            zzyaVar.zzb(13, str5);
        }
        String str6 = this.zztt;
        if (str6 != null) {
            zzyaVar.zzb(14, str6);
        }
        String str7 = this.zzts;
        if (str7 != null) {
            zzyaVar.zzb(16, str7);
        }
        Long l5 = this.zzaxt;
        if (l5 != null) {
            zzyaVar.zzi(17, l5.longValue());
        }
        Long l6 = this.zzaxu;
        if (l6 != null) {
            zzyaVar.zzi(18, l6.longValue());
        }
        String str8 = this.zzaxv;
        if (str8 != null) {
            zzyaVar.zzb(19, str8);
        }
        Boolean bool = this.zzaxw;
        if (bool != null) {
            zzyaVar.zzb(20, bool.booleanValue());
        }
        String str9 = this.zzafh;
        if (str9 != null) {
            zzyaVar.zzb(21, str9);
        }
        Long l7 = this.zzaxx;
        if (l7 != null) {
            zzyaVar.zzi(22, l7.longValue());
        }
        Integer num3 = this.zzaxy;
        if (num3 != null) {
            zzyaVar.zzd(23, num3.intValue());
        }
        String str10 = this.zzagm;
        if (str10 != null) {
            zzyaVar.zzb(24, str10);
        }
        String str11 = this.zzafi;
        if (str11 != null) {
            zzyaVar.zzb(25, str11);
        }
        Long l8 = this.zzaxn;
        if (l8 != null) {
            zzyaVar.zzi(26, l8.longValue());
        }
        Boolean bool2 = this.zzaxz;
        if (bool2 != null) {
            zzyaVar.zzb(28, bool2.booleanValue());
        }
        zzfr[] zzfrVarArr = this.zzaya;
        if (zzfrVarArr != null && zzfrVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                zzfr[] zzfrVarArr2 = this.zzaya;
                if (i3 >= zzfrVarArr2.length) {
                    break;
                }
                zzfr zzfrVar = zzfrVarArr2[i3];
                if (zzfrVar != null) {
                    zzyaVar.zza(29, zzfrVar);
                }
                i3++;
            }
        }
        String str12 = this.zzafk;
        if (str12 != null) {
            zzyaVar.zzb(30, str12);
        }
        Integer num4 = this.zzayb;
        if (num4 != null) {
            zzyaVar.zzd(31, num4.intValue());
        }
        Integer num5 = this.zzayc;
        if (num5 != null) {
            zzyaVar.zzd(32, num5.intValue());
        }
        Integer num6 = this.zzayd;
        if (num6 != null) {
            zzyaVar.zzd(33, num6.intValue());
        }
        String str13 = this.zzaye;
        if (str13 != null) {
            zzyaVar.zzb(34, str13);
        }
        Long l9 = this.zzayf;
        if (l9 != null) {
            zzyaVar.zzi(35, l9.longValue());
        }
        Long l10 = this.zzayg;
        if (l10 != null) {
            zzyaVar.zzi(36, l10.longValue());
        }
        String str14 = this.zzayh;
        if (str14 != null) {
            zzyaVar.zzb(37, str14);
        }
        String str15 = this.zzayi;
        if (str15 != null) {
            zzyaVar.zzb(38, str15);
        }
        Integer num7 = this.zzayj;
        if (num7 != null) {
            zzyaVar.zzd(39, num7.intValue());
        }
        String str16 = this.zzawp;
        if (str16 != null) {
            zzyaVar.zzb(41, str16);
        }
        zzfe.zzb zzbVar = this.zzayk;
        if (zzbVar != null) {
            zzyaVar.zze(44, zzbVar);
        }
        int[] iArr = this.zzayl;
        if (iArr != null && iArr.length > 0) {
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.zzayl;
                if (i4 >= iArr2.length) {
                    break;
                }
                int i5 = iArr2[i4];
                zzyaVar.zzc(45, 0);
                zzyaVar.zzcd(i5);
                i4++;
            }
        }
        Long l11 = this.zzaym;
        if (l11 != null) {
            zzyaVar.zzi(46, l11.longValue());
        }
        super.zza(zzyaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final int zzf() {
        int[] iArr;
        int zzf = super.zzf();
        Integer num = this.zzaxh;
        if (num != null) {
            zzf += zzya.zzh(1, num.intValue());
        }
        zzft[] zzftVarArr = this.zzaxi;
        int i = 0;
        if (zzftVarArr != null && zzftVarArr.length > 0) {
            int i2 = zzf;
            int i3 = 0;
            while (true) {
                zzft[] zzftVarArr2 = this.zzaxi;
                if (i3 >= zzftVarArr2.length) {
                    break;
                }
                zzft zzftVar = zzftVarArr2[i3];
                if (zzftVar != null) {
                    i2 += zzya.zzb(2, zzftVar);
                }
                i3++;
            }
            zzf = i2;
        }
        zzfz[] zzfzVarArr = this.zzaxj;
        if (zzfzVarArr != null && zzfzVarArr.length > 0) {
            int i4 = zzf;
            int i5 = 0;
            while (true) {
                zzfz[] zzfzVarArr2 = this.zzaxj;
                if (i5 >= zzfzVarArr2.length) {
                    break;
                }
                zzfz zzfzVar = zzfzVarArr2[i5];
                if (zzfzVar != null) {
                    i4 += zzya.zzb(3, zzfzVar);
                }
                i5++;
            }
            zzf = i4;
        }
        Long l = this.zzaxk;
        if (l != null) {
            zzf += zzya.zzd(4, l.longValue());
        }
        Long l2 = this.zzaxl;
        if (l2 != null) {
            zzf += zzya.zzd(5, l2.longValue());
        }
        Long l3 = this.zzaxm;
        if (l3 != null) {
            zzf += zzya.zzd(6, l3.longValue());
        }
        Long l4 = this.zzaxo;
        if (l4 != null) {
            zzf += zzya.zzd(7, l4.longValue());
        }
        String str = this.zzaxp;
        if (str != null) {
            zzf += zzya.zzc(8, str);
        }
        String str2 = this.zzaxq;
        if (str2 != null) {
            zzf += zzya.zzc(9, str2);
        }
        String str3 = this.zzaxr;
        if (str3 != null) {
            zzf += zzya.zzc(10, str3);
        }
        String str4 = this.zzahr;
        if (str4 != null) {
            zzf += zzya.zzc(11, str4);
        }
        Integer num2 = this.zzaxs;
        if (num2 != null) {
            zzf += zzya.zzh(12, num2.intValue());
        }
        String str5 = this.zzafp;
        if (str5 != null) {
            zzf += zzya.zzc(13, str5);
        }
        String str6 = this.zztt;
        if (str6 != null) {
            zzf += zzya.zzc(14, str6);
        }
        String str7 = this.zzts;
        if (str7 != null) {
            zzf += zzya.zzc(16, str7);
        }
        Long l5 = this.zzaxt;
        if (l5 != null) {
            zzf += zzya.zzd(17, l5.longValue());
        }
        Long l6 = this.zzaxu;
        if (l6 != null) {
            zzf += zzya.zzd(18, l6.longValue());
        }
        String str8 = this.zzaxv;
        if (str8 != null) {
            zzf += zzya.zzc(19, str8);
        }
        Boolean bool = this.zzaxw;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzya.zzbd(20) + 1;
        }
        String str9 = this.zzafh;
        if (str9 != null) {
            zzf += zzya.zzc(21, str9);
        }
        Long l7 = this.zzaxx;
        if (l7 != null) {
            zzf += zzya.zzd(22, l7.longValue());
        }
        Integer num3 = this.zzaxy;
        if (num3 != null) {
            zzf += zzya.zzh(23, num3.intValue());
        }
        String str10 = this.zzagm;
        if (str10 != null) {
            zzf += zzya.zzc(24, str10);
        }
        String str11 = this.zzafi;
        if (str11 != null) {
            zzf += zzya.zzc(25, str11);
        }
        Long l8 = this.zzaxn;
        if (l8 != null) {
            zzf += zzya.zzd(26, l8.longValue());
        }
        Boolean bool2 = this.zzaxz;
        if (bool2 != null) {
            bool2.booleanValue();
            zzf += zzya.zzbd(28) + 1;
        }
        zzfr[] zzfrVarArr = this.zzaya;
        if (zzfrVarArr != null && zzfrVarArr.length > 0) {
            int i6 = zzf;
            int i7 = 0;
            while (true) {
                zzfr[] zzfrVarArr2 = this.zzaya;
                if (i7 >= zzfrVarArr2.length) {
                    break;
                }
                zzfr zzfrVar = zzfrVarArr2[i7];
                if (zzfrVar != null) {
                    i6 += zzya.zzb(29, zzfrVar);
                }
                i7++;
            }
            zzf = i6;
        }
        String str12 = this.zzafk;
        if (str12 != null) {
            zzf += zzya.zzc(30, str12);
        }
        Integer num4 = this.zzayb;
        if (num4 != null) {
            zzf += zzya.zzh(31, num4.intValue());
        }
        Integer num5 = this.zzayc;
        if (num5 != null) {
            zzf += zzya.zzh(32, num5.intValue());
        }
        Integer num6 = this.zzayd;
        if (num6 != null) {
            zzf += zzya.zzh(33, num6.intValue());
        }
        String str13 = this.zzaye;
        if (str13 != null) {
            zzf += zzya.zzc(34, str13);
        }
        Long l9 = this.zzayf;
        if (l9 != null) {
            zzf += zzya.zzd(35, l9.longValue());
        }
        Long l10 = this.zzayg;
        if (l10 != null) {
            zzf += zzya.zzd(36, l10.longValue());
        }
        String str14 = this.zzayh;
        if (str14 != null) {
            zzf += zzya.zzc(37, str14);
        }
        String str15 = this.zzayi;
        if (str15 != null) {
            zzf += zzya.zzc(38, str15);
        }
        Integer num7 = this.zzayj;
        if (num7 != null) {
            zzf += zzya.zzh(39, num7.intValue());
        }
        String str16 = this.zzawp;
        if (str16 != null) {
            zzf += zzya.zzc(41, str16);
        }
        zzfe.zzb zzbVar = this.zzayk;
        if (zzbVar != null) {
            zzf += zztv.zzc(44, zzbVar);
        }
        int[] iArr2 = this.zzayl;
        if (iArr2 != null && iArr2.length > 0) {
            int i8 = 0;
            while (true) {
                iArr = this.zzayl;
                if (i >= iArr.length) {
                    break;
                }
                i8 += zzya.zzbl(iArr[i]);
                i++;
            }
            zzf = zzf + i8 + (iArr.length * 2);
        }
        Long l11 = this.zzaym;
        return l11 != null ? zzf + zzya.zzd(46, l11.longValue()) : zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int zzuj = zzxzVar.zzuj();
            switch (zzuj) {
                case 0:
                    return this;
                case 8:
                    this.zzaxh = Integer.valueOf(zzxzVar.zzvb());
                    break;
                case 18:
                    int zzb = zzyl.zzb(zzxzVar, 18);
                    zzft[] zzftVarArr = this.zzaxi;
                    int length = zzftVarArr == null ? 0 : zzftVarArr.length;
                    zzft[] zzftVarArr2 = new zzft[zzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzaxi, 0, zzftVarArr2, 0, length);
                    }
                    while (length < zzftVarArr2.length - 1) {
                        zzftVarArr2[length] = new zzft();
                        zzxzVar.zza(zzftVarArr2[length]);
                        zzxzVar.zzuj();
                        length++;
                    }
                    zzftVarArr2[length] = new zzft();
                    zzxzVar.zza(zzftVarArr2[length]);
                    this.zzaxi = zzftVarArr2;
                    break;
                case 26:
                    int zzb2 = zzyl.zzb(zzxzVar, 26);
                    zzfz[] zzfzVarArr = this.zzaxj;
                    int length2 = zzfzVarArr == null ? 0 : zzfzVarArr.length;
                    zzfz[] zzfzVarArr2 = new zzfz[zzb2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzaxj, 0, zzfzVarArr2, 0, length2);
                    }
                    while (length2 < zzfzVarArr2.length - 1) {
                        zzfzVarArr2[length2] = new zzfz();
                        zzxzVar.zza(zzfzVarArr2[length2]);
                        zzxzVar.zzuj();
                        length2++;
                    }
                    zzfzVarArr2[length2] = new zzfz();
                    zzxzVar.zza(zzfzVarArr2[length2]);
                    this.zzaxj = zzfzVarArr2;
                    break;
                case 32:
                    this.zzaxk = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 40:
                    this.zzaxl = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 48:
                    this.zzaxm = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 56:
                    this.zzaxo = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 66:
                    this.zzaxp = zzxzVar.readString();
                    break;
                case 74:
                    this.zzaxq = zzxzVar.readString();
                    break;
                case 82:
                    this.zzaxr = zzxzVar.readString();
                    break;
                case 90:
                    this.zzahr = zzxzVar.readString();
                    break;
                case 96:
                    this.zzaxs = Integer.valueOf(zzxzVar.zzvb());
                    break;
                case 106:
                    this.zzafp = zzxzVar.readString();
                    break;
                case 114:
                    this.zztt = zzxzVar.readString();
                    break;
                case 130:
                    this.zzts = zzxzVar.readString();
                    break;
                case 136:
                    this.zzaxt = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 144:
                    this.zzaxu = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 154:
                    this.zzaxv = zzxzVar.readString();
                    break;
                case 160:
                    this.zzaxw = Boolean.valueOf(zzxzVar.zzup());
                    break;
                case 170:
                    this.zzafh = zzxzVar.readString();
                    break;
                case 176:
                    this.zzaxx = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 184:
                    this.zzaxy = Integer.valueOf(zzxzVar.zzvb());
                    break;
                case 194:
                    this.zzagm = zzxzVar.readString();
                    break;
                case 202:
                    this.zzafi = zzxzVar.readString();
                    break;
                case 208:
                    this.zzaxn = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 224:
                    this.zzaxz = Boolean.valueOf(zzxzVar.zzup());
                    break;
                case 234:
                    int zzb3 = zzyl.zzb(zzxzVar, 234);
                    zzfr[] zzfrVarArr = this.zzaya;
                    int length3 = zzfrVarArr == null ? 0 : zzfrVarArr.length;
                    zzfr[] zzfrVarArr2 = new zzfr[zzb3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.zzaya, 0, zzfrVarArr2, 0, length3);
                    }
                    while (length3 < zzfrVarArr2.length - 1) {
                        zzfrVarArr2[length3] = new zzfr();
                        zzxzVar.zza(zzfrVarArr2[length3]);
                        zzxzVar.zzuj();
                        length3++;
                    }
                    zzfrVarArr2[length3] = new zzfr();
                    zzxzVar.zza(zzfrVarArr2[length3]);
                    this.zzaya = zzfrVarArr2;
                    break;
                case 242:
                    this.zzafk = zzxzVar.readString();
                    break;
                case 248:
                    this.zzayb = Integer.valueOf(zzxzVar.zzvb());
                    break;
                case 256:
                    this.zzayc = Integer.valueOf(zzxzVar.zzvb());
                    break;
                case 264:
                    this.zzayd = Integer.valueOf(zzxzVar.zzvb());
                    break;
                case 274:
                    this.zzaye = zzxzVar.readString();
                    break;
                case 280:
                    this.zzayf = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 288:
                    this.zzayg = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 298:
                    this.zzayh = zzxzVar.readString();
                    break;
                case 306:
                    this.zzayi = zzxzVar.readString();
                    break;
                case 312:
                    this.zzayj = Integer.valueOf(zzxzVar.zzvb());
                    break;
                case 330:
                    this.zzawp = zzxzVar.readString();
                    break;
                case 354:
                    zzfe.zzb zzbVar = (zzfe.zzb) zzxzVar.zza(zzfe.zzb.zza());
                    zzfe.zzb zzbVar2 = this.zzayk;
                    if (zzbVar2 != null) {
                        zzbVar = (zzfe.zzb) zzbVar2.zzwf().zza((zzfe.zzb.zza) zzbVar).zzwo();
                    }
                    this.zzayk = zzbVar;
                    break;
                case 360:
                    int zzb4 = zzyl.zzb(zzxzVar, 360);
                    int[] iArr = this.zzayl;
                    int length4 = iArr == null ? 0 : iArr.length;
                    int[] iArr2 = new int[zzb4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.zzayl, 0, iArr2, 0, length4);
                    }
                    while (length4 < iArr2.length - 1) {
                        iArr2[length4] = zzxzVar.zzvb();
                        zzxzVar.zzuj();
                        length4++;
                    }
                    iArr2[length4] = zzxzVar.zzvb();
                    this.zzayl = iArr2;
                    break;
                case 362:
                    int zzas = zzxzVar.zzas(zzxzVar.zzvb());
                    int position = zzxzVar.getPosition();
                    int i = 0;
                    while (zzxzVar.zzyy() > 0) {
                        zzxzVar.zzvb();
                        i++;
                    }
                    zzxzVar.zzcb(position);
                    int[] iArr3 = this.zzayl;
                    int length5 = iArr3 == null ? 0 : iArr3.length;
                    int[] iArr4 = new int[i + length5];
                    if (length5 != 0) {
                        System.arraycopy(this.zzayl, 0, iArr4, 0, length5);
                    }
                    while (length5 < iArr4.length) {
                        iArr4[length5] = zzxzVar.zzvb();
                        length5++;
                    }
                    this.zzayl = iArr4;
                    zzxzVar.zzat(zzas);
                    break;
                case 368:
                    this.zzaym = Long.valueOf(zzxzVar.zzvc());
                    break;
                default:
                    if (!super.zza(zzxzVar, zzuj)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
