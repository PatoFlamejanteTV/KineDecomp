package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Range<C extends Comparable> implements Predicate<C>, Serializable {
    private static final long serialVersionUID = 0;
    final Cut<C> lowerBound;
    final Cut<C> upperBound;

    /* renamed from: a */
    private static final Function<Range, Cut> f15641a = new C1500db();

    /* renamed from: b */
    private static final Function<Range, Cut> f15642b = new C1503eb();
    static final Ordering<Range<?>> RANGE_LEX_ORDERING = new RangeLexOrdering(null);

    /* renamed from: c */
    private static final Range<Comparable> f15643c = new Range<>(Cut.belowAll(), Cut.aboveAll());

    /* loaded from: classes2.dex */
    private static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {
        private static final long serialVersionUID = 0;

        private RangeLexOrdering() {
        }

        /* synthetic */ RangeLexOrdering(C1500db c1500db) {
            this();
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Range<?> range, Range<?> range2) {
            return ComparisonChain.e().a(range.lowerBound, range2.lowerBound).a(range.upperBound, range2.upperBound).d();
        }
    }

    private Range(Cut<C> cut, Cut<C> cut2) {
        Preconditions.a(cut);
        this.lowerBound = cut;
        Preconditions.a(cut2);
        this.upperBound = cut2;
        if (cut.compareTo((Cut) cut2) > 0 || cut == Cut.aboveAll() || cut2 == Cut.belowAll()) {
            throw new IllegalArgumentException("Invalid range: " + a(cut, cut2));
        }
    }

    private static String a(Cut<?> cut, Cut<?> cut2) {
        StringBuilder sb = new StringBuilder(16);
        cut.describeAsLowerBound(sb);
        sb.append("..");
        cut2.describeAsUpperBound(sb);
        return sb.toString();
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>) f15643c;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C c2) {
        return create(Cut.belowValue(c2), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> atMost(C c2) {
        return create(Cut.belowAll(), Cut.aboveValue(c2));
    }

    public static <C extends Comparable<?>> Range<C> closed(C c2, C c3) {
        return create(Cut.belowValue(c2), Cut.aboveValue(c3));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C c2, C c3) {
        return create(Cut.belowValue(c2), Cut.belowValue(c3));
    }

    public static int compareOrThrow(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static <C extends Comparable<?>> Range<C> create(Cut<C> cut, Cut<C> cut2) {
        return new Range<>(cut, cut2);
    }

    public static <C extends Comparable<?>> Range<C> downTo(C c2, BoundType boundType) {
        int i = C1506fb.f15787a[boundType.ordinal()];
        if (i == 1) {
            return greaterThan(c2);
        }
        if (i == 2) {
            return atLeast(c2);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> iterable) {
        Preconditions.a(iterable);
        if (iterable instanceof ContiguousSet) {
            return ((ContiguousSet) iterable).range();
        }
        Iterator<C> it = iterable.iterator();
        C next = it.next();
        Preconditions.a(next);
        C c2 = next;
        Comparable comparable = c2;
        while (it.hasNext()) {
            C next2 = it.next();
            Preconditions.a(next2);
            C c3 = next2;
            c2 = (Comparable) Ordering.natural().min(c2, c3);
            comparable = (Comparable) Ordering.natural().max(comparable, c3);
        }
        return closed(c2, comparable);
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C c2) {
        return create(Cut.aboveValue(c2), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C c2) {
        return create(Cut.belowAll(), Cut.belowValue(c2));
    }

    public static <C extends Comparable<?>> Function<Range<C>, Cut<C>> lowerBoundFn() {
        return f15641a;
    }

    public static <C extends Comparable<?>> Range<C> open(C c2, C c3) {
        return create(Cut.aboveValue(c2), Cut.belowValue(c3));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C c2, C c3) {
        return create(Cut.aboveValue(c2), Cut.aboveValue(c3));
    }

    public static <C extends Comparable<?>> Range<C> range(C c2, BoundType boundType, C c3, BoundType boundType2) {
        Preconditions.a(boundType);
        Preconditions.a(boundType2);
        return create(boundType == BoundType.OPEN ? Cut.aboveValue(c2) : Cut.belowValue(c2), boundType2 == BoundType.OPEN ? Cut.belowValue(c3) : Cut.aboveValue(c3));
    }

    public static <C extends Comparable<?>> Range<C> singleton(C c2) {
        return closed(c2, c2);
    }

    public static <C extends Comparable<?>> Range<C> upTo(C c2, BoundType boundType) {
        int i = C1506fb.f15787a[boundType.ordinal()];
        if (i == 1) {
            return lessThan(c2);
        }
        if (i == 2) {
            return atMost(c2);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> Function<Range<C>, Cut<C>> upperBoundFn() {
        return f15642b;
    }

    public Range<C> canonical(DiscreteDomain<C> discreteDomain) {
        Preconditions.a(discreteDomain);
        Cut<C> canonical = this.lowerBound.canonical(discreteDomain);
        Cut<C> canonical2 = this.upperBound.canonical(discreteDomain);
        return (canonical == this.lowerBound && canonical2 == this.upperBound) ? this : create(canonical, canonical2);
    }

    public boolean contains(C c2) {
        Preconditions.a(c2);
        return this.lowerBound.isLessThan(c2) && !this.upperBound.isLessThan(c2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsAll(Iterable<? extends C> iterable) {
        if (Iterables.c(iterable)) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            SortedSet a2 = a(iterable);
            Comparator comparator = a2.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return contains((Comparable) a2.first()) && contains((Comparable) a2.last());
            }
        }
        Iterator<? extends C> it = iterable.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean encloses(Range<C> range) {
        return this.lowerBound.compareTo((Cut) range.lowerBound) <= 0 && this.upperBound.compareTo((Cut) range.upperBound) >= 0;
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return this.lowerBound.equals(range.lowerBound) && this.upperBound.equals(range.upperBound);
    }

    public boolean hasLowerBound() {
        return this.lowerBound != Cut.belowAll();
    }

    public boolean hasUpperBound() {
        return this.upperBound != Cut.aboveAll();
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public Range<C> intersection(Range<C> range) {
        int compareTo = this.lowerBound.compareTo((Cut) range.lowerBound);
        int compareTo2 = this.upperBound.compareTo((Cut) range.upperBound);
        if (compareTo >= 0 && compareTo2 <= 0) {
            return this;
        }
        if (compareTo > 0 || compareTo2 < 0) {
            return create(compareTo >= 0 ? this.lowerBound : range.lowerBound, compareTo2 <= 0 ? this.upperBound : range.upperBound);
        }
        return range;
    }

    public boolean isConnected(Range<C> range) {
        return this.lowerBound.compareTo((Cut) range.upperBound) <= 0 && range.lowerBound.compareTo((Cut) this.upperBound) <= 0;
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public BoundType lowerBoundType() {
        return this.lowerBound.typeAsLowerBound();
    }

    public C lowerEndpoint() {
        return this.lowerBound.endpoint();
    }

    Object readResolve() {
        return equals(f15643c) ? all() : this;
    }

    public Range<C> span(Range<C> range) {
        int compareTo = this.lowerBound.compareTo((Cut) range.lowerBound);
        int compareTo2 = this.upperBound.compareTo((Cut) range.upperBound);
        if (compareTo <= 0 && compareTo2 >= 0) {
            return this;
        }
        if (compareTo < 0 || compareTo2 > 0) {
            return create(compareTo <= 0 ? this.lowerBound : range.lowerBound, compareTo2 >= 0 ? this.upperBound : range.upperBound);
        }
        return range;
    }

    public String toString() {
        return a(this.lowerBound, this.upperBound);
    }

    public BoundType upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }

    public C upperEndpoint() {
        return this.upperBound.endpoint();
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(C c2) {
        return contains(c2);
    }

    private static <T> SortedSet<T> a(Iterable<T> iterable) {
        return (SortedSet) iterable;
    }
}
