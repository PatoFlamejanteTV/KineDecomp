package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class Range<C extends Comparable> implements Predicate<C>, Serializable {
    private static final long serialVersionUID = 0;
    final Cut<C> lowerBound;
    final Cut<C> upperBound;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Range(Cut<C> cut, Cut<C> cut2) {
        if (cut.compareTo((Cut) cut2) > 0) {
            throw new IllegalArgumentException("Invalid range: " + a(cut, cut2));
        }
        this.lowerBound = cut;
        this.upperBound = cut2;
    }

    public boolean hasLowerBound() {
        return this.lowerBound != Cut.belowAll();
    }

    public C lowerEndpoint() {
        return this.lowerBound.endpoint();
    }

    public BoundType lowerBoundType() {
        return this.lowerBound.typeAsLowerBound();
    }

    public boolean hasUpperBound() {
        return this.upperBound != Cut.aboveAll();
    }

    public C upperEndpoint() {
        return this.upperBound.endpoint();
    }

    public BoundType upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public boolean contains(C c) {
        Preconditions.a(c);
        return this.lowerBound.isLessThan(c) && !this.upperBound.isLessThan(c);
    }

    @Override // com.google.common.base.Predicate
    public boolean apply(C c) {
        return contains(c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsAll(Iterable<? extends C> iterable) {
        if (Iterables.d(iterable)) {
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

    public boolean isConnected(Range<C> range) {
        return this.lowerBound.compareTo((Cut) range.upperBound) <= 0 && range.lowerBound.compareTo((Cut) this.upperBound) <= 0;
    }

    public Range<C> intersection(Range<C> range) {
        return Ranges.a((Cut) Ordering.natural().max(this.lowerBound, range.lowerBound), (Cut) Ordering.natural().min(this.upperBound, range.upperBound));
    }

    public Range<C> span(Range<C> range) {
        return Ranges.a((Cut) Ordering.natural().min(this.lowerBound, range.lowerBound), (Cut) Ordering.natural().max(this.upperBound, range.upperBound));
    }

    @GwtCompatible
    public ContiguousSet<C> asSet(DiscreteDomain<C> discreteDomain) {
        return ContiguousSet.create(this, discreteDomain);
    }

    public Range<C> canonical(DiscreteDomain<C> discreteDomain) {
        Preconditions.a(discreteDomain);
        Cut<C> canonical = this.lowerBound.canonical(discreteDomain);
        Cut<C> canonical2 = this.upperBound.canonical(discreteDomain);
        return (canonical == this.lowerBound && canonical2 == this.upperBound) ? this : Ranges.a((Cut) canonical, (Cut) canonical2);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return this.lowerBound.equals(range.lowerBound) && this.upperBound.equals(range.upperBound);
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public String toString() {
        return a(this.lowerBound, this.upperBound);
    }

    private static String a(Cut<?> cut, Cut<?> cut2) {
        StringBuilder sb = new StringBuilder(16);
        cut.describeAsLowerBound(sb);
        sb.append((char) 8229);
        cut2.describeAsUpperBound(sb);
        return sb.toString();
    }

    private static <T> SortedSet<T> a(Iterable<T> iterable) {
        return (SortedSet) iterable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int compareOrThrow(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }
}
