package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class SingletonImmutableMap<K, V> extends ImmutableMap<K, V> {
    final transient K singleKey;
    final transient V singleValue;

    public SingletonImmutableMap(K k, V v) {
        this.singleKey = k;
        this.singleValue = v;
    }

    public SingletonImmutableMap(Map.Entry<K, V> entry) {
        this(entry.getKey(), entry.getValue());
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(@Nullable Object obj) {
        if (this.singleKey.equals(obj)) {
            return this.singleValue;
        }
        return null;
    }

    @Override // java.util.Map
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(@Nullable Object obj) {
        return this.singleKey.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsValue(@Nullable Object obj) {
        return this.singleValue.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return ImmutableSet.of(Maps.a(this.singleKey, this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return ImmutableSet.of(this.singleKey);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> createValues() {
        return ImmutableList.of(this.singleValue);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 1) {
                Map.Entry<K, V> next = map.entrySet().iterator().next();
                return this.singleKey.equals(next.getKey()) && this.singleValue.equals(next.getValue());
            }
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public int hashCode() {
        return this.singleKey.hashCode() ^ this.singleValue.hashCode();
    }
}
