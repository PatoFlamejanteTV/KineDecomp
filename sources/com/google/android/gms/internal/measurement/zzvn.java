package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzvn<K, V> {
    static <K, V> void zza(zztv zztvVar, Ma<K, V> ma, K k, V v) throws IOException {
        C1393ua.a(zztvVar, ma.f13384a, 1, k);
        C1393ua.a(zztvVar, ma.f13385b, 2, v);
    }

    static <K, V> int zza(Ma<K, V> ma, K k, V v) {
        return C1393ua.a(ma.f13384a, 1, k) + C1393ua.a(ma.f13385b, 2, v);
    }
}
