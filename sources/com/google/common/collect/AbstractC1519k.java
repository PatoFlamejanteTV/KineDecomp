package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractMultimap.java */
@GwtCompatible
/* renamed from: com.google.common.collect.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1519k<K, V> implements Multimap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private transient Collection<Map.Entry<K, V>> f15806a;

    /* renamed from: b, reason: collision with root package name */
    private transient Set<K> f15807b;

    /* renamed from: c, reason: collision with root package name */
    private transient Multiset<K> f15808c;

    /* renamed from: d, reason: collision with root package name */
    private transient Collection<V> f15809d;

    /* renamed from: e, reason: collision with root package name */
    private transient Map<K, Collection<V>> f15810e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractMultimap.java */
    /* renamed from: com.google.common.collect.k$a */
    /* loaded from: classes2.dex */
    public class a extends Multimaps.b<K, V> {
        private a() {
        }

        @Override // com.google.common.collect.Multimaps.b
        Multimap<K, V> a() {
            return AbstractC1519k.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractC1519k.this.entryIterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractMultimap.java */
    /* renamed from: com.google.common.collect.k$b */
    /* loaded from: classes2.dex */
    public class b extends AbstractC1519k<K, V>.a implements Set<Map.Entry<K, V>> {
        private b() {
            super();
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
    /* compiled from: AbstractMultimap.java */
    /* renamed from: com.google.common.collect.k$c */
    /* loaded from: classes2.dex */
    public class c extends AbstractCollection<V> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractC1519k.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@Nullable Object obj) {
            return AbstractC1519k.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return AbstractC1519k.this.valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractC1519k.this.size();
        }
    }

    @Override // com.google.common.collect.Multimap
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map = this.f15810e;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> createAsMap = createAsMap();
        this.f15810e = createAsMap;
        return createAsMap;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsEntry(@Nullable Object obj, @Nullable Object obj2) {
        Collection<V> collection = asMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean containsValue(@Nullable Object obj) {
        Iterator<Collection<V>> it = asMap().values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    abstract Map<K, Collection<V>> createAsMap();

    Collection<Map.Entry<K, V>> createEntries() {
        if (this instanceof SetMultimap) {
            return new b();
        }
        return new a();
    }

    Set<K> createKeySet() {
        return new Maps.e(asMap());
    }

    Multiset<K> createKeys() {
        return new Multimaps.c(this);
    }

    Collection<V> createValues() {
        return new c();
    }

    @Override // com.google.common.collect.Multimap
    public Collection<Map.Entry<K, V>> entries() {
        Collection<Map.Entry<K, V>> collection = this.f15806a;
        if (collection != null) {
            return collection;
        }
        Collection<Map.Entry<K, V>> createEntries = createEntries();
        this.f15806a = createEntries;
        return createEntries;
    }

    abstract Iterator<Map.Entry<K, V>> entryIterator();

    @Override // com.google.common.collect.Multimap
    public boolean equals(@Nullable Object obj) {
        return Multimaps.a(this, obj);
    }

    @Override // com.google.common.collect.Multimap
    public int hashCode() {
        return asMap().hashCode();
    }

    @Override // com.google.common.collect.Multimap
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.common.collect.Multimap
    public Set<K> keySet() {
        Set<K> set = this.f15807b;
        if (set != null) {
            return set;
        }
        Set<K> createKeySet = createKeySet();
        this.f15807b = createKeySet;
        return createKeySet;
    }

    @Override // com.google.common.collect.Multimap
    public Multiset<K> keys() {
        Multiset<K> multiset = this.f15808c;
        if (multiset != null) {
            return multiset;
        }
        Multiset<K> createKeys = createKeys();
        this.f15808c = createKeys;
        return createKeys;
    }

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public abstract boolean put(@Nullable K k, @Nullable V v);

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean putAll(@Nullable K k, Iterable<? extends V> iterable) {
        Preconditions.a(iterable);
        if (iterable instanceof Collection) {
            Collection<? extends V> collection = (Collection) iterable;
            return !collection.isEmpty() && get(k).addAll(collection);
        }
        Iterator<? extends V> it = iterable.iterator();
        return it.hasNext() && Iterators.a(get(k), it);
    }

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean remove(@Nullable Object obj, @Nullable Object obj2) {
        Collection<V> collection = asMap().get(obj);
        return collection != null && collection.remove(obj2);
    }

    @CanIgnoreReturnValue
    public abstract Collection<V> replaceValues(@Nullable K k, Iterable<? extends V> iterable);

    public String toString() {
        return asMap().toString();
    }

    Iterator<V> valueIterator() {
        return Maps.c(entries().iterator());
    }

    public Collection<V> values() {
        Collection<V> collection = this.f15809d;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.f15809d = createValues;
        return createValues;
    }

    @CanIgnoreReturnValue
    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        boolean z = false;
        for (Map.Entry<? extends K, ? extends V> entry : multimap.entries()) {
            z |= put(entry.getKey(), entry.getValue());
        }
        return z;
    }
}
