package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.lang.Comparable;
import java.util.Map;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public interface RangeMap<K extends Comparable, V> {
    Map<Range<K>, V> asMapOfRanges();

    void put(Range<K> range, V v);
}
