package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzahm {
    private final Map<C1007na, C1021oa> zzdhe = new HashMap();
    private final LinkedList<C1007na> zzdhf = new LinkedList<>();
    private zzagi zzdhg;

    private static String[] zzbz(String str) {
        try {
            String[] split = str.split("\u0000");
            for (int i = 0; i < split.length; i++) {
                split[i] = new String(Base64.decode(split[i], 0), "UTF-8");
            }
            return split;
        } catch (UnsupportedEncodingException unused) {
            return new String[0];
        }
    }

    private static boolean zzca(String str) {
        try {
            return Pattern.matches((String) zzwu.zzpz().zzd(zzaan.zzcsg), str);
        } catch (RuntimeException e2) {
            com.google.android.gms.ads.internal.zzbv.i().zza(e2, "InterstitialAdPool.isExcludedAdUnit");
            return false;
        }
    }

    @VisibleForTesting
    private static String zzcb(String str) {
        try {
            Matcher matcher = Pattern.compile("([^/]+/[0-9]+).*").matcher(str);
            return matcher.matches() ? matcher.group(1) : str;
        } catch (RuntimeException unused) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set<String> zzh(zzwb zzwbVar) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(zzwbVar.extras.keySet());
        Bundle bundle = zzwbVar.zzcjl.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            hashSet.addAll(bundle.keySet());
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzwb zzi(zzwb zzwbVar) {
        zzwb zzk = zzk(zzwbVar);
        Bundle bundle = zzk.zzcjl.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            bundle.putBoolean("_skipMediation", true);
        }
        zzk.extras.putBoolean("_skipMediation", true);
        return zzk;
    }

    @VisibleForTesting
    private static zzwb zzj(zzwb zzwbVar) {
        zzwb zzk = zzk(zzwbVar);
        for (String str : ((String) zzwu.zzpz().zzd(zzaan.zzcsc)).split(",")) {
            zzb(zzk.zzcjl, str);
            if (str.startsWith("com.google.ads.mediation.admob.AdMobAdapter/")) {
                zzb(zzk.extras, str.replaceFirst("com.google.ads.mediation.admob.AdMobAdapter/", ""));
            }
        }
        return zzk;
    }

    @VisibleForTesting
    private static zzwb zzk(zzwb zzwbVar) {
        Parcel obtain = Parcel.obtain();
        zzwbVar.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        zzwb createFromParcel = zzwb.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel.zzpm();
    }

    private final String zzti() {
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<C1007na> it = this.zzdhf.iterator();
            while (it.hasNext()) {
                sb.append(Base64.encodeToString(it.next().toString().getBytes("UTF-8"), 0));
                if (it.hasNext()) {
                    sb.append("\u0000");
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzagi zzagiVar) {
        if (this.zzdhg == null) {
            this.zzdhg = zzagiVar.zztg();
            zzagi zzagiVar2 = this.zzdhg;
            if (zzagiVar2 != null) {
                SharedPreferences sharedPreferences = zzagiVar2.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
                while (this.zzdhf.size() > 0) {
                    C1007na remove = this.zzdhf.remove();
                    C1021oa c1021oa = this.zzdhe.get(remove);
                    zza("Flushing interstitial queue for %s.", remove);
                    while (c1021oa.c() > 0) {
                        c1021oa.a((zzwb) null).f12413a.B();
                    }
                    this.zzdhe.remove(remove);
                }
                try {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                        if (!entry.getKey().equals("PoolKeys")) {
                            C1049qa a2 = C1049qa.a((String) entry.getValue());
                            C1007na c1007na = new C1007na(a2.f12444a, a2.f12445b, a2.f12446c);
                            if (!this.zzdhe.containsKey(c1007na)) {
                                this.zzdhe.put(c1007na, new C1021oa(a2.f12444a, a2.f12445b, a2.f12446c));
                                hashMap.put(c1007na.toString(), c1007na);
                                zza("Restored interstitial queue for %s.", c1007na);
                            }
                        }
                    }
                    for (String str : zzbz(sharedPreferences.getString("PoolKeys", ""))) {
                        C1007na c1007na2 = (C1007na) hashMap.get(str);
                        if (this.zzdhe.containsKey(c1007na2)) {
                            this.zzdhf.add(c1007na2);
                        }
                    }
                } catch (IOException | RuntimeException e2) {
                    com.google.android.gms.ads.internal.zzbv.i().zza(e2, "InterstitialAdPool.restore");
                    zzbbd.zzc("Malformed preferences value for InterstitialAdPool.", e2);
                    this.zzdhe.clear();
                    this.zzdhf.clear();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzwb zzwbVar, String str) {
        zzagi zzagiVar = this.zzdhg;
        if (zzagiVar == null) {
            return;
        }
        int i = new zzaua(zzagiVar.getApplicationContext()).zzwx().zzedd;
        zzwb zzj = zzj(zzwbVar);
        String zzcb = zzcb(str);
        C1007na c1007na = new C1007na(zzj, zzcb, i);
        C1021oa c1021oa = this.zzdhe.get(c1007na);
        if (c1021oa == null) {
            zza("Interstitial pool created at %s.", c1007na);
            c1021oa = new C1021oa(zzj, zzcb, i);
            this.zzdhe.put(c1007na, c1021oa);
        }
        c1021oa.a(this.zzdhg, zzwbVar);
        c1021oa.g();
        zza("Inline entry added to the queue at %s.", c1007na);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzth() {
        int c2;
        int e2;
        if (this.zzdhg == null) {
            return;
        }
        for (Map.Entry<C1007na, C1021oa> entry : this.zzdhe.entrySet()) {
            C1007na key = entry.getKey();
            C1021oa value = entry.getValue();
            if (zzbbd.isLoggable(2) && (e2 = value.e()) < (c2 = value.c())) {
                zzaxz.v(String.format("Loading %s/%s pooled interstitials for %s.", Integer.valueOf(c2 - e2), Integer.valueOf(c2), key));
            }
            int f2 = value.f() + 0;
            while (value.c() < ((Integer) zzwu.zzpz().zzd(zzaan.zzcse)).intValue()) {
                zza("Pooling and loading one new interstitial for %s.", key);
                if (value.a(this.zzdhg)) {
                    f2++;
                }
            }
            zzahq.zzto().zzcn(f2);
        }
        zzagi zzagiVar = this.zzdhg;
        if (zzagiVar != null) {
            SharedPreferences.Editor edit = zzagiVar.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
            edit.clear();
            for (Map.Entry<C1007na, C1021oa> entry2 : this.zzdhe.entrySet()) {
                C1007na key2 = entry2.getKey();
                C1021oa value2 = entry2.getValue();
                if (value2.h()) {
                    edit.putString(key2.toString(), new C1049qa(value2).a());
                    zza("Saved interstitial queue for %s.", key2);
                }
            }
            edit.putString("PoolKeys", zzti());
            edit.apply();
        }
    }

    private static void zzb(Bundle bundle, String str) {
        while (true) {
            String[] split = str.split("/", 2);
            if (split.length == 0) {
                return;
            }
            String str2 = split[0];
            if (split.length == 1) {
                bundle.remove(str2);
                return;
            }
            bundle = bundle.getBundle(str2);
            if (bundle == null) {
                return;
            } else {
                str = split[1];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final C1035pa zza(zzwb zzwbVar, String str) {
        if (zzca(str)) {
            return null;
        }
        int i = new zzaua(this.zzdhg.getApplicationContext()).zzwx().zzedd;
        zzwb zzj = zzj(zzwbVar);
        String zzcb = zzcb(str);
        C1007na c1007na = new C1007na(zzj, zzcb, i);
        C1021oa c1021oa = this.zzdhe.get(c1007na);
        if (c1021oa == null) {
            zza("Interstitial pool created at %s.", c1007na);
            c1021oa = new C1021oa(zzj, zzcb, i);
            this.zzdhe.put(c1007na, c1021oa);
        }
        this.zzdhf.remove(c1007na);
        this.zzdhf.add(c1007na);
        c1021oa.g();
        while (this.zzdhf.size() > ((Integer) zzwu.zzpz().zzd(zzaan.zzcsd)).intValue()) {
            C1007na remove = this.zzdhf.remove();
            C1021oa c1021oa2 = this.zzdhe.get(remove);
            zza("Evicting interstitial queue for %s.", remove);
            while (c1021oa2.c() > 0) {
                C1035pa a2 = c1021oa2.a((zzwb) null);
                if (a2.f12417e) {
                    zzahq.zzto().zztq();
                }
                a2.f12413a.B();
            }
            this.zzdhe.remove(remove);
        }
        while (c1021oa.c() > 0) {
            C1035pa a3 = c1021oa.a(zzj);
            if (a3.f12417e) {
                if (com.google.android.gms.ads.internal.zzbv.l().a() - a3.f12416d > ((Integer) zzwu.zzpz().zzd(zzaan.zzcsf)).intValue() * 1000) {
                    zza("Expired interstitial at %s.", c1007na);
                    zzahq.zzto().zztp();
                }
            }
            String str2 = a3.f12414b != null ? " (inline) " : " ";
            StringBuilder sb = new StringBuilder(str2.length() + 34);
            sb.append("Pooled interstitial");
            sb.append(str2);
            sb.append("returned at %s.");
            zza(sb.toString(), c1007na);
            return a3;
        }
        return null;
    }

    private static void zza(String str, C1007na c1007na) {
        if (zzbbd.isLoggable(2)) {
            zzaxz.v(String.format(str, c1007na));
        }
    }
}
