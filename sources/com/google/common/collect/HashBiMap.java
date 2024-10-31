package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class HashBiMap<K, V> extends Maps.d<K, V> implements BiMap<K, V>, Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    private transient BiEntry<K, V>[] f15397a;

    /* renamed from: b */
    private transient BiEntry<K, V>[] f15398b;

    /* renamed from: c */
    private transient BiEntry<K, V> f15399c;

    /* renamed from: d */
    private transient BiEntry<K, V> f15400d;

    /* renamed from: e */
    private transient int f15401e;

    /* renamed from: f */
    private transient int f15402f;

    /* renamed from: g */
    private transient int f15403g;

    /* renamed from: h */
    @RetainedWith
    private transient BiMap<V, K> f15404h;

    /* loaded from: classes2.dex */
    public static final class BiEntry<K, V> extends ImmutableEntry<K, V> {
        final int keyHash;

        @Nullable
        BiEntry<K, V> nextInKToVBucket;

        @Nullable
        BiEntry<K, V> nextInKeyInsertionOrder;

        @Nullable
        BiEntry<K, V> nextInVToKBucket;

        @Nullable
        BiEntry<K, V> prevInKeyInsertionOrder;
        final int valueHash;

        public BiEntry(K k, int i, V v, int i2) {
            super(k, v);
            this.keyHash = i;
            this.valueHash = i2;
        }
    }

    /* loaded from: classes2.dex */
    public final class Inverse extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {

        /* loaded from: classes2.dex */
        public final class a extends Maps.e<V, K> {
            a() {
                super(Inverse.this);
            }

            @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<V> iterator() {
                return new O(this);
            }

            @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@Nullable Object obj) {
                BiEntry b2 = HashBiMap.this.b(obj, Q.a(obj));
                if (b2 == null) {
                    return false;
                }
                HashBiMap.this.a(b2);
                return true;
            }
        }

        private Inverse() {
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            forward().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@Nullable Object obj) {
            return forward().containsValue(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            return new N(this);
        }

        public K forcePut(@Nullable V v, @Nullable K k) {
            return (K) HashBiMap.this.b(v, k, true);
        }

        BiMap<K, V> forward() {
            return HashBiMap.this;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K get(@Nullable Object obj) {
            return (K) Maps.a(HashBiMap.this.b(obj, Q.a(obj)));
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<K, V> inverse() {
            return forward();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K put(@Nullable V v, @Nullable K k) {
            return (K) HashBiMap.this.b(v, k, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K remove(@Nullable Object obj) {
            BiEntry b2 = HashBiMap.this.b(obj, Q.a(obj));
            if (b2 == null) {
                return null;
            }
            HashBiMap.this.a(b2);
            b2.prevInKeyInsertionOrder = null;
            b2.nextInKeyInsertionOrder = null;
            return b2.key;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return HashBiMap.this.f15401e;
        }

        Object writeReplace() {
            return new InverseSerializedForm(HashBiMap.this);
        }

        /* synthetic */ Inverse(HashBiMap hashBiMap, L l) {
            this();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> values() {
            return forward().keySet();
        }
    }

    /* loaded from: classes2.dex */
    private static final class InverseSerializedForm<K, V> implements Serializable {
        private final HashBiMap<K, V> bimap;

        InverseSerializedForm(HashBiMap<K, V> hashBiMap) {
            this.bimap = hashBiMap;
        }

        Object readResolve() {
            return this.bimap.inverse();
        }
    }

    /* loaded from: classes2.dex */
    public abstract class a<T> implements Iterator<T> {

        /* renamed from: a */
        BiEntry<K, V> f15406a;

        /* renamed from: b */
        BiEntry<K, V> f15407b = null;

        /* renamed from: c */
        int f15408c;

        public a() {
            this.f15406a = HashBiMap.this.f15399c;
            this.f15408c = HashBiMap.this.f15403g;
        }

        abstract T a(BiEntry<K, V> biEntry);

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (HashBiMap.this.f15403g == this.f15408c) {
                return this.f15406a != null;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                BiEntry<K, V> biEntry = this.f15406a;
                this.f15406a = biEntry.nextInKeyInsertionOrder;
                this.f15407b = biEntry;
                return a(biEntry);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (HashBiMap.this.f15403g == this.f15408c) {
                C1555x.a(this.f15407b != null);
                HashBiMap.this.a(this.f15407b);
                this.f15408c = HashBiMap.this.f15403g;
                this.f15407b = null;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    /* loaded from: classes2.dex */
    public final class b extends Maps.e<K, V> {
        b() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new P(this);
        }

        @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@Nullable Object obj) {
            BiEntry a2 = HashBiMap.this.a(obj, Q.a(obj));
            if (a2 == null) {
                return false;
            }
            HashBiMap.this.a(a2);
            a2.prevInKeyInsertionOrder = null;
            a2.nextInKeyInsertionOrder = null;
            return true;
        }
    }

    private HashBiMap(int i) {
        b(i);
    }

    public void a(BiEntry<K, V> biEntry) {
        BiEntry<K, V> biEntry2;
        int i = biEntry.keyHash & this.f15402f;
        BiEntry<K, V> biEntry3 = null;
        BiEntry<K, V> biEntry4 = null;
        for (BiEntry<K, V> biEntry5 = this.f15397a[i]; biEntry5 != biEntry; biEntry5 = biEntry5.nextInKToVBucket) {
            biEntry4 = biEntry5;
        }
        if (biEntry4 == null) {
            this.f15397a[i] = biEntry.nextInKToVBucket;
        } else {
            biEntry4.nextInKToVBucket = biEntry.nextInKToVBucket;
        }
        int i2 = biEntry.valueHash & this.f15402f;
        BiEntry<K, V> biEntry6 = this.f15398b[i2];
        while (true) {
            biEntry2 = biEntry3;
            biEntry3 = biEntry6;
            if (biEntry3 == biEntry) {
                break;
            } else {
                biEntry6 = biEntry3.nextInVToKBucket;
            }
        }
        if (biEntry2 == null) {
            this.f15398b[i2] = biEntry.nextInVToKBucket;
        } else {
            biEntry2.nextInVToKBucket = biEntry.nextInVToKBucket;
        }
        BiEntry<K, V> biEntry7 = biEntry.prevInKeyInsertionOrder;
        if (biEntry7 == null) {
            this.f15399c = biEntry.nextInKeyInsertionOrder;
        } else {
            biEntry7.nextInKeyInsertionOrder = biEntry.nextInKeyInsertionOrder;
        }
        BiEntry<K, V> biEntry8 = biEntry.nextInKeyInsertionOrder;
        if (biEntry8 == null) {
            this.f15400d = biEntry.prevInKeyInsertionOrder;
        } else {
            biEntry8.prevInKeyInsertionOrder = biEntry.prevInKeyInsertionOrder;
        }
        this.f15401e--;
        this.f15403g++;
    }

    private void b(int i) {
        C1555x.a(i, "expectedSize");
        int a2 = Q.a(i, 1.0d);
        this.f15397a = a(a2);
        this.f15398b = a(a2);
        this.f15399c = null;
        this.f15400d = null;
        this.f15401e = 0;
        this.f15402f = a2 - 1;
        this.f15403g = 0;
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        b(16);
        C1527mb.a(this, objectInputStream, C1527mb.a(objectInputStream));
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        C1527mb.a(this, objectOutputStream);
    }

    @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f15401e = 0;
        Arrays.fill(this.f15397a, (Object) null);
        Arrays.fill(this.f15398b, (Object) null);
        this.f15399c = null;
        this.f15400d = null;
        this.f15403g++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@Nullable Object obj) {
        return a(obj, Q.a(obj)) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@Nullable Object obj) {
        return b(obj, Q.a(obj)) != null;
    }

    @Override // com.google.common.collect.Maps.d
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new L(this);
    }

    @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @CanIgnoreReturnValue
    public V forcePut(@Nullable K k, @Nullable V v) {
        return a(k, v, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V get(@Nullable Object obj) {
        return (V) Maps.c(a(obj, Q.a(obj)));
    }

    @Override // com.google.common.collect.BiMap
    public BiMap<V, K> inverse() {
        BiMap<V, K> biMap = this.f15404h;
        if (biMap != null) {
            return biMap;
        }
        Inverse inverse = new Inverse(this, null);
        this.f15404h = inverse;
        return inverse;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        return new b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V put(@Nullable K k, @Nullable V v) {
        return a(k, v, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V remove(@Nullable Object obj) {
        BiEntry<K, V> a2 = a(obj, Q.a(obj));
        if (a2 == null) {
            return null;
        }
        a(a2);
        a2.prevInKeyInsertionOrder = null;
        a2.nextInKeyInsertionOrder = null;
        return a2.value;
    }

    @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f15401e;
    }

    public static <K, V> HashBiMap<K, V> create(int i) {
        return new HashBiMap<>(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<V> values() {
        return inverse().keySet();
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }

    public BiEntry<K, V> b(@Nullable Object obj, int i) {
        for (BiEntry<K, V> biEntry = this.f15398b[this.f15402f & i]; biEntry != null; biEntry = biEntry.nextInVToKBucket) {
            if (i == biEntry.valueHash && Objects.a(obj, biEntry.value)) {
                return biEntry;
            }
        }
        return null;
    }

    @Nullable
    public K b(@Nullable V v, @Nullable K k, boolean z) {
        int a2 = Q.a(v);
        int a3 = Q.a(k);
        BiEntry<K, V> b2 = b(v, a2);
        if (b2 != null && a3 == b2.keyHash && Objects.a(k, b2.key)) {
            return k;
        }
        BiEntry<K, V> a4 = a(k, a3);
        if (a4 != null) {
            if (z) {
                a(a4);
            } else {
                throw new IllegalArgumentException("value already present: " + k);
            }
        }
        if (b2 != null) {
            a(b2);
        }
        a(new BiEntry<>(k, a3, v, a2), a4);
        if (a4 != null) {
            a4.prevInKeyInsertionOrder = null;
            a4.nextInKeyInsertionOrder = null;
        }
        a();
        return (K) Maps.a(b2);
    }

    public void a(BiEntry<K, V> biEntry, @Nullable BiEntry<K, V> biEntry2) {
        int i = biEntry.keyHash;
        int i2 = this.f15402f;
        int i3 = i & i2;
        BiEntry<K, V>[] biEntryArr = this.f15397a;
        biEntry.nextInKToVBucket = biEntryArr[i3];
        biEntryArr[i3] = biEntry;
        int i4 = biEntry.valueHash & i2;
        BiEntry<K, V>[] biEntryArr2 = this.f15398b;
        biEntry.nextInVToKBucket = biEntryArr2[i4];
        biEntryArr2[i4] = biEntry;
        if (biEntry2 == null) {
            BiEntry<K, V> biEntry3 = this.f15400d;
            biEntry.prevInKeyInsertionOrder = biEntry3;
            biEntry.nextInKeyInsertionOrder = null;
            if (biEntry3 == null) {
                this.f15399c = biEntry;
            } else {
                biEntry3.nextInKeyInsertionOrder = biEntry;
            }
            this.f15400d = biEntry;
        } else {
            biEntry.prevInKeyInsertionOrder = biEntry2.prevInKeyInsertionOrder;
            BiEntry<K, V> biEntry4 = biEntry.prevInKeyInsertionOrder;
            if (biEntry4 == null) {
                this.f15399c = biEntry;
            } else {
                biEntry4.nextInKeyInsertionOrder = biEntry;
            }
            biEntry.nextInKeyInsertionOrder = biEntry2.nextInKeyInsertionOrder;
            BiEntry<K, V> biEntry5 = biEntry.nextInKeyInsertionOrder;
            if (biEntry5 == null) {
                this.f15400d = biEntry;
            } else {
                biEntry5.prevInKeyInsertionOrder = biEntry;
            }
        }
        this.f15401e++;
        this.f15403g++;
    }

    public BiEntry<K, V> a(@Nullable Object obj, int i) {
        for (BiEntry<K, V> biEntry = this.f15397a[this.f15402f & i]; biEntry != null; biEntry = biEntry.nextInKToVBucket) {
            if (i == biEntry.keyHash && Objects.a(obj, biEntry.key)) {
                return biEntry;
            }
        }
        return null;
    }

    private V a(@Nullable K k, @Nullable V v, boolean z) {
        int a2 = Q.a(k);
        int a3 = Q.a(v);
        BiEntry<K, V> a4 = a(k, a2);
        if (a4 != null && a3 == a4.valueHash && Objects.a(v, a4.value)) {
            return v;
        }
        BiEntry<K, V> b2 = b(v, a3);
        if (b2 != null) {
            if (z) {
                a(b2);
            } else {
                throw new IllegalArgumentException("value already present: " + v);
            }
        }
        BiEntry<K, V> biEntry = new BiEntry<>(k, a2, v, a3);
        if (a4 != null) {
            a(a4);
            a(biEntry, a4);
            a4.prevInKeyInsertionOrder = null;
            a4.nextInKeyInsertionOrder = null;
            a();
            return a4.value;
        }
        a(biEntry, (BiEntry) null);
        a();
        return null;
    }

    private void a() {
        BiEntry<K, V>[] biEntryArr = this.f15397a;
        if (Q.a(this.f15401e, biEntryArr.length, 1.0d)) {
            int length = biEntryArr.length * 2;
            this.f15397a = a(length);
            this.f15398b = a(length);
            this.f15402f = length - 1;
            this.f15401e = 0;
            for (BiEntry<K, V> biEntry = this.f15399c; biEntry != null; biEntry = biEntry.nextInKeyInsertionOrder) {
                a(biEntry, biEntry);
            }
            this.f15403g++;
        }
    }

    private BiEntry<K, V>[] a(int i) {
        return new BiEntry[i];
    }
}
