package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
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

@GwtCompatible
/* loaded from: classes2.dex */
public final class Multimaps {
    private Multimaps() {
    }

    public static <K, V> SetMultimap<K, V> a(Map<K, Collection<V>> map, Supplier<? extends Set<V>> supplier) {
        return new CustomSetMultimap(map, supplier);
    }

    /* loaded from: classes2.dex */
    public static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {

        @GwtIncompatible
        private static final long serialVersionUID = 0;
        transient Supplier<? extends Set<V>> factory;

        CustomSetMultimap(Map<K, Collection<V>> map, Supplier<? extends Set<V>> supplier) {
            super(map);
            this.factory = (Supplier) Preconditions.a(supplier);
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap
        public Set<V> createCollection() {
            return this.factory.get();
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (Supplier) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }
    }

    /* loaded from: classes2.dex */
    public static class f<K, V1, V2> implements Multimap<K, V2> {

        /* renamed from: a */
        final Multimap<K, V1> f2745a;
        final Maps.EntryTransformer<? super K, ? super V1, V2> b;
        private transient Map<K, Collection<V2>> c;
        private transient Collection<Map.Entry<K, V2>> d;
        private transient Collection<V2> e;

        f(Multimap<K, V1> multimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            this.f2745a = (Multimap) Preconditions.a(multimap);
            this.b = (Maps.EntryTransformer) Preconditions.a(entryTransformer);
        }

        public Collection<V2> b(K k, Collection<V1> collection) {
            return Collections2.a(collection, new cg(this, k));
        }

        @Override // com.google.common.collect.Multimap
        public Map<K, Collection<V2>> asMap() {
            if (this.c != null) {
                return this.c;
            }
            Map<K, Collection<V2>> a2 = Maps.a((Map) this.f2745a.asMap(), (Maps.EntryTransformer) new ch(this));
            this.c = a2;
            return a2;
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            this.f2745a.clear();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimap
        public boolean containsEntry(Object obj, Object obj2) {
            return get(obj).contains(obj2);
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(Object obj) {
            return this.f2745a.containsKey(obj);
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsValue(Object obj) {
            return values().contains(obj);
        }

        @Override // com.google.common.collect.Multimap
        public Collection<Map.Entry<K, V2>> entries() {
            if (this.d != null) {
                return this.d;
            }
            a aVar = new a(this.b);
            this.d = aVar;
            return aVar;
        }

        /* loaded from: classes2.dex */
        private class a extends Collections2.a<Map.Entry<K, V1>, Map.Entry<K, V2>> {
            a(Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
                super(f.this.f2745a.entries(), new cj(f.this, entryTransformer));
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return f.this.containsEntry(entry.getKey(), entry.getValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return f.this.get(entry.getKey()).remove(entry.getValue());
            }
        }

        @Override // com.google.common.collect.Multimap
        public Collection<V2> get(K k) {
            return b(k, this.f2745a.get(k));
        }

        @Override // com.google.common.collect.Multimap
        public boolean isEmpty() {
            return this.f2745a.isEmpty();
        }

        @Override // com.google.common.collect.Multimap
        public Set<K> keySet() {
            return this.f2745a.keySet();
        }

        @Override // com.google.common.collect.Multimap
        public Multiset<K> keys() {
            return this.f2745a.keys();
        }

        @Override // com.google.common.collect.Multimap
        public boolean put(K k, V2 v2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimap
        public boolean putAll(K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V2> multimap) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimap
        public boolean remove(Object obj, Object obj2) {
            return get(obj).remove(obj2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimap
        public Collection<V2> removeAll(Object obj) {
            return b(obj, this.f2745a.removeAll(obj));
        }

        @Override // com.google.common.collect.Multimap
        public Collection<V2> replaceValues(K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            return this.f2745a.size();
        }

        @Override // com.google.common.collect.Multimap
        public Collection<V2> values() {
            if (this.e != null) {
                return this.e;
            }
            Collection<V2> a2 = Collections2.a((Collection) this.f2745a.entries(), (Function) new ci(this));
            this.e = a2;
            return a2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Multimap) {
                return asMap().equals(((Multimap) obj).asMap());
            }
            return false;
        }

        public int hashCode() {
            return asMap().hashCode();
        }

        public String toString() {
            return asMap().toString();
        }
    }

    public static <K, V1, V2> ListMultimap<K, V2> a(ListMultimap<K, V1> listMultimap, Function<? super V1, V2> function) {
        Preconditions.a(function);
        return a(listMultimap, new cc(function));
    }

    public static <K, V1, V2> ListMultimap<K, V2> a(ListMultimap<K, V1> listMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new e(listMultimap, entryTransformer);
    }

    /* loaded from: classes2.dex */
    public static final class e<K, V1, V2> extends f<K, V1, V2> implements ListMultimap<K, V2> {
        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.f
        public /* synthetic */ Collection b(Object obj, Collection collection) {
            return a((e<K, V1, V2>) obj, collection);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.f, com.google.common.collect.Multimap
        public /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return a((e<K, V1, V2>) obj, iterable);
        }

        e(ListMultimap<K, V1> listMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(listMultimap, entryTransformer);
        }

        List<V2> a(K k, Collection<V1> collection) {
            return Lists.a((List) collection, (Function) new cf(this, k));
        }

        @Override // com.google.common.collect.Multimaps.f, com.google.common.collect.Multimap
        /* renamed from: a */
        public List<V2> get(K k) {
            return a((e<K, V1, V2>) k, (Collection) this.f2745a.get(k));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.f, com.google.common.collect.Multimap
        /* renamed from: b */
        public List<V2> removeAll(Object obj) {
            return a((e<K, V1, V2>) obj, (Collection) this.f2745a.removeAll(obj));
        }

        public List<V2> a(K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class d<K, V> extends l<K> {
        abstract Multimap<K, V> a();

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.l
        public Iterator<Multiset.Entry<K>> entryIterator() {
            return new cd(this, a().asMap().entrySet().iterator());
        }

        @Override // com.google.common.collect.l
        int distinctElements() {
            return a().asMap().size();
        }

        @Override // com.google.common.collect.l
        Set<Multiset.Entry<K>> createEntrySet() {
            return new a();
        }

        /* loaded from: classes2.dex */
        class a extends Multisets.c<K> {
            a() {
            }

            @Override // com.google.common.collect.Multisets.c
            Multiset<K> a() {
                return d.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Multiset.Entry<K>> iterator() {
                return d.this.entryIterator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return d.this.distinctElements();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return d.this.a().isEmpty();
            }

            @Override // com.google.common.collect.Multisets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@Nullable Object obj) {
                if (!(obj instanceof Multiset.Entry)) {
                    return false;
                }
                Multiset.Entry entry = (Multiset.Entry) obj;
                Collection<V> collection = d.this.a().asMap().get(entry.getElement());
                return collection != null && collection.size() == entry.getCount();
            }

            @Override // com.google.common.collect.Multisets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@Nullable Object obj) {
                if (obj instanceof Multiset.Entry) {
                    Multiset.Entry entry = (Multiset.Entry) obj;
                    Collection<V> collection = d.this.a().asMap().get(entry.getElement());
                    if (collection != null && collection.size() == entry.getCount()) {
                        collection.clear();
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(@Nullable Object obj) {
            return a().containsKey(obj);
        }

        @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return Maps.a(a().entries().iterator());
        }

        @Override // com.google.common.collect.l, com.google.common.collect.Multiset
        public int count(@Nullable Object obj) {
            try {
                if (!a().containsKey(obj)) {
                    return 0;
                }
                Collection<V> collection = a().asMap().get(obj);
                return collection == null ? 0 : collection.size();
            } catch (ClassCastException e) {
                return 0;
            } catch (NullPointerException e2) {
                return 0;
            }
        }

        @Override // com.google.common.collect.l, com.google.common.collect.Multiset
        public int remove(@Nullable Object obj, int i) {
            Preconditions.a(i >= 0);
            if (i == 0) {
                return count(obj);
            }
            try {
                Collection<V> collection = a().asMap().get(obj);
                if (collection == null) {
                    return 0;
                }
                int size = collection.size();
                if (i >= size) {
                    collection.clear();
                } else {
                    Iterator<V> it = collection.iterator();
                    for (int i2 = 0; i2 < i; i2++) {
                        it.next();
                        it.remove();
                    }
                }
                return size;
            } catch (ClassCastException e) {
                return 0;
            } catch (NullPointerException e2) {
                return 0;
            }
        }

        @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // com.google.common.collect.l, com.google.common.collect.Multiset
        public Set<K> elementSet() {
            return a().keySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class g<K, V> extends AbstractCollection<V> {
        abstract Multimap<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return Maps.b(a().entries().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class b<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        abstract Multimap<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
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
        public void clear() {
            a().clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class c<K, V> extends b<K, V> implements Set<Map.Entry<K, V>> {
        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.a(this);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@Nullable Object obj) {
            return Sets.a(this, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class a<K, V> extends Maps.b<K, Collection<V>> {
        abstract Multimap<K, V> a();

        abstract Iterator<Map.Entry<K, Collection<V>>> c();

        @Override // com.google.common.collect.Maps.b
        protected Set<Map.Entry<K, Collection<V>>> b() {
            return new C0049a();
        }

        void a(Object obj) {
            a().removeAll(obj);
        }

        /* renamed from: com.google.common.collect.Multimaps$a$a */
        /* loaded from: classes2.dex */
        class C0049a extends Maps.a<K, Collection<V>> {
            C0049a() {
            }

            @Override // com.google.common.collect.Maps.a
            Map<K, Collection<V>> a() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return a.this.c();
            }

            @Override // com.google.common.collect.Maps.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                a.this.a(((Map.Entry) obj).getKey());
                return true;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: b */
        public Collection<V> get(Object obj) {
            if (containsKey(obj)) {
                return a().get(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: c */
        public Collection<V> remove(Object obj) {
            if (containsKey(obj)) {
                return a().removeAll(obj);
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.b, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return a().keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return a().containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            a().clear();
        }
    }
}
