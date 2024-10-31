package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
@Deprecated
/* loaded from: classes2.dex */
public final class MapConstraints {

    /* loaded from: classes2.dex */
    public static class a<K, V> extends ForwardingCollection<Map.Entry<K, V>> {

        /* renamed from: a */
        final MapConstraint<? super K, ? super V> f15536a;

        /* renamed from: b */
        final Collection<Map.Entry<K, V>> f15537b;

        a(Collection<Map.Entry<K, V>> collection, MapConstraint<? super K, ? super V> mapConstraint) {
            this.f15537b = collection;
            this.f15536a = mapConstraint;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return Maps.a((Collection) delegate(), obj);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new Da(this, this.f15537b.iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return Maps.b(delegate(), obj);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Collection<Map.Entry<K, V>> delegate() {
            return this.f15537b;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }
    }

    /* loaded from: classes2.dex */
    public static class b<K, V> extends a<K, V> implements Set<Map.Entry<K, V>> {
        b(Set<Map.Entry<K, V>> set, MapConstraint<? super K, ? super V> mapConstraint) {
            super(set, mapConstraint);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@Nullable Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c<K, V> extends ForwardingMap<K, V> {

        /* renamed from: a */
        private transient Set<Map.Entry<K, V>> f15538a;
        final MapConstraint<? super K, ? super V> constraint;
        private final Map<K, V> delegate;

        public c(Map<K, V> map, MapConstraint<? super K, ? super V> mapConstraint) {
            Preconditions.a(map);
            this.delegate = map;
            Preconditions.a(mapConstraint);
            this.constraint = mapConstraint;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f15538a;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> b2 = MapConstraints.b(this.delegate.entrySet(), this.constraint);
            this.f15538a = b2;
            return b2;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        @CanIgnoreReturnValue
        public V put(K k, V v) {
            this.constraint.a(k, v);
            return this.delegate.put(k, v);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            this.delegate.putAll(MapConstraints.b(map, this.constraint));
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public Map<K, V> delegate() {
            return this.delegate;
        }
    }

    private MapConstraints() {
    }

    public static <K, V> Map.Entry<K, V> b(Map.Entry<K, V> entry, MapConstraint<? super K, ? super V> mapConstraint) {
        Preconditions.a(entry);
        Preconditions.a(mapConstraint);
        return new Ca(entry, mapConstraint);
    }

    public static <K, V> Set<Map.Entry<K, V>> b(Set<Map.Entry<K, V>> set, MapConstraint<? super K, ? super V> mapConstraint) {
        return new b(set, mapConstraint);
    }

    public static <K, V> Map<K, V> b(Map<? extends K, ? extends V> map, MapConstraint<? super K, ? super V> mapConstraint) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry<K, V> entry : linkedHashMap.entrySet()) {
            mapConstraint.a(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }
}
