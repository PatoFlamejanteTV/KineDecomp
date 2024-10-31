package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzc;
import com.google.android.gms.internal.gtm.zzg;
import com.google.android.gms.tagmanager.zzgj;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzor {
    public static zzov zza(zzi zziVar) throws zzoz {
        zzl[] zzlVarArr = new zzl[zziVar.zzpj.length];
        for (int i = 0; i < zziVar.zzpj.length; i++) {
            zza(i, zziVar, zzlVarArr, new HashSet(0));
        }
        zzow zzmn = zzov.zzmn();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            zzc.zzb[] zzbVarArr = zziVar.zzpm;
            if (i2 >= zzbVarArr.length) {
                break;
            }
            arrayList.add(zza(zzbVarArr[i2], zziVar, zzlVarArr, i2));
            i2++;
        }
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        while (true) {
            zzc.zzb[] zzbVarArr2 = zziVar.zzpn;
            if (i3 >= zzbVarArr2.length) {
                break;
            }
            arrayList2.add(zza(zzbVarArr2[i3], zziVar, zzlVarArr, i3));
            i3++;
        }
        ArrayList arrayList3 = new ArrayList();
        int i4 = 0;
        while (true) {
            zzc.zzb[] zzbVarArr3 = zziVar.zzpl;
            if (i4 >= zzbVarArr3.length) {
                break;
            }
            zzot zza = zza(zzbVarArr3[i4], zziVar, zzlVarArr, i4);
            zzmn.zzc(zza);
            arrayList3.add(zza);
            i4++;
        }
        for (zzc.zze zzeVar : zziVar.zzpo) {
            zzoy zzoyVar = new zzoy();
            Iterator<Integer> it = zzeVar.zzn().iterator();
            while (it.hasNext()) {
                zzoyVar.zzd((zzot) arrayList2.get(it.next().intValue()));
            }
            Iterator<Integer> it2 = zzeVar.zzo().iterator();
            while (it2.hasNext()) {
                zzoyVar.zze((zzot) arrayList2.get(it2.next().intValue()));
            }
            Iterator<Integer> it3 = zzeVar.zzp().iterator();
            while (it3.hasNext()) {
                zzoyVar.zzf((zzot) arrayList.get(it3.next().intValue()));
            }
            Iterator<Integer> it4 = zzeVar.zzr().iterator();
            while (it4.hasNext()) {
                zzoyVar.zzct(zziVar.zzpj[it4.next().intValue()].string);
            }
            Iterator<Integer> it5 = zzeVar.zzq().iterator();
            while (it5.hasNext()) {
                zzoyVar.zzg((zzot) arrayList.get(it5.next().intValue()));
            }
            Iterator<Integer> it6 = zzeVar.zzs().iterator();
            while (it6.hasNext()) {
                zzoyVar.zzcu(zziVar.zzpj[it6.next().intValue()].string);
            }
            Iterator<Integer> it7 = zzeVar.zzt().iterator();
            while (it7.hasNext()) {
                zzoyVar.zzh((zzot) arrayList3.get(it7.next().intValue()));
            }
            Iterator<Integer> it8 = zzeVar.zzv().iterator();
            while (it8.hasNext()) {
                zzoyVar.zzcv(zziVar.zzpj[it8.next().intValue()].string);
            }
            Iterator<Integer> it9 = zzeVar.zzu().iterator();
            while (it9.hasNext()) {
                zzoyVar.zzi((zzot) arrayList3.get(it9.next().intValue()));
            }
            Iterator<Integer> it10 = zzeVar.zzw().iterator();
            while (it10.hasNext()) {
                zzoyVar.zzcw(zziVar.zzpj[it10.next().intValue()].string);
            }
            zzmn.zzb(zzoyVar.zzms());
        }
        zzmn.zzcs(zziVar.version);
        zzmn.zzaf(zziVar.zzpw);
        return zzmn.zzmp();
    }

    private static void zzcf(String str) throws zzoz {
        com.google.android.gms.tagmanager.zzdi.c(str);
        throw new zzoz(str);
    }

    public static zzl zzk(zzl zzlVar) {
        zzl zzlVar2 = new zzl();
        zzlVar2.type = zzlVar.type;
        zzlVar2.zzqv = (int[]) zzlVar.zzqv.clone();
        boolean z = zzlVar.zzqw;
        if (z) {
            zzlVar2.zzqw = z;
        }
        return zzlVar2;
    }

    private static zzg.zza zzl(zzl zzlVar) throws zzoz {
        if (((zzg.zza) zzlVar.zza(zzg.zza.zzpx)) != null) {
            return (zzg.zza) zzlVar.zza(zzg.zza.zzpx);
        }
        String valueOf = String.valueOf(zzlVar);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 54);
        sb.append("Expected a ServingValue and didn't get one. Value is: ");
        sb.append(valueOf);
        zzcf(sb.toString());
        throw null;
    }

    private static zzl zza(int i, zzi zziVar, zzl[] zzlVarArr, Set<Integer> set) throws zzoz {
        zzl zzlVar;
        if (!set.contains(Integer.valueOf(i))) {
            zzl zzlVar2 = (zzl) zza(zziVar.zzpj, i, "values");
            if (zzlVarArr[i] != null) {
                return zzlVarArr[i];
            }
            set.add(Integer.valueOf(i));
            int i2 = 0;
            switch (zzlVar2.type) {
                case 1:
                case 5:
                case 6:
                case 8:
                    zzlVar = zzlVar2;
                    break;
                case 2:
                    zzg.zza zzl = zzl(zzlVar2);
                    zzl zzk = zzk(zzlVar2);
                    int[] iArr = zzl.zzpz;
                    zzk.zzqn = new zzl[iArr.length];
                    int length = iArr.length;
                    int i3 = 0;
                    while (i2 < length) {
                        int i4 = i3 + 1;
                        zzk.zzqn[i3] = zza(iArr[i2], zziVar, zzlVarArr, set);
                        i2++;
                        i3 = i4;
                    }
                    zzlVar = zzk;
                    break;
                case 3:
                    zzlVar = zzk(zzlVar2);
                    zzg.zza zzl2 = zzl(zzlVar2);
                    int[] iArr2 = zzl2.zzqa;
                    int length2 = iArr2.length;
                    int[] iArr3 = zzl2.zzqb;
                    if (length2 == iArr3.length) {
                        zzlVar.zzqo = new zzl[iArr2.length];
                        zzlVar.zzqp = new zzl[iArr2.length];
                        int length3 = iArr2.length;
                        int i5 = 0;
                        int i6 = 0;
                        while (i5 < length3) {
                            zzlVar.zzqo[i6] = zza(iArr2[i5], zziVar, zzlVarArr, set);
                            i5++;
                            i6++;
                        }
                        int[] iArr4 = zzl2.zzqb;
                        int length4 = iArr4.length;
                        int i7 = 0;
                        while (i2 < length4) {
                            zzlVar.zzqp[i7] = zza(iArr4[i2], zziVar, zzlVarArr, set);
                            i2++;
                            i7++;
                        }
                        break;
                    } else {
                        int length5 = iArr2.length;
                        int length6 = iArr3.length;
                        StringBuilder sb = new StringBuilder(58);
                        sb.append("Uneven map keys (");
                        sb.append(length5);
                        sb.append(") and map values (");
                        sb.append(length6);
                        sb.append(")");
                        zzcf(sb.toString());
                        throw null;
                    }
                case 4:
                    zzlVar = zzk(zzlVar2);
                    zzlVar.zzqq = zzgj.a(zza(zzl(zzlVar2).zzqe, zziVar, zzlVarArr, set));
                    break;
                case 7:
                    zzlVar = zzk(zzlVar2);
                    int[] iArr5 = zzl(zzlVar2).zzqd;
                    zzlVar.zzqu = new zzl[iArr5.length];
                    int length7 = iArr5.length;
                    int i8 = 0;
                    while (i2 < length7) {
                        zzlVar.zzqu[i8] = zza(iArr5[i2], zziVar, zzlVarArr, set);
                        i2++;
                        i8++;
                    }
                    break;
                default:
                    zzlVar = null;
                    break;
            }
            if (zzlVar != null) {
                zzlVarArr[i] = zzlVar;
                set.remove(Integer.valueOf(i));
                return zzlVar;
            }
            String valueOf = String.valueOf(zzlVar2);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 15);
            sb2.append("Invalid value: ");
            sb2.append(valueOf);
            zzcf(sb2.toString());
            throw null;
        }
        String valueOf2 = String.valueOf(set);
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 90);
        sb3.append("Value cycle detected.  Current value reference: ");
        sb3.append(i);
        sb3.append(".  Previous value references: ");
        sb3.append(valueOf2);
        sb3.append(".");
        zzcf(sb3.toString());
        throw null;
    }

    private static <T> T zza(T[] tArr, int i, String str) throws zzoz {
        if (i >= 0 && i < tArr.length) {
            return tArr[i];
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 45);
        sb.append("Index out of bounds detected: ");
        sb.append(i);
        sb.append(" in ");
        sb.append(str);
        zzcf(sb.toString());
        throw null;
    }

    private static zzot zza(zzc.zzb zzbVar, zzi zziVar, zzl[] zzlVarArr, int i) throws zzoz {
        zzou zzml = zzot.zzml();
        Iterator<Integer> it = zzbVar.zze().iterator();
        while (it.hasNext()) {
            zzc.zzd zzdVar = (zzc.zzd) zza(zziVar.zzpk, it.next().intValue(), "properties");
            String str = (String) zza(zziVar.zzpi, zzdVar.zzl(), "keys");
            zzl zzlVar = (zzl) zza(zzlVarArr, zzdVar.getValue(), "values");
            if (zzb.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzml.zzm(zzlVar);
            } else {
                zzml.zzb(str, zzlVar);
            }
        }
        return zzml.zzmm();
    }

    public static void zza(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }
}
