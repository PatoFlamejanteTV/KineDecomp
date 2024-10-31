package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ForwardingMap<K, V> extends ForwardingObject implements Map<K, V> {

    @Beta
    /* loaded from: classes2.dex */
    protected abstract class StandardEntrySet extends Maps.c<K, V> {

        /* renamed from: a */
        final /* synthetic */ ForwardingMap f15383a;

        @Override // com.google.common.collect.Maps.c
        Map<K, V> a() {
            return this.f15383a;
        }
    }

    @Beta
    /* loaded from: classes2.dex */
    protected class StandardKeySet extends Maps.e<K, V> {
    }

    @Beta
    /* loaded from: classes2.dex */
    protected class StandardValues extends Maps.i<K, V> {
    }

    public void clear() {
        delegate().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(@Nullable Object obj) {
        return delegate().containsKey(obj);
    }

    public boolean containsValue(@Nullable Object obj) {
        return delegate().containsValue(obj);
    }

    @Override // com.google.common.collect.ForwardingObject
    public abstract Map<K, V> delegate();

    public Set<Map.Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Map
    public V get(@Nullable Object obj) {
        return delegate().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Set<K> keySet() {
        return delegate().keySet();
    }

    @CanIgnoreReturnValue
    public V put(K k, V v) {
        return delegate().put(k, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    @CanIgnoreReturnValue
    public V remove(Object obj) {
        return delegate().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return delegate().size();
    }

    protected void standardClear() {
        Iterators.b(entrySet().iterator());
    }

    @Beta
    protected boolean standardContainsKey(@Nullable Object obj) {
        return Maps.a((Map<?, ?>) this, obj);
    }

    protected boolean standardContainsValue(@Nullable Object obj) {
        return Maps.b(this, obj);
    }

    protected boolean standardEquals(@Nullable Object obj) {
        return Maps.c(this, obj);
    }

    protected int standardHashCode() {
        return Sets.a(entrySet());
    }

    protected boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    protected void standardPutAll(Map<? extends K, ? extends V> map) {
        Maps.a((Map) this, (Map) map);
    }

    @Beta
    protected V standardRemove(@Nullable Object obj) {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (Objects.a(next.getKey(), obj)) {
                V value = next.getValue();
                it.remove();
                return value;
            }
        }
        return null;
    }

    public String standardToString() {
        return Maps.a(this);
    }

    public Collection<V> values() {
        return delegate().values();
    }
}
