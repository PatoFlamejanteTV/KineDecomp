package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class N<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a */
    private Iterator<Map.Entry<K, Object>> f12802a;

    public N(Iterator<Map.Entry<K, Object>> it) {
        this.f12802a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12802a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f12802a.next();
        return next.getValue() instanceof zzcr ? new M(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f12802a.remove();
    }
}
