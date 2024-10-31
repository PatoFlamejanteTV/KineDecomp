package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ImmutableMap<K, V> delegate();

    @Override // com.google.common.collect.BiMap
    public abstract ImmutableBiMap<V, K> inverse();

    public static <K, V> ImmutableBiMap<K, V> of() {
        return EmptyImmutableBiMap.INSTANCE;
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v) {
        return new RegularImmutableBiMap(ImmutableMap.of((Object) k, (Object) v));
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2) {
        return new RegularImmutableBiMap(ImmutableMap.of((Object) k, (Object) v, (Object) k2, (Object) v2));
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return new RegularImmutableBiMap(ImmutableMap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3));
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return new RegularImmutableBiMap(ImmutableMap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4));
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return new RegularImmutableBiMap(ImmutableMap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4, (Object) k5, (Object) v5));
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    /* loaded from: classes2.dex */
    public static final class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        @Override // com.google.common.collect.ImmutableMap.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Builder<K, V> b(K k, V v) {
            super.b(k, v);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Builder<K, V> b(Map<? extends K, ? extends V> map) {
            super.b(map);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ImmutableBiMap<K, V> b() {
            ImmutableMap<K, V> b = super.b();
            return b.isEmpty() ? ImmutableBiMap.of() : new RegularImmutableBiMap(b);
        }
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        if (map.isEmpty()) {
            return of();
        }
        return new RegularImmutableBiMap(ImmutableMap.copyOf((Map) map));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(@Nullable Object obj) {
        return delegate().containsKey(obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsValue(@Nullable Object obj) {
        return inverse().containsKey(obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return delegate().entrySet();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(@Nullable Object obj) {
        return delegate().get(obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<K> keySet() {
        return delegate().keySet();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    public V forcePut(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // java.util.Map
    public int size() {
        return delegate().size();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean equals(@Nullable Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.ImmutableMap
    public String toString() {
        return delegate().toString();
    }

    /* loaded from: classes2.dex */
    private static class SerializedForm extends ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0;

        SerializedForm(ImmutableBiMap<?, ?> immutableBiMap) {
            super(immutableBiMap);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        Object readResolve() {
            return createMap(new Builder());
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new SerializedForm(this);
    }
}
