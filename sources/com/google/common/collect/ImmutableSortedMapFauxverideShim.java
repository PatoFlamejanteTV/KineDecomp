package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableSortedMap;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes.dex */
public abstract class ImmutableSortedMapFauxverideShim<K, V> extends ImmutableMap<K, V> {
    @Deprecated
    public static <K, V> ImmutableSortedMap.Builder<K, V> builder() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        throw new UnsupportedOperationException();
    }
}