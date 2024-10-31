package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzgu<K, V> {
    static <K, V> void zza(zzfa zzfaVar, S<K, V> s, K k, V v) throws IOException {
        C1287z.a(zzfaVar, s.f12992a, 1, k);
        C1287z.a(zzfaVar, s.f12993b, 2, v);
    }

    static <K, V> int zza(S<K, V> s, K k, V v) {
        return C1287z.a(s.f12992a, 1, k) + C1287z.a(s.f12993b, 2, v);
    }
}
