package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
final class Ha extends Ea {
    /* JADX INFO: Access modifiers changed from: private */
    public Ha() {
        super();
    }

    private static <E> zzuu<E> c(Object obj, long j) {
        return (zzuu) xb.f(obj, j);
    }

    @Override // com.google.android.gms.internal.measurement.Ea
    public final <L> List<L> a(Object obj, long j) {
        zzuu c2 = c(obj, j);
        if (c2.zztz()) {
            return c2;
        }
        int size = c2.size();
        zzuu zzal = c2.zzal(size == 0 ? 10 : size << 1);
        xb.a(obj, j, zzal);
        return zzal;
    }

    @Override // com.google.android.gms.internal.measurement.Ea
    public final void b(Object obj, long j) {
        c(obj, j).zzsw();
    }

    public /* synthetic */ Ha(Fa fa) {
        this();
    }

    @Override // com.google.android.gms.internal.measurement.Ea
    public final <E> void a(Object obj, Object obj2, long j) {
        zzuu c2 = c(obj, j);
        zzuu c3 = c(obj2, j);
        int size = c2.size();
        int size2 = c3.size();
        if (size > 0 && size2 > 0) {
            if (!c2.zztz()) {
                c2 = c2.zzal(size2 + size);
            }
            c2.addAll(c3);
        }
        if (size > 0) {
            c3 = c2;
        }
        xb.a(obj, j, c3);
    }
}
