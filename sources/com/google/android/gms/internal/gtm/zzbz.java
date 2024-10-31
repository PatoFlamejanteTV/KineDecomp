package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.config.GservicesValue;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzbz<V> {
    private final V zzaar;
    private final GservicesValue<V> zzaas;

    private zzbz(GservicesValue<V> gservicesValue, V v) {
        Preconditions.a(gservicesValue);
        this.zzaas = gservicesValue;
        this.zzaar = v;
    }

    public static zzbz<Boolean> zza(String str, boolean z, boolean z2) {
        return new zzbz<>(GservicesValue.a(str, z2), Boolean.valueOf(z));
    }

    public final V get() {
        return this.zzaar;
    }

    public static zzbz<String> zza(String str, String str2, String str3) {
        return new zzbz<>(GservicesValue.a(str, str3), str2);
    }

    public static zzbz<Long> zza(String str, long j, long j2) {
        return new zzbz<>(GservicesValue.a(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    public static zzbz<Integer> zza(String str, int i, int i2) {
        return new zzbz<>(GservicesValue.a(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    public static zzbz<Float> zza(String str, float f2, float f3) {
        Float valueOf = Float.valueOf(0.5f);
        return new zzbz<>(GservicesValue.a(str, valueOf), valueOf);
    }
}
