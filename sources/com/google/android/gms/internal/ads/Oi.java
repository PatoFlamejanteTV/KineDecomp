package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* loaded from: classes2.dex */
final class Oi implements Iterator<String> {

    /* renamed from: a */
    private Iterator<String> f11737a;

    /* renamed from: b */
    private final /* synthetic */ zzbtx f11738b;

    public Oi(zzbtx zzbtxVar) {
        zzbru zzbruVar;
        this.f11738b = zzbtxVar;
        zzbruVar = this.f11738b.zzftz;
        this.f11737a = zzbruVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11737a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f11737a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
