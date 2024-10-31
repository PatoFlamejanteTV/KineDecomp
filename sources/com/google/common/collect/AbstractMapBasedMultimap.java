package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public abstract class AbstractMapBasedMultimap<K, V> extends AbstractC1519k<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;

    /* renamed from: f */
    private transient Map<K, Collection<V>> f15290f;

    /* renamed from: g */
    private transient int f15291g;

    /* loaded from: classes2.dex */
    public class a extends Maps.j<K, Collection<V>> {

        /* renamed from: d */
        final transient Map<K, Collection<V>> f15292d;

        /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$a$a */
        /* loaded from: classes2.dex */
        class C0089a extends Maps.c<K, Collection<V>> {
            C0089a() {
            }

            @Override // com.google.common.collect.Maps.c
            Map<K, Collection<V>> a() {
                return a.this;
            }

            @Override // com.google.common.collect.Maps.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return Collections2.a(a.this.f15292d.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new b();
            }

            @Override // com.google.common.collect.Maps.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                AbstractMapBasedMultimap.this.b(((Map.Entry) obj).getKey());
                return true;
            }
        }

        /* loaded from: classes2.dex */
        class b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* renamed from: a */
            final Iterator<Map.Entry<K, Collection<V>>> f15295a;

            /* renamed from: b */
            Collection<V> f15296b;

            b() {
                this.f15295a = a.this.f15292d.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f15295a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f15295a.remove();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, this.f15296b.size());
                this.f15296b.clear();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.f15295a.next();
                this.f15296b = next.getValue();
                return a.this.a(next);
            }
        }

        a(Map<K, Collection<V>> map) {
            this.f15292d = map;
        }

        @Override // com.google.common.collect.Maps.j
        protected Set<Map.Entry<K, Collection<V>>> a() {
            return new C0089a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f15292d == AbstractMapBasedMultimap.this.f15290f) {
                AbstractMapBasedMultimap.this.clear();
            } else {
                Iterators.b(new b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return Maps.d(this.f15292d, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(@Nullable Object obj) {
            return this == obj || this.f15292d.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f15292d.hashCode();
        }

        @Override // com.google.common.collect.Maps.j, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f15292d.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f15292d.toString();
        }

        Map.Entry<K, Collection<V>> a(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return Maps.a(key, AbstractMapBasedMultimap.this.wrapCollection(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> get(Object obj) {
            Collection<V> collection = (Collection) Maps.e(this.f15292d, obj);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.wrapCollection(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> remove(Object obj) {
            Collection<V> remove = this.f15292d.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> createCollection = AbstractMapBasedMultimap.this.createCollection();
            createCollection.addAll(remove);
            AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, remove.size());
            remove.clear();
            return createCollection;
        }
    }

    /* loaded from: classes2.dex */
    public abstract class b<T> implements Iterator<T> {

        /* renamed from: a */
        final Iterator<Map.Entry<K, Collection<V>>> f15298a;

        /* renamed from: b */
        K f15299b = null;

        /* renamed from: c */
        Collection<V> f15300c = null;

        /* renamed from: d */
        Iterator<V> f15301d = Iterators.c();

        public b() {
            this.f15298a = AbstractMapBasedMultimap.this.f15290f.entrySet().iterator();
        }

        abstract T a(K k, V v);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f15298a.hasNext() || this.f15301d.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f15301d.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.f15298a.next();
                this.f15299b = next.getKey();
                this.f15300c = next.getValue();
                this.f15301d = this.f15300c.iterator();
            }
            return a(this.f15299b, this.f15301d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f15301d.remove();
            if (this.f15300c.isEmpty()) {
                this.f15298a.remove();
            }
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends Maps.e<K, Collection<V>> {
        c(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterators.b(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return a().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@Nullable Object obj) {
            return this == obj || a().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return a().keySet().hashCode();
        }

        @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new C1504f(this, a().entrySet().iterator());
        }

        @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int i;
            Collection<V> remove = a().remove(obj);
            if (remove != null) {
                i = remove.size();
                remove.clear();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, i);
            } else {
                i = 0;
            }
            return i > 0;
        }
    }

    @GwtIncompatible
    /* loaded from: classes2.dex */
    class d extends AbstractMapBasedMultimap<K, V>.g implements NavigableMap<K, Collection<V>> {
        public d(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        Map.Entry<K, Collection<V>> a(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = it.next();
            Collection<V> createCollection = AbstractMapBasedMultimap.this.createCollection();
            createCollection.addAll(next.getValue());
            it.remove();
            return Maps.a(next.getKey(), AbstractMapBasedMultimap.this.unmodifiableCollectionSubclass(createCollection));
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> ceilingEntry(K k) {
            Map.Entry<K, Collection<V>> ceilingEntry = d().ceilingEntry(k);
            if (ceilingEntry == null) {
                return null;
            }
            return a(ceilingEntry);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return d().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new d(d().descendingMap());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> firstEntry = d().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return a(firstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> floorEntry(K k) {
            Map.Entry<K, Collection<V>> floorEntry = d().floorEntry(k);
            if (floorEntry == null) {
                return null;
            }
            return a(floorEntry);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return d().floorKey(k);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.g, java.util.SortedMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
            return headMap((d) obj);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> higherEntry(K k) {
            Map.Entry<K, Collection<V>> higherEntry = d().higherEntry(k);
            if (higherEntry == null) {
                return null;
            }
            return a(higherEntry);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return d().higherKey(k);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> lastEntry = d().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return a(lastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lowerEntry(K k) {
            Map.Entry<K, Collection<V>> lowerEntry = d().lowerEntry(k);
            if (lowerEntry == null) {
                return null;
            }
            return a(lowerEntry);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return d().lowerKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return keySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return a(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return a(descendingMap().entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.g, java.util.SortedMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
            return tailMap((d) obj);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.g
        public NavigableMap<K, Collection<V>> d() {
            return (NavigableMap) super.d();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.g, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K k) {
            return headMap(k, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.g, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.g, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K k) {
            return tailMap(k, true);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.g, com.google.common.collect.Maps.j
        public NavigableSet<K> b() {
            return new e(d());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K k, boolean z) {
            return new d(d().headMap(k, z));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.g, com.google.common.collect.AbstractMapBasedMultimap.a, com.google.common.collect.Maps.j, java.util.AbstractMap, java.util.Map
        public NavigableSet<K> keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K k, boolean z, K k2, boolean z2) {
            return new d(d().subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K k, boolean z) {
            return new d(d().tailMap(k, z));
        }
    }

    @GwtIncompatible
    /* loaded from: classes2.dex */
    public class e extends AbstractMapBasedMultimap<K, V>.h implements NavigableSet<K> {
        public e(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            return b().ceilingKey(k);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new e(b().descendingMap());
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return b().floorKey(k);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.h, java.util.SortedSet, java.util.NavigableSet
        public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
            return headSet((e) obj);
        }

        @Override // java.util.NavigableSet
        public K higher(K k) {
            return b().higherKey(k);
        }

        @Override // java.util.NavigableSet
        public K lower(K k) {
            return b().lowerKey(k);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) Iterators.f(iterator());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Iterators.f(descendingIterator());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.h, java.util.SortedSet, java.util.NavigableSet
        public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
            return tailSet((e) obj);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.h
        public NavigableMap<K, Collection<V>> b() {
            return (NavigableMap) super.b();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.h, java.util.SortedSet, java.util.NavigableSet
        public NavigableSet<K> headSet(K k) {
            return headSet(k, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.h, java.util.SortedSet, java.util.NavigableSet
        public NavigableSet<K> subSet(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.h, java.util.SortedSet, java.util.NavigableSet
        public NavigableSet<K> tailSet(K k) {
            return tailSet(k, true);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k, boolean z) {
            return new e(b().headMap(k, z));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return new e(b().subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k, boolean z) {
            return new e(b().tailMap(k, z));
        }
    }

    /* loaded from: classes2.dex */
    public class f extends AbstractMapBasedMultimap<K, V>.j implements RandomAccess {
        f(@Nullable K k, List<V> list, @Nullable AbstractMapBasedMultimap<K, V>.i iVar) {
            super(k, list, iVar);
        }
    }

    /* loaded from: classes2.dex */
    public class g extends AbstractMapBasedMultimap<K, V>.a implements SortedMap<K, Collection<V>> {

        /* renamed from: f */
        SortedSet<K> f15307f;

        g(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return d().comparator();
        }

        SortedMap<K, Collection<V>> d() {
            return (SortedMap) this.f15292d;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return d().firstKey();
        }

        public SortedMap<K, Collection<V>> headMap(K k) {
            return new g(d().headMap(k));
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return d().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new g(d().subMap(k, k2));
        }

        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new g(d().tailMap(k));
        }

        @Override // com.google.common.collect.Maps.j
        public SortedSet<K> b() {
            return new h(d());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.a, com.google.common.collect.Maps.j, java.util.AbstractMap, java.util.Map
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.f15307f;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> b2 = b();
            this.f15307f = b2;
            return b2;
        }
    }

    /* loaded from: classes2.dex */
    public class h extends AbstractMapBasedMultimap<K, V>.c implements SortedSet<K> {
        h(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        SortedMap<K, Collection<V>> b() {
            return (SortedMap) super.a();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return b().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            return new h(b().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return b().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new h(b().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new h(b().tailMap(k));
        }
    }

    @GwtIncompatible
    /* loaded from: classes2.dex */
    class k extends AbstractMapBasedMultimap<K, V>.m implements NavigableSet<V> {
        public k(@Nullable K k, NavigableSet<V> navigableSet, @Nullable AbstractMapBasedMultimap<K, V>.i iVar) {
            super(k, navigableSet, iVar);
        }

        private NavigableSet<V> a(NavigableSet<V> navigableSet) {
            return new k(this.f15310a, navigableSet, b() == null ? this : b());
        }

        @Override // java.util.NavigableSet
        public V ceiling(V v) {
            return g().ceiling(v);
        }

        @Override // java.util.NavigableSet
        public Iterator<V> descendingIterator() {
            return new i.a(g().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> descendingSet() {
            return a(g().descendingSet());
        }

        @Override // java.util.NavigableSet
        public V floor(V v) {
            return g().floor(v);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> headSet(V v, boolean z) {
            return a(g().headSet(v, z));
        }

        @Override // java.util.NavigableSet
        public V higher(V v) {
            return g().higher(v);
        }

        @Override // java.util.NavigableSet
        public V lower(V v) {
            return g().lower(v);
        }

        @Override // java.util.NavigableSet
        public V pollFirst() {
            return (V) Iterators.f(iterator());
        }

        @Override // java.util.NavigableSet
        public V pollLast() {
            return (V) Iterators.f(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> subSet(V v, boolean z, V v2, boolean z2) {
            return a(g().subSet(v, z, v2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> tailSet(V v, boolean z) {
            return a(g().tailSet(v, z));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.m
        public NavigableSet<V> g() {
            return (NavigableSet) super.g();
        }
    }

    /* loaded from: classes2.dex */
    public class l extends AbstractMapBasedMultimap<K, V>.i implements Set<V> {
        l(@Nullable K k, Set<V> set) {
            super(k, set, null);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean a2 = Sets.a((Set<?>) this.f15311b, collection);
            if (a2) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f15311b.size() - size);
                f();
            }
            return a2;
        }
    }

    /* loaded from: classes2.dex */
    public class m extends AbstractMapBasedMultimap<K, V>.i implements SortedSet<V> {
        m(@Nullable K k, SortedSet<V> sortedSet, @Nullable AbstractMapBasedMultimap<K, V>.i iVar) {
            super(k, sortedSet, iVar);
        }

        @Override // java.util.SortedSet
        public Comparator<? super V> comparator() {
            return g().comparator();
        }

        @Override // java.util.SortedSet
        public V first() {
            e();
            return g().first();
        }

        SortedSet<V> g() {
            return (SortedSet) c();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> headSet(V v) {
            e();
            return new m(d(), g().headSet(v), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public V last() {
            e();
            return g().last();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> subSet(V v, V v2) {
            e();
            return new m(d(), g().subSet(v, v2), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(V v) {
            e();
            return new m(d(), g().tailSet(v), b() == null ? this : b());
        }
    }

    public AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        Preconditions.a(map.isEmpty());
        this.f15290f = map;
    }

    private Collection<V> a(@Nullable K k2) {
        Collection<V> collection = this.f15290f.get(k2);
        if (collection != null) {
            return collection;
        }
        Collection<V> createCollection = createCollection(k2);
        this.f15290f.put(k2, createCollection);
        return createCollection;
    }

    static /* synthetic */ int access$208(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i2 = abstractMapBasedMultimap.f15291g;
        abstractMapBasedMultimap.f15291g = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$210(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i2 = abstractMapBasedMultimap.f15291g;
        abstractMapBasedMultimap.f15291g = i2 - 1;
        return i2;
    }

    static /* synthetic */ int access$212(AbstractMapBasedMultimap abstractMapBasedMultimap, int i2) {
        int i3 = abstractMapBasedMultimap.f15291g + i2;
        abstractMapBasedMultimap.f15291g = i3;
        return i3;
    }

    public static /* synthetic */ int access$220(AbstractMapBasedMultimap abstractMapBasedMultimap, int i2) {
        int i3 = abstractMapBasedMultimap.f15291g - i2;
        abstractMapBasedMultimap.f15291g = i3;
        return i3;
    }

    public void b(Object obj) {
        Collection collection = (Collection) Maps.f(this.f15290f, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.f15291g -= size;
        }
    }

    public Map<K, Collection<V>> backingMap() {
        return this.f15290f;
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        Iterator<Collection<V>> it = this.f15290f.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.f15290f.clear();
        this.f15291g = 0;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@Nullable Object obj) {
        return this.f15290f.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractC1519k
    Map<K, Collection<V>> createAsMap() {
        Map<K, Collection<V>> map = this.f15290f;
        return map instanceof SortedMap ? new g((SortedMap) map) : new a(map);
    }

    abstract Collection<V> createCollection();

    public Collection<V> createCollection(@Nullable K k2) {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractC1519k
    Set<K> createKeySet() {
        Map<K, Collection<V>> map = this.f15290f;
        return map instanceof SortedMap ? new h((SortedMap) map) : new c(map);
    }

    Collection<V> createUnmodifiableEmptyCollection() {
        return unmodifiableCollectionSubclass(createCollection());
    }

    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractC1519k
    Iterator<Map.Entry<K, V>> entryIterator() {
        return new C1501e(this);
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> get(@Nullable K k2) {
        Collection<V> collection = this.f15290f.get(k2);
        if (collection == null) {
            collection = createCollection(k2);
        }
        return wrapCollection(k2, collection);
    }

    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public boolean put(@Nullable K k2, @Nullable V v) {
        Collection<V> collection = this.f15290f.get(k2);
        if (collection == null) {
            Collection<V> createCollection = createCollection(k2);
            if (createCollection.add(v)) {
                this.f15291g++;
                this.f15290f.put(k2, createCollection);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        }
        if (!collection.add(v)) {
            return false;
        }
        this.f15291g++;
        return true;
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> removeAll(@Nullable Object obj) {
        Collection<V> remove = this.f15290f.remove(obj);
        if (remove == null) {
            return createUnmodifiableEmptyCollection();
        }
        Collection<V> createCollection = createCollection();
        createCollection.addAll(remove);
        this.f15291g -= remove.size();
        remove.clear();
        return unmodifiableCollectionSubclass(createCollection);
    }

    @Override // com.google.common.collect.AbstractC1519k
    public Collection<V> replaceValues(@Nullable K k2, Iterable<? extends V> iterable) {
        Iterator<? extends V> it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(k2);
        }
        Collection<V> a2 = a((AbstractMapBasedMultimap<K, V>) k2);
        Collection<V> createCollection = createCollection();
        createCollection.addAll(a2);
        this.f15291g -= a2.size();
        a2.clear();
        while (it.hasNext()) {
            if (a2.add(it.next())) {
                this.f15291g++;
            }
        }
        return unmodifiableCollectionSubclass(createCollection);
    }

    public final void setMap(Map<K, Collection<V>> map) {
        this.f15290f = map;
        this.f15291g = 0;
        for (Collection<V> collection : map.values()) {
            Preconditions.a(!collection.isEmpty());
            this.f15291g += collection.size();
        }
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.f15291g;
    }

    Collection<V> unmodifiableCollectionSubclass(Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        if (collection instanceof List) {
            return Collections.unmodifiableList((List) collection);
        }
        return Collections.unmodifiableCollection(collection);
    }

    @Override // com.google.common.collect.AbstractC1519k
    Iterator<V> valueIterator() {
        return new C1498d(this);
    }

    @Override // com.google.common.collect.AbstractC1519k
    public Collection<V> values() {
        return super.values();
    }

    Collection<V> wrapCollection(@Nullable K k2, Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return new m(k2, (SortedSet) collection, null);
        }
        if (collection instanceof Set) {
            return new l(k2, (Set) collection);
        }
        if (collection instanceof List) {
            return a(k2, (List) collection, null);
        }
        return new i(k2, collection, null);
    }

    /* loaded from: classes2.dex */
    public class i extends AbstractCollection<V> {

        /* renamed from: a */
        final K f15310a;

        /* renamed from: b */
        Collection<V> f15311b;

        /* renamed from: c */
        final AbstractMapBasedMultimap<K, V>.i f15312c;

        /* renamed from: d */
        final Collection<V> f15313d;

        i(@Nullable K k, Collection<V> collection, @Nullable AbstractMapBasedMultimap<K, V>.i iVar) {
            this.f15310a = k;
            this.f15311b = collection;
            this.f15312c = iVar;
            this.f15313d = iVar == null ? null : iVar.c();
        }

        void a() {
            AbstractMapBasedMultimap<K, V>.i iVar = this.f15312c;
            if (iVar == null) {
                AbstractMapBasedMultimap.this.f15290f.put(this.f15310a, this.f15311b);
            } else {
                iVar.a();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v) {
            e();
            boolean isEmpty = this.f15311b.isEmpty();
            boolean add = this.f15311b.add(v);
            if (add) {
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    a();
                }
            }
            return add;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.f15311b.addAll(collection);
            if (addAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f15311b.size() - size);
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        AbstractMapBasedMultimap<K, V>.i b() {
            return this.f15312c;
        }

        Collection<V> c() {
            return this.f15311b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f15311b.clear();
            AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, size);
            f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            e();
            return this.f15311b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            e();
            return this.f15311b.containsAll(collection);
        }

        K d() {
            return this.f15310a;
        }

        void e() {
            Collection<V> collection;
            AbstractMapBasedMultimap<K, V>.i iVar = this.f15312c;
            if (iVar != null) {
                iVar.e();
                if (this.f15312c.c() != this.f15313d) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.f15311b.isEmpty() || (collection = (Collection) AbstractMapBasedMultimap.this.f15290f.get(this.f15310a)) == null) {
                    return;
                }
                this.f15311b = collection;
            }
        }

        @Override // java.util.Collection
        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            e();
            return this.f15311b.equals(obj);
        }

        void f() {
            AbstractMapBasedMultimap<K, V>.i iVar = this.f15312c;
            if (iVar != null) {
                iVar.f();
            } else if (this.f15311b.isEmpty()) {
                AbstractMapBasedMultimap.this.f15290f.remove(this.f15310a);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            e();
            return this.f15311b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            e();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            e();
            boolean remove = this.f15311b.remove(obj);
            if (remove) {
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                f();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.f15311b.removeAll(collection);
            if (removeAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f15311b.size() - size);
                f();
            }
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Preconditions.a(collection);
            int size = size();
            boolean retainAll = this.f15311b.retainAll(collection);
            if (retainAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f15311b.size() - size);
                f();
            }
            return retainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            e();
            return this.f15311b.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            e();
            return this.f15311b.toString();
        }

        /* loaded from: classes2.dex */
        public class a implements Iterator<V> {

            /* renamed from: a */
            final Iterator<V> f15315a;

            /* renamed from: b */
            final Collection<V> f15316b;

            a() {
                this.f15316b = i.this.f15311b;
                this.f15315a = AbstractMapBasedMultimap.this.a((Collection) i.this.f15311b);
            }

            Iterator<V> b() {
                c();
                return this.f15315a;
            }

            void c() {
                i.this.e();
                if (i.this.f15311b != this.f15316b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                c();
                return this.f15315a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                c();
                return this.f15315a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f15315a.remove();
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                i.this.f();
            }

            a(Iterator<V> it) {
                this.f15316b = i.this.f15311b;
                this.f15315a = it;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j extends AbstractMapBasedMultimap<K, V>.i implements List<V> {

        /* loaded from: classes2.dex */
        private class a extends AbstractMapBasedMultimap<K, V>.i.a implements ListIterator<V> {
            a() {
                super();
            }

            private ListIterator<V> d() {
                return (ListIterator) b();
            }

            @Override // java.util.ListIterator
            public void add(V v) {
                boolean isEmpty = j.this.isEmpty();
                d().add(v);
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    j.this.a();
                }
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return d().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return d().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return d().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return d().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v) {
                d().set(v);
            }

            public a(int i) {
                super(j.this.g().listIterator(i));
            }
        }

        j(@Nullable K k, List<V> list, @Nullable AbstractMapBasedMultimap<K, V>.i iVar) {
            super(k, list, iVar);
        }

        @Override // java.util.List
        public void add(int i, V v) {
            e();
            boolean isEmpty = c().isEmpty();
            g().add(i, v);
            AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
            if (isEmpty) {
                a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = g().addAll(i, collection);
            if (addAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, c().size() - size);
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        List<V> g() {
            return (List) c();
        }

        @Override // java.util.List
        public V get(int i) {
            e();
            return g().get(i);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            e();
            return g().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            e();
            return g().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            e();
            return new a();
        }

        @Override // java.util.List
        public V remove(int i) {
            e();
            V remove = g().remove(i);
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
            f();
            return remove;
        }

        @Override // java.util.List
        public V set(int i, V v) {
            e();
            return g().set(i, v);
        }

        @Override // java.util.List
        public List<V> subList(int i, int i2) {
            e();
            return AbstractMapBasedMultimap.this.a(d(), g().subList(i, i2), b() == null ? this : b());
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i) {
            e();
            return new a(i);
        }
    }

    public List<V> a(@Nullable K k2, List<V> list, @Nullable AbstractMapBasedMultimap<K, V>.i iVar) {
        return list instanceof RandomAccess ? new f(k2, list, iVar) : new j(k2, list, iVar);
    }

    public Iterator<V> a(Collection<V> collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }
}
