package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class LinkedHashMultimap<K, V> extends AbstractSetMultimap<K, V> {

    @VisibleForTesting
    static final double VALUE_SET_LOAD_FACTOR = 1.0d;

    @GwtIncompatible
    private static final long serialVersionUID = 1;

    /* renamed from: h */
    private transient ValueEntry<K, V> f15494h;

    @VisibleForTesting
    transient int valueSetCapacity;

    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements b<K, V> {

        @Nullable
        ValueEntry<K, V> nextInValueBucket;
        ValueEntry<K, V> predecessorInMultimap;
        b<K, V> predecessorInValueSet;
        final int smearedValueHash;
        ValueEntry<K, V> successorInMultimap;
        b<K, V> successorInValueSet;

        ValueEntry(@Nullable K k, @Nullable V v, int i, @Nullable ValueEntry<K, V> valueEntry) {
            super(k, v);
            this.smearedValueHash = i;
            this.nextInValueBucket = valueEntry;
        }

        public ValueEntry<K, V> getPredecessorInMultimap() {
            return this.predecessorInMultimap;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public b<K, V> getPredecessorInValueSet() {
            return this.predecessorInValueSet;
        }

        public ValueEntry<K, V> getSuccessorInMultimap() {
            return this.successorInMultimap;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public b<K, V> getSuccessorInValueSet() {
            return this.successorInValueSet;
        }

        boolean matchesValue(@Nullable Object obj, int i) {
            return this.smearedValueHash == i && Objects.a(getValue(), obj);
        }

        public void setPredecessorInMultimap(ValueEntry<K, V> valueEntry) {
            this.predecessorInMultimap = valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public void setPredecessorInValueSet(b<K, V> bVar) {
            this.predecessorInValueSet = bVar;
        }

        public void setSuccessorInMultimap(ValueEntry<K, V> valueEntry) {
            this.successorInMultimap = valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public void setSuccessorInValueSet(b<K, V> bVar) {
            this.successorInValueSet = bVar;
        }
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    public final class a extends Sets.b<V> implements b<K, V> {

        /* renamed from: a */
        private final K f15495a;

        /* renamed from: b */
        @VisibleForTesting
        ValueEntry<K, V>[] f15496b;

        /* renamed from: c */
        private int f15497c = 0;

        /* renamed from: d */
        private int f15498d = 0;

        /* renamed from: e */
        private b<K, V> f15499e = this;

        /* renamed from: f */
        private b<K, V> f15500f = this;

        a(K k, int i) {
            this.f15495a = k;
            this.f15496b = new ValueEntry[Q.a(i, LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(@Nullable V v) {
            int a2 = Q.a(v);
            int a3 = a() & a2;
            ValueEntry<K, V> valueEntry = this.f15496b[a3];
            for (ValueEntry<K, V> valueEntry2 = valueEntry; valueEntry2 != null; valueEntry2 = valueEntry2.nextInValueBucket) {
                if (valueEntry2.matchesValue(v, a2)) {
                    return false;
                }
            }
            ValueEntry<K, V> valueEntry3 = new ValueEntry<>(this.f15495a, v, a2, valueEntry);
            LinkedHashMultimap.a(this.f15500f, valueEntry3);
            LinkedHashMultimap.a(valueEntry3, this);
            LinkedHashMultimap.a((ValueEntry) LinkedHashMultimap.this.f15494h.getPredecessorInMultimap(), (ValueEntry) valueEntry3);
            LinkedHashMultimap.a((ValueEntry) valueEntry3, LinkedHashMultimap.this.f15494h);
            this.f15496b[a3] = valueEntry3;
            this.f15497c++;
            this.f15498d++;
            b();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.f15496b, (Object) null);
            this.f15497c = 0;
            for (b<K, V> bVar = this.f15499e; bVar != this; bVar = bVar.getSuccessorInValueSet()) {
                LinkedHashMultimap.a((ValueEntry) bVar);
            }
            LinkedHashMultimap.a(this, this);
            this.f15498d++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@Nullable Object obj) {
            int a2 = Q.a(obj);
            for (ValueEntry<K, V> valueEntry = this.f15496b[a() & a2]; valueEntry != null; valueEntry = valueEntry.nextInValueBucket) {
                if (valueEntry.matchesValue(obj, a2)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public b<K, V> getPredecessorInValueSet() {
            return this.f15500f;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public b<K, V> getSuccessorInValueSet() {
            return this.f15499e;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new C1549ua(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        public boolean remove(@Nullable Object obj) {
            int a2 = Q.a(obj);
            int a3 = a() & a2;
            ValueEntry<K, V> valueEntry = this.f15496b[a3];
            ValueEntry<K, V> valueEntry2 = null;
            while (true) {
                ValueEntry<K, V> valueEntry3 = valueEntry2;
                valueEntry2 = valueEntry;
                if (valueEntry2 == null) {
                    return false;
                }
                if (valueEntry2.matchesValue(obj, a2)) {
                    if (valueEntry3 == null) {
                        this.f15496b[a3] = valueEntry2.nextInValueBucket;
                    } else {
                        valueEntry3.nextInValueBucket = valueEntry2.nextInValueBucket;
                    }
                    LinkedHashMultimap.a((b) valueEntry2);
                    LinkedHashMultimap.a((ValueEntry) valueEntry2);
                    this.f15497c--;
                    this.f15498d++;
                    return true;
                }
                valueEntry = valueEntry2.nextInValueBucket;
            }
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public void setPredecessorInValueSet(b<K, V> bVar) {
            this.f15500f = bVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public void setSuccessorInValueSet(b<K, V> bVar) {
            this.f15499e = bVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f15497c;
        }

        private int a() {
            return this.f15496b.length - 1;
        }

        private void b() {
            if (Q.a(this.f15497c, this.f15496b.length, LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)) {
                ValueEntry<K, V>[] valueEntryArr = new ValueEntry[this.f15496b.length * 2];
                this.f15496b = valueEntryArr;
                int length = valueEntryArr.length - 1;
                for (b<K, V> bVar = this.f15499e; bVar != this; bVar = bVar.getSuccessorInValueSet()) {
                    ValueEntry<K, V> valueEntry = (ValueEntry) bVar;
                    int i = valueEntry.smearedValueHash & length;
                    valueEntry.nextInValueBucket = valueEntryArr[i];
                    valueEntryArr[i] = valueEntry;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b<K, V> {
        b<K, V> getPredecessorInValueSet();

        b<K, V> getSuccessorInValueSet();

        void setPredecessorInValueSet(b<K, V> bVar);

        void setSuccessorInValueSet(b<K, V> bVar);
    }

    private LinkedHashMultimap(int i, int i2) {
        super(new LinkedHashMap(i));
        this.valueSetCapacity = 2;
        C1555x.a(i2, "expectedValuesPerKey");
        this.valueSetCapacity = i2;
        this.f15494h = new ValueEntry<>(null, null, 0, null);
        ValueEntry<K, V> valueEntry = this.f15494h;
        a((ValueEntry) valueEntry, (ValueEntry) valueEntry);
    }

    public static <K, V> void a(b<K, V> bVar, b<K, V> bVar2) {
        bVar.setSuccessorInValueSet(bVar2);
        bVar2.setPredecessorInValueSet(bVar);
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap<>(16, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f15494h = new ValueEntry<>(null, null, 0, null);
        ValueEntry<K, V> valueEntry = this.f15494h;
        a((ValueEntry) valueEntry, (ValueEntry) valueEntry);
        this.valueSetCapacity = 2;
        int readInt = objectInputStream.readInt();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < readInt; i++) {
            Object readObject = objectInputStream.readObject();
            linkedHashMap.put(readObject, createCollection(readObject));
        }
        int readInt2 = objectInputStream.readInt();
        for (int i2 = 0; i2 < readInt2; i2++) {
            Object readObject2 = objectInputStream.readObject();
            ((Collection) linkedHashMap.get(readObject2)).add(objectInputStream.readObject());
        }
        setMap(linkedHashMap);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(keySet().size());
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public void clear() {
        super.clear();
        ValueEntry<K, V> valueEntry = this.f15494h;
        a((ValueEntry) valueEntry, (ValueEntry) valueEntry);
    }

    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractC1519k
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractC1519k
    Iterator<Map.Entry<K, V>> entryIterator() {
        return new C1546ta(this);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return super.get((LinkedHashMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractC1519k
    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set removeAll(Object obj) {
        return super.removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractC1519k
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((LinkedHashMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.AbstractC1519k
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractC1519k
    Iterator<V> valueIterator() {
        return Maps.c(entryIterator());
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractC1519k
    public Collection<V> values() {
        return super.values();
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int i, int i2) {
        return new LinkedHashMultimap<>(Maps.a(i), Maps.a(i2));
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public Set<V> createCollection() {
        return new LinkedHashSet(this.valueSetCapacity);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractC1519k
    @CanIgnoreReturnValue
    public Set<V> replaceValues(@Nullable K k, Iterable<? extends V> iterable) {
        return super.replaceValues((LinkedHashMultimap<K, V>) k, (Iterable) iterable);
    }

    public static <K, V> void a(ValueEntry<K, V> valueEntry, ValueEntry<K, V> valueEntry2) {
        valueEntry.setSuccessorInMultimap(valueEntry2);
        valueEntry2.setPredecessorInMultimap(valueEntry);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        LinkedHashMultimap<K, V> create = create(multimap.keySet().size(), 2);
        create.putAll(multimap);
        return create;
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> createCollection(K k) {
        return new a(k, this.valueSetCapacity);
    }

    public static <K, V> void a(b<K, V> bVar) {
        a(bVar.getPredecessorInValueSet(), bVar.getSuccessorInValueSet());
    }

    public static <K, V> void a(ValueEntry<K, V> valueEntry) {
        a((ValueEntry) valueEntry.getPredecessorInMultimap(), (ValueEntry) valueEntry.getSuccessorInMultimap());
    }
}
