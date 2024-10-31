package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public interface Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsEntry(@Nullable Object obj, @Nullable Object obj2);

    boolean containsKey(@Nullable Object obj);

    Collection<Map.Entry<K, V>> entries();

    boolean equals(@Nullable Object obj);

    Collection<V> get(@Nullable K k);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    Multiset<K> keys();

    @CanIgnoreReturnValue
    boolean put(@Nullable K k, @Nullable V v);

    @CanIgnoreReturnValue
    boolean putAll(@Nullable K k, Iterable<? extends V> iterable);

    @CanIgnoreReturnValue
    boolean remove(@Nullable Object obj, @Nullable Object obj2);

    @CanIgnoreReturnValue
    Collection<V> removeAll(@Nullable Object obj);

    int size();
}
