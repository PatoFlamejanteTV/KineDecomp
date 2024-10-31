package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public abstract class zzaac<T> {
    private final String mKey;
    private final int zzcni;
    private final T zzcnj;

    private zzaac(int i, String str, T t) {
        this.zzcni = i;
        this.mKey = str;
        this.zzcnj = t;
        zzwu.zzpy().zza(this);
    }

    public static zzaac<Boolean> zza(int i, String str, Boolean bool) {
        return new C0822a(i, str, bool);
    }

    public static zzaac<String> zzb(int i, String str) {
        zzaac<String> zza = zza(i, str, (String) null);
        zzwu.zzpy().zzb(zza);
        return zza;
    }

    public static zzaac<String> zzc(int i, String str) {
        zzaac<String> zza = zza(i, str, (String) null);
        zzwu.zzpy().zzc(zza);
        return zza;
    }

    public final String getKey() {
        return this.mKey;
    }

    public final int getSource() {
        return this.zzcni;
    }

    public abstract T zza(SharedPreferences sharedPreferences);

    public abstract void zza(SharedPreferences.Editor editor, T t);

    public abstract T zzb(JSONObject jSONObject);

    public final T zzqv() {
        return this.zzcnj;
    }

    public static zzaac<Integer> zza(int i, String str, int i2) {
        return new C0837b(i, str, Integer.valueOf(i2));
    }

    public static zzaac<Long> zza(int i, String str, long j) {
        return new C0852c(i, str, Long.valueOf(j));
    }

    public static zzaac<Float> zza(int i, String str, float f2) {
        return new C0867d(i, str, Float.valueOf(f2));
    }

    public static zzaac<String> zza(int i, String str, String str2) {
        return new C0881e(i, str, str2);
    }

    public /* synthetic */ zzaac(int i, String str, Object obj, C0822a c0822a) {
        this(i, str, obj);
    }
}
