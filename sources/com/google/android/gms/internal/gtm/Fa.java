package com.google.android.gms.internal.gtm;

import java.util.List;

/* loaded from: classes2.dex */
final class Fa extends Ca {
    /* JADX INFO: Access modifiers changed from: private */
    public Fa() {
        super();
    }

    private static <E> zzrj<E> c(Object obj, long j) {
        return (zzrj) ub.f(obj, j);
    }

    @Override // com.google.android.gms.internal.gtm.Ca
    public final <L> List<L> a(Object obj, long j) {
        zzrj c2 = c(obj, j);
        if (c2.zzmy()) {
            return c2;
        }
        int size = c2.size();
        zzrj zzaj = c2.zzaj(size == 0 ? 10 : size << 1);
        ub.a(obj, j, zzaj);
        return zzaj;
    }

    @Override // com.google.android.gms.internal.gtm.Ca
    public final void b(Object obj, long j) {
        c(obj, j).zzmi();
    }

    public /* synthetic */ Fa(Da da) {
        this();
    }

    @Override // com.google.android.gms.internal.gtm.Ca
    public final <E> void a(Object obj, Object obj2, long j) {
        zzrj c2 = c(obj, j);
        zzrj c3 = c(obj2, j);
        int size = c2.size();
        int size2 = c3.size();
        if (size > 0 && size2 > 0) {
            if (!c2.zzmy()) {
                c2 = c2.zzaj(size2 + size);
            }
            c2.addAll(c3);
        }
        if (size > 0) {
            c3 = c2;
        }
        ub.a(obj, j, c3);
    }
}
