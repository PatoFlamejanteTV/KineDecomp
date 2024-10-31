package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;

/* compiled from: TreeRangeMap.java */
/* loaded from: classes2.dex */
class Jb implements RangeMap {
    @Override // com.google.common.collect.RangeMap
    public Map<Range, Object> asMapOfRanges() {
        return Collections.emptyMap();
    }

    @Override // com.google.common.collect.RangeMap
    public void put(Range range, Object obj) {
        Preconditions.a(range);
        throw new IllegalArgumentException("Cannot insert range " + range + " into an empty subRangeMap");
    }
}
