package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public class ArrayMap<K, V> extends AbstractMap<K, V> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    int f2521a;
    private Object[] b;

    public static <K, V> ArrayMap<K, V> a() {
        return new ArrayMap<>();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f2521a;
    }

    public final K a(int i) {
        if (i < 0 || i >= this.f2521a) {
            return null;
        }
        return (K) this.b[i << 1];
    }

    public final V b(int i) {
        if (i < 0 || i >= this.f2521a) {
            return null;
        }
        return f((i << 1) + 1);
    }

    public final V a(int i, K k, V v) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i2 = i + 1;
        d(i2);
        int i3 = i << 1;
        V f = f(i3 + 1);
        b(i3, k, v);
        if (i2 > this.f2521a) {
            this.f2521a = i2;
        }
        return f;
    }

    public final V a(int i, V v) {
        int i2 = this.f2521a;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = (i << 1) + 1;
        V f = f(i3);
        this.b[i3] = v;
        return f;
    }

    public final V c(int i) {
        return g(i << 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return -2 != b(obj);
    }

    public final int a(K k) {
        return b(k) >> 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        return f(b(obj) + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        int a2 = a((ArrayMap<K, V>) k);
        if (a2 == -1) {
            a2 = this.f2521a;
        }
        return a(a2, k, v);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        return g(b(obj));
    }

    public final void d(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] objArr = this.b;
        int i2 = i << 1;
        int length = objArr == null ? 0 : objArr.length;
        if (i2 > length) {
            int i3 = ((length / 2) * 3) + 1;
            if (i3 % 2 != 0) {
                i3++;
            }
            if (i3 >= i2) {
                i2 = i3;
            }
            e(i2);
        }
    }

    private void e(int i) {
        if (i == 0) {
            this.b = null;
            return;
        }
        int i2 = this.f2521a;
        Object[] objArr = this.b;
        if (i2 == 0 || i != objArr.length) {
            Object[] objArr2 = new Object[i];
            this.b = objArr2;
            if (i2 != 0) {
                System.arraycopy(objArr, 0, objArr2, 0, i2 << 1);
            }
        }
    }

    private void b(int i, K k, V v) {
        Object[] objArr = this.b;
        objArr[i] = k;
        objArr[i + 1] = v;
    }

    private V f(int i) {
        if (i < 0) {
            return null;
        }
        return (V) this.b[i];
    }

    private int b(Object obj) {
        int i = this.f2521a << 1;
        Object[] objArr = this.b;
        for (int i2 = 0; i2 < i; i2 += 2) {
            Object obj2 = objArr[i2];
            if (obj == null) {
                if (obj2 == null) {
                    return i2;
                }
            } else if (obj.equals(obj2)) {
                return i2;
            }
        }
        return -2;
    }

    private V g(int i) {
        int i2 = this.f2521a << 1;
        if (i < 0 || i >= i2) {
            return null;
        }
        V f = f(i + 1);
        Object[] objArr = this.b;
        int i3 = (i2 - i) - 2;
        if (i3 != 0) {
            System.arraycopy(objArr, i + 2, objArr, i, i3);
        }
        this.f2521a--;
        b(i2 - 2, null, null);
        return f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f2521a = 0;
        this.b = null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        int i = this.f2521a << 1;
        Object[] objArr = this.b;
        for (int i2 = 1; i2 < i; i2 += 2) {
            Object obj2 = objArr[i2];
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
            } else if (obj.equals(obj2)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return new c();
    }

    @Override // java.util.AbstractMap
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ArrayMap<K, V> clone() {
        try {
            ArrayMap<K, V> arrayMap = (ArrayMap) super.clone();
            Object[] objArr = this.b;
            if (objArr != null) {
                int length = objArr.length;
                Object[] objArr2 = new Object[length];
                arrayMap.b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                return arrayMap;
            }
            return arrayMap;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    final class c extends AbstractSet<Map.Entry<K, V>> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new b();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ArrayMap.this.f2521a;
        }
    }

    /* loaded from: classes.dex */
    final class b implements Iterator<Map.Entry<K, V>> {
        private boolean b;
        private int c;

        b() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c < ArrayMap.this.f2521a;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            int i = this.c;
            if (i == ArrayMap.this.f2521a) {
                throw new NoSuchElementException();
            }
            this.c++;
            return new a(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            int i = this.c - 1;
            if (this.b || i < 0) {
                throw new IllegalArgumentException();
            }
            ArrayMap.this.c(i);
            this.b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class a implements Map.Entry<K, V> {
        private int b;

        a(int i) {
            this.b = i;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ArrayMap.this.a(this.b);
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return (V) ArrayMap.this.b(this.b);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            return (V) ArrayMap.this.a(this.b, v);
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return getKey().hashCode() ^ getValue().hashCode();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return Objects.a(getKey(), entry.getKey()) && Objects.a(getValue(), entry.getValue());
        }
    }
}
