package com.google.common.collect;

import android.support.v7.widget.ActivityChooserView;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class Maps {

    /* renamed from: a, reason: collision with root package name */
    static final Joiner.MapJoiner f15573a = Collections2.f15349a.c("=");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum EntryFunction implements Function<Map.Entry<?, ?>, Object> {
        KEY { // from class: com.google.common.collect.Maps.EntryFunction.1
            @Override // com.google.common.base.Function
            @Nullable
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE { // from class: com.google.common.collect.Maps.EntryFunction.2
            @Override // com.google.common.base.Function
            @Nullable
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        };

        /* synthetic */ EntryFunction(Ha ha) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public interface EntryTransformer<K, V1, V2> {
        V2 a(@Nullable K k, @Nullable V1 v1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a<K, V> extends j<K, V> {

        /* renamed from: d, reason: collision with root package name */
        private final Set<K> f15574d;

        /* renamed from: e, reason: collision with root package name */
        final Function<? super K, V> f15575e;

        a(Set<K> set, Function<? super K, V> function) {
            Preconditions.a(set);
            this.f15574d = set;
            Preconditions.a(function);
            this.f15575e = function;
        }

        @Override // com.google.common.collect.Maps.j
        protected Set<Map.Entry<K, V>> a() {
            return new Oa(this);
        }

        @Override // com.google.common.collect.Maps.j
        public Set<K> b() {
            return Maps.b(d());
        }

        @Override // com.google.common.collect.Maps.j
        Collection<V> c() {
            return Collections2.a((Collection) this.f15574d, (Function) this.f15575e);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            d().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@Nullable Object obj) {
            return d().contains(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Set<K> d() {
            return this.f15574d;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@Nullable Object obj) {
            if (Collections2.a(d(), obj)) {
                return this.f15575e.apply(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(@Nullable Object obj) {
            if (d().remove(obj)) {
                return this.f15575e.apply(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return d().size();
        }
    }

    @GwtIncompatible
    /* loaded from: classes2.dex */
    static abstract class b<K, V> extends ForwardingMap<K, V> implements NavigableMap<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private transient Comparator<? super K> f15576a;

        /* renamed from: b, reason: collision with root package name */
        private transient Set<Map.Entry<K, V>> f15577b;

        /* renamed from: c, reason: collision with root package name */
        private transient NavigableSet<K> f15578c;

        private static <T> Ordering<T> a(Comparator<T> comparator) {
            return Ordering.from(comparator).reverse();
        }

        Set<Map.Entry<K, V>> b() {
            return new Pa(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Iterator<Map.Entry<K, V>> c();

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k) {
            return d().floorEntry(k);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return d().floorKey(k);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator = this.f15576a;
            if (comparator != null) {
                return comparator;
            }
            Comparator<? super K> comparator2 = d().comparator();
            if (comparator2 == null) {
                comparator2 = Ordering.natural();
            }
            Ordering a2 = a(comparator2);
            this.f15576a = a2;
            return a2;
        }

        abstract NavigableMap<K, V> d();

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return d().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return d();
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f15577b;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> b2 = b();
            this.f15577b = b2;
            return b2;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return d().lastEntry();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return d().lastKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k) {
            return d().ceilingEntry(k);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return d().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k, boolean z) {
            return d().tailMap(k, z).descendingMap();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k) {
            return d().lowerEntry(k);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return d().lowerKey(k);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return d().firstEntry();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return d().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k) {
            return d().higherEntry(k);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return d().higherKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> navigableSet = this.f15578c;
            if (navigableSet != null) {
                return navigableSet;
            }
            f fVar = new f(this);
            this.f15578c = fVar;
            return fVar;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return d().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return d().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return d().subMap(k2, z2, k, z).descendingMap();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k, boolean z) {
            return d().headMap(k, z).descendingMap();
        }

        @Override // com.google.common.collect.ForwardingObject
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Collection<V> values() {
            return new i(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public final Map<K, V> delegate() {
            return d();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K k) {
            return headMap(k, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k) {
            return tailMap(k, true);
        }
    }

    /* loaded from: classes2.dex */
    static abstract class c<K, V> extends Sets.b<Map.Entry<K, V>> {
        abstract Map<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object e2 = Maps.e(a(), key);
            if (Objects.a(e2, entry.getValue())) {
                return e2 != null || a().containsKey(key);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj)) {
                return a().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.google.common.collect.Sets.b, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                Preconditions.a(collection);
                return super.removeAll(collection);
            } catch (UnsupportedOperationException unused) {
                return Sets.a((Set<?>) this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.Sets.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                Preconditions.a(collection);
                return super.retainAll(collection);
            } catch (UnsupportedOperationException unused) {
                HashSet a2 = Sets.a(collection.size());
                for (Object obj : collection) {
                    if (contains(obj)) {
                        a2.add(((Map.Entry) obj).getKey());
                    }
                }
                return a().keySet().retainAll(a2);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    /* loaded from: classes2.dex */
    static abstract class d<K, V> extends AbstractMap<K, V> {
        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterators.b(entryIterator());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Iterator<Map.Entry<K, V>> entryIterator();

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new Qa(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public abstract int size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class e<K, V> extends Sets.b<K> {

        /* renamed from: a, reason: collision with root package name */
        @Weak
        final Map<K, V> f15579a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public e(Map<K, V> map) {
            Preconditions.a(map);
            this.f15579a = map;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Map<K, V> a() {
            return this.f15579a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return a().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.a(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            a().remove(obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    /* loaded from: classes2.dex */
    public static class f<K, V> extends g<K, V> implements NavigableSet<K> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public f(NavigableMap<K, V> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            return a().ceilingKey(k);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return a().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return a().floorKey(k);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k, boolean z) {
            return a().headMap(k, z).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public K higher(K k) {
            return a().higherKey(k);
        }

        @Override // java.util.NavigableSet
        public K lower(K k) {
            return a().lowerKey(k);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) Maps.a(a().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Maps.a(a().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return a().subMap(k, z, k2, z2).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k, boolean z) {
            return a().tailMap(k, z).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.g, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K k) {
            return headSet(k, false);
        }

        @Override // com.google.common.collect.Maps.g, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        @Override // com.google.common.collect.Maps.g, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K k) {
            return tailSet(k, true);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.g, com.google.common.collect.Maps.e
        public NavigableMap<K, V> a() {
            return (NavigableMap) this.f15579a;
        }
    }

    /* loaded from: classes2.dex */
    static class g<K, V> extends e<K, V> implements SortedSet<K> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public g(SortedMap<K, V> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return a().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return a().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            return new g(a().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return a().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new g(a().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new g(a().tailMap(k));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.e
        public SortedMap<K, V> a() {
            return (SortedMap) super.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class h<K, V1, V2> extends d<K, V2> {

        /* renamed from: a, reason: collision with root package name */
        final Map<K, V1> f15580a;

        /* renamed from: b, reason: collision with root package name */
        final EntryTransformer<? super K, ? super V1, V2> f15581b;

        h(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            Preconditions.a(map);
            this.f15580a = map;
            Preconditions.a(entryTransformer);
            this.f15581b = entryTransformer;
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f15580a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f15580a.containsKey(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.d
        public Iterator<Map.Entry<K, V2>> entryIterator() {
            return Iterators.a((Iterator) this.f15580a.entrySet().iterator(), Maps.a(this.f15581b));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 get(Object obj) {
            V1 v1 = this.f15580a.get(obj);
            if (v1 != null || this.f15580a.containsKey(obj)) {
                return this.f15581b.a(obj, v1);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f15580a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 remove(Object obj) {
            if (this.f15580a.containsKey(obj)) {
                return this.f15581b.a(obj, this.f15580a.remove(obj));
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f15580a.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V2> values() {
            return new i(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class i<K, V> extends AbstractCollection<V> {

        /* renamed from: a, reason: collision with root package name */
        @Weak
        final Map<K, V> f15582a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(Map<K, V> map) {
            Preconditions.a(map);
            this.f15582a = map;
        }

        final Map<K, V> a() {
            return this.f15582a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@Nullable Object obj) {
            return a().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return Maps.c(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (Objects.a(obj, entry.getValue())) {
                        a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            try {
                Preconditions.a(collection);
                return super.removeAll(collection);
            } catch (UnsupportedOperationException unused) {
                HashSet a2 = Sets.a();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        a2.add(entry.getKey());
                    }
                }
                return a().keySet().removeAll(a2);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            try {
                Preconditions.a(collection);
                return super.retainAll(collection);
            } catch (UnsupportedOperationException unused) {
                HashSet a2 = Sets.a();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        a2.add(entry.getKey());
                    }
                }
                return a().keySet().retainAll(a2);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    @GwtCompatible
    /* loaded from: classes2.dex */
    static abstract class j<K, V> extends AbstractMap<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private transient Set<Map.Entry<K, V>> f15583a;

        /* renamed from: b, reason: collision with root package name */
        private transient Set<K> f15584b;

        /* renamed from: c, reason: collision with root package name */
        private transient Collection<V> f15585c;

        abstract Set<Map.Entry<K, V>> a();

        Set<K> b() {
            return new e(this);
        }

        Collection<V> c() {
            return new i(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f15583a;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> a2 = a();
            this.f15583a = a2;
            return a2;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            Set<K> set = this.f15584b;
            if (set != null) {
                return set;
            }
            Set<K> b2 = b();
            this.f15584b = b2;
            return b2;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.f15585c;
            if (collection != null) {
                return collection;
            }
            Collection<V> c2 = c();
            this.f15585c = c2;
            return c2;
        }
    }

    private Maps() {
    }

    public static <K, V> HashMap<K, V> b(int i2) {
        return new HashMap<>(a(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Iterator<V> c(Iterator<Map.Entry<K, V>> it) {
        return Iterators.a((Iterator) it, f());
    }

    public static <K, V> LinkedHashMap<K, V> d() {
        return new LinkedHashMap<>();
    }

    public static <K extends Comparable, V> TreeMap<K, V> e() {
        return new TreeMap<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> Function<Map.Entry<?, V>, V> f() {
        return EntryFunction.VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K> Function<Map.Entry<K, ?>, K> a() {
        return EntryFunction.KEY;
    }

    public static <K, V> ConcurrentMap<K, V> b() {
        return new MapMaker().f();
    }

    public static <K, V> HashMap<K, V> c() {
        return new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(Map<?, ?> map, Object obj) {
        Preconditions.a(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> V e(Map<?, V> map, @Nullable Object obj) {
        Preconditions.a(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> V f(Map<?, V> map, Object obj) {
        Preconditions.a(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Iterator<K> a(Iterator<Map.Entry<K, V>> it) {
        return Iterators.a((Iterator) it, a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Iterator<Map.Entry<K, V>> b(Set<K> set, Function<? super K, V> function) {
        return new Ha(set.iterator(), function);
    }

    public static <K, V> LinkedHashMap<K, V> c(int i2) {
        return new LinkedHashMap<>(a(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i2) {
        if (i2 >= 3) {
            return i2 < 1073741824 ? (int) ((i2 / 0.75f) + 1.0f) : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        C1555x.a(i2, "expectedSize");
        return i2 + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Set<E> b(Set<E> set) {
        return new Ia(set);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static <K, V> Map<K, V> a(Set<K> set, Function<? super K, V> function) {
        return new a(set, function);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Map.Entry<K, V> b(Map.Entry<? extends K, ? extends V> entry) {
        Preconditions.a(entry);
        return new Ja(entry);
    }

    public static <K, V> Map.Entry<K, V> a(@Nullable K k, @Nullable V v) {
        return new ImmutableEntry(k, v);
    }

    public static <K, V1, V2> Map<K, V2> a(Map<K, V1> map, Function<? super V1, V2> function) {
        return a((Map) map, a(function));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> UnmodifiableIterator<Map.Entry<K, V>> b(Iterator<Map.Entry<K, V>> it) {
        return new Ka(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static <V> V c(@Nullable Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public static <K, V1, V2> Map<K, V2> a(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new h(map, entryTransformer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V1, V2> Function<Map.Entry<K, V1>, V2> b(EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        Preconditions.a(entryTransformer);
        return new Na(entryTransformer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V1, V2> EntryTransformer<K, V1, V2> a(Function<? super V1, V2> function) {
        Preconditions.a(function);
        return new La(function);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> Predicate<Map.Entry<?, V>> b(Predicate<? super V> predicate) {
        return Predicates.a(predicate, f());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V1, V2> Function<V1, V2> a(EntryTransformer<? super K, V1, V2> entryTransformer, K k) {
        Preconditions.a(entryTransformer);
        return new Ma(entryTransformer, k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Map<?, ?> map, @Nullable Object obj) {
        return Iterators.a((Iterator<?>) c(map.entrySet().iterator()), obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> boolean b(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.remove(b((Map.Entry) obj));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V2, K, V1> Map.Entry<K, V2> a(EntryTransformer<? super K, ? super V1, V2> entryTransformer, Map.Entry<K, V1> entry) {
        Preconditions.a(entryTransformer);
        Preconditions.a(entry);
        return new Fa(entry, entryTransformer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V1, V2> Function<Map.Entry<K, V1>, Map.Entry<K, V2>> a(EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        Preconditions.a(entryTransformer);
        return new Ga(entryTransformer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K> Predicate<Map.Entry<K, ?>> a(Predicate<? super K> predicate) {
        return Predicates.a(predicate, a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Map<?, ?> map, @Nullable Object obj) {
        return Iterators.a((Iterator<?>) a(map.entrySet().iterator()), obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> boolean a(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.contains(b((Map.Entry) obj));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Map<?, ?> map) {
        StringBuilder a2 = Collections2.a(map.size());
        a2.append('{');
        f15573a.a(a2, map);
        a2.append('}');
        return a2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void a(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry<? extends K, ? extends V> entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static <K> K a(@Nullable Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableMap<E, Integer> a(Collection<E> collection) {
        ImmutableMap.Builder builder = new ImmutableMap.Builder(collection.size());
        Iterator<E> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            builder.a(it.next(), Integer.valueOf(i2));
            i2++;
        }
        return builder.a();
    }
}
