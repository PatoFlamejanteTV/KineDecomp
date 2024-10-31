package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* loaded from: classes2.dex */
final class wb implements Iterator<String> {

    /* renamed from: a */
    private Iterator<String> f13546a;

    /* renamed from: b */
    private final /* synthetic */ zzxg f13547b;

    public wb(zzxg zzxgVar) {
        zzve zzveVar;
        this.f13547b = zzxgVar;
        zzveVar = this.f13547b.zzcch;
        this.f13546a = zzveVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13546a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f13546a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
