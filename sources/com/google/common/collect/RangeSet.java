package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.lang.Comparable;
import java.util.Set;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public interface RangeSet<C extends Comparable> {
    void add(Range<C> range);

    Set<Range<C>> asRanges();

    RangeSet<C> complement();

    boolean encloses(Range<C> range);

    boolean isEmpty();
}
