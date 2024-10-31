package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class zzyy {
    private String zzcjt;
    private String zzcjz;
    private String zzckb;
    private String zzckf;
    private boolean zzckh;
    private Date zzih;
    private Location zzil;
    private final HashSet<String> zzcmf = new HashSet<>();
    private final Bundle zzclz = new Bundle();
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzcmg = new HashMap<>();
    private final HashSet<String> zzcmh = new HashSet<>();
    private final Bundle zzckd = new Bundle();
    private final HashSet<String> zzcmi = new HashSet<>();
    private int zzcjv = -1;
    private boolean zzbli = false;
    private int zzcjy = -1;
    private int zzcjs = -1;

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbli = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public final void zza(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).a());
        } else {
            this.zzcmg.put(networkExtras.getClass(), networkExtras);
        }
    }

    public final void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
        if (this.zzclz.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.zzclz.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        this.zzclz.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
    }

    public final void zzbd(String str) {
        this.zzcmf.add(str);
    }

    public final void zzbe(String str) {
        this.zzcmh.add(str);
    }

    public final void zzbf(String str) {
        this.zzcmh.remove(str);
    }

    public final void zzbg(String str) {
        this.zzckb = str;
    }

    public final void zzbh(String str) {
        this.zzcjz = str;
    }

    public final void zzbi(String str) {
        this.zzckf = str;
    }

    public final void zzbj(String str) {
        this.zzcmi.add(str);
    }

    public final void zzbk(String str) {
        if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
            this.zzcjt = str;
        }
    }

    @Deprecated
    public final void zzch(int i) {
        this.zzcjv = i;
    }

    public final void zzci(int i) {
        if (i == -1 || i == 0 || i == 1) {
            this.zzcjs = i;
        }
    }

    public final void zze(String str, String str2) {
        this.zzckd.putString(str, str2);
    }

    public final void zzu(boolean z) {
        this.zzcjy = z ? 1 : 0;
    }

    @Deprecated
    public final void zzv(boolean z) {
        this.zzckh = z;
    }

    public final void zza(Class<? extends MediationAdapter> cls, Bundle bundle) {
        this.zzclz.putBundle(cls.getName(), bundle);
    }

    public final void zzb(Location location) {
        this.zzil = location;
    }

    @Deprecated
    public final void zza(Date date) {
        this.zzih = date;
    }
}
