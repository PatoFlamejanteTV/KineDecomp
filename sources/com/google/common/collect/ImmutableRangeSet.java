package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.SortedLists;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class ImmutableRangeSet<C extends Comparable> extends AbstractC1531o<C> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private static final ImmutableRangeSet<Comparable<?>> f15456a = new ImmutableRangeSet<>(ImmutableList.of());

    /* renamed from: b, reason: collision with root package name */
    private static final ImmutableRangeSet<Comparable<?>> f15457b = new ImmutableRangeSet<>(ImmutableList.of(Range.all()));

    /* renamed from: c, reason: collision with root package name */
    private final transient ImmutableList<Range<C>> f15458c;

    /* renamed from: d, reason: collision with root package name */
    @LazyInit
    private transient ImmutableRangeSet<C> f15459d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class AsSet extends ImmutableSortedSet<C> {

        /* renamed from: b, reason: collision with root package name */
        private transient Integer f15460b;
        private final DiscreteDomain<C> domain;

        AsSet(DiscreteDomain<C> discreteDomain) {
            super(Ordering.natural());
            this.domain = discreteDomain;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@Nullable Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return ImmutableRangeSet.this.contains((Comparable) obj);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public int indexOf(Object obj) {
            if (!contains(obj)) {
                return -1;
            }
            Comparable comparable = (Comparable) obj;
            long j = 0;
            Iterator it = ImmutableRangeSet.this.f15458c.iterator();
            while (it.hasNext()) {
                if (((Range) it.next()).contains(comparable)) {
                    return Ints.b(j + ContiguousSet.create(r3, this.domain).indexOf(comparable));
                }
                j += ContiguousSet.create(r3, this.domain).size();
            }
            throw new AssertionError("impossible");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableRangeSet.this.f15458c.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Integer num = this.f15460b;
            if (num == null) {
                long j = 0;
                Iterator it = ImmutableRangeSet.this.f15458c.iterator();
                while (it.hasNext()) {
                    j += ContiguousSet.create((Range) it.next(), this.domain).size();
                    if (j >= 2147483647L) {
                        break;
                    }
                }
                num = Integer.valueOf(Ints.b(j));
                this.f15460b = num;
            }
            return num.intValue();
        }

        ImmutableSortedSet<C> subSet(Range<C> range) {
            return ImmutableRangeSet.this.m13subRangeSet((Range) range).asSet(this.domain);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return ImmutableRangeSet.this.f15458c.toString();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return new AsSetSerializedForm(ImmutableRangeSet.this.f15458c, this.domain);
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        public UnmodifiableIterator<C> descendingIterator() {
            return new C1502ea(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> headSetImpl(C c2, boolean z) {
            return subSet(Range.upTo(c2, BoundType.forBoolean(z)));
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public UnmodifiableIterator<C> iterator() {
            return new C1499da(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> subSetImpl(C c2, boolean z, C c3, boolean z2) {
            if (!z && !z2 && Range.compareOrThrow(c2, c3) == 0) {
                return ImmutableSortedSet.of();
            }
            return subSet(Range.range(c2, BoundType.forBoolean(z), c3, BoundType.forBoolean(z2)));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> tailSetImpl(C c2, boolean z) {
            return subSet(Range.downTo(c2, BoundType.forBoolean(z)));
        }
    }

    /* loaded from: classes2.dex */
    private static class AsSetSerializedForm<C extends Comparable> implements Serializable {
        private final DiscreteDomain<C> domain;
        private final ImmutableList<Range<C>> ranges;

        AsSetSerializedForm(ImmutableList<Range<C>> immutableList, DiscreteDomain<C> discreteDomain) {
            this.ranges = immutableList;
            this.domain = discreteDomain;
        }

        Object readResolve() {
            return new ImmutableRangeSet(this.ranges).asSet(this.domain);
        }
    }

    /* loaded from: classes2.dex */
    public static class Builder<C extends Comparable<?>> {

        /* renamed from: a, reason: collision with root package name */
        private final RangeSet<C> f15461a = TreeRangeSet.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class ComplementRanges extends ImmutableList<Range<C>> {
        private final boolean positiveBoundedAbove;
        private final boolean positiveBoundedBelow;
        private final int size;

        /* JADX WARN: Multi-variable type inference failed */
        ComplementRanges() {
            this.positiveBoundedBelow = ((Range) ImmutableRangeSet.this.f15458c.get(0)).hasLowerBound();
            this.positiveBoundedAbove = ((Range) Iterables.a((Iterable) ImmutableRangeSet.this.f15458c)).hasUpperBound();
            int size = ImmutableRangeSet.this.f15458c.size() - 1;
            size = this.positiveBoundedBelow ? size + 1 : size;
            this.size = this.positiveBoundedAbove ? size + 1 : size;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public Range<C> get(int i) {
            Cut<C> cut;
            Cut<C> cut2;
            Preconditions.a(i, this.size);
            if (!this.positiveBoundedBelow) {
                cut = ((Range) ImmutableRangeSet.this.f15458c.get(i)).upperBound;
            } else {
                cut = i == 0 ? Cut.belowAll() : ((Range) ImmutableRangeSet.this.f15458c.get(i - 1)).upperBound;
            }
            if (!this.positiveBoundedAbove || i != this.size - 1) {
                cut2 = ((Range) ImmutableRangeSet.this.f15458c.get(i + (!this.positiveBoundedBelow ? 1 : 0))).lowerBound;
            } else {
                cut2 = Cut.aboveAll();
            }
            return Range.create(cut, cut2);
        }
    }

    /* loaded from: classes2.dex */
    private static final class SerializedForm<C extends Comparable> implements Serializable {
        private final ImmutableList<Range<C>> ranges;

        SerializedForm(ImmutableList<Range<C>> immutableList) {
            this.ranges = immutableList;
        }

        Object readResolve() {
            if (this.ranges.isEmpty()) {
                return ImmutableRangeSet.of();
            }
            if (this.ranges.equals(ImmutableList.of(Range.all()))) {
                return ImmutableRangeSet.all();
            }
            return new ImmutableRangeSet(this.ranges);
        }
    }

    ImmutableRangeSet(ImmutableList<Range<C>> immutableList) {
        this.f15458c = immutableList;
    }

    private ImmutableList<Range<C>> a(final Range<C> range) {
        int size;
        if (!this.f15458c.isEmpty() && !range.isEmpty()) {
            if (range.encloses(span())) {
                return this.f15458c;
            }
            final int a2 = range.hasLowerBound() ? SortedLists.a(this.f15458c, (Function<? super E, Cut<C>>) Range.upperBoundFn(), range.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER) : 0;
            if (range.hasUpperBound()) {
                size = SortedLists.a(this.f15458c, (Function<? super E, Cut<C>>) Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
            } else {
                size = this.f15458c.size();
            }
            final int i = size - a2;
            if (i == 0) {
                return ImmutableList.of();
            }
            return (ImmutableList<Range<C>>) new ImmutableList<Range<C>>() { // from class: com.google.common.collect.ImmutableRangeSet.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.google.common.collect.ImmutableCollection
                public boolean isPartialView() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return i;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.List
                public Range<C> get(int i2) {
                    Preconditions.a(i2, i);
                    return (i2 == 0 || i2 == i + (-1)) ? ((Range) ImmutableRangeSet.this.f15458c.get(i2 + a2)).intersection(range) : (Range) ImmutableRangeSet.this.f15458c.get(i2 + a2);
                }
            };
        }
        return ImmutableList.of();
    }

    static <C extends Comparable> ImmutableRangeSet<C> all() {
        return f15457b;
    }

    public static <C extends Comparable<?>> Builder<C> builder() {
        return new Builder<>();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(RangeSet<C> rangeSet) {
        Preconditions.a(rangeSet);
        if (rangeSet.isEmpty()) {
            return of();
        }
        if (rangeSet.encloses(Range.all())) {
            return all();
        }
        if (rangeSet instanceof ImmutableRangeSet) {
            ImmutableRangeSet<C> immutableRangeSet = (ImmutableRangeSet) rangeSet;
            if (!immutableRangeSet.isPartialView()) {
                return immutableRangeSet;
            }
        }
        return new ImmutableRangeSet<>(ImmutableList.copyOf((Collection) rangeSet.asRanges()));
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of() {
        return f15456a;
    }

    @Override // com.google.common.collect.AbstractC1531o, com.google.common.collect.RangeSet
    @Deprecated
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractC1531o
    @Deprecated
    public void addAll(RangeSet<C> rangeSet) {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedSet<C> asSet(DiscreteDomain<C> discreteDomain) {
        Preconditions.a(discreteDomain);
        if (isEmpty()) {
            return ImmutableSortedSet.of();
        }
        Range<C> canonical = span().canonical(discreteDomain);
        if (canonical.hasLowerBound()) {
            if (!canonical.hasUpperBound()) {
                try {
                    discreteDomain.maxValue();
                } catch (NoSuchElementException unused) {
                    throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
                }
            }
            return new AsSet(discreteDomain);
        }
        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
    }

    @Override // com.google.common.collect.AbstractC1531o
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractC1531o
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // com.google.common.collect.AbstractC1531o, com.google.common.collect.RangeSet
    public boolean encloses(Range<C> range) {
        int a2 = SortedLists.a(this.f15458c, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        return a2 != -1 && this.f15458c.get(a2).encloses(range);
    }

    @Override // com.google.common.collect.AbstractC1531o
    public /* bridge */ /* synthetic */ boolean enclosesAll(RangeSet rangeSet) {
        return super.enclosesAll(rangeSet);
    }

    @Override // com.google.common.collect.AbstractC1531o
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractC1531o
    public boolean intersects(Range<C> range) {
        int a2 = SortedLists.a(this.f15458c, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (a2 < this.f15458c.size() && this.f15458c.get(a2).isConnected(range) && !this.f15458c.get(a2).intersection(range).isEmpty()) {
            return true;
        }
        if (a2 > 0) {
            int i = a2 - 1;
            if (this.f15458c.get(i).isConnected(range) && !this.f15458c.get(i).intersection(range).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractC1531o, com.google.common.collect.RangeSet
    public boolean isEmpty() {
        return this.f15458c.isEmpty();
    }

    boolean isPartialView() {
        return this.f15458c.isPartialView();
    }

    @Override // com.google.common.collect.AbstractC1531o
    public Range<C> rangeContaining(C c2) {
        int a2 = SortedLists.a(this.f15458c, Range.lowerBoundFn(), Cut.belowValue(c2), Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (a2 == -1) {
            return null;
        }
        Range<C> range = this.f15458c.get(a2);
        if (range.contains(c2)) {
            return range;
        }
        return null;
    }

    @Override // com.google.common.collect.AbstractC1531o
    @Deprecated
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractC1531o
    @Deprecated
    public void removeAll(RangeSet<C> rangeSet) {
        throw new UnsupportedOperationException();
    }

    public Range<C> span() {
        if (!this.f15458c.isEmpty()) {
            return Range.create(this.f15458c.get(0).lowerBound, this.f15458c.get(r1.size() - 1).upperBound);
        }
        throw new NoSuchElementException();
    }

    Object writeReplace() {
        return new SerializedForm(this.f15458c);
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> range) {
        Preconditions.a(range);
        if (range.isEmpty()) {
            return of();
        }
        if (range.equals(Range.all())) {
            return all();
        }
        return new ImmutableRangeSet<>(ImmutableList.of(range));
    }

    /* renamed from: asDescendingSetOfRanges, reason: merged with bridge method [inline-methods] */
    public ImmutableSet<Range<C>> m12asDescendingSetOfRanges() {
        if (this.f15458c.isEmpty()) {
            return ImmutableSet.of();
        }
        return new RegularImmutableSortedSet(this.f15458c.reverse(), Range.RANGE_LEX_ORDERING.reverse());
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableSet<Range<C>> asRanges() {
        if (this.f15458c.isEmpty()) {
            return ImmutableSet.of();
        }
        return new RegularImmutableSortedSet(this.f15458c, Range.RANGE_LEX_ORDERING);
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> immutableRangeSet = this.f15459d;
        if (immutableRangeSet != null) {
            return immutableRangeSet;
        }
        if (this.f15458c.isEmpty()) {
            ImmutableRangeSet<C> all = all();
            this.f15459d = all;
            return all;
        }
        if (this.f15458c.size() == 1 && this.f15458c.get(0).equals(Range.all())) {
            ImmutableRangeSet<C> of = of();
            this.f15459d = of;
            return of;
        }
        ImmutableRangeSet<C> immutableRangeSet2 = new ImmutableRangeSet<>(new ComplementRanges(), this);
        this.f15459d = immutableRangeSet2;
        return immutableRangeSet2;
    }

    /* renamed from: subRangeSet, reason: merged with bridge method [inline-methods] */
    public ImmutableRangeSet<C> m13subRangeSet(Range<C> range) {
        if (!isEmpty()) {
            Range<C> span = span();
            if (range.encloses(span)) {
                return this;
            }
            if (range.isConnected(span)) {
                return new ImmutableRangeSet<>(a(range));
            }
        }
        return of();
    }

    private ImmutableRangeSet(ImmutableList<Range<C>> immutableList, ImmutableRangeSet<C> immutableRangeSet) {
        this.f15458c = immutableList;
        this.f15459d = immutableRangeSet;
    }
}
