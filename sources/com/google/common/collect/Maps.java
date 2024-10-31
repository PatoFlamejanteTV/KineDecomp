package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes.dex */
public final class Maps {

    /* renamed from: a, reason: collision with root package name */
    static final Joiner.MapJoiner f2736a = Collections2.f2661a.c("=");

    /* loaded from: classes2.dex */
    public interface EntryTransformer<K, V1, V2> {
        V2 a(@Nullable K k, @Nullable V1 v1);
    }

    private Maps() {
    }

    public static <K, V> HashMap<K, V> a() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> a(int i) {
        return new HashMap<>(b(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i) {
        if (i < 3) {
            Preconditions.a(i >= 0);
            return i + 1;
        }
        if (i < 1073741824) {
            return (i / 3) + i;
        }
        return Integer.MAX_VALUE;
    }

    public static <K, V> LinkedHashMap<K, V> b() {
        return new LinkedHashMap<>();
    }

    @GwtCompatible
    public static <K, V> Map.Entry<K, V> a(@Nullable K k, @Nullable V v) {
        return new ImmutableEntry(k, v);
    }

    static <K, V> Map.Entry<K, V> a(Map.Entry<K, V> entry) {
        Preconditions.a(entry);
        return new br(entry);
    }

    public static <K, V1, V2> Map<K, V2> a(Map<K, V1> map, Function<? super V1, V2> function) {
        return a((Map) map, a(function));
    }

    private static <K, V1, V2> EntryTransformer<K, V1, V2> a(Function<? super V1, V2> function) {
        Preconditions.a(function);
        return new bs(function);
    }

    public static <K, V1, V2> Map<K, V2> a(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return map instanceof SortedMap ? a((SortedMap) map, (EntryTransformer) entryTransformer) : new d(map, entryTransformer);
    }

    @Beta
    public static <K, V1, V2> SortedMap<K, V2> a(SortedMap<K, V1> sortedMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new e(sortedMap, entryTransformer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class d<K, V1, V2> extends AbstractMap<K, V2> {

        /* renamed from: a, reason: collision with root package name */
        final Map<K, V1> f2738a;
        final EntryTransformer<? super K, ? super V1, V2> b;
        Set<Map.Entry<K, V2>> c;
        Collection<V2> d;

        d(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            this.f2738a = (Map) Preconditions.a(map);
            this.b = (EntryTransformer) Preconditions.a(entryTransformer);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f2738a.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f2738a.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 get(Object obj) {
            V1 v1 = this.f2738a.get(obj);
            if (v1 != null || this.f2738a.containsKey(obj)) {
                return this.b.a(obj, v1);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 remove(Object obj) {
            if (this.f2738a.containsKey(obj)) {
                return this.b.a(obj, this.f2738a.remove(obj));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f2738a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f2738a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V2>> entrySet() {
            Set<Map.Entry<K, V2>> set = this.c;
            if (set == null) {
                by byVar = new by(this);
                this.c = byVar;
                return byVar;
            }
            return set;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V2> values() {
            Collection<V2> collection = this.d;
            if (collection == null) {
                cb cbVar = new cb(this);
                this.d = cbVar;
                return cbVar;
            }
            return collection;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class e<K, V1, V2> extends d<K, V1, V2> implements SortedMap<K, V2> {
        protected SortedMap<K, V1> a() {
            return (SortedMap) this.f2738a;
        }

        e(SortedMap<K, V1> sortedMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(sortedMap, entryTransformer);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return a().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return a().firstKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V2> headMap(K k) {
            return Maps.a((SortedMap) a().headMap(k), (EntryTransformer) this.b);
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return a().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V2> subMap(K k, K k2) {
            return Maps.a((SortedMap) a().subMap(k, k2), (EntryTransformer) this.b);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V2> tailMap(K k) {
            return Maps.a((SortedMap) a().tailMap(k), (EntryTransformer) this.b);
        }
    }

    @GwtCompatible
    /* loaded from: classes2.dex */
    static abstract class b<K, V> extends AbstractMap<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private Set<Map.Entry<K, V>> f2737a;
        private Set<K> b;
        private Collection<V> c;

        protected abstract Set<Map.Entry<K, V>> b();

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f2737a;
            if (set == null) {
                Set<Map.Entry<K, V>> b = b();
                this.f2737a = b;
                return b;
            }
            return set;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            Set<K> set = this.b;
            if (set == null) {
                bw bwVar = new bw(this);
                this.b = bwVar;
                return bwVar;
            }
            return set;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.c;
            if (collection == null) {
                bx bxVar = new bx(this);
                this.c = bxVar;
                return bxVar;
            }
            return collection;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> V a(Map<?, V> map, Object obj) {
        try {
            return map.get(obj);
        } catch (ClassCastException e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Map<?, ?> map, Object obj) {
        try {
            return map.containsKey(obj);
        } catch (ClassCastException e2) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> boolean a(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.contains(a((Map.Entry) obj));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> boolean b(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.remove(a((Map.Entry) obj));
        }
        return false;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Map<?, ?> map) {
        StringBuilder append = Collections2.a(map.size()).append('{');
        f2736a.a(append, map);
        return append.append('}').toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void a(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry<? extends K, ? extends V> entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(Map<?, ?> map, @Nullable Object obj) {
        Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (Objects.a(it.next().getKey(), obj)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(Map<?, ?> map, @Nullable Object obj) {
        Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (Objects.a(it.next().getValue(), obj)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Iterator<K> a(Iterator<Map.Entry<K, V>> it) {
        return new bt(it);
    }

    /* loaded from: classes2.dex */
    static abstract class c<K, V> extends Sets.a<K> {
        abstract Map<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.a(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return a().containsKey(obj);
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
        public void clear() {
            a().clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static <K> K b(@Nullable Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Iterator<V> b(Iterator<Map.Entry<K, V>> it) {
        return new bu(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> UnmodifiableIterator<V> a(UnmodifiableIterator<Map.Entry<K, V>> unmodifiableIterator) {
        return new bv(unmodifiableIterator);
    }

    /* loaded from: classes2.dex */
    static abstract class f<K, V> extends AbstractCollection<V> {
        abstract Map<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return Maps.b(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException e) {
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
                return super.removeAll((Collection) Preconditions.a(collection));
            } catch (UnsupportedOperationException e) {
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
                return super.retainAll((Collection) Preconditions.a(collection));
            } catch (UnsupportedOperationException e) {
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

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@Nullable Object obj) {
            return a().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }
    }

    /* loaded from: classes2.dex */
    static abstract class a<K, V> extends Sets.a<Map.Entry<K, V>> {
        abstract Map<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }

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
            V v = a().get(key);
            if (Objects.a(v, entry.getValue())) {
                return v != null || a().containsKey(key);
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

        @Override // com.google.common.collect.Sets.a, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Preconditions.a(collection));
            } catch (UnsupportedOperationException e) {
                boolean z = true;
                Iterator<?> it = collection.iterator();
                while (it.hasNext()) {
                    z |= remove(it.next());
                }
                return z;
            }
        }

        @Override // com.google.common.collect.Sets.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Preconditions.a(collection));
            } catch (UnsupportedOperationException e) {
                HashSet a2 = Sets.a(collection.size());
                for (Object obj : collection) {
                    if (contains(obj)) {
                        a2.add(((Map.Entry) obj).getKey());
                    }
                }
                return a().keySet().retainAll(a2);
            }
        }
    }
}
