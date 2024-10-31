package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements SortedMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator<Comparable> f2702a = Ordering.natural();
    private static final ImmutableSortedMap<Comparable, Object> b = new EmptyImmutableSortedMap(f2702a);
    private static final long serialVersionUID = 0;
    private transient ImmutableSortedMap<K, V> c;

    abstract ImmutableSortedMap<K, V> createDescendingMap();

    public abstract ImmutableSortedMap<K, V> headMap(K k, boolean z);

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public abstract ImmutableSortedSet<K> keySet();

    public abstract ImmutableSortedMap<K, V> tailMap(K k, boolean z);

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public abstract ImmutableCollection<V> values();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
        return headMap((ImmutableSortedMap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap((ImmutableSortedMap<K, V>) obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> comparator) {
        return Ordering.natural().equals(comparator) ? of() : new EmptyImmutableSortedMap(comparator);
    }

    static <K, V> ImmutableSortedMap<K, V> fromSortedEntries(Comparator<? super K> comparator, Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        if (collection.isEmpty()) {
            return emptyMap(comparator);
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList.Builder builder2 = ImmutableList.builder();
        for (Map.Entry<? extends K, ? extends V> entry : collection) {
            builder.b((ImmutableList.Builder) entry.getKey());
            builder2.b((ImmutableList.Builder) entry.getValue());
        }
        return new RegularImmutableSortedMap(new RegularImmutableSortedSet(builder.a(), comparator), builder2.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> ImmutableSortedMap<K, V> from(ImmutableSortedSet<K> immutableSortedSet, ImmutableList<V> immutableList) {
        return immutableSortedSet.isEmpty() ? emptyMap(immutableSortedSet.comparator()) : new RegularImmutableSortedMap((RegularImmutableSortedSet) immutableSortedSet, immutableList);
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        return (ImmutableSortedMap<K, V>) b;
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj) {
        return from(ImmutableSortedSet.of(comparable), ImmutableList.of(obj));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2) {
        return new Builder(Ordering.natural()).b(comparable, obj).b(comparable2, obj2).b();
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3) {
        return new Builder(Ordering.natural()).b(comparable, obj).b(comparable2, obj2).b(comparable3, obj3).b();
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4) {
        return new Builder(Ordering.natural()).b(comparable, obj).b(comparable2, obj2).b(comparable3, obj3).b(comparable4, obj4).b();
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5) {
        return new Builder(Ordering.natural()).b(comparable, obj).b(comparable2, obj2).b(comparable3, obj3).b(comparable4, obj4).b(comparable5, obj5).b();
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        return a(map, Ordering.natural());
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        return a(map, (Comparator) Preconditions.a(comparator));
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> sortedMap) {
        Comparator<? super K> comparator = sortedMap.comparator();
        if (comparator == null) {
            comparator = f2702a;
        }
        return a(sortedMap, comparator);
    }

    private static <K, V> ImmutableSortedMap<K, V> a(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        boolean z;
        if (map instanceof SortedMap) {
            Comparator<? super K> comparator2 = ((SortedMap) map).comparator();
            z = comparator2 == null ? comparator == f2702a : comparator.equals(comparator2);
        } else {
            z = false;
        }
        if (z && (map instanceof ImmutableSortedMap)) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) map;
            if (!immutableSortedMap.isPartialView()) {
                return immutableSortedMap;
            }
        }
        Map.Entry[] entryArr = (Map.Entry[]) map.entrySet().toArray(new Map.Entry[0]);
        for (int i = 0; i < entryArr.length; i++) {
            Map.Entry entry = entryArr[i];
            entryArr[i] = entryOf(entry.getKey(), entry.getValue());
        }
        List asList = Arrays.asList(entryArr);
        if (!z) {
            a(asList, comparator);
            b(asList, comparator);
        }
        return fromSortedEntries(comparator, asList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void a(List<Map.Entry<K, V>> list, Comparator<? super K> comparator) {
        Collections.sort(list, new ai(comparator));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void b(List<Map.Entry<K, V>> list, Comparator<? super K> comparator) {
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (comparator.compare(list.get(i2 - 1).getKey(), list.get(i2).getKey()) != 0) {
                    i = i2 + 1;
                } else {
                    throw new IllegalArgumentException("Duplicate keys in mappings " + list.get(i2 - 1) + " and " + list.get(i2));
                }
            } else {
                return;
            }
        }
    }

    public static <K extends Comparable<K>, V> Builder<K, V> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    public static <K, V> Builder<K, V> orderedBy(Comparator<K> comparator) {
        return new Builder<>(comparator);
    }

    public static <K extends Comparable<K>, V> Builder<K, V> reverseOrder() {
        return new Builder<>(Ordering.natural().reverse());
    }

    /* loaded from: classes2.dex */
    public static class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        private final Comparator<? super K> b;

        public Builder(Comparator<? super K> comparator) {
            this.b = (Comparator) Preconditions.a(comparator);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Builder<K, V> b(K k, V v) {
            this.f2693a.add(ImmutableMap.entryOf(k, v));
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Builder<K, V> b(Map<? extends K, ? extends V> map) {
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                b(entry.getKey(), entry.getValue());
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedMap<K, V> b() {
            ImmutableSortedMap.a(this.f2693a, this.b);
            ImmutableSortedMap.b(this.f2693a, this.b);
            return ImmutableSortedMap.fromSortedEntries(this.b, this.f2693a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSortedMap() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSortedMap(ImmutableSortedMap<K, V> immutableSortedMap) {
        this.c = immutableSortedMap;
    }

    public int size() {
        return values().size();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsValue(@Nullable Object obj) {
        return values().contains(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return keySet().isPartialView() || values().isPartialView();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return keySet().first();
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return keySet().last();
    }

    @Override // java.util.SortedMap
    public ImmutableSortedMap<K, V> headMap(K k) {
        return headMap(k, false);
    }

    @Override // java.util.SortedMap
    public ImmutableSortedMap<K, V> subMap(K k, K k2) {
        return subMap(k, true, k2, false);
    }

    public ImmutableSortedMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        Preconditions.a(k);
        Preconditions.a(k2);
        Preconditions.a(comparator().compare(k, k2) <= 0, "expected fromKey <= toKey but %s > %s", k, k2);
        return headMap(k2, z2).tailMap(k, z);
    }

    @Override // java.util.SortedMap
    public ImmutableSortedMap<K, V> tailMap(K k) {
        return tailMap(k, true);
    }

    public Map.Entry<K, V> lowerEntry(K k) {
        return headMap(k, false).lastEntry();
    }

    public K lowerKey(K k) {
        return (K) Maps.b(lowerEntry(k));
    }

    public Map.Entry<K, V> floorEntry(K k) {
        return headMap(k, true).lastEntry();
    }

    public K floorKey(K k) {
        return (K) Maps.b(floorEntry(k));
    }

    public Map.Entry<K, V> ceilingEntry(K k) {
        return tailMap(k, true).firstEntry();
    }

    public K ceilingKey(K k) {
        return (K) Maps.b(ceilingEntry(k));
    }

    public Map.Entry<K, V> higherEntry(K k) {
        return tailMap(k, false).firstEntry();
    }

    public K higherKey(K k) {
        return (K) Maps.b(higherEntry(k));
    }

    public Map.Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(0);
    }

    public Map.Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(size() - 1);
    }

    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> immutableSortedMap = this.c;
        if (immutableSortedMap == null) {
            ImmutableSortedMap<K, V> createDescendingMap = createDescendingMap();
            this.c = createDescendingMap;
            return createDescendingMap;
        }
        return immutableSortedMap;
    }

    public ImmutableSortedSet<K> navigableKeySet() {
        return keySet();
    }

    public ImmutableSortedSet<K> descendingKeySet() {
        return keySet().descendingSet();
    }

    /* loaded from: classes2.dex */
    private static class SerializedForm extends ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0;
        private final Comparator<Object> comparator;

        SerializedForm(ImmutableSortedMap<?, ?> immutableSortedMap) {
            super(immutableSortedMap);
            this.comparator = immutableSortedMap.comparator();
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        Object readResolve() {
            return createMap(new Builder(this.comparator));
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new SerializedForm(this);
    }
}
