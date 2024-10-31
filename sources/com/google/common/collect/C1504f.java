package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: AbstractMapBasedMultimap.java */
/* renamed from: com.google.common.collect.f */
/* loaded from: classes2.dex */
public class C1504f<K> implements Iterator<K> {

    /* renamed from: a */
    Map.Entry<K, Collection<V>> f15782a;

    /* renamed from: b */
    final /* synthetic */ Iterator f15783b;

    /* renamed from: c */
    final /* synthetic */ AbstractMapBasedMultimap.c f15784c;

    public C1504f(AbstractMapBasedMultimap.c cVar, Iterator it) {
        this.f15784c = cVar;
        this.f15783b = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15783b.hasNext();
    }

    @Override // java.util.Iterator
    public K next() {
        this.f15782a = (Map.Entry) this.f15783b.next();
        return this.f15782a.getKey();
    }

    @Override // java.util.Iterator
    public void remove() {
        C1555x.a(this.f15782a != null);
        Collection collection = (Collection) this.f15782a.getValue();
        this.f15783b.remove();
        AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, collection.size());
        collection.clear();
    }
}
