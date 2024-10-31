package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Ba<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a */
    private Iterator<Map.Entry<K, Object>> f13129a;

    public Ba(Iterator<Map.Entry<K, Object>> it) {
        this.f13129a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13129a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f13129a.next();
        return next.getValue() instanceof zzrn ? new Aa(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f13129a.remove();
    }
}
