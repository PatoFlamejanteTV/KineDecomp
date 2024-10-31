package com.google.common.collect;

import com.google.common.collect.ImmutableMultimap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ImmutableMultimap.java */
/* loaded from: classes2.dex */
public class af<K, V> extends UnmodifiableIterator<Map.Entry<K, V>> {

    /* renamed from: a */
    K f2791a;
    Iterator<V> b;
    final /* synthetic */ Iterator c;
    final /* synthetic */ ImmutableMultimap.EntryCollection d;

    public af(ImmutableMultimap.EntryCollection entryCollection, Iterator it) {
        this.d = entryCollection;
        this.c = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return (this.f2791a != null && this.b.hasNext()) || this.c.hasNext();
    }

    @Override // java.util.Iterator
    /* renamed from: a */
    public Map.Entry<K, V> next() {
        if (this.f2791a == null || !this.b.hasNext()) {
            Map.Entry entry = (Map.Entry) this.c.next();
            this.f2791a = (K) entry.getKey();
            this.b = ((ImmutableCollection) entry.getValue()).iterator();
        }
        return Maps.a(this.f2791a, this.b.next());
    }
}
