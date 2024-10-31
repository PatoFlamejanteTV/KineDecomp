package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Da<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a */
    private Iterator<Map.Entry<K, Object>> f13360a;

    public Da(Iterator<Map.Entry<K, Object>> it) {
        this.f13360a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13360a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f13360a.next();
        return next.getValue() instanceof zzuy ? new Ca(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f13360a.remove();
    }
}
