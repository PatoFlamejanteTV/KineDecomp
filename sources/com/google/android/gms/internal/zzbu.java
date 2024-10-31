package com.google.android.gms.internal;

import android.content.SharedPreferences;

@zzgr
/* loaded from: classes.dex */
public abstract class zzbu<T> {
    private final String zzue;
    private final T zzuf;

    private zzbu(String str, T t) {
        this.zzue = str;
        this.zzuf = t;
        com.google.android.gms.ads.internal.zzp.m().zza(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbu(String str, Object obj, aa aaVar) {
        this(str, obj);
    }

    public static zzbu<String> zzP(String str) {
        zzbu<String> zzc = zzc(str, (String) null);
        com.google.android.gms.ads.internal.zzp.m().zzb(zzc);
        return zzc;
    }

    public static zzbu<String> zzQ(String str) {
        zzbu<String> zzc = zzc(str, (String) null);
        com.google.android.gms.ads.internal.zzp.m().zzc(zzc);
        return zzc;
    }

    public static zzbu<Integer> zza(String str, int i) {
        return new ab(str, Integer.valueOf(i));
    }

    public static zzbu<Boolean> zza(String str, Boolean bool) {
        return new aa(str, bool);
    }

    public static zzbu<Long> zzb(String str, long j) {
        return new ac(str, Long.valueOf(j));
    }

    public static zzbu<String> zzc(String str, String str2) {
        return new ad(str, str2);
    }

    public T get() {
        return (T) com.google.android.gms.ads.internal.zzp.n().zzd(this);
    }

    public String getKey() {
        return this.zzue;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T zza(SharedPreferences sharedPreferences);

    public T zzde() {
        return this.zzuf;
    }
}
