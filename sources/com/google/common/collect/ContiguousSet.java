package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.lang.Comparable;
import java.util.NoSuchElementException;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    final DiscreteDomain<C> domain;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    public abstract ContiguousSet<C> headSetImpl(C c, boolean z);

    public abstract ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet);

    public abstract Range<C> range();

    public abstract Range<C> range(BoundType boundType, BoundType boundType2);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    public abstract ContiguousSet<C> subSetImpl(C c, boolean z, C c2, boolean z2);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    public abstract ContiguousSet<C> tailSetImpl(C c, boolean z);

    public static <C extends Comparable> ContiguousSet<C> create(Range<C> range, DiscreteDomain<C> discreteDomain) {
        Preconditions.a(range);
        Preconditions.a(discreteDomain);
        try {
            Range<C> intersection = !range.hasLowerBound() ? range.intersection(Ranges.d(discreteDomain.a())) : range;
            if (!range.hasUpperBound()) {
                intersection = intersection.intersection(Ranges.b(discreteDomain.b()));
            }
            return intersection.isEmpty() || Range.compareOrThrow(range.lowerBound.leastValueAbove(discreteDomain), range.upperBound.greatestValueBelow(discreteDomain)) > 0 ? new EmptyContiguousSet(discreteDomain) : new RegularContiguousSet(intersection, discreteDomain);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContiguousSet(DiscreteDomain<C> discreteDomain) {
        super(Ordering.natural());
        this.domain = discreteDomain;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public ContiguousSet<C> headSet(C c) {
        return headSetImpl((ContiguousSet<C>) Preconditions.a(c), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    @GwtIncompatible
    public ContiguousSet<C> headSet(C c, boolean z) {
        return headSetImpl((ContiguousSet<C>) Preconditions.a(c), z);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public ContiguousSet<C> subSet(C c, C c2) {
        Preconditions.a(c);
        Preconditions.a(c2);
        Preconditions.a(comparator().compare(c, c2) <= 0);
        return subSetImpl((boolean) c, true, (boolean) c2, false);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    @GwtIncompatible
    public ContiguousSet<C> subSet(C c, boolean z, C c2, boolean z2) {
        Preconditions.a(c);
        Preconditions.a(c2);
        Preconditions.a(comparator().compare(c, c2) <= 0);
        return subSetImpl((boolean) c, z, (boolean) c2, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public ContiguousSet<C> tailSet(C c) {
        return tailSetImpl((ContiguousSet<C>) Preconditions.a(c), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    @GwtIncompatible
    public ContiguousSet<C> tailSet(C c, boolean z) {
        return tailSetImpl((ContiguousSet<C>) Preconditions.a(c), z);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public String toString() {
        return range().toString();
    }
}
