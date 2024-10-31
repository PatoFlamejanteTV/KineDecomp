package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {

    @Beta
    /* loaded from: classes2.dex */
    protected class StandardDescendingSet extends Sets.a<E> {
    }

    protected ForwardingNavigableSet() {
    }

    public SortedSet<E> a(E e2) {
        return headSet(e2, false);
    }

    public SortedSet<E> b(E e2) {
        return tailSet(e2, true);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e2) {
        return delegate().ceiling(e2);
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract NavigableSet<E> delegate();

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return delegate().descendingSet();
    }

    @Override // java.util.NavigableSet
    public E floor(E e2) {
        return delegate().floor(e2);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E e2, boolean z) {
        return delegate().headSet(e2, z);
    }

    @Override // java.util.NavigableSet
    public E higher(E e2) {
        return delegate().higher(e2);
    }

    @Override // java.util.NavigableSet
    public E lower(E e2) {
        return delegate().lower(e2);
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        return delegate().pollLast();
    }

    @Override // com.google.common.collect.ForwardingSortedSet
    public SortedSet<E> standardSubSet(E e2, E e3) {
        return subSet(e2, true, e3, false);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E e2, boolean z, E e3, boolean z2) {
        return delegate().subSet(e2, z, e3, z2);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E e2, boolean z) {
        return delegate().tailSet(e2, z);
    }
}
