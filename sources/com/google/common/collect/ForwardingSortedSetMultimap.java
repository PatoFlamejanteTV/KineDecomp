package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ForwardingSortedSetMultimap<K, V> extends ForwardingSetMultimap<K, V> implements SortedSetMultimap<K, V> {
    protected ForwardingSortedSetMultimap() {
    }
}
