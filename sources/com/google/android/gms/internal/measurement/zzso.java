package com.google.android.gms.internal.measurement;

import android.net.Uri;

/* loaded from: classes2.dex */
public final class zzso {
    private final String zzbrs;
    private final Uri zzbrt;
    private final String zzbru;
    private final String zzbrv;
    private final boolean zzbrw;
    private final boolean zzbrx;
    private final boolean zzbry;

    public zzso(Uri uri) {
        this(null, uri, "", "", false, false, false);
    }

    public final zzsi<Double> zzb(String str, double d2) {
        zzsi<Double> zza;
        zza = zzsi.zza(this, str, d2);
        return zza;
    }

    public final zzsi<Boolean> zzd(String str, boolean z) {
        zzsi<Boolean> zza;
        zza = zzsi.zza(this, str, z);
        return zza;
    }

    public final zzsi<Long> zze(String str, long j) {
        zzsi<Long> zza;
        zza = zzsi.zza(this, str, j);
        return zza;
    }

    public final zzsi<String> zzy(String str, String str2) {
        zzsi<String> zza;
        zza = zzsi.zza(this, str, str2);
        return zza;
    }

    private zzso(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3) {
        this.zzbrs = null;
        this.zzbrt = uri;
        this.zzbru = str2;
        this.zzbrv = str3;
        this.zzbrw = false;
        this.zzbrx = false;
        this.zzbry = false;
    }

    public final zzsi<Integer> zzd(String str, int i) {
        zzsi<Integer> zza;
        zza = zzsi.zza(this, str, i);
        return zza;
    }
}
