package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.firebase_auth.la */
/* loaded from: classes2.dex */
final class C1261la implements Iterator<zzeq> {

    /* renamed from: a */
    private final ArrayDeque<zzhs> f13044a;

    /* renamed from: b */
    private zzeq f13045b;

    private C1261la(zzeh zzehVar) {
        this.f13044a = new ArrayDeque<>();
        this.f13045b = a(zzehVar);
    }

    private final zzeq a(zzeh zzehVar) {
        while (zzehVar instanceof zzhs) {
            zzhs zzhsVar = (zzhs) zzehVar;
            this.f13044a.push(zzhsVar);
            zzehVar = zzhsVar.zzaak;
        }
        return (zzeq) zzehVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13045b != null;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ zzeq next() {
        zzeq zzeqVar;
        zzeh zzehVar;
        zzeq zzeqVar2 = this.f13045b;
        if (zzeqVar2 == null) {
            throw new NoSuchElementException();
        }
        while (true) {
            if (this.f13044a.isEmpty()) {
                zzeqVar = null;
                break;
            }
            zzehVar = this.f13044a.pop().zzaal;
            zzeqVar = a(zzehVar);
            if (!(zzeqVar.size() == 0)) {
                break;
            }
        }
        this.f13045b = zzeqVar;
        return zzeqVar2;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ C1261la(zzeh zzehVar, C1257ja c1257ja) {
        this(zzehVar);
    }
}
