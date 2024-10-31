package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
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

@GwtCompatible
/* loaded from: classes2.dex */
public final class LinkedHashMultimap<K, V> extends AbstractSetMultimap<K, V> {

    @GwtIncompatible
    private static final long serialVersionUID = 1;

    /* renamed from: a, reason: collision with root package name */
    private transient a<K, V> f2709a;

    @VisibleForTesting
    transient int valueSetCapacity;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface c<K, V> {
        c<K, V> a();

        void a(c<K, V> cVar);

        c<K, V> b();

        void b(c<K, V> cVar);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return super.get((LinkedHashMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set removeAll(Object obj) {
        return super.removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((LinkedHashMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap<>(16, 2);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int i, int i2) {
        return new LinkedHashMultimap<>(Maps.b(i), Maps.b(i2));
    }

    public static <K, V> LinkedHashMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        LinkedHashMultimap<K, V> create = create(multimap.keySet().size(), 2);
        create.putAll(multimap);
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void a(c<K, V> cVar, c<K, V> cVar2) {
        cVar.b(cVar2);
        cVar2.a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void a(a<K, V> aVar, a<K, V> aVar2) {
        aVar.a((a) aVar2);
        aVar2.b((a) aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void a(c<K, V> cVar) {
        a(cVar.a(), cVar.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void a(a<K, V> aVar) {
        a((a) aVar.c(), (a) aVar.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a<K, V> extends f<K, V> implements c<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final K f2710a;
        final V b;
        final int c;

        @Nullable
        a<K, V> d;
        c<K, V> e;
        c<K, V> f;
        a<K, V> g;
        a<K, V> h;

        a(@Nullable K k, @Nullable V v, int i, @Nullable a<K, V> aVar) {
            this.f2710a = k;
            this.b = v;
            this.c = i;
            this.d = aVar;
        }

        @Override // com.google.common.collect.f, java.util.Map.Entry
        public K getKey() {
            return this.f2710a;
        }

        @Override // com.google.common.collect.f, java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> a() {
            return this.e;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> b() {
            return this.f;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void a(c<K, V> cVar) {
            this.e = cVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void b(c<K, V> cVar) {
            this.f = cVar;
        }

        public a<K, V> c() {
            return this.g;
        }

        public a<K, V> d() {
            return this.h;
        }

        public void a(a<K, V> aVar) {
            this.h = aVar;
        }

        public void b(a<K, V> aVar) {
            this.g = aVar;
        }
    }

    private LinkedHashMultimap(int i, int i2) {
        super(new LinkedHashMap(i));
        this.valueSetCapacity = 2;
        Preconditions.a(i2 >= 0, "expectedValuesPerKey must be >= 0 but was %s", Integer.valueOf(i2));
        this.valueSetCapacity = i2;
        this.f2709a = new a<>(null, null, 0, null);
        a((a) this.f2709a, (a) this.f2709a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap
    public Set<V> createCollection() {
        return new LinkedHashSet(this.valueSetCapacity);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection<V> createCollection(K k) {
        return new b(k, this.valueSetCapacity);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return super.replaceValues((LinkedHashMultimap<K, V>) k, (Iterable) iterable);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Collection<V> values() {
        return super.values();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public final class b extends Sets.a<V> implements c<K, V> {
        private final K b;
        private a<K, V>[] c;
        private int d = 0;
        private int e = 0;
        private c<K, V> f = this;
        private c<K, V> g = this;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ int d(b bVar) {
            int i = bVar.d;
            bVar.d = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ int e(b bVar) {
            int i = bVar.e + 1;
            bVar.e = i;
            return i;
        }

        b(K k, int i) {
            this.b = k;
            int highestOneBit = Integer.highestOneBit(Math.max(i, 2) - 1) << 1;
            this.c = new a[highestOneBit < 0 ? 1073741824 : highestOneBit];
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> a() {
            return this.g;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> b() {
            return this.f;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void a(c<K, V> cVar) {
            this.g = cVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void b(c<K, V> cVar) {
            this.f = cVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new au(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.d;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@Nullable Object obj) {
            int hashCode = obj == null ? 0 : obj.hashCode();
            for (a<K, V> aVar = this.c[ab.a(hashCode) & (this.c.length - 1)]; aVar != null; aVar = aVar.d) {
                if (hashCode == aVar.c && Objects.a(obj, aVar.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @VisibleForTesting
        int c() {
            return this.c.length;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(@Nullable V v) {
            int hashCode = v == null ? 0 : v.hashCode();
            int a2 = ab.a(hashCode) & (this.c.length - 1);
            a<K, V> aVar = this.c[a2];
            for (a<K, V> aVar2 = aVar; aVar2 != null; aVar2 = aVar2.d) {
                if (hashCode == aVar2.c && Objects.a(v, aVar2.getValue())) {
                    return false;
                }
            }
            a<K, V> aVar3 = new a<>(this.b, v, hashCode, aVar);
            LinkedHashMultimap.a(this.g, aVar3);
            LinkedHashMultimap.a((c) aVar3, (c) this);
            LinkedHashMultimap.a((a) LinkedHashMultimap.this.f2709a.c(), (a) aVar3);
            LinkedHashMultimap.a((a) aVar3, LinkedHashMultimap.this.f2709a);
            this.c[a2] = aVar3;
            this.d++;
            this.e++;
            d();
            return true;
        }

        private void d() {
            if (this.d > c() && this.c.length < 1073741824) {
                a<K, V>[] aVarArr = new a[this.c.length * 2];
                this.c = aVarArr;
                int length = aVarArr.length - 1;
                for (c<K, V> cVar = this.f; cVar != this; cVar = cVar.b()) {
                    a<K, V> aVar = (a) cVar;
                    int a2 = ab.a(aVar.c) & length;
                    aVar.d = aVarArr[a2];
                    aVarArr[a2] = aVar;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@Nullable Object obj) {
            int hashCode = obj == null ? 0 : obj.hashCode();
            int a2 = ab.a(hashCode) & (this.c.length - 1);
            a<K, V> aVar = null;
            for (a<K, V> aVar2 = this.c[a2]; aVar2 != null; aVar2 = aVar2.d) {
                if (hashCode != aVar2.c || !Objects.a(obj, aVar2.getValue())) {
                    aVar = aVar2;
                } else {
                    if (aVar == null) {
                        this.c[a2] = aVar2.d;
                    } else {
                        aVar.d = aVar2.d;
                    }
                    LinkedHashMultimap.a((c) aVar2);
                    LinkedHashMultimap.a((a) aVar2);
                    this.d--;
                    this.e++;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.c, (Object) null);
            this.d = 0;
            for (c<K, V> cVar = this.f; cVar != this; cVar = cVar.b()) {
                LinkedHashMultimap.a((a) cVar);
            }
            LinkedHashMultimap.a((c) this, (c) this);
            this.e++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    public Iterator<Map.Entry<K, V>> createEntryIterator() {
        return new at(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public void clear() {
        super.clear();
        a((a) this.f2709a, (a) this.f2709a);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.valueSetCapacity);
        objectOutputStream.writeInt(keySet().size());
        Iterator it = keySet().iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f2709a = new a<>(null, null, 0, null);
        a((a) this.f2709a, (a) this.f2709a);
        this.valueSetCapacity = objectInputStream.readInt();
        int readInt = objectInputStream.readInt();
        LinkedHashMap linkedHashMap = new LinkedHashMap(Maps.b(readInt));
        for (int i = 0; i < readInt; i++) {
            Object readObject = objectInputStream.readObject();
            linkedHashMap.put(readObject, createCollection(readObject));
        }
        int readInt2 = objectInputStream.readInt();
        for (int i2 = 0; i2 < readInt2; i2++) {
            ((Collection) linkedHashMap.get(objectInputStream.readObject())).add(objectInputStream.readObject());
        }
        setMap(linkedHashMap);
    }
}
