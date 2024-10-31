package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class Multimaps {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {

        @GwtIncompatible
        private static final long serialVersionUID = 0;
        transient Supplier<? extends List<V>> factory;

        CustomListMultimap(Map<K, Collection<V>> map, Supplier<? extends List<V>> supplier) {
            super(map);
            Preconditions.a(supplier);
            this.factory = supplier;
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (Supplier) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public List<V> createCollection() {
            return this.factory.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {

        @GwtIncompatible
        private static final long serialVersionUID = 0;
        transient Supplier<? extends Set<V>> factory;

        CustomSetMultimap(Map<K, Collection<V>> map, Supplier<? extends Set<V>> supplier) {
            super(map);
            Preconditions.a(supplier);
            this.factory = supplier;
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (Supplier) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public Set<V> createCollection() {
            return this.factory.get();
        }
    }

    /* loaded from: classes2.dex */
    static final class a<K, V> extends Maps.j<K, Collection<V>> {

        /* renamed from: d, reason: collision with root package name */
        @Weak
        private final Multimap<K, V> f15605d;

        /* renamed from: com.google.common.collect.Multimaps$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0090a extends Maps.c<K, Collection<V>> {
            C0090a() {
            }

            @Override // com.google.common.collect.Maps.c
            Map<K, Collection<V>> a() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return Maps.b((Set) a.this.f15605d.keySet(), (Function) new Wa(this));
            }

            @Override // com.google.common.collect.Maps.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                a.this.a(((Map.Entry) obj).getKey());
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Multimap<K, V> multimap) {
            Preconditions.a(multimap);
            this.f15605d = multimap;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f15605d.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f15605d.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f15605d.isEmpty();
        }

        @Override // com.google.common.collect.Maps.j, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f15605d.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f15605d.keySet().size();
        }

        @Override // com.google.common.collect.Maps.j
        protected Set<Map.Entry<K, Collection<V>>> a() {
            return new C0090a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> get(Object obj) {
            if (containsKey(obj)) {
                return this.f15605d.get(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> remove(Object obj) {
            if (containsKey(obj)) {
                return this.f15605d.removeAll(obj);
            }
            return null;
        }

        void a(Object obj) {
            this.f15605d.keySet().remove(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class b<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        abstract Multimap<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@Nullable Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@Nullable Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c<K, V> extends AbstractC1522l<K> {

        /* renamed from: c, reason: collision with root package name */
        @Weak
        final Multimap<K, V> f15607c;

        /* loaded from: classes2.dex */
        class a extends Multisets.c<K> {
            a() {
            }

            @Override // com.google.common.collect.Multisets.c
            Multiset<K> a() {
                return c.this;
            }

            @Override // com.google.common.collect.Multisets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@Nullable Object obj) {
                if (!(obj instanceof Multiset.Entry)) {
                    return false;
                }
                Multiset.Entry entry = (Multiset.Entry) obj;
                Collection<V> collection = c.this.f15607c.asMap().get(entry.getElement());
                return collection != null && collection.size() == entry.getCount();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return c.this.f15607c.isEmpty();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Multiset.Entry<K>> iterator() {
                return c.this.entryIterator();
            }

            @Override // com.google.common.collect.Multisets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@Nullable Object obj) {
                if (!(obj instanceof Multiset.Entry)) {
                    return false;
                }
                Multiset.Entry entry = (Multiset.Entry) obj;
                Collection<V> collection = c.this.f15607c.asMap().get(entry.getElement());
                if (collection == null || collection.size() != entry.getCount()) {
                    return false;
                }
                collection.clear();
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return c.this.distinctElements();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(Multimap<K, V> multimap) {
            this.f15607c = multimap;
        }

        @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f15607c.clear();
        }

        @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(@Nullable Object obj) {
            return this.f15607c.containsKey(obj);
        }

        @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
        public int count(@Nullable Object obj) {
            Collection collection = (Collection) Maps.e(this.f15607c.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        @Override // com.google.common.collect.AbstractC1522l
        Set<Multiset.Entry<K>> createEntrySet() {
            return new a();
        }

        @Override // com.google.common.collect.AbstractC1522l
        int distinctElements() {
            return this.f15607c.asMap().size();
        }

        @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
        public Set<K> elementSet() {
            return this.f15607c.keySet();
        }

        @Override // com.google.common.collect.AbstractC1522l
        Iterator<Multiset.Entry<K>> entryIterator() {
            return new Ya(this, this.f15607c.asMap().entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return Maps.a(this.f15607c.entries().iterator());
        }

        @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
        public int remove(@Nullable Object obj, int i) {
            C1555x.a(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            Collection collection = (Collection) Maps.e(this.f15607c.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i >= size) {
                collection.clear();
            } else {
                Iterator it = collection.iterator();
                for (int i2 = 0; i2 < i; i2++) {
                    it.next();
                    it.remove();
                }
            }
            return size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class d<K, V1, V2> extends e<K, V1, V2> implements ListMultimap<K, V2> {
        d(ListMultimap<K, V1> listMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(listMultimap, entryTransformer);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.e
        /* bridge */ /* synthetic */ Collection a(Object obj, Collection collection) {
            return a((d<K, V1, V2>) obj, collection);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.e, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((d<K, V1, V2>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.AbstractC1519k
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            replaceValues((d<K, V1, V2>) obj, iterable);
            throw null;
        }

        @Override // com.google.common.collect.Multimaps.e
        List<V2> a(K k, Collection<V1> collection) {
            return Lists.a((List) collection, Maps.a((Maps.EntryTransformer) this.f15610g, (Object) k));
        }

        @Override // com.google.common.collect.Multimaps.e, com.google.common.collect.Multimap
        public List<V2> get(K k) {
            return a((d<K, V1, V2>) k, (Collection) this.f15609f.get(k));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimap
        public List<V2> removeAll(Object obj) {
            return a((d<K, V1, V2>) obj, (Collection) this.f15609f.removeAll(obj));
        }

        @Override // com.google.common.collect.AbstractC1519k
        public List<V2> replaceValues(K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class e<K, V1, V2> extends AbstractC1519k<K, V2> {

        /* renamed from: f, reason: collision with root package name */
        final Multimap<K, V1> f15609f;

        /* renamed from: g, reason: collision with root package name */
        final Maps.EntryTransformer<? super K, ? super V1, V2> f15610g;

        e(Multimap<K, V1> multimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            Preconditions.a(multimap);
            this.f15609f = multimap;
            Preconditions.a(entryTransformer);
            this.f15610g = entryTransformer;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Collection<V2> a(K k, Collection<V1> collection) {
            throw null;
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            this.f15609f.clear();
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(Object obj) {
            return this.f15609f.containsKey(obj);
        }

        @Override // com.google.common.collect.AbstractC1519k
        Map<K, Collection<V2>> createAsMap() {
            return Maps.a((Map) this.f15609f.asMap(), (Maps.EntryTransformer) new Za(this));
        }

        @Override // com.google.common.collect.AbstractC1519k
        Collection<V2> createValues() {
            return Collections2.a((Collection) this.f15609f.entries(), Maps.b(this.f15610g));
        }

        @Override // com.google.common.collect.AbstractC1519k
        Iterator<Map.Entry<K, V2>> entryIterator() {
            return Iterators.a((Iterator) this.f15609f.entries().iterator(), Maps.a(this.f15610g));
        }

        @Override // com.google.common.collect.Multimap
        public Collection<V2> get(K k) {
            throw null;
        }

        @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
        public boolean isEmpty() {
            return this.f15609f.isEmpty();
        }

        @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
        public Set<K> keySet() {
            return this.f15609f.keySet();
        }

        @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
        public Multiset<K> keys() {
            return this.f15609f.keys();
        }

        @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
        public boolean put(K k, V2 v2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
        public boolean putAll(K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
        public boolean remove(Object obj, Object obj2) {
            return get(obj).remove(obj2);
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            return this.f15609f.size();
        }

        @Override // com.google.common.collect.AbstractC1519k
        public boolean putAll(Multimap<? extends K, ? extends V2> multimap) {
            throw new UnsupportedOperationException();
        }
    }

    private Multimaps() {
    }

    public static <K, V> ListMultimap<K, V> a(Map<K, Collection<V>> map, Supplier<? extends List<V>> supplier) {
        return new CustomListMultimap(map, supplier);
    }

    public static <K, V> SetMultimap<K, V> b(Map<K, Collection<V>> map, Supplier<? extends Set<V>> supplier) {
        return new CustomSetMultimap(map, supplier);
    }

    public static <K, V1, V2> ListMultimap<K, V2> a(ListMultimap<K, V1> listMultimap, Function<? super V1, V2> function) {
        Preconditions.a(function);
        return a((ListMultimap) listMultimap, Maps.a(function));
    }

    public static <K, V1, V2> ListMultimap<K, V2> a(ListMultimap<K, V1> listMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new d(listMultimap, entryTransformer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Multimap<?, ?> multimap, @Nullable Object obj) {
        if (obj == multimap) {
            return true;
        }
        if (obj instanceof Multimap) {
            return multimap.asMap().equals(((Multimap) obj).asMap());
        }
        return false;
    }
}
