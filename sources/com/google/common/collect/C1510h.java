package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractMapBasedMultiset.java */
/* renamed from: com.google.common.collect.h */
/* loaded from: classes2.dex */
public class C1510h<E> implements Iterator<Multiset.Entry<E>> {

    /* renamed from: a */
    Map.Entry<E, Count> f15794a;

    /* renamed from: b */
    final /* synthetic */ Iterator f15795b;

    /* renamed from: c */
    final /* synthetic */ AbstractMapBasedMultiset f15796c;

    public C1510h(AbstractMapBasedMultiset abstractMapBasedMultiset, Iterator it) {
        this.f15796c = abstractMapBasedMultiset;
        this.f15795b = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15795b.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        C1555x.a(this.f15794a != null);
        AbstractMapBasedMultiset.access$122(this.f15796c, this.f15794a.getValue().getAndSet(0));
        this.f15795b.remove();
        this.f15794a = null;
    }

    @Override // java.util.Iterator
    public Multiset.Entry<E> next() {
        Map.Entry<E, Count> entry = (Map.Entry) this.f15795b.next();
        this.f15794a = entry;
        return new C1507g(this, entry);
    }
}
