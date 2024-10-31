package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.SortedMap;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ForwardingSortedMap<K, V> extends ForwardingMap<K, V> implements SortedMap<K, V> {
    protected ForwardingSortedMap() {
    }
}
