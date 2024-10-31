package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class MapConstraints {
    private MapConstraints() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> Map.Entry<K, V> b(Map.Entry<K, V> entry, MapConstraint<? super K, ? super V> mapConstraint) {
        Preconditions.a(entry);
        Preconditions.a(mapConstraint);
        return new bj(entry, mapConstraint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> Set<Map.Entry<K, V>> b(Set<Map.Entry<K, V>> set, MapConstraint<? super K, ? super V> mapConstraint) {
        return new b(set, mapConstraint);
    }

    /* loaded from: classes2.dex */
    static class c<K, V> extends ForwardingMap<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final MapConstraint<? super K, ? super V> f2719a;
        private final Map<K, V> b;
        private transient Set<Map.Entry<K, V>> c;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public Map<K, V> delegate() {
            return this.b;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.c;
            if (set == null) {
                Set<Map.Entry<K, V>> b = MapConstraints.b(this.b.entrySet(), this.f2719a);
                this.c = b;
                return b;
            }
            return set;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public V put(K k, V v) {
            this.f2719a.a(k, v);
            return this.b.put(k, v);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            this.b.putAll(MapConstraints.b(map, this.f2719a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a<K, V> extends ForwardingCollection<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        final MapConstraint<? super K, ? super V> f2718a;
        final Collection<Map.Entry<K, V>> b;

        a(Collection<Map.Entry<K, V>> collection, MapConstraint<? super K, ? super V> mapConstraint) {
            this.b = collection;
            this.f2718a = mapConstraint;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Collection<Map.Entry<K, V>> delegate() {
            return this.b;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new bk(this, this.b.iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return Maps.a((Collection) delegate(), obj);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
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
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> Map<K, V> b(Map<? extends K, ? extends V> map, MapConstraint<? super K, ? super V> mapConstraint) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry<K, V> entry : linkedHashMap.entrySet()) {
            mapConstraint.a(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }
}
