package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes2.dex */
final class Zh extends Wh {
    /* JADX INFO: Access modifiers changed from: private */
    public Zh() {
        super();
    }

    private static <E> zzbrk<E> c(Object obj, long j) {
        return (zzbrk) Pi.f(obj, j);
    }

    @Override // com.google.android.gms.internal.ads.Wh
    public final <L> List<L> a(Object obj, long j) {
        zzbrk c2 = c(obj, j);
        if (c2.zzaki()) {
            return c2;
        }
        int size = c2.size();
        zzbrk zzel = c2.zzel(size == 0 ? 10 : size << 1);
        Pi.a(obj, j, zzel);
        return zzel;
    }

    @Override // com.google.android.gms.internal.ads.Wh
    public final void b(Object obj, long j) {
        c(obj, j).zzakj();
    }

    public /* synthetic */ Zh(Xh xh) {
        this();
    }

    @Override // com.google.android.gms.internal.ads.Wh
    public final <E> void a(Object obj, Object obj2, long j) {
        zzbrk c2 = c(obj, j);
        zzbrk c3 = c(obj2, j);
        int size = c2.size();
        int size2 = c3.size();
        if (size > 0 && size2 > 0) {
            if (!c2.zzaki()) {
                c2 = c2.zzel(size2 + size);
            }
            c2.addAll(c3);
        }
        if (size > 0) {
            c3 = c2;
        }
        Pi.a(obj, j, c3);
    }
}
