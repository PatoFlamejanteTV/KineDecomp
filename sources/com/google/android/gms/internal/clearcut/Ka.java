package com.google.android.gms.internal.clearcut;

import java.util.Iterator;

/* loaded from: classes2.dex */
final class Ka implements Iterator<String> {

    /* renamed from: a */
    private Iterator<String> f12790a;

    /* renamed from: b */
    private final /* synthetic */ zzfa f12791b;

    public Ka(zzfa zzfaVar) {
        zzcx zzcxVar;
        this.f12791b = zzfaVar;
        zzcxVar = this.f12791b.zzpb;
        this.f12790a = zzcxVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12790a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f12790a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
