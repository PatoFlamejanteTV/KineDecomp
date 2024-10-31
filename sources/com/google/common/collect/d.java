package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: AbstractMapBasedMultiset.java */
/* loaded from: classes2.dex */
public class d<E> implements Iterator<Multiset.Entry<E>> {

    /* renamed from: a, reason: collision with root package name */
    Map.Entry<E, Count> f2855a;
    final /* synthetic */ Iterator b;
    final /* synthetic */ AbstractMapBasedMultiset c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbstractMapBasedMultiset abstractMapBasedMultiset, Iterator it) {
        this.c = abstractMapBasedMultiset;
        this.b = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Multiset.Entry<E> next() {
        Map.Entry<E, Count> entry = (Map.Entry) this.b.next();
        this.f2855a = entry;
        return new e(this, entry);
    }

    @Override // java.util.Iterator
    public void remove() {
        Iterators.a(this.f2855a != null);
        AbstractMapBasedMultiset.access$122(this.c, this.f2855a.getValue().getAndSet(0));
        this.b.remove();
        this.f2855a = null;
    }
}
