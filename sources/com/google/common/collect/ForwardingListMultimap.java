package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ForwardingListMultimap<K, V> extends ForwardingMultimap<K, V> implements ListMultimap<K, V> {
    protected ForwardingListMultimap() {
    }
}
