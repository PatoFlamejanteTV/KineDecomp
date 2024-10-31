package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class EmptyContiguousSet<C extends Comparable> extends ContiguousSet<C> {
    public EmptyContiguousSet(DiscreteDomain<C> discreteDomain) {
        super(discreteDomain);
    }

    @Override // java.util.SortedSet
    public C first() {
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedSet
    public C last() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return 0;
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet) {
        return this;
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range() {
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range(BoundType boundType, BoundType boundType2) {
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public ContiguousSet<C> headSetImpl(C c, boolean z) {
        return this;
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public ContiguousSet<C> subSetImpl(C c, boolean z, C c2, boolean z2) {
        return this;
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public ContiguousSet<C> tailSetImpl(C c, boolean z) {
        return this;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    @GwtIncompatible
    public int indexOf(Object obj) {
        return -1;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<C> iterator() {
        return Iterators.a();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<C> asList() {
        return ImmutableList.of();
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableCollection
    public String toString() {
        return "[]";
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

    @GwtIncompatible
    /* loaded from: classes2.dex */
    private static final class SerializedForm<C extends Comparable> implements Serializable {
        private static final long serialVersionUID = 0;
        private final DiscreteDomain<C> domain;

        /* synthetic */ SerializedForm(DiscreteDomain discreteDomain, AnonymousClass1 anonymousClass1) {
            this(discreteDomain);
        }

        private SerializedForm(DiscreteDomain<C> discreteDomain) {
            this.domain = discreteDomain;
        }

        private Object readResolve() {
            return new EmptyContiguousSet(this.domain);
        }
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    Object writeReplace() {
        return new SerializedForm(this.domain);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    @GwtIncompatible
    ImmutableSortedSet<C> createDescendingSet() {
        return new EmptyImmutableSortedSet(Ordering.natural().reverse());
    }
}
