package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
/* loaded from: classes2.dex */
public class ArraySortedMap<K, V> extends ImmutableSortedMap<K, V> {

    /* renamed from: a */
    private final K[] f16690a;

    /* renamed from: b */
    private final V[] f16691b;

    /* renamed from: c */
    private final Comparator<K> f16692c;

    public ArraySortedMap(Comparator<K> comparator) {
        this.f16690a = (K[]) new Object[0];
        this.f16691b = (V[]) new Object[0];
        this.f16692c = comparator;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> c() {
        return a(this.f16690a.length - 1, true);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K d() {
        K[] kArr = this.f16690a;
        if (kArr.length > 0) {
            return kArr[kArr.length - 1];
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K e() {
        K[] kArr = this.f16690a;
        if (kArr.length > 0) {
            return kArr[0];
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean isEmpty() {
        return this.f16690a.length == 0;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return a(0, false);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public ImmutableSortedMap<K, V> remove(K k) {
        int d2 = d(k);
        if (d2 == -1) {
            return this;
        }
        return new ArraySortedMap(this.f16692c, a(this.f16690a, d2), a(this.f16691b, d2));
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public int size() {
        return this.f16690a.length;
    }

    public static <A, B, C> ArraySortedMap<A, C> a(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator, Comparator<A> comparator) {
        Collections.sort(list, comparator);
        int size = list.size();
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        int i = 0;
        for (A a2 : list) {
            objArr[i] = a2;
            objArr2[i] = map.get(keyTranslator.a(a2));
            i++;
        }
        return new ArraySortedMap<>(comparator, objArr, objArr2);
    }

    private int d(K k) {
        int i = 0;
        for (K k2 : this.f16690a) {
            if (this.f16692c.compare(k, k2) == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private int e(K k) {
        int i = 0;
        while (true) {
            K[] kArr = this.f16690a;
            if (i >= kArr.length || this.f16692c.compare(kArr[i], k) >= 0) {
                break;
            }
            i++;
        }
        return i;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public V b(K k) {
        int d2 = d(k);
        if (d2 != -1) {
            return this.f16691b[d2];
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K c(K k) {
        int d2 = d(k);
        if (d2 == -1) {
            throw new IllegalArgumentException("Can't find predecessor of nonexistent key");
        }
        if (d2 > 0) {
            return this.f16690a[d2 - 1];
        }
        return null;
    }

    private static <T> T[] b(T[] tArr, int i, T t) {
        int length = tArr.length;
        T[] tArr2 = (T[]) new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, length);
        tArr2[i] = t;
        return tArr2;
    }

    private ArraySortedMap(Comparator<K> comparator, K[] kArr, V[] vArr) {
        this.f16690a = kArr;
        this.f16691b = vArr;
        this.f16692c = comparator;
    }

    public static <K, V> ArraySortedMap<K, V> a(Map<K, V> map, Comparator<K> comparator) {
        return a(new ArrayList(map.keySet()), map, ImmutableSortedMap.Builder.a(), comparator);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean a(K k) {
        return d(k) != -1;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public ImmutableSortedMap<K, V> a(K k, V v) {
        int d2 = d(k);
        if (d2 != -1) {
            if (this.f16690a[d2] == k && this.f16691b[d2] == v) {
                return this;
            }
            return new ArraySortedMap(this.f16692c, b(this.f16690a, d2, k), b(this.f16691b, d2, v));
        }
        K[] kArr = this.f16690a;
        if (kArr.length > 25) {
            HashMap hashMap = new HashMap(kArr.length + 1);
            int i = 0;
            while (true) {
                K[] kArr2 = this.f16690a;
                if (i < kArr2.length) {
                    hashMap.put(kArr2[i], this.f16691b[i]);
                    i++;
                } else {
                    hashMap.put(k, v);
                    return RBTreeSortedMap.a((Map) hashMap, (Comparator) this.f16692c);
                }
            }
        } else {
            int e2 = e(k);
            return new ArraySortedMap(this.f16692c, a(this.f16690a, e2, k), a(this.f16691b, e2, v));
        }
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public void a(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        int i = 0;
        while (true) {
            K[] kArr = this.f16690a;
            if (i >= kArr.length) {
                return;
            }
            nodeVisitor.a(kArr[i], this.f16691b[i]);
            i++;
        }
    }

    private Iterator<Map.Entry<K, V>> a(int i, boolean z) {
        return new a(this, i, z);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Comparator<K> a() {
        return this.f16692c;
    }

    private static <T> T[] a(T[] tArr, int i) {
        int length = tArr.length - 1;
        T[] tArr2 = (T[]) new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i);
        System.arraycopy(tArr, i + 1, tArr2, i, length - i);
        return tArr2;
    }

    private static <T> T[] a(T[] tArr, int i, T t) {
        T[] tArr2 = (T[]) new Object[tArr.length + 1];
        System.arraycopy(tArr, 0, tArr2, 0, i);
        tArr2[i] = t;
        System.arraycopy(tArr, i, tArr2, i + 1, (r0 - i) - 1);
        return tArr2;
    }
}
