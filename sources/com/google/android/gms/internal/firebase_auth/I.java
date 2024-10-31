package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class I<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a */
    private Iterator<Map.Entry<K, Object>> f12969a;

    public I(Iterator<Map.Entry<K, Object>> it) {
        this.f12969a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12969a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f12969a.next();
        return next.getValue() instanceof zzgf ? new H(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f12969a.remove();
    }
}
