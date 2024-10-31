package com.google.android.gms.internal.gtm;

import java.util.Iterator;

/* loaded from: classes2.dex */
final class tb implements Iterator<String> {

    /* renamed from: a */
    private Iterator<String> f13300a;

    /* renamed from: b */
    private final /* synthetic */ zztu f13301b;

    public tb(zztu zztuVar) {
        zzrt zzrtVar;
        this.f13301b = zztuVar;
        zzrtVar = this.f13301b.zzbeo;
        this.f13300a = zzrtVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13300a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f13300a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
