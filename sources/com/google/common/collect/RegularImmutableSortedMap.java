package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class RegularImmutableSortedMap<K, V> extends ImmutableSortedMap<K, V> {

    /* renamed from: a */
    private final transient RegularImmutableSortedSet<K> f2756a;
    private final transient ImmutableList<V> b;

    public RegularImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList) {
        this.f2756a = regularImmutableSortedSet;
        this.b = immutableList;
    }

    RegularImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList, ImmutableSortedMap<K, V> immutableSortedMap) {
        super(immutableSortedMap);
        this.f2756a = regularImmutableSortedSet;
        this.b = immutableList;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class EntrySet extends ImmutableMapEntrySet<K, V> {
        private EntrySet() {
        }

        /* synthetic */ EntrySet(RegularImmutableSortedMap regularImmutableSortedMap, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }

        /* renamed from: com.google.common.collect.RegularImmutableSortedMap$EntrySet$1 */
        /* loaded from: classes2.dex */
        class AnonymousClass1 extends ImmutableAsList<Map.Entry<K, V>> {
            private final ImmutableList<K> keyList;
            private final ImmutableList<V> valueList;

            AnonymousClass1() {
                this.keyList = RegularImmutableSortedMap.this.keySet().asList();
                this.valueList = RegularImmutableSortedMap.this.values().asList();
            }

            @Override // java.util.List
            public Map.Entry<K, V> get(int i) {
                return Maps.a(this.keyList.get(i), this.valueList.get(i));
            }

            @Override // com.google.common.collect.ImmutableAsList
            ImmutableCollection<Map.Entry<K, V>> delegateCollection() {
                return EntrySet.this;
            }
        }

        @Override // com.google.common.collect.ImmutableCollection
        ImmutableList<Map.Entry<K, V>> createAsList() {
            return new ImmutableAsList<Map.Entry<K, V>>() { // from class: com.google.common.collect.RegularImmutableSortedMap.EntrySet.1
                private final ImmutableList<K> keyList;
                private final ImmutableList<V> valueList;

                AnonymousClass1() {
                    this.keyList = RegularImmutableSortedMap.this.keySet().asList();
                    this.valueList = RegularImmutableSortedMap.this.values().asList();
                }

                @Override // java.util.List
                public Map.Entry<K, V> get(int i) {
                    return Maps.a(this.keyList.get(i), this.valueList.get(i));
                }

                @Override // com.google.common.collect.ImmutableAsList
                ImmutableCollection<Map.Entry<K, V>> delegateCollection() {
                    return EntrySet.this;
                }
            };
        }

        @Override // com.google.common.collect.ImmutableMapEntrySet
        ImmutableMap<K, V> map() {
            return RegularImmutableSortedMap.this;
        }
    }

    @Override // com.google.common.collect.ImmutableSortedMap, com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSortedSet<K> keySet() {
        return this.f2756a;
    }

    @Override // com.google.common.collect.ImmutableSortedMap, com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableCollection<V> values() {
        return this.b;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(@Nullable Object obj) {
        int indexOf = this.f2756a.indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        return this.b.get(indexOf);
    }

    private ImmutableSortedMap<K, V> a(int i, int i2) {
        if (i != 0 || i2 != size()) {
            if (i == i2) {
                return emptyMap(comparator());
            }
            return from(this.f2756a.getSubSet(i, i2), this.b.subList(i, i2));
        }
        return this;
    }

    @Override // com.google.common.collect.ImmutableSortedMap
    public ImmutableSortedMap<K, V> headMap(K k, boolean z) {
        return a(0, this.f2756a.headIndex(Preconditions.a(k), z));
    }

    @Override // com.google.common.collect.ImmutableSortedMap
    public ImmutableSortedMap<K, V> tailMap(K k, boolean z) {
        return a(this.f2756a.tailIndex(Preconditions.a(k), z), size());
    }

    @Override // com.google.common.collect.ImmutableSortedMap
    ImmutableSortedMap<K, V> createDescendingMap() {
        return new RegularImmutableSortedMap((RegularImmutableSortedSet) this.f2756a.descendingSet(), this.b.reverse(), this);
    }
}
