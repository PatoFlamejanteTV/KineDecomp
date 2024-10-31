package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Iterator;

/* compiled from: ConcurrentHashMultiset.java */
/* loaded from: classes2.dex */
class C<E> extends ForwardingIterator<Multiset.Entry<E>> {

    /* renamed from: a */
    private Multiset.Entry<E> f15344a;

    /* renamed from: b */
    final /* synthetic */ Iterator f15345b;

    /* renamed from: c */
    final /* synthetic */ ConcurrentHashMultiset f15346c;

    public C(ConcurrentHashMultiset concurrentHashMultiset, Iterator it) {
        this.f15346c = concurrentHashMultiset;
        this.f15345b = it;
    }

    @Override // com.google.common.collect.ForwardingIterator, java.util.Iterator
    public void remove() {
        C1555x.a(this.f15344a != null);
        this.f15346c.setCount(this.f15344a.getElement(), 0);
        this.f15344a = null;
    }

    @Override // com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
    public Iterator<Multiset.Entry<E>> delegate() {
        return this.f15345b;
    }

    @Override // com.google.common.collect.ForwardingIterator, java.util.Iterator
    public Multiset.Entry<E> next() {
        this.f15344a = (Multiset.Entry) super.next();
        return this.f15344a;
    }
}
