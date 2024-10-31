package com.nexstreaming.app.general.util;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: ImmutableBMap.java */
/* loaded from: classes.dex */
public class k<K, V> implements Map<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final K[] f3230a;
    private final V[] b;
    private List<K> c;
    private Set<K> d;
    private List<V> e;
    private Set<Map.Entry<K, V>> f;

    public k() {
        this.f3230a = (K[]) new Object[0];
        this.b = (V[]) new Object[0];
    }

    public k(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, Object... objArr) {
        int length = objArr.length / 2;
        this.f3230a = (K[]) new Object[length + 4];
        this.b = (V[]) new Object[length + 4];
        this.f3230a[0] = k;
        this.b[0] = v;
        this.f3230a[1] = k2;
        this.b[1] = v2;
        this.f3230a[2] = k3;
        this.b[2] = v3;
        this.f3230a[3] = k4;
        this.b[3] = v4;
        Class<?> cls = k.getClass();
        Class<?> cls2 = v.getClass();
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i * 2];
            Object obj2 = objArr[(i * 2) + 1];
            if (!cls.isInstance(obj)) {
                throw new ClassCastException("key of wrong class");
            }
            if (!cls2.isInstance(obj2)) {
                throw new ClassCastException("value of wrong class");
            }
            ((K[]) this.f3230a)[i + 4] = obj;
            ((V[]) this.b)[i + 4] = obj2;
        }
    }

    public List<K> a() {
        if (this.c == null) {
            this.c = Collections.unmodifiableList(Arrays.asList(this.f3230a));
        }
        return this.c;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        for (K k : this.f3230a) {
            if (k == obj || k.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        for (V v : this.b) {
            if (v == obj || v.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f == null) {
            HashSet hashSet = new HashSet();
            for (int i = 0; i < this.f3230a.length; i++) {
                hashSet.add(new AbstractMap.SimpleImmutableEntry(this.f3230a[i], this.b[i]));
            }
            this.f = Collections.unmodifiableSet(hashSet);
        }
        return this.f;
    }

    @Override // java.util.Map
    public V get(Object obj) {
        for (int i = 0; i < this.f3230a.length; i++) {
            if (this.f3230a[i] == obj || this.f3230a[i].equals(obj)) {
                return this.b[i];
            }
        }
        return null;
    }

    public K a(V v) {
        for (int i = 0; i < this.b.length; i++) {
            if (this.b[i] == v || this.b[i].equals(v)) {
                return this.f3230a[i];
            }
        }
        return null;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f3230a.length < 1;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        if (this.d == null) {
            this.d = Collections.unmodifiableSet(new HashSet(a()));
        }
        return this.d;
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
        return this.f3230a.length;
    }

    @Override // java.util.Map
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public List<V> values() {
        if (this.e == null) {
            this.e = Collections.unmodifiableList(Arrays.asList(this.b));
        }
        return this.e;
    }
}
