package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzsc<K, V> {
    static <K, V> void zza(zzqj zzqjVar, Ka<K, V> ka, K k, V v) throws IOException {
        C1330sa.a(zzqjVar, ka.f13163a, 1, k);
        C1330sa.a(zzqjVar, ka.f13164b, 2, v);
    }

    static <K, V> int zza(Ka<K, V> ka, K k, V v) {
        return C1330sa.a(ka.f13163a, 1, k) + C1330sa.a(ka.f13164b, 2, v);
    }
}
