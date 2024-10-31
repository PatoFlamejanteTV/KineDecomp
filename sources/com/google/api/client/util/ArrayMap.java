package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes2.dex */
public class ArrayMap<K, V> extends AbstractMap<K, V> implements Cloneable {

    /* renamed from: a */
    int f14895a;

    /* renamed from: b */
    private Object[] f14896b;

    /* loaded from: classes2.dex */
    public final class a implements Map.Entry<K, V> {

        /* renamed from: a */
        private int f14897a;

        a(int i) {
            this.f14897a = i;
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

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ArrayMap.this.b(this.f14897a);
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return (V) ArrayMap.this.c(this.f14897a);
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object key = getKey();
            Object value = getValue();
            return (key != null ? key.hashCode() : 0) ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            return (V) ArrayMap.this.a(this.f14897a, v);
        }
    }

    /* loaded from: classes2.dex */
    final class b implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a */
        private boolean f14899a;

        /* renamed from: b */
        private int f14900b;

        b() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f14900b < ArrayMap.this.f14895a;
        }

        @Override // java.util.Iterator
        public void remove() {
            int i = this.f14900b - 1;
            if (!this.f14899a && i >= 0) {
                ArrayMap.this.d(i);
                this.f14900b--;
                this.f14899a = true;
                return;
            }
            throw new IllegalArgumentException();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            int i = this.f14900b;
            ArrayMap arrayMap = ArrayMap.this;
            if (i != arrayMap.f14895a) {
                this.f14900b = i + 1;
                this.f14899a = false;
                return new a(i);
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: classes2.dex */
    final class c extends AbstractSet<Map.Entry<K, V>> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new b();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ArrayMap.this.f14895a;
        }
    }

    public static <K, V> ArrayMap<K, V> a() {
        return new ArrayMap<>();
    }

    private V e(int i) {
        int i2 = this.f14895a << 1;
        if (i < 0 || i >= i2) {
            return null;
        }
        V g2 = g(i + 1);
        Object[] objArr = this.f14896b;
        int i3 = (i2 - i) - 2;
        if (i3 != 0) {
            System.arraycopy(objArr, i + 2, objArr, i, i3);
        }
        this.f14895a--;
        b(i2 - 2, null, null);
        return g2;
    }

    private void f(int i) {
        if (i == 0) {
            this.f14896b = null;
            return;
        }
        int i2 = this.f14895a;
        Object[] objArr = this.f14896b;
        if (i2 == 0 || i != objArr.length) {
            Object[] objArr2 = new Object[i];
            this.f14896b = objArr2;
            if (i2 != 0) {
                System.arraycopy(objArr, 0, objArr2, 0, i2 << 1);
            }
        }
    }

    private V g(int i) {
        if (i < 0) {
            return null;
        }
        return (V) this.f14896b[i];
    }

    public final K b(int i) {
        if (i < 0 || i >= this.f14895a) {
            return null;
        }
        return (K) this.f14896b[i << 1];
    }

    public final V c(int i) {
        if (i < 0 || i >= this.f14895a) {
            return null;
        }
        return g((i << 1) + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f14895a = 0;
        this.f14896b = null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return -2 != b(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        int i = this.f14895a << 1;
        Object[] objArr = this.f14896b;
        for (int i2 = 1; i2 < i; i2 += 2) {
            Object obj2 = objArr[i2];
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
            } else {
                if (obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final V d(int i) {
        return e(i << 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        return g(b(obj) + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        int a2 = a((ArrayMap<K, V>) k);
        if (a2 == -1) {
            a2 = this.f14895a;
        }
        return a(a2, k, v);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        return e(b(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f14895a;
    }

    public final V a(int i, K k, V v) {
        if (i >= 0) {
            int i2 = i + 1;
            a(i2);
            int i3 = i << 1;
            V g2 = g(i3 + 1);
            b(i3, k, v);
            if (i2 > this.f14895a) {
                this.f14895a = i2;
            }
            return g2;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.AbstractMap
    public ArrayMap<K, V> clone() {
        try {
            ArrayMap<K, V> arrayMap = (ArrayMap) super.clone();
            Object[] objArr = this.f14896b;
            if (objArr != null) {
                int length = objArr.length;
                Object[] objArr2 = new Object[length];
                arrayMap.f14896b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
            }
            return arrayMap;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    private void b(int i, K k, V v) {
        Object[] objArr = this.f14896b;
        objArr[i] = k;
        objArr[i + 1] = v;
    }

    private int b(Object obj) {
        int i = this.f14895a << 1;
        Object[] objArr = this.f14896b;
        for (int i2 = 0; i2 < i; i2 += 2) {
            Object obj2 = objArr[i2];
            if (obj == null) {
                if (obj2 == null) {
                    return i2;
                }
            } else {
                if (obj.equals(obj2)) {
                    return i2;
                }
            }
        }
        return -2;
    }

    public final V a(int i, V v) {
        int i2 = this.f14895a;
        if (i >= 0 && i < i2) {
            int i3 = (i << 1) + 1;
            V g2 = g(i3);
            this.f14896b[i3] = v;
            return g2;
        }
        throw new IndexOutOfBoundsException();
    }

    public final int a(K k) {
        return b(k) >> 1;
    }

    public final void a(int i) {
        if (i >= 0) {
            Object[] objArr = this.f14896b;
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
                f(i2);
                return;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
