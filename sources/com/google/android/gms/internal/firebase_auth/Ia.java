package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;

/* loaded from: classes2.dex */
final class Ia implements Iterator<String> {

    /* renamed from: a */
    private Iterator<String> f12970a;

    /* renamed from: b */
    private final /* synthetic */ zzit f12971b;

    public Ia(zzit zzitVar) {
        zzgl zzglVar;
        this.f12971b = zzitVar;
        zzglVar = this.f12971b.zzabr;
        this.f12970a = zzglVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12970a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f12970a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
