package com.google.common.collect;

import com.google.common.collect.AbstractMultimap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [K] */
/* compiled from: AbstractMultimap.java */
/* loaded from: classes2.dex */
public class k<K> implements Iterator<K> {

    /* renamed from: a, reason: collision with root package name */
    final Iterator<Map.Entry<K, Collection<V>>> f2879a;
    Map.Entry<K, Collection<V>> b;
    final /* synthetic */ AbstractMultimap.c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbstractMultimap.c cVar) {
        this.c = cVar;
        this.f2879a = this.c.f2647a.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f2879a.hasNext();
    }

    @Override // java.util.Iterator
    public K next() {
        this.b = (Map.Entry) this.f2879a.next();
        return this.b.getKey();
    }

    @Override // java.util.Iterator
    public void remove() {
        Iterators.a(this.b != null);
        Collection collection = (Collection) this.b.getValue();
        this.f2879a.remove();
        AbstractMultimap.access$220(AbstractMultimap.this, collection.size());
        collection.clear();
    }
}
