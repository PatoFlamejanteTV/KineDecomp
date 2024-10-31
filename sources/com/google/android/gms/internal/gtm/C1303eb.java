package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.gtm.eb */
/* loaded from: classes2.dex */
final class C1303eb<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a */
    private int f13226a;

    /* renamed from: b */
    private Iterator<Map.Entry<K, V>> f13227b;

    /* renamed from: c */
    private final /* synthetic */ C1297cb f13228c;

    private C1303eb(C1297cb c1297cb) {
        List list;
        this.f13228c = c1297cb;
        list = this.f13228c.f13217b;
        this.f13226a = list.size();
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f13227b == null) {
            map = this.f13228c.f13221f;
            this.f13227b = map.entrySet().iterator();
        }
        return this.f13227b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i = this.f13226a;
        if (i > 0) {
            list = this.f13228c.f13217b;
            if (i <= list.size()) {
                return true;
            }
        }
        return b().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        if (b().hasNext()) {
            return b().next();
        }
        list = this.f13228c.f13217b;
        int i = this.f13226a - 1;
        this.f13226a = i;
        return (Map.Entry) list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ C1303eb(C1297cb c1297cb, C1300db c1300db) {
        this(c1297cb);
    }
}
