package com.google.android.gms.internal.firebase_auth;

import java.util.List;

/* loaded from: classes2.dex */
final class M extends J {
    /* JADX INFO: Access modifiers changed from: private */
    public M() {
        super();
    }

    private static <E> zzgb<E> c(Object obj, long j) {
        return (zzgb) Ja.f(obj, j);
    }

    @Override // com.google.android.gms.internal.firebase_auth.J
    public final <L> List<L> a(Object obj, long j) {
        zzgb c2 = c(obj, j);
        if (c2.zzeu()) {
            return c2;
        }
        int size = c2.size();
        zzgb zzj = c2.zzj(size == 0 ? 10 : size << 1);
        Ja.a(obj, j, zzj);
        return zzj;
    }

    @Override // com.google.android.gms.internal.firebase_auth.J
    public final void b(Object obj, long j) {
        c(obj, j).zzev();
    }

    public /* synthetic */ M(K k) {
        this();
    }

    @Override // com.google.android.gms.internal.firebase_auth.J
    public final <E> void a(Object obj, Object obj2, long j) {
        zzgb c2 = c(obj, j);
        zzgb c3 = c(obj2, j);
        int size = c2.size();
        int size2 = c3.size();
        if (size > 0 && size2 > 0) {
            if (!c2.zzeu()) {
                c2 = c2.zzj(size2 + size);
            }
            c2.addAll(c3);
        }
        if (size > 0) {
            c3 = c2;
        }
        Ja.a(obj, j, c3);
    }
}
