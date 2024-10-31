package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public class EmptyImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    public EmptyImmutableSortedSet(Comparator<? super E> comparator) {
        super(comparator);
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> collection) {
        return collection.isEmpty();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        return Iterators.a();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        return ImmutableList.of();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return ObjectArrays.f2748a;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        return (T[]) asList().toArray(tArr);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Set) {
            return ((Set) obj).isEmpty();
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public String toString() {
        return "[]";
    }

    @Override // java.util.SortedSet
    public E first() {
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedSet
    public E last() {
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> headSetImpl(E e, boolean z) {
        return this;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> subSetImpl(E e, boolean z, E e2, boolean z2) {
        return this;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> tailSetImpl(E e, boolean z) {
        return this;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public int indexOf(@Nullable Object obj) {
        return -1;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> createDescendingSet() {
        return new EmptyImmutableSortedSet(Ordering.from(this.comparator).reverse());
    }
}
