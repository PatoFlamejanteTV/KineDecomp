package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.hb */
/* loaded from: classes2.dex */
final class C1368hb<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a */
    private int f13459a;

    /* renamed from: b */
    private Iterator<Map.Entry<K, V>> f13460b;

    /* renamed from: c */
    private final /* synthetic */ C1362fb f13461c;

    private C1368hb(C1362fb c1362fb) {
        List list;
        this.f13461c = c1362fb;
        list = this.f13461c.f13449b;
        this.f13459a = list.size();
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f13460b == null) {
            map = this.f13461c.f13453f;
            this.f13460b = map.entrySet().iterator();
        }
        return this.f13460b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i = this.f13459a;
        if (i > 0) {
            list = this.f13461c.f13449b;
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
        list = this.f13461c.f13449b;
        int i = this.f13459a - 1;
        this.f13459a = i;
        return (Map.Entry) list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ C1368hb(C1362fb c1362fb, C1365gb c1365gb) {
        this(c1362fb);
    }
}
