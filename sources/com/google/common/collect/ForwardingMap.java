package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
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
    protected abstract class StandardEntrySet extends Maps.a<K, V> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    public abstract Map<K, V> delegate();

    @Override // java.util.Map
    public int size() {
        return delegate().size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public V remove(Object obj) {
        return delegate().remove(obj);
    }

    public void clear() {
        delegate().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return delegate().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return delegate().containsValue(obj);
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return delegate().get(obj);
    }

    public V put(K k, V v) {
        return delegate().put(k, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    public Set<K> keySet() {
        return delegate().keySet();
    }

    public Collection<V> values() {
        return delegate().values();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return delegate().hashCode();
    }

    @Beta
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

    @Beta
    protected void standardClear() {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @Beta
    /* loaded from: classes2.dex */
    protected class StandardKeySet extends Maps.c<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ForwardingMap f2679a;

        @Override // com.google.common.collect.Maps.c
        Map<K, V> a() {
            return this.f2679a;
        }
    }

    @Beta
    protected boolean standardContainsKey(@Nullable Object obj) {
        return Maps.d(this, obj);
    }

    @Beta
    /* loaded from: classes2.dex */
    protected class StandardValues extends Maps.f<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ForwardingMap f2680a;

        @Override // com.google.common.collect.Maps.f
        Map<K, V> a() {
            return this.f2680a;
        }
    }

    @Beta
    protected boolean standardContainsValue(@Nullable Object obj) {
        return Maps.e(this, obj);
    }

    @Beta
    protected boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    @Beta
    protected boolean standardEquals(@Nullable Object obj) {
        return Maps.c(this, obj);
    }

    @Beta
    protected int standardHashCode() {
        return Sets.a(entrySet());
    }

    @Beta
    protected String standardToString() {
        return Maps.a(this);
    }
}
