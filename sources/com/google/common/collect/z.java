package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: ConcurrentHashMultiset.java */
/* loaded from: classes2.dex */
class z<E> extends ForwardingIterator<Multiset.Entry<E>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Iterator f2895a;
    final /* synthetic */ ConcurrentHashMultiset b;
    private Multiset.Entry<E> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(ConcurrentHashMultiset concurrentHashMultiset, Iterator it) {
        this.b = concurrentHashMultiset;
        this.f2895a = it;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
    /* renamed from: a */
    public Iterator<Multiset.Entry<E>> delegate() {
        return this.f2895a;
    }

    @Override // com.google.common.collect.ForwardingIterator, java.util.Iterator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Multiset.Entry<E> next() {
        this.c = (Multiset.Entry) super.next();
        return this.c;
    }

    @Override // com.google.common.collect.ForwardingIterator, java.util.Iterator
    public void remove() {
        Preconditions.b(this.c != null);
        this.b.setCount(this.c.getElement(), 0);
        this.c = null;
    }
}
