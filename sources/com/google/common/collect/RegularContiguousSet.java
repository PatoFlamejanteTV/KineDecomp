package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public final class RegularContiguousSet<C extends Comparable> extends ContiguousSet<C> {
    private static final long serialVersionUID = 0;
    private final Range<C> range;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularContiguousSet(Range<C> range, DiscreteDomain<C> discreteDomain) {
        super(discreteDomain);
        this.range = range;
    }

    private ContiguousSet<C> a(Range<C> range) {
        return this.range.isConnected(range) ? this.range.intersection(range).asSet(this.domain) : new EmptyContiguousSet(this.domain);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public ContiguousSet<C> headSetImpl(C c, boolean z) {
        return a(Ranges.a(c, BoundType.forBoolean(z)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public ContiguousSet<C> subSetImpl(C c, boolean z, C c2, boolean z2) {
        return (c.compareTo(c2) != 0 || z || z2) ? a(Ranges.a(c, BoundType.forBoolean(z), c2, BoundType.forBoolean(z2))) : new EmptyContiguousSet(this.domain);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public ContiguousSet<C> tailSetImpl(C c, boolean z) {
        return a(Ranges.b(c, BoundType.forBoolean(z)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    @GwtIncompatible
    public int indexOf(Object obj) {
        if (contains(obj)) {
            return (int) this.domain.a(first(), (Comparable) obj);
        }
        return -1;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<C> iterator() {
        return new cq(this, first());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Comparable<?> comparable, @Nullable Comparable<?> comparable2) {
        return comparable2 != null && Range.compareOrThrow(comparable, comparable2) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.SortedSet
    public C first() {
        return this.range.lowerBound.leastValueAbove(this.domain);
    }

    @Override // java.util.SortedSet
    public C last() {
        return this.range.upperBound.greatestValueBelow(this.domain);
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        long a2 = this.domain.a(first(), last());
        if (a2 >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return ((int) a2) + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.range.contains((Comparable) obj);
        } catch (ClassCastException e) {
            return false;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> collection) {
        return Collections2.a((Collection<?>) this, collection);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return ObjectArrays.a(this);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        return (T[]) ObjectArrays.a((Collection<?>) this, (Object[]) tArr);
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet) {
        Preconditions.a(contiguousSet);
        Preconditions.a(this.domain.equals(contiguousSet.domain));
        if (!contiguousSet.isEmpty()) {
            Comparable comparable = (Comparable) Ordering.natural().max(first(), contiguousSet.first());
            Comparable comparable2 = (Comparable) Ordering.natural().min(last(), contiguousSet.last());
            return comparable.compareTo(comparable2) < 0 ? Ranges.a(comparable, comparable2).asSet(this.domain) : new EmptyContiguousSet<>(this.domain);
        }
        return contiguousSet;
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range() {
        return range(BoundType.CLOSED, BoundType.CLOSED);
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range(BoundType boundType, BoundType boundType2) {
        return Ranges.a((Cut) this.range.lowerBound.withLowerBoundType(boundType, this.domain), (Cut) this.range.upperBound.withUpperBoundType(boundType2, this.domain));
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RegularContiguousSet) {
            RegularContiguousSet regularContiguousSet = (RegularContiguousSet) obj;
            if (this.domain.equals(regularContiguousSet.domain)) {
                return first().equals(regularContiguousSet.first()) && last().equals(regularContiguousSet.last());
            }
        }
        return super.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.a(this);
    }

    @GwtIncompatible
    /* loaded from: classes2.dex */
    private static final class SerializedForm<C extends Comparable> implements Serializable {
        final DiscreteDomain<C> domain;
        final Range<C> range;

        /* synthetic */ SerializedForm(Range range, DiscreteDomain discreteDomain, cq cqVar) {
            this(range, discreteDomain);
        }

        private SerializedForm(Range<C> range, DiscreteDomain<C> discreteDomain) {
            this.range = range;
            this.domain = discreteDomain;
        }

        private Object readResolve() {
            return new RegularContiguousSet(this.range, this.domain);
        }
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    Object writeReplace() {
        return new SerializedForm(this.range, this.domain, null);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    @GwtIncompatible
    ImmutableSortedSet<C> createDescendingSet() {
        return new DescendingContiguousSet(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GwtIncompatible
    /* loaded from: classes2.dex */
    public final class DescendingContiguousSet extends ImmutableSortedSet<C> {
        /* synthetic */ DescendingContiguousSet(RegularContiguousSet regularContiguousSet, cq cqVar) {
            this();
        }

        private DescendingContiguousSet() {
            super(Ordering.natural().reverse());
        }

        @Override // java.util.SortedSet
        public C first() {
            return (C) RegularContiguousSet.this.last();
        }

        @Override // java.util.SortedSet
        public C last() {
            return (C) RegularContiguousSet.this.first();
        }

        @Override // java.util.Collection, java.util.Set
        public int size() {
            return RegularContiguousSet.this.size();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<C> iterator() {
            return new cr(this, first());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> headSetImpl(C c, boolean z) {
            return (ImmutableSortedSet<C>) RegularContiguousSet.this.tailSetImpl((RegularContiguousSet) c, z).descendingSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> subSetImpl(C c, boolean z, C c2, boolean z2) {
            return (ImmutableSortedSet<C>) RegularContiguousSet.this.subSetImpl((boolean) c2, z2, (boolean) c, z).descendingSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> tailSetImpl(C c, boolean z) {
            return (ImmutableSortedSet<C>) RegularContiguousSet.this.headSetImpl((RegularContiguousSet) c, z).descendingSet();
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        ImmutableSortedSet<C> createDescendingSet() {
            return RegularContiguousSet.this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public int indexOf(Object obj) {
            if (contains(obj)) {
                return (int) RegularContiguousSet.this.domain.a(last(), (Comparable) obj);
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }
    }
}
