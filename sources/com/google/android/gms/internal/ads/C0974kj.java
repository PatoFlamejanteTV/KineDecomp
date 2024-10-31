package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ads.kj */
/* loaded from: classes2.dex */
final class C0974kj<E> implements Iterator<E> {

    /* renamed from: a */
    private int f12269a = 0;

    /* renamed from: b */
    private final /* synthetic */ zzbwe f12270b;

    public C0974kj(zzbwe zzbweVar) {
        this.f12270b = zzbweVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12269a < this.f12270b.zzgct.size() || this.f12270b.zzgcu.hasNext();
    }

    @Override // java.util.Iterator
    public final E next() {
        while (this.f12269a >= this.f12270b.zzgct.size()) {
            zzbwe zzbweVar = this.f12270b;
            zzbweVar.zzgct.add(zzbweVar.zzgcu.next());
        }
        List<E> list = this.f12270b.zzgct;
        int i = this.f12269a;
        this.f12269a = i + 1;
        return list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
