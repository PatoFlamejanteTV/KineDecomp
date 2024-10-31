package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.lang.Comparable;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: AbstractRangeSet.java */
@GwtIncompatible
/* renamed from: com.google.common.collect.o */
/* loaded from: classes2.dex */
abstract class AbstractC1531o<C extends Comparable> implements RangeSet<C> {
    @Override // com.google.common.collect.RangeSet
    public abstract void add(Range<C> range);

    public void addAll(RangeSet<C> rangeSet) {
        Iterator<Range<C>> it = rangeSet.asRanges().iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public void clear() {
        remove(Range.all());
    }

    public boolean contains(C c2) {
        return rangeContaining(c2) != null;
    }

    @Override // com.google.common.collect.RangeSet
    public abstract boolean encloses(Range<C> range);

    public boolean enclosesAll(RangeSet<C> rangeSet) {
        Iterator<Range<C>> it = rangeSet.asRanges().iterator();
        while (it.hasNext()) {
            if (!encloses(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RangeSet) {
            return asRanges().equals(((RangeSet) obj).asRanges());
        }
        return false;
    }

    public final int hashCode() {
        return asRanges().hashCode();
    }

    public abstract boolean intersects(Range<C> range);

    @Override // com.google.common.collect.RangeSet
    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    public abstract Range<C> rangeContaining(C c2);

    public abstract void remove(Range<C> range);

    public void removeAll(RangeSet<C> rangeSet) {
        Iterator<Range<C>> it = rangeSet.asRanges().iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final String toString() {
        return asRanges().toString();
    }
}
