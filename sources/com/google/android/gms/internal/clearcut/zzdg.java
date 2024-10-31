package com.google.android.gms.internal.clearcut;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzdg<K, V> {
    static <K, V> int zza(Y<K, V> y, K k, V v) {
        return F.a(y.f12819a, 1, k) + F.a(y.f12820b, 2, v);
    }

    static <K, V> void zza(zzbn zzbnVar, Y<K, V> y, K k, V v) throws IOException {
        F.a(zzbnVar, y.f12819a, 1, k);
        F.a(zzbnVar, y.f12820b, 2, v);
    }
}
