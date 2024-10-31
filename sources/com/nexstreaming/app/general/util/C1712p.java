package com.nexstreaming.app.general.util;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: ImmutableBMap.java */
/* renamed from: com.nexstreaming.app.general.util.p */
/* loaded from: classes2.dex */
public class C1712p<K, V> implements Map<K, V> {

    /* renamed from: a */
    private final K[] f19874a;

    /* renamed from: b */
    private final V[] f19875b;

    /* renamed from: c */
    private List<K> f19876c;

    /* renamed from: d */
    private Set<K> f19877d;

    /* renamed from: e */
    private List<V> f19878e;

    /* renamed from: f */
    private Set<Map.Entry<K, V>> f19879f;

    public C1712p(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, Object... objArr) {
        int length = objArr.length / 2;
        int i = length + 4;
        this.f19874a = (K[]) new Object[i];
        this.f19875b = (V[]) new Object[i];
        K[] kArr = this.f19874a;
        kArr[0] = k;
        V[] vArr = this.f19875b;
        vArr[0] = v;
        kArr[1] = k2;
        vArr[1] = v2;
        kArr[2] = k3;
        vArr[2] = v3;
        kArr[3] = k4;
        vArr[3] = v4;
        Class<?> cls = k.getClass();
        Class<?> cls2 = v.getClass();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            Object obj = objArr[i3];
            Object obj2 = objArr[i3 + 1];
            if (cls.isInstance(obj)) {
                if (cls2.isInstance(obj2)) {
                    int i4 = i2 + 4;
                    ((K[]) this.f19874a)[i4] = obj;
                    ((V[]) this.f19875b)[i4] = obj2;
                } else {
                    throw new ClassCastException("value of wrong class");
                }
            } else {
                throw new ClassCastException("key of wrong class");
            }
        }
    }

    public List<K> a() {
        if (this.f19876c == null) {
            this.f19876c = Collections.unmodifiableList(Arrays.asList(this.f19874a));
        }
        return this.f19876c;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        for (K k : this.f19874a) {
            if (k == obj || k.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        for (V v : this.f19875b) {
            if (v == obj || v.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f19879f == null) {
            HashSet hashSet = new HashSet();
            int i = 0;
            while (true) {
                K[] kArr = this.f19874a;
                if (i >= kArr.length) {
                    break;
                }
                hashSet.add(new AbstractMap.SimpleImmutableEntry(kArr[i], this.f19875b[i]));
                i++;
            }
            this.f19879f = Collections.unmodifiableSet(hashSet);
        }
        return this.f19879f;
    }

    @Override // java.util.Map
    public V get(Object obj) {
        int i = 0;
        while (true) {
            K[] kArr = this.f19874a;
            if (i >= kArr.length) {
                return null;
            }
            if (kArr[i] == obj || kArr[i].equals(obj)) {
                break;
            }
            i++;
        }
        return this.f19875b[i];
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f19874a.length < 1;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        if (this.f19877d == null) {
            this.f19877d = Collections.unmodifiableSet(new HashSet(a()));
        }
        return this.f19877d;
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return this.f19874a.length;
    }

    @Override // java.util.Map
    public List<V> values() {
        if (this.f19878e == null) {
            this.f19878e = Collections.unmodifiableList(Arrays.asList(this.f19875b));
        }
        return this.f19878e;
    }

    public K a(V v) {
        int i = 0;
        while (true) {
            V[] vArr = this.f19875b;
            if (i >= vArr.length) {
                return null;
            }
            if (vArr[i] == v || vArr[i].equals(v)) {
                break;
            }
            i++;
        }
        return this.f19874a[i];
    }
}
