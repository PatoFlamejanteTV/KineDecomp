package com.google.android.gms.internal.clearcut;

/* loaded from: classes2.dex */
final class T extends O {
    /* JADX INFO: Access modifiers changed from: private */
    public T() {
        super();
    }

    public /* synthetic */ T(P p) {
        this();
    }

    private static <E> zzcn<E> b(Object obj, long j) {
        return (zzcn) La.f(obj, j);
    }

    @Override // com.google.android.gms.internal.clearcut.O
    public final void a(Object obj, long j) {
        b(obj, j).zzv();
    }

    @Override // com.google.android.gms.internal.clearcut.O
    public final <E> void a(Object obj, Object obj2, long j) {
        zzcn b2 = b(obj, j);
        zzcn b3 = b(obj2, j);
        int size = b2.size();
        int size2 = b3.size();
        if (size > 0 && size2 > 0) {
            if (!b2.zzu()) {
                b2 = b2.zzi(size2 + size);
            }
            b2.addAll(b3);
        }
        if (size > 0) {
            b3 = b2;
        }
        La.a(obj, j, b3);
    }
}
