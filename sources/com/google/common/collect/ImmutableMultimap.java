package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.cs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ImmutableMultimap<K, V> implements Multimap<K, V>, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private transient ImmutableCollection<Map.Entry<K, V>> f2694a;
    private transient ImmutableMultiset<K> b;
    private transient ImmutableCollection<V> c;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;

    @GwtIncompatible
    /* loaded from: classes2.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        static final cs.a<ImmutableMultimap> f2696a = cs.a(ImmutableMultimap.class, "map");
        static final cs.a<ImmutableMultimap> b = cs.a(ImmutableMultimap.class, "size");
    }

    @Override // com.google.common.collect.Multimap
    public abstract ImmutableCollection<V> get(K k);

    @Beta
    public abstract ImmutableMultimap<V, K> inverse();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((ImmutableMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableMultimap<K, V>) obj, iterable);
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v) {
        return ImmutableListMultimap.of((Object) k, (Object) v);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4, (Object) k5, (Object) v5);
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    /* loaded from: classes2.dex */
    private static class BuilderMultimap<K, V> extends AbstractMultimap<K, V> {
        private static final long serialVersionUID = 0;

        BuilderMultimap() {
            super(new LinkedHashMap());
        }

        @Override // com.google.common.collect.AbstractMultimap
        Collection<V> createCollection() {
            return Lists.a();
        }
    }

    /* loaded from: classes2.dex */
    public static class Builder<K, V> {

        /* renamed from: a, reason: collision with root package name */
        Multimap<K, V> f2695a = new BuilderMultimap();
        Comparator<? super K> b;
        Comparator<? super V> c;

        /* JADX WARN: Multi-variable type inference failed */
        public Builder<K, V> b(K k, V v) {
            this.f2695a.put(Preconditions.a(k), Preconditions.a(v));
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ImmutableMultimap<K, V> b() {
            if (this.c != null) {
                Iterator<Collection<V>> it = this.f2695a.asMap().values().iterator();
                while (it.hasNext()) {
                    Collections.sort((List) it.next(), this.c);
                }
            }
            if (this.b != null) {
                BuilderMultimap builderMultimap = new BuilderMultimap();
                ArrayList<Map.Entry> a2 = Lists.a(this.f2695a.asMap().entrySet());
                Collections.sort(a2, Ordering.from(this.b).onResultOf(new ae(this)));
                for (Map.Entry entry : a2) {
                    builderMultimap.putAll(entry.getKey(), (Iterable) entry.getValue());
                }
                this.f2695a = builderMultimap;
            }
            return ImmutableMultimap.copyOf(this.f2695a);
        }
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        if (multimap instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) multimap;
            if (!immutableMultimap.isPartialView()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.copyOf((Multimap) multimap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i) {
        this.map = immutableMap;
        this.size = i;
    }

    @Override // com.google.common.collect.Multimap
    public ImmutableCollection<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap
    public ImmutableCollection<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap
    public boolean put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap
    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsEntry(@Nullable Object obj, @Nullable Object obj2) {
        ImmutableCollection<V> immutableCollection = this.map.get(obj);
        return immutableCollection != null && immutableCollection.contains(obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@Nullable Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsValue(@Nullable Object obj) {
        Iterator it = this.map.values().iterator();
        while (it.hasNext()) {
            if (((ImmutableCollection) it.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.Multimap
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.size;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Multimap) {
            return this.map.equals(((Multimap) obj).asMap());
        }
        return false;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        return this.map.toString();
    }

    @Override // com.google.common.collect.Multimap
    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    @Override // com.google.common.collect.Multimap
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    @Override // com.google.common.collect.Multimap
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        ImmutableCollection<Map.Entry<K, V>> immutableCollection = this.f2694a;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        EntryCollection entryCollection = new EntryCollection(this);
        this.f2694a = entryCollection;
        return entryCollection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;
        final ImmutableMultimap<K, V> multimap;

        EntryCollection(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return new af(this, this.multimap.map.entrySet().iterator());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        @Override // java.util.Collection
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.collect.Multimap
    public ImmutableMultiset<K> keys() {
        ImmutableMultiset<K> immutableMultiset = this.b;
        if (immutableMultiset != null) {
            return immutableMultiset;
        }
        ImmutableMultiset<K> a2 = a();
        this.b = a2;
        return a2;
    }

    private ImmutableMultiset<K> a() {
        return new Keys();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class Keys extends ImmutableMultiset<K> {
        Keys() {
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
        public boolean contains(@Nullable Object obj) {
            return ImmutableMultimap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.Multiset
        public int count(@Nullable Object obj) {
            ImmutableCollection<V> immutableCollection = ImmutableMultimap.this.map.get(obj);
            if (immutableCollection == null) {
                return 0;
            }
            return immutableCollection.size();
        }

        @Override // com.google.common.collect.Multiset
        public Set<K> elementSet() {
            return ImmutableMultimap.this.keySet();
        }

        @Override // java.util.Collection
        public int size() {
            return ImmutableMultimap.this.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset
        ImmutableSet<Multiset.Entry<K>> createEntrySet() {
            return new KeysEntrySet();
        }

        /* loaded from: classes2.dex */
        private class KeysEntrySet extends ImmutableMultiset.EntrySet {
            private KeysEntrySet() {
                super();
            }

            @Override // java.util.Collection, java.util.Set
            public int size() {
                return ImmutableMultimap.this.keySet().size();
            }

            @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<Multiset.Entry<K>> iterator() {
                return asList().iterator();
            }

            @Override // com.google.common.collect.ImmutableCollection
            ImmutableList<Multiset.Entry<K>> createAsList() {
                final ImmutableList<Map.Entry<K, ? extends ImmutableCollection<V>>> asList = ImmutableMultimap.this.map.entrySet().asList();
                return new ImmutableAsList<Multiset.Entry<K>>() { // from class: com.google.common.collect.ImmutableMultimap.Keys.KeysEntrySet.1
                    @Override // java.util.List
                    public Multiset.Entry<K> get(int i) {
                        Map.Entry entry = (Map.Entry) asList.get(i);
                        return Multisets.a(entry.getKey(), ((Collection) entry.getValue()).size());
                    }

                    @Override // com.google.common.collect.ImmutableAsList
                    ImmutableCollection<Multiset.Entry<K>> delegateCollection() {
                        return KeysEntrySet.this;
                    }
                };
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }
    }

    @Override // com.google.common.collect.Multimap
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.c;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        Values values = new Values(this);
        this.c = values;
        return values;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Values<V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;
        final ImmutableMultimap<?, V> multimap;

        Values(ImmutableMultimap<?, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<V> iterator() {
            return Maps.a((UnmodifiableIterator) this.multimap.entries().iterator());
        }

        @Override // java.util.Collection
        public int size() {
            return this.multimap.size();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }
    }
}
