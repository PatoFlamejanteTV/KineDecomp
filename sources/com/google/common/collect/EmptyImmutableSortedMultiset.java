package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import java.util.Collection;
import java.util.Comparator;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class EmptyImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    private final ImmutableSortedSet<E> elementSet;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset headMultiset(Object obj, BoundType boundType) {
        return headMultiset((EmptyImmutableSortedMultiset<E>) obj, boundType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((EmptyImmutableSortedMultiset<E>) obj, boundType);
    }

    public EmptyImmutableSortedMultiset(Comparator<? super E> comparator) {
        this.elementSet = ImmutableSortedSet.emptySet(comparator);
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        return null;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        return null;
    }

    @Override // com.google.common.collect.Multiset
    public int count(@Nullable Object obj) {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean contains(@Nullable Object obj) {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> collection) {
        return collection.isEmpty();
    }

    @Override // java.util.Collection
    public int size() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.Multiset
    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public ImmutableSet<Multiset.Entry<E>> entrySet() {
        return ImmutableSet.of();
    }

    @Override // com.google.common.collect.ImmutableMultiset
    ImmutableSet<Multiset.Entry<E>> createEntrySet() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType) {
        Preconditions.a(e);
        Preconditions.a(boundType);
        return this;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        Preconditions.a(e);
        Preconditions.a(boundType);
        return this;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        return Iterators.a();
    }

    @Override // com.google.common.collect.ImmutableMultiset, java.util.Collection
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Multiset) {
            return ((Multiset) obj).isEmpty();
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableMultiset, java.util.Collection
    public int hashCode() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public String toString() {
        return "[]";
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return ObjectArrays.f2748a;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        return (T[]) asList().toArray(tArr);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        return ImmutableList.of();
    }
}
