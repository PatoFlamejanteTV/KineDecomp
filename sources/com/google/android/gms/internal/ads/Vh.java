package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Vh<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a */
    private Iterator<Map.Entry<K, Object>> f11911a;

    public Vh(Iterator<Map.Entry<K, Object>> it) {
        this.f11911a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11911a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f11911a.next();
        return next.getValue() instanceof zzbro ? new Uh(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f11911a.remove();
    }
}
